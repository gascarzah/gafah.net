package com.gafahtec.consultorio.service.impl;

import org.springframework.stereotype.Service;

import com.gafahtec.consultorio.model.TipoRecibo;
import com.gafahtec.consultorio.repository.IGenericRepository;
import com.gafahtec.consultorio.repository.ITipoRecibo;
import com.gafahtec.consultorio.service.ITipoReciboService;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class TipoReciboServiceImpl  extends CRUDImpl<TipoRecibo, Integer>  implements ITipoReciboService {

	
	private ITipoRecibo repo;
	
	@Override
	protected IGenericRepository<TipoRecibo, Integer> getRepo() {
		
		return repo;
	}
}

