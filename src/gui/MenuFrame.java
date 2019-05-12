package gui;

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

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.LineBorder;

import config.User;

public class MenuFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private User user;

	private JPanel panelLeft;
	private JPanel panelCenter;
	private JPanel panelOperations1;
	private JLabel lblHello;
	private JLabel lblEmpty;
	private JPanel panelOperations2;
	private JPanel panelOperations3;
	private JButton btnSelectmedicoes;
	private JButton btnInserirmedicao;
	private JButton btnMudarLimites;
	private JLabel labelEmpty2;
	private JButton btnLogOut;
	private JLabel lblImagelab;

	public MenuFrame(User user) {
		this.user = user;
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
		panelLeft.setBackground(SystemColor.window);
		panelLeft.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
		getContentPane().add(panelLeft, BorderLayout.WEST);
		panelLeft.setLayout(new GridLayout(5, 1, 0, 0));
		panelCenter = new JPanel();
		panelCenter.setLayout(new BorderLayout(0, 0));
		getContentPane().add(panelCenter, BorderLayout.CENTER);
	}

	private void addOperationsPanels() {
		panelOperations1 = new JPanel();
		panelLeft.add(panelOperations1);
		panelOperations1.setLayout(new GridLayout(2, 1, 0, 0));

		panelOperations2 = new JPanel();
		panelOperations2.setBackground(SystemColor.window);
		panelLeft.add(panelOperations2);
		panelOperations2.setLayout(new GridLayout(2, 1, 0, 0));

		panelOperations3 = new JPanel();
		panelOperations3.setBackground(SystemColor.window);
		panelLeft.add(panelOperations3);
		panelOperations3.setLayout(new GridLayout(2, 1, 0, 0));

	}

	private void addLabels() {
		lblHello = new JLabel("  hello, " + user.getName().toUpperCase());
		lblHello.setFont(new Font("Segoe UI", Font.BOLD, 18));
		panelLeft.add(lblHello);
		lblEmpty = new JLabel();
		lblEmpty.setBackground(Color.WHITE);
		panelLeft.add(lblEmpty);

		lblImagelab = new JLabel();
		lblImagelab.setBounds(0, 0, 664, 478);
		ImageIcon icon = createImageIcon("/images/menu.jpg", "LabManagement");
		lblImagelab.setIcon(icon);
		panelCenter.add(lblImagelab);
	}

	private void addButtons() {
		btnSelectmedicoes = new JButton("Select Medicoes");
		btnSelectmedicoes.setFont(new Font("Yu Gothic Light", Font.BOLD, 17));
		panelOperations1.add(btnSelectmedicoes);

		btnInserirmedicao = new JButton("Inserir Medicao");
		btnInserirmedicao.setFont(new Font("Yu Gothic Light", Font.BOLD, 17));
		panelOperations1.add(btnInserirmedicao);

		btnMudarLimites = new JButton("Mudar Limites");
		btnMudarLimites.setFont(new Font("Yu Gothic Light", Font.BOLD, 17));
		panelOperations2.add(btnMudarLimites);

		labelEmpty2 = new JLabel("");
		labelEmpty2.setBackground(SystemColor.window);
		panelOperations3.add(labelEmpty2);

		btnLogOut = new JButton("Log Out");
		btnLogOut.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		panelOperations3.add(btnLogOut);
	}

	private void addActionListeners() {
		btnSelectmedicoes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					SelectMedicoesFrame spf = new SelectMedicoesFrame();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				repaint();
				revalidate();
			}
		});
	}

	private void addPanelCenter(int option) {
		switch (option) {
		case 0:
			JPanel panelCenterUp = new JPanel();
			panelCenterUp.setLayout(new SpringLayout());
//			panelCenterUp.add()
			panelCenter.add(panelCenterUp, BorderLayout.NORTH);
			break;
		case 1:

			break;
		case 2:

			break;
		default:

			break;
		}
	}

	protected ImageIcon createImageIcon(String path, String description) {
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			ImageIcon tempIcon = new ImageIcon(imgURL, description);
			Image tempImage = tempIcon.getImage();
			Image finalImage = tempImage.getScaledInstance(lblImagelab.getWidth(), lblImagelab.getHeight(),
					Image.SCALE_SMOOTH);
			return new ImageIcon(finalImage);
//return new ImageIcon(imgURL, description);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
//return new ImageIcon(path, description);
	}

}
