package com.clases;
public class Usuario {
	private int id_usuario;
	private String Nombre;
	private String Apellido;
	private String correo;
	private long nit;
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public long getNit() {
		return nit;
	}
	public void setNit(long nit) {
		this.nit = nit;
	}
}
