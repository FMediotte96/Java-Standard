package com.facu.javastandard.test;

import java.sql.Connection;

import com.facu.javastandard.connector.AdministradorDeConexiones;
import com.facu.javastandard.dao.AlumnoDAO;
import com.facu.javastandard.entities.Alumno;

public class TestAlumnoDAO {
	
	public static void main(String[] args) {
		Connection conn = AdministradorDeConexiones.getConnector();
		
		AlumnoDAO ar = new AlumnoDAO(conn);
		
		Alumno alumno = new Alumno("Fernando", "Maceri", 25, 1);
		ar.save(alumno);
		
		System.out.println(ar.getById(1));
		
		ar.delete(ar.getById(2));
		
		alumno = ar.getById(1);
		alumno.setNombre("Fernando");
		alumno.setApellido("O'Conner");
		ar.update(alumno);
		
		System.out.println("-----------------------------");
		ar.getAll().forEach(System.out::println);
		System.out.println("-----------------------------");
		
		ar.getByFiltro("nombre like 'Fer%'").forEach(System.out::println);
		
		System.out.println("-----------------------------");

		ar.getByApellido("Maceri").forEach(System.out::println);
		
	}

}
