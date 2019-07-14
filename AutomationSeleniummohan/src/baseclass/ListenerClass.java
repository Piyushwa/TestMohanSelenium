
package baseclass;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.relevantcodes.extentreports.LogStatus;

import utilities.ExecutionLog;

public class ListenerClass extends DriverHelper implements ITestListener {

	// Called before every Test Method

	@Override
	public void onTestStart(ITestResult tr) {

		try {
		
			ExtentTestManager.startTest(tr.getMethod().getMethodName());
			
			ExecutionLog.Log(
					"*********************Started Executing '" + tr.getName() + "' Test Case*********************");
				

		}

		catch (Exception ex) {
			ExecutionLog.Log("The Browser was not opened due to following reason :");
			ex.printStackTrace();
		}
	}

@Override


public void onTestSuccess(ITestResult tr) {
	ExtentTestManager.getTest().log(Status.PASS, "Test '" + tr.getName() + "' PASSED");
  ExecutionLog.Log("Test '" + tr.getName() + "' PASSED");
  
  try { 
  ExecutionLog.Log("Closed the Browser");
  
  
  } 
  
  
  catch (Exception e) { 
	  
	  // TODO: handle exception
  }
  

	}

@Override 
	
public void onTestFailure(ITestResult tr) { String testCaseName =
  tr.getName(); ExecutionLog.Log("Test '" + testCaseName + "' FAILED");
  
  ExecutionLog.Log(tr.getStatus()+""); String methodName = tr.getName();
  ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");
  Date date = new Date(); SimpleDateFormat sdf1 = new
  SimpleDateFormat("MMMyyyy"); SimpleDateFormat sdf2 = new
  SimpleDateFormat("dd"); SimpleDateFormat sdf3 = new
  SimpleDateFormat("MM-dd-yyyy h-mm-ss a"); String formattedDate1 =
  sdf1.format(date); String formattedDate2 = sdf2.format(date); String
  formattedDate3 = sdf3.format(date); String fileSeperator =
  System.getProperty("file.separator");
  
  String folderName1= formattedDate1; String folderName2= formattedDate2;
  String imagePath1 = System.getProperty("user.dir")+"\\Screenshots\\"+
  folderName1+fileSeperator; String imagePath2 =
 
  System.getProperty("user.dir")+"\\Screenshots\\"+ folderName1+fileSeperator+"\\"+folderName2+fileSeperator;
  
  
  String imageName=methodName+"_"+formattedDate3+".jpg";
  
  File file1 = new File(imagePath1); if (!file1.exists()) {
  ExecutionLog.Log("File created " + file1); file1.mkdir();
  
  File file2 = new File(imagePath2); if (!file2.exists()) {
  ExecutionLog.Log("File created " + file2); file2.mkdir(); } }
  
  File scrFile = ((TakesScreenshot) driver) .getScreenshotAs(OutputType.FILE);
  try { 
	  
	  FileUtils.copyFile(scrFile, new File(imagePath2 + imageName));
	  
  System.out.println("ScreenShot of TestMethod Failure: " +imagePath2+imageName); 
  Reporter.log("<html><body><a href=\""+ imagePath2+imageName +"\"><img src=\"file:///" + imagePath2+imageName + "\" alt=\"\""+ "height='120' width='120'/></a> "+"<br></br></html></body>");
  ExecutionLog.Log("Test Case :" + testCaseName +"'s Screenshot of Failure Page: \n" + imagePath2 + imageName); }
  
  catch
  (IOException e) {
  ExecutionLog.Log("Could not take the Screenshot of Test Case '" +
  testCaseName + "'s at failure point due to:" + imagePath2 + imageName);
  e.printStackTrace(); } try
  {
	  try { 
		  
		  Alert alert = driver.switchTo().alert();
  alert.accept(); ExecutionLog.
  Log("==================Fail============ The Test Method left an Alert at the End of execution of the Test Case"
  );
  
  } catch (Exception e) {
	  
	  
	  // TODO: handle exception
	  
  } 
  

  
  ExecutionLog.Log("Closed the Browser"); } 
  
  catch (Exception e) { 
	  // TODO:handle exception 
  }
  
  
  try {
		ExtentTestManager.getTest().fail("Screenshot",
				MediaEntityBuilder.createScreenCaptureFromPath(imagePath2 + imageName).build());
	} catch (IOException e) {
		ExecutionLog.Log("An exception occured while taking screenshot " +e.getCause());
	}
	ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");
  
  }

	@Override public void onTestSkipped(ITestResult tr) {
  ExecutionLog.Log("*****Test '" + tr.getName() + "'*****: SKIPPED"); try {
  driver.quit(); ExecutionLog.Log("Closed the Browser"); } 
  
  catch (Exception e)
  { // TODO: handle exception } 
	  
  }
  }

	@Override
	public void onFinish(ITestContext arg0) {
		
		ExtentTestManager.endTest();
		ExtentManager.getInstance().flush();	

	}

	// Called before the start of <Test> Tag in TestNG.xml file

	@Override
	public void onStart(ITestContext arg0) {

		ExecutionLog.Log("Client: " + ClientName);
		ExecutionLog.Log("*********************Started Executing the Test Area(Modules/TAB): '" + arg0.getName()
				+ "'*********************");
	

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		
		// TODO Auto-generated method stub

	}

	@AfterSuite
	public void getDetails() {

	}

}
