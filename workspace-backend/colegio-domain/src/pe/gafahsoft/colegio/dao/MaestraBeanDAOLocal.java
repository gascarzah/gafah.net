package pe.gafahsoft.colegio.dao;

import java.util.List;

import pe.gafahsoft.colegio.modelo.Maestra;

public interface MaestraBeanDAOLocal {

	public List<Maestra> buscarOpciones(Maestra parametros);
	public List<Maestra> listar(Maestra parametros);
	
	public int grabar(Maestra parametros);
}
