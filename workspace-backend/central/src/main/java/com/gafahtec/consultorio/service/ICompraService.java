package com.gafahtec.consultorio.service;

import javax.validation.Valid;

import com.gafahtec.consultorio.dto.CompraDto;
import com.gafahtec.consultorio.model.Compra;

public interface ICompraService extends ICRUD<Compra, Integer>{

	Compra registrarTransaccional(@Valid CompraDto dto);

}
