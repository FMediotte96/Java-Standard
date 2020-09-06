package ar.com.eduit.curso.java.repositories;

import ar.com.eduit.curso.entities.Alumno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class AlumnoR {
    
    private Connection conn;
    
    public AlumnoR(Connection conn) {
        this.conn = conn;
    }
    
    public boolean save (Alumno alumno) {
//        String sql="insert into alumnos(nombre,apellido,edad,curso)"
//                + "values ('"+alumno.getNombre()+"','"
//                +alumno.getApellido()+"',+alumno"

        String sql="insert into alumnos (nombre,apellido,edad,curso)"
        + "values(?,?,?,?)";
        try {
            PreparedStatement ps=conn.prepareStatement(sql,1);
            ps.setString(1, alumno.getNombre());
            ps.setString(2, alumno.getApellido());
            ps.setInt(3,alumno.getEdad());
            ps.setInt(4,alumno.getCurso());
            if(ps.executeUpdate()>0){
                ResultSet rs = ps.getGeneratedKeys();
                if(rs.next())
                    alumno.setId(rs.getInt(1));
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    
    public Alumno getById(int id){
        Alumno alumno=null;
        String sql="select * from alumnos where id="+id;
        try {
            ResultSet rs=conn.createStatement().executeQuery(sql);
            if(rs.next()){
                alumno=new Alumno(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getInt("edad"),
                        rs.getInt("curso")
                );
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return alumno;
    }
    
    public boolean remove(Alumno alumno){
        if(alumno==null) return false;
        String sql="delete from alumnos where id="+alumno.getId();
        
        try {
            return conn.createStatement().executeUpdate(sql)>0;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    
    public boolean update(Alumno alumno){
        if(alumno==null) return false;
        String sql="update alumnos set nombre=?,apellido=?,"+
                   "edad=?,curso=? where id=?";
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, alumno.getNombre());
            ps.setString(2, alumno.getApellido());
            ps.setInt(3, alumno.getEdad());
            ps.setInt(4, alumno.getCurso());
            ps.setInt(5, alumno.getId());
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    
    public List<Alumno> getAll(){
        return getByFiltro("1=1");
    }
    
    public List<Alumno> getByFiltro(String filtro){
       String sql="select * from alumnos where "+filtro;
       List<Alumno> lista=new ArrayList();
       try {
           ResultSet rs=conn.createStatement().executeQuery(sql);
           while(rs.next()){
               lista.add(
                    new Alumno(
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getString("apellido"),
                            rs.getInt("edad"),
                            rs.getInt("curso")
                    )
               );
           }
           
       } catch (Exception e) {
           System.out.println(e);
       }
       return lista;
    }
    
    public List<Alumno> getByApellido(String apellido){
        return getByFiltro("apellido = '"+apellido+"'");
    }
}
