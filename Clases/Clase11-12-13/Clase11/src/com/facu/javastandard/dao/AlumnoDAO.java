package com.facu.javastandard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.facu.javastandard.entities.Alumno;

public class AlumnoDAO implements IPersistenceDAO {

	private Connection conn;

	public AlumnoDAO(Connection conn) {
		this.conn = conn;
	}
	
	public boolean save(Alumno alumno) { 
		
		String sql = "insert into alumnos (nombre,apellido,edad,curso)"
				+ "values(?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql,1);
			ps.setString(1, alumno.getNombre());
			ps.setString(2, alumno.getApellido());
			ps.setInt(3, alumno.getEdad());
			ps.setInt(4, alumno.getCurso());
			
			if(ps.executeUpdate() > 0) { 
				ResultSet rs = ps.getGeneratedKeys();
				if(rs.next()) { 
					alumno.setId(rs.getInt(1));
				} 
				ps.close();
				return true;
			} else {
				ps.close();
				return false;
			}
			
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
		
	}

	@Override
	public boolean update(Alumno a) {
		if(a == null) {
			return false;
		}
		
		String sql="update alumnos set nombre=?, apellido=?," + 
				"edad=?, curso=? where id=?";
		
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, a.getNombre());
			ps.setString(2, a.getApellido());
			ps.setInt(3, a.getEdad());
			ps.setInt(4, a.getCurso());
			ps.setInt(5, a.getId());
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public Alumno getById(int id) {
		Alumno alumno = null;
		String sql = "select * from alumnos where id=" + id;
		ResultSet rs;
		try {
			rs = conn.createStatement().executeQuery(sql);
			if(rs.next()) { 
				alumno = new Alumno(
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

	@Override
	public boolean delete(Alumno a) {
		if(a == null) {
			return false;
		}
		String sql = "delete from alumnos where id=" + a.getId();
		try {
			return conn.createStatement().executeUpdate(sql) > 0;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public List<Alumno> getAll() {
		return this.getByFiltro("1=1");
	}
	
	public List<Alumno> getByFiltro(String filtro) {
		String sql = "select * from alumnos where " + filtro;
		List<Alumno> lista = new ArrayList<Alumno>();
		
		ResultSet rs;
		try {
			rs = conn.createStatement().executeQuery(sql);
			
			while(rs.next()) { 
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
	
	public List<Alumno> getByApellido(String apellido) { 
		return this.getByFiltro("apellido = '" + apellido + "'");
	}
}
