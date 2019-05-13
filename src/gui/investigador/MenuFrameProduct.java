package gui.investigador;


import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.GridLayout;
import java.io.Serializable;

public class MenuFrameProduct implements Serializable {
	private JPanel panelLeft;
	private JPanel panelCenter;

	public JPanel getPanelLeft() {
		return panelLeft;
	}

	public JPanel getPanelCenter() {
		return panelCenter;
	}

	public void addPanels(MenuFrame menuFrame) {
		menuFrame.getContentPane().setLayout(new BorderLayout(0, 0));
		panelLeft = new JPanel();
		panelLeft.setBackground(new Color(240, 248, 255));
		panelLeft.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
		menuFrame.getContentPane().add(panelLeft, BorderLayout.WEST);
		panelLeft.setLayout(new GridLayout(5, 1, 0, 0));
		panelCenter = new JPanel();
		panelCenter.setLayout(new BorderLayout(0, 0));
		menuFrame.getContentPane().add(panelCenter, BorderLayout.CENTER);
	}
}