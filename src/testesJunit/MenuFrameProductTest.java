package testesJunit;

import static org.junit.Assert.assertNotEquals;

import org.junit.jupiter.api.Test;

import config.User;
import db_config.MySqlConnection;
import gui.investigador.MenuFrame;
import gui.investigador.MenuFrameProduct;

public class MenuFrameProductTest {

	private MySqlConnection msqlc = new MySqlConnection(); 

	User user = new User("root", "");
	private MenuFrame menuFrame = new MenuFrame(user, null);
	private MenuFrameProduct frame = new MenuFrameProduct();
	
	@Test
	public void testForNotNull() {
		assertNotEquals(null, frame);
	}
}
