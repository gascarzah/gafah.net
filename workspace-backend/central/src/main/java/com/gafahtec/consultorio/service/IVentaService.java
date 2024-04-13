package com.gafahtec.consultorio.service;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.gafahtec.consultorio.dto.VentaDto;
import com.gafahtec.consultorio.model.Venta;

public interface IVentaService extends ICRUD<Venta, Integer>{

	Venta registrarTransaccion(@Valid VentaDto p);
	Page<Venta> listarPageable(Pageable pageable);
}
