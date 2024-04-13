package com.gafahtec.exceaune.repository;

import java.util.List;

import com.gafahtec.exceaune.model.Foto;

public interface FotoRepositoryDao {
	public List<Foto> getFotosArticulo(Integer id);
}
