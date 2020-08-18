package com.facu.lab06.ejercicio5;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EscritorMejorado {

	public static void main(String[] args) throws IOException {
		
		//Instanciamos un objeto File de salida
		File fileOutput = new File("archivos" + File.separator + "outputMejorado.txt");
		
		//Instanciamos un BufferedWriter
		BufferedWriter out = new BufferedWriter(new FileWriter(fileOutput));
		
		//Texto a guardar
		String linea1 = "Hola, soy la línea #1";
		String linea2 = "Como te va? Yo soy la línea #2!";
		String linea3 = "Y yo la línea #3!!!";
		
		//Escribimos las lineas en el archivo
		out.write(linea1);
		out.newLine();
		out.write(linea2);
		out.newLine();
		out.write(linea3);
		out.newLine();
		
		//Cierro el bufferedWriter
		out.close();
	}
}
