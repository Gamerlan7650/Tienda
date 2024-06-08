package com.clases;

public class Producto {
    private int id_producto;
    private String nombre;
    private String descripcion;
    private double precio;
    private int stock;
    private int tienda_ID_tienda;
    private int categoria_ID_categoria;

    // Getters y Setters
    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getTienda_ID_tienda() {
        return tienda_ID_tienda;
    }

    public void setTienda_ID_tienda(int tienda_ID_tienda) {
        this.tienda_ID_tienda = tienda_ID_tienda;
    }

    public int getCategoria_ID_categoria() {
        return categoria_ID_categoria;
    }

    public void setCategoria_ID_categoria(int categoria_ID_categoria) {
        this.categoria_ID_categoria = categoria_ID_categoria;
    }
}

