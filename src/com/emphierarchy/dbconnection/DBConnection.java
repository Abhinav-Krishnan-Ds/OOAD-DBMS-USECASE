package com.emphierarchy.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


// Establishes connection with the database
public class DBConnection {

	// get the connection

	public static Connection getConnection() {

		String connectionURL = "jdbc:mysql://localhost:3306/employee_hierarchy?useSSL=false";

		String userName = "root";

		String password = "experion@123";

		Connection connection = null;

		try {
			connection = DriverManager.getConnection(connectionURL, userName, password);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}

		return connection;

	}

	// close the connection

	public static void closeConnection(Connection connection){
		
		try {
			connection.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
