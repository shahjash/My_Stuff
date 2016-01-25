package telecomm_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.Parent;
import javafx.stage.Stage;
import telecomm_model.RegistrationModel;
import telecomm_model.Telecomm;

public class RegistrationDAO {

	//Connection object
	private Connection connection;
	//Database connection parameters
    private String url = "jdbc:mysql://www.papademas.net:3306/dbfp";
    private String username = "fpuser";
    private String password = "510";
    Parent root;
    private Stage priStg = new Stage();

	public RegistrationModel create(RegistrationModel register) {
		//Get a connection
		try {
            connection = DriverManager.getConnection(url, username, password);
        } catch(SQLException e) {
            System.out.println("Error creating connection to database: " + e);
            System.exit(-1);
        }

		String query="Insert into users_jk values(null,?,?,?,?,?,?);" ;

		try{
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1,register.getFname());
			statement.setString(2,register.getLname());
			statement.setString(3,register.getSsn());
			statement.setString(4,register.getUname());
			statement.setString(5,register.getUpassword());
			statement.setString(6,register.getCorpFlag());
			statement.executeUpdate();
			//System.out.println(result);
		}
		catch(Exception e){
			System.out.println("Error at RegistartionDAO: "+ e.getMessage() );
		}

		try{
			connection.close();
			connection=null;
		}

		catch(Exception e ){
			System.out.println("Error in Closing conncetion: " + e.getMessage());
		}

		return register;
	}

}
