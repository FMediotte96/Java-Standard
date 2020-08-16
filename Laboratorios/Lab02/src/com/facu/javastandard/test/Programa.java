package com.facu.javastandard.test;

import com.facu.javastandard.domain.Zoologico;

public class Programa {

	public static void main(String[] args) {
		
		Zoologico zoo = new Zoologico();
		
		if(!zoo.isAbierto()) {
			zoo.abrir();
		}
		zoo.alimentarAnimales(130);
		zoo.cerrar();
	}
}
