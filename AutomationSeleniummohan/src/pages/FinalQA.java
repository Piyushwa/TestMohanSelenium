package pages;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import baseclass.DriverHelper;
import locators.InternalLocators;
import utilities.DatabaseConnectivity;
import utilities.ExecutionLog;
import utilities.ReadWriteExcel;

public class FinalQA extends DriverHelper implements InternalLocators{
	
	WebDriver driver;

	public static String SheetPath = System.getProperty("user.dir")+"\\TestData\\InputFile.xlsx";
//public static String FirstNamevalue = LevelFirstNamevalue;
	//public static String FirstNamevalue = "Automation_Candidate_02-May-2019 11:34:49 AM";
			
	public FinalQA(WebDriver driver) {

		this.driver = driver;
		
}
	
	public boolean FinalQAaction() throws InterruptedException, Exception {
		
		ReadWriteExcel.setExcelFile(SheetPath, "FinalQA");

		String FinalQANotes = ReadWriteExcel.getCellDataString(3, "B");
		
		String Comments = ReadWriteExcel.getCellDataString(4, "B");
	
		String CaseIDquery = "select case_id, * from candidate_master where first_name = '"+LevelFirstNamevalue+"'";

		System.out.println(CaseIDquery);

		String CaseID = DatabaseConnectivity.selectStringQueryforcolumn(CaseIDquery, "case_id");

		System.out.println(CaseID);

		navigatetourl(URL);

		login lg = new login(driver);
		lg.loggedin("Piyush_team", "V_q!GE[HeH");

	

		clickOn(loc_FinalQAindex, "FinalQAHome");
		
		
		String loc_FinalQACase = "//a[@href ='/SeniorSup/supQA?caseId="+CaseID+"']";
		
		
		clickOn(loc_FinalQACase, "Final QA on Case");
		
		sendKeys(loc_FinalQAComments,FinalQANotes , "FinalQAComments");
			
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		
		clickOn(loc_FinalQASaveAll, "FinalSaveAll");

		Thread.sleep(2000);
		
		clickOn(loc_FinalQASubmit, "FinalQASubmit");
		
		Thread.sleep(2000);

		String loc_FinalReportDownload = "//a[@href='/Home/getReports?caseId="+CaseID+"']";
		
		Thread.sleep(2000);

		String winHandleBefore = driver.getWindowHandle();
		
		clickOn(loc_FinalReportDownload, "FinalReportDownload");
			
		Set<String> handles =  driver.getWindowHandles();
				
		   for(String windowHandle  : handles)
		       {
		       if(!windowHandle.equals(winHandleBefore))
		          {
		          driver.switchTo().window(windowHandle);
		          
		          driver.manage().window().maximize();
		        
		clickOn(loc_WordfinalReport, " Download Word final report");          
		          
		driver.close(); 
		         
		         
		         driver.switchTo().window(winHandleBefore); 
		          }
		       }

		   
		   Thread.sleep(6000);
		   
  Boolean FinalReprtStatus =   isFileDownloaded(downloadPath, LevelFirstNamevalue);
  
  
  System.out.println(LevelFirstNamevalue);

  System.out.println(FinalReprtStatus);
   
	return FinalReprtStatus;
		}
		

	
		
	}
	


