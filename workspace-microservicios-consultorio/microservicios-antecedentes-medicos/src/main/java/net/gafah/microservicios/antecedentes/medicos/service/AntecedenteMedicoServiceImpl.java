package net.gafah.microservicios.antecedentes.medicos.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.gafah.microservicios.antecedentes.medicos.model.AntecedenteMedico;
import net.gafah.microservicios.antecedentes.medicos.repository.IAntecedenteMedicoRepository;
import net.gafah.microservicios.commons.microservicios.repository.IGenericRepository;
import net.gafah.microservicios.commons.microservicios.services.CRUDImpl;
@AllArgsConstructor
@Service
@Transactional
@Log4j2
public class AntecedenteMedicoServiceImpl extends CRUDImpl<AntecedenteMedico, Integer>  implements IAntecedenteMedicoService {

	
	private IAntecedenteMedicoRepository iAntecedenteMedicoRepository;



	@Override
	protected IGenericRepository<AntecedenteMedico, Integer> getRepo() {
		// TODO Auto-generated method stub
		return iAntecedenteMedicoRepository;
	}








}
