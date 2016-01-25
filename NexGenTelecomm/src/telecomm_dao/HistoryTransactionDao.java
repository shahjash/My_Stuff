package telecomm_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class provide the values for displaying the transactions that took place
 *
 * @author Jash
 *
 */

public class HistoryTransactionDao {

	public static ResultSet rs = null;
	public static ResultSet resultSet = null;

	public void transaction() {

		// Connection object
		Connection connection = null;
		// Database connection parameters
		String url = "jdbc:mysql://www.papademas.net:3306/dbfp";
		String username = "fpuser";
		String password = "510";

		// Get a connection
		try {
			connection = DriverManager.getConnection(url, username, password);
		}

		catch (SQLException e) {
			System.out.println("Error creating connection to database: " + e);
			System.exit(-1);
		}

		// selects the entre transactions table for displaying via view
		String query = "Select * from transaction_jk;";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			rs = statement.executeQuery(query);
			setResultSet(rs);

		}

		catch (Exception e) {
			System.out.println("Error while retriving data");
		}

	}

	/**
	 * Setter Getter for resultset as it will be used by
	 * UserTransactionController class to display it on a view
	 * 
	 * @param rs
	 */
	public void setResultSet(ResultSet rs) {

		this.resultSet = rs;

	} // end transaction

	public ResultSet getResultSet() {
		return this.resultSet;
	}

}
