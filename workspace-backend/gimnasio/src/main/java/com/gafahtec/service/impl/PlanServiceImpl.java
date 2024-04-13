package com.gafahtec.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gafahtec.model.Plan;
import com.gafahtec.repository.IGenericRepository;
import com.gafahtec.repository.IPlanRepository;
import com.gafahtec.service.IPlanService;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class PlanServiceImpl  extends CRUDImpl<Plan, Integer>  implements IPlanService {

	
	private IPlanRepository repo;
	
	@Override
	protected IGenericRepository<Plan, Integer> getRepo() {
		
		return repo;
	}
	
	@Override
	public Page<Plan> listarPageable(Pageable pageable) {
		return repo.findAll(pageable);
	}
	
	
//	@Override
//	public List<Plan> listarOrderNombre() {		
//		return repo.findAll(Sort.by("apellidoPaterno"));
//	}
}

