package telecomm_controller;

import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import telecomm_fp.Main;

public class InvalidUserController {

	private Stage priStg = new Stage();
	private Stage dialogStage;

	// Method to set the parent stage of the current view
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	// after displaying the error message when OK button us hit it will route to
	// main
	public void ok() {
		// closing current scene(aka window)
		dialogStage.fireEvent(new WindowEvent(dialogStage, WindowEvent.WINDOW_CLOSE_REQUEST));

		/**
		 * If incorrect credentials are entered then it will route to Login page
		 */
		Main mn = new Main();
		mn.start(priStg);
		/***********************************************/

	}

}
