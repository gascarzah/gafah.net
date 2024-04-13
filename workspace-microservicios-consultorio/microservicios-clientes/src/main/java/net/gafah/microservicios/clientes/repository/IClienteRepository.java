package net.gafah.microservicios.clientes.repository;

import org.springframework.stereotype.Repository;

import net.gafah.microservicios.clientes.model.Cliente;
import net.gafah.microservicios.commons.microservicios.repository.IGenericRepository;

@Repository
public interface IClienteRepository  extends IGenericRepository<Cliente,String>{
}
