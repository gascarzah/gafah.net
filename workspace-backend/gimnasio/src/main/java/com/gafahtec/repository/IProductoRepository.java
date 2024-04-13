package com.gafahtec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.gafahtec.model.Producto;

public interface IProductoRepository extends IGenericRepository<Producto, Integer>{
	
//	 @Query("SELECT p FROM Producto p where p.randomId = :randomId")
//	    Producto findByRandomId(@Param("randomId")String randomId);
//	List<Producto> findByRandomId(String randomId);
//	
//	@Query("SELECT p FROM Producto p where p.categoriaProducto.idCategoriaProducto = :idCategoriaProducto")
//	List<Producto> findByCategoriaProducto(Integer idCategoriaProducto);
}
