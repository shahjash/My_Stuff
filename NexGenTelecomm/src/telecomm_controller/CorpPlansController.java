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
import telecomm_dao.CorpPlanDao;
import telecomm_dao.TransactionDao;
import telecomm_fp.Call_Invoice;

public class CorpPlansController implements Initializable {

	private Stage dialogStage;
	// private ComboBox<String> Combo;

	// this is a combobox element in the view to show various plans
	@FXML
	private ComboBox ComboCorp;

	public static String plan_name;
	public static String plan_amount;
	String name;
	String amount;
	Stage primaryStage = new Stage();

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		System.out.println("Start of Combo");
		CorpPlanDao dao = new CorpPlanDao();
		dao.QueryCombobox();
		// storing all the plans in ObservableList for displaying when combo-box
		// is clicked
		ObservableList<String> options = FXCollections.observableArrayList(dao.getArrayList());
		// ComboCorp=new ComboBox(options);
		// System.out.println(dao.getArrayList());
		// System.out.println("Printing options");
		// System.out.println("options value " + options);
		ComboCorp.setItems(options); // adding items to the combo-box
		ComboCorp.setVisibleRowCount(10); // Initially allowing to display 10
											// items in the combo-box

	}

	private void close() {
		dialogStage.fireEvent(new WindowEvent(dialogStage, WindowEvent.WINDOW_CLOSE_REQUEST));
	}

	public void Buy() {

		try {
			if (ComboCorp.getValue() == null || ComboCorp.getValue() == "") {
				System.out.println("null not allowed");
				return;
			} else {
				/**
				 * Plan name contains plan name as well as amount hence
				 * splitting them
				 */
				String temp = (String) ComboCorp.getValue();
				String[] parts = temp.split("-");
				name = parts[0];
				amount = parts[1];
				amount = amount.trim();
				/**********************************************************/
				// System.out.println("Value for temp " + temp);
				// System.out.println("Plan Name:" + name);
				setPlanName(name); // set the plan name
				setPlanAmount(amount);// set the plan amount
				// Creating instance for TransactionDao
				TransactionDao transdao = new TransactionDao();
				transdao.TransactionOps();
				// closing this event window and then calling invoice to display
				// the invoice view
				dialogStage.fireEvent(new WindowEvent(dialogStage, WindowEvent.WINDOW_CLOSE_REQUEST));
				// Calling the form to display the plan bought
				Call_Invoice invoice = new Call_Invoice();
				invoice.start(primaryStage);
			}
		}

		catch (Exception e) {
			System.out.println("Combobox is null: " + e.getMessage());
		}

	}

	/**
	 * Setter Getter for Plan Name
	 *
	 * @return
	 */
	public String getPlanName() {
		System.out.println("getplan returning plan_name");
		return CorpPlansController.plan_name;
	}

	public void setPlanName(String name) {
		CorpPlansController.plan_name = name;
	}
	/********************************************************/

	/**
	 * Setter Getter for Plan Amount
	 *
	 * @return
	 */
	public String getPlanAmount() {
		System.out.println("returning plan_amount");
		return CorpPlansController.plan_amount;
	}

	public void setPlanAmount(String amount) {
		CorpPlansController.plan_amount = amount;
	}

	/*******************************************************/

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;

	}

}
