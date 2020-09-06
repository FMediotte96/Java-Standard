package com.facu.javastandard.test;

import java.sql.Connection;
import java.sql.SQLException;

import com.facu.javastandard.connector.AdministradorDeConexiones;

public class TestConnector {

	public static void main(String[] args) throws SQLException {
		Connection conn = AdministradorDeConexiones.getConnector();
		String query = "insert into alumnos (nombre,apellido,edad,curso) "
				+ "values ('Facundo','Mediotte',24,1)";
		
		conn.createStatement().execute(query);
	}

}
