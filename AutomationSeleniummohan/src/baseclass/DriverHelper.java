package baseclass;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.mail.internet.AddressException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.ExecutionLog;
import utilities.SendMail;

public class DriverHelper {

	public static WebDriver driver;

	public static String className;
	public Class<?> classObject;
	public static ExtentReports logger;
	public static ExtentTest test;
	public static boolean TestCaseStatus = true; // true >> Passed, // false >> failed
	public static String TestMethodName = "";
	public static int NumberOfFailures = 0;
	public static int ImageNameForFramesFailures = 0;
	public static int ScreenshotFailureNumber = 0;
	public static String Browser = PropertyReader.readApplicationFile("browser");
	public static ExtentReports extent;
	public static String chromedriverPath = System.getProperty("user.dir") + "\\chromedriver.exe";
	public static String IEdriverPath = System.getProperty("user.dir") + "\\IEDriverServer.exe";
	public static String firefoxdriverPath = System.getProperty("user.dir") + "\\geckodriver.exe";
	public static String URL = PropertyReader.readApplicationFile("url");
	public static String extentfilepath = System.getProperty("user.dir") + "\\test-output\\AdvanceReport\\" +"Test"+"_" +getDateStamp().replace("/", "") + ".html";
	public static String extentconfigfilepath = System.getProperty("user.dir") +"\\extent-config.xml";
	public static String ClientName = PropertyReader.readApplicationFile("Client");
	public static String downloadPath = "C:\\Downloads";
	public static String LevelFirstNamevalue = Uservalue();
	
	@BeforeSuite


	 
	public static WebDriver getbrowser() throws InterruptedException, ClassNotFoundException, SQLException {

		
		ExecutionLog.Log(
				"********************Started Executiong the Test Suite at " + getTimeStamp() + "******************");
		
		

		if (Browser.equalsIgnoreCase("firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			options.setProfile(getProfile("default"));
			options.setAcceptInsecureCerts(true);

			// System.setProperty("webdriver.gecko.driver",firefoxdriverPath);
			driver = new FirefoxDriver(options);
		}

		else if (Browser.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", chromedriverPath);
			  HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			  chromePrefs.put("profile.default_content_settings.popups", 0);
			  chromePrefs.put("download.default_directory", downloadPath); ChromeOptions
			  options = new ChromeOptions(); options.setExperimentalOption("prefs",
			  chromePrefs); DesiredCapabilities cap = DesiredCapabilities.chrome();
			  cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,
			  UnexpectedAlertBehaviour.IGNORE);
			  
			  cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			  cap.setCapability(ChromeOptions.CAPABILITY, options); options.merge(cap);
			  driver = new ChromeDriver(options);
			 
		
		}

		else if (Browser.equalsIgnoreCase("ie")) {

			File file = new File(IEdriverPath);
			System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
			DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
			// caps.setCapability(InternetExplorerDriver.ENABLE_ELEMENT_CACHE_CLEANUP,
			// true);
			// caps.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
			caps.setCapability("unexpectedAlertBehaviour", "accept");
			caps.setCapability("ignoreProtectedModeSettings", true);
			caps.setCapability("enablePersistentHover", false);
			caps.setCapability("requireWindowFocus", true);
			caps.setCapability("disable-popup-blocking", true);
			caps.setCapability("ignoreZoomSetting", true);
			caps.setCapability("nativeEvents", false);
			caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			driver = new InternetExplorerDriver();

		}

		else {
			throw new IllegalArgumentException("The Browser Type is Undefined");
		}

		Thread.sleep(6000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(2, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.navigate().to(URL);
		// Login into Application

		Thread.sleep(4000);
		// test.log(LogStatus.PASS, "Navigated to the specified URL");

		return driver;

	}
  
	private static FirefoxProfile getProfile(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void getScreenShotOnCheckpointFailure(String Methodname) throws IOException {
		TestCaseStatus = false;
		NumberOfFailures++;
		Methodname = Methodname.replace("*", "").replace(":", "").replace(":", "").replace("+", "").replace(" ", "");
		Date date = new Date();
		SimpleDateFormat sdf1 = new SimpleDateFormat("MMMyyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd");
		SimpleDateFormat sdf3 = new SimpleDateFormat("MM-dd-yyyy h-mm-ss a");
		String formattedDate1 = sdf1.format(date);
		String formattedDate2 = sdf2.format(date);
		String formattedDate3 = sdf3.format(date);
		String fileSeperator = System.getProperty("file.separator");

		String folderName1 = formattedDate1;
		String folderName2 = formattedDate2;
		String imagePath1 = System.getProperty("user.dir") + "\\Screenshots\\" + folderName1 + fileSeperator;
		String imagePath2 = System.getProperty("user.dir") + "\\Screenshots\\" + folderName1 + fileSeperator + "\\"
				+ folderName2 + fileSeperator;
		String imagePath3 = System.getProperty("user.dir") + "\\test-output\\AdvanceReport\\Screenshots\\";

		String imageName = Methodname.replace("*", "") + "_CheckpointFailure_" + formattedDate3 + ".jpg";

		File file1 = new File(imagePath1);
		if (!file1.exists()) {
			ExecutionLog.Log("File created " + file1);
			file1.mkdir();

			File file2 = new File(imagePath2);
			if (!file2.exists()) {
				ExecutionLog.Log("File created " + file2);
				file2.mkdir();
			}
		}

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(imagePath2 + imageName));
		FileUtils.copyFile(scrFile, new File(imagePath3 + imageName));
		// logger.attachScreenshot("./Screenshots/"+imageName);
		ExecutionLog.Log("ScreenShot of CheckPoint Failure: " + imagePath2 + imageName);
		Reporter.log("<html><body><a href=\"" + imagePath2 + imageName + "\"><img src=\"file:///" + imagePath2
				+ imageName + "\" alt=\"\"" + "height='120' width='120'/></a> " + "<br></br></html></body>");
		
		ExtentTestManager.getTest().fail("Screenshot",
				MediaEntityBuilder.createScreenCaptureFromPath(imagePath2 + imageName).build());

	}

	public static String getDateStamp() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		return sdf.format(date);
	}

	
	public static void Navigateback() {
		
		driver.navigate().back();
	}
	
public static void NavigateForward() {
	
		
		driver.navigate().forward();;
	}
	
	public static void clickWebelement(WebElement element, String Webelementname) {

		try {
			
			boolean elementIsClickable = element.isEnabled();

			element.click();
			ExecutionLog.Log("Clicked on the '" + Webelementname + "'");
			
			ExtentTestManager.getTest().log(Status.INFO, "Element is clicked "+Webelementname+"");

		} catch (Exception e) {

			ExecutionLog.Log("====Failed==== \"" + Webelementname + "\" field is not present'");
			ExtentTestManager.getTest().log(Status.INFO, "====Failed==== \field is not present'");

			e.printStackTrace();
		}
	}

	public static void sendKeys(WebElement element, String TestData) {

		try {

			element.clear();
			element.sendKeys(TestData);

			ExecutionLog.Log("Entered \"" + TestData + "\" in the field  ");
			
			
		} catch (Exception e) {
			ExecutionLog.Log("Failed in entering " + TestData);
			e.printStackTrace();

		}
	}

	public static void selectDropdownValue(WebElement element, String Selectvalue) throws Exception {
		try {
			Select select = new Select(element);
			select.selectByVisibleText(Selectvalue);
			ExecutionLog.Log("Selected \"" + Selectvalue + " \" drop down");
			
			ExtentTestManager.getTest().log(Status.INFO, "Selected \" "+ Selectvalue + "\" \" drop down");

		} catch (NoSuchElementException e) {
			ExecutionLog.Log("====Failed==== \"" + Selectvalue + "\" is not present in Drop Down");
			ExtentTestManager.getTest().log(Status.INFO, "====Failed==== \" "+ Selectvalue + "\" is not present in Drop Down");
			e.printStackTrace();
		}
	}

	public static void waitMyTime(int i) {
		driver.manage().timeouts().implicitlyWait(i, TimeUnit.SECONDS);

	}

	public static String color(String color, String text) {
		String coloredtext = "<span style=\"color:" + color + ";\">" + text + "</span>";
		return coloredtext;
	}

	public static String getTimeStamp() {
		SimpleDateFormat objSDF = new SimpleDateFormat("dd-MMM-yyyy hh_mm_ss a");
		Calendar cal = Calendar.getInstance();
		String dateTime = objSDF.format(cal.getTime());
		return dateTime;
	}

	public static String Uservalue() {
		String Uservalue = "Automation_Candidate_" + getTimeStamp();

		return Uservalue;
	}

	public static void scrollElementIntoView(String Locator) throws Exception {

		// This try block handles Index out of Bound exception
		try {

			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",
					driver.findElement(ByLocator(Locator)));
		} catch (Exception e) {
			ExecutionLog.Log("Could not Scroll Element in View Range: ");

			e.printStackTrace();
		}

	}

	public static void scrollElementIntoView(WebElement Element) throws Exception {

		// This try block handles Index out of Bound exception
		try {

		} catch (Exception e) {
			ExecutionLog.Log("Could not Scroll Element in View Range: ");

			e.printStackTrace();
		}

	}

	public static void sendkeyswithcleartext(WebElement element, String text) {

		try {

			element.clear();
			element.sendKeys(text);

			ExecutionLog.Log("Entered \"" + text + "\" in the field  ");

		} catch (Exception e) {
			ExecutionLog.Log("Failed in entering " + text);
			e.printStackTrace();

		}

	}

	public static By ByLocator(String locator) {
		By result = null;

		if (locator.startsWith("//")) {
			result = By.xpath(locator);
		} else if (locator.startsWith("css=")) {
			result = By.cssSelector(locator.replace("css=", ""));
		} else if (locator.startsWith("name=")) {
			result = By.name(locator.replace("name=", ""));
		} else if (locator.startsWith("link=")) {
			result = By.linkText(locator.replace("link=", ""));
		} else {
			result = By.id(locator);
		}
		return result;
	}

	public static void sendKeys(String Locator, String TestData, String WebElementNameOfLocator) throws Exception {

		try {

			WebElement elem;
			try {
				elem = driver.findElement(ByLocator(Locator));
				elem.clear();
			} catch (Exception e) {

			}
			elem = driver.findElement(ByLocator(Locator));
			elem.sendKeys(TestData);
			ExecutionLog.Log("Entered \"" + TestData + "\" in field '" + WebElementNameOfLocator + "'");
			ExtentTestManager.getTest().log(Status.INFO,"Entered \"" + TestData + "\" in field '" + WebElementNameOfLocator + "'");

		} catch (AssertionError e) {
			ExecutionLog.Log("====Failed==== \"" + WebElementNameOfLocator + "\" field is not present'"
					+ WebElementNameOfLocator + "'");
			ExtentTestManager.getTest().log(Status.INFO,"====Failed==== \"" + WebElementNameOfLocator + "\" field is not present'"
					+ WebElementNameOfLocator + "'");
			getScreenShotOnCheckpointFailure(WebElementNameOfLocator.replace("*", ""));

			e.printStackTrace();
			;
		}

		catch (Exception e) {
			ExecutionLog.Log("====Failed==== \"" + WebElementNameOfLocator + "\" field is not present'"
					+ WebElementNameOfLocator + "'");
			e.printStackTrace();
			;

		}
	}

	public static void selectDropdownValue(String DropDownLocator, String DropDownLabelName, String DropDownValue)
			throws Exception {

		try {
			Select select = new Select(driver.findElement(ByLocator(DropDownLocator)));
			select.selectByVisibleText(DropDownValue);
			ExecutionLog.Log("Selected \"" + DropDownValue + "\" in \"" + DropDownLabelName + "\" drop down");
			ExtentTestManager.getTest().log(Status.INFO,"Selected \"" + DropDownValue + "\" in \"" + DropDownLabelName + "\" drop down");
		} catch (NoSuchElementException e) {
			ExecutionLog.Log("====Failed==== \"" + DropDownValue + "\" is not present in '" + DropDownLabelName + "Drop Down'");
			ExtentTestManager.getTest().log(Status.INFO,"====Failed==== \"" + DropDownValue + "\" is not present in '" + DropDownLabelName + "Drop Down'");

			getScreenShotOnCheckpointFailure(DropDownValue.replace("*", ""));

			e.printStackTrace();
		}
	}

	public static void clickOn(String Locator, String WebElementNameOfLocator) throws IOException {

		try {

			driver.findElement(ByLocator(Locator)).click();
			ExecutionLog.Log("Clicked on the '" + WebElementNameOfLocator + "'");
			
			ExtentTestManager.getTest().log(Status.INFO,"Clicked on the '" + WebElementNameOfLocator + "'");

		} 
		
		
catch(StaleElementReferenceException e){
			
			driver.findElement(ByLocator(Locator)).click();
			ExecutionLog.Log("Clicked on the '" + WebElementNameOfLocator + "'");
			
			ExtentTestManager.getTest().log(Status.INFO,"Clicked on the '" + WebElementNameOfLocator + "'");
			
		  }
		
catch(UnhandledAlertException e){
			
			acceptAlert();
			ExecutionLog.Log("Clicked on the Alert");
			
			ExtentTestManager.getTest().log(Status.INFO,"Clicked on the Alert");
			
		  }
		catch (ArrayIndexOutOfBoundsException e) {

			try {
				// Click the object if nothing is passed in the clickStatus
				driver.findElement(ByLocator(Locator)).click();
				ExecutionLog.Log("Clicked on the '" + WebElementNameOfLocator + "'");
				
				ExtentTestManager.getTest().log(Status.INFO,"Clicked on the '" + WebElementNameOfLocator + "'");
			}

			catch (Exception e1) {

				ExecutionLog.Log("====Failed==== \"" + WebElementNameOfLocator + "\" field is not present'");
				ExtentTestManager.getTest().log(Status.INFO,"====Failed==== \"" + WebElementNameOfLocator + "\" field is not present'");
				getScreenShotOnCheckpointFailure(WebElementNameOfLocator.replace("*", ""));

				e1.printStackTrace();
			}

		} catch (Exception e) {
			ExecutionLog.Log("====Failed==== \"" + WebElementNameOfLocator + "\" field is not present'");

			getScreenShotOnCheckpointFailure(WebElementNameOfLocator.replace("*", ""));
			e.printStackTrace();

		}
		
		
		
		

	}

	public static String subtract(int years) throws ParseException {

		LocalDate TodayDate = LocalDate.now();

		LocalDate result = TodayDate;

		result = result.plusYears(-years);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM YYYY");
		String formattedString = result.format(formatter);

		return formattedString;
	}

	public static void navigatetourl(String url) {

		driver.navigate().to(url);
	}

	public static void clickUsingJSExecutor(String Locator, String WebElementNameOfLocator) throws IOException {
		try {

			((JavascriptExecutor) driver).executeScript("arguments[0].click(true)",
					driver.findElement(ByLocator(Locator)));
			ExecutionLog.Log("Clicked on the '" + WebElementNameOfLocator + "' using JS Executor");
			
			ExtentTestManager.getTest().log(Status.INFO,"Clicked on the '" + WebElementNameOfLocator + "' using JS Executor");

		} catch (IndexOutOfBoundsException e) {
			try {
				// Click the object if nothing is passed in the clickStatus
				((JavascriptExecutor) driver).executeScript("arguments[0].click()",
						driver.findElement(ByLocator(Locator)));
				ExecutionLog.Log("Clicked on the '" + WebElementNameOfLocator + "' using JS Executor");
				ExtentTestManager.getTest().log(Status.INFO,"Clicked on the '\" + WebElementNameOfLocator + \"' using JS Executor");
			} catch (Exception e1) {
				ExecutionLog.Log("====Failed==== \"" + WebElementNameOfLocator + "\" field is not present'");
				getScreenShotOnCheckpointFailure(WebElementNameOfLocator.replace("*", ""));
				ExtentTestManager.getTest().log(Status.INFO,"====Failed==== \"" + WebElementNameOfLocator + "\" field is not present'");
				e1.printStackTrace();
			}
		} catch (Exception e) {
			ExecutionLog.Log("====Failed==== \"" + WebElementNameOfLocator + "\" field is not present'");
			e.printStackTrace();
		}

	}

	public static void clickUsingJSExecutor(WebElement element, String WebElementNameOfLocator) throws IOException {
		try {

			((JavascriptExecutor) driver).executeScript("arguments[0].click(true)", element);
			ExecutionLog.Log("Clicked on the '" + WebElementNameOfLocator + "' using JS Executor");
			ExtentTestManager.getTest().log(Status.INFO,"Clicked on the '\" "+WebElementNameOfLocator+" \"' using JS Executor");


		} catch (IndexOutOfBoundsException e) {
			
			
			try {
				// Click the object if nothing is passed in the clickStatus
				((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
				ExecutionLog.Log("Clicked on the '" + WebElementNameOfLocator + "' using JS Executor");
			} catch (Exception e1) {
				ExecutionLog.Log("====Failed==== \"" + WebElementNameOfLocator + "\" field is not present'");
				e1.printStackTrace();
			}
		} catch (Exception e) {
			ExecutionLog.Log("====Failed==== \"" + WebElementNameOfLocator + "\" field is not present'");
			
			e.printStackTrace();
		}

	}

	public static void doubleClick(String Locator, String WebElementNameOfLocator) throws Exception {

		try {

			Actions act = new Actions(driver);
			WebElement elem = driver.findElement(ByLocator(Locator));
			act.doubleClick(elem).build().perform();
			ExecutionLog.Log("Double clicked on '" + WebElementNameOfLocator + "'");

		} catch (ArrayIndexOutOfBoundsException e) {
			try {
				Actions act = new Actions(driver);
				WebElement elem = driver.findElement(ByLocator(Locator));
				act.doubleClick(elem).build().perform();
				ExecutionLog.Log("Double clicked on '" + WebElementNameOfLocator + "'");
			} catch (Exception e2) {
				// If the locator is not foundExecutionLog.Log("Could not find the locator: " +
				// WebElementNameOfLocator + "'");
				getScreenShotOnCheckpointFailure(WebElementNameOfLocator.replace("*", ""));

				e.printStackTrace();
				;

			}

		} catch (Exception e) { // If the locator is not found
			ExecutionLog.Log("====Failed==== \"" + WebElementNameOfLocator + "\" field is not present'");

			e.printStackTrace();
		}

	}

	public static void Datepicker(String Monthlocator, String Month, String YearLocator, String Year, String date) {

		try {
			Select select1 = new Select(driver.findElement(ByLocator(Monthlocator)));
			select1.selectByVisibleText(Month);

			Select select2 = new Select(driver.findElement(ByLocator(YearLocator)));

			select2.selectByVisibleText(Year);

			driver.findElement(By.linkText(date)).click();

		} catch (Exception e) {

			ExecutionLog.Log("====Failed====");
			e.printStackTrace();
		}

	}

	public static void selectDropdownValueByIndex(String DropDownLocator, String DropDownLabelName, int indexNumber)
			throws Exception {

		try {
			Select select = new Select(driver.findElement(ByLocator(DropDownLocator)));
			select.selectByIndex(indexNumber);
			ExecutionLog
					.Log("Selected \"" + indexNumber + "\" number's value in \"" + DropDownLabelName + "\" drop down");
		} catch (NoSuchElementException e) {
			ExecutionLog.Log("====Failed==== \"" + indexNumber + "\" number's value is not present in '"
					+ DropDownLabelName + "Drop Down'");
			e.printStackTrace();
		}
	}

	public static Boolean isElementPresent(String Locator) {
	
		boolean flag = false;
		
		List<WebElement> elemList = driver.findElements(ByLocator(Locator));
		if (elemList.size() > 0) {
			flag = true;
		}
		return flag;

	}

	public static Boolean isElementEnable(String Locator) {
		boolean flag = false;
		
	WebElement elem = driver.findElement(ByLocator(Locator));
	
	if (elem.isEnabled()) {
		
		
		return true;
	}	
	
	return flag;

	}

	
	
	public static String getText(String Locator) {
		String text = "==========Failed==========No Text Available on Web Page";
		if (isElementPresent(Locator)) {
			text = driver.findElement(ByLocator(Locator)).getText();
			ExecutionLog.Log("Text is " + text);
		}
		return text;
	}

	public static String getTitle() {
		String text = "";
		text = driver.getTitle();
		ExecutionLog.Log("Text is " + text);

		return text;
	}

	public static void clickTab(String Locator) throws Exception {

		driver.findElement(ByLocator(Locator)).sendKeys(Keys.TAB);

	}

	public static void ZoomOut() throws Exception {

		Robot robot = new Robot();
		System.out.println("About to zoom out");
		for (int i = 0; i < 4; i++) {
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		}

	}

	public static void Zoomin() throws Exception {

		Robot robot = new Robot();
		System.out.println("About to zoom in");
		for (int i = 0; i < 3; i++) {
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ADD);
			robot.keyRelease(KeyEvent.VK_ADD);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		}

	}

	public static void explicitwait(String locator) {

		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.elementToBeClickable(ByLocator(locator)));
	}

	public static void WaitForElementPresent(String locator) throws Exception {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 90);
			wait.until(ExpectedConditions.visibilityOfElementLocated(ByLocator(locator)));
		}

		catch (Exception e) {
			ExecutionLog.Log("===Failed=== Could not find the locator: " + locator);

			e.printStackTrace();
		}

	}

	public static void acceptAlert() throws IOException {
		try {
			try {
				Alert alert = driver.switchTo().alert();
				alert.accept();
				ExecutionLog.Log("Accepted Alert");
			} catch (Exception e) {
				ExecutionLog.Log("=======Passing this Message instead of Exception to avoid PAUSE of execution=====");
				ExecutionLog.Log("Alert was not Present");
			}

		}

		catch (Exception e) {
			try {
				Alert alert = driver.switchTo().alert();
				alert.accept();
				ExecutionLog.Log("Accepted Alert");

			} catch (Exception e2) {
				ExecutionLog.Log("=======Passing this Message instead of Exception to avoid PAUSE of execution=====");
				ExecutionLog.Log("Alert was not Present");
			}
		}

	}

	public static void switchIntoFrame(String LocatorOfFrame) throws IOException {
		try {

			driver.switchTo().defaultContent();
			WebElement frameParent = null;
			if (LocatorOfFrame.startsWith("//")) {
				frameParent = driver.findElement(ByLocator(LocatorOfFrame));
			} else {
				frameParent = driver.findElement(By.cssSelector(LocatorOfFrame));
			}
			driver.switchTo().frame(frameParent.findElement(By.tagName("iframe")));

			// if throwing exception then switch into frame
		} catch (IndexOutOfBoundsException e) {
			try {
				driver.switchTo().defaultContent();
				WebElement frameParent = null;
				if (LocatorOfFrame.startsWith("//")) {
					frameParent = driver.findElement(ByLocator(LocatorOfFrame));
				} else {
					frameParent = driver.findElement(By.cssSelector(LocatorOfFrame));
				}
				driver.switchTo().frame(frameParent.findElement(By.tagName("iframe")));
			} catch (Exception e2) {
				ExecutionLog.Log("====Failed==== \" Could not find the Frame: " + LocatorOfFrame);
				ExecutionLog.Log(e2.getMessage());
			}

		} catch (Exception e1) {
			ExecutionLog.Log("====Failed==== \" Could not find the Frame: " + LocatorOfFrame);
			e1.printStackTrace();
		}

	}

	public static void switchIntoChildFrame(String LocatorOfFrame) throws Exception {
		try {

			WebElement frameParent = null;
			if (LocatorOfFrame.startsWith("//")) {
				frameParent = driver.findElement(ByLocator(LocatorOfFrame));
			} else {
				frameParent = driver.findElement(By.cssSelector(LocatorOfFrame));
			}
			driver.switchTo().frame(frameParent.findElement(By.tagName("iframe")));

			// if throwing exception then switch into frame
		} catch (IndexOutOfBoundsException e) {
			try {
				WebElement frameParent = null;
				if (LocatorOfFrame.startsWith("//")) {
					frameParent = driver.findElement(ByLocator(LocatorOfFrame));
				} else {
					frameParent = driver.findElement(By.cssSelector(LocatorOfFrame));
				}
				driver.switchTo().frame(frameParent.findElement(By.tagName("iframe")));
			} catch (Exception e2) {
				ExecutionLog.Log("====Failed==== \" Could not find the Frame: " + LocatorOfFrame);
				getScreenShotOnCheckpointFailure("FrameSwitchingFailed" + ImageNameForFramesFailures);
				e2.printStackTrace();
				ImageNameForFramesFailures++;
			}

		} catch (Exception e1) {
			ExecutionLog.Log("====Failed==== \" Could not find the Frame: " + LocatorOfFrame);
			getScreenShotOnCheckpointFailure("FrameSwitchingFailed" + ImageNameForFramesFailures);
			e1.printStackTrace();
			ImageNameForFramesFailures++;
		}
	}

	public static void switchOutOfFrame() {
		driver.switchTo().defaultContent();
	}

	public File getLatestFilefromDir(String dirPath){
	    File dir = new File(dirPath);
	    File[] files = dir.listFiles();
	    if (files == null || files.length == 0) {
	        return null;
	    }
	
	    File lastModifiedFile = files[0];
	    for (int i = 1; i < files.length; i++) {
	       if (lastModifiedFile.lastModified() < files[i].lastModified()) {
	           lastModifiedFile = files[i];
	       }
	    }
	    return lastModifiedFile;
	}
	
	public boolean isFileDownloaded(String downloadPath, String fileName) {
		  File dir = new File(downloadPath);
		  File[] dirContents = dir.listFiles();

		  for (int i = 0; i < dirContents.length; i++) {
		      if (dirContents[i].getName().contains(fileName)) {
		          // File has been found, it can now be deleted:
		          //dirContents[i].delete();
		          return true;
		      }
		          }
		      return false;
		  }
	
	public static void WaitForElementToClickable(String locator) throws Exception{
		try {
			WebDriverWait wait = new WebDriverWait(driver,90);
			wait.until(ExpectedConditions.elementToBeClickable(ByLocator(locator)));
		} catch (Exception e) {
			ExecutionLog.Log("Could Not find the element with Locator:" + locator);
			getScreenShotOnCheckpointFailure("WaitForElementIssue" + ScreenshotFailureNumber);	
			e.printStackTrace();	
		}
		
	}

	// This method need to be replaced
	public static void AlertMessage (WebElement Ele, String AlertName) throws IOException {
		WebElement alert = Ele;
		if (alert.isDisplayed()){
			ExecutionLog.Log("Alert message is Pass");
			String Alertmsg = Ele.getText();
			ExecutionLog.Log( Alertmsg);
		}
		else
		{
			ExecutionLog.Log("Alert message is Fail");
			getScreenShotOnCheckpointFailure(AlertName.replace("*", ""));
		}

	}
	
	public static void Enter(){
		
		try {
			Actions act = new Actions(driver);
			act.sendKeys(Keys.ENTER).perform();
			
			
			} catch (Exception e) {
				// TODO: handle exception
			}
	}
	
	public static void verifyTextMatches(String locator, String webElementNameOfLocator, String expected) throws Exception {
		String ActualText ="";
		if(!expected.contains("N/A")){
			if(expected.length()==0){
				try {
					Assert.assertTrue(isElementPresent(locator));
					ActualText = getText(locator);
					if(ActualText.equals("<!---->")) {
						ActualText = "";
					}
					Assert.assertTrue(ActualText.length()==0);
					
					ExtentTestManager.getTest().log(Status.PASS,"Verified that \"" + webElementNameOfLocator + "\" is Blank");
					
				} catch (Exception e) {
					ExtentTestManager.getTest().log(Status.FAIL, "====Failed====\"" + webElementNameOfLocator + "\" is not Present");
					ExecutionLog.Log("====Failed====\"" + webElementNameOfLocator + "\" is not Present");
					getScreenShotOnCheckpointFailure(webElementNameOfLocator.replace("*", ""));
					e.printStackTrace();
				} catch (AssertionError e) {
					ExtentTestManager.getTest().log(Status.FAIL, "====Failed==== Expected value is:["+expected+"] but Actual value is["+ActualText+"]. Please check the screenshot with name: " + webElementNameOfLocator +"for more details");
					ExecutionLog.Log("====Failed==== Expected value is:["+expected+"] but Actual value is ["+ActualText+"]. Please check the screenshot with name: " + webElementNameOfLocator +"for more details" );
					getScreenShotOnCheckpointFailure(webElementNameOfLocator.replace("*", ""));
					e.printStackTrace();
				}
			} else {
				try {
					Assert.assertTrue(isElementPresent(locator));  // Will throw Assertion Error if failed
					ActualText = getText(locator);// Will throw Exception if failed
					Assert.assertTrue(ActualText.contains(expected)); // Will throw Assertion Error if failed
					ExecutionLog.Log ("Verify The data of " + webElementNameOfLocator);
					ExtentTestManager.getTest().log(Status.PASS, "Verified that Expected value :["+expected+"] is matched with Actual value :["+ActualText+"]");
					ExecutionLog.Log ("Verified that Expected value :["+expected+"] is matched with Actual value :["+ActualText+"]");
				}
				catch (AssertionError e) { // To Catch Assertion Error
					ExecutionLog.Log ("Verify The data of " + webElementNameOfLocator);
					ExtentTestManager.getTest().log(Status.FAIL, "====Failed==== Expected value is:["+expected+"] but Actual value is["+ActualText+"]. Please check the screenshot with name: " + webElementNameOfLocator +"for more details" );

					ExecutionLog.Log("====Failed==== Expected value is:["+expected+"] but Actual value is["+ActualText+"]. Please check the screenshot with name: " + webElementNameOfLocator +"for more details" );
					getScreenShotOnCheckpointFailure(webElementNameOfLocator.replace("*", ""));
					e.printStackTrace();
				}
				catch (Exception e) { // To Catch Exception
					ExecutionLog.Log ("Verify The data of " + webElementNameOfLocator);
					ExtentTestManager.getTest().log(Status.FAIL, "====Failed====\"" + webElementNameOfLocator + "\" is not Present" );

					ExecutionLog.Log("====Failed====\"" + webElementNameOfLocator + "\" is not Present");
					getScreenShotOnCheckpointFailure(webElementNameOfLocator.replace("*", ""));
					e.printStackTrace();
				}

			}
		}
	}
	
	public static void verifyElementPresent(String Locator, String NameOfLocator) throws Exception {
		try {
			
				try {
					Assert.assertTrue(isElementPresent(Locator));
					ExtentTestManager.getTest().log(Status.PASS,"\"" + NameOfLocator + "\" is Present");

					ExecutionLog.Log ("\"" + NameOfLocator + "\" is Present");
				} catch (AssertionError e) {
					ExtentTestManager.getTest().log(Status.FAIL,"====Failed==== \""+NameOfLocator+"\"  does not exist.");

					ExecutionLog.Log("====Failed==== \""+NameOfLocator+"\"  does not exist.");
					getScreenShotOnCheckpointFailure(NameOfLocator);
					e.printStackTrace();
				
			}
		} catch (IndexOutOfBoundsException e) {
			try {
				Assert.assertTrue(isElementPresent(Locator));
				ExtentTestManager.getTest().log(Status.PASS,"\"" + NameOfLocator + "\" is Present" );
				ExecutionLog.Log ("\"" + NameOfLocator + "\" is Present");
			} catch (AssertionError e1) {
				ExecutionLog.Log("====Failed==== \""+NameOfLocator+"\"  does not exist.");
				
				ExtentTestManager.getTest().log(Status.FAIL,"====Failed==== \""+NameOfLocator+"\"  does not exist.");

				getScreenShotOnCheckpointFailure(NameOfLocator);
				e1.printStackTrace();
			}
		}

	}

	
	public static void verifyElementEnable(String Locator, String NameOfLocator) throws Exception {
		try {
			
				try {
					Assert.assertTrue(isElementEnable(Locator));
					ExtentTestManager.getTest().log(Status.PASS,"\"" + NameOfLocator + "\" is Enable");

					ExecutionLog.Log ("\"" + NameOfLocator + "\" is Enable");
				} catch (AssertionError e) {
					ExtentTestManager.getTest().log(Status.FAIL,"====Failed==== \""+NameOfLocator+"\"   is disabled.");

					ExecutionLog.Log("====Failed==== \""+NameOfLocator+"\" is disabled.");
					getScreenShotOnCheckpointFailure(NameOfLocator);
					e.printStackTrace();	
			}
				
				
		} catch (IndexOutOfBoundsException e) {
			try {
				Assert.assertTrue(isElementEnable(Locator));
				ExtentTestManager.getTest().log(Status.PASS,"\"" + NameOfLocator + "\" is Present" );
				ExecutionLog.Log ("\"" + NameOfLocator + "\" is Present");
			} catch (AssertionError e1) {
				ExecutionLog.Log("====Failed==== \""+NameOfLocator+"\"  does not exist.");
				
				ExtentTestManager.getTest().log(Status.FAIL,"====Failed==== \""+NameOfLocator+"\"  is disabled.");

				getScreenShotOnCheckpointFailure(NameOfLocator);
				e1.printStackTrace();
			}
		}

	}
	
	
	public static void verifyPagetitle(String PageName, String expected) throws Exception {
		
		
		String ActualText ="";
	
		try {
			  // Will throw Assertion Error if failed
			ActualText = getTitle();// Will throw Exception if failed
			Assert.assertTrue(ActualText.contains(expected)); // Will throw Assertion Error if failed
			ExecutionLog.Log ("Verify The title of Page");
			ExtentTestManager.getTest().log(Status.PASS, "Verified that Expected value :["+expected+"] is matched with Actual value :["+ActualText+"]");
			ExecutionLog.Log ("Verified that Expected Title :["+expected+"] is matched with Actual Title :["+ActualText+"]");
		}
		
		catch (AssertionError e) { // To Catch Assertion Error
			ExecutionLog.Log ("Verify The title of Page");
			ExtentTestManager.getTest().log(Status.FAIL, "====Failed==== Expected value is:["+expected+"] but Actual value is["+ActualText+"]. Please check the screenshot with name: " + PageName +"for more details" );

			ExecutionLog.Log("====Failed==== Expected value is:["+expected+"] but Actual value is["+ActualText+"]. Please check the screenshot with name: " + PageName +"for more details" );
			getScreenShotOnCheckpointFailure(PageName.replace("*", ""));
			e.printStackTrace();
		}
		
		catch (Exception e) { // To Catch Exception
			ExecutionLog.Log ("Verify the title of " + PageName);
			ExtentTestManager.getTest().log(Status.FAIL, "====Failed====\"" + PageName + "\" title is not Present" );

			ExecutionLog.Log("====Failed====\"" + PageName + "\" is not Present");
			getScreenShotOnCheckpointFailure(PageName.replace("*", ""));
			e.printStackTrace();
		}
		
		
	}
	
	public static void moveMouse(String Locator, String WebElementNameOfLocator) {
		Actions act = new Actions(driver);
		WebElement elem = driver.findElement(ByLocator(Locator));
		act.moveToElement(elem).build().perform();
		ExecutionLog.Log("Moved Mouse over '" + WebElementNameOfLocator + "'");
	}
	
	  @AfterSuite
	  
	  public static void closebrowser() throws AddressException {
	  
	  SendMail.sendmaiwithattachment(); }
	  
	 

}
