package pe.gafahsoft.colegio.dao;

import java.util.List;

import pe.gafahsoft.colegio.modelo.Empleado;



public interface EmpleadoBeanDAOLocal {

	List<Empleado> listar(Empleado parametros);

	int grabar(Empleado parametros);



}
