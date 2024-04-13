package com.gafahtec.service.impl;

import java.util.UUID;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gafahtec.dto.VentaDto;
import com.gafahtec.model.Venta;
import com.gafahtec.repository.IGenericRepository;
import com.gafahtec.repository.IVentaDetalleRepository;
import com.gafahtec.repository.IVentaRepository;
import com.gafahtec.service.IVentaService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class VentaServiceImpl extends CRUDImpl<Venta, Integer> implements IVentaService {

	private IVentaRepository repo;
	private IVentaDetalleRepository ventaDetallerepo;


	@Override
	protected IGenericRepository<Venta, Integer> getRepo() {

		return repo;
	}

	@Transactional
	@Override
	public Venta registrarTransaccion(@Valid VentaDto dto) {
		
		String randomId = UUID.randomUUID().toString();
		dto.getVenta().setRandomId(randomId);
		
		repo.save(dto.getVenta());

		Venta ventaSaved = repo.findByRandomId(randomId).get(0);
		
		dto.getVentaDetalle().forEach(vdt -> {
			vdt.setVenta(ventaSaved);
			ventaDetallerepo.save(vdt);
		});
	    

		return dto.getVenta();
	}

	@Override
	public Page<Venta> listarPageable(Pageable pageable) {
		// TODO Auto-generated method stub
		return repo.findAll(pageable);
	}
}
