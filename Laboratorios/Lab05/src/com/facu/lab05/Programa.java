package com.facu.lab05;

public class Programa {
	
	public static void main(String[] args) {
		try {
			//Si la cantidad de argumentos es distinto a 2 entonces lanzo una excepcion
			if(args.length != 2) {
				throw new CantidadDeArgumentosException("001", "ALTO", "Se deben pasar desde la linea de comandos 2 parametros. ");
			}
			
			//Convierte el 1er argumento a un numero entero --> en caso de no poder convertilo arroja una excepcion
			int a = Integer.parseInt(args[0]);
			
			//Convierte el 2do argumento a un numero entero --> en caso de no poder convertilo arroja una excepcion
			int b = Integer.parseInt(args[1]);
			
			System.out.println(calcularDivision(a, b));
			
		} catch (CantidadDeArgumentosException e) {
			System.out.println(">>>>>>>> " + e.getMensajeError());
			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.out.println(">>>>>>>> " + "Los dos valores deben ser númericos");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(">>>>>>>> " + e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	public static float calcularDivision(int a, int b) throws Exception {
		if(b==0) {
			throw new Exception("El 2do parametro no puede ser cero (0)");
		}
		
		return a/b;
	}

}
