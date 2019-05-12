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

public class AdminFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	private User user;
	private MySqlConnection msqlc;

	private JPanel panelLeft;
	private JPanel panelCenter;
	private JPanel panelOperations1;
	private JLabel lblHello;
	private JPanel panelOperations2;
	private JPanel panelOperations3;
	private JButton btnCriarAuditor;
	private JButton btnMudarAuditor;
	private JButton btnMudarInvestigador;
	private JLabel labelEmpty2;
	private JButton btnLogOut;
	private JLabel lblImagelab;
	private JButton btnApagarAuditor;
	private JButton btnCriarInvestigador;
	private JPanel panelOperations0;
	private JButton btnCriarAdmin;
	private JButton btnApagarInvestigador;
	private JLabel label_1;
	private JLabel label_2;

	public AdminFrame(User user, MySqlConnection msqlc) {
		this.user = user;
		this.msqlc = msqlc;
		addPanels();
		addLabels();
		addOperationsPanels();
		addButtons();
		addActionListeners();
		addDefaultSettings();
	}

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

	private void addPanels() {
		getContentPane().setLayout(new BorderLayout(0, 0));
		panelLeft = new JPanel();
		panelLeft.setBackground(new Color(240, 248, 255));
		panelLeft.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
		getContentPane().add(panelLeft, BorderLayout.WEST);
		panelLeft.setLayout(new GridLayout(5, 1, 0, 0));
		panelCenter = new JPanel();
		panelCenter.setLayout(new BorderLayout(0, 0));
		getContentPane().add(panelCenter, BorderLayout.CENTER);
	}

	private void addOperationsPanels() {

		panelOperations0 = new JPanel();
		panelOperations0.setBackground(new Color(240, 248, 255));
		panelLeft.add(panelOperations0);
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
		panelLeft.add(panelOperations1);
		panelOperations1.setLayout(new GridLayout(3, 1, 0, 0));

		panelOperations2 = new JPanel();
		panelOperations2.setBackground(new Color(240, 255, 255));
		panelLeft.add(panelOperations2);
		panelOperations2.setLayout(new GridLayout(3, 1, 0, 0));

		panelOperations3 = new JPanel();
		panelOperations3.setBackground(new Color(240, 248, 255));
		panelLeft.add(panelOperations3);
		panelOperations3.setLayout(new GridLayout(2, 1, 0, 0));

	}

	private void addLabels() {
		lblHello = new JLabel("  hello, " + user.getName().toUpperCase());
		lblHello.setFont(new Font("Yu Gothic Light", Font.BOLD, 18));
		panelLeft.add(lblHello);

		lblImagelab = new JLabel();
		lblImagelab.setBounds(0, 0, 664, 478);
		ImageIcon icon = createImageIcon("/images/lab_intro.jpg", "LabManagement", lblImagelab);
		lblImagelab.setIcon(icon);
		panelCenter.add(lblImagelab);
	}

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
				mudarLimitesFrame mlf = new mudarLimitesFrame(msqlc);
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
				MudarMedicaoFrame mmf = new MudarMedicaoFrame(msqlc);
			}
		});
		btnCriarInvestigador.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ApagarMedicaoFrame amf = new ApagarMedicaoFrame(msqlc);
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
	}

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
