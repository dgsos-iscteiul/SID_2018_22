package testesJunit;

import static org.junit.Assert.assertNotEquals;

import org.junit.jupiter.api.Test;

import db_config.MySqlConnection;
import gui.investigador.CriarVariavelMedidaFrame;

public class CriarVariavelMedidaFrameTest {
	private MySqlConnection msqlc = new MySqlConnection(); 
	private CriarVariavelMedidaFrame frame = new CriarVariavelMedidaFrame(msqlc);
	
	@Test
	public void testForNotNull() {
		assertNotEquals(null, frame);
	}
}
