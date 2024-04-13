package com.gafahtec.consultorio.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gafahtec.consultorio.model.CategoriaInsumo;
import com.gafahtec.consultorio.repository.ICategoriaInsumoRepository;
import com.gafahtec.consultorio.repository.IGenericRepository;
import com.gafahtec.consultorio.service.ICategoriaInsumoService;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class CategoriaInsumoServiceImpl  extends CRUDImpl<CategoriaInsumo, Integer>  implements ICategoriaInsumoService {

	
	private ICategoriaInsumoRepository repo;
	
	@Override
	protected IGenericRepository<CategoriaInsumo, Integer> getRepo() {
		
		return repo;
	}

	@Override
	public Page<CategoriaInsumo> listarPageable(Pageable pageable) {
		return repo.findAll(pageable);
	}
}
