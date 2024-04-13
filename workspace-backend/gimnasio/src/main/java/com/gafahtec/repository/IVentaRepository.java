package com.gafahtec.repository;

import java.util.List;

import com.gafahtec.model.Venta;

public interface IVentaRepository extends IGenericRepository<Venta, Integer>{

	List<Venta> findByRandomId(String randomId);

}
