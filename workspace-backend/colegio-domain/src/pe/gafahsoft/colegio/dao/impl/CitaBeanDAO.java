package pe.gafahsoft.colegio.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import pe.gafahsoft.colegio.dao.CitaBeanDAOLocal;
import pe.gafahsoft.colegio.modelo.Cita;
import pe.gafahsoft.colegio.patron.MantenimientoGeneralDAO;
import pe.gafahsoft.colegio.util.Constantes;
import pe.gafahsoft.colegio.util.Utiles;

public class CitaBeanDAO extends  MantenimientoGeneralDAO<Cita> implements CitaBeanDAOLocal{

	
	public List<Cita> listar(Cita parametros) {
		StringBuilder sql = new StringBuilder();
		switch (parametros.getOpcion()) {
		case Constantes.BUSCAR_TODOS:
			sql.append( "select cita_id                     as   citaid           ,        " +
					"			 emp_id                      as   empid           ,         " +
					"			 matri_id                    as   matriid           ,       " +
					"			 fec_cita                    as   feccita           ,       " +
					"			 envio_mail                  as   enviomail           ,     " +
					"			 estado                      as   estado           ,        " +
					"			 usu_reg                     as   usureg           ,        " +
					"			 fec_reg                     as   fecreg           ,        " +
					"			 usu_mod                     as   usumod           ,        " +
					"			 fec_mod                     as   fecmod           ,        " +
					"			 maq_reg                     as   maqreg           ,        " +
					"			 maq_mod                     as   maqmod                    " +
					"			 from cita                                                  " );	
			break;

		
		default:
			break;
		}
		List<Cita> lista = buscar(sql.toString(), parametros);
		
		return lista;
	}

	

	@Override
	public void setParametros(PreparedStatement prepaStatement, Cita parametros) throws SQLException {
		int i = 1;
		
		switch (parametros.getOpcion()) {
		case Constantes.INSERTAR:
			prepaStatement.setInt(i++, parametros.getEmpId());
			prepaStatement.setInt(i++, parametros.getMatriId());
//			prepaStatement.setInt(i++, parametros.getFecCita());
			prepaStatement.setString(i++, parametros.getEnvioMail());
			prepaStatement.setInt(i++, parametros.getEstado());
			prepaStatement.setString(i++, parametros.getUsuReg());
			prepaStatement.setString(i++, parametros.getMaqReg());
			break;

		case Constantes.ACTUALIZAR:
			prepaStatement.setInt(i++, parametros.getCitaId());
			break;
		default:
			break;
		}
		
	}
	
	@Override
	public int grabar(Cita parametros) {
		int i = 0;
		StringBuilder sql = new StringBuilder();
		switch (parametros.getOpcion()) {
		case Constantes.INSERTAR:
			 sql.append( " insert into cita ( emp_id, matri_id, fec_cita, envio_mail, estado, usu_reg, fec_reg, maq_reg) values "+Utiles.inParametros(8));	
			break;

		case Constantes.ACTUALIZAR:
			 sql.append( " update cita set emp_id =?, matri_id=?, fec_cita=?, envio_mail=?, estado=?, usu_mod=?, fec_mod=?, maq_mod=? where cita_id=? ");
			break;
		default:
			break;
		}
		

		i = crud(sql.toString(), parametros);

		return i;
	}



	@Override
	public Cita getFactory() {
		// TODO Auto-generated method stub
		return null;
	}



	

		
	
	

}
