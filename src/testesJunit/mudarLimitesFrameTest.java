package testesJunit;

import static org.junit.Assert.assertNotEquals;

import org.junit.jupiter.api.Test;

import db_config.MySqlConnection;
import gui.investigador.mudarLimitesFrame;

public class mudarLimitesFrameTest {
	private MySqlConnection msqlc = new MySqlConnection(); 
	private mudarLimitesFrame frame = new mudarLimitesFrame(msqlc);
	
	@Test
	public void testForNotNull() {
		assertNotEquals(null, frame);
	}
}
