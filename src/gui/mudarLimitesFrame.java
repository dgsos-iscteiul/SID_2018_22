package gui;

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

public class mudarLimitesFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private Interaction interaction;

	private JTextField txtIdVariaveisMedidas;
	private JTextField txtLimiteInferior;
	private JTextField txtLimiteSuperior;

	public mudarLimitesFrame(MySqlConnection msqlc) {
		setType(Type.UTILITY);
		setTitle("MUDAR");
		getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel centerPanel = new JPanel();
		getContentPane().add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new GridLayout(3, 2, 0, 0));

		JLabel lblIdVariaveisMedidas = new JLabel("Id Variaveis Medidas:");
		centerPanel.add(lblIdVariaveisMedidas);
		lblIdVariaveisMedidas.setFont(new Font("Yu Gothic Light", Font.BOLD, 16));
		lblIdVariaveisMedidas.setHorizontalAlignment(SwingConstants.RIGHT);

		txtIdVariaveisMedidas = new JTextField();
		centerPanel.add(txtIdVariaveisMedidas);
		txtIdVariaveisMedidas.setColumns(10);

		JLabel lblLimiteInferior = new JLabel("Limite Inferior:");
		centerPanel.add(lblLimiteInferior);
		lblLimiteInferior.setFont(new Font("Yu Gothic Light", Font.BOLD, 16));
		lblLimiteInferior.setHorizontalAlignment(SwingConstants.RIGHT);

		txtLimiteInferior = new JTextField();
		centerPanel.add(txtLimiteInferior);
		txtLimiteInferior.setColumns(10);

		JLabel lblLimiteSuperior = new JLabel("Limite Superior:");
		lblLimiteSuperior.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLimiteSuperior.setFont(new Font("Yu Gothic Light", Font.BOLD, 16));
		centerPanel.add(lblLimiteSuperior);

		txtLimiteSuperior = new JTextField();
		centerPanel.add(txtLimiteSuperior);
		txtLimiteSuperior.setColumns(10);

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
				if (!txtIdVariaveisMedidas.equals("") && !txtLimiteInferior.equals("")
						&& !txtLimiteSuperior.equals("")) {
					String idVariaveisMedidas = txtIdVariaveisMedidas.getText();
					String limiteInferior = txtLimiteInferior.getText();
					String limiteSuperior = txtLimiteSuperior.getText();
					interaction = new Interaction(msqlc);
					try {
						interaction.mudarLimites(idVariaveisMedidas, limiteInferior, limiteSuperior);
						JOptionPane.showMessageDialog(null, "Limites mudados", "Success",
								JOptionPane.INFORMATION_MESSAGE);
					} catch (SQLException e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, e1.getMessage(), "WARNING",
								JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		};

		txtLimiteInferior.addActionListener(actionListener);
		txtIdVariaveisMedidas.addActionListener(actionListener);
		btnInserir.addActionListener(actionListener);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		setVisible(true);

	}
}
