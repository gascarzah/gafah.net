package com.gafahtec.consultorio.service.impl;

import org.springframework.stereotype.Service;

import com.gafahtec.consultorio.model.Caja;
import com.gafahtec.consultorio.repository.ICajaRepository;
import com.gafahtec.consultorio.repository.IGenericRepository;
import com.gafahtec.consultorio.service.ICajaService;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class CajaServiceImpl extends CRUDImpl<Caja, Integer>  implements ICajaService {

	
	private ICajaRepository repo;
	
	@Override
	protected IGenericRepository<Caja, Integer> getRepo() {
		
		return repo;
	}
}
