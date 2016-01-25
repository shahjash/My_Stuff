package telecomm_controller;

import java.util.regex.Pattern;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import telecomm_dao.AddPlanDao;
import telecomm_fp.Call_Admin;
import telecomm_fp.Call_InvalidPlanEntry;
import telecomm_model.AddPlan_model;

public class AddPlanController {

	private Stage dialogStage;
	private Stage primaryStage = new Stage();

	// This is the Text box element in the view for plan name
	@FXML
	private TextField PlanName;

	// This is the Text box element in the view for plan type (corporate or
	// regular)
	@FXML
	private TextField PlanType;

	// Method used to add plans
	public void AddPlan() {

		String plan_name = PlanName.getText(); // store the plan name entered in
												// the form into variable
												// plan_name
		String plan_type = PlanType.getText();// store the plan type entered in
												// the form into variable
												// plan_type
		// Defining a pattern for validating the plan name
		String regex = "^(?:[0-9a-zA-Z])+[\\s]+[0-9a-zA-Z]+[-]+[\\s]+[$]+[0-9]+";

		/**
		 * Used for Validating the plan name entered by the user with the above
		 * given format
		 */
		boolean answer = Pattern.matches(regex, plan_name);
		/*************************************************************************/

		// System.out.println("Compairsion" + answer);

		/**
		 * The below series of IF statement makes sure that the data is entered
		 * is null not null, if null it will throw an error message(ALERT) and
		 * route back to the same page, until admin enters the values correctly
		 */
		if (plan_name == null || plan_name.trim().equals("") || plan_type == null || plan_type.trim().equals("")) {
			System.out.println("I am a null in if");
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("ERROR!!!");
			alert.setHeaderText(null);
			alert.setContentText("Plan Name or Plan Type cannot be Null");
			alert.showAndWait();
			return;
		}
		/********************************************************************************/

		/**
		 * If the plan_name entered is not in the format specified on the form
		 * or if plan_type is other than Y/y or N/n then it will throw an error
		 * message and route to the same page
		 */
		if ((plan_type.equals("Y") || plan_type.equals("N") || plan_type.equals("y") || plan_type.equals("n"))
				& (answer == true)) {
			AddPlan_model addplan = new AddPlan_model();
			addplan.setPlanName(plan_name);
			addplan.setPlanType(plan_type);
			AddPlanDao dao = new AddPlanDao();
			dao.create(addplan);
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information Dialog");
			alert.setHeaderText(null);
			alert.setContentText("Plan " + plan_name + " Added Successfully!");
			alert.showAndWait();
			close();
			Call_Admin admin = new Call_Admin();
			admin.start(primaryStage);
		}

		else {
			PlanName.setText("");
			PlanType.setText("");
			close();
			Call_InvalidPlanEntry call = new Call_InvalidPlanEntry();
			call.start(primaryStage);
			return;
		}
		/*********************************************************************************/

		close();

	}

	// Method to set the parent stage of the current view
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;

	}

	// Used to close a current the current window event
	public void close() {
		dialogStage.fireEvent(new WindowEvent(dialogStage, WindowEvent.WINDOW_CLOSE_REQUEST));
	}

}
