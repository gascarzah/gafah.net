package pe.gafahsoft.colegio.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import pe.gafahsoft.colegio.dao.AsistenciaBeanDAOLocal;
import pe.gafahsoft.colegio.modelo.Asistencia;
import pe.gafahsoft.colegio.patron.MantenimientoGeneralDAO;
import pe.gafahsoft.colegio.util.Constantes;
import pe.gafahsoft.colegio.util.Utiles;


public class AsistenciaBeanDAO extends MantenimientoGeneralDAO<Asistencia> implements AsistenciaBeanDAOLocal {

	@Override
	public List<Asistencia> listar(Asistencia parametros) {
		StringBuilder sql = new StringBuilder();
		switch (parametros.getOpcion()) {
		case Constantes.BUSCAR_TODOS:
			sql.append( "select asis_id                     as   asisid           ,				"
					+ "			 profe_id                      as   empid           ,         "
					+ "			 fec_asis                    as   fecasis           ,       "
					+ "			 usu_reg                     as   usureg           ,        "
					+ "			 fec_reg                     as   fecreg           ,        "
					+ "			 usu_mod                     as   usumod           ,        "
					+ "			 fec_mod                     as   fecmod           ,        "
					+ "			 maq_reg                     as   maqreg           ,        "
					+ "			 maq_mod                     as   maqmod                    "
					+ "			 from asistencia                                            ");
			break;
		
		default:
			break;
		}
		List<Asistencia> lista = buscar(sql.toString(), parametros);

		return lista;

	}

	@Override
	public void setParametros(PreparedStatement prepaStatement, Asistencia parametros) throws SQLException {
		int i = 1;

		switch (parametros.getOpcion()) {
		case Constantes.INSERTAR:
			prepaStatement.setInt(i++, parametros.getProfeId());
			prepaStatement.setDate(i++, parametros.getFecAsis()==null?null:new java.sql.Date(parametros.getFecAsis().getTime()));
			prepaStatement.setString(i++, parametros.getUsuReg());
			// prepaStatement.setDate(i++, parametros.getFecReg());
			prepaStatement.setString(i++, parametros.getMaqReg());
			break;

		case Constantes.ACTUALIZAR:
			prepaStatement.setInt(i++, parametros.getAsisId());
			break;
			
	
		default:
			break;
		}

	}

	@Override
	public int grabar(Asistencia parametros) {
		int i = 0;
		StringBuilder sql = new StringBuilder();
		switch (parametros.getOpcion()) {
		case Constantes.INSERTAR:
			sql.append( " insert into asistencia ( profe_id, fec_asis, usu_reg, maq_reg) values "
					+ Utiles.inParametros(4));
			break;

		case Constantes.ACTUALIZAR:
			sql.append( " update asistencia set  profe_id =?, fec_asis=?, usu_reg=?, fec_reg=?, maq_reg=? where asis_id = ?");
			break;
		default:
			break;
			
		}
		i = crud(sql.toString(), parametros);

		return i;
	}

	@Override
	public Asistencia getFactory() {
		// TODO Auto-generated method stub
		return new  Asistencia();
	}


}
