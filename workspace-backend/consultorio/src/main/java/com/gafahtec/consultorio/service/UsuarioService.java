package com.gafahtec.consultorio.service;

import com.gafahtec.consultorio.dto.request.UsuarioRequest;
import com.gafahtec.consultorio.model.Usuario;


public interface UsuarioService extends ICRUD<Usuario, Integer>{
	

	Usuario getUsuario(String username);
	
	Usuario registrarUsuarioEmpleado(UsuarioRequest usuarioRequest);


//	void addRoleToUser(String correo, String rol);
//	
//	public Rol registrarRol(Rol rol);
	
//	void grabarToken(AuthToken token);

}
