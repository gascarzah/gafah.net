package pe.gafahsoft.colegio.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import pe.gafahsoft.colegio.dao.AlumnoBeanDAOLocal;
import pe.gafahsoft.colegio.modelo.Alumno;
import pe.gafahsoft.colegio.patron.MantenimientoGeneralDAO;
import pe.gafahsoft.colegio.util.Constantes;
import pe.gafahsoft.colegio.util.Utiles;


public class AlumnoBeanDAO extends MantenimientoGeneralDAO<Alumno> implements AlumnoBeanDAOLocal {

	@Override
	public List<Alumno> listar(Alumno parametros) {
		StringBuilder sql = new StringBuilder();
		sql.append( 	" SELECT alum_id as alumId, "
				+ "				dni_alum      as dniAlum      , "+
				"			 	 nombres	as nombres	, "+
				"			 	 ape_pate	as apePate	, "+
				"			 	 ape_mate	as apeMate	, "+
				"			 	 sexo			as sexo			, "+
				"			 	 fec_naci	as fecNaci	, "+
				"			 	 direccion		as direccion		, "+
				"			 	 telefono	as telefono	, "+
				"			 	 email		as email		, "+
				"			 	 estado		as estado		, "+
				"			 	 usu_reg	as usuReg		, "+
//				"			 	 fec_reg	as fecReg		, "+
//				"			 	 usu_mod	as usuMod		, "+
//				"			 	 fec_mod	as fecMod		, "+
				"			 	 maq_reg	as maqReg		 "+
//				"			 	 maq_mod  as maqMod     "+
				"	  from alumno   where estado =?              ");
			
		switch (parametros.getOpcion()) {
		case Constantes.BUSCAR_TODOS:
         
			break;
		
		
		case Constantes.BUSCAR_POR_DNI_ALUMNO:
			sql = new StringBuilder();
			sql.append( 	" SELECT alum_id as alumId,"+
					 "		dni_alum      as dniAlum      , "+
					"			 	 nombres	as nombres	, "+
					"			 	 ape_pate	as apePate	, "+
					"			 	 ape_mate	as apeMate	, "+
					"			 	 sexo			as sexo			, "+
					"			 	 fec_naci	as fecNaci	, "+
					"			 	 direccion		as direccion		, "+
					"			 	 telefono	as telefono	, "+
					"			 	 email		as email		, "+
					"			 	 telef_emergencia		as telefEmergencia		, "+
					"			 	 contact_emergencia		as contactEmergencia		, "+
					"			 	 seg_escolar		as segEscolar		, "+
					"			 	 estado		as estado		 "+
					"	  from alumno   where estado =?              ");
			sql.append(" and dni_alum = ? ");
			
			break;	
		
		
			
		}
		
		System.out.println("sql >>>" + sql.toString());
		List<Alumno> lista = buscar(sql.toString(), parametros);
		
		return lista;
		
	}

	@Override
	public int grabar(Alumno parametros) {
		int i = 0;
		StringBuilder sql = new StringBuilder();
		switch (parametros.getOpcion()) {
		case Constantes.INSERTAR:
			sql.append( " insert into alumno (dni_alum, nombres, ape_pate, ape_mate, sexo, fec_naci, direccion, telefono, email, telef_emergencia, contact_emergencia, seg_escolar, estado, usu_reg, maq_reg ) values "+Utiles.inParametros(15));	
			break;

		case Constantes.ACTUALIZAR:
			sql.append( " update alumno set nombres = ?, ape_pate= ?, ape_mate= ?, sexo= ?, fec_naci= ?, direccion= ?, telefono= ?, email= ?, telef_emergencia=?,contact_emergencia=?, seg_escolar=?, estado= ?, usu_mod= ?, fec_mod= now(), maq_mod = ? where dni_alum = ? ");
			break;
		default:
			break;
		}
		

		i = crud(sql.toString(), parametros);

		return i;
	}

	

	@Override
	public void setParametros(PreparedStatement prepaStatement, Alumno parametros) throws SQLException {
		int i = 1;
		
		switch (parametros.getOpcion()) {
		case Constantes.INSERTAR:
			prepaStatement.setString(i++, parametros.getDniAlum());
			prepaStatement.setString(i++, parametros.getNombres());
			prepaStatement.setString(i++, parametros.getApePate());
			prepaStatement.setString(i++, parametros.getApeMate());
			prepaStatement.setInt(i++, parametros.getSexo());
			prepaStatement.setDate(i++, parametros.getFecNaci()==null?null:new java.sql.Date(parametros.getFecNaci().getTime()));
//			prepaStatement.setDate(i++, new java.sql.Date(Utiles.convertirFechaDate("21/03/2015").getTime()));
			
			prepaStatement.setString(i++, parametros.getDireccion());
			prepaStatement.setString(i++, parametros.getTelefono());
			prepaStatement.setString(i++, parametros.getEmail());
			prepaStatement.setString(i++, parametros.getTelefEmergencia());
			prepaStatement.setString(i++, parametros.getContactEmergencia());
			prepaStatement.setInt(i++, parametros.getSegEscolar());
			prepaStatement.setInt(i++, parametros.getEstado());
			prepaStatement.setString(i++, parametros.getUsuReg());
			prepaStatement.setString(i++, parametros.getMaqReg());
			break;

		case Constantes.ACTUALIZAR:
			
			prepaStatement.setString(i++, parametros.getNombres());
			prepaStatement.setString(i++, parametros.getApePate());
			prepaStatement.setString(i++, parametros.getApeMate());
			prepaStatement.setInt(i++, parametros.getSexo());
			prepaStatement.setDate(i++, parametros.getFecNaci()==null?null:new java.sql.Date(parametros.getFecNaci().getTime()));
			
			prepaStatement.setString(i++, parametros.getDireccion());
			prepaStatement.setString(i++, parametros.getTelefono());
			prepaStatement.setString(i++, parametros.getEmail());
			prepaStatement.setString(i++, parametros.getTelefEmergencia());
			prepaStatement.setString(i++, parametros.getContactEmergencia());
			prepaStatement.setInt(i++, parametros.getSegEscolar());
			prepaStatement.setInt(i++, parametros.getEstado());
			prepaStatement.setString(i++, parametros.getUsuReg());
			prepaStatement.setString(i++, parametros.getMaqReg());
			prepaStatement.setString(i++, parametros.getDniAlum());
			break;
		
		case Constantes.BUSCAR_TODOS:
			prepaStatement.setInt(i++, parametros.getEstado());
			break;
		
		case Constantes.BUSCAR_POR_DNI_ALUMNO:
			prepaStatement.setInt(i++, parametros.getEstado());
			prepaStatement.setString(i++, parametros.getDniAlum());
			break;
		
		default:
			break;
		}
		

		
	}

	@Override
	public Alumno getFactory() {
		// TODO Auto-generated method stub
		return new Alumno();
	}

	
	
}
