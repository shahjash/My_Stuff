package telecomm_controller;

import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import telecomm_fp.Call_AddPlans;

public class InvalidPlanController {

	private Stage dialogStage;
	private Stage primaryStage = new Stage();

	// after displaying the error message when OK button us hit it will route to
	// Call_AddPlans class
	public void OK() {

		dialogStage.fireEvent(new WindowEvent(dialogStage, WindowEvent.WINDOW_CLOSE_REQUEST));
		Call_AddPlans add = new Call_AddPlans();
		add.start(primaryStage);

	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

}
