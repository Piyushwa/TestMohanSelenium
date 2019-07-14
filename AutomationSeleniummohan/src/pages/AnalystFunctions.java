package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import baseclass.DriverHelper;
import locators.CommonLocators;
import locators.InternalLocators;
import utilities.DatabaseConnectivity;
import utilities.ExecutionLog;
import utilities.ReadWriteExcel;

public class AnalystFunctions extends DriverHelper implements CommonLocators, InternalLocators {


	//public static String FirstNamevalue = LevelFirstNamevalue;

	//public static String FirstNamevalue = "Automation_Candidate_13-May-2019 06_50_41 PM";
	
	static WebDriver driver;
	
	public static String SheetPath = System.getProperty("user.dir") + "\\TestData\\InputFile.xlsx";

	public AnalystFunctions(WebDriver driver) {

		AnalystFunctions.driver = driver;

	}

	public  void employmentcheck() throws Exception {
		ReadWriteExcel.setExcelFile(SheetPath, "Analyst");

		String NoteValue = ReadWriteExcel.getCellDataString(3, "B");
		String executivesummary = ReadWriteExcel.getCellDataString(4, "B");
		String Infringement = ReadWriteExcel.getCellDataString(5, "B");
		String disciplinary = ReadWriteExcel.getCellDataString(6, "B");
		String rehire = ReadWriteExcel.getCellDataString(7, "B");
		String VerifiedBy = ReadWriteExcel.getCellDataString(9, "B");
		String ContactDetails = ReadWriteExcel.getCellDataString(10, "B");
		String VerifiedDate = ReadWriteExcel.getCellDataString(11, "B");
		String CompanyName = ReadWriteExcel.getCellDataString(12, "B");


		sendKeys(loc_empcheckActionnotes, NoteValue, "empchecknotes");

		scrollElementIntoView(loc_analystempactivity);

		Thread.sleep(3000);
		clickOn(loc_analystempactivity, "Search Entity");

		Thread.sleep(3000);

		acceptAlert();

		scrollElementIntoView(loc_analystempactivity);

		clickOn(loc_empresponsereceived, "EmpResponseRecieved");

		// scrollElementIntoView(loc_analystempwritereport);

		Thread.sleep(3000);

		//explicitwait(loc_analystempwritereport);

		clickOn(loc_analystempwritereport, "Write Report");

		sendKeys(loc_executivesummary, executivesummary, "executivesummary");
		sendKeys(loc_empreportnotes, NoteValue, "Notes");
		sendKeys(loc_companynameemp, NoteValue, "companynameComment");
		sendKeys(loc_countryemp, CompanyName, "Country Comment");
		sendKeys(loc_jobtitleemp, CompanyName, "Job Title Comment");
		sendKeys(loc_corptitleemp, CompanyName, "Corp Title Comment");
		sendKeys(loc_empperiodemp, CompanyName, "Emp Period Comment");
		sendKeys(loc_suptitleemp, CompanyName, "Sup Title Comment");
		sendKeys(loc_fixedsalaryemp, CompanyName, "Fixed Salary Comment");
		sendKeys(loc_renumemp, CompanyName, "Renumeration Comment");
		sendKeys(loc_reasondeptureemp, CompanyName, "Reason of Dept Comment");

		scrollElementIntoView(loc_Infringement);

		sendKeys(loc_Infringement, Infringement, "Infringement");

		sendKeys(loc_disciplinary, disciplinary, "disciplinary");

		sendKeys(loc_rehire, rehire, "rehire");
		
		selectEmpcheckPerformance("1");

		sendKeys(loc_addcomment, executivesummary, "Additional Comment");

		sendKeys(loc_commentby, VerifiedBy, "Commented By ");

		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");

		sendKeys(loc_verifiedby, VerifiedBy, "VerifiedBy");
		sendKeys(loc_contactdetails, ContactDetails, "ContactDetails");
		//sendKeys(loc_verifieddate, VerifiedDate, "VerifiedDate");
		Enter();
		clickOn(loc_savebtn, "Save");

		Thread.sleep(2000);

		clickOn(loc_submitbtn, "Submit");

		acceptAlert();

		Thread.sleep(3000);

		clickOn(loc_InProgressTab, "InProgressTab");

	}

	public  void dbcheck() throws Exception {

		ReadWriteExcel.setExcelFile(SheetPath, "Analyst");
		String DBNoteValue = ReadWriteExcel.getCellDataString(3, "V");

		String executivesummary = ReadWriteExcel.getCellDataString(4, "B");
		
		sendKeys(loc_empcheckActionnotes, DBNoteValue, "empchecknotes");


		clickOn(loc_analystempwritereport, "Write Report");

		sendKeys(loc_dbexesummary, executivesummary, "executivesummary");
		sendKeys(loc_dbnote, DBNoteValue, "Db Note");

		driver.switchTo().frame(0);

		sendKeys(loc_bodyframe, executivesummary, "Description");

		switchOutOfFrame();

		scrollElementIntoView(loc_savebtn);

		clickOn(loc_savebtn, "Save");
		Thread.sleep(3000);

		clickOn(loc_submitbtn, "Submitbtn");

		acceptAlert();
		Thread.sleep(3000);

		clickOn(loc_InProgressTab, "InProgressTab");

	}

	public  void educheck() throws Exception {

		ReadWriteExcel.setExcelFile(SheetPath, "Analyst");

		String EduNoteValue = ReadWriteExcel.getCellDataString(15, "F");
		String executivesummary = ReadWriteExcel.getCellDataString(4, "B");
		String Remark = ReadWriteExcel.getCellDataString(8, "B");
		String ProgrammeType = ReadWriteExcel.getCellDataString(8, "F");
		String VerifiedBy = ReadWriteExcel.getCellDataString(9, "B");
		String ContactDetails = ReadWriteExcel.getCellDataString(10, "B");
		String VerifiedDate = ReadWriteExcel.getCellDataString(11, "B");
	
		String ModeofStudy = ReadWriteExcel.getCellDataString(14, "F");

		sendKeys(loc_empcheckActionnotes, EduNoteValue, "empchecknotes");
		scrollElementIntoView(loc_analystempactivity);
		Thread.sleep(3000);
		clickOn(loc_analystempactivity, "Search Entity");
		Thread.sleep(3000);
		acceptAlert();
		scrollElementIntoView(loc_analystempactivity);
		
		clickOn(loc_empresponsereceived, "EmpResponseRecieved");
		Thread.sleep(3000);
		
		clickUsingJSExecutor(loc_analystempwritereport, "Write Report");
		//clickOn(loc_analystempwritereport, "Write Report");

		sendKeys(loc_executivesummary, executivesummary, "executivesummary");

		sendKeys(loc_empreportnotes, EduNoteValue, "Notes");

		sendKeys(loc_eduinsititute, ProgrammeType, "Institute Comment");
		sendKeys(loc_educountry, ProgrammeType, "Education Country");
		sendKeys(loc_eduqualification, ProgrammeType, "Qualification Comment");
		sendKeys(loc_eduattendancedate, ProgrammeType, "Attendance Comment");
		sendKeys(loc_edugraddate, ProgrammeType, "Graduate Date Comment");
		sendKeys(loc_eduprogtype, ProgrammeType, "Programme Type Comment");
		sendKeys(loc_eduexternal, ProgrammeType, "external/long-distance programme Comment");
		sendKeys(loc_eduexternalcountry, ProgrammeType, "Country of Stay while study");
		sendKeys(loc_eduaccrestatus, ProgrammeType, "Accreditation Status Commnet");

		sendKeys(loc_eduaccreorg, ProgrammeType, "Accreditation Organization Comment");
		sendKeys(loc_edusource, ProgrammeType, "Source Comment");
		
		scrollElementIntoView(loc_verifiedby);

		selectDropdownValue(loc_edustudymode, "Study Mode", ModeofStudy);

		/*
		 * switchIntoFrame(loc_Remarkframe);
		 * 
		 * sendKeys(loc_eduremarks, Remark, "Remark"); switchOutOfFrame();
		 */
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(3000);

		sendKeys(loc_verifiedby, VerifiedBy, "VerifiedBy");
		sendKeys(loc_contactdetails, ContactDetails, "ContactDetails");
		//sendKeys(loc_verifieddate, VerifiedDate, "VerifiedDate");
Enter();
		clickOn(loc_savebtn, "Save");

		Thread.sleep(2000);

		clickOn(loc_submitbtn, "Submit");
		acceptAlert();
		Thread.sleep(3000);
		clickOn(loc_InProgressTab, "InProgressTab");

	}

	public  void professionalcheck() throws Exception {

		ReadWriteExcel.setExcelFile(SheetPath, "Analyst");

		String PRONoteValue = ReadWriteExcel.getCellDataString(3, "N");
		String executivesummary = ReadWriteExcel.getCellDataString(4, "B");
		String VerifiedBy = ReadWriteExcel.getCellDataString(9, "B");
		String ContactDetails = ReadWriteExcel.getCellDataString(10, "B");
		String VerifiedDate = ReadWriteExcel.getCellDataString(11, "B");

		sendKeys(loc_empcheckActionnotes, PRONoteValue, "empchecknotes");

		scrollElementIntoView(loc_analystempactivity);

		Thread.sleep(3000);
		clickOn(loc_analystempactivity, "Search Entity");
		Thread.sleep(3000);
		acceptAlert();
		scrollElementIntoView(loc_analystempactivity);
		clickOn(loc_empresponsereceived, "EmpResponseRecieved");
		// scrollElementIntoView(loc_analystempwritereport);
		//explicitwait(loc_analystempactivity);
		Thread.sleep(6000);
		clickOn(loc_analystempwritereport, "Write Report");
		sendKeys(loc_executivesummary, executivesummary, "executivesummary");
		sendKeys(loc_empreportnotes, PRONoteValue, "Notes");

		Thread.sleep(3000);

		sendKeys(loc_verifiedBy, VerifiedBy, "VerifiedBy");
		sendKeys(loc_contactdetails, ContactDetails, "ContactDetails");
		//sendKeys(loc_verifieddate, VerifiedDate, "VerifiedDate");
		Enter();
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		clickOn(loc_savebtn, "Save");

		Thread.sleep(3000);
		clickOn(loc_submitbtn, "Submit");
		acceptAlert();
		Thread.sleep(3000);
		clickOn(loc_InProgressTab, "InProgressTab");

	}

	public  void professionalreference() throws Exception {
		ReadWriteExcel.setExcelFile(SheetPath, "Analyst");

		String REFNoteValue = ReadWriteExcel.getCellDataString(3, "J");
		String executivesummary = ReadWriteExcel.getCellDataString(4, "B");
		String VerifiedBy = ReadWriteExcel.getCellDataString(9, "B");
		String ContactDetails = ReadWriteExcel.getCellDataString(10, "B");
		String VerifiedDate = ReadWriteExcel.getCellDataString(11, "B");
		String RatingValue = ReadWriteExcel.getCellDataString(4, "J");
		String RefrenceRole = ReadWriteExcel.getCellDataString(5, "J");

		
		sendKeys(loc_empcheckActionnotes, REFNoteValue, "empchecknotes");
		scrollElementIntoView(loc_analystempactivity);

		Thread.sleep(3000);
		clickOn(loc_analystempactivity, "Search Entity");
		Thread.sleep(3000);
		acceptAlert();
		scrollElementIntoView(loc_analystempactivity);
		clickOn(loc_empresponsereceived, "EmpResponseRecieved");
		// scrollElementIntoView(loc_analystempwritereport);
		//explicitwait(loc_analystempwritereport);
		Thread.sleep(6000);
		clickOn(loc_analystempwritereport, "Write Report");
		sendKeys(loc_executivesummary, executivesummary, "executivesummary");
		sendKeys(addverNotes, REFNoteValue, "Notes");
		scrollElementIntoView(loc_RefrenceRole);

		sendKeys(loc_RefrenceRole, RefrenceRole, "RefrenceRole");

		
		selectreferencecheckrating(RatingValue);
		
		
		Thread.sleep(3000);
		sendKeys(loc_verifiedBy, VerifiedBy, "VerifiedBy");
		sendKeys(loc_contactdetails, ContactDetails, "ContactDetails");
		//sendKeys(loc_verifieddate, VerifiedDate, "VerifiedDate");
		Enter();
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		clickOn(loc_savebtn, "Save");

		Thread.sleep(2000);
		clickOn(loc_submitbtn, "Submit");
		acceptAlert();
		Thread.sleep(3000);
		clickOn(loc_InProgressTab, "InProgressTab");

	}

	public  void Addresscheck() throws Exception {
		ReadWriteExcel.setExcelFile(SheetPath, "Analyst");

		String ADDNoteValue = ReadWriteExcel.getCellDataString(3, "R");
		String executivesummary = ReadWriteExcel.getCellDataString(4, "B");
		String ProgrammeType = ReadWriteExcel.getCellDataString(8, "F");

		String VerifiedBy = ReadWriteExcel.getCellDataString(9, "B");
		String ContactDetails = ReadWriteExcel.getCellDataString(10, "B");
		String VerifiedDate = ReadWriteExcel.getCellDataString(11, "B");

		sendKeys(loc_empcheckActionnotes, ADDNoteValue, "empchecknotes");

		scrollElementIntoView(loc_analystempactivity);

		Thread.sleep(3000);
		clickOn(loc_analystempactivity, "Search Entity");
		Thread.sleep(3000);
		acceptAlert();
		scrollElementIntoView(loc_analystempactivity);
		clickOn(loc_empresponsereceived, "EmpResponseRecieved");
		Thread.sleep(6000);
		scrollElementIntoView(loc_analystempwritereport);
		explicitwait(loc_analystempwritereport);
		clickOn(loc_analystempwritereport, "Write Report");
		sendKeys(loc_executivesummary, executivesummary, "executivesummary");
		sendKeys(addverNotes, ADDNoteValue, "Notes");
		sendKeys(loc_addveraddcomment, ProgrammeType, "Notes");
		sendKeys(loc_addNatureofaddcomment, ProgrammeType, "Notes");
		sendKeys(loc_addverResPeriodComment, ProgrammeType, "Notes");
		sendKeys(loc_addverRelationcomment, ProgrammeType, "Notes");

		Thread.sleep(3000);
		
		sendKeys(loc_verifiedBy, VerifiedBy, "VerifiedBy");
		sendKeys(loc_contactdetails, ContactDetails, "ContactDetails");
		//sendKeys(loc_verifieddate, VerifiedDate, "VerifiedDate");
		Enter();
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		clickOn(loc_savebtn, "Save");
		Thread.sleep(3000);
		clickOn(loc_submitbtn, "Submit");
		acceptAlert();
		Thread.sleep(3000);
		clickOn(loc_InProgressTab, "InProgressTab");
	}

	public  void Analystreview() throws InterruptedException, Exception {

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
				+ "' and status = 'Assigned'";
		System.out.println(checkIDquery);

		List<String> checkids = DatabaseConnectivity.selectQueryforcolumn(checkIDquery, "check_id");

		Thread.sleep(3000);

		clickOn(loc_Yourtask, "Analst task tab");

		Thread.sleep(5000);

		ExecutionLog.Log("Number of Assigned Checks " + checkids.size());

		for (int i = 0; i < checkids.size(); i++) {

			String checkid = checkids.get(i);

			String loc_Reviewcheck = "//a[@href='/Analyst/ChangeCheckStatusToAccept?checkID=" + checkid + "']";

			getText(loc_Reviewcheck);

			clickOn(loc_Reviewcheck, "Review Check");

			Thread.sleep(5000);
			acceptAlert();
			Thread.sleep(3000);
		}

		ExecutionLog.Log("*************************Analyst Review is completed*************************");

	}

	public  void Analystaction() throws Exception {

		// testing - need to remove

		navigatetourl(URL);
		login lg = new login(driver);

		lg.loggedin("Piyush_team", "V_q!GE[HeH");

		clickOn(loc_Yourtask, "Analst task tab");

		Thread.sleep(5000);

		ReadWriteExcel.setExcelFile(SheetPath, "CandidateRegistration");

		// String FirstNamevalue = ReadWriteExcel.getCellDatawithoutformula(7, 2);

		String CaseIDquery = "select case_id, * from candidate_master where first_name  = '" + LevelFirstNamevalue + "'";

		String CaseID = DatabaseConnectivity.selectStringQueryforcolumn(CaseIDquery, "case_id");
		System.out.println(CaseID);

		String checkIDquery = "select * from check_master where case_id ='" + CaseID
				+ "' and (status = 'Accepted' OR  status = 'Inprogress')";

		System.out.println(checkIDquery);

		List<String> checkids = DatabaseConnectivity.selectQueryforcolumn(checkIDquery, "check_id");

		clickOn(loc_InProgressTab, "InProgressTab");

		for (int i = 0; i < checkids.size(); i++) {

			String checkid = checkids.get(i);

			String loc_Actioncheck = "//a[@href='/Analyst/ActionArea?checkID=" + checkid + "']";

			clickOn(loc_Actioncheck, "Action on Check");

			String ChecktypeQuery = "select check_type from check_master where check_id ='" + checkid
					+ "' and (status = 'Accepted' OR  status = 'Inprogress')";

			String checktypename = DatabaseConnectivity.selectStringQueryforcolumn(ChecktypeQuery, "check_type");

			if (checktypename.equalsIgnoreCase("EMP")) {

				employmentcheck();
			}

			else if (checktypename.equalsIgnoreCase("DB")) {

				dbcheck();
			}

			else if (checktypename.equalsIgnoreCase("EDU")) {

				educheck();
			}

			else if (checktypename.equalsIgnoreCase("REF")) {

				professionalreference();
			}

			else if (checktypename.equalsIgnoreCase("PRO")) {

				professionalcheck();
			}

			else if (checktypename.equalsIgnoreCase("ADD")) {

				Addresscheck();

			}

			else {

				ExecutionLog.Log("No Checks available for Case");
			}

		}

		ExecutionLog.Log("*************************Analyst action is completed*************************");

	}

	public static void selectreferencecheckrating(String Rating) throws Exception {

		String loc_Rating = "//*[@value='" + Rating + "']";

		List<WebElement> Ratings = driver.findElements(By.xpath(loc_Rating));

		for (WebElement elem : Ratings) {

			clickWebelement(elem, "Rating Checkbox");

		}
		
		

	}
	
	public static void selectEmpcheckPerformance(String performance) throws Exception {

		String loc_Rating = "//*[@value='"+performance+"']";

		List<WebElement> Ratings = driver.findElements(By.xpath(loc_Rating));

		for (WebElement elem : Ratings) {

			clickWebelement(elem, "Rating Checkbox");

		}
	}
	
}
	
	