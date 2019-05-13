package testesJunit;

import static org.junit.Assert.assertNotEquals;

import org.junit.jupiter.api.Test;

import db_config.MySqlConnection;
import gui.investigador.ApagarMedicaoFrame;

public class ApagarMedicaoFrameTest {
	
	private MySqlConnection msqlc = new MySqlConnection(); 
	private ApagarMedicaoFrame frame = new ApagarMedicaoFrame(msqlc);
	
	@Test
	public void testForNotNull() {
		assertNotEquals(null, frame);
	}
}
