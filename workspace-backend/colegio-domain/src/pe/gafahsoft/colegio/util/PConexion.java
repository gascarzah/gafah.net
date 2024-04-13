package pe.gafahsoft.colegio.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public abstract class PConexion {
protected static Logger log = Logger.getLogger(PConexion.class.getName());
	
//	@Resource(mappedName="java:jboss/datasources/colegio") 
	protected DataSource  dataSource = null;

	protected Connection connection= null;
	protected ResultSet  resultSet = null;
	protected Statement  statement = null;
	protected PreparedStatement prepaStatement = null;
	protected CallableStatement callStatement  = null;

//	String usuario = "root";
//    String password = "";
//
//    String host = "localhost"; // tambien puede ser una ip como "192.168.1.14"
//    String puerto = "3306";
//    String database = "colegio";
//	
//    String driver = "com.mysql.jdbc.Driver";
//
//    String ulrjdbc = "jdbc:mysql://" + host + ":" + puerto + "/" + database;

    
	public PConexion() {
		try {			
			Context context = new InitialContext();		
//			dataSource = (DataSource)context.lookup("java:jboss/datasources/colegio");
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/colegio");
//			 System.out.println("Connected to the database");
           
            
		} catch(Exception e) {
			e.printStackTrace();
//			log.error("Error en PConexion(): "+e);
		}
	}

	public PConexion(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void closeCallableStatement(CallableStatement cstm)	{
		if (cstm!=null) {
			try {
				cstm.close();
			} catch (SQLException e) {
//				log.error("Error en closeCallableStatement(): "+e);
				e.printStackTrace();
			}
		}
	}
	
	public void closeConnection(Connection conn) {
		if (conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
//				log.error("Error en closeConnection(): "+e);
				e.printStackTrace();
			}finally {
				conn=null;
			}
		}
	}

	public void closePreparedStatement(PreparedStatement pstm) {
		if (pstm!=null) {
			try {
				pstm.close();
			} catch (SQLException e) {
//				log.error("Error en closePreparedStatement(): "+e);
				e.printStackTrace();
			}finally {
				pstm=null;
			}
		}
	}

	public void closeResultSet(ResultSet rs) {
		
		if (rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
//				log.error("Error en closeResultSet(): "+e);
				e.printStackTrace();
			}finally {
				rs=null;
			}
		}
	}

	public void closeStatement(Statement stm)	{
		if (stm!=null) {
			try {
				stm.close();
			} catch (SQLException e) {
				e.printStackTrace();
//				log.error("Error en closeStatement(): "+e);
				
			}finally {
				stm=null;
			}
		}
	}

	public PreparedStatement getPrepaStatement() {
		return prepaStatement;
	}

	
	
}
