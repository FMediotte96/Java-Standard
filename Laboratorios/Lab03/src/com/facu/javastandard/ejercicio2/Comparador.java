package com.facu.javastandard.ejercicio2;

public class Comparador {

	public static void main(String[] args) {
///////////////////////////////////////////////////////////////////////////////////////////////
// Para ver el comportamiento de comparacion debe haber un único Caso de Prueba descomentado //
///////////////////////////////////////////////////////////////////////////////////////////////
		
		//Caso de prueba 1 --> Comparación de Strings
//		String c1 = new String("Pedro");
//		String c2 = new String("Pedro");
		
		//Caso de prueba 2 --> Comparación de Integers
//		Integer c1 = new Integer("25");
//		Integer c2 = new Integer("25");
		
		//Caso de prueba 3 --> Comparación de Clases definidas por el usuario
//		Cliente c1 = new Cliente("Pedro", "20.333.333");
//		Cliente c2 = new Cliente("Pedro", "20.333.333");
		
		//Caso de prueba 4 --> Dos punteros apuntando a un mismo objeto
		Cliente c1 = new Cliente("Pedro", "20.333.333");
		Cliente c2 = c1;
		
		//Comparación con operador ==
		if(c1 == c2) {
			System.out.println("\t==es true!");
		}
		
		//Comparación con metodo equals()
		if(c1.equals(c2)) {
			System.out.println("\t.equals() es true!");
		}
		
	}
}
