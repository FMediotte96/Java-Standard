package com.facu.clase06.exceptions;

public class TestException {
	
	public static void generarException() {
		//un miembro static quiere decir que pertenece a una clase.
		//No tengo que generar un Objeto de la clase para utilizar este atributo
		//o método. No esta bueno realizar todo static
		int[] vector = new int[4];
		vector[10] = 20;
	}
	
	/*
	 	Sobrecarga de métodos: mismo nombre distintos parametros y comportamientos.
	 */
	
	public static void generarException(boolean x) {
		if(x){
			System.out.println(10/0);
		}
	}
	
	public static void generarException(String texto) {
		System.out.println(texto.length());
	}

}
