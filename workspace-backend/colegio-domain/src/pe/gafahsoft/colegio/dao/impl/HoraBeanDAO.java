package pe.gafahsoft.colegio.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import pe.gafahsoft.colegio.dao.HoraBeanDAOLocal;
import pe.gafahsoft.colegio.modelo.Hora;
import pe.gafahsoft.colegio.patron.MantenimientoGeneralDAO;
import pe.gafahsoft.colegio.util.Constantes;
import pe.gafahsoft.colegio.util.Utiles;

public class HoraBeanDAO extends MantenimientoGeneralDAO<Hora> implements HoraBeanDAOLocal {

	@Override
	public List<Hora> listar(Hora parametros) {
		StringBuilder sql = new StringBuilder();
		switch (parametros.getOpcion()) {
		case Constantes.BUSCAR_TODOS:
			sql.append( "select hora_id                     as   horaid           ,        " +
					"			 inicio                      as   inicio           ,        " +
					"			 fin                         as   fin           ,           " +
					"			 hora_pedag                  as   horapedag           ,     " +
					"			 estado                      as   estado           ,        " +
					"			 usu_reg                     as   usureg           ,        " +
					"			 fec_reg                     as   fecreg           ,        " +
					"			 usu_mod                     as   usumod           ,        " +
					"			 fec_mod                     as   fecmod           ,        " +
					"			 maq_reg                     as   maqreg           ,        " +
					"			 maq_mod                     as   maqmod                    " +
					"			 from hora                                                  " );	
			break;

		
		default:
			break;
		}
		
		List<Hora> lista = buscar(sql.toString(), parametros);

		return lista;
	}

	public int grabar(Hora parametros) {
		int i = 0;
		StringBuilder sql = new StringBuilder();
		switch (parametros.getOpcion()) {
		case Constantes.INSERTAR:
			sql.append( " insert into hora ( inicio, fin, hora_pedag, estado, usu_reg, fec_reg, maq_reg ) values "+Utiles.inParametros(7));
			break;

		case Constantes.ACTUALIZAR:
			sql.append( " update hora set inicio =?, fin = ?,hora_pedag = ?,estado=?, usu_mod=?, fec_mod=?, maq_mod=? where hora_id=?");	
			break;
		default:
			break;
		}
		

		i = crud(sql.toString(), parametros);

		return i;
	}



	

	@Override
	public void setParametros(PreparedStatement prepaStatement, Hora parametros) throws SQLException {
		int i = 1;
		switch (parametros.getOpcion()) {
		case Constantes.INSERTAR:
			prepaStatement.setString(i++, parametros.getInicio());
			prepaStatement.setString(i++, parametros.getFin());
			prepaStatement.setInt(i++, parametros.getHoraPedag());
			prepaStatement.setInt(i++, parametros.getEstado());
			prepaStatement.setString(i++, parametros.getUsuReg());
			prepaStatement.setString(i++, parametros.getMaqReg());
			break;
		case Constantes.ACTUALIZAR:
			prepaStatement.setString(i++, parametros.getInicio());
			prepaStatement.setString(i++, parametros.getFin());
			prepaStatement.setInt(i++, parametros.getHoraPedag());
			prepaStatement.setInt(i++, parametros.getEstado());
			prepaStatement.setString(i++, parametros.getUsuReg());
			prepaStatement.setString(i++, parametros.getMaqReg());
			prepaStatement.setInt(i++, parametros.getHoraId());
			
			break;
			
		default:
			break;
		}
	}

	@Override
	public Hora getFactory() {
		// TODO Auto-generated method stub
		return null;
	}


}
