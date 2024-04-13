package com.gafahtec.dto;

import java.util.List;

import com.gafahtec.model.Venta;
import com.gafahtec.model.VentaDetalle;

import lombok.Data;
@Data
public class VentaDto {

	private Venta venta;
	private List<VentaDetalle> ventaDetalle;
//	private List<Mesa> mesas;
}
