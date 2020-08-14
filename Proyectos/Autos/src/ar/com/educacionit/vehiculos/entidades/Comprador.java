package ar.com.educacionit.vehiculos.entidades;

import ar.com.educacionit.base.entidades.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Comprador extends Persona{
    
    private int id;
    private double presupuesto;

    public Comprador(String nombre, String apellido, String numeroDocumento, double presupuesto) {
        super(nombre, apellido, numeroDocumento);
        this.presupuesto = presupuesto;
    }

    public Comprador() {
        this("","","",0);
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    @Override
    public String toString() {
        return super.toString() + ", Presupuesto=" + presupuesto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int insertar(Connection conn) throws Exception {
                
        String insercion = "INSERT INTO compradores (c_nombre,"
                + "c_apellido,c_dni,c_presupuesto) VALUES (?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(insercion,Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, getNombre());
        ps.setString(2, getApellido());
        ps.setString(3, getNumeroDocumento());
        ps.setDouble(4, getPresupuesto());
        ps.execute();
        
        int id_aux = 0;
        ResultSet rs = ps.getGeneratedKeys();
        if(rs.next()) {
            id_aux = rs.getInt(1);
        }
        ps.close();      
        System.out.println("La inserción ha sido realizada con éxito"); 
        return id_aux;
    }
    
    public void actualizar(Connection conn) throws Exception {
                
        String actualizacion = "UPDATE compradores SET c_nombre = ?, c_apellido = ?,"
                + " c_dni = ?, c_presupuesto = ? WHERE c_id = ?";
        PreparedStatement ps = conn.prepareStatement(actualizacion);
        ps.setString(1, getNombre());
        ps.setString(2, getApellido());
        ps.setString(3, getNumeroDocumento());
        ps.setDouble(4, getPresupuesto());
        ps.setInt(5, getId());
        ps.execute();
        
        ps.close();       
        System.out.println("La actualización ha sido realizada con éxito");
    }
    
    public void eliminar(Connection conn) throws Exception {
        
        String eliminacion = "DELETE FROM compradores WHERE c_id = " + getId();
        Statement stmtEliminacion = conn.createStatement();
        stmtEliminacion.execute(eliminacion);
        
        stmtEliminacion.close();       
        System.out.println("La eliminación ha sido realizada con éxito");
    }
    
    public static ArrayList obtenerTodos(Connection conn) throws Exception {
                
        String laConsulta = "SELECT * FROM compradores";
        Statement stmtConsulta = conn.createStatement();
        ResultSet rs = stmtConsulta.executeQuery(laConsulta);
        
        ArrayList<Comprador> compradores = new ArrayList<>();
        while(rs.next()){
            Comprador nuevoComprador = new Comprador(
                    rs.getString("c_nombre"),
                    rs.getString("c_apellido"),
                    rs.getString("c_dni"),
                    rs.getDouble("c_presupuesto"));
            compradores.add(nuevoComprador);
        }
        
        stmtConsulta.close();        
        return compradores;
    }
}
