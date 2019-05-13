package gui.admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import config.User;
import db_config.MySqlConnection;
import gui.geral.LoginFrame;
import gui.investigador.ApagarMedicaoFrame;
import gui.investigador.ApagarVariavelMedidaFrame;
import gui.investigador.CriarVariavelMedidaFrame;
import gui.investigador.InserirMedicoesFrame;
import gui.investigador.MudarMedicaoFrame;
import gui.investigador.SelectMedicoesFrame;
import gui.investigador.mudarLimitesFrame;

// TODO: Auto-generated Javadoc
/**
 * The Class AdminFrame.
 *  *  @author jasbs1-iscteiul
 *  * @version 1.0
 */

public class AdminFrame extends JFrame {
	
	/** The admin frame product. */
	private AdminFrameProduct adminFrameProduct = new AdminFrameProduct();

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The user. */
	private User user;
	
	/** The msqlc. */
	private MySqlConnection msqlc;

	/** The panel operations 1. */
	private JPanel panelOperations1;
	
	/** The lbl hello. */
	private JLabel lblHello;
	
	/** The panel operations 2. */
	private JPanel panelOperations2;
	
	/** The panel operations 3. */
	private JPanel panelOperations3;
	
	/** The btn criar auditor. */
	private JButton btnCriarAuditor;
	
	/** The btn mudar auditor. */
	private JButton btnMudarAuditor;
	
	/** The btn mudar investigador. */
	private JButton btnMudarInvestigador;
	
	/** The label empty 2. */
	private JLabel labelEmpty2;
	
	/** The btn log out. */
	private JButton btnLogOut;
	
	/** The lbl imagelab. */
	private JLabel lblImagelab;
	
	/** The btn apagar auditor. */
	private JButton btnApagarAuditor;
	
	/** The btn criar investigador. */
	private JButton btnCriarInvestigador;
	
	/** The panel operations 0. */
	private JPanel panelOperations0;
	
	/** The btn criar admin. */
	private JButton btnCriarAdmin;
	
	/** The btn apagar investigador. */
	private JButton btnApagarInvestigador;
	
	/** The label 1. */
	private JLabel label_1;
	
	/** The label 2. */
	private JLabel label_2;

	/**
	 * Instantiates a new admin frame.
	 *
	 * @param user the user
	 * @param msqlc the msqlc
	 */
	public AdminFrame(User user, MySqlConnection msqlc) {
		this.user = user;
		this.msqlc = msqlc;
		adminFrameProduct.addPanels(this);
		addLabels();
		addOperationsPanels();
		addButtons();
		addActionListeners();
		addDefaultSettings();
	}

	/**
	 * Adds the default settings.
	 */
	private void addDefaultSettings() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setSize(800, 500);
		setResizable(false);
//		pack();
		repaint();
		revalidate();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		setVisible(true);
	}

	/**
	 * Adds the operations panels.
	 */
	private void addOperationsPanels() {

		panelOperations0 = new JPanel();
		panelOperations0.setBackground(new Color(240, 248, 255));
		adminFrameProduct.getPanelLeft().add(panelOperations0);
		panelOperations0.setLayout(new GridLayout(3, 1, 0, 0));
				
				label_1 = new JLabel("");
				label_1.setBackground(SystemColor.inactiveCaption);
				panelOperations0.add(label_1);
				
				label_2 = new JLabel("");
				label_2.setBackground(SystemColor.inactiveCaption);
				panelOperations0.add(label_2);
				
						btnCriarAdmin = new JButton("Criar Administrador");
						btnCriarAdmin.setFont(new Font("Yu Gothic Light", Font.BOLD, 17));
						panelOperations0.add(btnCriarAdmin);
		panelOperations1 = new JPanel();
		adminFrameProduct.getPanelLeft().add(panelOperations1);
		panelOperations1.setLayout(new GridLayout(3, 1, 0, 0));

		panelOperations2 = new JPanel();
		panelOperations2.setBackground(new Color(240, 255, 255));
		adminFrameProduct.getPanelLeft().add(panelOperations2);
		panelOperations2.setLayout(new GridLayout(3, 1, 0, 0));

		panelOperations3 = new JPanel();
		panelOperations3.setBackground(new Color(240, 248, 255));
		adminFrameProduct.getPanelLeft().add(panelOperations3);
		panelOperations3.setLayout(new GridLayout(2, 1, 0, 0));

	}

	/**
	 * Adds the labels.
	 */
	private void addLabels() {
		lblHello = new JLabel("  hello, " + user.getName().toUpperCase());
		lblHello.setFont(new Font("Yu Gothic Light", Font.BOLD, 18));
		adminFrameProduct.getPanelLeft().add(lblHello);

		lblImagelab = new JLabel();
		lblImagelab.setBounds(0, 0, 664, 478);
		ImageIcon icon = createImageIcon("/images/lab_intro.jpg", "LabManagement", lblImagelab);
		lblImagelab.setIcon(icon);
		adminFrameProduct.getPanelCenter().add(lblImagelab);
	}

	/**
	 * Adds the buttons.
	 */
	private void addButtons() {
		btnCriarAuditor = new JButton("CriarAuditor");
		btnCriarAuditor.setFont(new Font("Yu Gothic Light", Font.BOLD, 17));
		panelOperations1.add(btnCriarAuditor);

		btnMudarAuditor = new JButton("Mudar Auditor");
		btnMudarAuditor.setFont(new Font("Yu Gothic Light", Font.BOLD, 17));
		panelOperations1.add(btnMudarAuditor);

		btnApagarAuditor = new JButton("ApagarAuditor");
		btnApagarAuditor.setFont(new Font("Yu Gothic Light", Font.BOLD, 17));
		panelOperations1.add(btnApagarAuditor);

		btnCriarInvestigador = new JButton("Criar Investigador");
		btnCriarInvestigador.setFont(new Font("Yu Gothic Light", Font.BOLD, 17));
		panelOperations2.add(btnCriarInvestigador);

		btnMudarInvestigador = new JButton("Mudar Investigador");
		btnMudarInvestigador.setFont(new Font("Yu Gothic Light", Font.BOLD, 17));
		panelOperations2.add(btnMudarInvestigador);
		
		btnApagarInvestigador = new JButton("Apagar Investigador");
		btnApagarInvestigador.setFont(new Font("Yu Gothic Light", Font.BOLD, 17));
		panelOperations2.add(btnApagarInvestigador);

		labelEmpty2 = new JLabel("");
		labelEmpty2.setBackground(SystemColor.window);
		panelOperations3.add(labelEmpty2);

		btnLogOut = new JButton("Log Out");
		btnLogOut.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		panelOperations3.add(btnLogOut);
	}

	/**
	 * Adds the action listeners.
	 */
	private void addActionListeners() {
		btnCriarAuditor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CriarAuditorFrame caf = new CriarAuditorFrame(msqlc);
			}
		});
		btnMudarAuditor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MudarAuditorFrame imf = new MudarAuditorFrame(msqlc);
			}
		});
		btnMudarInvestigador.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MudarInvestigadorFrame mif = new MudarInvestigadorFrame(msqlc);
			}
		});
		btnCriarAdmin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CriarAdminFrame caf = new CriarAdminFrame(msqlc);
			}
		});
		btnApagarAuditor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ApagarAuditorFrame aaf = new ApagarAuditorFrame(msqlc);
			}
		});
		btnCriarInvestigador.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CriarInvestigadorFrame cif = new CriarInvestigadorFrame(msqlc);
			}
		});
		btnLogOut.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int dialogResult = JOptionPane.showConfirmDialog(null, "Confirmar Log Out?", "Warning",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (dialogResult == JOptionPane.YES_OPTION) {
					dispose();
					LoginFrame lf = new LoginFrame();
				}
			}
		});
		btnApagarInvestigador.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ApagarInvestigadorFrame aif = new ApagarInvestigadorFrame(msqlc);
			}
		});
	}

	/**
	 * Creates the image icon.
	 *
	 * @param path the path
	 * @param description the description
	 * @param label the label
	 * @return the image icon
	 */
	protected ImageIcon createImageIcon(String path, String description, JLabel label) {
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			ImageIcon tempIcon = new ImageIcon(imgURL, description);
			Image tempImage = tempIcon.getImage();
			Image finalImage = tempImage.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
			return new ImageIcon(finalImage);
//return new ImageIcon(imgURL, description);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
//return new ImageIcon(path, description);
	}
}
