package pe.gafahsoft.colegio.dao;

import java.util.List;

import pe.gafahsoft.colegio.modelo.OpcionesMenu;


public interface OpcionMenuBeanDAOLocal {
	public List<OpcionesMenu> getOpcionesMenus(OpcionesMenu parametros);

	public List<OpcionesMenu> listar(OpcionesMenu parametros);

	public int grabar(OpcionesMenu parametros);
}
