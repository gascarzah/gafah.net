package net.gafah.microservicios.programaciones.service;

import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.gafah.microservicios.commons.microservicios.services.ICommonService;
import net.gafah.microservicios.programaciones.model.Programacion;


public interface IProgramacionService extends ICommonService<Programacion>{

    

    Set<Programacion> listarPorRango(String rango);

    

  

    Page<Programacion> listarProgramacionPageable(Integer idEmpresa,Pageable pageable);

    Set<Programacion> programacionActivo();

//    public Set<Programacion> programacionEntityActivo();
    
//    public Programacion modificarEntity(Programacion request);
}
