package net.gafah.microservicios.programaciones.medicos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.gafah.microservicios.commons.microservicios.controllers.CommonController;
import net.gafah.microservicios.programaciones.medicos.model.ProgramacionDetalle;
import net.gafah.microservicios.programaciones.medicos.service.IProgramacionDetalleService;

@RestController
@RequestMapping("/programacionesDetalladas")
@AllArgsConstructor
@Log4j2
public class ProgramacionDetalleController extends CommonController<ProgramacionDetalle, IProgramacionDetalleService>{




}
