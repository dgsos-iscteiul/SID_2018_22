package testesJunit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runners.JUnit4;

import db_config.MySqlConnection;

class MySqlConnectionTest {

	private MySqlConnection msqlc = new MySqlConnection(); 
	
	@Test
	void testInit() {	
		msqlc.init("localhost/sid22", "root", "");
		assertEquals(msqlc.isLoggedIn(), true);
	}
	
	

}
