package testesJunit;

import static org.junit.Assert.assertNotEquals;

import org.junit.jupiter.api.Test;

import db_config.MySqlConnection;
import gui.investigador.InserirMedicoesFrame;

public class InserirMedicoesFrameTest {
	private MySqlConnection msqlc = new MySqlConnection(); 
	private InserirMedicoesFrame frame = new InserirMedicoesFrame(msqlc);
	
	@Test
	public void testForNotNull() {
		assertNotEquals(null, frame);
	}
}
