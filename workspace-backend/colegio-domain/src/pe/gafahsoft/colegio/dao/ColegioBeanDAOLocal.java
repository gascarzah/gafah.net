package pe.gafahsoft.colegio.dao;

import java.util.List;

import pe.gafahsoft.colegio.modelo.Colegio;


public interface ColegioBeanDAOLocal {

	public List<Colegio> listar(Colegio parametros);
	public int grabar(Colegio parametros);
	
}
