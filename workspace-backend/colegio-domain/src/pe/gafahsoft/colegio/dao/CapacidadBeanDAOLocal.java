package pe.gafahsoft.colegio.dao;

import java.util.List;

import pe.gafahsoft.colegio.modelo.Capacidad;


public interface CapacidadBeanDAOLocal {

	List<Capacidad> listar(Capacidad parametros);

	int grabar(Capacidad parametros);

}
