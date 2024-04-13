package com.gafahtec.consultorio.service.impl;

import org.springframework.stereotype.Service;

import com.gafahtec.consultorio.model.Destino;
import com.gafahtec.consultorio.repository.IDestinoRepository;
import com.gafahtec.consultorio.repository.IGenericRepository;
import com.gafahtec.consultorio.service.IDestinoService;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class DestinoServiceImpl  extends CRUDImpl<Destino, Integer>  implements IDestinoService {

	
	private IDestinoRepository repo;
	
	@Override
	protected IGenericRepository<Destino, Integer> getRepo() {
		
		return repo;
	}
}
