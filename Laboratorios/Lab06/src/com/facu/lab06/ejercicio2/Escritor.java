package com.facu.lab06.ejercicio2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Escritor {
	
	public static void main(String[] args) throws IOException {
		
		//Instanciamos un objeto File de salida
		File fileOutput = new File("archivos" + File.separator + "output.txt");
		
		//Instanciamos un FileWriter que se encargará de escribir el archivo
		FileWriter out = new FileWriter(fileOutput);
		
		//Construimos una cadena de caracteres a ser guardada en el archivo
		String cadena = "Soy la información";
		
		//Escribe el archivo con la información
		for(int i=0;i<cadena.length();i++) {
			out.write(cadena.charAt(i));
		}
		
		//Cierro el stream
		out.close();
	}

}
