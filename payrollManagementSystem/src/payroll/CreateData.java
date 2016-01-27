package payroll;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class CreateData {

	/**
	 * This function checks whether the working hours and the wages is in
	 * valid(Double) format or not , it also validates for -ve value.
	 * 
	 * @param str
	 * @return
	 */
	public static boolean CheckDouble(String str) {
		try {
			Double a = Double.parseDouble(str);
			if (a < 0) {
				JOptionPane.showMessageDialog(null, "Cannot accept Negative values", "Error", JOptionPane.ERROR_MESSAGE);
				System.exit(0);
			}
		}

		catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		int repeat = 1;
		String answer;

		JOptionPane.showMessageDialog(null, "this program writes payroll data", "Welcome", JOptionPane.PLAIN_MESSAGE);

		do {
			Write();

			/**
			 * The following part of the code asks the user, whether he/she
			 * wants to continue with the entering more data or exit the process
			 */
			answer = JOptionPane.showInputDialog("write payroll data?\n" + "enter 1 to continue or other key to exit");

			if (answer.equals("1")) {
				repeat = Integer.parseInt(answer);
			}

			else {

				JOptionPane.showMessageDialog(null, "Program Terminated . Thank you", "Result",
						JOptionPane.PLAIN_MESSAGE);

				System.out.println("Program Terminated . Thank you");
				System.exit(0);

			}

			repeat = Integer.parseInt(answer);

		} while (repeat == 1);

	}

	public static void Write() {
		try {

			String firstLine = "", secondLine = "", thirdLine = "", number = "";

			/**
			 * This part of the code checks whether the file name payroll exist
			 * or not if not then it will create one.
			 */
			File check = new File("payroll.txt");
			FileWriter file;

			if (check.exists())
				// allows appending of data to file
				file = new FileWriter("payroll.txt", true);
			else
				file = new FileWriter("payroll.txt");

			BufferedWriter buffer = new BufferedWriter(file);
			int size, count = 1;

			/**
			 * This part of the code will not allow the user to enter null
			 * values and also if the user happens to press "ok" or "cancel" it
			 * will prompt the user again to enter the values
			 */
			while (number == null || number.equals("")) {
				number = JOptionPane.showInputDialog("how many records?");
			}

			/**
			 * The If-Else condition checks whether the no.of records entered
			 * are numeric if zero or any other non-numeric value is entered it
			 * will throw an Error
			 */
			if (number.matches("[1-9]+")) {

			}

			else {
				JOptionPane.showMessageDialog(null, "Number of records to be inserted cannot be zero\n" + "Or \n"
						+ "Record inserted is in Incorrect Format", "Error", JOptionPane.ERROR_MESSAGE);
				System.exit(0);
			}

			size = Integer.parseInt(number);

			do {
				firstLine = "";
				secondLine = "";
				thirdLine = "";
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

				} else {
					JOptionPane.showMessageDialog(null, "Name should not contain Numbers or Special Characters",
							"Error", JOptionPane.ERROR_MESSAGE);
					System.out.println("Incorrect Name Format");
					System.exit(0);
				}

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

				/**
				 * This part of the code will write the details entered in the
				 * previos steps into the text file payroll.txt
				 */
				buffer.write(firstLine);
				buffer.newLine();
				buffer.write(secondLine);
				buffer.newLine();
				buffer.write(thirdLine);
				buffer.newLine();
				count++;

				// The loop will continue to run untill all the records are
				// inserted
			} while (count <= size);
			buffer.close();

			JOptionPane.showMessageDialog(null, "data processed", "Result", JOptionPane.PLAIN_MESSAGE);

		}

		catch (IOException e) {
			System.out.println(e);
		}

	}
}
