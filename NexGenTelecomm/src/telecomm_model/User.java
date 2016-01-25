package telecomm_model;

import javafx.stage.Stage;
import telecomm_dao.TelecommDAO;
import telecomm_fp.Call_InfoUpdate;

public class User implements UserInterface {

	public Stage primaryStage = new Stage();
	public Stage dialogStage;
	public static String username;
	public static String user_check;

	/*
	 * This method is called by different users to update their passwords
	 * (non-Javadoc)
	 *
	 * @see telecomm_model.UserInterface#UpdateInfo()
	 */
	public void UpdateInfo() {

		/**
		 * creating dao instance to get username and user_check(type) which will
		 * be used to update user's (admin,corpuser,reguser) password
		 */
		TelecommDAO teledao = new TelecommDAO();
		username = teledao.getUserTelecommdao();
		user_check = teledao.getUserCheckTelecommdao();
		// System.out.println(username);
		// System.out.println(user_check);
		Call_InfoUpdate info_update = new Call_InfoUpdate();
		info_update.start(primaryStage);

	}

}
