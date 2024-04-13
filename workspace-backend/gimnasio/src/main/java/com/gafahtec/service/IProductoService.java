package com.gafahtec.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.gafahtec.model.Producto;

public interface IProductoService extends ICRUD<Producto, Integer>{

	Page<Producto> listarPageable(Pageable pageable);
	

	public List<Producto> listarOrderNombre();


//	public List<Producto> listarPorCategoria(Integer idCategoriaProducto);

	

//	Producto registrarYObtener(@Valid ProductoDto p);


}
