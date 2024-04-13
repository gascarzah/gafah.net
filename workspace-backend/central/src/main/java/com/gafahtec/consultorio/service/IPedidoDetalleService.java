package com.gafahtec.consultorio.service;

import java.util.List;

import com.gafahtec.consultorio.model.PedidoDetalle;

public interface IPedidoDetalleService extends ICRUD<PedidoDetalle, Integer>{

	List<PedidoDetalle> listarPedidoDetallePorPedido(Integer id);

}
