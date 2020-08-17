package com.facu.javastandard.clase05;

public class TestEnumString {
	
	public static void main(String[] args) {
		System.out.println("------------ENUMERADORES-------------");
        //Enums
        EstadoCivil estado = EstadoCivil.CASADO;
        Genero genero = Genero.MASCULINO;
        
        System.out.println(estado + " " + genero);
        Genero[] generos = Genero.values();
        for(Genero gen:generos) {
        	System.out.println(gen);
        }
        
        //Clase String
        String texto = "Hola soy una Cadena de caracteres!";
        String texto2 = new String("Hola");
        char[] vector = {'h','o','l','a'};
        String texto3 = new String(vector);
        
        //Metodo equals() y equalsIgnoreCase()
        System.out.println("-----------EQUALS---------");
        System.out.println(texto2.equals("hola"));
        System.out.println(texto2.equalsIgnoreCase("hola"));
        
        //Metodo startsWith y endWith
        System.out.println("------------StartsWith-EndWith---------");
        System.out.println(texto.startsWith("Hola"));
        System.out.println(texto.startsWith("hola"));
        System.out.println(texto.endsWith("res!"));
        System.out.println(texto.endsWith("res"));
        
        //Metodo contains
        System.out.println("------------CONTAINS----------");
        System.out.println(texto.contains("Cadena"));
        System.out.println(texto3.contains("chau"));
        
        //Metodo toLowerCase - to UpperCase
        System.out.println("------------CASE-----------");
        System.out.println(texto.toLowerCase());
        System.out.println(texto.toUpperCase());
        
        //Metodo lenght
        System.out.println("Lenght: " + texto.length());
        
        //Metodo charAt
        System.out.println(texto.charAt(5));
        
        //Metodo subString
        System.out.println(texto.substring(3));
        System.out.println(texto.substring(3, 10));
	}

}
