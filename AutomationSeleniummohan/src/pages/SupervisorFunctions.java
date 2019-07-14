package pages;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import baseclass.DriverHelper;
import locators.CommonLocators;
import locators.InternalLocators;
import utilities.DatabaseConnectivity;
import utilities.ExecutionLog;
import utilities.ReadWriteExcel;

public class SupervisorFunctions extends DriverHelper implements CommonLocators, InternalLocators {

	WebDriver driver;

	public static String SheetPath = System.getProperty("user.dir") + "\\TestData\\InputFile.xlsx";
	
	//public static String FirstNamevalue =  LevelFirstNamevalue;

	//public static String FirstNamevalue =  "Automation_Candidate_21-May-2019 10_36_49 AM";
			

	public SupervisorFunctions(WebDriver driver) {

		this.driver = driver;

	}

	public void Supervisoraction() throws InterruptedException, Exception {

		ReadWriteExcel.setExcelFile(SheetPath, "CandidateRegistration");

		// String FirstNamevalue = ReadWriteExcel.getCellDatawithoutformula(7, 2);

		ReadWriteExcel.setExcelFile(SheetPath, "Supervisor");

		String AnalystName = ReadWriteExcel.getCellData(3, 2);
		String SupervisorNotes = ReadWriteExcel.getCellData(4, 2);

		navigatetourl(URL);

		login lg = new login(driver);

		lg.loggedin("Piyush_team", "V_q!GE[HeH");

		clickOn(loc_supnavigationtab, "supnavigation");

		clickOn(loc_supnewcases, "New Case");

		String CaseIDquery = "select case_id, * from candidate_master where first_name  = '" + LevelFirstNamevalue + "'";
		String CaseID = DatabaseConnectivity.selectStringQueryforcolumn(CaseIDquery, "case_id");
		System.out.println(CaseID);
		String loc_Actiononcase = "//a[@href='/Sup/caseAction?caseID=" + CaseID + "&redirectfrom=New%20cases']";

		clickOn(loc_Actiononcase, "Action on case");

		List<WebElement> AllStops = driver.findElements(By.xpath("//*[@id='currentChecks']/tbody/tr/td[10]"));

		List<WebElement> Allchecks1 = driver.findElements(By.xpath("//*[@id='currentChecks']/tbody/tr/td[1]"));

		for (int i = 1; i < AllStops.size(); i++) {
			List<WebElement> Allchecks2 = driver.findElements(By.xpath("//*[@id='currentChecks']/tbody/tr/td[1]"));

			String checkname = Allchecks2.get(i).getText();

			ExecutionLog.Log(checkname);


			if (!checkname.contains("Financial") && !checkname.contains("EMP") && !checkname.contains("EDU")
					&& !checkname.contains("PRO") && !checkname.contains("REF") && !checkname.contains("Address"))

			{
				String loc_Stop = "//*[@id='currentChecks']/tbody/tr[" + (i + 1) + "]/td[10]/a";

				Thread.sleep(3000);

				clickOn(loc_Stop, "Stop");
				Thread.sleep(3000);
			}

		}

		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");

		Thread.sleep(3000);

		selectDropdownValue(loc_Assignalltoonealayst, "Assignalltoonealayst", AnalystName);

		clickOn(loc_AssignAllButton, "AssignAllButton");

		sendKeys(loc_SupervisorNotes, SupervisorNotes, "SupervisorNotes");
		waitMyTime(6);

		clickOn(loc_Update, "Update");

		ExecutionLog.Log("*************************Supervisor action is completed*************************");
	}

	
	public String verifysupervisoraction() throws Exception

	{

		ReadWriteExcel.setExcelFile(SheetPath, "CandidateRegistration");

		navigatetourl(URL);

		login lg = new login(driver);

		lg.loggedin("Piyush_team", "V_q!GE[HeH");

		clickOn(loc_supnavigationtab, "supnavigation");

		clickOn(loc_supOngoingcase, "On Going Case");

		String CaseIDquery = "select case_id, * from candidate_master where first_name  = '" + LevelFirstNamevalue + "'";

		System.out.println(CaseIDquery);

		String CaseID = DatabaseConnectivity.selectStringQueryforcolumn(CaseIDquery, "case_id");

		System.out.println(CaseID);

		String casetoverify = "//a[contains(text(),'" + CaseID + "')]";

		String SupCompleteCase_Name = getText(casetoverify);
		
		return SupCompleteCase_Name;


	}
	
	
	
	public String SupcompletedCase() throws InterruptedException, Exception {
		
		ReadWriteExcel.setExcelFile(SheetPath, "CandidateRegistration");

		navigatetourl(URL);

		login lg = new login(driver);

		lg.loggedin("Piyush_team", "V_q!GE[HeH");

		clickOn(loc_supnavigationtab, "supnavigation");

		clickOn(loc_supcomletedcase, "Completed Case");	
		
		String CaseIDquery = "select case_id, * from candidate_master where first_name  = '"+LevelFirstNamevalue+"'";

		String CaseID = DatabaseConnectivity.selectStringQueryforcolumn(CaseIDquery, "case_id");

		String Completedcasetoverify = "//a[contains(text(),'"+CaseID+"')]";
		
		String CompletedCase_Name = getText(Completedcasetoverify);
		
		ExecutionLog.Log("Completed Case Name " +CompletedCase_Name);
		
	String CompletedCasestatus =  getText(loc_SupCompletedCaseStatus);
	

	String completedTracksHistory = "//a[@href='/Sup/trackHistory?caseID="+CaseID+"']";
	

	
	String completedActivityHistory = "//a[@href='/Sup/activityHistory?caseID="+CaseID+"']";

	clickOn(completedTracksHistory, "Track History");
		
Navigateback();

clickOn(completedActivityHistory, "Activity History");

Navigateback();



	return CompletedCasestatus;
	
	
}
		
	
	public String  actionarchivecase() throws Exception {
		

		clickOn(loc_supnavigationtab, "supnavigation");

		clickOn(loc_supcomletedcase, "Completed Case");	
		
		String CaseIDquery = "select  * from candidate_master where first_name  = '"+LevelFirstNamevalue+"'";

		String CaseID = DatabaseConnectivity.selectStringQueryforcolumn(CaseIDquery, "case_id");
		
		String Candidate_ID = DatabaseConnectivity.selectStringQueryforcolumn(CaseIDquery, "Candidate_ID");

	
		String loc_ActionArchive = "//tr[@class='"+CaseID+" altOdd']//a[contains(text(),'Archive')]";
		
		String loc_Archiveentity = "//a[@href='/Sup/candidateProfile?candidateID="+Candidate_ID+"']";


		clickOn(loc_ActionArchive, "Archive Case");

		Thread.sleep(3000);
		
		acceptAlert();
		
		Thread.sleep(2000);

		clickOn(loc_supnavigationtab, "supnavigation");
		
		clickOn(loc_SupArchivedCase, "supnavigation");
		
		return loc_Archiveentity;

		
	}


public void Casesearch(String filtervalue, String filtertext) throws Exception {
	

	selectDropdownValue(loc_CaseserachFiltervalue, "Search Category",filtervalue );
	
	Thread.sleep(2000);

	
	sendKeys(loc_Caseserachfiltertext, filtertext, "FilterValue");
	
	clickOn(loc_Caseserachfiltersubmit, "Case Search Submit");
	
	Thread.sleep(3000);

	
	
	
}

public void ClientSettingsfind(String ClinetName, String Packagename) throws Exception {
	
	selectDropdownValue(loc_ClientName, "Client Name", ClinetName);
	 
	Thread.sleep(2000);
	
 selectDropdownValue(loc_CSpackagename, "Package Name", Packagename);

 clickOn(loc_Finddetails, "Find Details Button");
 
	Thread.sleep(2000);
	
	getText(loc_firstcheckname);
	
	sendKeys(loc_CScomment, ClinetName, "Sup Comments");


	clickOn(loc_CScommentSave, "Save Comments");
	Thread.sleep(2000);

	
	acceptAlert();

	
	
}
		
public void Customeditfilter(String FilterName, String filtertext) throws Exception {
	

	if (FilterName.equalsIgnoreCase("FirstName")) {

		clickOn(loc_CueditFirstnamecheck, "FirstNameCheckBox");

		sendKeys(loc_CustEditName, filtertext, "FilterTextValue");

		clickOn(loc_CuEditSearchbutton, "SearchButton");
		
		Thread.sleep(3000);

	}

	else if (FilterName.equalsIgnoreCase("MiddleName")) {

		clickOn(loc_CueditMiddlenamecheck, "Ref No");

		sendKeys(loc_CustEditMiddleName, filtertext, "FilterTextValue");

		clickOn(loc_CuEditSearchbutton, "SearchButton");
		
		Thread.sleep(2000);
	}

	else if (FilterName.equalsIgnoreCase("LastName")) {

		clickOn(loc_CueditLastnamecheck, "Employee ID");

		sendKeys(loc_CustEditLastName, filtertext, "FilterTextValue");

		clickOn(loc_CuEditSearchbutton, "SearchButton");
		Thread.sleep(2000);

	}

	else if (FilterName.equalsIgnoreCase("RefNo")) {

		clickOn(loc_CueditRefnocheck, "Cost Center");
		sendKeys(loc_CustEditRefNo, filtertext, "FilterTextValue");

		clickOn(loc_CuEditSearchbutton, "SearchButton");
		Thread.sleep(2000);

	}
	
	
}


public void Manageuserfilter(String FilterName, String filtertext) throws Exception {
	

	if (FilterName.equalsIgnoreCase("UserName")) {

		clickOn(loc_UserNamecheck, "FirstNameCheckBox");

		sendKeys(loc_MUSearchBox, filtertext, "FilterTextValue");

		clickOn(loc_MUsearchbutton, "SearchButton");
		
		Thread.sleep(3000);

	}

	else if (FilterName.equalsIgnoreCase("UserEmail")) {

		clickOn(loc_UserEmailcheck, "Ref No");

		sendKeys(loc_MUSearchBox, filtertext, "FilterTextValue");

		clickOn(loc_MUsearchbutton, "SearchButton");
		
		Thread.sleep(2000);
	}

	else if (FilterName.equalsIgnoreCase("ClientName")) {

		clickOn(loc_ClientNamecheck, "Employee ID");

		sendKeys(loc_MUSearchBox, filtertext, "FilterTextValue");

		clickOn(loc_MUsearchbutton, "SearchButton");
		Thread.sleep(2000);

	}


	
}

public void Transferredtask(String Clientname, String AnalystName, String Status) throws Exception {
	
	selectDropdownValue(loc_SupTTClientname, "Client Name", Clientname);
	
	selectDropdownValue(loc_SupTTAnalyst, "Analyst Name", AnalystName);
	
	selectDropdownValue(loc_SupTTStatus, "Status", Status);
	
	Thread.sleep(2000);

	clickOn(loc_SupTTSearchbutton, "Search Button");
}

public void IITaskFilter(String ClinetName, String AnalystName) throws Exception {
	
	selectDropdownValue(loc_IIClientName, "Client Name", ClinetName);
	 
	Thread.sleep(2000);
	
 selectDropdownValue(loc_IIAnalystName, "Analyst Name", AnalystName);

 clickOn(loc_IISearch, "Search Button");
 
	Thread.sleep(2000);
	
	}


public void GenerateSupStatistcis() throws IOException {
	
	
	clickOn(loc_SupStatSearch, "Statistics Search");
	
	
	
	
}
		
	}

