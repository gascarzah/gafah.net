package net.gafah.microservicios.programaciones.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.gafah.microservicios.commons.exceptions.ResourceNotFoundException;
import net.gafah.microservicios.commons.microservicios.controllers.CommonController;
import net.gafah.microservicios.programaciones.model.Programacion;
import net.gafah.microservicios.programaciones.service.IProgramacionService;

@RestController
@AllArgsConstructor
@Log4j2
public class ProgramacionController extends CommonController<Programacion, IProgramacionService>{

    private IProgramacionService iProgramacionService;






    @GetMapping("/activo")
    public ResponseEntity<Programacion> programacionActivo() throws Exception {
        var list = iProgramacionService.programacionActivo().stream().findFirst().orElseThrow(() ->  new ResourceNotFoundException("programacion activa no encontrado "));
        

        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    

}
