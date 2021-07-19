package Test;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import locators.Registration_locators;
import locators.login_locators;
import variable.all_variables;
import variable.variable_reader;




public class login_StepDefn {
	
	 WebDriver driver;
	 public Properties prop;
	 @Before
	 public void BeforeCodition() {
		 
//		    driver = new ChromeDriver();
//		    driver.get("http://automationpractice.com/");
//		    driver.manage().window().maximize();
//		    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 
		 prop = new Properties();
			try {
				FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\variable\\configure.properties");
				prop.load(ip);
			} catch (FileNotFoundException e) {
				System.out.println("Config.properties file not found please give correct path");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("IOException occured while loading the config.properties file");
				e.printStackTrace();
			}
			
//			System.out.println(prop.getProperty("url"));
//			System.out.println(prop.getProperty("browser"));
//			System.out.println(prop.getProperty("headless"));
//			System.out.println(prop.getProperty("maximize"));
//			
			
			driver = new ChromeDriver();
			
			if (prop.getProperty("maximize").equalsIgnoreCase("yes")) {
				driver.manage().window().maximize();
			}	
			
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));
			
	 }
		    
		 
	 
	
	@Given("user open the browser and checking  user navigate to right url")
	public void user_open_the_browser_and_checking_user_navigate_to_right_url() {
	     
		   
		   Assert.assertEquals("url is not correct",all_variables.loginURL, driver.getCurrentUrl());
		   
	}

	@Given("provide correct email address to navigate")
	public void provide_correct_email_address_to_navigate() {
		
		driver.findElement(login_locators.click_sign_in).click();
        driver.findElement(login_locators.send_email_address).sendKeys(all_variables.email);;
		driver.findElement(login_locators.click_Submit).click();
		
	}

	@When("user provide correct registration details and login")
	public void user_provide_correct_registration_details_and_login()  {
		
		 
		try {
		
		
		CSVReader reader = new  CSVReader(new FileReader(all_variables.csvpath));
		//reading data from text file
	   // StringBuffer buffer = new StringBuffer();
		String data[];
	    
        while ((data = reader.readNext())!=null) {
			
     
				String first_name = data[1];
				String last_name = data[2];
				String Password = data[3]; 
				String f_Name = data[1];
				String L_Name = data[2];
				String Address = data[4];
				String city = data[5];
				String Pincode = data[6];
				String Mobile_Number = data[7];
				String Reff_Address = data[8];
			
              

             WebDriverWait wait = new WebDriverWait (driver, 20);
           //  wait.until(ExpectedConditions.VisibilityofElementLocated());
				
				
				driver.findElement(Registration_locators.click_on_radio_button).click();
				driver.findElement(Registration_locators.first_Name).sendKeys(first_name);
				driver.findElement(Registration_locators.last_Name).sendKeys(last_name);
				driver.findElement(Registration_locators.password).sendKeys(Password);
			    driver.findElement(Registration_locators.f_name).sendKeys(f_Name);
			    driver.findElement(Registration_locators.l_name).sendKeys(L_Name);
			    driver.findElement(Registration_locators.adress).sendKeys(Address);
			    driver.findElement(Registration_locators.city).sendKeys(city);
			    driver.findElement(Registration_locators.state).click();
			    driver.findElement(Registration_locators.pincode).sendKeys(Pincode);
			    driver.findElement(Registration_locators.country).click();
			    driver.findElement(Registration_locators.mobile).sendKeys(Mobile_Number);
			    driver.findElement(Registration_locators.Ref_address).sendKeys(Reff_Address);
			    driver.findElement(Registration_locators.Register).click();
		 }
        
		}catch(Exception e){
	        	
	        	e.printStackTrace();
	        	
	        }
		finally {
			
		System.out.println("Finally block is executed");
			
		}
			
			}
       

	@Then("user is launch on homepage correctly")
	public void user_is_launch_on_homepage_correctly() {
		
		
		Assert.assertEquals("Not on home page", all_variables.after_registration_url, driver.getCurrentUrl());
		
		   
	}
	
	@After
	
	public void End_Method() {
		
		driver.close();
		
	}
	


}
