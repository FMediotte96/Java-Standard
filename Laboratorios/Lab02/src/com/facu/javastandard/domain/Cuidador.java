package com.facu.javastandard.domain;

public class Cuidador extends Persona {
	
	private int cantidadDeRaciones;

	public Cuidador(int cantidadDeRaciones) {
		this.cantidadDeRaciones = cantidadDeRaciones;
	}
	
	public void alimentarAnimales() {
		int cantNecesaria = Zoologico.CANTIDAD_ANIMALES * Zoologico.RACIONES_POR_ANIMAL;
		int sobrante = this.cantidadDeRaciones - cantNecesaria;
		
		String mensaje = "";
		
		if(sobrante == 0) {
			mensaje = "La comida alcanzo justo. No sobro nada.";
		}
		
		if(sobrante > 0) {
			mensaje = "La comida alcanzo y sobro.";
		}
		
		if(sobrante < 0) {
			mensaje = "La comida no alcanzo.";
		}
		
		System.out.println(mensaje);
	}

}
