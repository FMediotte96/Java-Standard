package test;

import domain.Persona;
import interfaces.Saludo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
	
	public static void main(String[] args) {
		
		//Redefinición de métodos de objetos del jdk
		/*ArrayList<String> permisos = new ArrayList<String>() { 
			public boolean contains(Object o) {
				return true;
			}
		};
		
		System.out.println(permisos.contains("algo"));
		*/
		
		//Uso de lambdas
		Saludo reverseStr = (str) -> {
			String result = "";
			
			for(int i = str.length()-1; i>= 0; i--) {
				result += str.charAt(i);
			}
			
			return result;
		};
		
		System.out.println(reverseStr.saluda("Hola Mundo"));
		
		ArrayList<Persona> lista = new ArrayList<Persona>();
		
		lista.add(new Persona(1,"A"));
		lista.add(new Persona(2,"Z"));
		lista.add(new Persona(5,"G"));
		lista.add(new Persona(3,"F"));
		
		Comparator<Persona> porNombre = (Persona p, Persona p1) -> p.getFullname().compareTo(p1.getFullname());
		Collections.sort(lista, porNombre);
		
		for(Persona p : lista) {
			System.out.println(p);
		}

		//Sobrescribir metodos 
		Collections.sort(lista, new Comparator<Persona>() {

			@Override
			public int compare(Persona o1, Persona o2) {
				return o1.getFullname().compareTo(o2.getFullname());
			}
		});
		
		for(Persona p : lista) {
			System.out.println(p);
		}
		
		Saludo saludo1 = (str) -> "Buen dia " + str + "!";
		System.out.println(saludo1.saluda("Luis"));
		
		Saludo saludo2 = (str) -> "Buenas tardes " + str + "!";
		System.out.println(saludo2.saluda("Pepe"));

	}

}
