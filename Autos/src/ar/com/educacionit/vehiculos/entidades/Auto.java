package ar.com.educacionit.vehiculos.entidades;

import ar.com.educacionit.base.entidades.Vehiculo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Auto extends Vehiculo{
    
    private int id;
    private StringProperty marca;
    private StringProperty modelo;
    private String color;
    private double precio;
    private String descripcion;

    
    public Auto(String marca, String modelo, String color, int alto, int ancho, int largo) {
        super(alto, ancho, largo);
        this.marca = new SimpleStringProperty(marca);
        this.modelo = new SimpleStringProperty(modelo);
        this.color = color;
    }

    public Auto() {
        this(null,null,null,0,0,0);
        descripcion = "";
    }

    @Override
    public String toString() {
        return "Marca: " + marca.get() + ", Modelo: " + modelo.get() + ", Color: " + color
                + ", " + super.toString();
    }

    public String getMarca() {
        return marca.get();
    }

    public void setMarca(String marca) {
        this.marca.set(marca);
    }

    public String getModelo() {
        return modelo.get();
    }

    public void setModelo(String modelo) {
        this.modelo.set(modelo);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public StringProperty modeloProperty() {
        return modelo;
    }
    
    public StringProperty marcaProperty() {
        return marca;
    }
    
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int insertar(Connection conn) throws Exception {
               
        String insercion = "INSERT INTO autos (au_marca,au_modelo,"
                + "au_precio,au_color,au_largo,au_ancho,au_altura,au_equipamiento)"
                + " VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(insercion, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, getMarca());
        ps.setString(2, getModelo());
        ps.setDouble(3, getPrecio());
        ps.setString(4, getColor());
        ps.setInt(5, getLargo());
        ps.setInt(6, getAncho());
        ps.setInt(7, getAlto());
        ps.setString(8, getDescripcion());
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
                
        String actualizacion = "UPDATE autos SET au_marca = ?, au_modelo = ?,"
                + " au_precio = ?, au_color = ?, au_largo = ?, au_ancho = ?,"
                + " au_altura = ?, au_equipamiento = ? WHERE au_id = ?";
        PreparedStatement ps = conn.prepareStatement(actualizacion);
        ps.setString(1, getMarca());
        ps.setString(2, getModelo());
        ps.setDouble(3, getPrecio());
        ps.setString(4, getColor());
        ps.setInt(5, getLargo());
        ps.setInt(6, getAncho());
        ps.setInt(7, getAlto());
        ps.setString(8, getDescripcion());
        ps.setInt(9, getId());
        ps.execute();
        
        ps.close();        
        System.out.println("La actualización ha sido realizada con éxito");
    }
    
    public void eliminar(Connection conn) throws Exception {
                
        String eliminacion = "DELETE FROM autos WHERE au_id = " + getId();
        Statement stmtEliminacion = conn.createStatement();
        stmtEliminacion.execute(eliminacion);
        
        stmtEliminacion.close();        
        System.out.println("La eliminacion ha sido realizada con éxito");
    }
    
    public static ArrayList obtenerTodos(Connection conn) throws Exception {
                
        String laConsulta = "SELECT * FROM autos";
        Statement stmtConsulta = conn.createStatement();
        ResultSet rs = stmtConsulta.executeQuery(laConsulta);
        
        ArrayList<Auto> autos = new ArrayList<>();
        while(rs.next()){
            Auto nuevoAuto = new Auto(
                    rs.getString("au_marca"),
                    rs.getString("au_modelo"),
                    rs.getString("au_color"),
                    rs.getInt("au_altura"),
                    rs.getInt("au_ancho"),
                    rs.getInt("au_largo"));
            nuevoAuto.setId(rs.getInt("au_id"));
            nuevoAuto.setDescripcion(rs.getString("au_equipamiento"));
            nuevoAuto.setPrecio(rs.getDouble("au_precio"));
            autos.add(nuevoAuto);
        }
        
        stmtConsulta.close();        
        return autos;
    }

}
