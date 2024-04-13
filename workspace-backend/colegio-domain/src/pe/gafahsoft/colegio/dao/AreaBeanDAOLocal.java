package pe.gafahsoft.colegio.dao;

import java.util.List;

import pe.gafahsoft.colegio.modelo.Area;


public interface AreaBeanDAOLocal {

	List<Area> listar(Area parametros);

	int grabar(Area parametros);

}
