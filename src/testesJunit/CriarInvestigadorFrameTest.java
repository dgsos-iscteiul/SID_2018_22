package testesJunit;

import static org.junit.Assert.assertNotEquals;

import org.junit.jupiter.api.Test;

import db_config.MySqlConnection;
import gui.admin.CriarInvestigadorFrame;

public class CriarInvestigadorFrameTest {

	private MySqlConnection msqlc = new MySqlConnection(); 
	private CriarInvestigadorFrame frame = new CriarInvestigadorFrame(msqlc);
	
	@Test
	public void testForNotNull() {
		assertNotEquals(null, frame);
	}
}
