package pages;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;
import com.sun.xml.bind.v2.schemagen.xmlschema.List;

import baseclass.DriverHelper;
import locators.CommonLocators;
import utilities.DatabaseConnectivity;
import utilities.ExecutionLog;
import utilities.ReadWriteExcel;

public class ClientFunctions extends DriverHelper implements CommonLocators {

	public static String ExpectedTitle = "Candidate Registration";
	public static String ExpectedSuccessMessage = "Account has been created successfully.";
	public static String SheetPath = System.getProperty("user.dir") + "\\TestData\\InputFile.xlsx";
	//static String FirstNamevalue = DriverHelper.LevelFirstNamevalue;

	WebDriver driver;

	public ClientFunctions(WebDriver driver) {

		this.driver = driver;

	}

	public String registercandidate() throws InterruptedException, Exception {
		String ActualMessage = null;
		ReadWriteExcel.setExcelFile(SheetPath, "CandidateRegistration");

		// Values from Inputfile

		String HiringCountryvalue = ReadWriteExcel.getCellData(4, 2);
		String ResearchJurisdictionvalue = ReadWriteExcel.getCellData(5, 2);

		String LanguageValue = ReadWriteExcel.getCellData(6, 2);
		// String FirstNamevalue = ReadWriteExcel.getCellData(7, 2);
		String Middlenamevalue = ReadWriteExcel.getCellData(8, 2);
		String lastnamevalue = ReadWriteExcel.getCellData(9, 2);
		String Mobilenovalue = ReadWriteExcel.getCellData(10, 2);
		String EmailValue = ReadWriteExcel.getCellData(12, 2);
		String EmployeeIDValue = ReadWriteExcel.getCellData(19, 2);
		String CostCentervalue = ReadWriteExcel.getCellData(20, 2);
		String RemarkValue = ReadWriteExcel.getCellData(21, 2);
		String EmployeeClassvalue = ReadWriteExcel.getCellData(22, 2);
		String DOBYearvalue = ReadWriteExcel.getCellData(12, 6);
		String DOBMonthvalue = ReadWriteExcel.getCellData(13, 6);
		String DOBDatevalue = ReadWriteExcel.getCellData(14, 6);
		String DOBChangeYear = ReadWriteExcel.getCellData(21, 6);
		String DOBChangeMonth = ReadWriteExcel.getCellData(22, 6);
		String DOBChangeDate = ReadWriteExcel.getCellData(23, 6);
		String RecruiterNamevalue = ReadWriteExcel.getCellData(23, 2);
		String Depatmentvalue = ReadWriteExcel.getCellData(24, 2);
		String HRBusinessPartnervalue = ReadWriteExcel.getCellData(25, 2);
		String Designationvalue = ReadWriteExcel.getCellData(26, 2);
		String ScreeningPackagevalue = ReadWriteExcel.getCellData(27, 2);

		String PackagechecklistQuery = "select * from package_master where pk_name='" + ScreeningPackagevalue
				+ "'and client_id=1007";

		clickOn(loc_Createcase, "CreateCase");

		clickOn(loc_Candiate_Registration, "RegisterCandidate");
		Thread.sleep(2000);
		String RegisterCandidatetitle = getTitle();

		Assert.assertEquals(RegisterCandidatetitle, ExpectedTitle);

		selectDropdownValue(loc_HiringCountry, "HiringCountry", HiringCountryvalue);

		waitMyTime(3);

		selectDropdownValue(loc_ResearchJurisdiction, "ResearchJurisdiction", ResearchJurisdictionvalue);

		waitMyTime(3);

		selectDropdownValue(loc_Language, "Language", LanguageValue);
		waitMyTime(5);

		sendKeys(loc_FirstName, LevelFirstNamevalue, "FirstName");
		waitMyTime(5);

		sendKeys(loc_MiddleName, Middlenamevalue, "MiddleName");

		sendKeys(loc_LastName, lastnamevalue, "lastname");

		DriverHelper.waitMyTime(5);

		sendKeys(loc_MobileNo, Mobilenovalue, "Mobileno");

		DriverHelper.waitMyTime(5);

		sendKeys(loc_Email, EmailValue, "Email");
		selectDropdownValue(loc_DOBYear, "DOBYear", DOBYearvalue);
		selectDropdownValue(loc_DOBMonth, "loc_DOBMonth", DOBMonthvalue);
		selectDropdownValue(loc_DOBDate, "DOBDate", DOBDatevalue);
		Thread.sleep(2000);

		clickTab(loc_DOBDate);

		// clickOn(loc_EmployeeStartDate, "EmployeeStartDate");

//clickUsingJSExecutor(loc_EmployeeStartDate, "EmployeeStartDate");

		Thread.sleep(2000);

		Datepicker(loc_DateofNameChangeMonth, DOBChangeMonth, loc_DateofNameChangeYear, DOBChangeYear, DOBChangeDate);

		sendKeys(loc_EmployeeID, EmployeeIDValue, "EmployeeID");

		DriverHelper.waitMyTime(10);

		sendKeys(loc_CostCenter, CostCentervalue, "CostCenter");
		sendKeys(loc_Remark, RemarkValue, "EmployeeID");

		// Society general

		/*
		 * WebElement EmployeeClass = driver.findElement(By.xpath(loc_EmployeeClass));
		 * 
		 * DriverHelper.selectDropdownValue(EmployeeClass, EmployeeClassvalue);
		 * 
		 * 
		 * WebElement RecruiterName = driver.findElement(By.xpath(loc_RecruiterName));
		 * DriverHelper.sendKeys(RecruiterName, RecruiterNamevalue);
		 */

		sendKeys(loc_EmployeeDepartment, Depatmentvalue, "Depatment");
		/*
		 * WebElement HRBusinessPartner =
		 * driver.findElement(By.xpath(loc_HRBusinessPartner));
		 * DriverHelper.sendKeys(HRBusinessPartner, HRBusinessPartnervalue);
		 * 
		 * WebElement Designation = driver.findElement(By.xpath(loc_Designation));
		 * 
		 * DriverHelper.selectDropdownValue(Designation, Designationvalue);
		 */
//selectDropdownValue(loc_Designation, loc_Designation, Designationvalue);

		Thread.sleep(3000);

		WebElement RCSubmit = driver.findElement(By.xpath(loc_Submitbutton));

		selectDropdownValue(loc_Package, "ScreeningPackage", ScreeningPackagevalue);

		Thread.sleep(3000);

		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");

		Thread.sleep(3000);

		java.util.List<String> Allchecks = DatabaseConnectivity.selectQueryforcolumn(PackagechecklistQuery,
				"check_name");

		ExecutionLog.Log(ScreeningPackagevalue + " check list is" + Allchecks);

		clickWebelement(RCSubmit, "Submit Button");

		Thread.sleep(3000);

		// WebElement NoticeCancel = driver.findElement(By.xpath(loc_NoticeCancel));

		explicitwait(loc_NoticeCancel2);

		if (isElementPresent(loc_NoticeCancel2)) {

			WebElement NoticeCancel = driver.findElement(By.xpath(loc_NoticeCancel2));

			clickWebelement(NoticeCancel, "Cancel Notice Button");

			// clickOn(loc_NoticeCancel, "NoticeCancel");

			Thread.sleep(3000);

			clickWebelement(RCSubmit, "Submit Button");

			ActualMessage = driver.findElement(By.xpath(loc_RegistarionSuccess2)).getText();

			Assert.assertEquals(ActualMessage, ExpectedSuccessMessage);

			ExecutionLog.Log("Registration Status: " + ActualMessage);

		}

		else {

			Thread.sleep(3000);

			ActualMessage = driver.findElement(By.xpath(loc_RegistarionSuccess1)).getText();

			Assert.assertEquals(ActualMessage, ExpectedSuccessMessage);

			ExecutionLog.Log("Registration Status: " + ActualMessage);

		}

		return LevelFirstNamevalue;

		// test.log(LogStatus.PASS, "Done");
	}

	public void Verifyclienthomefilters(String FilterName, String Filtervalue) throws Exception {

		if (FilterName.equalsIgnoreCase("Name")) {

			clickOn(loc_clientHomeNamecheck, "NameCheckBox");

			sendKeys(loc_Filtervalue, Filtervalue, "FilterTextValue");

			clickOn(loc_Searchbutton, "SearchButton");

		}

		else if (FilterName.equalsIgnoreCase("RefNo")) {

			clickOn(loc_clientHomeRefnocheck, "NameCheckBox");

			sendKeys(loc_Filtervalue, Filtervalue, "FilterTextValue");

			clickOn(loc_Searchbutton, "SearchButton");

		}

		else if (FilterName.equalsIgnoreCase("EmployeeID")) {

			clickOn(loc_EmployeeIdcheck, "NameCheckBox");
			sendKeys(loc_Filtervalue, Filtervalue, "FilterTextValue");

			clickOn(loc_Searchbutton, "SearchButton");

		}

		else if (FilterName.equalsIgnoreCase("CostCenter")) {

			clickOn(loc_EmployeeCostcenter, "NameCheckBox");
			sendKeys(loc_Filtervalue, Filtervalue, "FilterTextValue");

			clickOn(loc_Searchbutton, "SearchButton");

		}

	}

	public void NavigatetoRegisterMultipleCandidate() throws Exception {

		clickOn(loc_Createcase, "CreateCase");

		clickOn(loc_MultipleRegisterCandidate, "RegisterMultipleCandidate");

		verifyElementPresent(loc_uploadButton, "Upload Button");

	}

	public void uploadRegisterMutlipleCandidate() throws Exception {

		String Pathfile = System.getProperty("user.dir") + "\\AutoIT\\Fileupload.exe";
		String fileName = System.getProperty("user.dir") + "\\TestData\\DemoMultiple_Candidate_Registration.xlsx";

		String autoITExecutable = Pathfile + " " + fileName;

		clickOn(loc_ChooseFile, "ChooseFile");

		Thread.sleep(2000);

		Runtime.getRuntime().exec(autoITExecutable);

		explicitwait(loc_uploadButton);

		Thread.sleep(2000);

		clickOn(loc_uploadButton, "Upload Button");

		explicitwait(loc_CreateProfiles);

		clickOn(loc_CreateProfiles, "CreateProfile");
		

	}

	public void NavigatetoCandidateManagement() throws IOException {

		clickOn(loc_Createcase, "CreateCase");

		clickOn(loc_CandidateManagement, "CandidateManagement");

	}

	public void NavigatetoClientongoingcase() throws IOException {

		clickOn(loc_MyCases, "MyCases");

		clickOn(loc_OngoingCase, "Ongoing Case");

	}

	public void NavigatetoClientCompletedCase() throws IOException {

		clickOn(loc_MyCases, "MyCases");

		clickOn(loc_ClientCompletedCase, "Completed Cases");

	}

	public void NavigatetoArchivedCase() throws IOException {

		clickOn(loc_MyCases, "MyCases");

		clickOn(loc_ArchivedCases, "Archived Cases");

	}

	public void NavigatetoNormaluploads() throws IOException {

		clickOn(loc_Upload, "Upload");

		clickOn(loc_NormalUpload, "Normal Upload");

	}

	public void Navigatetobulkupload() throws IOException {

		clickOn(loc_Upload, "Upload");

		clickOn(loc_Bulkupload, "Bulk Upload");

	}

	public void Navigatetocaseupload() throws IOException {

		clickOn(loc_Upload, "Upload");

		clickOn(loc_Caseupload, "Case Upload");

	}

	public void NavigatetoMISReport() throws IOException {

		clickOn(loc_MISReport, "MISReport");

		clickOn(loc_MISReportBoard, "MISReportBoard");

	}
	
	public void NavigatetoClientSettings() throws IOException {

		clickOn(loc_SettingsOption, "SettingsOption");

	}

	
	public void NavigatetoMessagethread() throws IOException {

		clickOn(loc_MessaageThread, "MessaageThread");

	}
	
	public void NavigatetoChangePassword() throws IOException {

		clickOn(loc_ChangePasswordoption, "ChangePasswordoption");

	}


	public void VerifyclientOngoingfilters(String FilterName, String Filtervalue) throws Exception {

		if (FilterName.equalsIgnoreCase("Name")) {

			clickOn(loc_clientNameOnGoingcheck, "NameCheckBox");

			sendKeys(loc_Filtervalue, Filtervalue, "FilterTextValue");
			Thread.sleep(2000);

			clickOn(loc_Searchbutton, "SearchButton");
			
			Thread.sleep(3000);

		}

		else if (FilterName.equalsIgnoreCase("RefNo")) {

			clickOn(loc_clientRefnoOnGoingcheck, "Ref No");

			sendKeys(loc_Filtervalue, Filtervalue, "FilterTextValue");

			clickOn(loc_Searchbutton, "SearchButton");
			
			Thread.sleep(2000);
		}

		else if (FilterName.equalsIgnoreCase("EmployeeID")) {

			clickOn(loc_clientEmpIDOnGoingcheck, "Employee ID");

			sendKeys(loc_Filtervalue, Filtervalue, "FilterTextValue");

			clickOn(loc_Searchbutton, "SearchButton");
			Thread.sleep(2000);

		}

		else if (FilterName.equalsIgnoreCase("CostCenter")) {

			clickOn(loc_clientEmpCostOnGoingcheck, "Cost Center");
			sendKeys(loc_Filtervalue, Filtervalue, "FilterTextValue");

			clickOn(loc_Searchbutton, "SearchButton");
			Thread.sleep(2000);

		}
		
		else if (FilterName.equalsIgnoreCase("CompletionDate")) {

			clickOn(loc_ClientCompletionDateCheck, "Completion Date Checkbox");
			
			clickOn(loc_CompleteCaseFIlterfrom, "Completion Date Checkbox");
			
			
			Datepicker(loc_DateofNameChangeMonth, "Jan", loc_DateofNameChangeYear, "2019", "1");
			
			Thread.sleep(2000);

			clickOn(loc_CompleteCaseFIlterto, "Completion Date Checkbox");


			Datepicker(loc_DateofNameChangeMonth, "May", loc_DateofNameChangeYear, "2019", "1");

				
			clickOn(loc_Searchbutton, "SearchButton");
			Thread.sleep(2000);

		}


	}
	
	public  Boolean GenerateStatisticsMISReport() throws Exception {

		ReadWriteExcel.setExcelFile(SheetPath, "CandidateRegistration");
		
		String DataEnteriesValue = ReadWriteExcel.getCellDataString(60, "B");
		Thread.sleep(2000);
		selectDropdownValue(loc_MISDataEnteries, "MISDataEnteries", DataEnteriesValue);
		selectDropdownValueByIndex(loc_MISchartype, "MISchartype", 1);
		selectDropdownValueByIndex(loc_MISAxis, "MISAxis", 1);
		clickOn(loc_GenerateStatisticsButton, "GenerateStatisticsButton");
		Thread.sleep(3000);

		Boolean Result = getText(loc_Reportresulttext).contains(DataEnteriesValue);
		
		return Result;

	}

	
	public void GenerateMISReport() throws Exception {

		clickOn(loc_MISReportBoard, "MISReportBoard");
		clickOn(loc_GenerateMISReport, "GenerateMISReport");
		
		Thread.sleep(3000);
	}
	
	public void ActiononNormlupload() throws Exception {

		
		String Pathfile = System.getProperty("user.dir") + "\\AutoIT\\Fileupload.exe";
		String fileName = System.getProperty("user.dir") + "\\TestData\\InterimReport.docx";

       String autoITExecutable = Pathfile + " " + fileName;
       
		VerifyclientOngoingfilters("Name", "Automation");
		
		Thread.sleep(2000);
		
		clickOn(loc_firstcandidatefile, "firstcandidateChoosefile");
		
		Runtime.getRuntime().exec(autoITExecutable);
		
		Thread.sleep(2000);
		
		clickOn(loc_firstcandidateupload, "firstcandidateupload");

		
	}
	
	
	public void ActiononCaseupload() throws IOException, InterruptedException {
		
		
		
String Pathfile = System.getProperty("user.dir") + "\\AutoIT\\Fileupload.exe";
String fileName = System.getProperty("user.dir") + "\\TestData\\InterimReport.docx";

String autoITExecutable = Pathfile + " " + fileName;

clickOn(loc_CUchoosefilebutton, "Choose Files");

Thread.sleep(3000);

Runtime.getRuntime().exec(autoITExecutable);	
Thread.sleep(3000);

clickOn(loc_CUuploadbutton, "Upload File");

Thread.sleep(2000);

clickOn(loc_CUDownloadFile, "DownloadFile");


	}
	
	public void ActiononBulkupload() throws IOException, InterruptedException {
		
	
String Pathfile = System.getProperty("user.dir") + "\\AutoIT\\Fileupload.exe";
String fileName = System.getProperty("user.dir") + "\\TestData\\IN317.zip";

System.out.println(fileName);

String autoITExecutable = Pathfile + " " + fileName;

clickOn(loc_BUChoosefile, "Choose Files");

Thread.sleep(3000);

Runtime.getRuntime().exec(autoITExecutable);	
Thread.sleep(2000);

clickOn(loc_BUUploadfile, "Upload File");

Thread.sleep(2000);

clickOn(loc_BUFirstupload, "Check first Candidate");

((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");

clickOn(loc_BUUpoadFilesbutton, "Upload Selected");


	}


}
