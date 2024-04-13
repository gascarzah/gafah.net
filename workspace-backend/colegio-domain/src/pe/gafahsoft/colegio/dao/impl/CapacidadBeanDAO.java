package pe.gafahsoft.colegio.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import pe.gafahsoft.colegio.dao.CapacidadBeanDAOLocal;
import pe.gafahsoft.colegio.modelo.Capacidad;
import pe.gafahsoft.colegio.patron.MantenimientoGeneralDAO;
import pe.gafahsoft.colegio.util.Constantes;

public class CapacidadBeanDAO extends MantenimientoGeneralDAO<Capacidad> implements CapacidadBeanDAOLocal {

	@Override
	public List<Capacidad> listar(Capacidad parametros) {

		StringBuilder sql = null;
		switch (parametros.getOpcion()) {
		case Constantes.BUSCAR_TODOS:
			sql = new StringBuilder();
			sql.append("select area_id as   areaId , " + " curso as   curso " + " from area order by curso ");
			break;

		case Constantes.BUSCAR_CAPACIDAD_POR_AREA:

			sql = new StringBuilder();
			sql.append("select distinct(ca.capacidad_id) as capacidadId , " + " ca.desc as   descripcion "
					+ " from capacidad ca, indicador ind ");
			sql.append(" where ca.capacidad_id = ind.capacidad_id ");
			sql.append(" and ind.area_id = ? ");
			sql.append(" order by ca.desc ");
			break;

		default:
			break;
		}

		List<Capacidad> lista = buscar(sql.toString(), parametros);

		return lista;
	}

	@Override
	public int grabar(Capacidad parametros) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setParametros(PreparedStatement prepaStatement, Capacidad parametros) throws SQLException {
		int i = 1;
		switch (parametros.getOpcion()) {
		case Constantes.INSERTAR:

			break;

		case Constantes.ACTUALIZAR:

			break;
		case Constantes.BUSCAR_TODOS:

			break;
		case Constantes.BUSCAR_CAPACIDAD_POR_AREA:

			prepaStatement.setInt(i++, parametros.getAreaId());
			break;

		default:
			break;
		}

	}

	@Override
	public Capacidad getFactory() {
		// TODO Auto-generated method stub
		return new Capacidad();
	}

}
