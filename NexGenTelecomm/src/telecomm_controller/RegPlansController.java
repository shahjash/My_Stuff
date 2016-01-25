package telecomm_controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import telecomm_dao.RegPlanDao;
import telecomm_dao.TransactionDao;
import telecomm_fp.Call_Invoice;
import telecomm_fp.Call_RegPlans;

public class RegPlansController implements Initializable {

	String name;
	String amount;
	public static String plan_name;
	public static String plan_amount;

	private Stage dialogStage;
	private Stage primaryStage = new Stage();

	// this is a combobox element in the view to show various plans
	@FXML
	private ComboBox ComboReg;

	@Override
	public void initialize(URL url, ResourceBundle rb) {

		RegPlanDao dao = new RegPlanDao();
		dao.QueryCombobox();
		// storing the plan names in the ObservableList list
		ObservableList<String> options = FXCollections.observableArrayList(dao.getArrayList());
		// System.out.println(dao.getArrayList());
		setPlanName(name);
		setPlanAmount(amount);
		// TransactionDao transdao=new TransactionDao();
		// transdao.TransactionOps();
		ComboReg.setItems(options); // adding items to combobox
		ComboReg.setVisibleRowCount(5);

	}

	private void close() {
		dialogStage.fireEvent(new WindowEvent(dialogStage, WindowEvent.WINDOW_CLOSE_REQUEST));
	}

	public void Buy() {

		// Closing any previous window,if open
		dialogStage.fireEvent(new WindowEvent(dialogStage, WindowEvent.WINDOW_CLOSE_REQUEST));

		// if no value of combo-box is selected then error Alert will be
		// generated
		try {
			if (ComboReg.getValue() == null || ComboReg.getValue() == "") {
				System.out.println("null not allowed");
				Call_RegPlans reg = new Call_RegPlans();
				reg.start(primaryStage);
			}
		}

		catch (Exception e) {
			System.out.println("Combobox is null: " + e.getMessage());
		}

		/**
		 * The plan name contains the plan amount as well as name, hence
		 * splitting the String to get the amount and name seperately
		 */
		String temp = (String) ComboReg.getValue();
		String[] parts = temp.split("-");
		name = parts[0];
		amount = parts[1];
		amount = amount.trim();
		/*******************************************************/

		// System.out.println("Value for temp " + temp);
		// System.out.println("Plan Name:" + name);
		setPlanName(name);
		setPlanAmount(amount);
		// Creating instance for TransactionDao
		TransactionDao transdao = new TransactionDao();
		transdao.TransactionOps();
		System.out.println("Buy selected");
		Call_Invoice invoice = new Call_Invoice();
		invoice.start(primaryStage);
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;

	}

	/**
	 * Setter Getter for Plan Name
	 *
	 * @return
	 */
	public String getPlanName() {
		System.out.println("getplan returning plan_name");
		return RegPlansController.plan_name;
	}

	public void setPlanName(String name) {
		RegPlansController.plan_name = name;
	}
	/********************************************************/

	/**
	 * Setter Getter for Plan Amount
	 *
	 * @return
	 */
	public String getPlanAmount() {
		System.out.println("returning plan_amount");
		return RegPlansController.plan_amount;
	}

	public void setPlanAmount(String amount) {
		RegPlansController.plan_amount = amount;
	}
	/*********************************************/

}
