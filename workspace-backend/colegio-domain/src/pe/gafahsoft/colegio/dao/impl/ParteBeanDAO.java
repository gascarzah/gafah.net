package pe.gafahsoft.colegio.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import pe.gafahsoft.colegio.dao.ParteBeanDAOLocal;
import pe.gafahsoft.colegio.modelo.Parte;
import pe.gafahsoft.colegio.patron.MantenimientoGeneralDAO;
import pe.gafahsoft.colegio.util.Constantes;
import pe.gafahsoft.colegio.util.Utiles;

public class ParteBeanDAO extends MantenimientoGeneralDAO<Parte> implements ParteBeanDAOLocal {

	@Override
	public List<Parte> listar(Parte parametros) {
		StringBuilder sql = new StringBuilder();
		switch (parametros.getOpcion()) {
		case Constantes.BUSCAR_TODOS:
			sql.append( "select parte_id                    as   parteid           ,       " +
					"			 horario_id                  as   horarioid           ,     " +
					"			 fec_parte                   as   fecparte           ,      " +
					"			 tema_dia                    as   temadia           ,       " +
					"			 conte_tema_dia              as   contetemadia           ,  " +
					"			 observ                      as   observ           ,        " +
					"			 estado                      as   estado           ,        " +
					"			 usu_reg                     as   usureg           ,        " +
					"			 fec_reg                     as   fecreg           ,        " +
					"			 usu_mod                     as   usumod           ,        " +
					"			 fec_mod                     as   fecmod           ,        " +
					"			 maq_reg                     as   maqreg           ,        " +
					"			 maq_mod                     as   maqmod                    " +
					"			 from parte                                                 ") ;	
			break;

		
		default:
			break;
		}
		System.out.println("sql >> " + sql);
		List<Parte> lista = buscar(sql.toString(), parametros);

		return lista;
	}

	public int grabar(Parte parametros) {
int i = 0;
StringBuilder sql = new StringBuilder();
		switch (parametros.getOpcion()) {
		case Constantes.INSERTAR:
			sql.append( " insert into parte (horario_id, fec_parte, tema_dia, conte_tema_dia, observ, estado, usu_reg, fec_reg, maq_reg) values " + Utiles.inParametros(9));		
			break;

		case Constantes.ACTUALIZAR:
			sql.append( " update parte set  horario_id=?, fec_parte=?, tema_dia=?, conte_tema_dia=?, observ=?, estado=?,  usu_mod=?, fec_mod=?,  maq_mod=?  where parte_id=?");	
			break;
		default:
			break;
		}
		

		i = crud(sql.toString(), parametros);

		return i;
	}

	@Override
	public void setParametros(PreparedStatement prepaStatement, Parte parametros) throws SQLException {
		int i = 1;
		switch (parametros.getOpcion()) {
		case Constantes.INSERTAR:
			prepaStatement.setInt(i++, parametros.getHorarioId());
			prepaStatement.setDate(i++, parametros.getFecParte()==null?null: new java.sql.Date(parametros.getFecParte().getTime()));
			prepaStatement.setString(i++, parametros.getTemaDia());
			prepaStatement.setString(i++, parametros.getConteTemaDia());
			prepaStatement.setString(i++, parametros.getObserv());
			prepaStatement.setInt(i++, parametros.getEstado());
			prepaStatement.setString(i++, parametros.getUsuReg());
			prepaStatement.setString(i++, parametros.getMaqReg());

			break;
		case Constantes.ACTUALIZAR:
//			prepaStatement.setInt(i++, parametros.getAulaId);
			prepaStatement.setDate(i++, parametros.getFecParte()==null?null: new java.sql.Date(parametros.getFecParte().getTime()));
			prepaStatement.setString(i++, parametros.getObserv());
			prepaStatement.setInt(i++, parametros.getEstado());
			prepaStatement.setInt(i++, parametros.getParteId());
			break;
			
		case 4: //parametros de busqueda
			prepaStatement.setInt(i++, parametros.getParteId());
			
			break;	
			
		default:
			break;
		}
		
	}

	@Override
	public Parte getFactory() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
