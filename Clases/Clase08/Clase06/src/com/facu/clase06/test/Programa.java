package com.facu.clase06.test;

import com.facu.clase06.exceptions.NoHayPasajesException;
import com.facu.clase06.exceptions.TestException;
import com.facu.clase06.exceptions.Vuelo;

public class Programa {
	
	public static void main(String[] args) {
		//Excepciones
		//System.out.println(10/0);
		//System.out.println("Este linea ya no se ejecuta");
		
		//Estructura Try-Catch
		/*try {
			colocar las lineas que pueden arrojar un error (Exception).
			estas líneas tiene más costo de hardware
		} catch (Exception e) {
			En caso de existir una exception se ejecuta este bloque.
			Se recibe un objeto Exception con detalles del error
		} finally {
			Estas lineas se ejecutan siempre
		}
		Estas lineas tambien se ejecutan siempre.
		*/
		
		try {
			System.out.println(10/0);
			System.out.println("Este linea no se ejecuta");
		} catch (Exception e) {
			System.out.println("Ocurrio un error");
			System.out.println(e);
		} finally {
			System.out.println("Estas lineas se ejecutan siempre");
		}
		
		System.out.println("-------------------------");
		try {
			System.out.println("A continuación se lanzara una Exception");
			//TestException.generarException();
			//TestException.generarException(true);
			TestException.generarException(null);
			System.out.println("Esta linea no se ejecuta");
		} catch (Exception e) {
			System.out.println(e);
		}
		
		System.out.println("-------------------------");

		//Captura personalizada de Exceptions
		try {
			System.out.println("A continuación se lanzara una Exception");
			//TestException.generarException();
			//TestException.generarException(true);
			String texto = null;
			TestException.generarException(texto);
			System.out.println("Esta linea no se ejecuta");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Indice fuera de rango.");
		} catch (ArithmeticException e) {
			System.out.println("División por cero.");
		} catch (NumberFormatException e) {
			System.out.println("Formato de número incorrecto.");
		} catch (NullPointerException e) {
			System.out.println("Elemento nulo");
		} catch (Exception e) {
			System.out.println("Ocurrio un error inesperado");
		}
		
		
		//Uso de Exceptions para validar reglas de negocio
        
        Vuelo vuelo1 = new Vuelo("aer1234",100);
        Vuelo vuelo2 = new Vuelo("lan1111",100);
        
        try {
            vuelo1.venderPasajes(20);
            vuelo2.venderPasajes(10);
            vuelo1.venderPasajes(40);
            vuelo2.venderPasajes(30);
            vuelo1.venderPasajes(50);       //Esta venta arroja una exception
            vuelo2.venderPasajes(20);       //Esta venta no se efectua
        } catch (NoHayPasajesException ex) {
            System.out.println(ex);
        }
	}

}
