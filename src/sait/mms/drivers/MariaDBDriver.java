package sait.mms.drivers;

import java.sql.*;

import sait.mms.contracts.DatabaseDriver;

public class MariaDBDriver implements DatabaseDriver {
	private static final String SERVER = "localhost";
	private static final int PORT = 3306;
	private static final String DATABASE = "cprg251";
	private static final String	USERNAME = "Hoang";
	private static final String PASSWORD = "password";
	
	Connection conn = null;
	
	@Override
	public void connect() throws SQLException {
		String DB_URL = this.getDSN();
		conn = DriverManager.getConnection(DB_URL);
	}

	public String getDSN() {
		return String.format("jdbc:mariadb://%s:%d/%s?user=%s&password=%s", SERVER, PORT,DATABASE,USERNAME,PASSWORD);
	}
	@Override
	public ResultSet get(String query) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet results = stmt.executeQuery(query);
		return results;
	}

	@Override
	public void update(String query) throws SQLException {
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(query);
	}

	@Override
	public void disconnect() throws SQLException {
		if (conn != null && !conn.isClosed()) {
			conn.close();
		}
		
	}

}
