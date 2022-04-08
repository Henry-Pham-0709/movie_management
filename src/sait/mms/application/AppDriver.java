package sait.mms.application;

import java.sql.SQLException;

import sait.mms.managers.MovieManagementSystem;

public class AppDriver {

	public static void main(String[] args) throws SQLException {
		MovieManagementSystem driver = new MovieManagementSystem();
		driver.displayMenu();
		driver.disconnect();
	}

}
