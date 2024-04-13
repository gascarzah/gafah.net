package com.gafahtec.exceaune.repository.impl;

import java.sql.Types;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gafahtec.exceaune.model.Decada;
import com.gafahtec.exceaune.repository.PromocionRepositoryDao;

@Repository
@Transactional
public class PromocionRepositoryImpl implements PromocionRepositoryDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	SqlParameterSource paramaters;
	SqlParameter[] sqlParameters;
	private SimpleJdbcCall simpleJdbcCallRefCursor;


	public List<Decada> getSecciones(Integer anio)  {
		paramaters = new MapSqlParameterSource().addValue("panio", anio);
		sqlParameters = new SqlParameter[] { new SqlParameter("panio", Types.INTEGER) };
		Map out = null;
		try {
		jdbcTemplate.setResultsMapCaseInsensitive(true);

		simpleJdbcCallRefCursor = new SimpleJdbcCall(jdbcTemplate)
//				.withSchemaName("exceaune")
				.withFunctionName("sf_secciones")
				.withoutProcedureColumnMetaDataAccess()
				.declareParameters(sqlParameters)
				.returningResultSet("c1", BeanPropertyRowMapper.newInstance(Decada.class));

		out = simpleJdbcCallRefCursor.execute(paramaters);

		}catch(Exception e) {
			e.printStackTrace();
			out = null;
		}
		
		return evaluar(out);
	}
	
	public List<Decada> getAnios(Integer pdecada)  {
		paramaters = new MapSqlParameterSource().addValue("pdecada", pdecada);
		sqlParameters = new SqlParameter[] { new SqlParameter("pdecada", Types.INTEGER) };
		Map out = null;
		try {
		jdbcTemplate.setResultsMapCaseInsensitive(true);

		simpleJdbcCallRefCursor = new SimpleJdbcCall(jdbcTemplate)
//				.withSchemaName("exceaune")
				.withFunctionName("sf_anios")
				.withoutProcedureColumnMetaDataAccess()
				.declareParameters(sqlParameters)
				.returningResultSet("c1", BeanPropertyRowMapper.newInstance(Decada.class));

		out = simpleJdbcCallRefCursor.execute(paramaters);

		}catch(Exception e) {
			e.printStackTrace();
			out = null;
		}
		
		return evaluar(out);
	}
	
	public List<Decada> getDecadas(Integer id)  {
		paramaters = new MapSqlParameterSource().addValue("idrango", id);
		sqlParameters = new SqlParameter[] { new SqlParameter("idrango", Types.INTEGER) };
		Map out = null;
		try {
		jdbcTemplate.setResultsMapCaseInsensitive(true);

		simpleJdbcCallRefCursor = new SimpleJdbcCall(jdbcTemplate)
//				.withSchemaName("exceaune")
				.withFunctionName("sf_decadas")
				.withoutProcedureColumnMetaDataAccess()
				.declareParameters(sqlParameters)
				.returningResultSet("c1", BeanPropertyRowMapper.newInstance(Decada.class));

		out = simpleJdbcCallRefCursor.execute(paramaters);

		}catch(Exception e) {
			e.printStackTrace();
			out = null;
		}
		
		return evaluar(out);
	}
	
	private List evaluar(Map out) {
		if (out == null) {

			return Collections.emptyList();
		} else {

			return (List) out.get("c1");
		}		
	}
	
//	public List<Promocion> getList(Integer id)  {
//		paramaters = new MapSqlParameterSource().addValue("anio", id);
//		sqlParameters = new SqlParameter[] { new SqlParameter("anio", Types.INTEGER) };
//		return getGeneralList("sf_promo_list", paramaters, sqlParameters);
//
//	}

//	private List<Promocion> getGeneralList(String function, SqlParameterSource paramaters,
//			SqlParameter[] sqlParameters) {
//		Map out = null;
//		try {
//		jdbcTemplate.setResultsMapCaseInsensitive(true);
//
//		simpleJdbcCallRefCursor = new SimpleJdbcCall(jdbcTemplate)
//				.withSchemaName("exceaune")
//				.withFunctionName(function)
//				.withoutProcedureColumnMetaDataAccess()
//				.declareParameters(sqlParameters)
//				.returningResultSet("c1", BeanPropertyRowMapper.newInstance(Promocion.class));
//
//		out = simpleJdbcCallRefCursor.execute(paramaters);
//
//		}catch(Exception e) {
//			e.printStackTrace();
//			out = null;
//		}
//		
//		return evaluar(out);
//
//	}
}
