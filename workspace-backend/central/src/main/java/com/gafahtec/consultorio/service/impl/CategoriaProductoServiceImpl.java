package com.gafahtec.consultorio.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gafahtec.consultorio.model.CategoriaProducto;
import com.gafahtec.consultorio.repository.ICategoriaProductoRepository;
import com.gafahtec.consultorio.repository.IGenericRepository;
import com.gafahtec.consultorio.service.ICategoriaProductoService;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class CategoriaProductoServiceImpl  extends CRUDImpl<CategoriaProducto, Integer>  implements ICategoriaProductoService {

	
	private ICategoriaProductoRepository repo;
	
	@Override
	protected IGenericRepository<CategoriaProducto, Integer> getRepo() {
		
		return repo;
	}

	@Override
	public Page<CategoriaProducto> listarPageable(Pageable pageable) {
		return repo.findAll(pageable);
	}
}

