package net.gafah.microservicios.citas.controller;

import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.gafah.microservicios.citas.dto.CitaRequest;
import net.gafah.microservicios.citas.dto.CitaResponse;
import net.gafah.microservicios.citas.model.Cita;
import net.gafah.microservicios.citas.service.ICitaService;
import net.gafah.microservicios.commons.exceptions.ResourceNotFoundException;
import net.gafah.microservicios.commons.microservicios.controllers.CommonController;

@RestController

@AllArgsConstructor
public class CitaController extends CommonController<Cita, ICitaService>{

//    private ICitaService iCitaService;
//
//
//
//    @GetMapping("/listaCitados")
//    public ResponseEntity<Set<Cita>> listaCitados(
//            @RequestParam("idEmpresa") Long idEmpresa, 
//            @RequestParam("numeroDocumento") Long idCliente,
//            @RequestParam("numeroDiaSemana")Integer numeroDiaSemana) throws ResourceNotFoundException {
//
//           
//    	var lista = iCitaService.listaCitados(idEmpresa,idCliente, numeroDiaSemana);
//    	System.out.println("lista "+  lista); 
//    	if (lista.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(lista, HttpStatus.OK);
//    }
    




}
