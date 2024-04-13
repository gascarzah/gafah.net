package pe.gafahsoft.colegio.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import pe.gafahsoft.colegio.bean.MatriculadoBean;
import pe.gafahsoft.colegio.dao.MatriculaBeanDAOLocal;
import pe.gafahsoft.colegio.modelo.Alumno;
import pe.gafahsoft.colegio.modelo.Matricula;
import pe.gafahsoft.colegio.patron.MantenimientoGeneralDAO;
import pe.gafahsoft.colegio.util.Constantes;
import pe.gafahsoft.colegio.util.Utiles;


public class MatriculaBeanDAO extends MantenimientoGeneralDAO<Matricula> implements MatriculaBeanDAOLocal{

	@Override
	public List<Matricula> listar(Matricula parametros) {
		StringBuilder sql = null;
		switch (parametros.getOpcion()) {
		case Constantes.BUSCAR_TODOS:
			sql = new StringBuilder();
			sql.append( "select matri_id                    as   matriId           ,       " +
					"			 alum_id                     as   alumId           ,        " +
					"			 aula_id                     as   aulaid           ,        " +
					"			 fec_matri                   as   fecmatri           ,      " +
					"			 observ                      as   observ           ,        " +
					"			 estado                      as   estado           ,        " +
					"			 anio                        as   anio           ,          " +
					"			 usu_reg                     as   usureg           ,        " +
					"			 fec_reg                     as   fecreg           ,        " +
					"			 usu_mod                     as   usumod           ,        " +
					"			 fec_mod                     as   fecmod           ,        " +
					"			 maq_reg                     as   maqreg           ,        " +
					"			 cod_colegio                  as  codColegio           ,     " +
					"			 maq_mod                     as   maqmod                    " +
					"			 from matricula                                             " );	
			break;
		
		case Constantes.BUSCAR_MATRICULA_POR_ANIO:
			sql = new StringBuilder();
			sql.append( "select m.matri_id                    as   matriId           ,       " +
					"			 al.dni_alum                     as   dniAlum         ,         " +
					"			 m.alum_id                     as   alumId                  " +
					"			 from matricula m, alumno al                                             " );	
			sql.append(" where al.alum_id = m.alum_id and al.dni_alum = ? ");
			sql.append(" and m.anio = ? ");
			sql.append(" and m.estado = ? ");
			
			//poner anio
			break;
			
		case Constantes.BUSCAR_MATRICULA_DNI_ALUMNO:
			sql = new StringBuilder();
			sql.append( "select m.matri_id                    as   matriId           ,       " +
					"			 al.dni_alum                     as   dniAlum         ,         " +
					"			 m.alum_id                     as   alumId                  " +
					"			 from matricula m, alumno al                                             " );	
			sql.append(" where al.alum_id = m.alum_id and al.dni_alum = ? ");
			sql.append(" and m.estado = ? ");
			//poner anio
			break;
		
		default:
			break;
		}

		List<Matricula> lista = buscar(sql.toString(), parametros);

		
		return lista;
	}

	@Override
	public int grabar(Matricula parametros) {
		int i = 0;
		StringBuilder sql = new StringBuilder();
		switch (parametros.getOpcion()) {
		case Constantes.INSERTAR:
			sql.append( " insert into matricula (alum_id, nivel, cod_colegio, fec_matri, observ, estado, anio, usu_reg,  maq_reg) values "+Utiles.inParametros(9));
			break;

		case Constantes.ACTUALIZAR:
			sql.append( " update matricula set alum_id = ?, nivel=?, fec_matri=?, observ=?, estado=?, anio=?, usu_mod=?, fec_mod=now(), maq_mod=? where  matri_id=?  ");
			break;
		default:
			break;
		}
		

		i = crud(sql.toString(), parametros);

		return i;
	}

	

	@Override
	public void setParametros(PreparedStatement prepaStatement, Matricula parametros) throws SQLException {
		int i = 1;
		switch (parametros.getOpcion()) {
		case Constantes.INSERTAR:
			prepaStatement.setInt(i++,parametros.getAlumId());
			prepaStatement.setInt(i++,parametros.getNivel());
			prepaStatement.setInt(i++,parametros.getCodColegio()); //agregar cuando se logee parametros.getColegioId()
			prepaStatement.setDate(i++,new java.sql.Date(new Date().getTime()));
			prepaStatement.setString(i++,parametros.getObserv());
			prepaStatement.setInt(i++,parametros.getEstado());
			prepaStatement.setString(i++,parametros.getAnio());
			prepaStatement.setString(i++, parametros.getUsuReg());
			prepaStatement.setString(i++, parametros.getMaqReg());
			
			break;

		case Constantes.ACTUALIZAR:
			prepaStatement.setInt(i++,parametros.getAlumId());
			prepaStatement.setInt(i++,parametros.getNivel());
			prepaStatement.setDate(i++,new java.sql.Date(new Date().getTime()));
			prepaStatement.setString(i++,parametros.getObserv());
			prepaStatement.setInt(i++,parametros.getEstado());
			prepaStatement.setString(i++,parametros.getAnio());
			prepaStatement.setString(i++, parametros.getUsuReg());
			prepaStatement.setString(i++, parametros.getMaqReg());
			prepaStatement.setInt(i++,parametros.getMatriId());
			break;
		case Constantes.BUSCAR_TODOS:
			prepaStatement.setInt(i++, parametros.getMatriId());
			
			break;	
		case Constantes.BUSCAR_MATRICULA_DNI_ALUMNO:
			prepaStatement.setString(i++,parametros.getDniAlum());
			prepaStatement.setInt(i++,parametros.getEstado());
			break;
			
		case Constantes.BUSCAR_MATRICULA_POR_ANIO:
			prepaStatement.setString(i++,parametros.getDniAlum());
			prepaStatement.setString(i++,parametros.getAnio());
			prepaStatement.setInt(i++,parametros.getEstado());
			break;
			
		default:
			break;
		}
		
		
	}

	@Override
	public Matricula getFactory() {
		// TODO Auto-generated method stub
		return new Matricula();
	}

	public List<MatriculadoBean> listarMatriculados(Alumno parametro){
		int i = 1;
		List<MatriculadoBean> lista = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
			sql.append(" select m.matri_id matriId, " + 
						" (select concat(IFNULL(ms.valor,''), ' ', IFNULL(ms.desc_larga,''), ' ', IFNULL(ms.desc_corta,'')) "+ 
						" from maestra ms where ms.maes_id = m.nivel) grado, " +
						" m.nivel nivel, " + 
						" (select ms.maes_padre_id "+ 
						" from maestra ms where ms.maes_id = m.nivel) nivelPadre, " + 
						" concat(a.ape_pate, ' ', a.ape_mate, ', ', a.nombres) alumno,  "+ 
						" (select ms.valor  from maestra ms where ms.maes_id = a.sexo) sexo, "+
						" a.dni_alum dniAlum, "+ 
						" a.fec_naci fecNaci, "+ 
						" m.anio ,"+ 
						" a.ape_pate  paterno ,"+
						" a.ape_mate  materno ,"+
						" a.nombres  nombres, "+
						" a.alum_id  alumId "+
						" from matricula m, alumno a "+ 
						" where m.alum_id = a.alum_id ");
			
			
			if(parametro.getNivel() != null && parametro.getNivel()!=-1){
				sql.append(" and m.nivel = ? ");
			}
			
			if(StringUtils.isNotEmpty(parametro.getApePate())){
				sql.append(" and a.ape_pate like ? '%' ");
			}
			if(StringUtils.isNotEmpty(parametro.getApeMate())){
				sql.append(" and a.ape_mate like ? '%' ");
			}
			if(StringUtils.isNotEmpty(parametro.getNombres())){
				sql.append(" and a.nombres like ? '%' ");
			}
			
			if(StringUtils.isNotEmpty(parametro.getDniAlum())){
				sql.append(" and a.dni_alum = ?");
			}
			
			sql.append(" and m.cod_colegio = ? ");
			sql.append(" and m.anio = ? ");
			sql.append(" order by a.ape_pate");
			System.out.println("sql >>>> "+sql.toString());
			try {
				connection = dataSource.getConnection();
				prepaStatement = connection.prepareStatement(sql.toString());
				
				if(parametro.getNivel() != null && parametro.getNivel()!=-1){
					prepaStatement.setInt(i++, parametro.getNivel());
				}
				
				if(StringUtils.isNotEmpty(parametro.getApePate())){
					prepaStatement.setString(i++, parametro.getApePate());
				}
				if(StringUtils.isNotEmpty(parametro.getApeMate())){
					prepaStatement.setString(i++, parametro.getApeMate());
				}
				if(StringUtils.isNotEmpty(parametro.getNombres())){
					prepaStatement.setString(i++, parametro.getNombres());
				}
				
				if(StringUtils.isNotEmpty(parametro.getDniAlum())){
					prepaStatement.setString(i++, parametro.getDniAlum());
				}
				
				prepaStatement.setInt(i++, parametro.getCodColegio());
				prepaStatement.setString(i++, parametro.getAnio());
				
				
				resultSet = prepaStatement.executeQuery();
				while(resultSet.next()){
					MatriculadoBean objCons = getMatriculados();
					objCons.setMatriId(resultSet.getInt("matriId"));
					objCons.setNivel(resultSet.getInt("nivel"));
					objCons.setNivelPadre(resultSet.getInt("nivelPadre"));
					objCons.setGrado(resultSet.getString("grado"));
					objCons.setDni(resultSet.getString("dniAlum"));
					objCons.setAlumno(resultSet.getString("alumno"));
					objCons.setAnio(resultSet.getString("anio"));
					objCons.setSexo(resultSet.getString("sexo"));
					objCons.setFecNaci(resultSet.getDate("fecNaci"));
					objCons.setApePate(resultSet.getString("paterno"));
					objCons.setApeMate(resultSet.getString("materno"));
					objCons.setNombres(resultSet.getString("nombres"));
					objCons.setAlumId(resultSet.getInt("alumId"));
					lista.add(objCons);
				}
				
				System.out.println("tamaño de la lista de matriculados "+lista.size());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				closeResultSet(resultSet);
				closePreparedStatement(prepaStatement);
				closeConnection(connection);
			}
			
					
		return lista;
	}

	public MatriculadoBean getMatriculados() {
		// TODO Auto-generated method stub
		return new MatriculadoBean();
	}

	@Override
	public List<MatriculadoBean> listarAlumnos(Alumno parametro) {
		int i = 1;
		List<MatriculadoBean> lista = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
			sql.append(" select concat(a.ape_pate, ' ', a.ape_mate, ', ', a.nombres) alumno,  "+ 
						" (select ms.valor  from maestra ms where ms.maes_id = a.sexo) sexo, "+
						" a.dni_alum dniAlum, "+
						" a.alum_id alumId, "+ 
						" a.fec_naci fecNaci, "+ 
						" a.ape_pate  paterno ,"+
						" a.ape_mate  materno ,"+
						" a.nombres  nombres "+
						" from alumno a "+ 
						" where 1 =1 ");
			
			
			
			
			if(StringUtils.isNotEmpty(parametro.getApePate())){
				sql.append(" and a.ape_pate like ? '%' ");
			}
			if(StringUtils.isNotEmpty(parametro.getApeMate())){
				sql.append(" and a.ape_mate like ? '%' ");
			}
			if(StringUtils.isNotEmpty(parametro.getNombres())){
				sql.append(" and a.nombres like ? '%' ");
			}
			
			if(StringUtils.isNotEmpty(parametro.getDniAlum())){
				sql.append(" and a.dni_alum = ?");
			}
			sql.append(" order by a.ape_pate");
			
			try {
				connection = dataSource.getConnection();
				prepaStatement = connection.prepareStatement(sql.toString());
				
			
				if(StringUtils.isNotEmpty(parametro.getApePate())){
					prepaStatement.setString(i++, parametro.getApePate());
				}
				if(StringUtils.isNotEmpty(parametro.getApeMate())){
					prepaStatement.setString(i++, parametro.getApeMate());
				}
				if(StringUtils.isNotEmpty(parametro.getNombres())){
					prepaStatement.setString(i++, parametro.getNombres());
				}
				
				if(StringUtils.isNotEmpty(parametro.getDniAlum())){
					prepaStatement.setString(i++, parametro.getDniAlum());
				}
				
								
				
				resultSet = prepaStatement.executeQuery();
				while(resultSet.next()){
					MatriculadoBean objCons = getMatriculados();
					objCons.setDni(resultSet.getString("dniAlum"));
					objCons.setAlumno(resultSet.getString("alumno"));
						objCons.setSexo(resultSet.getString("sexo"));
					objCons.setFecNaci(resultSet.getDate("fecNaci"));
					objCons.setApePate(resultSet.getString("paterno"));
					objCons.setApeMate(resultSet.getString("materno"));
					objCons.setNombres(resultSet.getString("nombres"));
					objCons.setAlumId(resultSet.getInt("alumId"));					
					lista.add(objCons);
				}
				
				System.out.println("tamaño de la lista de matriculados "+lista.size());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				closeResultSet(resultSet);
				closePreparedStatement(prepaStatement);
				closeConnection(connection);
			}
			
					
		return lista;
	}
}
