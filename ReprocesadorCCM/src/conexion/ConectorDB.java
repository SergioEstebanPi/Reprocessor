package conexion;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConectorDB {

	private DataSource dataSource;
	
	public ConectorDB() {
	}

	public ConectorDB(String basededatos) {
        try {
            InitialContext context = new InitialContext();
            dataSource = (DataSource) context.lookup("jdbc/pooled/DBPORVE");
        } catch (NamingException ex) {
        	System.out.println("No se ha podido crear la conexion");
        }
	}

	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
		} catch (SQLException ex) {
			System.out.println("No se puede obtener la conexion");
		}
		return conn;
	}
}
