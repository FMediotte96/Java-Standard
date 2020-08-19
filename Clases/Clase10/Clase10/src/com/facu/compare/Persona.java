package com.facu.compare;

import java.util.Date;

public class Persona implements Comparable<Persona> {
	
	private int id;
	private String nombre;
	private Date fechaNacimiento;
	
	public Persona() {

	}

	public Persona(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@Override
	public int compareTo(Persona o) {
		return this.nombre.compareTo(o.nombre);
	}
	
	@Override
	public String toString() {
		return String.format("Persona{id:%1s, nombre:%2s}", id, nombre);
	}

}
