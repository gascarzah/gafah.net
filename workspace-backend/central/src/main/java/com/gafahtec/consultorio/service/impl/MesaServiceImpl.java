package com.gafahtec.consultorio.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gafahtec.consultorio.model.Mesa;
import com.gafahtec.consultorio.repository.IGenericRepository;
import com.gafahtec.consultorio.repository.IMesaRepository;
import com.gafahtec.consultorio.service.IMesaService;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class MesaServiceImpl  extends CRUDImpl<Mesa, Integer>  implements IMesaService {

	
	private IMesaRepository repo;
	
	@Override
	protected IGenericRepository<Mesa, Integer> getRepo() {
		
		return repo;
	}

	@Override
	public Page<Mesa> listarPageable(Pageable pageable) {
		return repo.findAll(pageable);
	}

	@Override
	public List<Mesa> listarMesasDesocupadas() {
//		System.out.println("lista");
		System.out.println(repo.findByOcupado(false));
		
		return repo.findByOcupado(false);
	}
}
