package net.gafah.microservicios.programaciones.service.impl;

import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import net.gafah.microservicios.commons.microservicios.services.CommonServiceImpl;
import net.gafah.microservicios.programaciones.dto.ProgramacionResponse;
import net.gafah.microservicios.programaciones.model.Programacion;
import net.gafah.microservicios.programaciones.repository.IProgramacionRepository;
import net.gafah.microservicios.programaciones.service.IProgramacionService;

@AllArgsConstructor
@Service
@Transactional
public class ProgramacionServiceImpl  extends CommonServiceImpl<Programacion, IProgramacionRepository> implements IProgramacionService {

	
	private IProgramacionRepository iProgramacionRepository;




	@Override
	public Set<Programacion> listarPorRango(String rango) {
		return iProgramacionRepository.findByRango(rango);
	}





  


    @Override
    public Page<Programacion> listarProgramacionPageable(Integer idEmpresa, Pageable pageable) {
        // TODO Auto-generated method stub
        return iProgramacionRepository.listarProgramacionPageable(idEmpresa,pageable);
    }




	@Override
	public Set<Programacion> programacionActivo() {

		return iProgramacionRepository.findByActivo(true);
	}
}
