package net.gafah.microservicios.programaciones.medicos.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.gafah.microservicios.commons.microservicios.services.CommonServiceImpl;
import net.gafah.microservicios.programaciones.medicos.model.ProgramacionDetalle;
import net.gafah.microservicios.programaciones.medicos.repository.IProgramacionDetalleRepository;

@AllArgsConstructor
@Service
@Log4j2
@Transactional
public class ProgramacionDetalleServiceImpl extends CommonServiceImpl<ProgramacionDetalle, IProgramacionDetalleRepository> implements IProgramacionDetalleService{



}
