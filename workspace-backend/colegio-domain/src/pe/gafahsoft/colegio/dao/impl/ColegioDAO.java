package pe.gafahsoft.colegio.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import pe.gafahsoft.colegio.dao.ColegioBeanDAOLocal;
import pe.gafahsoft.colegio.modelo.Colegio;
import pe.gafahsoft.colegio.patron.MantenimientoGeneralDAO;
import pe.gafahsoft.colegio.util.Constantes;
import pe.gafahsoft.colegio.util.Utiles;


public class ColegioDAO extends  MantenimientoGeneralDAO<Colegio> implements ColegioBeanDAOLocal{

	@Override
	public List<Colegio> listar(Colegio parametros) {
		StringBuilder sql = new StringBuilder();
		switch (parametros.getOpcion()) {
		case Constantes.BUSCAR_TODOS:
			sql.append( "select colegio_id                  as   colegioid           ,     " +
					"			 desc_corta                  as   desccorta           ,     " +
					"			 desc_larga                  as   desclarga           ,     " +
					"			 habilitado                  as   habilitado           ,    " +
					"			 usu_reg                     as   usureg           ,        " +
					"			 fec_reg                     as   fecreg           ,        " +
					"			 usu_mod                     as   usumod           ,        " +
					"			 fec_mod                     as   fecmod           ,        " +
					"			 maq_reg                     as   maqreg           ,        " +
					"			 maq_mod                     as   maqmod                    " +
					"			 from colegio                                               " );	
			break;

		
		default:
			break;
		}
		List<Colegio> lista = buscar(sql.toString(), parametros);
		
		return lista;
	}

	@Override
	public int grabar(Colegio parametros) {
		int i = 0;
		StringBuilder sql = new StringBuilder();
		switch (parametros.getOpcion()) {
		case Constantes.INSERTAR:
			sql.append( " insert into colegio (desc, desc_larga, habilitado, usu_reg, fec_reg, maq_reg) values "+Utiles.inParametros(6));	
			break;

		case Constantes.ACTUALIZAR:
			sql.append( " update colegio set desc_corta=?, desc_larga=?, habilitado=?,  usu_mod=?, fec_mod=?,  maq_mod=? where colegio_id=? ");
			break;
		default:
			break;
		}
		

		i = crud(sql.toString(), parametros);

		return i;
	}


	@Override
	public void setParametros(PreparedStatement prepaStatement, Colegio parametros) throws SQLException {
int i = 1;
		
		switch (parametros.getOpcion()) {
		case Constantes.INSERTAR:
			prepaStatement.setString(i++, parametros.getDescCorta());
			prepaStatement.setString(i++, parametros.getDescLarga());
			prepaStatement.setInt(i++, parametros.getHabilitado());
//			prepaStatement.setInt(i++, parametros.getEstado());
			prepaStatement.setString(i++, parametros.getUsuReg());
			prepaStatement.setString(i++, parametros.getMaqReg());
			break;

		case Constantes.ACTUALIZAR:
			prepaStatement.setInt(i++, parametros.getCodColegio());
			break;
		default:
			break;
		}
		
		
	}

	@Override
	public Colegio getFactory() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
