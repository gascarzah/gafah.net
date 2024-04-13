package net.gafah.microservicios.antecedentes.medicos.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.gafah.microservicios.antecedentes.medicos.model.AntecedenteMedico;
import net.gafah.microservicios.commons.microservicios.repository.IGenericRepository;


@Repository
public interface IAntecedenteMedicoRepository extends IGenericRepository<AntecedenteMedico,Integer>{
	
	
	List<AntecedenteMedico> findByNumeroDocumento(Integer numeroDocumento);

}
