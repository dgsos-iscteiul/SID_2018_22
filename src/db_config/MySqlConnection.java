package db_config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Date: March 26-2019
 * This is a class that makes the connection to the mysql database possible.
 * @author ajcvo-iscteiul
 * @version 1.0
 *
 */

public class MySqlConnection {

	
	
	/**
	 * This is the connection element from jdbc.
	 */
	private Connection connection;
	
	/**
	 * This constructor initiates the connection value as null.
	 */
	public MySqlConnection() {
		connection = null;	//init de Connection variable
	}

	/**
	 * This method connects to the database that we specify
	 * @param database_location location of the database
	 */
	public void init(String database_location) {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://"+database_location+""
					+ "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode"
					+ "=false&serverTimezone=UTC", "root", "");
			//getConnection uses de (databaselocation, user, password)
			//its also required to setup de serverTimeZone to work with our timezone
			System.out.println("Connection to " + database_location + " established!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @return returns the connection
	 */
	public Connection getConnection() {
		return connection;
	}
	
	public static void main(String[] args) {
		MySqlConnection msqlc = new MySqlConnection();
		msqlc.init("localhost/sid");
	}
	
}
