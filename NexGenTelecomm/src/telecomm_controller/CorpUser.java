package telecomm_controller;

import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import telecomm_dao.TelecommDAO;
import telecomm_fp.Call_CorpPlans;
import telecomm_fp.Main;
import telecomm_model.User;

public class CorpUser extends User {

	private Stage dialogStage;
	private Stage primaryStage = new Stage();

	// method to update password
	public void UpdateInfo() {
		System.out.println("corp user reached");
		User corpuser = new User();
		corpuser.UpdateInfo();
		System.out.println("user object created");
	}

	// method to view corp plans
	public void ViewPlans() {
		dialogStage.fireEvent(new WindowEvent(dialogStage, WindowEvent.WINDOW_CLOSE_REQUEST));
		Call_CorpPlans corpplans = new Call_CorpPlans();
		corpplans.start(primaryStage);

	}

	// method to log-out from the application
	public void LogOut() {
		dialogStage.fireEvent(new WindowEvent(dialogStage, WindowEvent.WINDOW_CLOSE_REQUEST));
		Main main = new Main();
		main.start(primaryStage);
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

}
