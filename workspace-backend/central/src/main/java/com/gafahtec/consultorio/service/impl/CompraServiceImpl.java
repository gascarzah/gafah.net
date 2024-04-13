package com.gafahtec.consultorio.service.impl;

import java.util.UUID;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

import com.gafahtec.consultorio.dto.CompraDto;
import com.gafahtec.consultorio.model.Compra;
import com.gafahtec.consultorio.model.Insumo;
import com.gafahtec.consultorio.repository.ICompraDetalleRepository;
import com.gafahtec.consultorio.repository.ICompraRepository;
import com.gafahtec.consultorio.repository.IGenericRepository;
import com.gafahtec.consultorio.repository.IInsumoRepository;
import com.gafahtec.consultorio.service.ICompraService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CompraServiceImpl extends CRUDImpl<Compra, Integer> implements ICompraService {

	private ICompraRepository repo;
	private ICompraDetalleRepository detRepo;
	private IInsumoRepository repoInsumo;

	@Override
	protected IGenericRepository<Compra, Integer> getRepo() {

		return repo;
	}

	@Transactional
	@Override
	public Compra registrarTransaccional(@Valid CompraDto dto) {
		String randomId = UUID.randomUUID().toString();
		dto.getCompra().setRandomId(randomId);

		repo.save(dto.getCompra());

		Compra p = repo.findByRandomId(randomId).get(0);

		dto.getCompraDetalles().forEach(pd -> {

			pd.setCompra(p);
			detRepo.save(pd);

			Insumo insumo = pd.getInsumo();

			int stock = ObjectUtils.defaultIfNull(insumo.getStockMinimo(), 0) + pd.getCantidad();
//			System.out.println(stock);
			repoInsumo.actualizar(pd.getInsumo().getIdInsumo(), stock);

		});

		return p;
	}

}
