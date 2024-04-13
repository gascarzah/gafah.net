package pe.gafahsoft.colegio.dao;

import java.util.List;

import pe.gafahsoft.colegio.modelo.Apoderado;


public interface ApoderadoBeanDAOLocal {
	public List<Apoderado> listar(Apoderado parametros);

	public int grabar(Apoderado parametros);
}
