package com.gafahtec.consultorio.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gafahtec.consultorio.model.Pedido;
import com.gafahtec.consultorio.model.PedidoDetalle;
import com.gafahtec.consultorio.repository.IGenericRepository;
import com.gafahtec.consultorio.repository.IPedidoDetalleRepository;
import com.gafahtec.consultorio.service.IPedidoDetalleService;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class PedidoDetalleServiceImpl  extends CRUDImpl<PedidoDetalle, Integer>  implements IPedidoDetalleService {

	
	private IPedidoDetalleRepository repo;
	
	@Override
	protected IGenericRepository<PedidoDetalle, Integer> getRepo() {
		
		return repo;
	}

	@Override
	public List<PedidoDetalle> listarPedidoDetallePorPedido(Integer id) {
		
		return repo.findByPedido(Pedido.builder().idPedido(id).build());
	}
}

