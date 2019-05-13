package gui.investigador;

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
 * The Class CriarVariavelMedidaFrame.
 *  *  @author jasbs1-iscteiul
 *  * @version 1.0
 */
public class CriarVariavelMedidaFrame extends JFrame{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The interaction. */
	private Interaction interaction;

	/** The txt nome variavel. */
	private JTextField txtNomeVariavel;
	
	/** The txt id cultura. */
	private JTextField txtIdCultura;
	
	/** The txt limite superior. */
	private JTextField txtLimiteSuperior;
	
	/** The txt limiteinferior. */
	private JTextField txtLimiteinferior;

	/**
	 * Instantiates a new criar variavel medida frame.
	 *
	 * @param msqlc the msqlc
	 */
	public CriarVariavelMedidaFrame(MySqlConnection msqlc) {
		setType(Type.UTILITY);
		setTitle("CRIAR");
		getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel centerPanel = new JPanel();
		getContentPane().add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new GridLayout(4, 2, 0, 0));

		JLabel lblNomeVariavel = new JLabel("Nome Variavel:");
		centerPanel.add(lblNomeVariavel);
		lblNomeVariavel.setFont(new Font("Yu Gothic Light", Font.BOLD, 16));
		lblNomeVariavel.setHorizontalAlignment(SwingConstants.RIGHT);

		txtNomeVariavel = new JTextField();
		centerPanel.add(txtNomeVariavel);
		txtNomeVariavel.setColumns(10);

		JLabel lblIdCultura = new JLabel("Id Cultura:");
		centerPanel.add(lblIdCultura);
		lblIdCultura.setFont(new Font("Yu Gothic Light", Font.BOLD, 16));
		lblIdCultura.setHorizontalAlignment(SwingConstants.RIGHT);

		txtIdCultura = new JTextField();
		centerPanel.add(txtIdCultura);
		txtIdCultura.setColumns(10);

		JLabel lblLimiteSuperior = new JLabel("Limite Superior:");
		lblLimiteSuperior.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLimiteSuperior.setFont(new Font("Yu Gothic Light", Font.BOLD, 16));
		centerPanel.add(lblLimiteSuperior);

		txtLimiteSuperior = new JTextField();
		centerPanel.add(txtLimiteSuperior);
		txtLimiteSuperior.setColumns(10);
		
		JLabel lblLimiteInferior = new JLabel("Limite Inferior:");
		lblLimiteInferior.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLimiteInferior.setFont(new Font("Yu Gothic Light", Font.BOLD, 16));
		centerPanel.add(lblLimiteInferior);
		
		txtLimiteinferior = new JTextField();
		centerPanel.add(txtLimiteinferior);
		txtLimiteinferior.setColumns(10);

		JPanel panelButton = new JPanel();
		getContentPane().add(panelButton, BorderLayout.SOUTH);
		panelButton.setLayout(new BorderLayout(0, 0));

		JButton btnInserir = new JButton("CRIAR");
		btnInserir.setFont(new Font("Yu Gothic Light", Font.BOLD, 18));
		panelButton.add(btnInserir);
		pack();

		ActionListener actionListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!txtNomeVariavel.equals("") && !txtIdCultura.equals("")
						&& !txtLimiteSuperior.equals("")) {
					String nomeVariavel = txtNomeVariavel.getText();
					String idCultura = txtIdCultura.getText();
					String limiteSuperior = txtLimiteSuperior.getText();
					String limiteInferior = txtLimiteinferior.getText();
					interaction = new Interaction(msqlc);
					try {
						interaction.criarVariavelMedida(nomeVariavel, idCultura, limiteSuperior, limiteInferior);
						JOptionPane.showMessageDialog(null, "Variavel medida criada", "Success",
								JOptionPane.INFORMATION_MESSAGE);
					} catch (SQLException e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, e1.getMessage(), "WARNING",
								JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		};

		txtIdCultura.addActionListener(actionListener);
		txtNomeVariavel.addActionListener(actionListener);
		btnInserir.addActionListener(actionListener);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		setVisible(true);

	}
}
