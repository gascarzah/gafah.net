package pe.gafahsoft.colegio.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pe.gafahsoft.colegio.dao.EmpleadoBeanDAOLocal;
import pe.gafahsoft.colegio.modelo.Empleado;
import pe.gafahsoft.colegio.patron.MantenimientoGeneralDAO;
import pe.gafahsoft.colegio.util.Constantes;
import pe.gafahsoft.colegio.util.Utiles;

public class EmpleadoBeanDAO extends MantenimientoGeneralDAO<Empleado> implements EmpleadoBeanDAOLocal {

	@Override
	public List<Empleado> listar(Empleado parametros) {
		StringBuilder sql = new StringBuilder();
		List<Empleado> lista = new ArrayList<>();
		switch (parametros.getOpcion()) {
		case Constantes.BUSCAR_TODOS:
			sql.append( "select emp_id                      as   empid           ,         " +
					"			 curso_id                    as   cursoid           ,       " +
					"			 dni                         as   dni           ,           " +
					"			 nombres                     as   nombres           ,       " +
					"			 ape_pate                    as   apepate           ,       " +
					"			 ape_mate                    as   apemate           ,       " +
					"			 direccion                   as   direccion           ,     " +
					"			 telefono                    as   telefono           ,      " +
					"			 celular                     as   celular           ,       " +
					"			 email                       as   email           ,         " +
					"			 estado                      as   estado           ,        " +
					"			 tipo_pers                   as   tipopers           ,      " +
					"			 remunera                    as   remunera           ,      " +
					"			 usu_reg                     as   usureg           ,        " +
					"			 fec_reg                     as   fecreg           ,        " +
					"			 usu_mod                     as   usumod           ,        " +
					"			 fec_mod                     as   fecmod           ,        " +
					"			 maq_reg                     as   maqreg           ,        " +
					"			 maq_mod                     as   maqmod           ,        " +
					"			 cod_colegio                  as   codColegio                 " +
					"			 from empleado                                              " );	
			break;

		
		default:
			break;
		}
		
		lista = buscar(sql.toString(), parametros);
		
		return lista;
	}


	@Override
	public int grabar(Empleado parametros) {
		int i = 0;
		StringBuilder sql = new StringBuilder();
		switch (parametros.getOpcion()) {
		case Constantes.INSERTAR:
			sql.append( " insert into empleado (curso_id, dni, nombres, ape_pate, ape_mate, direccion, telefono, celular, email, estado, tipo_emp, remunera, usu_reg, fec_reg, maq_reg, cod_colegio ) values "+Utiles.inParametros(16));	
			break;

		case Constantes.ACTUALIZAR:
			sql.append( " update empleado set curso_id=?, dni=?, nombres=?, ape_pate=?, ape_mate=?, direccion=?, telefono=?, celular=?, email=?, estado=?, tipo_emp=?, remunera=?, usu_mod=?, fec_mod=?, maq_mod=?, cod_colegio=? where empleado_id=? ");	
			break;
		default:
			break;
		}
		

		i = crud(sql.toString(), parametros);

		return i;
	}

	

	@Override
	public void setParametros(PreparedStatement prepaStatement, Empleado parametros) throws SQLException {
		int i=1;
		switch (parametros.getOpcion()) {
		case Constantes.INSERTAR:
			prepaStatement.setInt(i++, parametros.getCursoId());
			prepaStatement.setString(i++, parametros.getDni());
			prepaStatement.setString(i++, parametros.getNombres());
			prepaStatement.setString(i++, parametros.getApePate());
			prepaStatement.setString(i++, parametros.getApeMate());
			prepaStatement.setString(i++, parametros.getDireccion());
			prepaStatement.setString(i++, parametros.getTelefono());
			prepaStatement.setString(i++, parametros.getCelular());
			prepaStatement.setString(i++, parametros.getEmail());
			prepaStatement.setInt(i++, parametros.getEstado());
			prepaStatement.setInt(i++, parametros.getTipoPers());
			prepaStatement.setBigDecimal(i++, parametros.getRemunera());
			prepaStatement.setString(i++, parametros.getUsuReg());
//			prepaStatement.setDate(i++, parametros.getFecReg());
			prepaStatement.setString(i++, parametros.getMaqReg());
			prepaStatement.setInt(i++, parametros.getCodColegio());
			break;

		case Constantes.ACTUALIZAR:
			prepaStatement.setInt(i++, parametros.getEmpId());
			break;
		default:
			break;
		}

		
	}


	@Override
	public Empleado getFactory() {
		// TODO Auto-generated method stub
		return null;
	}



}
