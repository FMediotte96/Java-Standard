package com.java.standard.entities;

public class Cuenta {
	
	private int nro;
	private String moneda;
	private float saldo;
	
	public Cuenta(int nro, String moneda) {
		this.nro = nro;
		this.moneda = moneda;
		this.saldo = 0;
	}
	
	public Cuenta() {
	}
	
	public void depositar(float monto) {
		saldo += monto;
	}
	
	public void debitar(float monto) {
		if(saldo >= monto) {
			saldo-=monto;
		} else {
			System.out.println("Saldo Insuficiente.");
		}
	}

	public int getNro() {
		return nro;
	}

	public void setNro(int nro) {
		this.nro = nro;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	@Override
	public String toString() {
		return nro + " " + moneda + " " + saldo;
	}
	
}
