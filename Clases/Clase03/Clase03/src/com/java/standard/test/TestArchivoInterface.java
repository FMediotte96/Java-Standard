package com.java.standard.test;

import java.util.Scanner;

import com.java.standard.interfaces.Archivo;
import com.java.standard.utils.ArchivoBuffer;
import com.java.standard.utils.ArchivoCaracter;

public class TestArchivoInterface {
	public static void main(String[] args) throws Exception {
		Archivo archivo = null;
		
//		archivo = new ArchivoCaracter();
//		archivo = new ArchivoBuffer();
		System.out.println("Ingrese ArchivoBuffer - ArchivoCaracter");
		@SuppressWarnings("resource")
		String input = new Scanner(System.in).nextLine();
		
		if(input.equals("ArchivoBuffer")) archivo = new ArchivoBuffer();
		if(input.equals("ArchivoCaracter")) archivo = new ArchivoCaracter();
		
		//instanciación dinamica
		input = "com.java.standard.utils."+input;
		archivo = (Archivo) Class.forName(input).newInstance();
		
		archivo.print();
		archivo.setText("texto");
		archivo.append("text");
		System.out.println(archivo.getText());
		archivo.info();

	}

}
