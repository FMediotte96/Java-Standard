package com.java.standard.test;

import com.java.standard.entities.ClienteEmpresa;
import com.java.standard.entities.ClienteMinorista;
import com.java.standard.entities.Cuenta;

public class TestRelaciones {

	public static void main(String[] args) {
		
		System.out.println("-- cuenta1 --");
		Cuenta cuenta1 = new Cuenta();
		cuenta1.setNro(1);
		cuenta1.setMoneda("arg$");
		cuenta1.setSaldo(100000);
		
		System.out.println("-- cuenta2 --");
		Cuenta cuenta2 = new Cuenta(2,"arg$");
		cuenta2.depositar(30000);
		cuenta2.depositar(20000);
		cuenta2.debitar(10000);
		
		System.out.println(cuenta2.getNro() + " " + cuenta2.getMoneda() + " " + cuenta2.getSaldo());
		
		//método toString
		System.out.println(cuenta2.toString());
		System.out.println(cuenta2);
		
		//Clase Minorista
		ClienteMinorista cm = new ClienteMinorista(1,"Juan Perez", "Lima 222", 3);
		cm.getCuenta().depositar(40000);
		cm.getCuenta().debitar(20000);
		
		System.out.println(cm);
		System.out.println(cm.getCuenta());
		
		//Clase ClienteMayorista
		System.out.println("-- Cliente Mayorista --");
		ClienteEmpresa cma1 = new ClienteEmpresa(1, "Todo Limpio srl", "Maipu 222");
		
		Cuenta[] cuentas = cma1.getCuentas();
		cuentas[0] = new Cuenta(10,"arg$");
		cuentas[1] = new Cuenta(11,"u$s");
		cuentas[2] = new Cuenta(12,"reales");
		
		cuentas[0].depositar(30000);
		cuentas[0].depositar(23000);
		cuentas[0].debitar(5000);
		
		cuentas[1].depositar(12000);
		cuentas[2].depositar(18000);
		
		System.out.println(cma1);
		
		for(int i=0; i< cuentas.length; i++) {
			System.out.println(cuentas[i]);
		}
		
	}
}
