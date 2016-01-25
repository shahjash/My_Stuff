package telecomm_controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import telecomm_dao.TelecommDAO;
import telecomm_dao.TransactionDao;
import telecomm_fp.Call_CorpPlans;
import telecomm_fp.Call_RegPlans;
import telecomm_fp.Main;

public class InvoiceController {

	private Stage dialogStage;
	private Stage primaryStage = new Stage();

	//This is the Text box field element in the view of Invoice view
	@FXML
	private TextField planName;

	//This is the Text box field element in the view of Invoice view
	@FXML
	private TextField Amount;

	// used to set invoice information for the view
	public void SetInformation() {

		TransactionDao dao = new TransactionDao();
		String name = dao.getPlanName();
		// System.out.println("Invoice Controller:" + name);
		String amount = dao.getPlanAmount();
		// System.out.println("Invoice Controller:" + amount);
		planName.setText(name);
		planName.setDisable(true);// Disabling the TextField so user cannot edit
									// it
		Amount.setText(amount);
		Amount.setDisable(true);// Disabling the TextField so user cannot edit
								// it

	}

	public void BuyMore() {
		dialogStage.fireEvent(new WindowEvent(dialogStage, WindowEvent.WINDOW_CLOSE_REQUEST));
		TelecommDAO dao = new TelecommDAO();
		String user_type = dao.getUserCheckTelecommdao();
		/**
		 * If user_type=yes, then he is a corporate user.Hence route the control
		 * to Call_CorpPlans which will further open Corporate plans window
		 */
		if (user_type.equals("Yes") || user_type.equals("yes") || user_type.equals("YES")) {
			Call_CorpPlans corp = new Call_CorpPlans();
			corp.start(primaryStage);
		}

		/**
		 * If user_type=yes, then he is a regular user.Hence route the control
		 * to Call_RegPlans which will further open Regular plans window
		 */
		if (user_type.equals("NO") || user_type.equals("no") || user_type.equals("No")) {
			Call_RegPlans corp = new Call_RegPlans();
			corp.start(primaryStage);

		}
	}

	/**
	 * When clicked exit buuton the current window event will be closed and the
	 * user will be routed to main login-page
	 */
	public void Exit() {
		dialogStage.fireEvent(new WindowEvent(dialogStage, WindowEvent.WINDOW_CLOSE_REQUEST));
		Main main = new Main();
		main.start(primaryStage);
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;

	}

}
