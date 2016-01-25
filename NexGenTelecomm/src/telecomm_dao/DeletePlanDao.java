package telecomm_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.scene.Parent;
import javafx.stage.Stage;
import telecomm_model.DeletePlan_model;

/**
 * This class will be used to delete plans from plans table in database
 *
 * @author Jash
 *
 */
public class DeletePlanDao {

	public Stage primaryStage = new Stage();
	public Stage dialogStage;

	private Connection connection;
	// Database connection parameters
	private String url = "jdbc:mysql://www.papademas.net:3306/dbfp";
	private String username = "fpuser";
	private String password = "510";
	Parent root;

	public DeletePlan_model create(DeletePlan_model delete_plan) {
		// Get a connection
		try {
			connection = DriverManager.getConnection(url, username, password);
		}

		catch (SQLException e) {
			System.out.println("Error creating connection to database: " + e);
			System.exit(-1);
		}

		// Query to delete plan from plans table
		String query = "Delete from plans_jk where plan_id=?";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			// this statement will basically replace the question mark in the
			// above querry with a plan_id
			statement.setInt(1, delete_plan.getPlanID());
			statement.executeUpdate();
			// int temp=delete_plan.getPlanID();
			// System.out.println("Plan_id to be deleted"+temp);
		}

		catch (Exception e) {
			System.out.println("Error in deleteing" + e.getMessage());
		}

		return delete_plan;
	}

}
