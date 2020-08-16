package com.facu.javastandard.domain;

import java.util.Date;
/**
 * Abstract class Persona
 * @author fmediotte
 *
 */
public abstract class Persona {
	
	private String nombre;
	private Date fechaDeNacimiento;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}
	public void setFechaDeNacimiento(Date fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}
	
}
