package variable;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

public class variable_reader {
	
	String csvpath = "C:\\\\Users\\\\DELL\\\\Capgemini_Discover\\\\Capgemini_Discover_Automation_Practise\\\\src\\\\test\\\\java\\\\variable\\\\Data.csv";
	
	public void ReadText() throws  IOException, CsvValidationException  {
		
		//CSVReader class
		
		CSVReader reader = new CSVReader(new FileReader (csvpath));
		
		//reading data from csv file
		
		StringBuffer  buffer = new StringBuffer();
		String data[];
		
		while ((data = reader.readNext())!=null) {
			
			for(int i=0; i<=data.length;i++) {
				
				String email = data[i];
				
			}
			
		}
	    
	
	}

}
