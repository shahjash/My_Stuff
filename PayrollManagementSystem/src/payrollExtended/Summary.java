package payrollExtended;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;

/**
 * The given code will display the summary of overtime wages of the employees 
 * having their 1st name in the range A-F or G-L or M-Z
 * @author Jash
 *
 */

public class Summary {

	public Summary() {

		double sum = 0, overtime_wages = 0;
		int user_input = 0;
		String temp = "", s1 = "", s2 = "", s3 = "", display_sum = "", display_overtime = "";
		String[] str = new String[2];
		DecimalFormat df = new DecimalFormat("##.##");


		/**
		 * The code below has a message that will be display_sumed on the dialog
		 * box, which allows the user to make a choice
		 */
		String message = "welcome" + "\n", response = "";

		message += "\n" + "enter...";
		message += "\n" + "  1 to view employee's overtime starting with initials A-F";
		message += "\n" + "  2 to view employee's overtime starting with initials G-L";
		message += "\n" + "  3 to view employee's overtime starting with initials M-Z";
		message += "\n" + "  4 to exit" + "\n" + " ";
		/*******************************************************************************************/

		char signal = 'Y';

		do {
			try {

				// asking user to input his choice
				response = JOptionPane.showInputDialog(message);
				user_input = Integer.parseInt(response);
				if (response.equals("1") || response.equals("2") || response.equals("3") || response.equals("4")) {
					signal = 'N';
				} else {
					JOptionPane.showMessageDialog(null, "Enter: 1-4", "Error!!!", JOptionPane.ERROR_MESSAGE);
					signal = 'Y';
				}
			}

			catch (NumberFormatException e) {
				// System.out.println(e);
				JOptionPane.showMessageDialog(null, "Enter a valid Input", "Error!!!", JOptionPane.ERROR_MESSAGE);
			}
		} while (signal == 'Y');

		try {
			int i = 0, j, k;
			String s = "", line = "", store = "";
			ArrayList<String> arr = new ArrayList<>();
			ArrayList<String> arr_name = new ArrayList<>();
			ArrayList<String> arr_owage = new ArrayList<>();
			ArrayList<String> arr_store = new ArrayList<>();
			ArrayList<String> arr_slot1 = new ArrayList<>();
			ArrayList<String> arr_slot2 = new ArrayList<>();
			ArrayList<String> arr_slot3 = new ArrayList<>();
			FileReader file = new FileReader("overtime.txt");
			BufferedReader buffer = new BufferedReader(file);

			while ((line = buffer.readLine()) != null) {
				arr.add(line);
			}

			// System.out.println(arr);

			/*
			 * ArrayList consisting of Employee Names
			 */
			for (j = 0; j < arr.size(); j += 6) {
				arr_name.add(arr.get(j));
			}

			for (k = 4; k < arr.size(); k += 6) {
				arr_owage.add(arr.get(k));
			}

			// System.out.println(arr_name);
			// System.out.println(arr_owage);

			for (i = 0; i < arr_name.size(); i++) {
				arr_store.add(arr_name.get(i) + " " + arr_owage.get(i));
			}

			// Sorting arraylist Alphabetically
			Collections.sort(arr_store);

			// System.out.println(arr_store);

			/**
			 * The code below reads the arraylist which contain employee's
			 * information and stores the employee names along with their
			 * overtime wages into a new ArrayList only for those Employees
			 * whose 1st Name falls in the range a-f or A-F
			 */
			for (j = 0; j < arr_store.size(); j++) {
				char ch[] = arr_store.get(j).toCharArray();
				if ((ch[0] >= 'a' && ch[0] <= 'f') || (ch[0] >= 'A' && ch[0] <= 'F')) {
					arr_slot1.add(arr_store.get(j));
				}
			}
			/****************************************************************************************/

			// System.out.println(arr_slot1);

			/**
			 * The code below reads the arraylist which contain employee's
			 * information and stores the employee names along with their
			 * overtime wages into a new ArrayList only for those Employees
			 * whose 1st Name falls in the range g-l or G-L
			 */
			for (j = 0; j < arr_store.size(); j++) {
				char ch[] = arr_store.get(j).toCharArray();
				if ((ch[0] >= 'g' && ch[0] <= 'l') || (ch[0] >= 'G' && ch[0] <= 'L')) {
					arr_slot2.add(arr_store.get(j));
				}
			}
			/*******************************************************************************************/

			// System.out.println(arr_slot2);

			/**
			 * The code below reads the arraylist which contain employee's
			 * information and stores the employee names along with their
			 * overtime wages into a new ArrayList only for those Employees
			 * whose 1st Name falls in the range m-z or M-Z
			 */
			for (j = 0; j < arr_store.size(); j++) {
				char ch[] = arr_store.get(j).toCharArray();
				if ((ch[0] >= 'm' && ch[0] <= 'z') || (ch[0] >= 'M' && ch[0] <= 'Z')) {
					arr_slot3.add(arr_store.get(j));
				}
			}
			/***********************************************************************************************/

			// System.out.println(arr_slot3);

			/**
			 * This part of the code will display_sum the employee names along
			 * with overtime wages; only for employees whose first name falls in
			 * the range a-f or A-F.
			 */
			if (user_input == 1) {
				for (i = 0; i < arr_slot1.size(); i++) {
					temp = arr_slot1.get(i);
					str = temp.split(" ");
					s1 = str[0];
					s2 = str[1];
					s3 = str[2];
					overtime_wages = Double.parseDouble(s3);
					display_overtime = df.format(overtime_wages);
					sum += Double.parseDouble(s3);
					display_sum = df.format(sum);
					JOptionPane.showMessageDialog(null, "Name: " + s1 + " " + s2 + "\n" + "Overtime Wages: $"
							+ display_overtime, "Overtime Information", JOptionPane.PLAIN_MESSAGE);
				}

				JOptionPane.showMessageDialog(null, "The overtimes wages for the employees is $" + display_sum,
						"Result", JOptionPane.PLAIN_MESSAGE);
			}
			/******************************************************************************************************/

			/**
			 * This part of the code will display_sum the employee names along
			 * with overtime wages; only for employees whose first name falls in
			 * the range a-f or A-F.
			 */
			if (user_input == 2) {
				for (i = 0; i < arr_slot2.size(); i++) {
					temp = arr_slot2.get(i);
					str = temp.split(" ");
					s1 = str[0];
					s2 = str[1];
					s3 = str[2];
					overtime_wages = Double.parseDouble(s3);
					display_overtime = df.format(overtime_wages);
					sum += Double.parseDouble(s3);
					display_sum = df.format(sum);
					JOptionPane.showMessageDialog(null, "Name: " + s1 + " " + s2 + "\n" + "Overtime Wages: $"
							+ display_overtime, "Overtime Information", JOptionPane.PLAIN_MESSAGE);
				}

				JOptionPane.showMessageDialog(null, "The overtimes wages for the employees is $" + display_sum,
						"Result", JOptionPane.PLAIN_MESSAGE);
			}
			/********************************************************************************************************/

			/**
			 * This part of the code will display_sum the employee names along
			 * with overtime wages; only for employees whose first name falls in
			 * the range m-z or M-Z.
			 */
			if (user_input == 3) {
				for (i = 0; i < arr_slot3.size(); i++) {
					temp = arr_slot3.get(i);
					str = temp.split(" ");
					s1 = str[0];
					s2 = str[1];
					s3 = str[2];
					overtime_wages = Double.parseDouble(s3);
					display_overtime = df.format(overtime_wages);
					sum += Double.parseDouble(s3);
					display_sum = df.format(sum);
					JOptionPane.showMessageDialog(null, "Name: " + s1 + " " + s2 + "\n" + "Overtime Wages: $"
							+ display_overtime, "Overtime Information", JOptionPane.PLAIN_MESSAGE);
				}

				JOptionPane.showMessageDialog(null, "The overtimes wages for the employees is $" + display_sum,
						"Result", JOptionPane.PLAIN_MESSAGE);
			}
			/*********************************************************************************************************/

		}// end try

		catch (Exception e) {

			// System.out.println(e.getMessage());
		}

	}// end method Summary

	public static void main(String[] args) {

		new Summary();
	} // end main
}// end clss
