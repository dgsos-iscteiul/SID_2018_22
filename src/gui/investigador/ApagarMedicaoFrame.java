package gui.investigador;

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

// TODO: Auto-generated Javadoc
/**
 * The Class ApagarMedicaoFrame.
 *  *  @author jasbs1-iscteiul
 *  * @version 1.0
 */
public class ApagarMedicaoFrame extends JFrame{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The interaction. */
	private Interaction interaction;

	/** The txt id medicao. */
	private JTextField txtIdMedicao;

	/**
	 * Instantiates a new apagar medicao frame.
	 *
	 * @param msqlc the msqlc
	 */
	public ApagarMedicaoFrame(MySqlConnection msqlc) {
		setType(Type.UTILITY);
		setTitle("APAGAR");
		getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel centerPanel = new JPanel();
		getContentPane().add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new GridLayout(1, 1, 0, 0));

		JLabel lblIdVariaveisMedidas = new JLabel("Id Medicao:");
		centerPanel.add(lblIdVariaveisMedidas);
		lblIdVariaveisMedidas.setFont(new Font("Yu Gothic Light", Font.BOLD, 16));
		lblIdVariaveisMedidas.setHorizontalAlignment(SwingConstants.RIGHT);

		txtIdMedicao = new JTextField();
		centerPanel.add(txtIdMedicao);
		txtIdMedicao.setColumns(10);

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
				if (!txtIdMedicao.equals("")) {
					String idMedicao = txtIdMedicao.getText();
					interaction = new Interaction(msqlc);
					try {
						interaction.apagarMedicao(idMedicao);
						JOptionPane.showMessageDialog(null, "Medicao apagada", "Success",
								JOptionPane.INFORMATION_MESSAGE);
					} catch (SQLException e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, e1.getMessage(), "WARNING",
								JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		};
		txtIdMedicao.addActionListener(actionListener);
		btnInserir.addActionListener(actionListener);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		setVisible(true);

	}
}
