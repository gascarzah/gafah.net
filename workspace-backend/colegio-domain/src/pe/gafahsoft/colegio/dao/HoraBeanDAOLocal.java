package pe.gafahsoft.colegio.dao;

import java.util.List;

import pe.gafahsoft.colegio.modelo.Hora;


public interface HoraBeanDAOLocal {

	int grabar(Hora parametros);

	List<Hora> listar(Hora parametros);

	

}
