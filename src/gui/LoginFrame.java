package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import db_config.MySqlConnection;
import java.awt.Color;
import javax.swing.JLabel;

public class LoginFrame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField username;
	private JPasswordField password;
	private MySqlConnection msqlc;
	private JButton btnLogin = new JButton("LOGIN");
	private JLabel lblNewLabel = new JLabel("New label");
	
	public LoginFrame() {
		
		msqlc = new MySqlConnection();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		setSize(new Dimension(670, 510));
		
		username = new JTextField();
		username.setHorizontalAlignment(SwingConstants.CENTER);
		username.setFont(new Font("Segoe UI", Font.PLAIN, 23));
		username.setBounds(134, 224, 391, 44);
		panel.add(username);
		username.setColumns(10);
		
		password = new JPasswordField();
		password.setHorizontalAlignment(SwingConstants.CENTER);
		password.setFont(new Font("Segoe UI", Font.PLAIN, 23));
		password.setColumns(10);
		password.setBounds(134, 294, 391, 44);
		panel.add(password);
		
		btnLogin = new JButton("LOGIN");
		btnLogin.setForeground(Color.DARK_GRAY);
		btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 23));
		btnLogin.setBounds(274, 351, 126, 50);
		panel.add(btnLogin);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel.setBounds(134, 414, 391, 36);
		panel.add(lblNewLabel);
		
		addActionListeners();
		
		setVisible(true);
	}
	
	private void addActionListeners() {
		ActionListener loginListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String user = username.getText();
				System.out.println(user);
				String pass = new String(password.getPassword());
				System.out.println(pass);
				msqlc.init("localhost/sid", user, pass);
				if(msqlc.isLoggedIn()) {
					lblNewLabel.setText("SUCCESS! LOGGED IN.");
				}
				else {
					lblNewLabel.setText("ERROR! WRONG CREDENTIALS.");
				}
			}
		};
		btnLogin.addActionListener(loginListener);
		username.addActionListener(loginListener);
		password.addActionListener(loginListener);
	}
	
	public static void main(String[] args) {
		LoginFrame lf = new LoginFrame();
	}
}
