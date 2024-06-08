package com.clases;

public class Empleado {
	private int Id_empleado;
	private String nombre;
	private String cargo;
	private String Correo;
	public int getId_empleado() {
		return Id_empleado;
	}
	public void setId_empleado(int id_empleado) {
		Id_empleado = id_empleado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getCorreo() {
		return Correo;
	}
	public void setCorreo(String correo) {
		Correo = correo;
	}
}
