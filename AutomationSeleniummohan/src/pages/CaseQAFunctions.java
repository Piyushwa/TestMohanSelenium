package pages;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import baseclass.DriverHelper;
import locators.InternalLocators;
import utilities.DatabaseConnectivity;
import utilities.ExecutionLog;

public class CaseQAFunctions extends DriverHelper implements InternalLocators {

	WebDriver driver;

	public static String SheetPath = System.getProperty("user.dir") + "\\TestData\\InputFile.xlsx";
	//public static String FirstNamevalue =  LevelFirstNamevalue;

	//public static String FirstNamevalue = "Automation_Candidate_06-May-2019 11:07:29 AM";
			


	public CaseQAFunctions(WebDriver driver) {

		this.driver = driver;

	}

	public void CaseQAaction() throws InterruptedException, Exception {

		String CaseIDquery = "select case_id, * from candidate_master where first_name  ='" + LevelFirstNamevalue +"'";

		System.out.println(CaseIDquery);

		String CaseID = DatabaseConnectivity.selectStringQueryforcolumn(CaseIDquery, "case_id");

		System.out.println(CaseID);

		navigatetourl(URL);

		login lg = new login(driver);
		
		lg.loggedin("Piyush_team", "V_q!GE[HeH");

		clickOn(loc_caseQAindex, "CaseQAHome");

		String loc_CaseQAActiononCase = "//a[@href='/CaseQA/caseQAcaseAction?caseId=" + CaseID + "']";

		clickOn(loc_CaseQAActiononCase, "Case QA Action");

		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");

		clickOn(loc_CaseQASubmitcase, "Case QA Action");
		ExecutionLog.Log("*************************CaseQA action is Completed*************************");
	}
	
	
}
