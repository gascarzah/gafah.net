package com.gafahtec.consultorio.service.impl;

import com.gafahtec.consultorio.model.Cupo;
import com.gafahtec.consultorio.repository.ICupoRepository;
import com.gafahtec.consultorio.repository.IGenericRepository;
import com.gafahtec.consultorio.service.ICupoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CupoServiceImpl extends CRUDImpl<Cupo, Integer>  implements ICupoService {

	
	private ICupoRepository repo;
	
	@Override
	protected IGenericRepository<Cupo, Integer> getRepo() {
		
		return repo;
	}




}
