package payrollExtended;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;

import javax.swing.JOptionPane;

/**
 * The following code reads the data from overtime.txt and displays it on dialog box.
 * @author Jash
 *
 */
public class ReadData {

	public ReadData() {
		try {
			String[] firstLine = new String[100], secondLine = new String[100], thirdLine = new String[100],
					fourthLine=new String[100],fifthLine=new String[100],sixthLine=new String[100];

			double hours[] = new double[100], wages[] = new double[100];
			Double[] overtime_hours=new Double[100];
			Double[] gross_pay= new Double[100];
			Double[] overtime_wages=new Double[100];
			
			String wages1[] = new String[100];
			String[] gross_pay1=new String[100];
			String[] overtime_hours1=new String[100];
			String[] overtime_wages1=new String[100];
			
			DecimalFormat df = new DecimalFormat("##.##");

			int index;
			for (index = 0; index < 100; index++) {
				firstLine[index] = "";
				secondLine[index] = "";
				thirdLine[index] = "";
				fourthLine[index]="";
				fifthLine[index]="";
				sixthLine[index]="";
				hours[index] = 0.0;
				wages[index] = 0.0;
			}

			FileReader file = new FileReader("overtime.txt");
			BufferedReader buffer = new BufferedReader(file);

			index = 0;
			String line;

			/**
			 * This part of the code will read the details of the employees from
			 * the file payroll.txt and display it one by one on the dialog-box
			 */
			while ((line = buffer.readLine()) != null) {
				firstLine[index] = line; // Reads the Employee Name from overtime.txt
				secondLine[index] = buffer.readLine(); // Reads Employee working hours
				thirdLine[index] = buffer.readLine(); // Reads Wages
				fourthLine[index]=buffer.readLine(); // Reads Overtime hours
				fifthLine[index]=buffer.readLine(); // Reads Overtime wages
				sixthLine[index]=buffer.readLine(); // Reads Gross Pay

				hours[index] = Double.parseDouble(secondLine[index]);
				wages[index] = Double.parseDouble(thirdLine[index]);
				wages1[index] = df.format(wages[index]);
				overtime_hours[index]=Double.parseDouble(fourthLine[index]);
				overtime_hours1[index]=df.format(overtime_hours[index]);
				overtime_wages[index]=Double.parseDouble(fifthLine[index]);
				overtime_wages1[index]=df.format(overtime_wages[index]);
				gross_pay[index]=Double.parseDouble(sixthLine[index]);
				gross_pay1[index]=df.format(gross_pay[index]);

				JOptionPane.showMessageDialog(null, "Name: " + firstLine[index] + "\n" + "Hours: " + +hours[index]
						+ "\n" + "Wages: $" + wages1[index] + "\n" + "Overtime hours: " + fourthLine[index] + "\n" 
						+ "Overtime Wages:$ " + overtime_wages1[index] + "\n" + "Gross Wages:$ " + gross_pay1[index]
								, "Result", JOptionPane.PLAIN_MESSAGE);

				index++;
			}
			buffer.close();
			System.exit(0);
		}
		/******************************************************************************************************/

		/**
		 * The catch block will catch any time of exception that occurs in the
		 * profram As per the code logic, the error that can occur can be
		 * "File does not Exist". This is because, if we run this code without
		 * payroll.txt file being created we are going to get that Error
		 * Message.
		 */
		catch (IOException e) {
			// System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No such file Exist", "ERROR!!!", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void main(String[] args) {
		new ReadData();
	}

}
