package pe.gafahsoft.colegio.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import pe.gafahsoft.colegio.dao.HorarioBeanDAOLocal;
import pe.gafahsoft.colegio.modelo.Horario;
import pe.gafahsoft.colegio.patron.MantenimientoGeneralDAO;
import pe.gafahsoft.colegio.util.Constantes;
import pe.gafahsoft.colegio.util.Utiles;

public class HorarioBeanDAO extends MantenimientoGeneralDAO<Horario> implements HorarioBeanDAOLocal{

	public List<Horario> listar(Horario parametros) {
		StringBuilder sql = new StringBuilder();
		switch (parametros.getOpcion()) {
		case Constantes.BUSCAR_TODOS:
        sql.append( 	" select horario_id                  as   horarioid           ,     " +
				"			 nivel                     as   nivel           ,        " +
				"			 hora_id                     as   horaid           ,        " +
				"			 emp_id                      as   empid           ,         " +
				"			 dia                         as   dia           ,           " +
				"			 anio                        as   anio           ,          " +
				"			 estado                      as   estado           ,        " +
				"			 usu_reg                     as   usureg           ,        " +
				"			 fec_reg                     as   fecreg           ,        " +
				"			 usu_mod                     as   usumod           ,        " +
				"			 fec_mod                     as   fecmod           ,        " +
				"			 maq_reg                     as   maqreg           ,        " +
				"			 maq_mod                     as   maqmod                    " +
				" from horario                                                      " );	
			break;

		
		default:
			break;
		}
		
		System.out.println("sql >> " + sql);
		List<Horario> lista = buscar(sql.toString(), parametros);

		return lista;
	}
	
	public int grabar(Horario parametros) {
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
	public void setParametros(PreparedStatement prepaStatement, Horario parametros) throws SQLException {
		int i=1;
		switch (parametros.getOpcion()) {
		case Constantes.INSERTAR:
			prepaStatement.setInt(i++, parametros.getNivel());
			prepaStatement.setInt(i++, parametros.getHoraId());
			prepaStatement.setInt(i++, parametros.getEmpId());
			prepaStatement.setInt(i++, parametros.getDia());
			prepaStatement.setString(i++, parametros.getAnio());
			prepaStatement.setInt(i++, parametros.getEstado());
			prepaStatement.setString(i++, parametros.getUsuReg());
			prepaStatement.setString(i++, parametros.getMaqReg());
			
			break;

		case Constantes.ACTUALIZAR:
			prepaStatement.setInt(i++, parametros.getHorarioId());
			break;
		default:
			break;
		}
		
	}

	@Override
	public Horario getFactory() {
		// TODO Auto-generated method stub
		return null;
	}
}
