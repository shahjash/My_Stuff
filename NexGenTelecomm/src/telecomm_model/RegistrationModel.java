package telecomm_model;

/**
 * This class is used gets the new user details from the form and sets its value
 *
 * @author Jash
 *
 */
public class RegistrationModel {

	private String fname; // user's 1st name
	private String lname;// user's last name
	private String ssn; // user's SSN
	private String username; // user's username
	private String password; // user's password
	private String corp_flag; // user's type

	// default constructor
	public RegistrationModel() {

	}

	// Fully parameterized constructor
	public RegistrationModel(String fname, String lanme, String ssn, String uname, String password, String corp_flag) {
		this.fname = fname;
		this.lname = lanme;
		this.ssn = ssn;
		this.username = uname;
		this.password = password;
		this.corp_flag = corp_flag;
	}

	/***** Getter Setter for fname *********/
	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}
	/*******************************************************/

	/****** Getter Setter for lname ********/
	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}
	/****************************************************/

	/******** Getter Setter for ssn ************/
	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	/*************************************************/

	/***** Getter Setter for username ***********/
	public String getUname() {
		return username;
	}

	public void setUname(String username) {
		this.username = username;
	}
	/*******************************************************/

	/***** Getter Setter for password ***********/
	public String getUpassword() {
		return password;
	}

	public void setUpassword(String password) {
		this.password = password;
	}
	/**************************************************/

	/****** Getter Setter for corp_flag **********/
	public String getCorpFlag() {
		return corp_flag;
	}

	public void setCorpFlag(String corp_flag) {
		this.corp_flag = corp_flag;
	}
	/**************************************************************/

}
