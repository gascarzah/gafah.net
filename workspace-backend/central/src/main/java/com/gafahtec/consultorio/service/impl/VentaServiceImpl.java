package com.gafahtec.consultorio.service.impl;

import java.util.UUID;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gafahtec.consultorio.dto.VentaDto;
import com.gafahtec.consultorio.model.Pedido;
import com.gafahtec.consultorio.model.Venta;
import com.gafahtec.consultorio.repository.IGenericRepository;
import com.gafahtec.consultorio.repository.IMesaRepository;
import com.gafahtec.consultorio.repository.IPedidoDetalleRepository;
import com.gafahtec.consultorio.repository.IPedidoRepository;
import com.gafahtec.consultorio.repository.IProductoRepository;
import com.gafahtec.consultorio.repository.IVentaRepository;
import com.gafahtec.consultorio.service.IVentaService;
import com.gafahtec.consultorio.socket.WebSocketService;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class VentaServiceImpl extends CRUDImpl<Venta, Integer> implements IVentaService {

	private IVentaRepository repo;
	private IPedidoRepository pedidoRepo;
	private IMesaRepository mesaRepo;
	private IProductoRepository productoRepo;
	private IPedidoDetalleRepository pedidoDetalleRepo;
	
	
	private WebSocketService webSocketService;
	
	
	@Override
	protected IGenericRepository<Venta, Integer> getRepo() {

		return repo;
	}

	@Transactional
	@Override
	public Venta registrarTransaccion(@Valid VentaDto v) {
		 if(v.getPedido().getTipoPedido().getIdTipoPedido() == 1) {
		//graba pedido
		String randomId = UUID.randomUUID().toString();
		v.getPedido().setRandomId(randomId);
		v.getPedido().setPagado(true);
		pedidoRepo.save(v.getPedido());

		Pedido newPedido = pedidoRepo.findByRandomId(randomId).get(0);
	
		//graba pedido detalle
		v.getPedidoDetalles().forEach( pdt -> {
		pdt.setPedido(newPedido);
		pedidoDetalleRepo.save(pdt);
		});
		
		//graba venta
		v.getVenta().setPedido(newPedido);
		repo.save(v.getVenta());
		
		//actualizando producto
		v.getProductos().forEach(p -> {
			productoRepo.actualizar(p.getIdProducto(), p.getStock());
		});
		// Notify frontend that there has been a change on entity
       notifyFrontend();
		 }

		
       if(v.getPedido().getTipoPedido().getIdTipoPedido() == 2) {
    	repo.save(v.getVenta());
		v.getPedido().setPagado(true);
		pedidoRepo.actualizar(v.getPedido().getIdPedido());

		v.getPedido().getMesas().forEach(mesa -> {
			mesaRepo.actualizar(mesa.getIdMesa(), false);
		});
       }
		return v.getVenta();
	}
	
	
	
    protected String getEntityTopic() {
        return "venta";
    }

    private void notifyFrontend() {
        final String entityTopic = getEntityTopic();
        if (entityTopic == null) {
            System.out.println("Failed to get entity topic");
            return;
        }

//        webSocketService.sendMessage(entityTopic);
    }
    
    
	@Override
	public Page<Venta> listarPageable(Pageable pageable) {
		// TODO Auto-generated method stub
		return repo.findAll(pageable);
	}
}
