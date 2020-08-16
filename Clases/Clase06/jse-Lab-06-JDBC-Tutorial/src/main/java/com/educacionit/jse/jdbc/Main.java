package com.educacionit.jse.jdbc;

public class Main {

	public static void main(String[] args) {

		Persona pepe = new Persona("Pepe", "Sanchez", 43);
		Persona fulano = new Persona("Juan", "Gomez", 53);
		try {
			PersonaDAO.inserta(pepe);
			PersonaDAO.inserta(fulano);
			Persona personita = PersonaDAO.getPersona(1);
			personita.setNombre("Maxi");
			PersonaDAO.modifica(personita);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
