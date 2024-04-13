package net.gafah.microservicios.usuarios.service;

import java.util.Optional;

import net.gafah.microservicios.commons.microservicios.services.ICommonService;
import net.gafah.microservicios.commons.usuarios.dto.UsuarioRequest;
import net.gafah.microservicios.commons.usuarios.model.Usuario;

public interface IUsuarioService extends ICommonService<Usuario>{
	
	public Usuario modificarUsuario(UsuarioRequest usuarioRequest);
	public Usuario register(UsuarioRequest usuarioRequest);

	 public  Optional<Usuario> findByEmail(String email);
	 


}