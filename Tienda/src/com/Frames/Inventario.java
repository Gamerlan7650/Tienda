package com.Frames;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.clases.*;

public class Inventario extends JFrame {
    ProductoDAO productoDAO = new ProductoDAO();
    Producto p;
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField tID;
    private JTextField tNombre;
    private JTextField tDescripcion;
    private JTextField tPrecio;
    private JTextField tStock;
    private JTextArea tpInventario;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Inventario frame = new Inventario();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Inventario() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 531, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        tID = new JTextField();
        tID.setBounds(138, 50, 145, 20);
        contentPane.add(tID);
        tID.setColumns(10);

        tNombre = new JTextField();
        tNombre.setBounds(138, 77, 145, 20);
        contentPane.add(tNombre);
        tNombre.setColumns(10);

        tDescripcion = new JTextField();
        tDescripcion.setBounds(138, 108, 145, 20);
        contentPane.add(tDescripcion);
        tDescripcion.setColumns(10);

        tPrecio = new JTextField();
        tPrecio.setBounds(138, 139, 145, 20);
        contentPane.add(tPrecio);
        tPrecio.setColumns(10);

        tStock = new JTextField();
        tStock.setBounds(138, 170, 145, 20);
        contentPane.add(tStock);
        tStock.setColumns(10);

        JLabel lblNewLabel = new JLabel("ID_producto:");
        lblNewLabel.setBounds(29, 53, 86, 14);
        contentPane.add(lblNewLabel);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(29, 80, 86, 14);
        contentPane.add(lblNombre);

        JLabel lblNewLabel_1_1 = new JLabel("Descripcion:");
        lblNewLabel_1_1.setBounds(29, 111, 86, 14);
        contentPane.add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_2 = new JLabel("Precio:");
        lblNewLabel_1_2.setBounds(29, 142, 86, 14);
        contentPane.add(lblNewLabel_1_2);

        JLabel lblNewLabel_1_3 = new JLabel("Stock:");
        lblNewLabel_1_3.setBounds(29, 173, 86, 14);
        contentPane.add(lblNewLabel_1_3);

        JLabel lblNewLabel_1 = new JLabel("INVENTARIO");
        lblNewLabel_1.setBounds(170, 11, 97, 14);
        contentPane.add(lblNewLabel_1);

        JButton bBuscarID = new JButton("Buscar por ID");
        bBuscarID.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String idS = tID.getText();
                int id = Integer.parseInt(idS);
                Producto producto = productoDAO.consultar(id);
                if (producto != null) {
                    tID.setText(String.valueOf(producto.getId_producto()));
                    tNombre.setText(producto.getNombre());
                    tDescripcion.setText(producto.getDescripcion());
                    tPrecio.setText(String.valueOf(producto.getPrecio()));
                    tStock.setText(String.valueOf(producto.getStock()));
                }
            }
        });
        bBuscarID.setBounds(294, 49, 97, 23);
        contentPane.add(bBuscarID);

        JButton bElmId = new JButton("Eliminar por ID");
        bElmId.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String idS = tID.getText();
                int id = Integer.parseInt(idS);
                productoDAO.eliminar(id);
                tID.setText("");
                tNombre.setText("");
                tDescripcion.setText("");
                tPrecio.setText("");
                tStock.setText("");
            }
        });
        bElmId.setBounds(401, 49, 104, 23);
        contentPane.add(bElmId);

        JButton bImpInv = new JButton("Imprimir inventario");
        bImpInv.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tID.setText("");
                tNombre.setText("");
                tDescripcion.setText("");
                tPrecio.setText("");
                tStock.setText("");
                tpInventario.setText(productoDAO.Ilista());
            }
        });
        bImpInv.setBounds(324, 76, 150, 23);
        contentPane.add(bImpInv);

        JButton bAdd = new JButton("Agregar producto a inventario");
        bAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                p = new Producto();
                // id producto
                String ids = tID.getText();
                int id = Integer.parseInt(ids);
                p.setId_producto(id);
                // Nombre del producto
                String nm = tNombre.getText();
                p.setNombre(nm);
                // Descripcion del producto
                String dc = tDescripcion.getText();
                p.setDescripcion(dc);
                // Precio del producto
                String prs = tPrecio.getText();
                double pr = Double.parseDouble(prs);
                p.setPrecio(pr);
                // Cantidad del producto para inventario (STOCK)
                String stockS = tStock.getText();
                int stock = Integer.parseInt(stockS);
                p.setStock(stock);
                // Tienda_ID_tienda (set a default value for simplicity)
                p.setTienda_ID_tienda(1); // Assuming a default value for now
                // Categoria_ID_categoria (set a default value for simplicity)
                p.setCategoria_ID_categoria(1); // Assuming a default value for now
                productoDAO.agregar(p);
                tID.setText("");
                tNombre.setText("");
                tDescripcion.setText("");
                tPrecio.setText("");
                tStock.setText("");
            }
        });
        bAdd.setBounds(71, 213, 184, 23);
        contentPane.add(bAdd);

        tpInventario = new JTextArea();
        tpInventario.setBounds(309, 106, 184, 117);
        contentPane.add(tpInventario);
    }
}
