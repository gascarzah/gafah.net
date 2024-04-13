package com.gafahtec.exceaune.repository;

import java.util.List;

import com.gafahtec.exceaune.model.Decada;

public interface PromocionRepositoryDao {

	
	public List<Decada> getDecadas(Integer id);
	public List<Decada> getAnios(Integer pdecada) ;
	public List<Decada> getSecciones(Integer anio);
}
