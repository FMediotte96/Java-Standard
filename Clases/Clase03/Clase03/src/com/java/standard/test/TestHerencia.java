package com.java.standard.test;

import com.java.standard.entities.Cliente;
import com.java.standard.entities.Direccion;
import com.java.standard.entities.Empleado;
import com.java.standard.entities.Persona;

public class TestHerencia {

	public static void main(String[] args) {
		
		//Object
		class ClaseEjemplo { 
			
		}
		
		class ClaseEjemplo2 extends ClaseEjemplo {
			
		}
		
		ClaseEjemplo ce1 = new ClaseEjemplo();
		ClaseEjemplo ce2 = new ClaseEjemplo2();
		
		String texto = "hola";
		
		Object obj = new Object();
		
		System.out.println(ce2.getClass().getSuperclass());
		System.out.println(ce1.getClass().getSuperclass());
		System.out.println(texto.getClass().getSuperclass());
		System.out.println(obj.getClass().getSuperclass());
		
		//Direccion
		Direccion dir1 = new Direccion("Lavalle", 648, 11, "A");
		System.out.println(dir1);
		Direccion dir2 = new Direccion("Maipu", 3070, 0, null, "Olivos");
		System.out.println(dir2);
		
		//Persona
		/* No podemos crear instancias de una clase abstracta
		Persona p1 = new Persona("Jose", "Cereso", 0, dir1);
		p1.saludar();
		System.out.println(p1);
		*/
		
		//Empleado
		Empleado e1 = new Empleado(1, 25000, "Susana", "Molina", 26, dir1);
		System.out.println(e1);
		e1.saludar();
		
		Empleado e2 = new Empleado(2, 3200, "Laura", "Segovia", 32 , dir2);
		System.out.println(e2);
		e2.saludar();
		
		//Cliente
		Cliente c1 = new Cliente(1, "Simple", "Javier", "Larrosa", 24, dir1);
		System.out.println(c1);
		c1.saludar();
		
		Cliente c2 = new Cliente(2, "Simple", "Cristian", "Juarez", 32, dir2);
		System.out.println(c2);
		c2.saludar();
		
		//Polimorfismo
		Persona persona1 = new Empleado(3, 2000, "Facundo", "Mediotte", 40, dir1);
		Persona persona2 = new Cliente(3, "Simple", "Raul", "Sertez", 34, dir2);
		
		persona1.saludar();
		persona2.saludar();
		
		//Casteo de Objetos
//		Persona persona3 = c1;
//		Object obj2 = c1;
//		
//		Empleado e3 = (Empleado)persona1;
//		Cliente e4 = (Cliente) obj2;
		
//		obj2 = "Hola";
		
		Empleado empleado = null;
		Cliente cliente = null;
		if(persona1 instanceof Empleado)
			empleado = (Empleado) persona1;
		if(persona1 instanceof Cliente)
			cliente = (Cliente) persona1;
		
		System.out.println(empleado);
		System.out.println(cliente);
		
	}

}
