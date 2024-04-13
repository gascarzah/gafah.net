package pe.gafahsoft.colegio.dao;

import java.util.List;

import pe.gafahsoft.colegio.modelo.Menu;


public interface MenuBeanDAOLocal {

	public List<Menu> listar(Menu parametros);

	public List<Menu> getObtenerMenuPorPadre(Menu parametros);

	public int grabar(Menu parametros);
}
