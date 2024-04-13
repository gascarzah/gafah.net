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

import com.gafahtec.exceaune.model.Persona;
import com.gafahtec.exceaune.repository.PersonaRepositoryDao;

@Repository
@Transactional
public class PersonaRepositoryImpl implements PersonaRepositoryDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	SqlParameterSource paramaters;
	SqlParameter[] sqlParameters;
	private SimpleJdbcCall simpleJdbcCallRefCursor;


	
	public List<Persona> getAlumnos(Integer anio, String seccion)  {
		paramaters = new MapSqlParameterSource()
				.addValue("anio", anio)
				.addValue("seccion", seccion);
		sqlParameters = new SqlParameter[] 
				{
					new SqlParameter("anio", Types.INTEGER),
					new SqlParameter("seccion", Types.VARCHAR)};
		Map out = null;
		try {
		jdbcTemplate.setResultsMapCaseInsensitive(true);

		simpleJdbcCallRefCursor = new SimpleJdbcCall(jdbcTemplate)
//				.withSchemaName("exceaune")
				.withFunctionName("sf_alumnos")
				.withoutProcedureColumnMetaDataAccess()
				.declareParameters(sqlParameters)
				.returningResultSet("c1", BeanPropertyRowMapper.newInstance(Persona.class));

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

}
