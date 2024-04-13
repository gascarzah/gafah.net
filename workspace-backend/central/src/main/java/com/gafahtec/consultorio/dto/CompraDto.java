package com.gafahtec.consultorio.dto;

import java.util.List;

import com.gafahtec.consultorio.model.Compra;
import com.gafahtec.consultorio.model.CompraDetalle;

import lombok.Data;
@Data
public class CompraDto {
	private Compra compra;
	private List<CompraDetalle> compraDetalles;
}
