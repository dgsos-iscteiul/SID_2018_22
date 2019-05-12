package gui.investigador;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import db_config.MySqlConnection;
import db_interaction.Interaction;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class InserirMedicoesFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private Interaction interaction;

	private JTextField txtValor;
	private JTextField txtIdvariavelmedida;

	public InserirMedicoesFrame(MySqlConnection msqlc) {
		setType(Type.UTILITY);
		setTitle("INSERIR");
		getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel centerPanel = new JPanel();
		getContentPane().add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new GridLayout(2, 2, 0, 0));

		JLabel lblValor = new JLabel("Valor:");
		centerPanel.add(lblValor);
		lblValor.setFont(new Font("Yu Gothic Light", Font.BOLD, 16));
		lblValor.setHorizontalAlignment(SwingConstants.RIGHT);

		txtValor = new JTextField();
		centerPanel.add(txtValor);
		txtValor.setColumns(10);

		JLabel lblIdVariavelMedida = new JLabel("Id Variavel Medida:");
		centerPanel.add(lblIdVariavelMedida);
		lblIdVariavelMedida.setFont(new Font("Yu Gothic Light", Font.BOLD, 16));
		lblIdVariavelMedida.setHorizontalAlignment(SwingConstants.RIGHT);

		txtIdvariavelmedida = new JTextField();
		centerPanel.add(txtIdvariavelmedida);
		txtIdvariavelmedida.setColumns(10);

		JPanel panelButton = new JPanel();
		getContentPane().add(panelButton, BorderLayout.SOUTH);
		panelButton.setLayout(new BorderLayout(0, 0));

		JButton btnInserir = new JButton("INSERIR");
		btnInserir.setFont(new Font("Yu Gothic Light", Font.BOLD, 18));
		panelButton.add(btnInserir);
		pack();

		ActionListener actionListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!txtValor.equals("") && !txtIdvariavelmedida.equals("")) {
					String valor = txtValor.getText();
					String idVariavelMedida = txtIdvariavelmedida.getText();
					interaction = new Interaction(msqlc);
					try {
						interaction.InserirMedicao(valor, idVariavelMedida);
						JOptionPane.showMessageDialog(null,
								"Valor Adicionado: " + valor + "idVariaveisMedidas: " + idVariavelMedida, "Success",
								JOptionPane.INFORMATION_MESSAGE);
					} catch (SQLException e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, e1.getMessage(), "WARNING",
								JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		};
		
		txtIdvariavelmedida.addActionListener(actionListener);
		txtValor.addActionListener(actionListener);
		btnInserir.addActionListener(actionListener);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		setVisible(true);

	}

}
