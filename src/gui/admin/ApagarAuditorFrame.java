package gui.admin;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import db_config.MySqlConnection;
import db_interaction.Interaction;

// TODO: Auto-generated Javadoc
/**
 * The Class ApagarAuditorFrame.
 *  *  *  * @author jasbs1-iscteiul
 *  * @version 1.0
 */
public class ApagarAuditorFrame extends JFrame {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The interaction. */
	private Interaction interaction;

	/** The txt username. */
	private JTextField txtUsername;

	/**
	 * Instantiates a new apagar auditor frame.
	 *
	 * @param msqlc the msqlc
	 */
	public ApagarAuditorFrame(MySqlConnection msqlc) {
		setType(Type.UTILITY);
		setTitle("APAGAR");
		getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel centerPanel = new JPanel();
		getContentPane().add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new GridLayout(1, 2, 0, 0));

		JLabel lblUsername = new JLabel("Username:");
		centerPanel.add(lblUsername);
		lblUsername.setFont(new Font("Yu Gothic Light", Font.BOLD, 16));
		lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);

		txtUsername = new JTextField();
		centerPanel.add(txtUsername);
		txtUsername.setColumns(10);

		JPanel panelButton = new JPanel();
		getContentPane().add(panelButton, BorderLayout.SOUTH);
		panelButton.setLayout(new BorderLayout(0, 0));

		JButton btnInserir = new JButton("APAGAR");
		btnInserir.setFont(new Font("Yu Gothic Light", Font.BOLD, 18));
		panelButton.add(btnInserir);
		pack();

		ActionListener actionListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!txtUsername.equals("")) {
					String username = txtUsername.getText();
					interaction = new Interaction(msqlc);
					try {
						interaction.apagarAuditor(username);
						JOptionPane.showMessageDialog(null, "Auditor apagado", "Success",
								JOptionPane.INFORMATION_MESSAGE);
					} catch (SQLException e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, e1.getMessage(), "WARNING",
								JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		};
		txtUsername.addActionListener(actionListener);
		btnInserir.addActionListener(actionListener);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		setVisible(true);
	}
}
