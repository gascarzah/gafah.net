package com.gafahtec.consultorio.dto;

import com.gafahtec.consultorio.model.Pedido;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PedidoMesaDto {

	private Integer idPedido;
	private String numMesa;
	private Pedido pedido;
}
