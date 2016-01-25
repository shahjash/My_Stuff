package telecomm_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.scene.Parent;

/**
 * This class retrieves all corporate plans from plans table in Database
 *
 * @author Jash
 *
 */
public class CorpPlanDao {

	// Connection object
	private Connection connection;
	// Database connection parameters
	private String url = "jdbc:mysql://www.papademas.net:3306/dbfp";
	private String username = "fpuser";
	private String password = "510";
	Parent root;
	// array list to store corporate plan names
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

		// Selecting only corporate plans from the plans table
		String query = "select plan_name from plans_jk where corp_plan='Y';";

		ArrayList<String> arr = new ArrayList<>();

		setArrayList(arr); // set the values of the plans

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultset = statement.executeQuery(query);

			while (resultset.next()) {
				arr.add(resultset.getString(1));
			}

			// System.out.println("ArrayList " + arr);

		}

		catch (Exception e) {
			System.out.println("Error in Querying " + e.getMessage());
		}

	}// end CorpTelecomm

	/**
	 * Setter getter methods for corporate plans
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
