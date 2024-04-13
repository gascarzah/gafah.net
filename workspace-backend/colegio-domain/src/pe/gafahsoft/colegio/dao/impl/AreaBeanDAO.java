package pe.gafahsoft.colegio.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import pe.gafahsoft.colegio.dao.AreaBeanDAOLocal;
import pe.gafahsoft.colegio.modelo.Area;
import pe.gafahsoft.colegio.patron.MantenimientoGeneralDAO;
import pe.gafahsoft.colegio.util.Constantes;

public class AreaBeanDAO extends  MantenimientoGeneralDAO<Area> implements AreaBeanDAOLocal{

	@Override
	public List<Area> listar(Area parametros) {
		StringBuilder sql = null;
		switch (parametros.getOpcion()) {
		case Constantes.BUSCAR_TODOS:
			sql = new StringBuilder();
			sql.append( "select area_id as   areaId , " +
					" curso as   curso "+
					" from area order by curso " );	
			break;
		

		
		default:
			break;
		}

		List<Area> lista = buscar(sql.toString(), parametros);

		
		return lista;
	}

	@Override
	public int grabar(Area parametros) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setParametros(PreparedStatement prepaStatement, Area parametros) throws SQLException {
		int i = 1;
		switch (parametros.getOpcion()) {
		case Constantes.INSERTAR:
			
			
			break;

		case Constantes.ACTUALIZAR:
			
			break;
		case Constantes.BUSCAR_TODOS:
			
			
			break;	
		
			
		default:
			break;
		}
		
		
	}

	@Override
	public Area getFactory() {
		// TODO Auto-generated method stub
		return new Area();
	}

}
