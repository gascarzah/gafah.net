package com.gafahtec.consultorio.service.impl;

import org.springframework.stereotype.Service;

import com.gafahtec.consultorio.model.Estado;
import com.gafahtec.consultorio.repository.IEstadoRepository;
import com.gafahtec.consultorio.repository.IGenericRepository;
import com.gafahtec.consultorio.service.IEstadoService;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class EstadoServiceImpl  extends CRUDImpl<Estado, Integer>  implements IEstadoService {

	
	private IEstadoRepository repo;
	
	@Override
	protected IGenericRepository<Estado, Integer> getRepo() {
		
		return repo;
	}
}
