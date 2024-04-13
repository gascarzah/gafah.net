package pe.gafahsoft.colegio.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import pe.gafahsoft.colegio.dao.UsuarioBeanDAOLocal;
import pe.gafahsoft.colegio.modelo.Usuario;
import pe.gafahsoft.colegio.patron.MantenimientoGeneralDAO;
import pe.gafahsoft.colegio.util.Constantes;
import pe.gafahsoft.colegio.util.Utiles;

public class UsuarioBeanDAO extends MantenimientoGeneralDAO<Usuario> implements UsuarioBeanDAOLocal{
	

	@Override
	public List<Usuario> listar(Usuario parametros) {
		StringBuilder sql = new StringBuilder();
		switch (parametros.getOpcion()) {
		case Constantes.BUSCAR_TODOS:
				sql = new StringBuilder();
				sql.append( " select u.usu_id as usuId, u.emp_id as empId, u.cod_colegio as codColegio, u.login, u.clave, u.perfil, u.estado,"
						+ "concat(e.ape_pate , ' ' , e.ape_mate, ', ', e.nombres) nomUsu "
						+ "from usuario u , empleado e " );
				sql.append( " where u.estado = ?  and u.emp_id = e.emp_id" );
			break;
		case Constantes.LOGIN:
			sql = new StringBuilder();
			sql.append( " select u.usu_id as usuId, u.emp_id as empId, u.cod_colegio as codColegio, u.login, u.clave, u.perfil, u.estado,"
					+ "concat(e.ape_pate , ' ' , e.ape_mate, ', ', e.nombres) nomUsu "
					+ "from usuario u , empleado e " );
			sql.append( " where u.estado = ? and u.login = ? and u.clave = ? and u.emp_id = e.emp_id" );
		break;
		
		default:
			break;
		}
		
		System.out.println("sql >> " + sql);
		List<Usuario> lista = buscar(sql.toString(), parametros);

		return lista;
		
	}

	public int grabar(Usuario parametros) {
		int i = 0;
		StringBuilder sql = new StringBuilder();
		switch (parametros.getOpcion()) {
		case Constantes.INSERTAR:
			sql.append( " insert into usuario (emp_id, login, clave, perfil, estado, cole_id, usu_reg, fec_reg, maq_reg, cod_colegio) values "+Utiles.inParametros(10));		
			break;

		case Constantes.ACTUALIZAR:
			sql.append( " update usuario set  emp_id=?, login=?, clave=?, perfil=?, estado=?, cole_id=?, usu_mod=?, fec_mod=?, maq_mod=?, cod_colegio=? where usu_id=? ");	
			break;
		default:
			break;
		}
		

		i = crud(sql.toString(), parametros);

		return i;
	}

	

	@Override
	public void setParametros(PreparedStatement prepaStatement, Usuario parametros) throws SQLException {
		int i = 1;
		switch (parametros.getOpcion()) {
		case Constantes.INSERTAR:
			prepaStatement.setInt(i++, parametros.getEmpId());
			prepaStatement.setString(i++, parametros.getLogin());
			prepaStatement.setString(i++, parametros.getClave());
			prepaStatement.setString(i++, parametros.getPerfil());

			break;
		case Constantes.ACTUALIZAR:
			prepaStatement.setInt(i++, parametros.getEmpId());
			prepaStatement.setString(i++, parametros.getLogin());
			prepaStatement.setString(i++, parametros.getClave());
			prepaStatement.setString(i++, parametros.getPerfil());
			prepaStatement.setInt(i++, parametros.getUsuId());
			
			break;
			
		case Constantes.BUSCAR_TODOS:
			prepaStatement.setInt(i++, parametros.getUsuId());
			
			break;	
			
		case Constantes.LOGIN:
			prepaStatement.setInt(i++, parametros.getEstado());
			prepaStatement.setString(i++, parametros.getLogin());
			prepaStatement.setString(i++, parametros.getClave());
			break;
		default:
			break;
		}
		
	}

	@Override
	public Usuario getFactory() {
		// TODO Auto-generated method stub
		return new Usuario();
	}

	
}
