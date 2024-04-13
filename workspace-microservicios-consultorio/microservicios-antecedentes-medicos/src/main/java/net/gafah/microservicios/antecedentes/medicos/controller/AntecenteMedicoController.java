package net.gafah.microservicios.antecedentes.medicos.controller;

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
import net.gafah.microservicios.antecedentes.medicos.model.AntecedenteMedico;
import net.gafah.microservicios.antecedentes.medicos.service.IAntecedenteMedicoService;
import net.gafah.microservicios.commons.exceptions.ResourceNotFoundException;
@RestController

@AllArgsConstructor
public class AntecenteMedicoController {

	private IAntecedenteMedicoService iAntecedenteMedicoService;

	@GetMapping
	public ResponseEntity<?> listar() throws Exception{
		var lista = iAntecedenteMedicoService.listar();
		if (lista.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> listarPorId(@PathVariable("id") Integer id) throws Exception{
		var obj = iAntecedenteMedicoService.listarPorId(id);
		
		if(obj.getIdAntecedenteMedico() == null) {
		    throw new ResourceNotFoundException("Id no encontrado " + id);
		}
		
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> registrar(@Valid @RequestBody AntecedenteMedico antecedenteMedico) throws Exception{

		var obj = iAntecedenteMedicoService.registrar(antecedenteMedico);
		 return new ResponseEntity<>(obj, HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<?> modificar(@Valid @RequestBody AntecedenteMedico antecedenteMedico) throws Exception{

		var obj = iAntecedenteMedicoService.modificar(antecedenteMedico);
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception{
		var obj = iAntecedenteMedicoService.listarPorId(id);
		
		if(obj.getIdAntecedenteMedico() == null) {
			throw new ResourceNotFoundException("ID NO ENCONTRADO "+id);
		}
			
		iAntecedenteMedicoService.eliminar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
  @GetMapping("/pageable")
  public ResponseEntity<Page<?>> listarPageable(Pageable pageable,@RequestParam(defaultValue = "0") int page,
          @RequestParam(defaultValue = "5") int size) throws Exception{
      Page<AntecedenteMedico> paginas = iAntecedenteMedicoService.listar(pageable);
      if (paginas.isEmpty()) {
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
      return new ResponseEntity<>(paginas, HttpStatus.OK);
  }
}
