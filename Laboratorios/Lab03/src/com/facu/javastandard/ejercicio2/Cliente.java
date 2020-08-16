package com.facu.javastandard.ejercicio2;

public class Cliente {
	
	private String nombre;
	private String dni;

	public Cliente() {
	}
	
	public Cliente(String nombre, String dni) {
		this.nombre = nombre;
		this.dni = dni;
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
	
	public boolean equals(Object obj) {
		Cliente c = (Cliente) obj;
		
		if(c.getDni().equals(this.getDni())) {
			return true;
		}
		
		return false;
	}

}
