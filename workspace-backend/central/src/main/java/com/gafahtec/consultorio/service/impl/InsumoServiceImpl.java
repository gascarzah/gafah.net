package com.gafahtec.consultorio.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gafahtec.consultorio.model.Insumo;
import com.gafahtec.consultorio.repository.IGenericRepository;
import com.gafahtec.consultorio.repository.IInsumoRepository;
import com.gafahtec.consultorio.service.IInsumoService;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class InsumoServiceImpl  extends CRUDImpl<Insumo, Integer>  implements IInsumoService {

	
	private IInsumoRepository repo;
	
	@Override
	protected IGenericRepository<Insumo, Integer> getRepo() {
		
		return repo;
	}

	@Override
	public Page<Insumo> listarPageable(Pageable pageable) {
		return repo.findAll(pageable);
	}
}
