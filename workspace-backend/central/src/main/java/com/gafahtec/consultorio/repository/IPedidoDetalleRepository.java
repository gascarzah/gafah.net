package com.gafahtec.consultorio.repository;

import java.util.List;

import com.gafahtec.consultorio.model.Pedido;
import com.gafahtec.consultorio.model.PedidoDetalle;

public interface IPedidoDetalleRepository extends IGenericRepository<PedidoDetalle, Integer>{
	
	List<PedidoDetalle> findByPedido(Pedido pedido);

}
