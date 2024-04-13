package net.gafah.microservicios.clientes.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.gafah.microservicios.clientes.model.Cliente;
import net.gafah.microservicios.clientes.repository.IClienteRepository;
import net.gafah.microservicios.clientes.service.IClienteService;
import net.gafah.microservicios.commons.microservicios.repository.IGenericRepository;
import net.gafah.microservicios.commons.microservicios.services.CRUDImpl;
@AllArgsConstructor
@Service
@Transactional
@Log4j2
public class ClienteServiceImpl  extends CRUDImpl<Cliente, String> implements IClienteService {

	private IClienteRepository iClienteRepository;

	@Override
	protected IGenericRepository<Cliente, String> getRepo() {
		// TODO Auto-generated method stub
		return iClienteRepository;
	}


}
