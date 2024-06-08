package com.clases;

public class Tienda {
	private int Id_tienda;
	private String lugar;
	private double tamaño;
	public int getId_tienda() {
		return Id_tienda;
	}
	public void setId_tienda(int id_tienda) {
		Id_tienda = id_tienda;
	}
	public String getLugar() {
		return lugar;
	}
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	public double getTamaño() {
		return tamaño;
	}
	public void setTamaño(double tamaño) {
		this.tamaño = tamaño;
	}
}
