package com.Frames;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Usuario extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldNombre;
    private JPasswordField passwordField;

    // Datos de conexión a la base de datos
    private static final String URL = "jdbc:postgresql://localhost:5432/tienda";
    private static final String USER = "postgres";
    private static final String PASSWORD = "admin";

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Usuario frame = new Usuario();
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
    public Usuario() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        textFieldNombre = new JTextField();
        textFieldNombre.setBounds(53, 60, 154, 20);
        contentPane.add(textFieldNombre);
        textFieldNombre.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setBounds(53, 102, 154, 20);
        contentPane.add(passwordField);

        JButton btnIngresar = new JButton("Ingresar");
        btnIngresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardarDatosUsuario();
            }
        });
        btnIngresar.setBounds(53, 133, 89, 23);
        contentPane.add(btnIngresar);

        JLabel lblDatosUsuario = new JLabel("Datos de Usuario");
        lblDatosUsuario.setBounds(53, 15, 131, 14);
        contentPane.add(lblDatosUsuario);

        JLabel lblNombre = new JLabel("Nombre");
        lblNombre.setBounds(53, 40, 131, 14);
        contentPane.add(lblNombre);

        JLabel lblContraseña = new JLabel("Contraseña");
        lblContraseña.setBounds(53, 87, 131, 14);
        contentPane.add(lblContraseña);
    }

    private void guardarDatosUsuario() {
        String nombre = textFieldNombre.getText();
        String contraseña = new String(passwordField.getPassword());

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "INSERT INTO Usuario (Nombre, Contraseña) VALUES (?, ?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, nombre);
            statement.setString(2, contraseña);
            statement.executeUpdate();

            System.out.println("Datos del usuario guardados exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

