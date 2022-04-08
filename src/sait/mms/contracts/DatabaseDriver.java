package sait.mms.contracts;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface DatabaseDriver {
	void connect() throws SQLException;
	
	ResultSet get(String query) throws SQLException;
	
	void update(String query) throws SQLException;
	
	void disconnect() throws SQLException;
	
}
