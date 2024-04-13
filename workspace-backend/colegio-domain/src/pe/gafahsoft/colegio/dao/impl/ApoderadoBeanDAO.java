package pe.gafahsoft.colegio.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import pe.gafahsoft.colegio.dao.ApoderadoBeanDAOLocal;
import pe.gafahsoft.colegio.modelo.Apoderado;
import pe.gafahsoft.colegio.patron.MantenimientoGeneralDAO;
import pe.gafahsoft.colegio.util.Constantes;
import pe.gafahsoft.colegio.util.Utiles;

public class ApoderadoBeanDAO extends MantenimientoGeneralDAO<Apoderado> implements ApoderadoBeanDAOLocal{

	@Override
	public List<Apoderado> listar(Apoderado parametros) {
		StringBuilder sql = new StringBuilder();
		switch (parametros.getOpcion()) {
		case Constantes.BUSCAR_TODOS:
			sql.append( " SELECT 	 apod_id as apodId, " +
//					"			dni_alum  as dniAlum   , "+
					"			 	 dni_apod      as dniApod      , "+
					"			 	 nombres	as nombres	, "+
					"			 	 ape_pate	as apepate	, "+
					"			 	 ape_mate	as apemate	, "+
					"			 	 sexo			as sexo			, "+
					"			 	 telefono	as telefono	, "+
					"			 	 tipo_pers	as tipoPers	, "+
					"			 	 email		as email		, "+
					"			 	 fec_naci	as fecnaci	, "+
					"			 	 celular	as celular	, "+
					"			 	 direccion		as direccion		, "+
					"			 	 estado_civil		as estadocivil		, "+
					"			 	 usu_reg	as usureg		, "+
					"			 	 fec_reg	as fecreg		, "+
					"			 	 usu_mod	as usumod		, "+
					"			 	 fec_mod	as fecmod		, "+
					"			 	 maq_reg	as maqreg		, "+
					"			 	 maq_mod  as maqmod     "+
					"	  from apoderado             ");
			break;

		case Constantes.BUSCAR_POR_DNI_ALUMNO:
			sql.append( " SELECT 	 a.apod_id as apodId,  "+
//					+ "  dni_alum  		as dniAlum   , "+
						" 		 	 a.dni_apod      	as dniApod      , "+
						"		 	 a.nombres		as nombres	, "+
						"		 	 a.ape_pate		as apePate	, "+
						"		 	 a.ape_mate		as apeMate	, "+
						"		 	 a.sexo			as sexo			, "+
						"		 	 a.telefono		as telefono	, "+
						"		 	 a.tipo_pers		as tipoPers	, "+
						"		 	 a.email			as email		, "+
						"		 	 a.fec_naci		as fecNaci	, "+
						"		 	 a.celular		as celular	, "+
						"		 	 a.direccion		as direccion		, "+
						"		 	 a.estado_civil	as estadoCivil	, "+
						"		 	 a.ocupacion		, "+
						"		 	 a.centro_trabajo	as centroTrabajo, "+ 
						"		 	 a.telef_trabajo	as telefTrabajo, "+
						"		 	 a.email_trabajo	as emailTrabajo, "+
						"		 	 a.direc_trabajo	as direcTrabajo, "+
						"		 	 a.vive_con_hijo	as viveConHijo "+
						"	  from apoderado a, dependencia d, alumno al where 1=1 and d.alum_id = d.alum_id  and d.apod_id = a.apod_id             ");
			sql.append(" and al.dni_alum = ? ");
			break;	
			
		case Constantes.BUSCAR_TIPO_APODERADO_Y_DNI_ALUMNO:
			sql.append( " SELECT a.apod_id as apodId, "+
//					+ "	 dni_alum  		as dniAlum   , "+
					" 		 	 a.dni_apod      	as dniApod      , "+
					"		 	 a.nombres		as nombres	, "+
					"		 	 a.ape_pate		as apePate	, "+
					"		 	 a.ape_mate		as apeMate	, "+
					"		 	 a.sexo			as sexo			, "+
					"		 	 a.telefono		as telefono	, "+
					"		 	 a.tipo_pers		as tipoPers	, "+
					"		 	 a.email			as email		, "+
					"		 	 a.fec_naci		as fecNaci	, "+
					"		 	 a.celular		as celular	, "+
					"		 	 a.direccion		as direccion		, "+
					"		 	 a.estado_civil	as estadoCivil	, "+
					"		 	 a.ocupacion		, "+
					"		 	 a.centro_trabajo	as centroTrabajo, "+ 
					"		 	 a.telef_trabajo	as telefTrabajo, "+
					"		 	 a.email_trabajo	as emailTrabajo, "+
					"		 	 a.direc_trabajo	as direcTrabajo, "+
					"		 	 a.vive_con_hijo	as viveConHijo "+
					"	  from apoderado a, dependiente d, alumno al where 1=1 and d.alum_id = al.alum_id  and d.apod_id = a.apod_id             ");
		sql.append(" and al.dni_alum = ? ");
		sql.append(" and a.tipo_pers = ? ");
			break;
		case Constantes.BUSCAR_POR_DNI_APODERADO:
			sql.append(" SELECT apod_id as apodId , ");
			sql.append(" dni_apod as dniApod ");
			sql.append(" from apoderado ");
			sql.append(" where 1=1 ");
			sql.append(" and dni_apod = ? ");
		
			break;
		case Constantes.BUSCAR_POR_DNI_APODERADO_TIP_APO:
			sql.append(" SELECT  a.apod_id as apodId, "+
					" 		 	 a.dni_apod      	as dniApod      , "+
					"		 	 a.nombres		as nombres	, "+
					"		 	 a.ape_pate		as apePate	, "+
					"		 	 a.ape_mate		as apeMate	, "+
					"		 	 a.sexo			as sexo			, "+
					"		 	 a.telefono		as telefono	, "+
					"		 	 a.tipo_pers		as tipoPers	, "+
					"		 	 a.email			as email		, "+
					"		 	 a.fec_naci		as fecNaci	, "+
					"		 	 a.celular		as celular	, "+
					"		 	 a.direccion		as direccion		, "+
					"		 	 a.estado_civil	as estadoCivil	, "+
					"		 	 a.ocupacion		, "+
					"		 	 a.centro_trabajo	as centroTrabajo, "+ 
					"		 	 a.telef_trabajo	as telefTrabajo, "+
					"		 	 a.email_trabajo	as emailTrabajo, "+
					"		 	 a.direc_trabajo	as direcTrabajo, "+
					"		 	 a.vive_con_hijo	as viveConHijo ");
			sql.append(" from apoderado a ");
			sql.append(" where 1=1 ");
			sql.append(" and a.dni_apod = ? ");
			sql.append(" and a.tipo_pers = ? ");
			break;
		default:
			break;
		}
		System.out.println("sql "+sql);
		List<Apoderado> lista = buscar(sql.toString(), parametros);
		return lista;
	}

	@Override
	public int grabar(Apoderado parametros) {
		StringBuilder sql = new StringBuilder();
		int i = 0;
		
		switch (parametros.getOpcion()) {
		case Constantes.INSERTAR:
			sql.append( " insert into apoderado (dni_apod, nombres, ape_pate, ape_mate, sexo, telefono, tipo_pers, email, fec_naci, celular, direccion, ");
			sql.append(" ocupacion, centro_trabajo, telef_trabajo, anexo_trabajo, email_trabajo, direc_trabajo, vive_con_hijo, ");
			sql.append(" estado_civil, usu_reg, maq_reg) values "+Utiles.inParametros(21));	
			break;

		case Constantes.ACTUALIZAR:
			sql.append( " update apoderado set nombres=?, ape_pate=?, ape_mate=?, sexo=?, telefono=?, tipo_pers=?, email=?, fec_naci=?, celular=?, direccion=?, "
					+" ocupacion=?, centro_trabajo=?, telef_trabajo=?, anexo_trabajo=?, email_trabajo=?, direc_trabajo=?, vive_con_hijo=?, "
					+ " estado_civil=?, usu_reg=?,  maq_reg=?, fec_mod=now() where dni_apod =?  ");
			break;
		default:
			break;
		}
		i = crud(sql.toString(), parametros);

		return i;
	}



	@Override
	public void setParametros(PreparedStatement prepaStatement, Apoderado parametros) throws SQLException {
		int i = 1;
		
		switch (parametros.getOpcion()) {
		case Constantes.INSERTAR:
//			prepaStatement.setString(i++, parametros.getDniAlum());
			prepaStatement.setString(i++, parametros.getDniApod());
			prepaStatement.setString(i++, parametros.getNombres());
			prepaStatement.setString(i++, parametros.getApePate());
			prepaStatement.setString(i++, parametros.getApeMate());
			prepaStatement.setInt(i++, parametros.getSexo());
			prepaStatement.setString(i++, parametros.getTelefono());
			prepaStatement.setInt(i++, parametros.getTipoPers());
			prepaStatement.setString(i++, parametros.getEmail());
			prepaStatement.setDate(i++, parametros.getFecNaci()==null?null:new java.sql.Date(parametros.getFecNaci().getTime()));
			prepaStatement.setString(i++, parametros.getCelular());
			prepaStatement.setString(i++, parametros.getDireccion());
			prepaStatement.setString(i++, parametros.getOcupacion());
			prepaStatement.setString(i++, parametros.getCentroTrabajo());
			prepaStatement.setString(i++, parametros.getTelefTrabajo());
			prepaStatement.setString(i++, parametros.getAnexoTrabajo());
			prepaStatement.setString(i++, parametros.getEmailTrabajo());
			prepaStatement.setString(i++, parametros.getDirecTrabajo());
			prepaStatement.setInt(i++, parametros.getViveConHijo());
			prepaStatement.setInt(i++, parametros.getEstadoCivil());//estado civil
			prepaStatement.setString(i++, parametros.getUsuReg());
			prepaStatement.setString(i++, parametros.getUsuMod());
			break;

		case Constantes.ACTUALIZAR:
//			prepaStatement.setString(i++, parametros.getDniAlum());
			prepaStatement.setString(i++, parametros.getNombres());
			prepaStatement.setString(i++, parametros.getApePate());
			prepaStatement.setString(i++, parametros.getApeMate());
			prepaStatement.setInt(i++, parametros.getSexo());
			prepaStatement.setString(i++, parametros.getTelefono());
			prepaStatement.setInt(i++, parametros.getTipoPers());
			prepaStatement.setString(i++, parametros.getEmail());
			prepaStatement.setDate(i++, parametros.getFecNaci()==null?null:new java.sql.Date(parametros.getFecNaci().getTime()));
			prepaStatement.setString(i++, parametros.getCelular());
			prepaStatement.setString(i++, parametros.getDireccion());
			prepaStatement.setString(i++, parametros.getOcupacion());
			prepaStatement.setString(i++, parametros.getCentroTrabajo());
			prepaStatement.setString(i++, parametros.getTelefTrabajo());
			prepaStatement.setString(i++, parametros.getAnexoTrabajo());
			prepaStatement.setString(i++, parametros.getEmailTrabajo());
			prepaStatement.setString(i++, parametros.getDirecTrabajo());
			prepaStatement.setInt(i++, parametros.getViveConHijo());
			prepaStatement.setInt(i++, parametros.getEstadoCivil());//estado civil
			prepaStatement.setString(i++, parametros.getUsuReg());
			prepaStatement.setString(i++, parametros.getUsuMod());
			prepaStatement.setString(i++, parametros.getDniApod());
			break;
			 
		case Constantes.BUSCAR_POR_DNI_ALUMNO:
			prepaStatement.setString(i++, parametros.getDniAlum());
			break;
		
		case Constantes.BUSCAR_TIPO_APODERADO_Y_DNI_ALUMNO:
			prepaStatement.setString(i++, parametros.getDniAlum());
			prepaStatement.setInt(i++, parametros.getTipoPers());
			break;
		case Constantes.BUSCAR_POR_DNI_APODERADO:
			prepaStatement.setString(i++, parametros.getDniApod());
			break;
		case Constantes.BUSCAR_POR_DNI_APODERADO_TIP_APO:
			prepaStatement.setString(i++, parametros.getDniApod());
			prepaStatement.setInt(i++, parametros.getTipoPers());
			break;
		default:
			break;
		}
		
		
	}

	@Override
	public Apoderado getFactory() {
		// TODO Auto-generated method stub
		return new Apoderado();
	}

}
