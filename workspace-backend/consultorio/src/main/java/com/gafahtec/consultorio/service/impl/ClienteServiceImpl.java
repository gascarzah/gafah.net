package com.gafahtec.consultorio.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gafahtec.consultorio.model.Cliente;
import com.gafahtec.consultorio.repository.IGenericRepository;
import com.gafahtec.consultorio.repository.IClienteRepository;
import com.gafahtec.consultorio.service.IClienteService;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class ClienteServiceImpl extends CRUDImpl<Cliente, Integer>  implements IClienteService {

	
	private IClienteRepository repo;
	
	@Override
	protected IGenericRepository<Cliente, Integer> getRepo() {
		
		return repo;
	}
	
	@Override
	public Page<Cliente> listarPageable(Pageable pageable) {
		return repo.findAll(pageable);
	}
}
