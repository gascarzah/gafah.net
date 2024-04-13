package pe.gafahsoft.colegio.dao;

import java.util.List;

import pe.gafahsoft.colegio.modelo.Indicador;


public interface IndicadorBeanDAOLocal {
	public List<Indicador> listar(Indicador parametros);
	public int grabar(Indicador parametros);
}
