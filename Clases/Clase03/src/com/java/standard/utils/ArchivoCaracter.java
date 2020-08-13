package com.java.standard.utils;

import com.java.standard.interfaces.Archivo;

public class ArchivoCaracter implements Archivo {

	@Override
	public void print() {
		System.out.println("Imprimiendo archivo caracter.");
	}

	@Override
	public String getText() {
		return "Texto archivo caracter.";
	}

	@Override
	public void setText(String text) {
		System.out.println("Escribiendo Archivo Caracter");
	}

	@Override
	public void append(String text) {
		System.out.println("Apendizando Archivo Caracter.");
	}

}
