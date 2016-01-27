package payrollExtended;

import javax.swing.JOptionPane;
import java.io.*;
import java.text.DecimalFormat;

/**
 * This code takes the employee information from the user and 
 * creates a payroll.txt and overtime.txt files 
 * @author Jash
 *
 */


public class CreateData {

	public static boolean CheckDouble(String str) {
		try {
			double d = Double.parseDouble(str);
			return true;
		}

		catch (Exception exp) {
			return false;
		}
	}

	public static void main(String[] args) {
		new CreateData();
	}

	public CreateData() {
		int repeat = 1;
		String answer;

		do {
			Write();
			answer = JOptionPane.showInputDialog("write payroll " + "data?\n" + "enter 1 to continue or 0 to exit");

			repeat = Integer.parseInt(answer);

		} while (repeat == 1);

		System.exit(1);
	}

	static void Write() {
		try {
			DecimalFormat df = new DecimalFormat("##.##");
			String firstLine = "", secondLine = "", thirdLine = "", number = "";
			double overtime = 0, total_hours = 0, wages = 0;
			String overtime_wages = "";
			String gross_pay = "";
			File check = new File("payroll.txt");
			File check1 = new File("overtime.txt");
			FileWriter file;
			if (check.exists())
				file = new FileWriter("payroll.txt", true);
			else
				file = new FileWriter("payroll.txt");

			BufferedWriter buffer = new BufferedWriter(file);

			/*
			 * Checks for the overtime file, if doesn't exist then creates one
			 */
			if (check1.exists())
				file = new FileWriter("overtime.txt", true);
			else
				file = new FileWriter("overtime.txt");

			BufferedWriter buffer1 = new BufferedWriter(file);

			int size = 0, count = 1;
			while (number == null || number.equals("")) {
				number = JOptionPane.showInputDialog("how many records?");
			}

			/**
			 * The following try-catch block will not allow -ve numbers or
			 * decimal numbers to be entered if entered it will throw an Error
			 * Message.
			 */
			try {
				size = Integer.parseInt(number);
				if (size < 0) {
					JOptionPane.showMessageDialog(null, "Cannot accept Negative values", "Error",
							JOptionPane.ERROR_MESSAGE);

					System.exit(0);
				}
			}

			catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Please enter a valid Input", "Error", JOptionPane.ERROR_MESSAGE);
				JOptionPane.showMessageDialog(null, "The program will be terminated now.Thank you!", "Final Message",
						JOptionPane.PLAIN_MESSAGE);
				System.exit(0);
			}
			/**********************************************************************************************************/

			/**
			 * The following IF-ELSE block will allow only numbers in the reange
			 * of 1-9 to be entered if any values apart from these are entered
			 * an Error Message will be displayed.
			 */
			if (number.matches("[1-9]+")) {

			}

			else {
				JOptionPane.showMessageDialog(null, "Number of records to be inserted cannot be zero\n" + "Or \n"
						+ "Record inserted is in Incorrect Format", "Error", JOptionPane.ERROR_MESSAGE);
				JOptionPane.showMessageDialog(null, "The program will be terminated now.Thank you!", "Final Message",
						JOptionPane.PLAIN_MESSAGE);
				System.exit(0);
			}
			/********************************************************************************************************/

			do {

				firstLine = null;
				secondLine = null;
				thirdLine = null;

				String str;
				while (firstLine == null || firstLine.equals("")) {
					firstLine = JOptionPane.showInputDialog("Enter name");
				}

				/**
				 * The If-Else condition provides the validation for the names
				 * entered, if the number or special characters are entered it
				 * will throw and error.
				 */
				if (firstLine.matches("[a-z A-Z]+")) {

				}

				else {
					JOptionPane.showMessageDialog(null, "Name should not contain Numbers or Special Characters",
							"Error", JOptionPane.ERROR_MESSAGE);
					// System.out.println("Incorrect Name Format");
					System.exit(0);
				}
				/****************************************************************************************************/

				while (secondLine == null || secondLine.equals("")) {
					secondLine = JOptionPane.showInputDialog("Enter hours");
				}

				str = secondLine;

				/**
				 * TheIf-Else condition provides validation for the number of
				 * hours by calling function CheckDouble which will check
				 * whether the hours entered are in double format or not if not
				 * it will throw an error message
				 */
				if (CheckDouble(str)) {

				}

				else {
					JOptionPane.showMessageDialog(null, "Hours should not contain Alphabets or Special Characters",
							"Error", JOptionPane.ERROR_MESSAGE);
					System.exit(0);
				}
				/*******************************************************************************************************/

				while (thirdLine == null || thirdLine.equals("")) {
					thirdLine = JOptionPane.showInputDialog("Enter wage");
				}

				str = thirdLine;

				/**
				 * TheIf-Else condition provides validation for the number of
				 * hours by calling function CheckDouble which will check
				 * whether the wages entered are in double format or not if not
				 * it will throw an error message
				 */
				if (CheckDouble(str)) {

				}

				else {
					JOptionPane.showMessageDialog(null, "Wages should not contain Alphabets or Special Characters",
							"Error", JOptionPane.ERROR_MESSAGE);
					System.out.println("Wages Entered in Incorrect Format");
					System.exit(0);
				}
				/*************************************************************************************************/

				/**
				 * This part of the code writes the employee data into file
				 * payroll.txt
				 */
				buffer.write(firstLine);
				buffer.newLine();
				buffer.write(secondLine);
				buffer.newLine();
				buffer.write(thirdLine);
				buffer.newLine();
				/*******************************************************************************************/

				/**
				 * This part of the code will write the employee details as well
				 * overtime details into a new file named overtime.txt
				 */
				buffer1.write(firstLine);
				buffer1.newLine();
				buffer1.write(secondLine);
				buffer1.newLine();
				buffer1.write(thirdLine);
				buffer1.newLine();
				total_hours = Double.parseDouble(secondLine);
				wages = Double.parseDouble(thirdLine);
				/**
				 * If working hours>40 hours overtime wages are calculated for
				 * that particular employee if working hours<40 hours , then
				 * overtime wages are not calculated. zero overtime wages is
				 * entered against that employee.
				 */
				if (total_hours > 40) {
					overtime = total_hours - 40;
					overtime_wages = df.format(wages * 1.5 * overtime);
					double temp = Double.parseDouble(overtime_wages);
					gross_pay = df.format(temp + (wages * 40));
					buffer1.write(overtime + "");
					buffer1.newLine();
					buffer1.write(overtime_wages + "");
					buffer1.newLine();
					buffer1.write(gross_pay + "");
					buffer1.newLine();
				} else {
					overtime = 0;
					overtime_wages = "0";
					gross_pay = df.format(wages * total_hours);
					buffer1.write(overtime + "");
					buffer1.newLine();
					buffer1.write(overtime_wages + "");
					buffer1.newLine();
					buffer1.write(gross_pay + "");
					buffer1.newLine();

				}
				/***************************************************************************************************/

				count++;

			} while (count <= size);

			// closing the BufferedWirter for file payroll.txt
			buffer.close();

			// closing the BufferedWirter for file overtime.txt
			buffer1.close();

			JOptionPane.showMessageDialog(null, "data processed", "Result", JOptionPane.PLAIN_MESSAGE);
		} catch (IOException e) {
			System.out.println(e);
		}
	}

}
