package com.educacionit.jse.excepciones;

public class Main {

	public static void main(String[] args) {

		Calculadora c = new Calculadora();
		try {
			System.out.println(c.sumar(10, 50));
			System.out.println(c.sumar(0, 50));
			System.out.println(c.sumar(100000, 50));
		} catch (CalculadoraException e) {
			e.printStackTrace();
		}
		
		try {
			System.out.println(c.restar(10, 5));
			System.out.println(c.restar(10, 50));
		} catch (CalculadoraException e) {
			e.printStackTrace();
		}

	}

}
