package testesJunit;

import static org.junit.Assert.assertNotEquals;

import org.junit.jupiter.api.Test;

import db_config.MySqlConnection;
import gui.admin.MudarInvestigadorFrame;

public class MudarInvestigadorFrameTest {

	
	private MySqlConnection msqlc = new MySqlConnection(); 
	private MudarInvestigadorFrame frame = new MudarInvestigadorFrame(msqlc);
	
	@Test
	public void testForNotNull() {
		assertNotEquals(null, frame);
	}
}
