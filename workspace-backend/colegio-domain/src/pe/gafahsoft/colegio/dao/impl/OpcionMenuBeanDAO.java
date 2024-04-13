package pe.gafahsoft.colegio.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import pe.gafahsoft.colegio.dao.OpcionMenuBeanDAOLocal;
import pe.gafahsoft.colegio.modelo.OpcionesMenu;
import pe.gafahsoft.colegio.patron.MantenimientoGeneralDAO;
import pe.gafahsoft.colegio.util.Constantes;
import pe.gafahsoft.colegio.util.Utiles;

public class OpcionMenuBeanDAO extends MantenimientoGeneralDAO<OpcionesMenu> implements OpcionMenuBeanDAOLocal {

	@Override
	public List<OpcionesMenu> listar(OpcionesMenu parametros) {
		StringBuilder sql = new StringBuilder();
		switch (parametros.getOpcion()) {
		case Constantes.BUSCAR_TODOS:
			sql.append( 		"select opc_menu_id                 as   opcmenuid           ,     " +
							"			 menu_id                     as   menuid           ,        " +
							"			 usu_id                      as   usuid           ,         " +
							"			 habilitado                  as   habilitado           ,    " +
							"			 usu_reg                     as   usureg           ,        " +
							"			 fec_reg                     as   fecreg           ,        " +
							"			 usu_mod                     as   usumod           ,        " +
							"			 fec_mod                     as   fecmod           ,        " +
							"			 maq_reg                     as   maqreg           ,        " +
							"			 maq_mod                     as   maqmod                    " +
							"			 from opciones_menu                                         " );	
			break;

		
		default:
			break;
		}
		List<OpcionesMenu> lista = buscar(sql.toString(), parametros);
		
		return lista;
	}

	@Override
	public int grabar(OpcionesMenu parametros) {
		int i = 0;
		StringBuilder sql = new StringBuilder();
		switch (parametros.getOpcion()) {
		case Constantes.INSERTAR:
			sql.append( " insert into opciones_menu (menu_id, usu_id, habilitado, usu_reg, fec_reg, maq_reg) values "+Utiles.inParametros(6));		
			break;

		case Constantes.ACTUALIZAR:
			sql.append( " update opciones_menu set menu_id=?, usu_id=?, habilitado=?, usu_mod=?, fec_mod=?, maq_mod=? where opc_menu_id=?");	
			break;
		default:
			break;
		}
		

		i = crud(sql.toString(), parametros);

		return i;
	}

	@Override
	public void setParametros(PreparedStatement prepaStatement, OpcionesMenu parametros) throws SQLException {
		int i = 1;
		switch (parametros.getOpcion()) {
		case Constantes.INSERTAR:
			prepaStatement.setInt(i++,parametros.getMenuId());
			prepaStatement.setInt(i++,parametros.getUsuId());
			prepaStatement.setInt(i++,parametros.getHabilitado());
			prepaStatement.setString(i++, parametros.getUsuReg());
			prepaStatement.setString(i++, parametros.getMaqReg());
			
			break;

		case Constantes.ACTUALIZAR:
			prepaStatement.setInt(i++, parametros.getOpcMenuId());
			break;
		case Constantes.BUSCAR_TODOS:
			prepaStatement.setInt(i++, parametros.getOpcMenuId());
			
			break;	
			
		default:
			break;
		}
		
	}

	@Override
	public List<OpcionesMenu> getOpcionesMenus(OpcionesMenu parametros) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OpcionesMenu getFactory() {
		// TODO Auto-generated method stub
		return null;
	}

}
