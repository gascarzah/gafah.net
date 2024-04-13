package net.gafah.microservicios.citas.service.impl;

import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.gafah.microservicios.citas.model.Cita;
import net.gafah.microservicios.citas.repository.ICitaRepository;
import net.gafah.microservicios.citas.service.ICitaService;
import net.gafah.microservicios.commons.microservicios.services.CommonServiceImpl;

@AllArgsConstructor
@Transactional
@Service
@Log4j2
public class CitaServiceImpl  extends CommonServiceImpl<Cita, ICitaRepository> implements ICitaService {



}
