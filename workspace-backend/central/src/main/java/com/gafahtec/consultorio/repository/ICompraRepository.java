package com.gafahtec.consultorio.repository;

import java.util.List;

import com.gafahtec.consultorio.model.Compra;

public interface ICompraRepository extends IGenericRepository<Compra, Integer>{

	List<Compra> findByRandomId(String randomId);
	
	
}
