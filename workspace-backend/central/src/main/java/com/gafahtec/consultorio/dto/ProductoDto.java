package com.gafahtec.consultorio.dto;

import java.util.List;

import com.gafahtec.consultorio.model.Producto;
import com.gafahtec.consultorio.model.ProductoDetalle;

import lombok.Data;

@Data
public class ProductoDto {

	private Producto producto;
	private List<ProductoDetalle> productoDetalles;
}
