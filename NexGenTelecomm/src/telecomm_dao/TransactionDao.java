package telecomm_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import telecomm_controller.CorpPlansController;
import telecomm_controller.RegPlansController;

/**
 * This class enters the details about the which customer as bought which plans
 * into transactions table
 * 
 * @author Jash
 *
 */
public class TransactionDao {

	public static String PlanName;
	public static String Amount;

	public void TransactionOps() {

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

		// creating the TelecommDAO object to get user's type
		TelecommDAO teledao1 = new TelecommDAO();
		String user_type = teledao1.getUserCheckTelecommdao();

		// for corp users
		if (user_type.equals("Yes") || user_type.equals("yes") || user_type.equals("YES")) {

			/**
			 * creating CorpPlansController object and getting the Plan name and
			 * Plan amount
			 */
			CorpPlansController corp = new CorpPlansController();
			String pln_name = corp.getPlanName();
			String pln_amount = corp.getPlanAmount();
			/******************************************************************/

			setPlanName(pln_name);
			setPlanAmount(pln_amount);

			// System.out.println("Plan Name:" + pln_name);
			// System.out.println("Plan amount" + pln_amount);
			// System.out.println("CorpPlansController object created");

			/**
			 * Creating the TelecommDAO and getting the type of user whether
			 * corporate user or regular user
			 */
			TelecommDAO teledao2 = new TelecommDAO();
			int users_id = teledao2.getUserIdTelecommdao();
			/*****************************************************************/

			// System.out.println("Users Id: " + users_id);
			// System.out.println("user type: " + user_type);
			// System.out.println("teledao objected created");

			// query to insert transaction details for corporate user
			String query = "Insert into Transaction_jk values (null,'" + users_id + "','" + pln_name + "','"
					+ pln_amount + "');";

			// System.out.println("user type=Y reached");

			try {
				PreparedStatement statement = connection.prepareStatement(query);
				statement.executeUpdate(query);
				statement.close();
				connection.close();
			}

			catch (Exception e) {
				System.out.println("Error while executing update: " + e.getMessage());
			}

		} // end 1st if

		/**
		 * For Reg users
		 */
		if (user_type.equals("No") || user_type.equals("NO") || user_type.equals("no")) {

			/**
			 * creating CorpPlansController object and getting the Plan name and
			 * Plan amount
			 */
			RegPlansController reg = new RegPlansController();
			String pln_name = reg.getPlanName();
			String pln_amount = reg.getPlanAmount();
			/******************************************************************/

			// System.out.println("Plan Name:" + pln_name);
			// System.out.println("Plan amount" + pln_amount);
			// System.out.println("RegPlansController object created");

			setPlanName(pln_name); // set the value for pln_name
			setPlanAmount(pln_amount); // set the value for pln_amount

			/**
			 * Creating the TelecommDAO and getting the type of user whether
			 * corporate user or regular user
			 */
			TelecommDAO teledao3 = new TelecommDAO();
			int users_id = teledao3.getUserIdTelecommdao();
			/*****************************************************************/

			// System.out.println("Users Id: " + users_id);
			// System.out.println("user type: " + user_type);
			// System.out.println("teledao objected created");

			// query to insert transactions details for reguser
			String query = "Insert into Transaction_jk values (null,'" + users_id + "','" + pln_name + "','"
					+ pln_amount + "');";

			try {
				PreparedStatement statement2 = connection.prepareStatement(query);
				statement2.executeUpdate(query);

			}

			catch (Exception e) {
				System.out.println("Error while executing update: " + e.getMessage());
			}

		} // end 2nd if

	}// end TransactionOps

	/**
	 * Setter getter for plan name and amount
	 * 
	 * @return
	 */
	public String getPlanName() {
		return PlanName;
	}

	public void setPlanName(String plan_name) {
		PlanName = plan_name;
	}

	public String getPlanAmount() {
		return Amount;
	}

	public void setPlanAmount(String plan_amount) {
		Amount = plan_amount;
	}

}
