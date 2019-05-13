package testesJunit;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import org.junit.jupiter.api.Test;

import config.User;
import db_config.MySqlConnection;
import gui.admin.AdminFrame;

class AdminFrameTest {

	private MySqlConnection msqlc = new MySqlConnection(); 

	User user = new User("sebas", "12345");
	private AdminFrame adminFrame = new AdminFrame(user, null);
	
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
	
	@Test
	void addLabels() {
		Font font = new Font("Yu Gothic Light", Font.BOLD, 18);
		adminFrame.addLabels();
		assertEquals(font, adminFrame.lblHello.getFont());
	}
	
	@Test
	void addButtons() {
		Font font = new Font("Yu Gothic Light", Font.BOLD, 17);
		adminFrame.addButtons();
		assertEquals(font, adminFrame.btnCriarAuditor.getFont());
	}	

}
