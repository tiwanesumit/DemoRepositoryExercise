package variable;

import java.io.IOException;

//import org.apache.logging.log4j.Logger;
//import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
//import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class Extend_Reports {

		
	static WebDriver driver;
    static double grades[][];
    static String[] name;
    public static void main(String[] args) throws InterruptedException, IOException {
       
            ExtentHtmlReporter reporter=new ExtentHtmlReporter("./Reports/TestReport.html");
            ExtentReports extent = new ExtentReports();
            extent.attachReporter(reporter);
            ExtentTest logger=extent.createTest("LoginTest");
           
    }
	
	
		
	}


