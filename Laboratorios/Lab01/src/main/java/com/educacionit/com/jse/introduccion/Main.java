package com.educacionit.com.jse.introduccion;

public class Main {

	public static void main(String[] args) {

		int[] vecNumeros = { 11, -22, 33, -44, 55, -66, 77, -88, 99 };
		int totalPositivos = 0;
		int totalNegativos = 0;

		for (int i = 0; i < vecNumeros.length; i++) {
			if (vecNumeros[i] < 0) {
				totalNegativos = totalNegativos + vecNumeros[i];
			} else {
				totalPositivos = totalPositivos + vecNumeros[i];
			}
		}
		System.out.println("Total positivos: "+ totalPositivos);
		System.out.println("Total negativos: "+ totalNegativos);

	}

}
