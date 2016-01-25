package telecomm_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.scene.Parent;

/*
 * This class retrieves all regular plans from plans table in Database
 */
public class RegPlanDao {

	// Connection object
	private Connection connection;
	// Database connection parameters
	private String url = "jdbc:mysql://www.papademas.net:3306/dbfp";
	private String username = "fpuser";
	private String password = "510";
	Parent root;
	// arraylist to store regular plans
	public static ArrayList<String> arrlist = new ArrayList<String>();

	public void QueryCombobox() {
		// Get a connection

		try {
			connection = DriverManager.getConnection(url, username, password);
		}

		catch (SQLException e) {
			System.out.println("Error creating connection to database: " + e);
			System.exit(-1);
		}

		// selecting only regular plans from plans table
		String query = "select plan_name from plans_jk where corp_plan='N' or corp_plan='n';";

		ArrayList<String> arr = new ArrayList<>();

		setArrayList(arr);

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultset = statement.executeQuery(query);

			// storing the plan name only in the arraylist
			while (resultset.next()) {
				arr.add(resultset.getString(1));
			}

			System.out.println("ArrayList " + arr);

		}

		catch (Exception e) {
			System.out.println("Error in Querying " + e.getMessage());
		}

	}// end CorpTelecomm

	/**
	 * Setter Getter method for Regular plans
	 *
	 * @return
	 */
	public ArrayList<String> getArrayList() {
		return this.arrlist;
	}

	public void setArrayList(ArrayList<String> arr) {
		this.arrlist = arr;
	}

}
