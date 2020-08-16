package com.facu.javastandard.domain;

public class Zoologico {
	
	public static final int CANTIDAD_ANIMALES = 25;
	public static final int RACIONES_POR_ANIMAL = 5;
	private boolean abierto;
	
	public Zoologico() {
	}

	public void abrir() {
		abierto = true;
	}

	public void alimentarAnimales(int unaCantidadDeRaciones) {
		Cuidador cuidador = new Cuidador(unaCantidadDeRaciones);
		cuidador.alimentarAnimales();
	}
	
	public void cerrar() {
		abierto = false;
	}

	public boolean isAbierto() {
		return abierto;
	}

 }
