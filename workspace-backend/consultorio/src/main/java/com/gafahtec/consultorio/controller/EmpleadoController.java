package com.gafahtec.consultorio.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gafahtec.consultorio.dto.request.EmpleadoRequest;
import com.gafahtec.consultorio.exception.ResourceNotFoundException;
import com.gafahtec.consultorio.model.Empleado;
import com.gafahtec.consultorio.service.IEmpleadoService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@RestController
@RequestMapping("/empleados")
@AllArgsConstructor
@Slf4j
public class EmpleadoController {

	private IEmpleadoService iEmpleadoService;
	
	@GetMapping(value="/medicos/{tipoEmpleado}")
	public ResponseEntity<List<Empleado>> listar(@PathVariable("tipoEmpleado") Integer tipoEmpleado) throws Exception{
		List<Empleado> lista = iEmpleadoService.listar(tipoEmpleado);
		if (lista.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
		return new ResponseEntity<List<Empleado>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Empleado> listarPorId(@PathVariable("id") Integer id) throws Exception{
		Empleado obj = iEmpleadoService.listarPorId(id);
		
		if(obj.getIdEmpleado() == null) {
		    throw new ResourceNotFoundException("Id no encontrado " + id);
		}
		
		return new ResponseEntity<Empleado>(obj, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Empleado> registrar(@Valid @RequestBody EmpleadoRequest EmpleadoRequest) throws Exception{
		Empleado Empleado = new Empleado();
		BeanUtils.copyProperties(Empleado, EmpleadoRequest);
		Empleado obj = iEmpleadoService.registrar(Empleado);
//		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdEmpleado()).toUri();
		log.info("Empleado creado "+ obj);
		 return new ResponseEntity<>(obj, HttpStatus.CREATED);
	}



	@PutMapping
	public ResponseEntity<Empleado> modificar(@Valid @RequestBody EmpleadoRequest EmpleadoRequest) throws Exception{
		Empleado Empleado = new Empleado();
		BeanUtils.copyProperties(Empleado, EmpleadoRequest);
		Empleado obj = iEmpleadoService.modificar(Empleado);
		log.info("Empleado modificado "+ obj);
		return new ResponseEntity<Empleado>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception{
		Empleado obj = iEmpleadoService.listarPorId(id);
		
		if(obj.getIdEmpleado() == null) {
			throw new ResourceNotFoundException("ID NO ENCONTRADO "+id);
		}
			
		iEmpleadoService.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/pageable")
	public ResponseEntity<Page<Empleado>> listarPageable(@PageableDefault(sort = "apellidoPaterno")Pageable pageable) throws Exception{			
		Page<Empleado> paginas = iEmpleadoService.listarPageable(pageable);
		if (paginas.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
		return new ResponseEntity<Page<Empleado>>(paginas, HttpStatus.OK);
	}
}
