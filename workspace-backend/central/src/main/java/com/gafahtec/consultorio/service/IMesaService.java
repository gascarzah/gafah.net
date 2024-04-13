package com.gafahtec.consultorio.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.gafahtec.consultorio.model.Mesa;

public interface IMesaService extends ICRUD<Mesa, Integer>{

	Page<Mesa> listarPageable(Pageable pageable);

	List<Mesa> listarMesasDesocupadas();
}
