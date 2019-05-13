package testesJunit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import config.User;
import db_config.MySqlConnection;
import db_interaction.Interaction;

public class InteractionTest {

		private Interaction interaction;
		private MySqlConnection mysql;

		@Before
		public void executedBeforeEach() {
			mysql = new MySqlConnection(); 
			interaction = new Interaction(mysql);
		}

		@Test
		public void testNotNullInteraction() {
			assertNotEquals(null, interaction);
		}
		
		@Test(expected=NullPointerException.class)
		public void testIsAdminOrInvestigador() throws SQLException {
			assertEquals(false, interaction.isAdminOrInvestigador(""));
		}		
}
