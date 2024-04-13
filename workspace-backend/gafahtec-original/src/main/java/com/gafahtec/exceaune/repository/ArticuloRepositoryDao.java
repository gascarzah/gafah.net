package com.gafahtec.exceaune.repository;

import java.util.List;

import com.gafahtec.exceaune.model.Articulo;

public interface ArticuloRepositoryDao {

	public List<Articulo> getArticuloDet(Integer id);
	public List<Articulo> get3primerosArticulos(Integer id);
	public List<Articulo> getAllArticulos(Integer id);
	
}
