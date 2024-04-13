package pe.gafahsoft.colegio.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import pe.gafahsoft.colegio.dao.DependienteBeanDAOLocal;
import pe.gafahsoft.colegio.modelo.Dependiente;
import pe.gafahsoft.colegio.patron.MantenimientoGeneralDAO;
import pe.gafahsoft.colegio.util.Constantes;
import pe.gafahsoft.colegio.util.Utiles;

public class DependienteBeanDAO extends  MantenimientoGeneralDAO<Dependiente> implements DependienteBeanDAOLocal{

	@Override
	public List<Dependiente> listar(Dependiente parametros) {
		StringBuilder sql = new StringBuilder();
		switch (parametros.getOpcion()) {
		case Constantes.BUSCAR_TODOS:
			sql.append( "select alum_id                  as   alumId           ,     " +
					"			 apod_id                  as   apodId                " +
					"			 from dependiente                                               " );	
			break;

		case Constantes.BUSCAR_POR_ID_ALUM_ID_APOD:
			sql.append( "select depend_id                  as   dependId " +
						" from dependiente where alum_id = ? and apod_id = ?" );	
			break;
		default:
			break;
		}
		List<Dependiente> lista = buscar(sql.toString(), parametros);
		
		return lista;
	}

	@Override
	public int grabar(Dependiente parametros) {
		int i = 0;
		StringBuilder sql = new StringBuilder();
		switch (parametros.getOpcion()) {
		case Constantes.INSERTAR:
			sql.append( " insert into dependiente (alum_id, apod_id) values "+Utiles.inParametros(2));	
			break;

		case Constantes.ACTUALIZAR:
			sql.append( " update dependiente set alum_id=?, apod_id=? where depend_id=? ");
			break;
		default:
			break;
		}
		

		i = crud(sql.toString(), parametros);

		return i;
	}


	@Override
	public void setParametros(PreparedStatement prepaStatement, Dependiente parametros) throws SQLException {
int i = 1;
		
		switch (parametros.getOpcion()) {
		case Constantes.INSERTAR:
			prepaStatement.setInt(i++, parametros.getAlumId());
			prepaStatement.setInt(i++, parametros.getApodId());
			break;

		case Constantes.ACTUALIZAR:
			prepaStatement.setInt(i++, parametros.getAlumId());
			prepaStatement.setInt(i++, parametros.getApodId());
			prepaStatement.setInt(i++, parametros.getDependId());
			break;
			
		case Constantes.BUSCAR_POR_ID_ALUM_ID_APOD:
			prepaStatement.setInt(i++, parametros.getAlumId());
			prepaStatement.setInt(i++, parametros.getApodId());
			break;
		default:
			break;
		}
		
		
	}

	@Override
	public Dependiente getFactory() {
		// TODO Auto-generated method stub
		return new Dependiente();
	}
	
}
