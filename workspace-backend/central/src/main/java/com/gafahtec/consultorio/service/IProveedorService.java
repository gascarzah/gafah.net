package com.gafahtec.consultorio.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.gafahtec.consultorio.model.Proveedor;

public interface IProveedorService extends ICRUD<Proveedor, Integer>{

	Page<Proveedor> listarPageable(Pageable pageable);

}
