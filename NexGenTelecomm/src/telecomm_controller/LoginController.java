package telecomm_controller;

import telecomm_dao.TelecommDAO;
import telecomm_fp.Call_Registration;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import telecomm_model.Telecomm;

public class LoginController {

	// This is the parent stage
	private Stage dialogStage;
	private Stage priStg = new Stage();

	// This is the Text box field element in the view of Login page
	@FXML
	private TextField Uname;

	// This is the Text box field element in the view of Login page
	@FXML
	private TextField Upassword;

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;

	}

	public void login() {
		String username = this.Uname.getText(); // getting username from the
												// form
		String password = this.Upassword.getText(); // getting password from the
													// form

		// if TextField is null and Error Alert will be generated
		if ((username == null || username.trim().equals("")) || (password == null || password.trim().equals(""))) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("ERROR");
			alert.setHeaderText("Null not Allowed");
			alert.setContentText("Neither Username or Password cannot be Null!!!");
			alert.showAndWait();
			return;
		}

		// System.out.println(username);
		// System.out.println(password);

		Telecomm telecomm = new Telecomm();
		// Set the values from the input form
		telecomm.setUname(username);
		telecomm.setUpassword(password);
		// Create a DAO instance of the model
		TelecommDAO b = new TelecommDAO();
		// Use the DAO to persist the model to database
		b.create(telecomm);
		// Close the stage after entering credentials
		close();

	}

	public void cancel() {
		close();
	}

	private void close() {
		dialogStage.fireEvent(new WindowEvent(dialogStage, WindowEvent.WINDOW_CLOSE_REQUEST));
	}

	public void create() {
		close();
		// Calling Call_Registration View
		Call_Registration registration = new Call_Registration();
		registration.start(priStg);

	}

}
