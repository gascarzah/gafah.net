package pe.gafahsoft.colegio.dao;

import java.util.List;

import pe.gafahsoft.colegio.modelo.Cita;


public interface CitaBeanDAOLocal {
	public List<Cita> listar(Cita parametros);
	
	public int grabar(Cita parametros);
}
