package com.gafahtec.consultorio.service.impl;

import org.springframework.stereotype.Service;

import com.gafahtec.consultorio.model.Unidad;
import com.gafahtec.consultorio.repository.IGenericRepository;
import com.gafahtec.consultorio.repository.IUnidadRepository;
import com.gafahtec.consultorio.service.IUnidadService;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class UnidadServiceImpl  extends CRUDImpl<Unidad, Integer>  implements IUnidadService {

	
	private IUnidadRepository repo;
	
	@Override
	protected IGenericRepository<Unidad, Integer> getRepo() {
		
		return repo;
	}
}

