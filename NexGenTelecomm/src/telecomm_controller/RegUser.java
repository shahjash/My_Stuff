package telecomm_controller;

import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import telecomm_fp.Call_CorpPlans;
import telecomm_fp.Call_RegPlans;
import telecomm_fp.Main;
import telecomm_model.User;

public class RegUser extends User {

	private Stage dialogStage;
	private Stage primaryStage = new Stage();

	// Method to updte password
	public void UpdateInfo() {
		dialogStage.fireEvent(new WindowEvent(dialogStage, WindowEvent.WINDOW_CLOSE_REQUEST));
		System.out.println("reg user reached");
		User reguser = new User();
		reguser.UpdateInfo();
		System.out.println("reg object created");
	}

	// Method to view plans
	public void ViewPlans() {
		dialogStage.fireEvent(new WindowEvent(dialogStage, WindowEvent.WINDOW_CLOSE_REQUEST));
		Call_RegPlans regplans = new Call_RegPlans();
		regplans.start(primaryStage);
	}

	// Will log-out from current window and route to login screen
	public void LogOut() {
		dialogStage.fireEvent(new WindowEvent(dialogStage, WindowEvent.WINDOW_CLOSE_REQUEST));
		Main main = new Main();
		main.start(primaryStage);
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

}
