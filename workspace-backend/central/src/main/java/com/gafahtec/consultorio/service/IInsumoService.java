package com.gafahtec.consultorio.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.gafahtec.consultorio.model.Insumo;

public interface IInsumoService extends ICRUD<Insumo, Integer>{

	Page<Insumo> listarPageable(Pageable pageable);

}
