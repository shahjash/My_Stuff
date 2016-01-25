package telecomm_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import telecomm_model.AddPlan_model;

/**
 * This class is used to for adding new plans
 *
 * @author Jash
 *
 */

public class AddPlanDao {

	// Connection object
	private Connection connection;
	// Database connection parameters
	private String url = "jdbc:mysql://www.papademas.net:3306/dbfp";
	private String username = "fpuser";
	private String password = "510";

	public AddPlan_model create(AddPlan_model addplan) {
		// Get a connection
		try {
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			System.out.println("Error creating connection to database: " + e);
			System.exit(-1);
		}

		// query to insert new plans to the plans table
		String query = "Insert into plans_jk values(null,?,?);";

		try {
			PreparedStatement statement1 = connection.prepareStatement(query);
			// provides the query with plan name
			statement1.setString(1, addplan.getPlanName());
			// provide the query with plan type
			statement1.setString(2, addplan.getPlanType());
			statement1.executeUpdate();

		}

		catch (Exception e) {
			System.out.println("Error while inserting into plans_jk" + e.getMessage());
		}

		try {
			connection.close();
			connection = null;

		}

		catch (Exception e) {
			System.out.println("Error in closing connection");
		}

		return addplan;
	}

}