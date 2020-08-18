package com.facu.clase06.exceptions;

public class NoHayPasajesException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private String vuelo;
	private int cantidad;
	
	public NoHayPasajesException() {
		
	}
	
	public NoHayPasajesException(String vuelo, int cantidad) {
		this.vuelo = vuelo;
		this.cantidad = cantidad;
	}
	
	@Override
	public String toString() {
		return "El vuelo " + vuelo + ", no tiene " + cantidad + " pasajes.";
	}

	public String getVuelo() {
		return vuelo;
	}

	public void setVuelo(String vuelo) {
		this.vuelo = vuelo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
}
