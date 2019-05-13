package gui.investigador;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import db_config.MySqlConnection;
import db_interaction.Interaction;
import gui.geral.LoginFrame;
import net.proteanit.sql.DbUtils;

// TODO: Auto-generated Javadoc
/**
 * The Class SelectMedicoesFrame.
 * 
  *  * @author jasbs1-iscteiul
 *  * @version 1.0
 */
public class SelectMedicoesFrame extends JFrame{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The msqlc. */
	private MySqlConnection msqlc = new MySqlConnection();
	
	/** The interaction. */
	private Interaction interaction = new Interaction(msqlc);
	
	/** The panel. */
	private JPanel panel;
	
	/** The id cultura. */
	private JTextField idCultura;
	
	/** The id variaveis medidas. */
	private JTextField idVariaveisMedidas;
	
	/** The id medicoes. */
	private JTextField idMedicoes;
	
	/** The table. */
	private JTable table;
	
	/** The btn search. */
	private JButton btnSearch = new JButton("SEARCH");
	
	/** The scroll pane. */
	private JScrollPane scrollPane ;
	
	/**
	 * Instantiates a new select medicoes frame.
	 *
	 * @param name the name
	 * @param pass the pass
	 * @throws SQLException the SQL exception
	 */
	public SelectMedicoesFrame(String name, String pass) {
		setTitle("SELECT MEDICOES");
		msqlc.init("localhost/" + LoginFrame.DATABASE, name, pass);
		try {
			constructFrame();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		addActionListeners();
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		this.setVisible(true);
	}
	
	/**
	 * Construct frame.
	 *
	 * @throws SQLException the SQL exception
	 */
	private void constructFrame() throws SQLException {
		setSize(new Dimension(1500, 600));
//		setExtendedState(JFrame.MAXIMIZED_BOTH); 
//		setUndecorated(true);
		panel = new JPanel();
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
		
		idCultura = new JTextField();
		panel.add(idCultura, "4, 2, left, default");
		idCultura.setColumns(10);
		
		JLabel lblIdvariaveismedidas = new JLabel("idVariaveisMedidas:");
		lblIdvariaveismedidas.setFont(new Font("Segoe UI", Font.BOLD, 18));
		panel.add(lblIdvariaveismedidas, "2, 4, right, default");
		
		idVariaveisMedidas = new JTextField();
		panel.add(idVariaveisMedidas, "4, 4, left, default");
		idVariaveisMedidas.setColumns(10);
		
		JLabel lblIdmedicoes = new JLabel("idMedicoes:");
		lblIdmedicoes.setFont(new Font("Segoe UI", Font.BOLD, 18));
		panel.add(lblIdmedicoes, "2, 6, right, default");
		
		idMedicoes = new JTextField();
		panel.add(idMedicoes, "4, 6, left, default");
		idMedicoes.setColumns(10);
		
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(btnSearch, "4, 8, left, default");
		
		JLabel lblResults = new JLabel("RESULTS");
		lblResults.setFont(new Font("Segoe UI Emoji", Font.BOLD, 22));
		panel.add(lblResults, "2, 10, center, default");
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ResultSet rs = interaction.selectMedicoes(null, null, null);
		table.setModel(DbUtils.resultSetToTableModel(rs));
		scrollPane = new JScrollPane(table);
		scrollPane.setViewportView(table);

		panel.add(scrollPane, "4, 10, fill, fill");
	}
	
	/**
	 * Adds the action listeners.
	 */
	private void addActionListeners() {
		ActionListener searchListener = (new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(idCultura.getText() == "")
					idCultura.setText("0");
				if(idVariaveisMedidas.getText() == "")
					idVariaveisMedidas.setText("0");
				if(idMedicoes.getText() == "")
					idMedicoes.setText("0");
				try {
					ResultSet rs = interaction.selectMedicoes(idCultura.getText(),
							idVariaveisMedidas.getText(), idMedicoes.getText());
					table.setModel(DbUtils.resultSetToTableModel(rs));
					repaint();
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnSearch.addActionListener(searchListener);
		idCultura.addActionListener(searchListener);
		idMedicoes.addActionListener(searchListener);
		idVariaveisMedidas.addActionListener(searchListener);
	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws SQLException the SQL exception
	 */
	public static void main(String[] args) throws SQLException {
		SelectMedicoesFrame spf= new SelectMedicoesFrame("root", "");
	}

}
