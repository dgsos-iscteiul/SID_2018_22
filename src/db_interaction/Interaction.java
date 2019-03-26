package db_interaction;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import db_config.MySqlConnection;

public class Interaction {
	
	private MySqlConnection msqlc;
	private List<Row> table;
	
	public Interaction(MySqlConnection msqlc) {
		this.msqlc = msqlc;
		this.table = new ArrayList<Row>();
	}
	
//	public List<Row> selectMedicoes(int idCultura, int idVariaveisMedidas, int idMedicoes) throws SQLException {
//		CallableStatement statement = null;
//		statement = msqlc.getConnection().prepareCall("{call selectMedicoes(?,?,?)}");
//		statement.setInt(1, idCultura);
//		statement.setInt(2, idVariaveisMedidas);
//		statement.setInt(3, idMedicoes);
//		ResultSet result_set = statement.executeQuery();
//		Row.formTable(result_set, table);
//		return table;
//	}
	
	public void selectMedicoes(int idCultura, int idVariaveisMedidas, int idMedicoes) throws SQLException {
		CallableStatement statement = null;
		statement = msqlc.getConnection().prepareCall("{call selectMedicoes(?,?,?)}");
		statement.setInt(1, idCultura);
		statement.setInt(2, idVariaveisMedidas);
		statement.setInt(3, idMedicoes);
		boolean hadResults = statement.execute();
		while (hadResults) {
	        ResultSet rs = statement.getResultSet();
	        System.out.println(rs.getMetaData());
	        hadResults = statement.getMoreResults();
	    }
		
	}
	
	public List<Row> getTable() {
		return table;
	}
	
	public void printTable(List<Row> table) {

		for (Row row : table)
		{
		    for (Entry<Object, Class> col: row.row)
		    {
		        System.out.print(" > " + ((col.getValue()).cast(col.getKey())));
		    }
		    System.out.println();
		}
	}
	
	public static void main(String[] args) throws SQLException {
		MySqlConnection msqlc = new MySqlConnection();
		msqlc.init("localhost/sid");
		Interaction interaction = new Interaction(msqlc);
		interaction.selectMedicoes(12,9,1);
//		Row.printTable(interaction.getTable());
	}
}
