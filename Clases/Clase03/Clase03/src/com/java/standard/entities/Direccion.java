package com.java.standard.entities;

public class Direccion {
	
	private String calle;
	private int nro;
	private int piso;
	private String depto;
	private String ciudad;
	
	/**
	 * Constructor CABA
	 * @param calle
	 * @param nro
	 * @param piso
	 * @param depto
	 */
	public Direccion(String calle, int nro, int piso, String depto) {
		this.calle = calle;
		this.nro = nro;
		this.piso = piso;
		this.depto = depto;
		this.ciudad = "CABA";
	}

	/**
	 * Constructor GBA
	 * @param calle
	 * @param nro
	 * @param piso
	 * @param depto
	 * @param ciudad
	 */
	public Direccion(String calle, int nro, int piso, String depto, String ciudad) {
		super();
		this.calle = calle;
		this.nro = nro;
		this.piso = piso;
		this.depto = depto;
		this.ciudad = ciudad;
	}
	
	@Override
	public String toString() {
		return calle + " " + nro + " " + piso + " " + depto + " " + ciudad;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getNro() {
		return nro;
	}

	public void setNro(int nro) {
		this.nro = nro;
	}

	public int getPiso() {
		return piso;
	}

	public void setPiso(int piso) {
		this.piso = piso;
	}

	public String getDepto() {
		return depto;
	}

	public void setDepto(String depto) {
		this.depto = depto;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
}
