package com.gafahtec.consultorio.controller;

import com.gafahtec.consultorio.dto.request.ProgramacionRequest;
import com.gafahtec.consultorio.exception.ResourceNotFoundException;
import com.gafahtec.consultorio.model.Programacion;
import com.gafahtec.consultorio.model.ProgramacionDetalle;
import com.gafahtec.consultorio.service.ICitaService;
import com.gafahtec.consultorio.service.IProgramacionDetalleService;
import com.gafahtec.consultorio.service.IProgramacionService;
import com.gafahtec.consultorio.util.Utils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
@RestController
@RequestMapping("/programaciones")
@AllArgsConstructor
@Slf4j
public class ProgramacionController {

	private IProgramacionService iProgramacionService;
	
	private IProgramacionDetalleService iProgramacionDetalleService;
	
	private ICitaService iCitaService;
	
	@GetMapping
	public ResponseEntity<List<Programacion>> listar() throws Exception{
		List<Programacion> lista = iProgramacionService.listar();
		if (lista.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
		return new ResponseEntity<List<Programacion>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Programacion> listarPorId(@PathVariable("id") Integer id) throws Exception{
		Programacion obj = iProgramacionService.listarPorId(id);
		
		if(obj.getIdProgramacion() == null) {
		    throw new ResourceNotFoundException("Id no encontrado " + id);
		}
		
		return new ResponseEntity<Programacion>(obj, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Programacion> registrar(@Valid @RequestBody ProgramacionRequest programacionRequest) throws Exception{

	    String strFechaInicial = Utils.getFecha2String(programacionRequest.getFechaInicial());
        String strFechaFinal = Utils.getFecha2String(programacionRequest.getFechaFinal());
	    
		String rango = strFechaInicial + " - " + strFechaFinal;
		List<Programacion> programacionList = iProgramacionService.listarPorRango(rango);
		Programacion obj = null;
		if(programacionList.isEmpty()) {
			Programacion programacion = new Programacion();
			BeanUtils.copyProperties(programacion, programacionRequest);
			programacion.setRango(rango);
			programacion.setEstado(0);
			programacion.setStrFechaFinal(strFechaFinal);
			programacion.setStrFechaInicial(strFechaInicial);
			obj = iProgramacionService.registrar(programacion);
		}else{
			obj = programacionList.get(0);
		}


			log.info("resultado : ", obj);
			if (obj != null) {
			    
			    List<ProgramacionDetalle> existeProgramacionMedico = iProgramacionDetalleService.getProgramacionMedico(obj.getIdProgramacion(), programacionRequest.getIdMedico());
			    
			    if(existeProgramacionMedico.isEmpty()) {
			    
			    List<ProgramacionDetalle> list = iProgramacionDetalleService.generarProgramacionDetalle(obj, programacionRequest);
			    
			    iCitaService.registrarCupos(list);
			   
			    
				URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdProgramacion()).toUri();
				return ResponseEntity.created(location).build();
			    }else {
			        log.info("Ya existe programacion vinculada a esta semana");
			        throw new ResourceNotFoundException("Ya existe programacion vinculada a esta semana");
			    }
			}
			 return new ResponseEntity<>(obj, HttpStatus.CREATED);



	}
	
	@PutMapping
	public ResponseEntity<Programacion> modificar(@Valid @RequestBody Programacion p) throws Exception{
		Programacion obj = iProgramacionService.modificar(p);
		return new ResponseEntity<Programacion>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception{
		Programacion obj = iProgramacionService.listarPorId(id);
		
		if(obj.getIdProgramacion() == null) {
			throw new ResourceNotFoundException("ID NO ENCONTRADO "+id);
		}
			
		iProgramacionService.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
