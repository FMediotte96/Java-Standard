package com.lab04.ejercicio1;

import java.util.ArrayList;

public class Empresa {
	
	public static void main(String[] args) {
		
		//A
		Empleado e1 = new Empleado("Facundo", "39436162", 24);
		Empleado e2 = new Empleado("Fernando", "39999999", 25);
		Empleado e3 = new Empleado("Lucas", "42999931", 19);
		Empleado e4 = new Empleado("Diego", "37999111", 26);
		Empleado e5 = new Empleado("Nicole", "44111222", 17);
		Empleado e6 = new Empleado("Fabiana", "17900028", 55);
		
		//B
		ArrayList<Empleado> losEmpleados = new ArrayList<Empleado>();
		losEmpleados.add(e1);
		losEmpleados.add(e2);
		losEmpleados.add(e3);
		losEmpleados.add(e4);
		losEmpleados.add(e5);
		losEmpleados.add(e6);
		
		//C(F)
		System.out.println("-----------C------------");
		Empleado.informarDatosDeEmpleados(losEmpleados);
		
		//D
		System.out.println("-----------D------------");
		System.out.println("Cantidad de empleados de la empresa: " + losEmpleados.size());
		
		//E(G)
		System.out.println("-----------E------------");
		Empleado.informarDatosDeEmpleados(obtenerDatosDeEmpleadosMenosDe30(losEmpleados));
	}

	public static ArrayList<Empleado> obtenerDatosDeEmpleadosMenosDe30(ArrayList<Empleado> losEmpleados) {
		ArrayList<Empleado> empleadosMenoresDe30 = new ArrayList<Empleado>();
		losEmpleados.forEach(empl-> {
			if(empl.getEdad() < 30) {
				empleadosMenoresDe30.add(empl);
			}
		});
		
		return empleadosMenoresDe30;
	}
}
