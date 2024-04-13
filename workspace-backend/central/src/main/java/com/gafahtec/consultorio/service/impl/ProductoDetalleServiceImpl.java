package com.gafahtec.consultorio.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gafahtec.consultorio.model.Producto;
import com.gafahtec.consultorio.model.ProductoDetalle;
import com.gafahtec.consultorio.repository.IGenericRepository;
import com.gafahtec.consultorio.repository.IProductoDetalleRepository;
import com.gafahtec.consultorio.service.IProductoDetalleService;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class ProductoDetalleServiceImpl  extends CRUDImpl<ProductoDetalle, Integer>  implements IProductoDetalleService {

	
	private IProductoDetalleRepository repo;
	
	@Override
	protected IGenericRepository<ProductoDetalle, Integer> getRepo() {
		
		return repo;
	}

	@Override
	public List<ProductoDetalle> listarPorProductoId(Producto producto) {
		return repo.findByProducto(producto);
	}
}

