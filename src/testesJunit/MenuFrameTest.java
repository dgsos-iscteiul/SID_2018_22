package testesJunit;

import static org.junit.Assert.assertNotEquals;

import org.junit.jupiter.api.Test;

import config.User;
import gui.investigador.MenuFrame;

public class MenuFrameTest {

	User user = new User("root", "");
	private MenuFrame frame = new MenuFrame(user, null);
	
	
	@Test
	public void testForNotNull() {
		assertNotEquals(null, frame);
	}
}
