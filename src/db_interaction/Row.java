package db_interaction;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

// TODO: Auto-generated Javadoc
/**
 * The Class Row.
*  * @author jasbs1-iscteiul
*  * @version 1.0
 
 */
public class Row {

	/** The row. */
	public List<Entry<Object, Class>> row;
    
    /** The type. */
    public static Map<String, Class> TYPE;

    static {
        TYPE = new HashMap<String, Class>();

        TYPE.put("INTEGER", Integer.class);
        TYPE.put("TINYINT", Byte.class);
        TYPE.put("SMALLINT", Short.class);
        TYPE.put("BIGINT", Long.class);
        TYPE.put("REAL", Float.class);
        TYPE.put("FLOAT", Double.class);
        TYPE.put("DOUBLE", Double.class);
        TYPE.put("DECIMAL", BigDecimal.class);
        TYPE.put("NUMERIC", BigDecimal.class);
        TYPE.put("BOOLEAN", Boolean.class);
        TYPE.put("CHAR", String.class);
        TYPE.put("VARCHAR", String.class);
        TYPE.put("LONGVARCHAR", String.class);
        TYPE.put("DATE", Date.class);
        TYPE.put("TIME", Time.class);
        TYPE.put("TIMESTAMP", Timestamp.class);
        TYPE.put("SERIAL",Integer.class);
    }

    /**
     * Instantiates a new row.
     */
    public Row() {
        row = new ArrayList<Entry<Object, Class>>();
    }

    /**
     * Adds the.
     *
     * @param <T> the generic type
     * @param data the data
     */
    public <T> void add(T data) {
        row.add(new AbstractMap.SimpleImmutableEntry<Object,Class>(data, data.getClass()));
    }

    /**
     * Adds the.
     *
     * @param data the data
     * @param sqlType the sql type
     */
    public void add(Object data, String sqlType) {
        Class castType = Row.TYPE.get(sqlType.toUpperCase());
        try {
            this.add(castType.cast(data));
        } catch (NullPointerException e) {
            e.printStackTrace();
            Logger lgr = Logger.getLogger(Row.class.getName());
            lgr.log(Level.SEVERE, e.getMessage()+" Add the type "+sqlType+" to the TYPE hash map in the Row class.", e);
            throw e;
        }
    }

    /**
     * Form table.
     *
     * @param rs the rs
     * @param table the table
     * @throws SQLException the SQL exception
     */
    public static void formTable(ResultSet rs, List<Row> table)
            throws SQLException {
        if (rs == null)
            return;

        ResultSetMetaData rsmd = rsmd(rs);
		try {
            int NumOfCol = rsmd.getColumnCount();

            while (rs.next()) {
                Row current_row = new Row();

                for (int i = 1; i <= NumOfCol; i++) {
                    current_row.add(rs.getObject(i), rsmd.getColumnTypeName(i));
                }

                table.add(current_row);
            }
        } catch (SQLException e) {
            throw e;
        }
    }

	/**
	 * Rsmd.
	 *
	 * @param rs the rs
	 * @return the result set meta data
	 * @throws SQLException the SQL exception
	 */
	private static ResultSetMetaData rsmd(ResultSet rs) throws SQLException {
		ResultSetMetaData rsmd;
		rsmd = rs.getMetaData();
		return rsmd;
	}
    
    /**
     * Prints the table.
     *
     * @param table the table
     */
    public static void printTable(List<Row> table) {

		for (Row row : table)
		{
		    for (Entry<Object, Class> col: row.row)
		    {
		        System.out.print(" > " + ((col.getValue()).cast(col.getKey())));
		    }
		    System.out.println();
		}
	}
	
}
