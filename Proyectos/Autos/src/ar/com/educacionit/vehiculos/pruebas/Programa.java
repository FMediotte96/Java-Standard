package ar.com.educacionit.vehiculos.pruebas;

import ar.com.educacionit.vehiculos.entidades.Auto;
import ar.com.educacionit.vehiculos.entidades.Comprador;
import ar.com.educacionit.vehiculos.entidades.Vendedor;

public class Programa {
    
    public static void main(String[] args) {
        
        Auto auto = new Auto("Ford", "Focus", "Negro", 148, 182, 435);
        System.out.println(auto);
        
        Comprador comprador = new Comprador("Fernando", "Maceri", "38123562", 500000);
        System.out.println(comprador);
        
        Vendedor vendedor = new Vendedor("Facundo", "Mediotte", "39436162", 10);
        System.out.println(vendedor);
        
    }

}
