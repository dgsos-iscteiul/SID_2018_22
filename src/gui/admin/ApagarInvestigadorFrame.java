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

public class ApagarInvestigadorFrame extends JFrame{
	private static final long serialVersionUID = 1L;

	private Interaction interaction;

	private JTextField txtEmail;

	public ApagarInvestigadorFrame(MySqlConnection msqlc) {
		setType(Type.UTILITY);
		setTitle("APAGAR");
		getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel centerPanel = new JPanel();
		getContentPane().add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new GridLayout(1, 2, 0, 0));

		JLabel lblUsername = new JLabel("Email:");
		centerPanel.add(lblUsername);
		lblUsername.setFont(new Font("Yu Gothic Light", Font.BOLD, 16));
		lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);

		txtEmail = new JTextField();
		centerPanel.add(txtEmail);
		txtEmail.setColumns(10);

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
				if (!txtEmail.equals("")) {
					String email = txtEmail.getText();
					interaction = new Interaction(msqlc);
					try {
						interaction.apagarInvestigador(email);
						JOptionPane.showMessageDialog(null, "Investigador apagado", "Success",
								JOptionPane.INFORMATION_MESSAGE);
					} catch (SQLException e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, e1.getMessage(), "WARNING",
								JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		};
		txtEmail.addActionListener(actionListener);
		btnInserir.addActionListener(actionListener);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		setVisible(true);
	}
}
