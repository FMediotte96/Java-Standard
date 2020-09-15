package test;

import interfaces.Calculadora;

public class TestCalculadora {
	
	public static void main(String[] args) {
		
		Calculadora cal = (argA, argB) -> argA / argB;
		
		System.out.println(cal.suma(10, 23));
	}

}
