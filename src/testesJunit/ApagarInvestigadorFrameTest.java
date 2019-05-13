package testesJunit;

import static org.junit.Assert.assertNotEquals;

import org.junit.jupiter.api.Test;

import db_config.MySqlConnection;
import gui.admin.ApagarInvestigadorFrame;

public class ApagarInvestigadorFrameTest {


		private MySqlConnection msqlc = new MySqlConnection(); 
		private ApagarInvestigadorFrame frame = new ApagarInvestigadorFrame(msqlc);
		
		@Test
		public void testForNotNull() {
			assertNotEquals(null, frame);
		}
}
