package pages;

import static org.testng.Assert.assertEquals;

import baseclass.DriverHelper;
import baseclass.PropertyReader;
import locators.CommonLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.SendKeysAction;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import utilities.ExecutionLog;


public class login extends DriverHelper implements CommonLocators {

	public static String ExpectedTilte = "Home";
	WebDriver driver;

	public login(WebDriver driver) {

		this.driver = driver;

	}

	public String loggedin(String usernamevalue, String passwordvalue) throws InterruptedException, Exception {

		
		String Homepage = null;
		try {
			
			

			sendKeys(loc_username, usernamevalue, "username");

			ExecutionLog.Log("UserName: " + usernamevalue);
			ExecutionLog.Log("Password: " + passwordvalue);

			sendKeys(loc_Password, passwordvalue, "Password");

			clickOn(loc_loginbutton, "LoginButton");

			Thread.sleep(3000);

			if (driver.findElement(By.xpath(loc_Agreecheck)).isDisplayed()) {
		
				clickOn(loc_Agreecheck, "Agree");

				Thread.sleep(2000);
				clickOn(loc_Submit, "Submit");
				
				Homepage = driver.getTitle();
			
			}

			else {
			
				 Homepage = driver.getTitle();
				ExecutionLog.Log("Login Done");

				// Assert.assertEquals(Homepage, ExpectedTilte, "LoggedIn Successfully");

				// ExecutionLog.Log("Home Page Open");
			}
			
			
		
			
			ExecutionLog.Log("Page title is: " + Homepage);
			
	
	
		}
		

		catch (Exception e) {

			ExecutionLog.Log("LoginFail");
			getScreenShotOnCheckpointFailure("login");
		

		}
		
		return Homepage;
		
		
		
	}

}