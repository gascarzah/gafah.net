package com.gafahtec.consultorio.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gafahtec.consultorio.model.Proveedor;
import com.gafahtec.consultorio.repository.IGenericRepository;
import com.gafahtec.consultorio.repository.IProveedorRepository;
import com.gafahtec.consultorio.service.IProveedorService;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class ProveedorServiceImpl  extends CRUDImpl<Proveedor, Integer>  implements IProveedorService {

	
	private IProveedorRepository repo;
	
	@Override
	protected IGenericRepository<Proveedor, Integer> getRepo() {
		
		return repo;
	}
	
	@Override
	public Page<Proveedor> listarPageable(Pageable pageable) {
		return repo.findAll(pageable);
	}
}
