package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.LineBorder;

import config.User;

public class MenuFrame extends JFrame{

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
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
//		setResizable(false);
		repaint();
		revalidate();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
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
		panelCenter.setLayout(new BorderLayout(0,0));
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
		panelLeft.add(lblEmpty);
	}
	
	private void addButtons() {
		btnSelectmedicoes = new JButton("Select Medicoes");
		panelOperations1.add(btnSelectmedicoes);
		
		btnInserirmedicao = new JButton("Inserir Medicao");
		panelOperations1.add(btnInserirmedicao);
		
		btnMudarLimites = new JButton("Mudar Limites");
		panelOperations2.add(btnMudarLimites);
		
		labelEmpty2 = new JLabel("");
		labelEmpty2.setBackground(SystemColor.window);
		panelOperations3.add(labelEmpty2);
		
		btnLogOut = new JButton("Log Out");
		panelOperations3.add(btnLogOut);
	}
	
	private void addActionListeners() {
		btnSelectmedicoes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				try {
//					panelCenter = new StoredProceduresFrame();
//				} catch (SQLException e1) {
//					e1.printStackTrace();
//				}
//				panelCenter.add(btnInserirmedicao);
//				getContentPane().add(panelCenter);
				try {
					getContentPane().remove(panelCenter);
					getContentPane().add(new StoredProceduresFrame(), BorderLayout.CENTER);
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
	
}
