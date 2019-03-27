package db_config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Date: March 26-2019
 * This is a class that makes the connection to the mysql database possible.
 * @author ajcvo-iscteiul
 * @version 1.0
 * asdasd
 */

public class MySqlConnection {

	
	
	/**
	 * This is the connection element from jdbc.
	 */
	private Connection connection;
	private boolean login_status = false;
	
	/**
	 * This constructor initiates the connection value as null.
	 */
	public MySqlConnection() {
		connection = null;	//init de Connection variable
	}

	/**
	 * This method connects to the database that we specify
	 * @param database_location location of the database
	 * @param user user that is logging in
	 * @param password password of the user
	 */
	public void init(String database_location, String user, String password) {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://"+database_location+""
					+ "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode"
					+ "=false&serverTimezone=UTC", user, password);
			//getConnection uses de (databaselocation, user, password)
			//its also required to setup de serverTimeZone to work with our timezone
			System.out.println("Connection to " + database_location + " established!");
			setLogin_status(true);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Login error!");
			setLogin_status(false);
		}
	}
	
	/**
	 * @return returns the connection
	 */
	public Connection getConnection() {
		return connection;
	}
	
	public boolean isLoggedIn() {
		return login_status;
	}
	
	public void setLogin_status(boolean login_status) {
		this.login_status = login_status;
	}
	
	public static void main(String[] args) {
		MySqlConnection msqlc = new MySqlConnection();
		msqlc.init("localhost/sid", "root", "");
	}
	
}
