package com.educacionit.com.jse.poo;

public class Main {

	public static void main(String[] args) {
		Domicilio domicilio = new Domicilio();
		domicilio.setCalle("Lavalle");
		domicilio.setLocalidad("CABA");
		domicilio.setNumero(648);
		
		Persona persona = new Persona();
		persona.setApellido("Perez");
		persona.setNombre("Pepe");
		persona.setEdad(43);
		persona.setDomicilio(domicilio);
		
		System.out.print("La persona: "+ persona.getApellido() + ", " +persona.getNombre());
		System.out.print(" vive en: "+ persona.getDomicilio().getCalle() + " ");
		System.out.print(persona.getDomicilio().getNumero());
	}

}
