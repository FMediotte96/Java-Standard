package com.java.standard.entities;

public class Empleado extends Persona {
	private int legajo;
	private float sBasico;
	
	@Override
	public void saludar() {
		System.out.println("Hola soy un Empleado!");
	}
	
	public Empleado(int legajo, float sBasico, String nombre, String apellido, int edad, Direccion direccion) {
		super(nombre, apellido, edad, direccion);
		this.legajo = legajo;
		this.sBasico = sBasico;
	}
	
	@Override
	public String toString() {
		return legajo + " " + sBasico + " " + super.toString();
	}

	public int getLegajo() {
		return legajo;
	}

	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}

	public float getsBasico() {
		return sBasico;
	}

	public void setsBasico(float sBasico) {
		this.sBasico = sBasico;
	}
	
}
