package com.gafahtec.consultorio.service.impl;

import org.springframework.stereotype.Service;

import com.gafahtec.consultorio.model.Rol;
import com.gafahtec.consultorio.repository.IGenericRepository;
import com.gafahtec.consultorio.repository.IRolRepository;
import com.gafahtec.consultorio.service.IRolService;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class RolServiceImpl extends CRUDImpl<Rol, Integer>  implements IRolService {

	
	private IRolRepository repo;
	
	@Override
	protected IGenericRepository<Rol, Integer> getRepo() {
		
		return repo;
	}
}
