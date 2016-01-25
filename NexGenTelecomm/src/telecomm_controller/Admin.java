package telecomm_controller;

import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import telecomm_fp.Call_AddPlans;
import telecomm_fp.Call_DeletePlan;
import telecomm_fp.Call_TransactionHistory;
import telecomm_fp.Main;
import telecomm_model.User;

public class Admin extends User {

	private Stage dialogStage;
	private Stage primaryStage = new Stage();

	// method to add plan
	public void AddPlan() {
		Call_AddPlans add = new Call_AddPlans();
		add.start(primaryStage);
		dialogStage.fireEvent(new WindowEvent(dialogStage, WindowEvent.WINDOW_CLOSE_REQUEST));
	}

	// method to delete plan
	public void DeletePlan() {
		Call_DeletePlan plan = new Call_DeletePlan();
		plan.start(primaryStage);
		dialogStage.fireEvent(new WindowEvent(dialogStage, WindowEvent.WINDOW_CLOSE_REQUEST));
	}

	// method to update password
	public void UpdateInfo() {
		System.out.println("corp user reached");

		/**
		 * creating object of parent class and calling parent class method to
		 * update password
		 */
		User admin = new User();
		admin.UpdateInfo();
		System.out.println("user object created");
		dialogStage.fireEvent(new WindowEvent(dialogStage, WindowEvent.WINDOW_CLOSE_REQUEST));
	}

	// method to view all transaction detail
	public void ViewTransactions() {
		Call_TransactionHistory tras_history = new Call_TransactionHistory();
		tras_history.start(primaryStage);
		dialogStage.fireEvent(new WindowEvent(dialogStage, WindowEvent.WINDOW_CLOSE_REQUEST));

	}

	// will route to login screen
	public void Logout() {
		dialogStage.fireEvent(new WindowEvent(dialogStage, WindowEvent.WINDOW_CLOSE_REQUEST));
		Main mn = new Main();
		mn.start(primaryStage);
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

}
