package com.Frames;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.clases.ConexionBD;

import com.clases.Producto;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Carrito extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtCodigoProducto;
    private double precioTotal = 0.0;
    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultSet;
    private ProductoDAO productoDAO;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Carrito frame = new Carrito();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Carrito() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 575, 370);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblCarritoDeCompras = new JLabel("Carrito de compras");
        lblCarritoDeCompras.setBounds(54, 75, 132, 14);
        contentPane.add(lblCarritoDeCompras);

        JButton btnAgregarAlCarrito = new JButton("Agregar al carrito");
        btnAgregarAlCarrito.setBounds(54, 119, 132, 23);
        contentPane.add(btnAgregarAlCarrito);

        JButton btnComprar = new JButton("Comprar");
        btnComprar.setBounds(54, 164, 132, 23);
        contentPane.add(btnComprar);

        JLabel lblCodigoProducto = new JLabel("Código del producto:");
        lblCodigoProducto.setBounds(240, 100, 150, 14);
        contentPane.add(lblCodigoProducto);

        txtCodigoProducto = new JTextField();
        txtCodigoProducto.setBounds(240, 120, 150, 20);
        contentPane.add(txtCodigoProducto);
        txtCodigoProducto.setColumns(10);

        JLabel lblPrecioTotal = new JLabel("Precio Total: $0.0");
        lblPrecioTotal.setBounds(240, 200, 150, 14);
        contentPane.add(lblPrecioTotal);

        conectarBaseDatos();

        btnAgregarAlCarrito.addActionListener(e -> {
            String codigoProducto = txtCodigoProducto.getText();
            if (!codigoProducto.isEmpty()) {
                Producto producto = obtenerProductoPorCodigo(codigoProducto);
                if (producto != null) {
                    precioTotal += producto.getPrecio();
                    lblPrecioTotal.setText("Precio Total: $" + precioTotal);
                    JOptionPane.showMessageDialog(this, "Producto agregado al carrito:\n" +
                            "Nombre: " + producto.getNombre() + "\n" +
                            "Precio: $" + producto.getPrecio());
                } else {
                    JOptionPane.showMessageDialog(this, "No se encontró ningún producto con el código proporcionado.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Ingrese un código de producto válido.");
            }
        });

        btnComprar.addActionListener(e -> {
            int cantidadComprada = 1;
            String codigoProducto = txtCodigoProducto.getText();
            actualizarStock(codigoProducto, cantidadComprada);
            JOptionPane.showMessageDialog(this, "Compra realizada por un total de $" + precioTotal);
            precioTotal = 0.0;
            lblPrecioTotal.setText("Precio Total: $0.0");
        });

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                cerrarConexion();
            }
        });
    }

    private void conectarBaseDatos() {
        try {
            connection = ConexionBD.getConnection();
            productoDAO = new ProductoDAO();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al conectar a la base de datos.");
        }
    }

    private void cerrarConexion() {
        try {
            if (resultSet != null) resultSet.close();
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Producto obtenerProductoPorCodigo(String codigo) {
        Producto producto = null;
        try {
            int codigoProducto = Integer.parseInt(codigo);
            producto = productoDAO.consultar(codigoProducto);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El código de producto debe ser un número entero.");
        }
        return producto;
    }

    private void actualizarStock(String codigoProducto, int cantidadComprada) {
        try {
            int codigo = Integer.parseInt(codigoProducto);
            productoDAO.actualizarStock(codigo, cantidadComprada);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El código de producto debe ser un número entero.");
        }
    }
}
