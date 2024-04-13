package pe.gafahsoft.colegio.dao;

import java.util.List;

import pe.gafahsoft.colegio.modelo.Alumno;


public interface AlumnoBeanDAOLocal {
	public List<Alumno> listar(Alumno parametros);
	public int grabar(Alumno parametros);
	

	

}
