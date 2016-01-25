package telecomm_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.Parent;
import javafx.stage.Stage;
import telecomm_fp.Call_Admin;
import telecomm_fp.Call_CorpUser;
import telecomm_fp.Call_InvalidUser;
import telecomm_fp.Call_RegUser;
import telecomm_model.Telecomm;

/**
 * This class is used for user Authentication
 *
 * @author Jash
 *
 */

public class TelecommDAO {

	private static String unameDao;
	public static String corpcheckDao;
	public static int useridDao;

	String uname;
	String corp_check;
	int users_id;

	// Connection object
	private Connection connection;
	// Database connection parameters
	private String url = "jdbc:mysql://www.papademas.net:3306/dbfp";
	private String username = "fpuser";
	private String password = "510";
	Parent root;
	private Stage priStg = new Stage();

	public Telecomm create(Telecomm telecomm) {
		// Get a connection
		try {
			connection = DriverManager.getConnection(url, username, password);
		}

		catch (SQLException e) {
			System.out.println("Error creating connection to database: " + e);
			System.exit(-1);
		}

		// query to check whether user exist or not
		String query = "select count(*) from users_jk where lower(username)='" + telecomm.getUname() + "' and "
				+ "password='" + telecomm.getUpassword() + "';";

		try {
			// PreparedStatement used to avoid sql injections
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultset = statement.executeQuery(query);
			System.out.println(statement);
			int count_rows = 0;

			/**
			 * Checking whether the user exists or not, if not a Error message
			 * will be generated
			 */
			while (resultset.next()) {
				count_rows = resultset.getInt(1);

			}

			statement.close();
			resultset.close();

			/**
			 * if no row returned user does not exist, and it will route call a
			 * class Call_InvalidUser which eventually calls a view to display
			 * the error message
			 */
			if (count_rows == 0) {
				System.out.println("No user Exist");
				Call_InvalidUser invaliduser = new Call_InvalidUser();
				invaliduser.start(priStg);
			}

			/**
			 * The below chunk of code will check, If user exist he will be
			 * routed to different home-screens (views) depending upon their
			 * login
			 */
			else {
				System.out.println("User Exist");

				String type_user = "select username, corp_emp,user_id from users_jk where lower(username)='"
						+ telecomm.getUname() + "' and " + "password='" + telecomm.getUpassword() + "';";

				try {
					PreparedStatement stmt = connection.prepareStatement(type_user);
					ResultSet rs = stmt.executeQuery(type_user);
					rs.next();
					uname = rs.getString("username");
					corp_check = rs.getString("corp_emp");
					users_id = rs.getInt("user_id"); // added to get user's id

					System.out.println(uname);
					System.out.println(corp_check);

					/**
					 * set values for uname and corp_check
					 */
					setUserTelecommdao(uname);
					setUserCheckTelecommdao(corp_check);
					setUserIdTelecommdao(users_id);
					/******************************************************/

					if (uname.equals("admin") & corp_check.equals("adm")) {
						Call_Admin admin = new Call_Admin();
						admin.start(priStg);
					}

					if (corp_check.equals("Yes") || corp_check.equals("yes") || corp_check.equals("YES")) {
						Call_CorpUser corpuser = new Call_CorpUser();
						corpuser.start(priStg);
					}

					if (corp_check.equals("No") || corp_check.equals("no") || corp_check.equals("NO")) {
//						String temp = this.getUserTelecommdao();
						Call_RegUser reguser = new Call_RegUser();
						reguser.start(priStg);
					}

				}

				catch (Exception e) {
					System.out.println("Error in query user check" + e.getMessage());
				}
				/***************************************************************************************/

			}

		} // end main try

		catch (Exception e) {
			telecomm = null;
			System.out.println("Error Creating Bank: " + e);
		}

		try {
			connection.close();
			connection = null;
		}

		catch (Exception e) {
			System.out.println("Error in closing connection " + e.getMessage());
		}
		return telecomm;

	}

	/**
	 * Setter Getter for username
	 *
	 * @return unameDao
	 */
	public String getUserTelecommdao() {
		return this.unameDao;
	}

	public void setUserTelecommdao(String uname) {
		unameDao = this.uname;
	}
	/*************************************************************/

	/**
	 * Setter Getter for checking type of user
	 *
	 * @return corpcheckDao
	 */
	public String getUserCheckTelecommdao() {
		return TelecommDAO.corpcheckDao;
	}

	public void setUserCheckTelecommdao(String corp_check) {
		corpcheckDao = this.corp_check;
	}
	/********************************************************************/

	/**
	 * Setter Getter for user_id
	 *
	 * @return
	 */
	public int getUserIdTelecommdao() {
		return TelecommDAO.useridDao;
	}

	public void setUserIdTelecommdao(int users_id) {
		useridDao = this.users_id;
	}
	/*******************************************************************/

} // TelecommDAO
