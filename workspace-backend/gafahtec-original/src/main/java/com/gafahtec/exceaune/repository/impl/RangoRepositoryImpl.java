package com.gafahtec.exceaune.repository.impl;

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

import com.gafahtec.exceaune.model.Rango;
import com.gafahtec.exceaune.repository.RangoRepositoryDao;

@Repository
@Transactional
public class RangoRepositoryImpl implements RangoRepositoryDao{


		@Autowired
		private JdbcTemplate jdbcTemplate;

		private SimpleJdbcCall simpleJdbcCallRefCursor;
		SqlParameterSource paramaters;
		SqlParameter[] sqlParameters;
		
		@Override
		public List<Rango> getRangos() {
			paramaters = new MapSqlParameterSource()
//					s.addValue("pid", id)
					;
			
//			 sqlParameters = new SqlParameter[] {
//						new SqlParameter("pid", Types.INTEGER) };
//			System.out.println(">>>> aqui ");
		return	getGeneralList("sf_rangos", paramaters, sqlParameters);
		}
		
		private List<Rango> getGeneralList(String function,SqlParameterSource paramaters,SqlParameter[] sqlParameters ) {
			Map out = null;
			try {
//			System.out.println(">>>> entrando ");
			jdbcTemplate.setResultsMapCaseInsensitive(true);

			simpleJdbcCallRefCursor = new SimpleJdbcCall(jdbcTemplate)
//					.withSchemaName("exceaune")
					.withFunctionName(function)
					.withoutProcedureColumnMetaDataAccess()
//					.declareParameters(sqlParameters)
					.returningResultSet("c1", BeanPropertyRowMapper.newInstance(Rango.class));

			
//			System.out.println("antes >>>> ");
			
			out = simpleJdbcCallRefCursor.execute(paramaters);
//			System.out.println("resultado >>>> "+out);
		
			
			}
			catch(Exception e) {
				e.printStackTrace();
				out = null;	
			}
			
			if (out == null) {
				
				return Collections.emptyList();
			} else {
				
				return (List) out.get("c1");
			}
		}

}
