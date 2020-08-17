package com.lab04.ejercicio1;

import java.util.ArrayList;

public class Empleado {

	private String nombre;
	private String dni;
	private int edad;
	
	public Empleado(String nombre, String dni, int edad) {
		this.nombre = nombre;
		this.dni = dni;
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	@Override
	public String toString() {
		return "Nombre: " + nombre + ", DNI: " + dni + ", Edad: " + edad;
	}
	
	public static void informarDatosDeEmpleados(ArrayList<Empleado> losEmpleados) {
		losEmpleados.forEach(System.out::println);
	}
	
}
