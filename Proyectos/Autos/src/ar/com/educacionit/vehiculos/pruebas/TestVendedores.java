/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.educacionit.vehiculos.pruebas;

import ar.com.educacionit.vehiculos.entidades.Vendedor;
import ar.com.educacionit.vehiculos.util.AdministradorDeConexiones;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author Facundo
 */
public class TestVendedores {
    public static void main(String[] args) throws Exception {
        
        Connection conn = AdministradorDeConexiones.getConnection();
        Vendedor vendedor = new Vendedor("Brian", "Rami", "25012389", 25);
        ArrayList<Vendedor> vendedores;
        
        //Insertar
        vendedor.setId(1);
        vendedor.insertar(conn);
        vendedores = Vendedor.obtenerTodos(conn);
        vendedores.forEach(System.out::println);
        
        //Actualizar
        vendedor.setApellido("Ramirez");
        vendedor.setCantAutosVendidos(30);
        vendedor.actualizar(conn);
        vendedores = Vendedor.obtenerTodos(conn);
        vendedores.forEach(System.out::println);
        
        //Eliminar
        vendedor.eliminar(conn);
        vendedores = Vendedor.obtenerTodos(conn);
        vendedores.forEach(System.out::println);
        
        conn.close();
    } 
}
