package ar.com.eduit.curso.java.test;

import ar.com.eduit.curos.java.connector.Connector;
import java.sql.Connection;

public class TestConnector {
   public static void main(String[] args) throws Exception{
       Connection conn= Connector.getConnector();
       String query="insert into alumnos (nombre, apellido,edad,curso)" +
               "values ('Facundo','Mediotte',22,1)";
       conn.createStatement().execute(query);
   }
}
