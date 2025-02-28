package com.gafahtec.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
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
import com.gafahtec.model.Cliente;
import com.gafahtec.service.IClienteService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/clientes")
@AllArgsConstructor
public class ClienteController {

	private IClienteService iClienteService;

	@GetMapping
	public ResponseEntity<List<Cliente>> listar() throws Exception {
		List<Cliente> lista = iClienteService.listarOrderNombre();
		return new ResponseEntity<List<Cliente>>(lista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> listarPorId(@PathVariable("id") Integer id, Authentication authentication)
			throws Exception {
		Cliente obj = iClienteService.listarPorId(id);

		if (obj.getIdCliente() == null) {
			throw new ModeloNotFoundException("Id no encontrado " + id);
		}

		return new ResponseEntity<Cliente>(obj, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Cliente> registrar(@Valid @RequestBody Cliente p, Authentication authentication)
			throws Exception {
		var isRegistrado = iClienteService.getPorNumeroDocumento(p.getNumeroDocumento());
		if (isRegistrado) {
			throw new ModeloNotFoundException("numero de documento ya se encuentra registrado");
		}
		Cliente obj = iClienteService.registrar(p);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdCliente())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping
	public ResponseEntity<Cliente> modificar(@Valid @RequestBody Cliente p, Authentication authentication)
			throws Exception {
//		System.out.println(p);
		Cliente obj = iClienteService.modificar(p);
		return new ResponseEntity<Cliente>(obj, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id, Authentication authentication)
			throws Exception {
		Cliente obj = iClienteService.listarPorId(id);

		if (obj.getIdCliente() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}

		iClienteService.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/pageable")
	public ResponseEntity<Page<Cliente>> listarPageable(
			@PageableDefault(sort = "apellidoPaterno") Pageable pageable)
			throws Exception {
		Page<Cliente> clientes = iClienteService.listarPageable(pageable);
		return new ResponseEntity<Page<Cliente>>(clientes, HttpStatus.OK);
	}

//	@GetMapping
//	public ResponseEntity<List<Cliente>> listarOrdenadoPorId() throws Exception{
//		List<Cliente> lista = iClienteService.listarOrderById();
//		return new ResponseEntity<List<Cliente>>(lista, HttpStatus.OK);
//	}

}
