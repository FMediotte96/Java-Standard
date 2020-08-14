package ar.com.educacionit.vehiculos.entidades;

import ar.com.educacionit.base.entidades.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Vendedor extends Persona {
    
    private int id;
    private int cantAutosVendidos;

    public Vendedor(String nombre, String apellido, String numeroDocumento, int cantAutosVendidos) {
        super(nombre, apellido, numeroDocumento);
        this.cantAutosVendidos = cantAutosVendidos;
    }

    public Vendedor() {
        this("","","",0);
    }

    public int getCantAutosVendidos() {
        return cantAutosVendidos;
    }

    public void setCantAutosVendidos(int cantAutosVendidos) {
        this.cantAutosVendidos = cantAutosVendidos;
    }

    @Override
    public String toString() {
        return super.toString() + ", Cantidad de autos vendidos: " + cantAutosVendidos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int insertar(Connection conn) throws Exception {
                
        String insercion = "INSERT INTO vendedores (v_nombre,v_apellido,"
                + "v_dni,v_autosVendidos) VALUES (?,?,?,?)";
        
        PreparedStatement ps = conn.prepareStatement(insercion, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, getNombre());
        ps.setString(2, getApellido());
        ps.setString(3, getNumeroDocumento());
        ps.setInt(4, getCantAutosVendidos());
        ps.execute();
        
        int id_aux = 0;
        ResultSet rs = ps.getGeneratedKeys();
        if(rs.next()){
            id_aux = rs.getInt(1);
        }

        ps.close();        
        System.out.println("La inserción ha sido realizada con éxito");
        return id_aux;
    }
    
    public void actualizar(Connection conn) throws Exception {
                
        String actualizacion = "UPDATE vendedores SET v_nombre = ?, "
                + "v_apellido = ?, v_dni = ?, v_autosVendidos = ? WHERE "
                + "v_id = ?";
        PreparedStatement ps = conn.prepareStatement(actualizacion);
        ps.setString(1, getNombre());
        ps.setString(2, getApellido());
        ps.setString(3, getNumeroDocumento());
        ps.setInt(4, getCantAutosVendidos());
        ps.setInt(5, getId());
        ps.execute();
        
        ps.close();        
        System.out.println("La actualización ha sido realizada con éxito");
    }
    
    public void eliminar(Connection conn) throws Exception {
                
        String eliminacion = "DELETE FROM vendedores WHERE v_id = " + getId();
        Statement stmtEliminacion = conn.createStatement();
        stmtEliminacion.execute(eliminacion);
        
        stmtEliminacion.close();        
        System.out.println("La eliminación ha sido realizada con éxito");
    }
    
    public static ArrayList obtenerTodos(Connection conn) throws Exception {
                
        String laConsulta = "SELECT * FROM vendedores";
        Statement stmtConsulta = conn.createStatement();
        ResultSet rs = stmtConsulta.executeQuery(laConsulta);
        
        ArrayList<Vendedor> vendedores = new ArrayList<>();
        while(rs.next()){
            Vendedor nuevoVendedor = new Vendedor(
                    rs.getString("v_nombre"),
                    rs.getString("v_apellido"),
                    rs.getString("v_dni"),
                    rs.getInt("v_autosVendidos"));
            vendedores.add(nuevoVendedor);
        }
        
        stmtConsulta.close();        
        return vendedores;
    }
}
