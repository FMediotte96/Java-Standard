package com.facu.lab06.ejercicio3;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Copiador {
	
	public static void main(String[] args) throws IOException {
		
		//Instanciamos un objeto File de entrada y un objeto File de Salida
		File fileInput = new File("archivos" + File.separator + "input.txt");
		File fileOutput = new File("archivos" + File.separator + "output.txt");
		
		//Instanciamos un FileReader y un FileWriter
		FileReader in = new FileReader(fileInput);
		FileWriter out = new FileWriter(fileOutput);
		
		//Declaramos una variable que contendrá el caracter a leer
		int caracter;
		
		//Leo de input.txt y grabo en el archivo output.txt
		while((caracter = in.read()) != -1) {
			out.write(caracter);
		}
		
		//Cierro los streams
		in.close();
		out.close();
	}

}
