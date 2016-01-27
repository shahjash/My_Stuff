package payrollExtended;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

/**
 * The following code implements a login module which required user to insert
 * credentials in order to Login into the system. 
 * @author Jash
 *
 */

public class Login {

	public static void main(String[] args) {
		int i = 0, j = 0;
		boolean access = false;
		String message = "welcome" + "\n", response;
		message += "enter your user name";
		message += "\n" + " ";
		

		try {
			while (i < 3) {
				String name = JOptionPane.showInputDialog(message);
				//String password = "";
				name = name.trim();
				name = name.toUpperCase();

				if (name.equals("JASHKUMAR")) {
					JOptionPane.showMessageDialog(null, "hello " + name);
					while (j < 3) {
						message = "enter your password";
						message += "\n" + " ";
						
						/*JPasswordField helps in encrypting the password*/
						JPasswordField pwdFeild=new JPasswordField(20); 
						JOptionPane.showMessageDialog(null,pwdFeild,"Input Password",JOptionPane.PLAIN_MESSAGE);
						char[] pwd=pwdFeild.getPassword();
						String password=new String(pwd);
				//		password = JOptionPane.showInputDialog(message);
						password = password.trim();
						password = password.toUpperCase();

						if (password.equals("AUTUMN")) {
							access = true;
							break;
						} // end if-2
						else {
							JOptionPane.showMessageDialog(null, "Incorrect password", "Error",
									JOptionPane.WARNING_MESSAGE);
							JOptionPane.showMessageDialog(null, "Maximum 3 attempts are allowed. \n "
									+ "The System will Exit thereafter", "Notification", JOptionPane.WARNING_MESSAGE);
							if (j == 3) {

								System.exit(1);
							} else {
								j++;
							}
						} // end else-2
					} // end while j

					break;
				} // end if-1

				else {
					JOptionPane.showMessageDialog(null, "Incorrect login name", "Error", JOptionPane.WARNING_MESSAGE);
					JOptionPane.showMessageDialog(null, "Maximum 3 attempts are allowed. \n "
							+ "The System will Exit thereafter", "Notification", JOptionPane.WARNING_MESSAGE);

					if (i == 3) {

						System.exit(1);
						break;
					}

					else {
						i++;
					}

				} // end else-1

			} // end while-outer

			if (access == true) {
				/******************************/
				try {
					Menu m = new Menu();
					System.exit(1);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				/********************************/
			} // end if

		}// end try

		catch (Exception e1) {
			// System.out.println(e1.getMessage());
			JOptionPane.showMessageDialog(null, "The System will exit now", "Notification", JOptionPane.NO_OPTION);
		}

	}// end main

} // end class
