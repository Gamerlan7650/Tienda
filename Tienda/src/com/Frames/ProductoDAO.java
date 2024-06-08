package com.Frames;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.clases.ConexionBD;
import com.clases.Producto;

public class ProductoDAO {
    private Connection connection;

    public ProductoDAO() {
        connection = ConexionBD.getConnection();
    }

    public void agregar(Producto producto) {
        String query = "INSERT INTO Producto (ID_producto, Nombre, Descripcion, Precio, Stock, Tienda_ID_tienda, Categoria_ID_categoria) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, producto.getId_producto());
            statement.setString(2, producto.getNombre());
            statement.setString(3, producto.getDescripcion());
            statement.setDouble(4, producto.getPrecio());
            statement.setInt(5, producto.getStock());
            statement.setInt(6, producto.getTienda_ID_tienda());
            statement.setInt(7, producto.getCategoria_ID_categoria());
            statement.executeUpdate();
            System.out.println("Producto agregado correctamente a la base de datos");
        } catch (SQLException e) {
            System.out.println("Error al agregar el producto: " + e.getMessage());
        }
    }

    public Producto consultar(int id) {
        String query = "SELECT * FROM Producto WHERE ID_producto = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Producto producto = new Producto();
                producto.setId_producto(resultSet.getInt("ID_producto"));
                producto.setNombre(resultSet.getString("Nombre"));
                producto.setDescripcion(resultSet.getString("Descripcion"));
                producto.setPrecio(resultSet.getDouble("Precio"));
                producto.setStock(resultSet.getInt("Stock"));
                producto.setTienda_ID_tienda(resultSet.getInt("Tienda_ID_tienda"));
                producto.setCategoria_ID_categoria(resultSet.getInt("Categoria_ID_categoria"));
                return producto;
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar el producto: " + e.getMessage());
        }
        return null;
    }

    public void eliminar(int id) {
        String query = "DELETE FROM Producto WHERE ID_producto = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Producto eliminado correctamente de la base de datos");
        } catch (SQLException e) {
            System.out.println("Error al eliminar el producto: " + e.getMessage());
        }
    }
    public String Ilista() {
        String resultado = "";
        String query = "SELECT * FROM Producto";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("ID_producto");
                String nombre = resultSet.getString("Nombre");
                double precio = resultSet.getDouble("Precio");
                int stock = resultSet.getInt("Stock");
                resultado += "ID: " + id + ", Nombre: " + nombre + ", Precio: " + precio + ", Stock: " + stock + "\n";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public void close() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Conexión cerrada");
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
    public void actualizarStock(int id, int cantidadComprada) {
        String query = "UPDATE Producto SET Stock = Stock - ? WHERE ID_producto = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, cantidadComprada);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al actualizar el stock en la base de datos: " + ex.getMessage());
        }
    } }
