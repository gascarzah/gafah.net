package com.gafahtec.consultorio.dto;

import java.util.List;

import com.gafahtec.consultorio.model.Pedido;
import com.gafahtec.consultorio.model.PedidoDetalle;
import com.gafahtec.consultorio.model.Producto;
import com.gafahtec.consultorio.model.Venta;

import lombok.Data;

@Data
public class VentaDto {

	private Pedido pedido;
	private List<PedidoDetalle> pedidoDetalles; 
	private List<Producto> productos; 
	private Venta venta;
}
