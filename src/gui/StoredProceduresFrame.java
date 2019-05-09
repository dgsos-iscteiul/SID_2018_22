package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import db_config.MySqlConnection;
import db_interaction.Interaction;
import net.proteanit.sql.DbUtils;

public class StoredProceduresFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MySqlConnection msql = new MySqlConnection();
	private Interaction interaction = new Interaction(msql);
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;
	public StoredProceduresFrame() throws SQLException {
		msql.init("localhost/sid", "root", "");
		constructFrame();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	private void constructFrame() throws SQLException {
		setSize(new Dimension(1000, 600));
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("Button.light"));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		
		JLabel lblIdcultura = new JLabel("idCultura:");
		lblIdcultura.setFont(new Font("Segoe UI", Font.BOLD, 18));
		panel.add(lblIdcultura, "2, 2, right, default");
		
		textField = new JTextField();
		panel.add(textField, "4, 2, left, default");
		textField.setColumns(10);
		
		JLabel lblIdvariaveismedidas = new JLabel("idVariaveisMedidas:");
		lblIdvariaveismedidas.setFont(new Font("Segoe UI", Font.BOLD, 18));
		panel.add(lblIdvariaveismedidas, "2, 4, right, default");
		
		textField_1 = new JTextField();
		panel.add(textField_1, "4, 4, left, default");
		textField_1.setColumns(10);
		
		JLabel lblIdmedicoes = new JLabel("idMedicoes:");
		lblIdmedicoes.setFont(new Font("Segoe UI", Font.BOLD, 18));
		panel.add(lblIdmedicoes, "2, 6, right, default");
		
		textField_2 = new JTextField();
		panel.add(textField_2, "4, 6, left, default");
		textField_2.setColumns(10);
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(btnSearch, "4, 8, left, default");
		
		JLabel lblResults = new JLabel("RESULTS");
		lblResults.setFont(new Font("Segoe UI Emoji", Font.BOLD, 22));
		panel.add(lblResults, "2, 10, center, default");
		
		table = new JTable();
		ResultSet rs = interaction.selectMedicoes("12", null, null);
		table.setModel(DbUtils.resultSetToTableModel(rs));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setViewportView(table);

		panel.add(scrollPane, "4, 10, fill, fill");
	}
	
	public static void main(String[] args) throws SQLException {
		StoredProceduresFrame spf= new StoredProceduresFrame();
	}

}
