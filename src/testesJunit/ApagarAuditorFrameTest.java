package testesJunit;

import static org.junit.Assert.assertNotEquals;


import org.junit.jupiter.api.Test;

import db_config.MySqlConnection;
import gui.admin.ApagarAuditorFrame;

public class ApagarAuditorFrameTest {

	private MySqlConnection msqlc = new MySqlConnection(); 
	private ApagarAuditorFrame frame = new ApagarAuditorFrame(msqlc);
	
	@Test
	public void testForNotNull() {
		assertNotEquals(null, frame);
	}
}
