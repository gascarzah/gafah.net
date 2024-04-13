package pe.gafahsoft.colegio.dao;

import java.util.List;

import pe.gafahsoft.colegio.modelo.AsistenciaDiaria;


public interface AsistenciaDiariaBeanDAOLocal {
	public List<AsistenciaDiaria> listar(AsistenciaDiaria parametros);
	
	public int grabar(AsistenciaDiaria parametros);
}
