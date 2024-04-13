package net.gafah.microservicios.auth.controller;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.gafah.microservicios.auth.service.IUsuarioService;
import net.gafah.microservicios.commons.microservicios.controllers.CommonController;
import net.gafah.microservicios.commons.usuarios.dto.AuthenticationRequest;
import net.gafah.microservicios.commons.usuarios.dto.AuthenticationResponse;
import net.gafah.microservicios.commons.usuarios.model.Usuario;

@RestController

@RequiredArgsConstructor
@Log4j2
public class AuthenticateController extends CommonController<Usuario, IUsuarioService>{

	

    
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(
        @RequestBody AuthenticationRequest request
    ) {
      return ResponseEntity.ok(service.authenticate(request));
    }

    @PostMapping("/refresh-token")
    public void refreshToken(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws IOException {
    	service.refreshToken(request, response);
    }
  
}



