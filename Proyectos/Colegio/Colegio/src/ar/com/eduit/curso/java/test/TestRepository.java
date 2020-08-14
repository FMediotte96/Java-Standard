package ar.com.eduit.curso.java.test;

import ar.com.eduit.curso.entities.Alumno;
import ar.com.eduit.curso.java.connector.Connector;
import ar.com.eduit.curso.java.repositories.AlumnoR;
import java.sql.Connection;


public class TestRepository {
    public static void main(String[] args) {
        Connection conn=Connector.getConnector();
        AlumnoR ar=new AlumnoR(conn);
        Alumno alumno = new Alumno("Nicolas","Leon",20,1);
        ar.save(alumno);
        System.out.println(alumno);
        
        System.out.println(ar.getById(1));
        
        ar.remove(ar.getById(4));
        
        alumno=ar.getById(3);
        alumno.setNombre("Juan");
        alumno.setApellido("Loreto");
        ar.update(alumno);
        
        System.out.println("------------------");
        ar.getAll().forEach(System.out::println);
        System.out.println("------------------");
        ar.getByFiltro("nombre like 'Ma%'")
                .forEach(System.out::println);
        System.out.println("-------------------");
        ar.getByApellido("Leon")
                .forEach(System.out::println);
        
    }
}
