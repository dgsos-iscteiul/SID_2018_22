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

public class ApagarVariavelMedidaFrame extends JFrame{
	private static final long serialVersionUID = 1L;

	private Interaction interaction;

	private JTextField txtIdVariaveisMedidas;

	public ApagarVariavelMedidaFrame(MySqlConnection msqlc) {
		setType(Type.UTILITY);
		setTitle("APAGAR");
		getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel centerPanel = new JPanel();
		getContentPane().add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new GridLayout(1, 2, 0, 0));

		JLabel lblIdVariaveisMedidas = new JLabel("Id Variaveis Medidas:");
		centerPanel.add(lblIdVariaveisMedidas);
		lblIdVariaveisMedidas.setFont(new Font("Yu Gothic Light", Font.BOLD, 16));
		lblIdVariaveisMedidas.setHorizontalAlignment(SwingConstants.RIGHT);

		txtIdVariaveisMedidas = new JTextField();
		centerPanel.add(txtIdVariaveisMedidas);
		txtIdVariaveisMedidas.setColumns(10);

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
				if (!txtIdVariaveisMedidas.equals("")) {
					String nomeVariavel = txtIdVariaveisMedidas.getText();
					interaction = new Interaction(msqlc);
					try {
						interaction.apagarVariavelMedida(nomeVariavel);
						JOptionPane.showMessageDialog(null, "Variavel medida apagada", "Success",
								JOptionPane.INFORMATION_MESSAGE);
					} catch (SQLException e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, e1.getMessage(), "WARNING",
								JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		};
		txtIdVariaveisMedidas.addActionListener(actionListener);
		btnInserir.addActionListener(actionListener);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		setVisible(true);

	}
}
