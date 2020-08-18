package com.facu.lab06.ejercicio4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LectorMejorado {
	
	public static void main(String[] args) throws IOException {
		
		//Instanciamos un objeto File de entrada
		File fileInput = new File("archivos" + File.separator + "input.txt");
		
		//Construyo un BufferedReader
		BufferedReader reader = new BufferedReader(new FileReader(fileInput));
		
		//Leemos el archivo linea a linea y mostramos por pantalla
		String cadenaLeida;
		while((cadenaLeida = reader.readLine()) != null) { 
			System.out.println(cadenaLeida);
		}
		
		//Cierro el bufferedReader
		reader.close();
	}

}
