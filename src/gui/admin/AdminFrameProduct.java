package gui.admin;


import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.GridLayout;
import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class AdminFrameProduct.
 *  *  * @author jasbs1-iscteiul
 *  * @version 1.0
 */
public class AdminFrameProduct implements Serializable {
	
	/** The panel left. */
	private JPanel panelLeft;
	
	/** The panel center. */
	private JPanel panelCenter;

	/**
	 * Gets the panel left.
	 *
	 * @return the panel left
	 */
	public JPanel getPanelLeft() {
		return panelLeft;
	}

	/**
	 * Gets the panel center.
	 *
	 * @return the panel center
	 */
	public JPanel getPanelCenter() {
		return panelCenter;
	}

	/**
	 * Adds the panels.
	 *
	 * @param adminFrame the admin frame
	 */
	public void addPanels(AdminFrame adminFrame) {
		adminFrame.getContentPane().setLayout(new BorderLayout(0, 0));
		panelLeft = new JPanel();
		panelLeft.setBackground(new Color(240, 248, 255));
		panelLeft.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
		adminFrame.getContentPane().add(panelLeft, BorderLayout.WEST);
		panelLeft.setLayout(new GridLayout(5, 1, 0, 0));
		panelCenter = new JPanel();
		panelCenter.setLayout(new BorderLayout(0, 0));
		adminFrame.getContentPane().add(panelCenter, BorderLayout.CENTER);
	}
}