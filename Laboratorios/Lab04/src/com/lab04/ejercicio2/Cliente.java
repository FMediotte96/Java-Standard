package com.lab04.ejercicio2;

public class Cliente {
	
	private String razonSocial;
	private String direccion;
	
	public Cliente(String razonSocial, String direccion) {
		this.razonSocial = razonSocial;
		this.direccion = direccion;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	@Override
	public String toString() {
		return "Razon Social: " + razonSocial + ", Dirección: " + direccion;
	}

}
