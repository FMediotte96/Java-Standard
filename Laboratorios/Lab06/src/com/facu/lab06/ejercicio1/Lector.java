package com.facu.lab06.ejercicio1;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Lector {
	
	public static void main(String[] args) throws IOException {
		
		//Instanciamos un objeto File de entrada
		File fileInput = new File("archivos" + File.separator + "input.txt");
		
		//Instanciamos un FileReader que se encargará de leer el archivo
		FileReader in = new FileReader(fileInput);
		
		//Declaramos una variable que contendrá el caracter a leer
		int caracter;
		
		//Lee el archivo e informa por pantalla
		while((caracter = in.read()) != -1) {
			System.out.print((char)caracter);
		}
		
		//Cierro el stream
		in.close();
	}

}
