package com.gafahtec.consultorio.service.impl;

import org.springframework.stereotype.Service;

import com.gafahtec.consultorio.model.CompraDetalle;
import com.gafahtec.consultorio.repository.ICompraDetalleRepository;
import com.gafahtec.consultorio.repository.IGenericRepository;
import com.gafahtec.consultorio.service.ICompraDetalleService;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class CompraDetalleServiceImpl  extends CRUDImpl<CompraDetalle, Integer>  implements ICompraDetalleService {

	
	private ICompraDetalleRepository repo;
	
	@Override
	protected IGenericRepository<CompraDetalle, Integer> getRepo() {
		
		return repo;
	}
}
