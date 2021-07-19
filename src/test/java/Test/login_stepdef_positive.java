package Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import locators.login_locators;
import variable.all_variables;

public class login_stepdef_positive {

	 WebDriver driver;
	 public Properties prop;

@Given("use launch the url on browser")
public void use_launch_the_url_on_browser() {
	
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
		
		driver = new ChromeDriver();
		
		if (prop.getProperty("maximize").equalsIgnoreCase("yes")) {
			driver.manage().window().maximize();
		}	
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
}

@When("user login with valide credential")
public void user_login_with_valide_credential() {
	
	driver.findElement(login_locators.click_sign_in).click();
	driver.findElement(login_locators.loginId).sendKeys("sampleidcreated@gmail.com");
	driver.findElement(login_locators.password).sendKeys("Welcome@123");
	driver.findElement(login_locators.click_sign_in).click();

}


@Then("checking the user launch to home page")
public void checking_the_user_launch_to_home_page() {
	
	Assert.assertEquals("Not on home page", all_variables.HomePageUrl, driver.getCurrentUrl());
  }
}
