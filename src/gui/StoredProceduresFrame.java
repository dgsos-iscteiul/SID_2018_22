package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JButton;

public class StoredProceduresFrame extends JFrame{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;
	public StoredProceduresFrame() {
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
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, "4, 10, fill, fill");
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}

}
