package locators;


import org.openqa.selenium.By;



public class login_locators {
	

	
	
     public static By click_sign_in = By.xpath("//a[@title='Log in to your customer account']");
     public static By send_email_address = By.name("email_create");
     public static By click_Submit = By.id("SubmitCreate");
     
     public static By loginId = By.xpath("//input[@name='email'and @data-validate='isEmail']");
     public static By password = By.xpath("//input[@name='passwd'and @data-validate='isPasswd']");
     public static By signInBtn = By.linkText("Sign in");
 
}
