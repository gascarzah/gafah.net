package com.gafahtec.consultorio.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.gafahtec.consultorio.dto.ProductoDto;
import com.gafahtec.consultorio.model.Producto;

public interface IProductoService extends ICRUD<Producto, Integer>{

	Page<Producto> listarPageable(Pageable pageable);
	

	public List<Producto> listarOrderNombre();


	public List<Producto> listarPorCategoria(Integer idCategoriaProducto);

	

	Producto registrarYObtener(@Valid ProductoDto p);


}
