package com.clases;
import java.util.Date;
public class Compra {
	private int Id_compra;
	private int Cantidad;
	private double Monto;
	private Date Fecha;
	public int getId_compra() {
		return Id_compra;
	}
	public void setId_compra(int id_compra) {
		Id_compra = id_compra;
	}
	public int getCantidad() {
		return Cantidad;
	}
	public void setCantidad(int cantidad) {
		Cantidad = cantidad;
	}
	public double getMonto() {
		return Monto;
	}
	public void setMonto(double monto) {
		Monto = monto;
	}
	public Date getFecha() {
		return Fecha;
	}
	public void setFecha(Date fecha) {
		Fecha = fecha;
	}
}
