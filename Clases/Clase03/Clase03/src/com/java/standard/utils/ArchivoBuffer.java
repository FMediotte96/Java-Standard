package com.java.standard.utils;

import com.java.standard.interfaces.Archivo;

public class ArchivoBuffer implements Archivo {

	@Override
	public void print() {
		System.out.println("Imprimiento Archivo de Buffers");
		
	}

	@Override
	public String getText() {
		return "Texto de archivo Buffer";
	}

	@Override
	public void setText(String text) {
		System.out.println("Escribiendo archivo buffer.");
		
	}

	@Override
	public void append(String text) {
		System.out.println("Apendizando archivo buffer.");
	}

}
