package pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import baseclass.DriverHelper;
import locators.InternalLocators;
import utilities.DatabaseConnectivity;
import utilities.ExecutionLog;
import utilities.ReadWriteExcel;

public class TaskQAFunctions extends DriverHelper implements InternalLocators {

	WebDriver driver;
	public static String SheetPath = System.getProperty("user.dir") + "\\TestData\\InputFile.xlsx";
	//public static String FirstNamevalue =  LevelFirstNamevalue;

	//public static String FirstNamevalue = "Automation_Candidate_06-May-2019 11:07:29 AM";
			
	

	public TaskQAFunctions(WebDriver driver) {

		this.driver = driver;
	}

	public void TaskQAaction() throws InterruptedException, Exception {

		ReadWriteExcel.setExcelFile(SheetPath, "Analyst");

		String NoteValue = ReadWriteExcel.getCellDataString(3, "B");
		String executivesummary = ReadWriteExcel.getCellDataString(4, "B");

		navigatetourl(URL);

		login lg = new login(driver);

		lg.loggedin("Piyush_team", "V_q!GE[HeH");

		ReadWriteExcel.setExcelFile(SheetPath, "CandidateRegistration");

		// String FirstNamevalue = ReadWriteExcel.getCellDatawithoutformula(7, 2);

		String CaseIDquery = "select case_id, * from candidate_master where first_name  = '" + LevelFirstNamevalue + "'";
		System.out.println(CaseIDquery);
		String CaseID = DatabaseConnectivity.selectStringQueryforcolumn(CaseIDquery, "case_id");
		System.out.println(CaseID);

		String checkIDquery = "select check_id from check_master where case_id ='" + CaseID
				+ "' and status = 'Submitted'";
		System.out.println(checkIDquery);

		List<String> checkids = DatabaseConnectivity.selectQueryforcolumn(checkIDquery, "check_id");

		Thread.sleep(3000);

		clickOn(loc_QAindex, "TaskQA");

		Thread.sleep(5000);

		ExecutionLog.Log("Number of Task for QA " + checkids.size());

		for (int i = 0; i < checkids.size(); i++) {

			String checkid = checkids.get(i);

			String loc_QACheck = "//a[@href='/QA/checkQA?checkID=" +checkid+"&redirectfrom=Index']";

			getText(loc_QACheck);

			clickOn(loc_QACheck, "QA Action on Check");

			/*
			 * sendKeys(loc_eduexecutivesummary, NoteValue, "QA Notes");
			 * 
			 * sendKeys(loc_QAchecknotes, executivesummary, "QA Executive Summary");
			 */

			((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
			Thread.sleep(3000);
			
			clickOn(loc_QASubmitcheck, "QA Check");

		}
		
		ExecutionLog.Log("*************************TaskQA action is Completed*************************");

	}

}