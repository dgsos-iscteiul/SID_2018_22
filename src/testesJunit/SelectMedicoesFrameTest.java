package testesJunit;

import static org.junit.Assert.assertNotEquals;
import org.junit.jupiter.api.Test;

import gui.investigador.SelectMedicoesFrame;

public class SelectMedicoesFrameTest {
	SelectMedicoesFrame frame = new SelectMedicoesFrame("root", "");
	
	@Test
	public void testForNotNull() {
		assertNotEquals(null, frame);
	}
}
