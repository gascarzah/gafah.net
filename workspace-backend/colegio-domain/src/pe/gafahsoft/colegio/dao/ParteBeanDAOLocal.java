package pe.gafahsoft.colegio.dao;

import java.util.List;

import pe.gafahsoft.colegio.modelo.Parte;


public interface ParteBeanDAOLocal {
	public List<Parte> listar(Parte parametros);

	public int grabar(Parte parametros);
}
