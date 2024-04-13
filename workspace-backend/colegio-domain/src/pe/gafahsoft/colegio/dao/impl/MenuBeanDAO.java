package pe.gafahsoft.colegio.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import pe.gafahsoft.colegio.dao.MenuBeanDAOLocal;
import pe.gafahsoft.colegio.modelo.Menu;
import pe.gafahsoft.colegio.patron.MantenimientoGeneralDAO;
import pe.gafahsoft.colegio.util.Constantes;

public class MenuBeanDAO extends MantenimientoGeneralDAO<Menu> implements MenuBeanDAOLocal {


	

	@Override
	public List<Menu> listar(Menu parametros) {
		StringBuilder sql = new StringBuilder();
		sql.append(" select m.menu_id as menuId , " +
				 " m.padre_id   as   padreId  , " +
				 " m.desc_larga as   descLarga, " +
				 " m.estado     as   estado   , " +
				 " m.url        as url  " +
				 " from menu m                  " +
				 " where m.estado = ? ");
		switch (parametros.getOpcion()) {
		case Constantes.BUSCAR_TODOS:
			
			
			
			break;

		case Constantes.BUSCAR_POR_PADRE:
			sql.append(" and m.padre_id = ? ");
			break;
		

		default:
			break;
		}
		
		sql.append(" order by m.desc_larga ");
		
		List<Menu> lista = buscar(sql.toString(), parametros);
		
		return lista;
	}

	@Override
	public int grabar(Menu parametros) {
		StringBuilder sql = new StringBuilder();
		int i = 0;
		
		switch (parametros.getOpcion()) {
		case Constantes.INSERTAR:
			sql.append( " insert into menu padre_id=?, desc=?, estado=?, url=?, usu_reg=?, fec_reg=?, maq_reg=? from menu ");		
			break;

		case Constantes.ACTUALIZAR:
			sql.append( " update menu set padre_id=?, desc=?, estado=?, url=?, usu_mod=?, fec_mod=?, maq_mod=? from menu where menu_id = ? ");	
			break;
		default:
			break;
		}
		

		i = crud(sql.toString(), parametros);

		return i;
	}



	@Override
	public void setParametros(PreparedStatement prepaStatement, Menu parametros) throws SQLException {
		int i = 1;
		switch (parametros.getOpcion()) {
		case Constantes.INSERTAR:
			prepaStatement.setInt(i++,parametros.getPadreId());
			prepaStatement.setString(i++,parametros.getDescLarga());
			prepaStatement.setInt(i++,parametros.getEstado());
			prepaStatement.setString(i++,parametros.getUrl());
			prepaStatement.setString(i++, parametros.getUsuReg());
			prepaStatement.setString(i++, parametros.getMaqReg());
			
			break;

		case Constantes.ACTUALIZAR:
			prepaStatement.setInt(i++, parametros.getMenuId());
			break;
		case Constantes.BUSCAR_TODOS:
			prepaStatement.setInt(i++, parametros.getEstado());
			
			
			break;	
		case Constantes.BUSCAR_POR_PADRE:
			prepaStatement.setInt(i++, parametros.getEstado());
			prepaStatement.setInt(i++, parametros.getMenuId());
			
			break;	

		default:
			break;
		}
		
	}

	@Override
	public List<Menu> getObtenerMenuPorPadre(Menu parametros) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Menu getFactory() {
		// TODO Auto-generated method stub
		return new Menu();
	}
	
	
}
