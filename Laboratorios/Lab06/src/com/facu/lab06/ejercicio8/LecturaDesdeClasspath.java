package com.facu.lab06.ejercicio8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LecturaDesdeClasspath {
	
	public static void main(String[] args) throws IOException {
		
		//Determina la uicación del archivo a leer
		String archivoALeer = "/com/facu/lab06/recursos/noticias.txt";
		
		//Obtiene un stream al archivo a leer
		InputStreamReader isr = new InputStreamReader(LecturaDesdeClasspath.class.getResourceAsStream(archivoALeer));
	
		//Construye un BufferedReader
		BufferedReader readerMejorado = new BufferedReader(isr);
		
		//Variables
		String unaLinea;
		//Leemos el archivo linea a linea y mostramos por pantalla
		while((unaLinea = readerMejorado.readLine()) != null) {
			System.out.println(unaLinea);
		}
		
		//Cierro el FileReader
		readerMejorado.close();
	}

}
