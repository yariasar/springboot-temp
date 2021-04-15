package com.experis.springboot.app.clientes.models.request;

import java.util.Date;

public class ClienteRequest {
	private String nombre;
	private String apellido;
	private Integer edad;
	private Date fechaNacimiento;
	private String fechaProbabilidadMuerte;
	
	public ClienteRequest(String nombre, String apellido,
				Integer edad, Date fechaNacimiento, String fechaProbabilidadMuerte) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaProbabilidadMuerte = fechaProbabilidadMuerte;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getFechaProbabilidadMuerte() {
		return fechaProbabilidadMuerte;
	}
	public void setFechaProbabilidadMuerte(String fechaProbabilidadMuerte) {
		this.fechaProbabilidadMuerte = fechaProbabilidadMuerte;
	}
}
