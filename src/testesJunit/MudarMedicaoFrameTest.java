package testesJunit;

import static org.junit.Assert.assertNotEquals;

import org.junit.jupiter.api.Test;

import db_config.MySqlConnection;
import gui.investigador.MudarMedicaoFrame;

public class MudarMedicaoFrameTest {
	private MySqlConnection msqlc = new MySqlConnection(); 
	private MudarMedicaoFrame frame = new MudarMedicaoFrame(msqlc);
	
	@Test
	public void testForNotNull() {
		assertNotEquals(null, frame);
	}
}
