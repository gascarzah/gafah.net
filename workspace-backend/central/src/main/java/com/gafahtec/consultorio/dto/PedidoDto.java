package com.gafahtec.consultorio.dto;

import java.util.List;

import com.gafahtec.consultorio.model.Mesa;
import com.gafahtec.consultorio.model.Pedido;
import com.gafahtec.consultorio.model.PedidoDetalle;

import lombok.Data;
@Data
public class PedidoDto {

	private Pedido pedido;
	private List<PedidoDetalle> pedidoDetalles;
	private List<Mesa> mesas;
}
