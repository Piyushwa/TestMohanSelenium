/*package pages;

import java.awt.List;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import org.apache.commons.lang3.StringEscapeUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SendKeysAction;

import baseclass.DriverHelper;
import freemarker.template.utility.HtmlEscape;
import locators.CommonLocators;
import utilities.DatabaseConnectivity;
import utilities.ReadWriteExcel;
import org.openqa.selenium.support.Color;

public class CandidateFunctions2 extends DriverHelper implements CommonLocators {

	WebDriver driver;

	public static String SheetPath = System.getProperty("user.dir") + "\\TestData\\InputFile.xlsx";

	public CandidateFunctions2(WebDriver driver) {

		this.driver = driver;

	}
	


	public void candidateinformationfill() throws InterruptedException, Exception {

		try {

			ReadWriteExcel.setExcelFile(SheetPath, "CandidateRegistration");

			String FirstNamevalue = ReadWriteExcel.getCellData(7, 2);
			String lastnamevalue = ReadWriteExcel.getCellData(9, 2);
			String MiddleNamevalue = ReadWriteExcel.getCellData(6, 6);
			String Nicknamevalue = ReadWriteExcel.getCellData(9, 6);
			String Titlevalue = ReadWriteExcel.getCellData(10, 6);
			String MaidenNameValue = ReadWriteExcel.getCellData(20, 6);
			String DOBYearvalue = ReadWriteExcel.getCellData(12, 6);
			String DOBMonthvalue = ReadWriteExcel.getCellData(13, 6);
			String DOBDatevalue = ReadWriteExcel.getCellData(14, 6);	
			String DOBChangeYear = ReadWriteExcel.getCellData(21, 6);
			String DOBChangeMonth = ReadWriteExcel.getCellData(22, 6);
			String DOBChangeDate = ReadWriteExcel.getCellData(23, 6);
			String Gender = ReadWriteExcel.getCellData(15, 6);
			String Depatmentvalue = ReadWriteExcel.getCellData(16, 6);
			String Positionvalue = ReadWriteExcel.getCellData(17, 6);
			String Permitvalue = ReadWriteExcel.getCellData(18, 6);
			String loc_Gender = "//span[contains(text(),'"+Gender+"')]";
			
			System.out.println(loc_Gender);
			String loc_Workpermit = "//div[@id='hiringCountryPermit' and @value='" +Permitvalue+"']";
			String NewPasswordValue = ReadWriteExcel.getCellData(19, 6);

			String UsernameQuery = "select UserName from aspnet_users where userid IN(select candidate_guid from candidate_master where first_name = '"
					+ FirstNamevalue + "')";

			System.out.println(UsernameQuery);

			String Usernamevalue = DatabaseConnectivity.selectStringQueryforcolumn(UsernameQuery, "UserName");
			// testing -Need to remove
			
			
			  String PasswordQuery =
			  "Select MailBody from CandidateRegistrationEmailLogging where CandidateId IN (Select Candidate_ID from candidate_master where first_name = '"
			  + FirstNamevalue + "' and MailType = 'Password')";
			  
			  String Passwordvalue =
			  DatabaseConnectivity.selectStringQueryforcolumn(PasswordQuery, "MailBody");
			  
			  String[] TempPasswordvalue =
			  org.apache.commons.lang3.StringUtils.substringsBetween(Passwordvalue,
			  "below:", "You"); String HTMLPassword =
			  TempPasswordvalue[0].replaceAll("</p>", "").replaceAll("<p>", "");
			  
			  String cleanedString = StringEscapeUtils.unescapeHtml4(HTMLPassword);
			  
			  String cleanedStringN = cleanedString.trim();
			  
			  System.out.println("********" + cleanedStringN);
			  
			  navigatetourl("https://demo.pes.bluedd.com/");
			  
			  sendKeys(loc_username, Usernamevalue, "USERNAME");
			  
			  sendKeys(loc_Password, cleanedStringN, "Pssword");
			  
			  clickOn(loc_loginbutton, "LogIn");
			  
			  Thread.sleep(2000);
			  
			  driver.navigate().refresh();
			  
			  WebElement Oldpassword = driver.findElement(By.xpath(loc_Oldpassword));
			  
			  new Actions(driver).moveToElement(Oldpassword).click().perform();
			  
			  sendKeys(loc_Oldpassword, cleanedStringN, "Oldpassword");
			  
			  sendKeys(loc_NewPassword, NewPasswordValue, "PasswordNew");
			  
			  sendKeys(loc_ConfirmPassword, NewPasswordValue, "confirmPassword");
			  
			  clickOn(loc_ChangePassword, "ChangePassword");
			  
			  Thread.sleep(2000);
			  
			  clickOn(loc_Logon, "Logon");
			 
			Thread.sleep(2000);

			navigatetourl("https://demo.pes.bluedd.com/");

			sendKeys(loc_username, Usernamevalue, "USERNAME");

			sendKeys(loc_Password, NewPasswordValue, "Password");

			clickOn(loc_loginbutton, "LogIn");

			Thread.sleep(3000);

			// testing -Need to remove

			
			
			  WebElement NextSubmit = driver.findElement(By.xpath(loc_Submitnext));
			  
			  ((JavascriptExecutor)
			  driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
			  
			  clickOn(loc_Agreetermcheck, "Termscheck"); Thread.sleep(2000);
			  
			  clickOn(loc_Iagree, "Iagree");
			  
			  Thread.sleep(2000);
			  
			  clickWebelement(NextSubmit);
			 
			// PrivacyNotes -Not Applicable for test client

			Thread.sleep(2000);

			
			  ((JavascriptExecutor)
			  driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
			  
			  Thread.sleep(2000);
			  
			  clickOn(loc_Iagree, "Iagree");
			  
			  DriverHelper.clickWebelement(NextSubmit);
			  
			  Thread.sleep(2000);
			  
			 

			clickOn(loc_WelcomeUnderstood, "understood");

			Thread.sleep(2000);

			clickOn(loc_EmploymentHistory, "CG");

			
			
			  sendKeys(loc_LastNamePD, lastnamevalue, "lastname");
			  
			  sendKeys(loc_FirstNamePD, FirstNamevalue, "FirstName");
			  
			  sendKeys(loc_middleName, MiddleNamevalue, "MiddleName");
			  
			  
			  sendKeys(loc_Maidenname, MaidenNameValue, "MaidenName");
			  
			  clickOn(loc_dobchange, "Dob change");
			  
			  Thread.sleep(2000);
			  
			  Datepicker(loc_DateofNameChangeMonth, DOBChangeMonth,
			  loc_DateofNameChangeYear, DOBChangeYear, DOBChangeDate);
			  
			  sendKeys(loc_nickname, Nicknamevalue, "NickName");
			  
			  
			  selectDropdownValue(loc_Title, "Tilte",Titlevalue );
			  
			  ((JavascriptExecutor)
			  driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
			  
			  Thread.sleep(1000);
			  
			  clickOn(loc_NameOption, "Not Available");
			  
			  Thread.sleep(2000);
			  
			  selectDropdownValue(loc_DOBYear, "dobYear", DOBYearvalue);
			  
			  selectDropdownValue(loc_DOBMonth, "dobMonth", DOBMonthvalue);
			  
			  selectDropdownValue(loc_DOBDate, "dobDate", DOBDatevalue);
			 
			  
			
			  
			  
			 // clickOn(loc_Gender, "GenderPD");
			  
			 
			/// *********TestClient -Not Applicable******

			
			  WebElement Department = driver.findElement(By.xpath(loc_department));
			  
			  DriverHelper.sendKeys(Department, Depatmentvalue);
			  
			  WebElement Position = driver.findElement(By.xpath(loc_Position));
			  
			  DriverHelper.sendKeys(Position, Positionvalue);
			  
			  WebElement Permit = driver.findElement(By.xpath(loc_PermitNO));
			  
			  DriverHelper.clickWebelement(Permit);
			  
			  Thread.sleep(2000);
			 

			
			
			  WebElement MovetoAddress =
			  driver.findElement(By.xpath(loc_MovetoAddrssDetails));
			  
			  String ButtonColor = MovetoAddress.getCssValue("background-color");
			  System.out.println("***********" + ButtonColor);
			  
			  clickOn(loc_MovetoAddrssDetails, "MovetoAddress");
			  
			  Thread.sleep(2000);
			 

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	// Address Details
	public void AddressDetails() throws InterruptedException, Exception

	{

		ReadWriteExcel.setExcelFile(SheetPath, "CandidateRegistration");

		String ApartmentNo = ReadWriteExcel.getCellData(4, 12);
		String UnitLane1 = ReadWriteExcel.getCellData(5, 12);

		String UnitLane2 = ReadWriteExcel.getCellData(6, 12);

		String CityValue = ReadWriteExcel.getCellData(7, 12);

		String StateValue = ReadWriteExcel.getCellData(8, 12);
		String ZipValue = ReadWriteExcel.getCellData(9, 12);
		String CountryValue = ReadWriteExcel.getCellData(10, 12);

		String FromYearValue = ReadWriteExcel.getCellData(11, 12);

		String FromMonthValue = ReadWriteExcel.getCellData(12, 12);

		String Infovalue = ReadWriteExcel.getCellData(15, 12);
		String Natureofresidence = ReadWriteExcel.getCellData(17, 12);
		String loc_resiTyppe = "//span[contains(text(),'"+Natureofresidence+"')]";
		//String NatureofResidence = ReadWriteExcel.getCellData(17, 12);

		try {

			sendKeys(loc_apartmentnumber, ApartmentNo, "ApartmentNo");

			sendKeys(loc_unitlane1, UnitLane1, "UnitLane1");

			sendKeys(loc_unitlane2, UnitLane2, "UnitLane2");

			sendKeys(loc_city, CityValue, "City");

			sendKeys(loc_state, StateValue, "State");
			sendKeys(loc_postalcode, ZipValue, "PostalCode");

			Thread.sleep(2000);

			selectDropdownValue(loc_country, "Country", CountryValue);

			Thread.sleep(2000);

			((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");

			selectDropdownValue(loc_fromYear, "From Year", FromYearValue);

			Thread.sleep(2000);

			selectDropdownValue(loc_fromMonth, "From Month", FromMonthValue);

			sendKeys(loc_addInfo, Infovalue, "AddInfo");
			
			clickOn(CorrespondingSameaddress, " Same As corresponding Address");

			clickOn(loc_resiTyppe, "Nature of Residence");

			clickOn(loc_MovetoPermanent, "MovetoAddress");

		} catch (Exception e) {

		}
	}

	public void PermanentAddressDetails() throws IOException {

		try {
			clickOn(loc_perAddress, "Same as Current Address");

			clickOn(loc_movetofamilydetails, "movetofamilydetails");

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void familydetails() throws Exception {

		ReadWriteExcel.setExcelFile(SheetPath, "CandidateRegistration");

		String FatherLastName = ReadWriteExcel.getCellData(19, 12);
		String FatherMiddleName = ReadWriteExcel.getCellData(20, 12);
		String FatherFirstName = ReadWriteExcel.getCellData(21, 12);
		String MotherLastName = ReadWriteExcel.getCellData(22, 12);
		String MotherMiddleName = ReadWriteExcel.getCellData(23, 12);
		String MotherFirstName = ReadWriteExcel.getCellData(24, 12);

		try {
			sendKeys(loc_Ffamilytname, FatherLastName, "FatherLastName");
			sendKeys(loc_Fmiddlename, FatherMiddleName, "FatherMiddleName");
			sendKeys(loc_Ffirstname, FatherFirstName, "FatherFirstName");

			sendKeys(loc_Mfamilyname, MotherLastName, "MotherLastName");
			sendKeys(loc_Mmiddlename, MotherMiddleName, "MotherMiddleName");
			sendKeys(loc_Mfirstname, MotherFirstName, "MotherfirstName");

			clickOn(loc_MovetocontactDetails, "Movetocontactdetailsbutton");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void contactdetails() {

		try {

			ReadWriteExcel.setExcelFile(SheetPath, "CandidateRegistration");
			String communicationmode = ReadWriteExcel.getCellData(28, 12);
			String ContactConfirmationValue = ReadWriteExcel.getCellData(27, 12);
			String Officecountrycode = ReadWriteExcel.getCellData(29, 12);
			String OfficeAreacode = ReadWriteExcel.getCellData(30, 12);
			String Officenumber = ReadWriteExcel.getCellData(31, 12);
			String loc_ContactConfirmation = "//span[contains(text(),'"+ContactConfirmationValue+"')]";
			String PreferTimevalue = ReadWriteExcel.getCellData(32, 12);

			
			sendKeys(loc_HomeCountry, Officecountrycode, "Homecountrycode");
			sendKeys(loc_HomeAreaCode, OfficeAreacode, "HomeAreacode");
			sendKeys(loc_HomeNumber, Officenumber, "Homenumber");
			
			
			Thread.sleep(2000);
			
			sendKeys(loc_Mobilecountry, Officecountrycode, "Mobile Country");
			sendKeys(loc_Mobilenumber, Officenumber, "Mobile Number");
			
			clickOn(loc_ContactConfirmation, "Yes to Contact");

			sendKeys(loc_Officecountry, Officecountrycode, "Officecountrycode");
			sendKeys(loc_officearea, OfficeAreacode, "OfficeAreacode");
			sendKeys(loc_officenumber, Officenumber, "Officenumber");

			selectDropdownValue(loc_commmethod, "communicationmode", communicationmode);
			
			Thread.sleep(2000);
			sendKeys(loc_prefertime, PreferTimevalue, "Prefer TIme to contact");


			clickOn(loc_movetoemploymenthistory, "movetoemploymenthistory");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void employmenthistory() {

		try {

			Thread.sleep(2000);
			// span[contains(text(),'Employment History')]
			ReadWriteExcel.setExcelFile(SheetPath, "CandidateRegistration");
			String CurrentEmployeebol = ReadWriteExcel.getCellData(13, 16);
			String ContactEmployerbol = ReadWriteExcel.getCellData(14, 16);
			String EmploymentStatus = ReadWriteExcel.getCellData(15, 16);
			String EmploymentType = ReadWriteExcel.getCellData(16, 16);
			String CompanyName = ReadWriteExcel.getCellData(4, 16);
			String EmployeeID = ReadWriteExcel.getCellData(5, 16);
			String Apartmentno = ReadWriteExcel.getCellData(6, 16);
			String Unit1 = ReadWriteExcel.getCellData(7, 16);
			String Unit2 = ReadWriteExcel.getCellData(8, 16);
			String CityValue = ReadWriteExcel.getCellData(9, 16);
			String StateValue = ReadWriteExcel.getCellData(10, 16);
			String ZipValue = ReadWriteExcel.getCellData(11, 16);
			String CountryValue = ReadWriteExcel.getCellData(12, 16);
			String PhoneCountryCode = ReadWriteExcel.getCellData(33, 16);
			String PhoneAreaCode = ReadWriteExcel.getCellData(34, 16);
			String PhoneNumber = ReadWriteExcel.getCellData(35, 16);
			String Addinfo = ReadWriteExcel.getCellData(18, 16);

			String JobValue = ReadWriteExcel.getCellData(20, 16);
			String CorporateTitle = ReadWriteExcel.getCellData(21, 16);
			String Responsibility = ReadWriteExcel.getCellData(22, 16);
				String Reasonleaving = ReadWriteExcel.getCellData(24, 16);
			String Reasonleavingvol = ReadWriteExcel.getCellData(25, 16);
			String supname = ReadWriteExcel.getCellData(26, 16);
			String suptitle = ReadWriteExcel.getCellData(27, 16);
			String supemail = ReadWriteExcel.getCellData(28, 16);
			String hrname = ReadWriteExcel.getCellData(29, 16);
			String hrjobtitle = ReadWriteExcel.getCellData(30, 16);
			String hrjobcontact = ReadWriteExcel.getCellData(31, 16);
			String EmployeeDept = ReadWriteExcel.getCellData(19, 16);

			String LastFixedSalary = ReadWriteExcel.getCellData(39, 16);
			String LastBonus = ReadWriteExcel.getCellData(40, 16);


			String filetitlevalue = ReadWriteExcel.getCellData(28, 16);
			String loc_currentemp = "//label//input[@id='currentEmployer'and @value='"+CurrentEmployeebol+"']";
			String loc_contactEmployee = "//label//input[@id='contactEmployerNow' and @value ='False']";
			String loc_empstatusEC = "//span[contains(text(),'"+EmploymentStatus+"')]";
			String loc_emptypeEC = "//span[contains(text(),'"+EmploymentType+"')]";
			String Timeframequery = "select yrs from package_master where client_id=1007 and pk_name='Scope 1' and  check_name ='Employment Verification' and scope_flag = 0 and yrs is not null order by id";
			String Timeframe = DatabaseConnectivity.selectStringQueryforcolumn(Timeframequery, "yrs");
			int Finaltimeframe = Integer.parseInt(Timeframe);
			System.out.println(Finaltimeframe);
			String Str1[] = subtract(Finaltimeframe).split(" ");
			LocalDate TodayDate = LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM YYYY");
			String formattedString = TodayDate.format(formatter);
			String Str2[] = formattedString.split(" ");
			String StartYear = Str1[2];
			String StartMonth = Str1[1];
			String StartDay = Str1[0];
			String EndYear = Str2[2];
			String EndtMonth = Str2[1];
			String EndDay = Str2[0];
			Thread.sleep(2000);
			
			clickOn(loc_currentemp, " Current Employer");
			
			clickOn(loc_contactEmployee, "Contact Employer");
			
			sendKeys(loc_companyname, CompanyName, "CompanyName");
			scrollElementIntoView(loc_empstate);
			Thread.sleep(2000);
			sendKeys(loc_employeeidEC, EmployeeID, "EmployeeID");
			sendKeys(loc_aptnumberEC, Apartmentno, "Appartment No");

			sendKeys(loc_streetlane1, Unit1, "Unit 1");
			sendKeys(loc_streetlane2, Unit2, "Unit 2");
			
			sendKeys(loc_empcity, CityValue, "City");

			sendKeys(loc_empstate, StateValue, "State");
			sendKeys(loc_zipEC, ZipValue, "Postal Code");

			selectDropdownValue(loc_empcountry, "Empcountry", CountryValue);

			Thread.sleep(2000);
			scrollElementIntoView(loc_empcountry);

			
			sendKeys(loc_Phonecountry, PhoneCountryCode, "PhoneCountryCode");

			sendKeys(loc_Phonearea, PhoneAreaCode, "PhoneAreaCode");
			sendKeys(loc_Phonenumber, PhoneNumber, "PhoneNumber");

			clickOn(loc_empstatusEC, "Empstatus");

			clickOn(loc_emptypeEC, "Emptype");

			
			sendKeys(loc_empdept, EmployeeDept, "Department");

			// Employment Start date
			scrollElementIntoView(loc_empstyear);
			selectDropdownValue(loc_empstyear, "EmploymentStartYear", StartYear);
			selectDropdownValue(loc_empstmonth, "EmploymentStartMonth", StartMonth);
			selectDropdownValue(loc_empstdate, "EmploymentStartDay", StartDay);

			// Employment Enddate

			selectDropdownValue(loc_empendyear, "EmploymentEndYear", EndYear);
			selectDropdownValue(loc_empendmonth, "EmploymentEndMonth", EndtMonth);
			selectDropdownValue(loc_empenddate, "EmploymentEndtDay", EndDay);
			Thread.sleep(2000);
			scrollElementIntoView(loc_reasonforliving);

			sendKeys(loc_jobtitle, JobValue, "jobtitle");
			sendKeys(loc_corptitle, CorporateTitle, "CorporateTitle");
			sendKeys(loc_responsibilities, Responsibility, "Responsibility");
		

			selectDropdownValue(loc_reasonforliving, "reasonforliving", Reasonleaving);

			selectDropdownValue(loc_voluntaryresignation, "reasonforlivingvol", Reasonleavingvol);
			
			
			Thread.sleep(2000);
			
			
			sendKeys(loc_lsupname, supname, "supname");
			sendKeys(loc_lsuptitle, suptitle, "suptitle");
			sendKeys(loc_lsupemail, supemail, "supemail");
			
			sendKeys(loc_supphonecountry, PhoneCountryCode, "supCountryCode");

			sendKeys(loc_supphonearea, PhoneAreaCode, "supAreaCode");
			sendKeys(loc_supphonenumber, PhoneNumber, "SupNumber");

			
			sendKeys(loc_hrname, hrname, "hrname");
			sendKeys(loc_hrjobtitle, hrjobtitle, "hrjobtitle");
			sendKeys(loc_hrcontact, hrjobcontact, "hrcontact");
			
			
			
			selectDropdownValueByIndex(loc_lfixedsalary, "fixedsalary", 1);
			selectDropdownValueByIndex(loc_lfixedcurrency, "fixedcurrency", 1);
sendKeys(loc_lfixedsalaryV, LastFixedSalary, "Fixed Slary");
			selectDropdownValueByIndex(loc_bonus, "bonustype", 1);
			sendKeys(loc_bonusV, LastBonus, "Bonus Value");

			((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
			clickOn(loc_agency, "AgencyNo");

			
	
			clickOn(loc_MovetoEducationalQualification, "MovetoEducationalQualification");
		}

		catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void Educationqualification() {

		try {

			ReadWriteExcel.setExcelFile(SheetPath, "CandidateRegistration");

			String CollegeNameValue = ReadWriteExcel.getCellData(4, 20);
			String CityNamevalue = ReadWriteExcel.getCellData(8, 20);
			String StateName = ReadWriteExcel.getCellData(9, 20);
			String Apartmentno = ReadWriteExcel.getCellData(6, 16);
			String Unit1 = ReadWriteExcel.getCellData(7, 16);
			String Unit2 = ReadWriteExcel.getCellData(8, 16);
			String CityValue = ReadWriteExcel.getCellData(9, 16);
			String StateValue = ReadWriteExcel.getCellData(10, 16);
			String ZipValue = ReadWriteExcel.getCellData(11, 16);
			String CountryName = ReadWriteExcel.getCellData(11, 20);
			String ProgrammeName = ReadWriteExcel.getCellData(12, 20);
			String ProgrammeType = ReadWriteExcel.getCellData(14, 20);
			String CertifciationnUmber = ReadWriteExcel.getCellData(21, 20);
			String Addinfo = ReadWriteExcel.getCellData(22, 20);

			String StudyStatus = ReadWriteExcel.getCellData(20, 20);

			String StartYear = ReadWriteExcel.getCellData(16, 20);

			String StartMonth = ReadWriteExcel.getCellData(17, 20);

			String EndYear = ReadWriteExcel.getCellData(18, 20);
			String EndMonth = ReadWriteExcel.getCellData(19, 20);
			String  loc_ProgrammeType  = "//span[contains(text(),'"+ProgrammeType+"')]";
			String  loc_StudyStatus = "//span[contains(text(),'"+StudyStatus+"')]";
			sendKeys(loc_CollegeName, CollegeNameValue, "CollegeName");
			sendKeys(loc_aptnumberEC, Apartmentno, "aptnumber");
			sendKeys(loc_streetlane1, Unit1, "streetlane1");
			sendKeys(loc_streetlane2, Unit2, "streetlane2");
			
			sendKeys(loc_CityNameEQ, CityNamevalue, "CityName");
			sendKeys(loc_empstate, StateValue, "State");
			sendKeys(loc_zipEC, ZipValue, "Postal Code");

			selectDropdownValue(loc_CountryEQ, "Country", CountryName);

			sendKeys(loc_ProgrammeName, ProgrammeName, "CollegeName");

			scrollElementIntoView(loc_ProgrammeName);

			clickOn(loc_ProgrammeType, "ProgrammeType");
			clickOn(loc_Progammeloc, "No Distance Learning");

			selectDropdownValue(loc_StartYearEQ, "StartYear", StartYear);
			selectDropdownValue(loc_StartMonthEQ, "StartMonth", StartMonth);
			selectDropdownValue(loc_EndYearEQ, "EndYear", EndYear);
			selectDropdownValue(loc_EndMonthEQ, "EndMonth", EndMonth);

			scrollElementIntoView(loc_EndMonthEQ);

			clickOn(loc_StudyStatus, "StudyStatus");
			
			sendKeys(loc_CertifciationnUmber, ProgrammeName, "CertifciationnUmber");
			sendKeys(loc_AddinfoEQ, Addinfo, "Info");

			clickOn(loc_MovetoProfessional, "MovetoProfessionalQualifcation");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void Profesionalqualification() {

		try {
			ReadWriteExcel.setExcelFile(SheetPath, "CandidateRegistration");

			String QualificationValue = ReadWriteExcel.getCellData(42, 6);
			String InstituteValue = ReadWriteExcel.getCellData(43, 6);
			String StatusValue = ReadWriteExcel.getCellData(44, 6);
			String CountryValue = ReadWriteExcel.getCellData(55, 6);

			sendKeys(loc_QualificationPQ, QualificationValue, "Qualification");
			sendKeys(loc_Institute, InstituteValue, "Qualification");

			sendKeys(loc_StatusPQ, StatusValue, "Qualification");

			scrollElementIntoView(loc_SatePQ);

			selectDropdownValue(loc_CountryPQ, "Country", CountryValue);

			((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");

			Thread.sleep(2000);

			clickOn(loc_NofurtherPQ, " No further details checkbox");
			Thread.sleep(2000);

			clickOn(loc_MovetoProfessionalReference, "MovetoProfessionalReference");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void professionalrefrence() {

		try {

			ReadWriteExcel.setExcelFile(SheetPath, "CandidateRegistration");

			String RefrenceNameValue = ReadWriteExcel.getCellData(42, 12);
			String CountryPf = ReadWriteExcel.getCellData(46, 12);
			String Telephonepf = ReadWriteExcel.getCellData(47, 12);
			String EmailValue = ReadWriteExcel.getCellData(48, 12);

			sendKeys(loc_Namepf, RefrenceNameValue, "Reference Name");

			selectDropdownValue(loc_Countrypf, "Country", CountryPf);

			sendKeys(loc_Phonepf, Telephonepf, "Phone Number");

			((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");

			Thread.sleep(2000);

			clickOn(loc_Nofurtherdetailspf, "No Further details");
			Thread.sleep(2000);

			clickOn(loc_movetoidentitydetails, "MovetoProfessionalReference");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void identitydetails() {

		try {
			ReadWriteExcel.setExcelFile(SheetPath, "CandidateRegistration");
			String PrimeNationality = ReadWriteExcel.getCellDataString(42, "P");
			String Countryofbirth = ReadWriteExcel.getCellDataString(44, "P");

			String IssuingCountry = ReadWriteExcel.getCellDataString(47, "P");

			String IdentityType = ReadWriteExcel.getCellDataString(48, "P");
			String IdentityNumber = ReadWriteExcel.getCellDataString(49, "P");

			selectDropdownValue(loc_primarynationalityid, "PrimeNationality", PrimeNationality);

			selectDropdownValue(loc_countryofbirthid, "countryofbirth", Countryofbirth);

			selectDropdownValue(loc_issucountryid, "Issuing Country", IssuingCountry);
			Thread.sleep(2000);
			selectDropdownValue(loc_idtypeid, "IdentityType", IdentityType);

			sendKeys(loc_idnumberid, IdentityNumber, "IdentityNumber");

			((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");

			Thread.sleep(2000);
			clickOn(loc_anotherthirdid, "No other Details");

			clickOn(loc_Movetocareergaps, "Movetocareergaps");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void careergaps() {

		try {
			ReadWriteExcel.setExcelFile(SheetPath, "CandidateRegistration");
			String startyear = ReadWriteExcel.getCellDataString(43, "T");
			String startMonth = ReadWriteExcel.getCellDataString(44, "T");

			String startdate = ReadWriteExcel.getCellDataString(45, "T");

			String Endyear = ReadWriteExcel.getCellDataString(46, "T");

			String EndMonth = ReadWriteExcel.getCellDataString(47, "T");
			String EndDate = ReadWriteExcel.getCellDataString(48, "T");
			String Reason = ReadWriteExcel.getCellDataString(49, "T");

			selectDropdownValue(loc_startyear, "startyear", startyear);
			selectDropdownValue(loc_startmonth, "startMonth", startMonth);

			selectDropdownValue(loc_startdate, "startdate", startdate);

			selectDropdownValue(loc_endyear, "Endyear", Endyear);
			selectDropdownValue(loc_endmonth, "EndMonth", EndMonth);

			selectDropdownValue(loc_enddate, "EndDate", EndDate);

			sendKeys(loc_reasongap, Reason, "Reason");
			Thread.sleep(2000);

			clickOn(loc_addcareergap, "Movetodeclaration");

			Thread.sleep(2000);

			clickOn(loc_Nofurtherdetails, "No further details");

			clickOn(loc_movetodeclaration, "Movetodeclaration");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void Declaration() {

		try {
			java.util.List<WebElement> AllNoOption = driver.findElements(By.xpath(loc_Noans));

			for (WebElement Question : AllNoOption) {

				clickUsingJSExecutor(Question, "No Ans");
				Thread.sleep(1000);
				scrollElementIntoView(Question);

			}

			clickOn(loc_Movetouploads, "Movetouploads");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void uploads() {

		try {

			clickOn(loc_ConsentUpload, "Consent Form Upload");
			Thread.sleep(2000);
			Runtime.getRuntime().exec("C:\\Users\\piyushwadhwa\\workspace\\Levels\\AutoIT\\Fileupload.exe");
			Thread.sleep(2000);

			clickOn(loc_consentuplodbutton, "Consent Form Upload");
			Thread.sleep(2000);

			clickOn(loc_Movetooverview, "Movetooverview");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void overview() {

	}

}
*/