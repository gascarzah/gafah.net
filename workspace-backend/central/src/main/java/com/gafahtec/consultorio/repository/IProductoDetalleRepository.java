package com.gafahtec.consultorio.repository;

import java.util.List;

import com.gafahtec.consultorio.model.Producto;
import com.gafahtec.consultorio.model.ProductoDetalle;

public interface IProductoDetalleRepository extends IGenericRepository<ProductoDetalle, Integer>{

	List<ProductoDetalle> findByProducto(Producto producto);
}
