package payrollExtended;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

/**
 * The following code generates a report file(.txt file) for the a particular employee,
 * as per the user's requirement 
 * @author Jash
 *
 */

public class Report {
	
	public Report() {

		try {
			int l = 0, i = 0, k = 0;
			String[] a = new String[6];
			String part1 = "", part2 = "", file_name = "";
			ArrayList<String> arr = new ArrayList<>();
			String search_name = "", line = "", temp = "";
			FileReader file = new FileReader("_overtime.txt");
			BufferedReader buffer = new BufferedReader(file);

			/*
			 * This part of the code will extract the only the names of the
			 * Employees from overtime.txt file and stores into a string and
			 * then displaying the employee names in the dialog box which will
			 * appear at the time of searching the employee details (further
			 * part of the code)
			 */
			while ((line = buffer.readLine()) != null) {
				if (line.matches("[a-z A-Z]+")) {
					arr.add(line);
				}
			}

			/*
			 * We can use either of the following, I have selected a normal FOR
			 * loop as it is easy
			 */

			// For-each loop
			/*
			 * for(String s : arr){ temp = temp + s + '\n'; }
			 */

			// List Iterator
			/*
			 * ListIterator<String> itr = arr.listIterator();
			 * while(itr.hasNext()) temp = temp + itr.next() +'\n';
			 */

			// Normal for loop
			for (k = 0; k < arr.size(); k++) {
				temp = temp + arr.get(k) + '\n';
			}
			/*****************************************************************************/

			/**
			 * The following code will accept the user input and IF-ELSE part
			 * will take care that no special characters or Numbers are entered
			 * in the text box to search employees details
			 */
			search_name = JOptionPane.showInputDialog(null, temp, "Enter Employee's Full Name");
			if (search_name.matches("[a-z A-Z]+")) {

			}

			else {
				JOptionPane.showMessageDialog(null, "Error occured due to following Reasons \n"
						+ "1.Special character/s was entered \n" + "2.Number/s were entered  \n"
						+ "3.Null Value was entered", "ERROR!!!", JOptionPane.ERROR_MESSAGE);
				System.exit(0);
			}
			/*************************************************************************************/

			/**
			 * The following part of the code will give the required file name,
			 * which will be in the format of Initial of the Employee's first
			 * name concatenated with last .txt
			 */
			try {
				String[] text_name = new String[2];
				text_name = search_name.split(" ");
				part1 = text_name[0];
				part2 = text_name[1];
				// System.out.println(part1);
				// System.out.println(part2);
				file_name = part1.substring(0, 1) + part2;
			}

			catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Enter a valid name from the list shown", "Error",
						JOptionPane.ERROR_MESSAGE);
				JOptionPane.showMessageDialog(null, "The program will be terminated.Thank you", "Notification",
						JOptionPane.PLAIN_MESSAGE);
				System.exit(0);
			}
			/************************************************************************************/

			buffer.close(); // closing the buffer Reader

			// Initially assuming the name is not found,hence we will keep
			// boolean notFound=true
			boolean notFound = true;

			BufferedReader buffer2 = new BufferedReader(new FileReader("overtime.txt"));

			/*
			 * This part of the code will find the searched name in the
			 * overtime.txt file and if found it will write all the details
			 * about that employee into new text file as per the Employee Name;
			 * If the searched employee's name does not match it will throw an
			 * Error message and reasons for the same
			 */
			while ((line = buffer2.readLine()) != null) {
				if (line.matches(search_name)) {
					// System.out.println("Found");
					// System.out.println(line);
					JOptionPane.showMessageDialog(null, "Report file has been generated at its destination folder",
							"Report", JOptionPane.PLAIN_MESSAGE);
					FileWriter fw = new FileWriter(file_name + ".txt");
					BufferedWriter bw = new BufferedWriter(fw);
					bw.write("********************Payroll Report***************************");
					bw.newLine();
					bw.write("Employee Name: " + line);
					bw.newLine();
					while (i < 5) {
						switch (i) {
						case 0:
							bw.write("Working Hours: " + buffer2.readLine());
							bw.newLine();
							break;
						case 1:
							bw.write("Wages: $" + buffer2.readLine());
							bw.newLine();
							break;
						case 2:
							bw.write("Overtime Hours: " + buffer2.readLine());
							bw.newLine();
							break;
						case 3:
							bw.write("Overtime Pay: $" + buffer2.readLine());
							bw.newLine();
							break;
						case 4:
							bw.write("Gross Pay: $" + buffer2.readLine() + " (Overtime Pay Included)");
							bw.newLine();
							bw.write("*************************************************************");
							break;
						default:
							System.out.println("Default reached");
						}
						i++;
					}// end inner while
					notFound = false;
					buffer2.close();
					bw.close();
					break;
				} // end if
				l++;
			} // end while

			if (notFound == true) {
				JOptionPane.showMessageDialog(null, "No Match Found \n Following can be the one of the reasons"
						+ "\n 1.No such employee exist. "
						+ "\n 2.The employee name was not entered in the way as shown in the list."
						+ "\n 3.A NULL value was entered", "******************ERROR*****************",
						JOptionPane.ERROR_MESSAGE);
				System.exit(0);
			} // end else
			/*************************************************************************************************************/

		} // end try

		/**
		 * If any other Error occurs or user hits "Cancel" button the program
		 * will notify about it and make an exit.
		 */
		catch (Exception e) {
			String s = e.getMessage();
			if (s == null) {
				JOptionPane.showMessageDialog(null, "You will exit the process now", "EXIT", JOptionPane.PLAIN_MESSAGE);
				System.exit(0);
			} else {
				JOptionPane.showMessageDialog(null, "File Does not exist", "EXIT", JOptionPane.PLAIN_MESSAGE);
				System.exit(0);
			}

		}
	}

	public static void main(String[] args) {

		new Report();
	}
}
