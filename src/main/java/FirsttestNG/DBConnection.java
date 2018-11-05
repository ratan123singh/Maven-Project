package FirsttestNG;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		System.out.println("-------- PostgreSQL " + "JDBC Connection Testing ------------");

		try {

			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your PostgreSQL JDBC Driver? " + "Include in your library path!");
			e.printStackTrace();
			return;

		}

		System.out.println("PostgreSQL JDBC Driver Registered!");

		Connection connection1 = null;

		try {

			connection1 = DriverManager.getConnection("DB URL");

		} catch (SQLException e1) {

			System.out.println("Connection Failed! Check output console");
			e1.printStackTrace();
			return;

		}

		if (connection1 != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
		
//		Statement stmt = connection1.createStatement();
//		
//		stmt.executeQuery("select * from businesses");
	}
}