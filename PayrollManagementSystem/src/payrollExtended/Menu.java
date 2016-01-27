package payrollExtended;

import javax.swing.JOptionPane;

/**
 * The given code gives the user options to
 * 1.Create payroll data
 * 2.View payroll data
 * 3.Generate a report for a particular employee
 * 4.Generate a summary of overtime wages of the employees,
 * 5.Exit the process
 * @author Jash
 *
 */

public class Menu {
	public Menu() {
		int choice = 0;
		String message = "welcome" + "\n", response = "";

		message += "\n" + "enter...";
		message += "\n" + "  1 to enter payroll data";
		message += "\n" + "  2 to view payroll data";
		message += "\n" + "  3 to generate report by employee";
		message += "\n" + "  4 to generate overtime summary of employee";
		message += "\n" + "  5 to exit" + "\n" + " ";

		char answer = 'Y';

		do {

			try {

				/* Taking the input from the user via Dialog box */
				response = JOptionPane.showInputDialog(message);

				choice = Integer.parseInt(response);

				/*
				 * The Switch-Case statement gives the options that user wants
				 * to select
				 */
				switch (choice) {
				case 1:
					CreateData cd = new CreateData();
					answer = 'N';
					System.exit(1);
					break;
				case 2:
					ReadData rd = new ReadData();
					answer = 'N';
					System.exit(1);
					break;
				case 3:
					Report rpt = new Report();
					answer = 'N';
					System.exit(1);
					break;
				case 4:
					Summary sum = new Summary();
					answer = 'N';
					System.exit(1);
					break;
				case 5:
					answer = 'N';
					System.exit(1);
					break;
				default: {
					answer = 'Y';
					choice = 0;
					JOptionPane.showMessageDialog(null, "enter a number: 1 - 4");
				}
				}// end switch
			}// end try

			/**
			 * If any input other than a numeric value is enterd, then the catch
			 * block will raise an ERROR messsage and the program will be
			 * re-directed to enter a valid input.
			 */
			catch (Exception e) {
				JOptionPane.showMessageDialog(null, " Please Enter a Valid Input OR Press 5 to Exit", "ERROR!!!",
						JOptionPane.ERROR_MESSAGE);
				// System.out.println(e);
			}
			/*************************************************************************************************************/
		} while (answer == 'Y' || answer == 'y');

	}

	public static void main(String[] args) {
		new Menu();
	}// end main

}
