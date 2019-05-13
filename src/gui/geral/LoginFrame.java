package gui.geral;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import config.User;
import db_config.MySqlConnection;
import db_interaction.Interaction;
import gui.admin.AdminFrame;
import gui.investigador.MenuFrame;

public class LoginFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private User user;
	public final static String DATABASE = "sid22";
	private MySqlConnection msqlc;
	private MySqlConnection msqlc_mysqlDB;

	public JPanel panel;
	private JTextField username;
	public JPasswordField password;
	private JButton btnLogin = new JButton("LOGIN");
	public JLabel lblImagelab;
	public JRadioButton rdbtnAdminMode;

	public LoginFrame() {
		msqlc = new MySqlConnection();
		msqlc_mysqlDB = new MySqlConnection();
		addPanels();
		addTextfields();
		addButtons();
		addLabels();
		addActionListeners();
		addDefaultSettings();
	}

	public void addDefaultSettings() {
//		setUndecorated(true);
//		getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(new Dimension(670, 513));
		setResizable(false);
		repaint();
		revalidate();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		setVisible(true);
	}

	public void addPanels() {
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
	}

	public void addTextfields() {
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
	}

	public void addButtons() {
		btnLogin = new JButton("LOGIN");
		btnLogin.setForeground(Color.DARK_GRAY);
		btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 23));
		btnLogin.setBounds(274, 351, 126, 50);
		panel.add(btnLogin);

		rdbtnAdminMode = new JRadioButton("admin mode");
		rdbtnAdminMode.setBackground(new Color(255, 255, 255));
		rdbtnAdminMode.setFont(new Font("Yu Gothic Light", Font.BOLD, 16));
		rdbtnAdminMode.setBounds(274, 444, 126, 25);
		panel.add(rdbtnAdminMode);
	}

	public void addLabels() {

		lblImagelab = new JLabel();
		lblImagelab.setBounds(0, 0, 664, 478);
		ImageIcon icon = createImageIcon("/images/lab_intro.jpg", "LabManagement");
		lblImagelab.setIcon(icon);
		panel.add(lblImagelab);
	}

	private void addActionListeners() {
		ActionListener loginListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = username.getText();
				System.out.println(name);
				String pass = new String(password.getPassword());
				System.out.println(pass);
				msqlc.init("localhost/" + DATABASE, name, pass);
				msqlc_mysqlDB.init("localhost/mysql", "root", "");
				Interaction interaction = new Interaction(msqlc_mysqlDB);
				if (msqlc.isLoggedIn()) {
					user = new User(name, pass);
					try {
						user.setCredentials();
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
					try {
						if (!rdbtnAdminMode.isSelected() && interaction.isAdminOrInvestigador(name)) {
							MenuFrame menuFrame = new MenuFrame(user, msqlc);
							dispose();
						} else {
							try {
								if (interaction.isAdmin(name)) {
									AdminFrame adminFrame = new AdminFrame(user, msqlc);
									dispose();
								}
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				} else {

					JOptionPane.showMessageDialog(null, "Wrong credentials", "WARNING",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		};
		btnLogin.addActionListener(loginListener);
		username.addActionListener(loginListener);
		password.addActionListener(loginListener);
	}

	/** Returns an ImageIcon, or null if the path was invalid. */
	public ImageIcon createImageIcon(String path, String description) {
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			ImageIcon tempIcon = new ImageIcon(imgURL, description);
			Image tempImage = tempIcon.getImage();
			Image finalImage = tempImage.getScaledInstance(lblImagelab.getWidth(), lblImagelab.getHeight(),
					Image.SCALE_SMOOTH);
			return new ImageIcon(finalImage);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}

	public static void main(String[] args) {
		LoginFrame lf = new LoginFrame();
	}
}
