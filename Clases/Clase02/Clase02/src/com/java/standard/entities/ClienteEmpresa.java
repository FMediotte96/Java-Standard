package com.java.standard.entities;

public class ClienteEmpresa {

	private int nro;
	private String razonSocial;
	private String direccion;
	private Cuenta[] cuentas;
	
	public ClienteEmpresa(int nro, String razonSocial, String direccion) {
		this.nro = nro;
		this.razonSocial = razonSocial;
		this.direccion = direccion;
		this.cuentas = new Cuenta[3];
	}
	
	@Override
	public String toString() {
		return "ClienteEmpresa{" + "nro=" + nro + ", razonSocial=" + razonSocial + 
				", direccion=" + direccion + "}";
	}

	public int getNro() {
		return nro;
	}

	public void setNro(int nro) {
		this.nro = nro;
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

	public Cuenta[] getCuentas() {
		return cuentas;
	}

	public void setCuentas(Cuenta[] cuentas) {
		this.cuentas = cuentas;
	}
	
}
