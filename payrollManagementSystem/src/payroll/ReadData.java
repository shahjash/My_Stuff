package payroll;


import javax.swing.JOptionPane;
import java.io.*;   


public class ReadData { //Sammy Student, Programmer
public ReadData ()
{
try {  
  String[] firstLine  = new String[100],
           secondLine = new String[100],
           thirdLine = new String[100];
   
  double hours[] = new double[100], wages[] = new double[100];
  
  int index;
  for (index = 0; index < 100; index++) {
  firstLine[index] = "";
  secondLine[index] = "";
  thirdLine[index ] = "";
  hours[index] = 0.0;
  wages[index]= 0.0;
}
  FileReader file = new FileReader("payroll.txt");
  BufferedReader buffer = new BufferedReader(file);
  index = 0;
  String line;
   
  while((line = buffer.readLine()) != null)
  {
    firstLine[index] = line;
    secondLine[index] = buffer.readLine();
    thirdLine[index ] = buffer.readLine();
  
    hours[index] = Double.parseDouble(secondLine[index]); 
    wages[index] = Double.parseDouble(thirdLine[index]);
   
    JOptionPane.showMessageDialog(null,"Name: " + firstLine[index] + "\n" + "Hours: " +
     + hours[index] + "\n" + "Wages: $" +wages[index], "Result",
     JOptionPane.PLAIN_MESSAGE );
 
    index++;
  }
  buffer.close();
  System.exit(0);
}
catch (IOException e ) { 
	System.out.println(e); 
	}        
 }

public static void main(String[] args)  
{
	new ReadData();
}
}

