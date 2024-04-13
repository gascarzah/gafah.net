package pe.gafahsoft.colegio.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import pe.gafahsoft.colegio.dao.IndicadorBeanDAOLocal;
import pe.gafahsoft.colegio.modelo.Indicador;
import pe.gafahsoft.colegio.patron.MantenimientoGeneralDAO;
import pe.gafahsoft.colegio.util.Constantes;
import pe.gafahsoft.colegio.util.Utiles;

public class IndicadorDAO extends MantenimientoGeneralDAO<Indicador> implements IndicadorBeanDAOLocal{

	public List<Indicador> listar(Indicador parametros) {
		StringBuilder sql = new StringBuilder();
		switch (parametros.getOpcion()) {
		case Constantes.BUSCAR_TODOS:
			sql.append(" select area_id as areaId,  ");
			sql.append("		capacidad_id  as capacidadId, ");
			sql.append("		nivel as   nivel ");
			sql.append(" from indicador ");	
			break;

		case Constantes.BUSCAR_POR_NIVEL:
			sql.append(" select area_id as areaId,  ");
			sql.append("		capacidad_id  as capacidadId, ");
			sql.append("		nivel as   nivel ");
			sql.append(" from indicador ");
			sql.append(" where nivel = ? ");
			break;
		
		case Constantes.BUSCAR_NIVEL_POR_CAPACIDAD:
		sql.append(" select ind.nivel as   nivel, ");
		sql.append(" concat(m.valor, ' ', m.desc_corta, ' ', m.desc_larga) as valor ");
		sql.append(" from indicador ind, maestra m ");
		sql.append(" where ind.nivel = m.maes_id ");
		sql.append(" and ind.area_id = ? ");
		sql.append(" and ind.capacidad_id = ? ");
		break;
		default:
			break;
		}
		
		System.out.println("sql >> " + sql);
		List<Indicador> lista = buscar(sql.toString(), parametros);

		return lista;
	}
	
	public int grabar(Indicador parametros) {
		int result = 0;
		StringBuilder sql = new StringBuilder();
		switch (parametros.getOpcion()) {
		case Constantes.INSERTAR:
			sql.append( " insert into horario ( aula_id, hora_id, emp_id, dia, anio, estado, usu_reg, fec_reg, maq_reg) " +Utiles.inParametros(9));	
			break;

		case Constantes.ACTUALIZAR:
			sql.append( " update horario set  aula_id=?, hora_id=?, emp_id=?, dia=?, anio=?, estado=?, usu_mod=?, fec_mod=?, maq_mod=? where horario_id =? ");
			break;
		default:
			break;
		}
		

		result = crud(sql.toString(), parametros);

		return result;
	}

	


	
	@Override
	public void setParametros(PreparedStatement prepaStatement, Indicador parametros) throws SQLException {
		int i=1;
		switch (parametros.getOpcion()) {
		case Constantes.INSERTAR:
			
			
			
			break;

		case Constantes.ACTUALIZAR:
			
			break;
			
		case Constantes.BUSCAR_POR_NIVEL:
			prepaStatement.setInt(i++, parametros.getNivel());
			break;

		case Constantes.BUSCAR_NIVEL_POR_CAPACIDAD:
			prepaStatement.setInt(i++, parametros.getAreaId());
			prepaStatement.setInt(i++, parametros.getCapacidadId());
		break;
		default:
			break;
		}
		
	}

	

	@Override
	public Indicador getFactory() {
		// TODO Auto-generated method stub
		return new Indicador();
	}

}
