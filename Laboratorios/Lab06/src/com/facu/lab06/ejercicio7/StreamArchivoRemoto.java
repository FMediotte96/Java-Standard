package com.facu.lab06.ejercicio7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class StreamArchivoRemoto {
	
	public static void main(String[] args) {
		
		try {
			//Construye un objeto URL
			URL url = new URL("http://www.clarin.com");
			
			//Construye un stream contra la URL
			BufferedReader eBuffer = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream()));
			
			//Variables
			String unaLinea;
			//Leemos el archivo linea a linea y mostramos por pantalla
			while((unaLinea = eBuffer.readLine()) != null) {
				System.out.println(unaLinea);
			}
			
			//Cierro el bufferedReader
			eBuffer.close();
			
		} catch (MalformedURLException e) {
			System.out.println("La url no es válida: " +  e.toString());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("No se puede leer de Internet: " + e.toString());
			e.printStackTrace();
		} 
		
	}

}
