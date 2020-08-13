package com.java.standard.entities;

public abstract class Persona {
	protected String nombre;
	protected String apellido;
	protected int edad;
	protected Direccion direccion;
	
	public void saludar() {
		System.out.println("Hola soy una persona.");
	}

	public Persona(String nombre, String apellido, int edad, Direccion direccion) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.direccion = direccion;
	}
	
	@Override
	public String toString() {
		return nombre + " " + apellido + " " + edad + " " + direccion;
	}

}
