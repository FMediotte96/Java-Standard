package com.facu.javastandard.ejercicio1;

public class TestSystem {

	public TestSystem() {
		
	}
	
	public static void main(String[] args) {
		//Obtengo las propiedades del sistema donde se encuentra la JVM
		String javahome = "java.home --> " + System.getProperty("java.home");
		String classpath = "java.class.path --> " + System.getProperty("java.class.path");
		String osname = "os.name --> " + System.getProperty("os.name");
		
		//Imprime las propiedas obtenidas
		System.out.println("[Propiedades obtenidas]");
		System.out.println("\t" + javahome);
		System.out.println("\t" + classpath);
		System.out.println("\t" + osname);
		
		//Llama al garbage collector
		System.gc();
		
		//Termina la ejecución
		System.exit(0);
	}
}
