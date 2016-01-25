package telecomm_model;

/**
 * This class will be used tp update user's password
 *
 * @author Jash
 *
 */
public class InfoUpdate_model {

	public String new_password; // new password for user
	public String uname;// username

	// Getter / Setter methods for each attribute of the class

	public String getPassword() {
		return this.new_password;
	}

	public void setPassword(String password) {
		this.new_password = password;

	}

	public String getUserName() {
		return this.uname;
	}

	public void setUserName(String username) {
		this.uname = username;

	}

}
