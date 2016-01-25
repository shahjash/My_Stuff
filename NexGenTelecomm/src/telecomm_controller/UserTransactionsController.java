package telecomm_controller;

import java.sql.ResultSet;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;

import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import telecomm_dao.HistoryTransactionDao;

import telecomm_fp.Call_Admin;

public class UserTransactionsController {

	String output = "";
	public Stage dialogStage;
	public Stage primaryStage = new Stage();

	// This is the label field element in the view of User_Transcation page page
	@FXML
	private Label TransactionID;

	// This is the label field element in the view of User_Transcation page page
	@FXML
	private Label UserID;

	// This is the label field element in the view of User_Transcation page page
	@FXML
	private Label PlanName;

	// This is the label field element in the view of User_Transcation page page
	@FXML
	private Label Amount;

	// This is the label field element in the view of User_Transcation page page
	@FXML
	private TableColumn firstColumn;

	public void Back() {

		try {
			dialogStage.fireEvent(new WindowEvent(dialogStage, WindowEvent.WINDOW_CLOSE_REQUEST));
			Call_Admin ca = new Call_Admin();
			ca.start(primaryStage);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;

	}

	// Takes transaction details from database
	public void transaction() {
		HistoryTransactionDao trans = new HistoryTransactionDao();
		trans.transaction();
		HistoryTransactionDao htd = new HistoryTransactionDao();
		ResultSet rs = htd.getResultSet();

		try {
			while (rs.next()) {

				String trans_id, user_id, PlanName, Amount;
				int t_id = rs.getInt("transaction_id");
				trans_id = Integer.toString(t_id);
				int u_id = rs.getInt("user_id");
				user_id = Integer.toString(u_id);
				PlanName = rs.getString("Plan_Name");
				Amount = rs.getString("amount");
				// Appending all columns into one string, which will used to
				// print the same on view
				output += trans_id + "\t\t\t\t" + user_id + "\t\t\t " + PlanName + "\t\t\t\t " + Amount + "\n";

				// System.out.println(trans_id+"\t"+u_id+"\t");
			}
		} catch (Exception e) {
			System.out.println("Error in retrieval");
		}
		System.out.println(output);
		// Printing the entire table data in label TransactionID
		TransactionID.setText(output);

	}

}
