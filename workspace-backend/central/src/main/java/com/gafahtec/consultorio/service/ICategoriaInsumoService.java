package com.gafahtec.consultorio.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.gafahtec.consultorio.model.CategoriaInsumo;

public interface ICategoriaInsumoService extends ICRUD<CategoriaInsumo, Integer>{

	Page<CategoriaInsumo> listarPageable(Pageable pageable);

}
