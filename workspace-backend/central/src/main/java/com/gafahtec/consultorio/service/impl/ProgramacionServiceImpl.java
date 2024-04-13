package com.gafahtec.consultorio.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gafahtec.consultorio.model.Programacion;
import com.gafahtec.consultorio.repository.IGenericRepository;
import com.gafahtec.consultorio.repository.IProgramacionRepository;
import com.gafahtec.consultorio.service.IProgramacionService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service

public class ProgramacionServiceImpl extends CRUDImpl<Programacion, Integer>  implements IProgramacionService {

	
	private IProgramacionRepository repo;

//	private IProgramacionDetalleService iProgramacionDetalleService;

	@Override
	protected IGenericRepository<Programacion, Integer> getRepo() {
		
		return repo;
	}


	@Override
	public List<Programacion> listarPorRango(String rango) {
		return repo.findByRango(rango);
	}


    @Override
    public List<Programacion> programacionActiva(Integer b) {
        // TODO Auto-generated method stub
        return repo.findByEstado(b);
    }


}
