package telecomm_controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import telecomm_dao.DeletePlanDao;
import telecomm_fp.Call_Admin;
import telecomm_model.DeletePlan_model;

public class PlanDeleteController {

	public Stage primaryStage = new Stage();
	public Stage dialogStage;

	// Text field element in the form
	@FXML
	private TextField PlanID;

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;

	}

	public void DeletePlan() {

		String plan_id = PlanID.getText();

		if (plan_id == null || plan_id == "") {
			return;
		}

		/**
		 * validating the plan name entred against the above mentioned pattern
		 * and generating alert if there is no match it will generate Error
		 * Alert
		 */
		else if (plan_id.matches("^[0-9]+")) {
			int plan_number = Integer.parseInt(plan_id);
			DeletePlan_model delete_plan = new DeletePlan_model();
			System.out.println("calling deelete PlanID");
			delete_plan.setPlanID(plan_number);
			DeletePlanDao plan_dao = new DeletePlanDao();
			plan_dao.create(delete_plan);
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information Dialog");
			alert.setHeaderText(null);
			alert.setContentText("Plan Deleted!");
			alert.showAndWait();
			close();
			Call_Admin admin = new Call_Admin();
			admin.start(primaryStage);
		}

		else {
			System.out.println("no match");
			PlanID.setText(null);
			Alert alert1 = new Alert(AlertType.ERROR);
			alert1.setTitle("Error Dialog");
			alert1.setHeaderText(null);
			alert1.setContentText("Cannot accept Null/Non-numeric/Negative/Decimal values!");
			alert1.showAndWait();
		}
		/****************************************************************************************/
	}

	public void close() {
		dialogStage.fireEvent(new WindowEvent(dialogStage, WindowEvent.WINDOW_CLOSE_REQUEST));
	}

}
