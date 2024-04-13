package pe.gafahsoft.colegio.dao;

import java.util.List;

import pe.gafahsoft.colegio.modelo.Asistencia;


public interface AsistenciaBeanDAOLocal {
	public List<Asistencia> listar(Asistencia parametros);
	public int grabar(Asistencia parametros);
}
