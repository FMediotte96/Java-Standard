package com.java.standard.entities;

public class ClienteMinorista {

	private int nro;
	private String nombre;
	private String direccion;
	private Cuenta cuenta;
	
	public ClienteMinorista(int nro, String nombre, String direccion, int nroCuenta) {
		this.nro = nro;
		this.nombre = nombre;
		this.direccion = direccion;
		this.cuenta = new Cuenta(nroCuenta,"arg$");
	}
	
	@Override
	public String toString() {
		return "ClienteMinorista{" + "nro=" + nro + ", nombre=" + nombre + ", direccion=" +
				direccion + ", cuenta=" + cuenta + "}";
	}

	public int getNro() {
		return nro;
	}

	public void setNro(int nro) {
		this.nro = nro;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	
}
