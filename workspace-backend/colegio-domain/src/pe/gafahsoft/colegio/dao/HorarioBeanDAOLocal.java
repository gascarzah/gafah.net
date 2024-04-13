package pe.gafahsoft.colegio.dao;

import java.util.List;

import pe.gafahsoft.colegio.modelo.Horario;


public interface HorarioBeanDAOLocal {
	public List<Horario> listar(Horario parametros);
	
	public int grabar(Horario parametros);
}
