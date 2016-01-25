package telecomm_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.scene.Parent;
import javafx.stage.Stage;
import telecomm_model.InfoUpdate_model;

/**
 * Class used for updating user's password
 *
 * @author Jash
 *
 */
public class InfoUpdateDao {

	public Stage primaryStage = new Stage();
	public Stage dialogStage;

	private Connection connection;
	// Database connection parameters
	private String url = "jdbc:mysql://www.papademas.net:3306/dbfp";
	private String username = "fpuser";
	private String password = "510";
	Parent root;

	public InfoUpdate_model create(InfoUpdate_model info_update) {

		// Get a connection
		try {
			connection = DriverManager.getConnection(url, username, password);
		}

		catch (SQLException e) {
			System.out.println("Error creating connection to database: " + e);
			System.exit(-1);
		}

		// query to update password
		String query = "update users_jk set password=? where username=? ;";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			// it gives the query the new password that need to be updated
			statement.setString(1, info_update.getPassword());
			// it gives the query usename where the password needs to be updated
			statement.setString(2, info_update.getUserName());
			statement.executeUpdate();
		}

		catch (Exception e) {
			System.out.println("Error in updating password" + e.getMessage());
		}

		return info_update;
	}

}
