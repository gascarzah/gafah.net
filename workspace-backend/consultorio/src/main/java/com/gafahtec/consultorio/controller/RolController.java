package com.gafahtec.consultorio.controller;

import com.gafahtec.consultorio.exception.ResourceNotFoundException;
import com.gafahtec.consultorio.model.Rol;
import com.gafahtec.consultorio.service.IRolService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/roles")
@AllArgsConstructor
public class RolController {

	private IRolService iRolService;
	
	@GetMapping
	public ResponseEntity<List<Rol>> listar() throws Exception{
		List<Rol> lista = iRolService.listar();
		if (lista.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
		return new ResponseEntity<List<Rol>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Rol> listarPorId(@PathVariable("id") Integer id) throws Exception{
		Rol obj = iRolService.listarPorId(id);
		
		if(obj.getIdRol() == null) {
		    throw new ResourceNotFoundException("Id no encontrado " + id);
		}
		
		return new ResponseEntity<Rol>(obj, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Rol> registrar(@Valid @RequestBody Rol p) throws Exception{
		Rol obj = iRolService.registrar(p);
//		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdRol()).toUri();
		 return new ResponseEntity<>(obj, HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Rol> modificar(@Valid @RequestBody Rol p) throws Exception{
		Rol obj = iRolService.modificar(p);
		return new ResponseEntity<Rol>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception{
		Rol obj = iRolService.listarPorId(id);
		
		if(obj.getIdRol() == null) {
			throw new ResourceNotFoundException("ID NO ENCONTRADO "+id);
		}
			
		iRolService.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
