package db_interaction;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db_config.MySqlConnection;

/**
 * Date: March 26-2019
 * This is a class that contains all the interactions possible with the database
 * @author ajcvo-iscteiul
 * @version 0.5
 *
 */
public class Interaction {
	
	/**
	 * This is the pointer to the database that will be interacted.
	 */
	private MySqlConnection msqlc;
	
	/**
	 * @param msqlc MySqlConnection object
	 */
	public Interaction(MySqlConnection msqlc) {
		this.msqlc = msqlc;
	}
	
	/**
	 * This is a method that is linked to the database's stored procedure selectMedicoes.
	 * @param idCultura id that cultura's table has
	 * @param idVariaveisMedidas id that variaveismedidas's table has
	 * @param idMedicoes id that medicoes's table has
	 * @return returns a list of strings that contais all the outputs
	 * @throws SQLException
	 */
	public List<String> selectMedicoes(String idCultura, String idVariaveisMedidas, String idMedicoes) throws SQLException {
		List<String> output = new ArrayList<String>();
		CallableStatement statement = null;
		statement = msqlc.getConnection().prepareCall("{call selectMedicoes(?,?,?)}");
		statement.setString(1, idCultura);
		statement.setString(2, idVariaveisMedidas);
		statement.setString(3, idMedicoes);
		ResultSet result_set = statement.executeQuery();
		while(result_set.next()) {
			int idmedicoes = result_set.getInt("id");
			String data = result_set.getString("data");
			int valor = result_set.getInt("valor");
			int idvariaveismedidas = result_set.getInt("idVariaveisMedidas");
			String row = String.format("%d, %s, %d, %d", idmedicoes, data, valor, idvariaveismedidas);
			output.add(row);
//			System.out.printf("%d, %s, %d, %d\n", idmedicoes, data, valor, idvariaveismedidas);
		}
		return output;
	}
	
	public static void main(String[] args) throws SQLException {
		MySqlConnection msqlc = new MySqlConnection();
		msqlc.init("localhost/sid");
		Interaction interaction = new Interaction(msqlc);
		List<String> output = interaction.selectMedicoes(null,null,"1");
		System.out.println(output);
	}
}
