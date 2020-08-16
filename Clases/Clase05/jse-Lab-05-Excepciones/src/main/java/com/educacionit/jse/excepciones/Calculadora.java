package com.educacionit.jse.excepciones;

public class Calculadora {
	
	public int sumar(int a, int b) throws CalculadoraException{
		if (a < 0 || b < 0) {
			throw new CalculadoraException("No se pueden enviar n�meros menores a 0");
		}
		if (a > 1000 || b > 1000) {
			throw new CalculadoraException("No se pueden enviar n�meros mayores a 1000");
		}
		return a+b;
	}
	
	public int restar(int a, int b) throws CalculadoraException{
		if (a < 0 || b < 0) {
			throw new CalculadoraException("No se pueden enviar n�meros menores a 0");
		}
		if (a < b) {
			throw new CalculadoraException("El primer n�mero no puede ser inferior al segundo");
		}
		return a-b;
	}

}
