package telecomm_model;

/**
 * This class gets the user credentials and then sets it for authentication
 *
 * @author Jash
 *
 */
public class Telecomm {

	private String username; // user's username
	private String password; // user's password

	// Getter / Setter methods for each attribute of the class

	public Telecomm() {
	}

	public Telecomm(String uname, String upassword) {
		this.username = uname;
		this.password = upassword;
	}

	public String getUname() {
		return username;
	}

	public void setUname(String uname) {
		this.username = uname;
	}

	public String getUpassword() {
		return password;
	}

	public void setUpassword(String upass) {
		this.password = upass;
	}

}
