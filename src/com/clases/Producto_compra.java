package com.clases;

public class Producto_compra {
	private int Id_pc;
	private int cantidad;
	private double precio;
	public int getId_pc() {
		return Id_pc;
	}
	public void setId_pc(int id_pc) {
		Id_pc = id_pc;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
}
