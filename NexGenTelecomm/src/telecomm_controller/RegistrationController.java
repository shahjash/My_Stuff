package telecomm_controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import telecomm_dao.RegistrationDAO;
import telecomm_fp.Call_Registration;
import telecomm_fp.Main;
import telecomm_model.RegistrationModel;

public class RegistrationController {

	private Stage priStg = new Stage();
	private Stage dialogStage;

	private String corp_flag;

	// This is the Text box field element in the view of Registration page
	@FXML
	private TextField Fname;

	// This is the Text box field element in the view of Registration page
	@FXML
	private TextField Lname;

	// This is the Text box field element in the view of Registration page
	@FXML
	private TextField SSN;

	// This is the Text box field element in the view of Registration page
	@FXML
	private TextField Uname;

	// This is the Text box field element in the view of Registration page
	@FXML
	private TextField Upassword;

	@FXML
	private TextField CorpEmp;

	public void Ok() {

		// getting the user details from the form
		String fname = this.Fname.getText();
		String lname = this.Lname.getText();
		String ssn = this.SSN.getText();
		String username = this.Uname.getText();
		String password = this.Upassword.getText();
		String corpemp = this.CorpEmp.getText();

		// if null values entered an Error Alert will be generated
		if (fname == null || fname.trim().equals("") || lname == null || lname.trim().equals("") || password == null
				|| password.trim().equals("") || username == null || password.trim().equals("") || corpemp == null
				|| password.trim().equals("")) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("ERROR");
			alert.setHeaderText("Null not Allowed");
			alert.setContentText("Fields cannot be Null!!!");
			alert.showAndWait();
			return;
		}

		// creating object for Registration model
		RegistrationModel register = new RegistrationModel();
		/* Set the values from the user form */
		register.setFname(fname);
		register.setLname(lname);
		register.setSsn(ssn);
		register.setUname(username);
		register.setUpassword(password);
		register.setCorpFlag(corpemp);
		/*********************************************************/

		/**
		 * Enters the details into db and generates Alert for successfull
		 * insertion
		 */
		RegistrationDAO regdao = new RegistrationDAO();
		regdao.create(register);
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("New User");
		alert.setHeaderText("Details");
		alert.setContentText("Desired UserName is: " + username + "\nDesired Password is: " + password);
		alert.showAndWait();

		// closing the registration page when done with the Registration
		close();
		Main main = new Main();
		main.start(priStg);
	}

	public void Cancel() {
		close();
	}

	public void close() {
		dialogStage.fireEvent(new WindowEvent(dialogStage, WindowEvent.WINDOW_CLOSE_REQUEST));
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

}
