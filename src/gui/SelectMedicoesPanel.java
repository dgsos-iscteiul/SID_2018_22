package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.BorderLayout;
import javax.swing.SpringLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import db_interaction.Interaction;
import net.proteanit.sql.DbUtils;

import java.awt.FlowLayout;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class SelectMedicoesPanel extends JPanel{

	private static final long serialVersionUID = 1L;

	private Interaction interaction;
	
	private JTextField textFieldIdCultura;
	private JTextField textFieldIdVariaveisMedidas;
	private JTextField textFieldIdMedicao;
	private JTable table;
	private JScrollPane scrollPane;

	public SelectMedicoesPanel() throws SQLException {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblIdCultura = new JLabel("id cultura:");
		panel.add(lblIdCultura);
		
		textFieldIdCultura = new JTextField();
		panel.add(textFieldIdCultura);
		textFieldIdCultura.setColumns(10);
		
		JLabel lblIdVariaveisMedidas = new JLabel("id variaveis medidas:");
		panel.add(lblIdVariaveisMedidas);
		
		textFieldIdVariaveisMedidas = new JTextField();
		panel.add(textFieldIdVariaveisMedidas);
		textFieldIdVariaveisMedidas.setColumns(10);
		
		JLabel lblIdMedicao = new JLabel("id medicao:");
		panel.add(lblIdMedicao);
		
		textFieldIdMedicao = new JTextField();
		panel.add(textFieldIdMedicao);
		textFieldIdMedicao.setColumns(10);
		
		JButton btnSearch = new JButton("SEARCH");
		add(btnSearch, BorderLayout.SOUTH);
		
		addJTable();
	}
	
	private void InitialSettings() {
		
	}
	
	private void addJTable() throws SQLException {
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ResultSet rs = interaction.selectMedicoes(null, null, null);
		table.setModel(DbUtils.resultSetToTableModel(rs));
		scrollPane = new JScrollPane(table);
		scrollPane.setViewportView(table);

		add(scrollPane, BorderLayout.CENTER);
	}
	
}
