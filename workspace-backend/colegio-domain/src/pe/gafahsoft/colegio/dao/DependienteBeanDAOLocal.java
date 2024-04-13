package pe.gafahsoft.colegio.dao;

import java.util.List;

import pe.gafahsoft.colegio.modelo.Dependiente;


public interface DependienteBeanDAOLocal {

	public List<Dependiente> listar(Dependiente parametros);
	public int grabar(Dependiente parametros);
	
}
