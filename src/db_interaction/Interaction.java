package db_interaction;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	 * @return returns a resultset of all entries on the table
	 * @throws SQLException
	 */
	
	public ResultSet selectMedicoes(String idCultura, String idVariaveisMedidas, String idMedicoes) throws SQLException {
//		String[][] output = new String[10][10];
		CallableStatement statement = null;
		statement = msqlc.getConnection().prepareCall("{call selectMedicoes(?,?,?)}");
		statement.setString(1, idCultura);
		statement.setString(2, idVariaveisMedidas);
		statement.setString(3, idMedicoes);
		ResultSet result_set = statement.executeQuery();
		System.out.println(result_set.toString());
		return result_set;
	}

	public void printResultSet(ResultSet result_set) throws SQLException {
		while(result_set.next()) {
			int idmedicoes = result_set.getInt("id");
			String data = result_set.getString("data");
			int valor = result_set.getInt("valor");
			int idvariaveismedidas = result_set.getInt("idVariaveisMedidas");
			int id = result_set.getInt("id");
			String nomeVariaveis = result_set.getString("nomeVariaveis");
			int idCulturaAux = result_set.getInt("idCultura");
			int limiteInferior = result_set.getInt("limiteInferior");
			int limiteSuperior = result_set.getInt("limiteSuperior");
			String row = String.format("%d, %s, %d, %d, %d, %s, %d, %d, %d", idmedicoes, data, valor, idvariaveismedidas, id, 
					nomeVariaveis, idCulturaAux, limiteInferior, limiteSuperior);
			System.out.printf("%d, %s, %d, %d, %d, %s, %d, %d, %d\n", idmedicoes, data, valor, idvariaveismedidas, id, 
					nomeVariaveis, idCulturaAux, limiteInferior, limiteSuperior);
		}
	}
	
	public static void main(String[] args) throws SQLException {
		MySqlConnection msqlc = new MySqlConnection();
		msqlc.init("localhost/sid", "root", "");
		Interaction interaction = new Interaction(msqlc);
		interaction.printResultSet(interaction.selectMedicoes("0", "0", "0"));
	}
}
