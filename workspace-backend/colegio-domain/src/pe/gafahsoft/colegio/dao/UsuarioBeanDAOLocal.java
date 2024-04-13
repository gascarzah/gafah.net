package pe.gafahsoft.colegio.dao;

import java.util.List;

import pe.gafahsoft.colegio.modelo.Usuario;


public interface UsuarioBeanDAOLocal {
	public List<Usuario> listar(Usuario parametros);

	public int grabar(Usuario parametros);
}
