package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import db_config.MySqlConnection;

public class LoginFrame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField username;
	private JPasswordField password;
	private MySqlConnection msqlc;
	private JButton btnLogin = new JButton("LOGIN");
	private JLabel lblLoginConfirmation = new JLabel("");
	
	public LoginFrame() {
		
		msqlc = new MySqlConnection();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
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
		
		lblLoginConfirmation = new JLabel("");
		lblLoginConfirmation.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginConfirmation.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblLoginConfirmation.setBounds(134, 414, 391, 36);
		panel.add(lblLoginConfirmation);
		
//		JLabel lblImagelab = new JLabel("image_lab");
//		ImageIcon icon = createImageIcon("images/login_frame_plants.jpg",
//                "a pretty but meaningless splat");
//		JLabel lblimage = new JLabel(icon);
//		lblimage.setBounds(3, 194, 644, -194);
//		panel.add(lblimage);
		
		JLabel lblImagelab = new JLabel();
		lblImagelab.setBounds(12, 13, 628, 200);
		ImageIcon icon = createImageIcon("/images/login_frame_plants.jpg", "LabManagement");
		lblImagelab.setIcon(icon);
//		Icon imageIcon = new ImageIcon(getClass().getResource("/images/login_frame_plants.jpg"));
//		lblImagelab.setIcon(imageIcon);
		panel.add(lblImagelab);
		
		repaint();
		revalidate();
		
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
					lblLoginConfirmation.setText("SUCCESS! LOGGED IN.");
				}
				else {
					lblLoginConfirmation.setText("ERROR! WRONG CREDENTIALS.");
				}
			}
		};
		btnLogin.addActionListener(loginListener);
		username.addActionListener(loginListener);
		password.addActionListener(loginListener);
	}
	
	/** Returns an ImageIcon, or null if the path was invalid. */
	protected ImageIcon createImageIcon(String path,
	                                           String description) {
	    java.net.URL imgURL = getClass().getResource(path);
	    if (imgURL != null) {
	        return new ImageIcon(imgURL, description);
	    } else {
	        System.err.println("Couldn't find file: " + path);
	        return null;
	    }
//		return new ImageIcon(path, description);
	}
	
	public static void main(String[] args) {
		LoginFrame lf = new LoginFrame();
	}
}
