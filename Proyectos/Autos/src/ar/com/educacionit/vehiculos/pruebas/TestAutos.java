/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.educacionit.vehiculos.pruebas;

import ar.com.educacionit.vehiculos.entidades.Auto;
import ar.com.educacionit.vehiculos.util.AdministradorDeConexiones;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author Facundo
 */
public class TestAutos {
    
    public static void main(String[] args) throws Exception {
        
        Connection conn = AdministradorDeConexiones.getConnection();
        Auto auto = new Auto("Citroen", "2018", "Gris", 300, 200, 400);
        ArrayList<Auto> autos;
        
        //Insertar
        auto.setPrecio(600000);
        auto.setDescripcion("Airbag");
        auto.insertar(conn);
        autos = Auto.obtenerTodos(conn);
        autos.forEach(System.out::println);

        //Actualizar
        auto.setId(1);
        auto.setAlto(160);
        auto.actualizar(conn);
        autos = Auto.obtenerTodos(conn);
        autos.forEach(System.out::println);
        
        //Eliminar
        auto.eliminar(conn);
        autos = Auto.obtenerTodos(conn);
        autos.forEach(System.out::println);
        
        conn.close();
    }
    
}
