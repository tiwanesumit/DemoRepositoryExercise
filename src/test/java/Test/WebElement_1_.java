package Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElement_1_ {
	
	WebDriver driver;
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/");
        driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    
	    
	List<WebElement> all_links =  driver.findElements(By.tagName("a"));
	System.out.println("Total Tags are :"+ all_links);
	
	for(int i=0;i<= all_links.size();i++ ) {
		System.out.println("Links on Page "+all_links.get(i).getAttribute("href"));
		System.out.println("Links on Page "+all_links.get(i).getText());
			
		
	}
	}

}
