package com.gafahtec.consultorio.service;

import java.util.List;

import com.gafahtec.consultorio.model.Programacion;


public interface IProgramacionService extends ICRUD<Programacion,Integer>{

    

    List<Programacion> listarPorRango(String rango);

    List<Programacion> programacionActiva(Integer b);
}
