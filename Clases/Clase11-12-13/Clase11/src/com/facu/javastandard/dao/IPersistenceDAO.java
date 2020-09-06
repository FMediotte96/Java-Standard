package com.facu.javastandard.dao;

import java.util.List;

import com.facu.javastandard.entities.Alumno;

public interface IPersistenceDAO {
	
	boolean save(Alumno a);
	boolean update(Alumno a);
	Alumno getById(int id);
	boolean delete(Alumno a);
	List<Alumno> getAll();
	
}
