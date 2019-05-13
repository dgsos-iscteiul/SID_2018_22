package testesJunit;

import static org.junit.Assert.assertNotEquals;

import org.junit.jupiter.api.Test;

import db_config.MySqlConnection;
import gui.investigador.ApagarVariavelMedidaFrame;

public class ApagarVariavelMedidaFrameTest {
	private MySqlConnection msqlc = new MySqlConnection(); 
	private ApagarVariavelMedidaFrame frame = new ApagarVariavelMedidaFrame(msqlc);
	
	@Test
	public void testForNotNull() {
		assertNotEquals(null, frame);
	}
}
