package pe.gafahsoft.colegio.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import pe.gafahsoft.colegio.dao.NotaBeanDAOLocal;
import pe.gafahsoft.colegio.modelo.Nota;
import pe.gafahsoft.colegio.patron.MantenimientoGeneralDAO;
import pe.gafahsoft.colegio.util.Constantes;
import pe.gafahsoft.colegio.util.Utiles;

public class NotaBeanDAO extends MantenimientoGeneralDAO<Nota> implements NotaBeanDAOLocal{
	
	
	public List<Nota> listar(Nota parametros) {
		StringBuilder sql = new StringBuilder();
		switch (parametros.getOpcion()) {
		case Constantes.BUSCAR_TODOS:
			sql.append( "select nota_id                     as   notaid           ,        " +
			"			 emp_id                      as   empid           ,         " +
			"			 matri_id                    as   matriid           ,       " +
			
			"			 nota_11                      as   nota11           ,         " +
			"			 nota_21                      as   nota21           ,         " +
			"			 nota_31                      as   nota31           ,         " +
			"			 nota_41                      as   nota41           ,         " +
			"			 prom_final_1                 as   promFinal1           ,     " +
			"			 nota_12                      as   nota12           ,         " +
			"			 nota_22                      as   nota22           ,         " +
			"			 nota_32                      as   nota32           ,         " +
			"			 nota_42                      as   nota42           ,         " +
			"			 prom_final_2                 as   promFinal2           ,     " +
			"			 nota_13                      as   nota13           ,         " +
			"			 nota_23                      as   nota23           ,         " +
			"			 nota_33                      as   nota33           ,         " +
			"			 nota_43                      as   nota43           ,         " +
			"			 prom_final_3                 as   promFinal3           ,     " +
			"			 nota_14                      as   nota14           ,         " +
			"			 nota_24                      as   nota24           ,         " +
			"			 nota_34                      as   nota34           ,         " +
			"			 nota_44                      as   nota44           ,         " +
			"			 prom_final_4                 as   promFinal4           ,     " +

			"			 letra_nota_11                      as   letraNota11           ,         " +
			"			 letra_nota_21                      as   letraNota21           ,         " +
			"			 letra_nota_31                      as   letraNota31           ,         " +
			"			 letra_nota_41                      as   letraNota41           ,         " +
			"			 letra_prom_final_1                 as   letraPromFinal1           ,     " +
			"			 letra_nota_12                      as   letraNota12           ,         " +
			"			 letra_nota_22                      as   letraNota22           ,         " +
			"			 letra_nota_32                      as   letraNota32           ,         " +
			"			 letra_nota_42                      as   letraNota42           ,         " +
			"			 letra_prom_final_2                 as   letraPromFinal2           ,     " +
			"			 letra_nota_13                      as   letraNota13           ,         " +
			"			 letra_nota_23                      as   letraNota23           ,         " +
			"			 letra_nota_33                      as   letraNota33           ,         " +
			"			 letra_nota_43                      as   letraNota43           ,         " +
			"			 letra_prom_final_3                 as   letraPromFinal3           ,     " +
			"			 letra_nota_14                      as   letraNota14           ,         " +
			"			 letra_nota_24                      as   letraNota24           ,         " +
			"			 letra_nota_34                      as   letraNota34           ,         " +
			"			 letra_nota_44                      as   letraNota44           ,         " +
			"			 letra_prom_final_4                 as   letraPromFinal4           ,     " +
			
			
			"			 usu_reg                     as   usureg           ,        " +
			"			 fec_reg                     as   fecreg           ,        " +
			"			 usu_mod                     as   usumod           ,        " +
			"			 fec_mod                     as   fecmod           ,        " +
			"			 maq_reg                     as   maqreg           ,        " +
			"			 maq_mod                     as   maqmod                    " +
			"			 from nota                                                  ") ;	
			break;

		case Constantes.BUSCAR_POR_NIVEL:
			sql.append( "select n.nota_id                     as   notaId           ,        " +
					"			n.emp_id                      as   empId           ,         " +
					"			n.matri_id                    as   matriId           ,       " +

			"			 n.nota_11                      as   nota11           ,         " +
			"			 n.nota_21                      as   nota21           ,         " +
			"			 n.nota_31                      as   nota31           ,         " +
			"			 n.nota_41                      as   nota41           ,         " +
			"			 n.prom_final_1                 as   promFinal1           ,     " +
			"			 n.nota_12                      as   nota12           ,         " +
			"			 n.nota_22                      as   nota22           ,         " +
			"			 n.nota_32                      as   nota32           ,         " +
			"			 n.nota_42                      as   nota42           ,         " +
			"			 n.prom_final_2                 as   promFinal2           ,     " +
			"			 n.nota_13                      as   nota13           ,         " +
			"			 n.nota_23                      as   nota23           ,         " +
			"			 n.nota_33                      as   nota33           ,         " +
			"			 n.nota_43                      as   nota43           ,         " +
			"			 n.prom_final_3                 as   promFinal3           ,     " +
			"			 n.nota_14                      as   nota14           ,         " +
			"			 n.nota_24                      as   nota24           ,         " +
			"			 n.nota_34                      as   nota34           ,         " +
			"			 n.nota_44                      as   nota44           ,         " +
			"			 n.prom_final_4                 as   promFinal4           ,     " +
			"			 n.letra_nota_11                      as   letraNota11           ,         " +
			"			 n.letra_nota_21                      as   letraNota21           ,         " +
			"			 n.letra_nota_31                      as   letraNota31           ,         " +
			"			 n.letra_nota_41                      as   letraNota41           ,         " +
			"			 n.letra_prom_final_1                 as   letraPromFinal1           ,     " +
			"			 n.letra_nota_12                      as   letraNota12           ,         " +
			"			 n.letra_nota_22                      as   letraNota22           ,         " +
			"			 n.letra_nota_32                      as   letraNota32           ,         " +
			"			 n.letra_nota_42                      as   letraNota42           ,         " +
			"			 n.letra_prom_final_2                 as   letraPromFinal2           ,     " +
			"			 n.letra_nota_13                      as   letraNota13           ,         " +
			"			 n.letra_nota_23                      as   letraNota23           ,         " +
			"			 n.letra_nota_33                      as   letraNota33           ,         " +
			"			 n.letra_nota_43                      as   letraNota43           ,         " +
			"			 n.letra_prom_final_3                 as   letraPromFinal3           ,     " +
			"			 n.letra_nota_14                      as   letraNota14           ,         " +
			"			 n.letra_nota_24                      as   letraNota24           ,         " +
			"			 n.letra_nota_34                      as   letraNota34           ,         " +
			"			 n.letra_nota_44                      as   letraNota44           ,         " +
			"			 n.letra_prom_final_4                 as   letraPromFinal4                " +
					
					
					"			 from nota    n                                              ") ;
			sql.append(" where n.nivel = ? ");
			break;
		
		case Constantes.BUSCAR_POR_INDICADORES:
			sql.append( "select nota_id                      as   notaId           ,        " +
					"			 n.area_id                     as   areaId           ,         " +
					"			 n.capacidad_id                as   capacidadId           ,         " +
					"			 n.nivel                as   nivel           ,         " +
					"			 n.matri_id                    as   matriId           ,       " +
					"			 al.dni_alum                    as   dniAlum           ,       " +
//					"			 n.bimestre                    as   bimestre           ,       " +
					"    CONCAT(al.ape_pate, ' ', al.ape_mate, ', ', al.nombres) alumno,  "+

			"			 n.nota_11                      as   nota11           ,         " +
			"			 n.nota_21                      as   nota21           ,         " +
			"			 n.nota_31                      as   nota31           ,         " +
			"			 n.nota_41                      as   nota41           ,         " +
			"			 n.prom_final_1                 as   promFinal1           ,     " +
			"			 n.nota_12                      as   nota12           ,         " +
			"			 n.nota_22                      as   nota22           ,         " +
			"			 n.nota_32                      as   nota32           ,         " +
			"			 n.nota_42                      as   nota42           ,         " +
			"			 n.prom_final_2                 as   promFinal2           ,     " +
			"			 n.nota_13                      as   nota13           ,         " +
			"			 n.nota_23                      as   nota23           ,         " +
			"			 n.nota_33                      as   nota33           ,         " +
			"			 n.nota_43                      as   nota43           ,         " +
			"			 n.prom_final_3                 as   promFinal3           ,     " +
			"			 n.nota_14                      as   nota14           ,         " +
			"			 n.nota_24                      as   nota24           ,         " +
			"			 n.nota_34                      as   nota34           ,         " +
			"			 n.nota_44                      as   nota44           ,         " +
			"			 n.prom_final_4                 as   promFinal4           ,     " +
			"			 n.letra_nota_11                      as   letraNota11           ,         " +
			"			 n.letra_nota_21                      as   letraNota21           ,         " +
			"			 n.letra_nota_31                      as   letraNota31           ,         " +
			"			 n.letra_nota_41                      as   letraNota41           ,         " +
			"			 n.letra_prom_final_1                 as   letraPromFinal1           ,     " +
			"			 n.letra_nota_12                      as   letraNota12           ,         " +
			"			 n.letra_nota_22                      as   letraNota22           ,         " +
			"			 n.letra_nota_32                      as   letraNota32           ,         " +
			"			 n.letra_nota_42                      as   letraNota42           ,         " +
			"			 n.letra_prom_final_2                 as   letraPromFinal2           ,     " +
			"			 n.letra_nota_13                      as   letraNota13           ,         " +
			"			 n.letra_nota_23                      as   letraNota23           ,         " +
			"			 n.letra_nota_33                      as   letraNota33           ,         " +
			"			 n.letra_nota_43                      as   letraNota43           ,         " +
			"			 n.letra_prom_final_3                 as   letraPromFinal3           ,     " +
			"			 n.letra_nota_14                      as   letraNota14           ,         " +
			"			 n.letra_nota_24                      as   letraNota24           ,         " +
			"			 n.letra_nota_34                      as   letraNota34           ,         " +
			"			 n.letra_nota_44                      as   letraNota44           ,         " +
			"			 n.letra_prom_final_4                 as   letraPromFinal4                " +
					
					"			 from nota    n, matricula m, alumno al ") ;
			sql.append(" where n.matri_id = m.matri_id ");
			sql.append(" and al.alum_id = m.alum_id ");
			sql.append(" and n.area_id = ? ");
			sql.append(" and n.capacidad_id = ? ");
			sql.append(" and n.nivel = ? ");
//			sql.append(" and n.bimestre = ? ");
			sql.append(" and m.anio = ? ");
			sql.append(" order by al.ape_pate ");
			
			break;
			
		default:
			break;
		}
		
		System.out.println("sql >> " + sql);
		List<Nota> lista = buscar(sql.toString(), parametros);

		return lista;
	}
	
	public int grabar(Nota parametros) {
		int i = 0;
		StringBuilder sql = new StringBuilder();
		switch (parametros.getOpcion()) {
		case Constantes.INSERTAR:
			sql.append( " insert into nota (area_id, capacidad_id, nivel, matri_id, estado,"
					+ " nota_11, nota_21, nota_31, nota_41, prom_final_1, "
					+ " nota_12, nota_22, nota_32, nota_42, prom_final_2, "
					+ " nota_13, nota_23, nota_33, nota_43, prom_final_3, "
					+ " nota_14, nota_24, nota_34, nota_44, prom_final_4, "
					+ " letra_nota_11, letra_nota_21, letra_nota_31, letra_nota_41, letra_prom_final_1, "
					+ " letra_nota_12, letra_nota_22, letra_nota_32, letra_nota_42, letra_prom_final_2,"
					+ " letra_nota_13, letra_nota_23, letra_nota_33, letra_nota_43, letra_prom_final_3, "
					+ " letra_nota_14, letra_nota_24, letra_nota_34, letra_nota_44, letra_prom_final_4, "
					+ "usu_reg) values "+Utiles.inParametros(46));		
			break;

		case Constantes.ACTUALIZAR:
			sql.append( " update nota set fec_mod = now(), ");
			sql.append( " nota_11=?, nota_21=?, nota_31=?, nota_41=?, prom_final_1=?, ");
			sql.append( " nota_12=?, nota_22=?, nota_32=?, nota_42=?, prom_final_2=?, ");
			sql.append( " nota_13=?, nota_23=?, nota_33=?, nota_43=?, prom_final_3=?, ");
			sql.append( " nota_14=?, nota_24=?, nota_34=?, nota_44=?, prom_final_4=?, ");
			sql.append( " letra_nota_11=?, letra_nota_21=?, letra_nota_31=?, letra_nota_41=?, letra_prom_final_1=?, ");
			sql.append( " letra_nota_12=?, letra_nota_22=?, letra_nota_32=?, letra_nota_42=?, letra_prom_final_2=?, ");
			sql.append( " letra_nota_13=?, letra_nota_23=?, letra_nota_33=?, letra_nota_43=?, letra_prom_final_3=?, ");
			sql.append( " letra_nota_14=?, letra_nota_24=?, letra_nota_34=?, letra_nota_44=?, letra_prom_final_4=? ");			
			sql.append( " where nota_id =?  ");
			sql.append(" and area_id=? and capacidad_id =? and nivel =? and matri_id =? and estado = 1 ");
			break;
		default:
			break;
		}
		System.out.println("sql >>> "+sql.toString());
		i = crud(sql.toString(), parametros);

		return i;
	}

	@Override
	public void setParametros(PreparedStatement prepaStatement, Nota parametros) throws SQLException {
		int i = 1;
		switch (parametros.getOpcion()) {
		case Constantes.INSERTAR:
			prepaStatement.setInt(i++, parametros.getAreaId());
			prepaStatement.setInt(i++, parametros.getCapacidadId());
			prepaStatement.setInt(i++, parametros.getNivel());
			prepaStatement.setInt(i++, parametros.getMatriId());
//			prepaStatement.setString(i++, parametros.getDniAlum());
			prepaStatement.setInt(i++, parametros.getEstado());
			prepaStatement.setInt(i++, parametros.getNota11());
			prepaStatement.setInt(i++, parametros.getNota21());
			prepaStatement.setInt(i++, parametros.getNota31());
			prepaStatement.setInt(i++, parametros.getNota41());
			prepaStatement.setInt(i++, parametros.getPromFinal1());
			prepaStatement.setInt(i++, parametros.getNota12());
			prepaStatement.setInt(i++, parametros.getNota22());
			prepaStatement.setInt(i++, parametros.getNota32());
			prepaStatement.setInt(i++, parametros.getNota42());
			prepaStatement.setInt(i++, parametros.getPromFinal2());
			prepaStatement.setInt(i++, parametros.getNota13());
			prepaStatement.setInt(i++, parametros.getNota23());
			prepaStatement.setInt(i++, parametros.getNota33());
			prepaStatement.setInt(i++, parametros.getNota43());
			prepaStatement.setInt(i++, parametros.getPromFinal3());
			prepaStatement.setInt(i++, parametros.getNota14());
			prepaStatement.setInt(i++, parametros.getNota24());
			prepaStatement.setInt(i++, parametros.getNota34());
			prepaStatement.setInt(i++, parametros.getNota44());
			prepaStatement.setInt(i++, parametros.getPromFinal4());
			prepaStatement.setString(i++, parametros.getLetraNota11());
			prepaStatement.setString(i++, parametros.getLetraNota21());
			prepaStatement.setString(i++, parametros.getLetraNota31());
			prepaStatement.setString(i++, parametros.getLetraNota41());
			prepaStatement.setString(i++, parametros.getLetraPromFinal1());
			prepaStatement.setString(i++, parametros.getLetraNota12());
			prepaStatement.setString(i++, parametros.getLetraNota22());
			prepaStatement.setString(i++, parametros.getLetraNota32());
			prepaStatement.setString(i++, parametros.getLetraNota42());
			prepaStatement.setString(i++, parametros.getLetraPromFinal2());
			prepaStatement.setString(i++, parametros.getLetraNota13());
			prepaStatement.setString(i++, parametros.getLetraNota23());
			prepaStatement.setString(i++, parametros.getLetraNota33());
			prepaStatement.setString(i++, parametros.getLetraNota43());
			prepaStatement.setString(i++, parametros.getLetraPromFinal3());
			prepaStatement.setString(i++, parametros.getLetraNota14());
			prepaStatement.setString(i++, parametros.getLetraNota24());
			prepaStatement.setString(i++, parametros.getLetraNota34());
			prepaStatement.setString(i++, parametros.getLetraNota44());
			prepaStatement.setString(i++, parametros.getLetraPromFinal4());
			prepaStatement.setString(i++, parametros.getUsuReg());
			
			
			
			break;
		case Constantes.ACTUALIZAR:
			prepaStatement.setInt(i++, parametros.getNota11());
			prepaStatement.setInt(i++, parametros.getNota21());
			prepaStatement.setInt(i++, parametros.getNota31());
			prepaStatement.setInt(i++, parametros.getNota41());
			prepaStatement.setInt(i++, parametros.getPromFinal1());
			prepaStatement.setInt(i++, parametros.getNota12());
			prepaStatement.setInt(i++, parametros.getNota22());
			prepaStatement.setInt(i++, parametros.getNota32());
			prepaStatement.setInt(i++, parametros.getNota42());
			prepaStatement.setInt(i++, parametros.getPromFinal2());
			prepaStatement.setInt(i++, parametros.getNota13());
			prepaStatement.setInt(i++, parametros.getNota23());
			prepaStatement.setInt(i++, parametros.getNota33());
			prepaStatement.setInt(i++, parametros.getNota43());
			prepaStatement.setInt(i++, parametros.getPromFinal3());
			prepaStatement.setInt(i++, parametros.getNota14());
			prepaStatement.setInt(i++, parametros.getNota24());
			prepaStatement.setInt(i++, parametros.getNota34());
			prepaStatement.setInt(i++, parametros.getNota44());
			prepaStatement.setInt(i++, parametros.getPromFinal4());
			prepaStatement.setString(i++, parametros.getLetraNota11());
			prepaStatement.setString(i++, parametros.getLetraNota21());
			prepaStatement.setString(i++, parametros.getLetraNota31());
			prepaStatement.setString(i++, parametros.getLetraNota41());
			prepaStatement.setString(i++, parametros.getLetraPromFinal1());
			prepaStatement.setString(i++, parametros.getLetraNota12());
			prepaStatement.setString(i++, parametros.getLetraNota22());
			prepaStatement.setString(i++, parametros.getLetraNota32());
			prepaStatement.setString(i++, parametros.getLetraNota42());
			prepaStatement.setString(i++, parametros.getLetraPromFinal2());
			prepaStatement.setString(i++, parametros.getLetraNota13());
			prepaStatement.setString(i++, parametros.getLetraNota23());
			prepaStatement.setString(i++, parametros.getLetraNota33());
			prepaStatement.setString(i++, parametros.getLetraNota43());
			prepaStatement.setString(i++, parametros.getLetraPromFinal3());
			prepaStatement.setString(i++, parametros.getLetraNota14());
			prepaStatement.setString(i++, parametros.getLetraNota24());
			prepaStatement.setString(i++, parametros.getLetraNota34());
			prepaStatement.setString(i++, parametros.getLetraNota44());
			prepaStatement.setString(i++, parametros.getLetraPromFinal4());
			prepaStatement.setInt(i++, parametros.getNotaId());
			prepaStatement.setInt(i++, parametros.getAreaId());
			prepaStatement.setInt(i++, parametros.getCapacidadId());
			prepaStatement.setInt(i++, parametros.getNivel());
			prepaStatement.setInt(i++, parametros.getMatriId());
//			prepaStatement.setString(i++, parametros.getDniAlum());
//			prepaStatement.setInt(i++, parametros.getBimestre());
			break;
			
		case 4: //parametros de busqueda
			prepaStatement.setInt(i++, parametros.getNotaId());
			
			break;	
		case Constantes.BUSCAR_POR_NIVEL:
			prepaStatement.setInt(i++, parametros.getNotaId());
			break;
		case Constantes.BUSCAR_POR_INDICADORES:
			prepaStatement.setInt(i++, parametros.getAreaId());
			prepaStatement.setInt(i++, parametros.getCapacidadId());
			prepaStatement.setInt(i++, parametros.getNivel());
//			prepaStatement.setInt(i++, parametros.getBimestre());
			prepaStatement.setString(i++, parametros.getAnio());
			break;
		case Constantes.ELIMINAR:
			prepaStatement.setInt(i++, parametros.getMatriId());
			break;
		default:
			break;
		}
		
	}

	@Override
	public Nota getFactory() {
		// TODO Auto-generated method stub
		return new Nota();
	}

	@Override
	public void eliminar(Nota nota) {
		StringBuilder sql = new StringBuilder();
		
			sql.append( " delete from nota where matri_id= ?");		
			 crud(sql.toString(), nota);
		
	}
	
	
}
