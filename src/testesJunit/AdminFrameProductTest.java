package testesJunit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import config.User;
import db_config.MySqlConnection;
import gui.admin.AdminFrame;
import gui.admin.AdminFrameProduct;

public class AdminFrameProductTest {

	private MySqlConnection msqlc = new MySqlConnection(); 
	User user = new User("root", "");
	private AdminFrame adminFrame = new AdminFrame(user, null);
	private AdminFrameProduct adminFrameProduct = new AdminFrameProduct();
	
	@Test
	void addDefaultSettings() {
		Dimension size = new Dimension(800, 500);
		adminFrame.addDefaultSettings();
		assertEquals(size, adminFrame.getSize());
	}
	
	@Test
	void addOperationsPanels() {
		Color cor = new Color(240, 248, 255);
		adminFrame.addOperationsPanels();
		assertEquals(cor, adminFrame.panelOperations0.getBackground());
	}
	
	@Before 
	void addPanels() {
		adminFrameProduct.addPanels(adminFrame);
	}
	
	@Test
	void addLabels() {
		Color cor = new Color(240, 248, 255);
		assertEquals(cor, adminFrameProduct.getPanelCenter().getBackground());
	}
	
	
}
