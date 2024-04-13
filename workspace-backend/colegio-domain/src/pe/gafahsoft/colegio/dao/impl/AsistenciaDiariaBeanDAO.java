package pe.gafahsoft.colegio.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import pe.gafahsoft.colegio.dao.AsistenciaDiariaBeanDAOLocal;
import pe.gafahsoft.colegio.modelo.AsistenciaDiaria;
import pe.gafahsoft.colegio.patron.MantenimientoGeneralDAO;
import pe.gafahsoft.colegio.util.Constantes;
import pe.gafahsoft.colegio.util.Utiles;


public class AsistenciaDiariaBeanDAO extends MantenimientoGeneralDAO<AsistenciaDiaria> implements AsistenciaDiariaBeanDAOLocal{

	@Override
	public List<AsistenciaDiaria> listar(AsistenciaDiaria parametros) {
		StringBuilder sql = new StringBuilder();
		switch (parametros.getOpcion()) {
		case Constantes.BUSCAR_TODOS:
			sql.append( "select asis_dia_id                 as   asisdiaid           ,     " +
					"			 asis_id                     as   asisid           ,        " +
					"			 matri_id                    as   matriid           ,       " +
					"			 asiste                      as   asiste           ,        " +
					"			 dia_observ                  as   diaobserv           ,     " +
					"			 usu_reg                     as   usureg           ,        " +
					"			 fec_reg                     as   fecreg           ,        " +
					"			 usu_mod                     as   usumod           ,        " +
					"			 fec_mod                     as   fecmod           ,        " +
					"			 maq_reg                     as   maqreg           ,        " +
					"			 maq_mod                     as   maqmod                    " +
					"			 from asistencia_diaria                                     ") ;	
			break;
		case Constantes.BUSCAR_POR_NIVEL:
			sql = new StringBuilder();
			sql.append( " SELECT m.matri_id  as matriId   , "+
						"	 	 a.dni      as dni      , "+
						"	 	 a.nombres	as nombres	, "+
						"	 	 a.ape_pate	as apePate	, "+
						"	 	 a.ape_mate	as apeMate	, "+
						"	 	 ad.asiste	as flagAsis	 "+
						" 	from asistencia_diaria ad, "+
						"		 matricula m, "+
						"		alumno a, asistencia asis "+
						" where ad.matri_id = m.matri_id and m.alum_id = a.alum_id " +
					   	" and m.nivel = ? ");
			break;
			
		case Constantes.BUSCAR_POR_ASISTENCIA:
			sql = new StringBuilder();
			sql.append( " SELECT m.matri_id  as matriId   , "+
						"	 	 a.dni      as dni      , "+
						"	 	 a.nombres	as nombres	, "+
						"	 	 a.ape_pate	as apePate	, "+
						"	 	 a.ape_mate	as apeMate	 "+
//						"	 	 ad.asiste	as flagAsis	 "+
						" 	from matricula m, "+
						"		alumno a "+
						" where m.alum_id = a.alum_id " +
					   	" and m.nivel = ? ");
			break;
		
		default:
			break;
		}
		
		List<AsistenciaDiaria> lista = buscar(sql.toString(), parametros);
		
		return lista;
	}

	@Override
	public int grabar(AsistenciaDiaria parametros) {
		int i = 0;
		StringBuilder sql = new StringBuilder();
		switch (parametros.getOpcion()) {
		case Constantes.INSERTAR:
			sql.append( " insert into asistencia_diaria (asis_id, matri_id, asiste, dia_observ, usu_reg, maq_reg ) values "+Utiles.inParametros(6));	
			break;

		case Constantes.ACTUALIZAR:
			sql.append( " update asistencia_diaria set asis_id =?, matri_id=?, asiste=?, dia_observ=?, usu_mod=?, fec_mod=?, maq_mod=? where asis_dia_id = ? ");
			break;
		default:
			break;
		}
		
		
		i = crud(sql.toString(), parametros);
		
		return i;
	}
	
	@Override
	public void setParametros(PreparedStatement prepaStatement, AsistenciaDiaria parametros) throws SQLException {
		int i = 1;
		
		switch (parametros.getOpcion()) {
		case Constantes.INSERTAR:
			prepaStatement.setInt(i++, parametros.getAsisId());
			prepaStatement.setInt(i++, parametros.getMatriId());
			prepaStatement.setInt(i++, parametros.getAsiste());
			prepaStatement.setString(i++, parametros.getDiaObserv());
			prepaStatement.setString(i++, parametros.getUsuReg());
			prepaStatement.setString(i++, parametros.getMaqReg());
			break;

		case Constantes.ACTUALIZAR:
			prepaStatement.setInt(i++, parametros.getAsisDiaId());
			break;
			
		case Constantes.BUSCAR_POR_NIVEL:
			prepaStatement.setInt(i++, parametros.getNivel());
			
			break;
			
		case Constantes.BUSCAR_POR_ASISTENCIA:
			prepaStatement.setInt(i++, parametros.getNivel());
			
			break;
		default:
			break;
		}
		
		
		
	}

	@Override
	public AsistenciaDiaria getFactory() {
		// TODO Auto-generated method stub
		return new AsistenciaDiaria();
	}

	


}
