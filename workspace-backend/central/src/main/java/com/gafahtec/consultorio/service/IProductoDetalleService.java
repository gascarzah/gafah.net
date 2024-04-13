package com.gafahtec.consultorio.service;

import java.util.List;

import com.gafahtec.consultorio.model.Producto;
import com.gafahtec.consultorio.model.ProductoDetalle;

public interface IProductoDetalleService extends ICRUD<ProductoDetalle, Integer>{

	List<ProductoDetalle> listarPorProductoId(Producto producto);
}
