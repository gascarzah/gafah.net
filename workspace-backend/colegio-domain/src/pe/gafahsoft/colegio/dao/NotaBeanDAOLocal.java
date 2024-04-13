package pe.gafahsoft.colegio.dao;

import java.util.List;

import pe.gafahsoft.colegio.modelo.Nota;


public interface NotaBeanDAOLocal {
	public List<Nota> listar(Nota parametros);

	public int grabar(Nota parametros);

	public void eliminar(Nota nota);
}
