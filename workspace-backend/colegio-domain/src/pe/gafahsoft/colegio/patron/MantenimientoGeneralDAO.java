package pe.gafahsoft.colegio.patron;

import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import pe.gafahsoft.colegio.util.PConexion;

public abstract class MantenimientoGeneralDAO<T> extends PConexion {
	

	public abstract List<T> listar(T parametros);

	public abstract int grabar(T parametros);

	public List<T> buscar(String sql, T parametros) {
		List<T> lista = new ArrayList<>();
		
		T objBean = null;
//		System.out.println("sql >>> " + sql);
		try {
			connection = dataSource.getConnection();
			prepaStatement = connection.prepareStatement(sql);

			if (parametros != null) {
				setParametros(prepaStatement, parametros);
			}
			resultSet = prepaStatement.executeQuery();
			
	        ResultSetMetaData meta = resultSet.getMetaData();
	        while (resultSet.next()) {
	            Map<String, Object> map = new HashMap<String, Object>();
	            for (int i = 1; i <= meta.getColumnCount(); i++) {
//	                String key = meta.getColumnName(i);
	                String alias = meta.getColumnLabel(i);
//	                System.out.println("key "+key);
//	                System.out.println("key "+alias);
	                Object value = resultSet.getObject(alias);
	                	map.put(alias, value);
	            }
	            objBean = getFactory();
//	            System.out.println("map "+map);
	            BeanUtils.populate(objBean, map);
	            
	            lista.add(objBean);
	        }

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResultSet(resultSet);
			closePreparedStatement(prepaStatement);
			closeConnection(connection);
		}

		return lista;
	}

	
	public int crud(String sql, T parametros) {
		int resultado = 0;
		System.out.println("sql >>> " + sql);
		try {
			connection = dataSource.getConnection();
			prepaStatement = connection.prepareStatement(sql);
			if (parametros != null) {
				setParametros(prepaStatement, parametros);
			}
			resultado = prepaStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResultSet(resultSet);
			closePreparedStatement(prepaStatement);
			closeConnection(connection);
		}
		return resultado;

	}

	public abstract void setParametros(PreparedStatement prepaStatement, T parametros) throws SQLException;

	public abstract T getFactory();

}
