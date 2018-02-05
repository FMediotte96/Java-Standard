/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.educacionit.vehiculos.pruebas;

import ar.com.educacionit.vehiculos.entidades.Comprador;
import ar.com.educacionit.vehiculos.util.AdministradorDeConexiones;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author Facundo
 */
public class TestCompradores {
    public static void main(String[] args) throws Exception {
        
        Connection conn = AdministradorDeConexiones.getConnection();
        Comprador comprador = new Comprador("Facundo", "Mediot", "39436162", 600000);
        ArrayList<Comprador> compradores;
        
        //Insertar
        comprador.setId(1);
        comprador.insertar(conn);
        compradores = Comprador.obtenerTodos(conn);
        compradores.forEach(System.out::println);
        
        //Actualizar
        comprador.setApellido("Mediotte");
        comprador.actualizar(conn);
        compradores = Comprador.obtenerTodos(conn);
        compradores.forEach(System.out::println);
        
        //Eliminar
        comprador.eliminar(conn);
        compradores = Comprador.obtenerTodos(conn);
        compradores.forEach(System.out::println);
        
        conn.close();
    }
    
}
