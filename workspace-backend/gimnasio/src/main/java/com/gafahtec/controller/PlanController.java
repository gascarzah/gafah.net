package com.gafahtec.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

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

import com.gafahtec.exception.ModeloNotFoundException;
import com.gafahtec.model.Plan;
import com.gafahtec.service.IPlanService;

import lombok.AllArgsConstructor;
@RestController
@RequestMapping("/planes")
@AllArgsConstructor
public class PlanController {

	private IPlanService iPlanService;
	
	@GetMapping
	public ResponseEntity<List<Plan>> listar() throws Exception{
		List<Plan> lista = iPlanService.listar();
		return new ResponseEntity<List<Plan>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Plan> listarPorId(@PathVariable("id") Integer id) throws Exception{
		Plan obj = iPlanService.listarPorId(id);
		
		if(obj.getIdPlan() == null) {
			throw new ModeloNotFoundException("Id no encontrado " + id );
		}
		
		return new ResponseEntity<Plan>(obj, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Plan> registrar(@Valid @RequestBody Plan p) throws Exception{
		Plan obj = iPlanService.registrar(p);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdPlan()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Plan> modificar(@Valid @RequestBody Plan p) throws Exception{
//		System.out.println(p);
		Plan obj = iPlanService.modificar(p);
		return new ResponseEntity<Plan>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception{
		Plan obj = iPlanService.listarPorId(id);
		
		if(obj.getIdPlan() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO "+id);
		}
			
		iPlanService.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/pageable")
	public ResponseEntity<Page<Plan>> listarPageable(@PageableDefault(sort = "nombre")Pageable pageable) throws Exception{			
		Page<Plan> Plans = iPlanService.listarPageable(pageable);
		return new ResponseEntity<Page<Plan>>(Plans, HttpStatus.OK);
	}
	
//	@GetMapping
//	public ResponseEntity<List<Plan>> listarOrdenadoPorId() throws Exception{
//		List<Plan> lista = iPlanService.listarOrderById();
//		return new ResponseEntity<List<Plan>>(lista, HttpStatus.OK);
//	}
	
}
