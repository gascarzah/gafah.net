package com.gafahtec.consultorio.controller;

import com.gafahtec.consultorio.model.Tratamiento;
import com.gafahtec.consultorio.service.ITratamientoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
@RestController
@RequestMapping("/tratamientos")
@AllArgsConstructor
public class TratamientoController {

	private ITratamientoService iTratamientoService;
	
	@GetMapping
	public ResponseEntity<List<Tratamiento>> listar() throws Exception{
		List<Tratamiento> lista = iTratamientoService.listar();
		return new ResponseEntity<List<Tratamiento>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Tratamiento> listarPorId(@PathVariable("id") Integer id) throws Exception{
		Tratamiento obj = iTratamientoService.listarPorId(id);
		
		if(obj.getIdTratamiento() == null) {
			throw new RuntimeException("Id no encontrado " + id );
		}
		
		return new ResponseEntity<Tratamiento>(obj, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Tratamiento> registrar(@Valid @RequestBody Tratamiento p) throws Exception{
		Tratamiento obj = iTratamientoService.registrar(p);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdTratamiento()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Tratamiento> modificar(@Valid @RequestBody Tratamiento p) throws Exception{
		Tratamiento obj = iTratamientoService.modificar(p);
		return new ResponseEntity<Tratamiento>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception{
		Tratamiento obj = iTratamientoService.listarPorId(id);
		
		if(obj.getIdTratamiento() == null) {
			throw new RuntimeException("ID NO ENCONTRADO "+id);
		}
			
		iTratamientoService.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
