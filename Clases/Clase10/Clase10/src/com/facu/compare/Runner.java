package com.facu.compare;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Runner {
	
	public static void main(String[] args) {
		comparableRunner();
		comparatorRunner();
	}
	
	public static void comparableRunner() {
		Set<Persona> personas = new TreeSet<Persona>();
		personas.add(new Persona(1, "Facundo"));
		personas.add(new Persona(2, "Hernando"));
		personas.add(new Persona(3, "Matias"));
		personas.add(new Persona(4, "Gaston"));
        System.out.println("Conjunto ordenado de personas: " + personas);
	}
	
	public static void comparatorRunner() {
		List<Persona> personas = Arrays.asList(
				new Persona(2,"Fernando"),
				new Persona(1,"Mario"),
				new Persona(3,"Omar"));
		Collections.sort(personas, new OrdenarPersonasPorId());
		System.out.println("Lista de personas ordenadas por ID: " + personas);
	}

}
