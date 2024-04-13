package com.gafahtec.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.gafahtec.model.Plan;

public interface IPlanService extends ICRUD<Plan, Integer>{

	Page<Plan> listarPageable(Pageable pageable);
//	
//	public List<Plan> listarOrderNombre();

}
