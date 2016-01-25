package telecomm_controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import telecomm_dao.InfoUpdateDao;
import telecomm_fp.Call_Admin;
import telecomm_fp.Call_CorpUser;
import telecomm_fp.Call_RegUser;
import telecomm_model.InfoUpdate_model;
import telecomm_model.User;

public class InfoUpdateController {

	public Stage primaryStage = new Stage();
	public Stage dialogStage;

	// this is Text Field in the form to accept new password
	@FXML
	private TextField NewPassword;

	// method to save new password
	public void SetPassword() {

		String password = NewPassword.getText(); // getting new password from
													// the form
		String username = User.username;
		String user_type = User.user_check;
		System.out.println(username);

		if (password == null || password.trim().equals("")) {
			System.out.println("trying to enter null");
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("ERROR Dialog");
			alert.setHeaderText(null);
			alert.setContentText("Null not Allowed!!!");
			alert.showAndWait();
			return;
		}

		else {
			InfoUpdate_model info_update = new InfoUpdate_model();
			info_update.setPassword(password); // set password
			info_update.setUserName(username); // set username
			InfoUpdateDao dao = new InfoUpdateDao();
			// Use the DAO to persist the model to database
			dao.create(info_update);
			/**
			 * Creating an alert to after updating password
			 */
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information Dialog");
			alert.setHeaderText(null);
			alert.setContentText("Password Updated Successfully");
			alert.showAndWait();
			/*********************************************************************/
			close(); // closing the current window

			/*
			 * Depending upon the user he willbe routed to his home-screen
			 */
			if (user_type.equals("adm")) {
				Call_Admin admin = new Call_Admin();
				admin.start(primaryStage);
			}

			if (user_type.equals("Yes") || user_type.equals("YES") || user_type.equals("yes")) {
				Call_CorpUser corp = new Call_CorpUser();
				corp.start(primaryStage);
			}

			if (user_type.equals("No") || user_type.equals("NO") || user_type.equals("no")) {
				Call_RegUser corp = new Call_RegUser();
				corp.start(primaryStage);
			}
			/*******************************************************************************/

		}
	}

	public void close() {
		dialogStage.fireEvent(new WindowEvent(dialogStage, WindowEvent.WINDOW_CLOSE_REQUEST));
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;

	}

}
