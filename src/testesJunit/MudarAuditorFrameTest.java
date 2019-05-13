package testesJunit;

import static org.junit.Assert.assertNotEquals;

import org.junit.jupiter.api.Test;

import db_config.MySqlConnection;
import gui.admin.MudarAuditorFrame;

public class MudarAuditorFrameTest {

	private MySqlConnection msqlc = new MySqlConnection(); 
	private MudarAuditorFrame frame = new MudarAuditorFrame(msqlc);
	
	@Test
	public void testForNotNull() {
		assertNotEquals(null, frame);
	}
	
}
