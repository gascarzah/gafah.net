package net.gafah.microservicios.usuarios.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.gafah.microservicios.commons.microservicios.controllers.CommonController;
import net.gafah.microservicios.commons.usuarios.model.Usuario;
import net.gafah.microservicios.usuarios.service.IUsuarioService;

@RestController

@RequiredArgsConstructor
@Log4j2
public class UsuarioController extends CommonController<Usuario, IUsuarioService>{


    @GetMapping("/{email}")
    public ResponseEntity<Usuario> getUsuarioPorEmail(@PathVariable("email") String email) throws Exception {
        Usuario obj = service.findByEmail(email).get();

        if (obj.getEmail() == null) {
            throw new RuntimeException("Email no encontrado " + email);
        }

        return new ResponseEntity<Usuario>(obj, HttpStatus.OK);
    }

  
}



