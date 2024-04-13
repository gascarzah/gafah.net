package com.gafahtec.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.gafahtec.model.Mascota;

public interface IMascotaService extends ICRUD<Mascota, Integer>{

	Page<Mascota> listarPageable(Pageable pageable);

//	Venta registrarTransaccion(@Valid Venta p);

}
