package com.gafahtec.consultorio.service.impl;

import org.springframework.stereotype.Service;

import com.gafahtec.consultorio.model.Medida;
import com.gafahtec.consultorio.repository.IGenericRepository;
import com.gafahtec.consultorio.repository.IMedidaRepository;
import com.gafahtec.consultorio.service.IMedidaService;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class MedidaServiceImpl  extends CRUDImpl<Medida, Integer>  implements IMedidaService {

	
	private IMedidaRepository repo;
	
	@Override
	protected IGenericRepository<Medida, Integer> getRepo() {
		
		return repo;
	}
}
