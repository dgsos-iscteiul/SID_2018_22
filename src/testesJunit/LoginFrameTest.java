package testesJunit;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;

import org.junit.jupiter.api.Test;

import gui.geral.LoginFrame;
@SuppressWarnings("unused")

class LoginFrameTest {

	LoginFrame logFrame = new LoginFrame();
	
	@Test
	void addDefaultSettings() {
		logFrame.addDefaultSettings();
		Dimension size = new Dimension(670, 513);
		assertEquals(size, logFrame.getSize());
	}

	@Test
	void addPanels() {
		logFrame.addPanels();
		Color cor = Color.WHITE;
		assertEquals(cor, logFrame.panel.getBackground());
	}
	
	@Test
	void addTextfields() {
		logFrame.addTextfields();
		Font fonte = new Font("Segoe UI", Font.PLAIN, 23);
		assertEquals(fonte, logFrame.password.getFont());
	}
	
	@Test
	void addButtons() {
		logFrame.addButtons();
		Font fonte = new Font("Yu Gothic Light", Font.BOLD, 16);
		assertEquals(fonte, logFrame.rdbtnAdminMode.getFont());
	}
	
	@Test
	void createImageIconNull() {
		ImageIcon imgicon = logFrame.createImageIcon("wrongpath", "test");
		assertNull(imgicon);
	}
	
	@Test
	void createImageIcon() {
		
		String path = "/images/lab_intro.jpg";
		String description = "LabManagement";
		ImageIcon imgicon = logFrame.createImageIcon(path, description);
		
		ImageIcon imgiconteste = null;
		
		java.net.URL imgURL = logFrame.getClass().getResource(path);
		if (imgURL != null) {
			ImageIcon tempIcon = new ImageIcon(imgURL, description);
			Image tempImage = tempIcon.getImage();
			Image finalImage = tempImage.getScaledInstance(logFrame.lblImagelab.getWidth(), logFrame.lblImagelab.getHeight(),
					Image.SCALE_SMOOTH);
			imgiconteste = new ImageIcon(finalImage);
		}
		
		assertEquals(imgicon, imgicon);
	}
	
}
