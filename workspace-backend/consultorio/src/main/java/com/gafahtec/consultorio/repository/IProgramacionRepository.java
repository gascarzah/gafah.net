package com.gafahtec.consultorio.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gafahtec.consultorio.model.Programacion;

@Repository
public interface IProgramacionRepository extends IGenericRepository<Programacion,Integer>{

    List<Programacion> findByRango(String rango);
    
    List<Programacion> findByEstado(Integer estado);
    
    
}
