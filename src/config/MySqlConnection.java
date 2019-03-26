package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {

	private void init(String database_location) {
		Connection connection = null;	//init de Connection variable
		try {
			connection = DriverManager.getConnection("jdbc:mysql://"+database_location+""
					+ "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode"
					+ "=false&serverTimezone=UTC", "root", "");
			//getConection uses de (databaselocation, user, password)
			//its also required to setup de serverTimeZone to work with our timezone
			System.out.println("Connection to " + database_location + " established!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		MySqlConnection msqlc = new MySqlConnection();
		msqlc.init("localhost/sid");
	}
	
}
