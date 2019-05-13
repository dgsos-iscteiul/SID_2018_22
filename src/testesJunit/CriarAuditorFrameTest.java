package testesJunit;

import static org.junit.Assert.assertNotEquals;

import org.junit.jupiter.api.Test;

import db_config.MySqlConnection;
import gui.admin.CriarAdminFrame;

public class CriarAuditorFrameTest {

	private MySqlConnection msqlc = new MySqlConnection(); 
	private CriarAdminFrame frame = new CriarAdminFrame(msqlc);
	
	@Test
	public void testForNotNull() {
		assertNotEquals(null, frame);
	}
}
