package com.lab04.ejercicio2;

import java.util.ArrayList;
import java.util.Iterator;

public class ImpresorDeClientes {
	
	public static void main(String[] args) {
		
		ArrayList<Cliente> losClientes = new ArrayList<Cliente>();
		losClientes.add(new Cliente("Mac Donalds", "Av. Corrientes 4586"));
        losClientes.add(new Cliente("BlockBuster", "Av. Maipu 4251"));
        losClientes.add(new Cliente("Pizza Hut", "Av. Cordoba 5471"));
        losClientes.add(new Cliente("Kodak", "Av. Alem 555"));
        losClientes.add(new Cliente("Unicenter", "Av. Paraná 3524"));
		
		Iterator<Cliente> it = losClientes.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
