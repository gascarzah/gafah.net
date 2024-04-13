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

import com.gafahtec.exceaune.model.Foto;
import com.gafahtec.exceaune.repository.FotoRepositoryDao;

@Repository
@Transactional
public class FotoRepositoryImpl implements FotoRepositoryDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private SimpleJdbcCall simpleJdbcCallRefCursor;
	SqlParameterSource paramaters;
	SqlParameter[] sqlParameters;
	
	@Override
	public List<Foto> getFotosArticulo(Integer id) {
		paramaters = new MapSqlParameterSource()
				.addValue("pid", id);
		
		 sqlParameters = new SqlParameter[] {
					new SqlParameter("pid", Types.INTEGER) };

	return	getGeneralList("sf_articulo_fotos", paramaters, sqlParameters);
	}
	
	private List<Foto> getGeneralList(String function,SqlParameterSource paramaters,SqlParameter[] sqlParameters ) {

		jdbcTemplate.setResultsMapCaseInsensitive(true);

		simpleJdbcCallRefCursor = new SimpleJdbcCall(jdbcTemplate)
//				.withSchemaName("exceaune")
				.withFunctionName(function)
				.withoutProcedureColumnMetaDataAccess()
				.declareParameters(sqlParameters)
				.returningResultSet("c1", BeanPropertyRowMapper.newInstance(Foto.class));

		
		
		Map out = simpleJdbcCallRefCursor.execute(paramaters);
		
		if (out == null) {
			
			return Collections.emptyList();
		} else {
			
			return (List) out.get("c1");
		}
	}
}
