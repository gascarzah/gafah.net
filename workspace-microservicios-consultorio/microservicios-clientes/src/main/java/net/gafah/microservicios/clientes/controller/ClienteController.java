package net.gafah.microservicios.clientes.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.gafah.microservicios.clientes.model.Cliente;
import net.gafah.microservicios.clientes.service.IClienteService;
import net.gafah.microservicios.commons.exceptions.ResourceNotFoundException;
@RestController
//@RequestMapping("/clientes")
@AllArgsConstructor
@Log4j2
public class ClienteController {


	
	private IClienteService iClienteService;

	@GetMapping
	public ResponseEntity<?> listar() throws Exception{
		var lista = iClienteService.listar();
		if (lista.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> listarPorId(@PathVariable("id") String id) throws Exception{
		var obj = iClienteService.listarPorId(id);
		
		if(obj.getNumeroDocumento() == null) {
		    throw new ResourceNotFoundException("Id no encontrado " + id);
		}
		
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> registrar(@Valid @RequestBody Cliente Cliente) throws Exception{

		var obj = iClienteService.registrar(Cliente);
		 return new ResponseEntity<>(obj, HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<?> modificar(@Valid @RequestBody Cliente Cliente) throws Exception{

		var obj = iClienteService.modificar(Cliente);
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") String id) throws Exception{
		var obj = iClienteService.listarPorId(id);
		
		if(obj.getNumeroDocumento() == null) {
			throw new ResourceNotFoundException("ID NO ENCONTRADO "+id);
		}
			
		iClienteService.eliminar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
  @GetMapping("/pageable")
  public ResponseEntity<Page<?>> listarPageable(Pageable pageable,@RequestParam(defaultValue = "0") int page,
          @RequestParam(defaultValue = "5") int size) throws Exception{
      Page<Cliente> paginas = iClienteService.listar(pageable);
      if (paginas.isEmpty()) {
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
      return new ResponseEntity<>(paginas, HttpStatus.OK);
  }
	

}
