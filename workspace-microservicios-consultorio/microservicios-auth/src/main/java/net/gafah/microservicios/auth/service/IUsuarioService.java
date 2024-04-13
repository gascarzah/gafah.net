package net.gafah.microservicios.auth.service;

import java.io.IOException;
import java.util.Optional;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.gafah.microservicios.commons.microservicios.services.ICommonService;
import net.gafah.microservicios.commons.usuarios.dto.AuthenticationRequest;
import net.gafah.microservicios.commons.usuarios.dto.AuthenticationResponse;
import net.gafah.microservicios.commons.usuarios.dto.UsuarioRequest;
import net.gafah.microservicios.commons.usuarios.model.Usuario;

public interface IUsuarioService extends ICommonService<Usuario>{
	public Usuario modificarUsuario(UsuarioRequest usuarioRequest);
	public Usuario register(UsuarioRequest usuarioRequest);

	 public  Optional<Usuario> findByEmail(String email);

	 public AuthenticationResponse authenticate(AuthenticationRequest request);
		
	 public void refreshToken(
	          HttpServletRequest request,
	          HttpServletResponse response
	  ) throws IOException;

}