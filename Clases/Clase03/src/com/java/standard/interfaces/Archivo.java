package com.java.standard.interfaces;

public interface Archivo {
	
	/*
	 * Una interface es un contrato de m�todo a implementar por las clases que utilicen la interfaz.
	 * En la interfaz todos los m�todos son public, no hay atributos declarados,
	 * solo se pueden declarar constantes, y tampoco se declaran constructores
	 */
	
	void print(); //No es necesario ponerle public
	String getText();
	void setText(String text);
	void append(String text); //apendiza el texto, agrega al final.
	
	//Interfaces default java8
	default void info() {
		System.out.println("Interface Archivo!");
	}

}
