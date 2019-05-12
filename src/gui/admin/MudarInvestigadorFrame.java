package gui.admin;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.Window.Type;
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

public class MudarInvestigadorFrame extends JFrame{
	private static final long serialVersionUID = 1L;

	private Interaction interaction;

	private JTextField txtUsername;
	private JTextField txtEmail;
	private JTextField txtCategoriaProfissional;

	public MudarInvestigadorFrame(MySqlConnection msqlc) {
		setType(Type.UTILITY);
		setTitle("MUDAR");
		getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel centerPanel = new JPanel();
		getContentPane().add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new GridLayout(3, 2, 0, 0));

		JLabel lblIdVariaveisMedidas = new JLabel("Username:");
		centerPanel.add(lblIdVariaveisMedidas);
		lblIdVariaveisMedidas.setFont(new Font("Yu Gothic Light", Font.BOLD, 16));
		lblIdVariaveisMedidas.setHorizontalAlignment(SwingConstants.RIGHT);

		txtUsername = new JTextField();
		centerPanel.add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setFont(new Font("Yu Gothic Light", Font.BOLD, 16));
		centerPanel.add(lblEmail);
		
		txtEmail = new JTextField();
		centerPanel.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblCategoriaProfissional = new JLabel("Categoria Profissional:");
		lblCategoriaProfissional.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCategoriaProfissional.setFont(new Font("Yu Gothic Light", Font.BOLD, 16));
		centerPanel.add(lblCategoriaProfissional);
		
		txtCategoriaProfissional = new JTextField();
		centerPanel.add(txtCategoriaProfissional);
		txtCategoriaProfissional.setColumns(10);

		JPanel panelButton = new JPanel();
		getContentPane().add(panelButton, BorderLayout.SOUTH);
		panelButton.setLayout(new BorderLayout(0, 0));

		JButton btnInserir = new JButton("MUDAR");
		btnInserir.setFont(new Font("Yu Gothic Light", Font.BOLD, 18));
		panelButton.add(btnInserir);
		pack();

		ActionListener actionListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!txtUsername.equals("")) {
					String username = txtUsername.getText();
					String email = txtEmail.getText();
					String categoria = txtCategoriaProfissional.getText();
					interaction = new Interaction(msqlc);
					try {
						interaction.mudarInvestigador(username, email, categoria);
						JOptionPane.showMessageDialog(null, "Investigador mudado", "Success",
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
