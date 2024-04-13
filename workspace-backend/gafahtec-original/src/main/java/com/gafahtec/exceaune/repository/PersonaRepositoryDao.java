package com.gafahtec.exceaune.repository;

import java.util.List;

import com.gafahtec.exceaune.model.Persona;

public interface PersonaRepositoryDao {

	public List<Persona> getAlumnos(Integer anio, String seccion);
}
