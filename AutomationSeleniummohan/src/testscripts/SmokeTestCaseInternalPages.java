package testscripts;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import baseclass.DriverHelper;
import locators.InternalLocators;
import pages.SupervisorFunctions;
import pages.login;
import utilities.ReadWriteExcel;

@Listeners(baseclass.ListenerClass.class)

public class SmokeTestCaseInternalPages extends DriverHelper implements InternalLocators {
	// public static String FirstNamevalue = LevelFirstNamevalue;

	public static String SheetPath = System.getProperty("user.dir") + "\\TestData\\InputFile.xlsx";

	
	
	  @Test(priority = 0)
	  
	  public void verifySupArchivedCases() throws InterruptedException, Exception {
	  
	  navigatetourl(URL); login lg = new login(driver); lg.loggedin("Piyush_team",
	  "V_q!GE[HeH"); Thread.sleep(2000); clickOn(loc_supnavigationtab,
	  "supnavigationtab");
	  
	  clickOn(loc_SupArchivedCase, "SupArchivedCase");
	  
	  Thread.sleep(2000); verifyPagetitle("Archived Cases", "Archived Cases");
	  SupervisorFunctions sf = new SupervisorFunctions(driver); String Archivecase
	  = sf.actionarchivecase(); Thread.sleep(2000);
	  verifyElementPresent(Archivecase, "Archivecase");
	  
	  }
	  
	  
	  @Test(priority = 1)
	  
	  public void verifySupCandidateManagement() throws InterruptedException,
	  Exception {
	  
	  Thread.sleep(2000); clickOn(loc_supnavigationtab, "supnavigationtab");
	  
	  clickOn(SupCandidateManagement, "SupCandidateManagement");
	  
	  Thread.sleep(2000); verifyPagetitle("Candidate Management",
	  "Candidate Management"); }
	  
	  @Test(priority = 2)
	  
	  public void verifyCaseDownloadPage() throws InterruptedException, Exception {
	  
	  clickOn(loc_supnavigationtab, "supnavigationtab");
	  
	  clickOn(loc_SupCaseDownloadoption, "SupCaseDownloadoption");
	  
	  Thread.sleep(2000); verifyPagetitle("Case Download", "Case Download");
	  
	  }
	  
	  @Test(priority = 3)
	  
	  public void verifyCaseSearchPage() throws InterruptedException, Exception {
	  
	  Thread.sleep(2000); clickOn(loc_supnavigationtab, "supnavigationtab");
	  
	  clickOn(loc_SupCaseSearchoption, "SupCaseSearchoption"); Thread.sleep(2000);
	  verifyPagetitle("Sup CaseSearch option", "Case Search"); SupervisorFunctions
	  sf = new SupervisorFunctions(driver); sf.Casesearch("First Name",
	  LevelFirstNamevalue); Thread.sleep(2000);
	  
	  verifyTextMatches(loc_FilterResult, "FilterResult", LevelFirstNamevalue);
	  
	  }
	 
	@Test(priority = 4)
	public void verifyClientSettingsPage() throws InterruptedException, Exception {
		
		 navigatetourl(URL);
		  login lg = new login(driver);
	lg.loggedin("Piyush_team", "V_q!GE[HeH");

		ReadWriteExcel.setExcelFile(SheetPath, "Supervisor");

		String ClientName = ReadWriteExcel.getCellDataString(3, "G");
		String PackageName = ReadWriteExcel.getCellDataString(4, "G");

		Thread.sleep(2000);
		clickOn(loc_supnavigationtab, "supnavigationtab");

		clickOn(loc_ClientSettings, "Client Settings");
		Thread.sleep(2000);
		verifyPagetitle("Client Setting option", "Client Setting");

		SupervisorFunctions sf = new SupervisorFunctions(driver);
		sf.ClientSettingsfind(ClientName, PackageName);

		String text = getText(loc_firstcheckname);
		
System.out.println(text);
		verifyTextMatches(loc_firstcheckname, "Check Name", "Check");

	}

	@Test(priority = 5)
	public void verifyCustomEditPage() throws InterruptedException, Exception {

		clickOn(loc_supnavigationtab, "supnavigationtab");

		clickOn(loc_SupCustomEditoption, "CustomEditoption");
		Thread.sleep(2000);
		verifyPagetitle("Custom Edit", "Custom Edit");
		SupervisorFunctions sf = new SupervisorFunctions(driver);
		sf.Customeditfilter("FirstName", "Automation");

	}

	@Test(priority = 6)
	public void verifySupManageUsersPage() throws InterruptedException, Exception {

		clickOn(loc_supnavigationtab, "supnavigationtab");
		clickOn(loc_SupManageUsersoption, "Manage User");
		verifyPagetitle("Manage Uers", "manageUser");

		SupervisorFunctions sf = new SupervisorFunctions(driver);
		sf.Manageuserfilter("UserName", "Automation");
		
		
		if(driver.getTitle().equalsIgnoreCase("Error")) {
			
		clickOn(loc_Errorexit, "Exit Error");	
		}

	}

	

	@Test(priority = 7)

	public void verifyClientcheckreqPage() throws InterruptedException, Exception {
		
	
		
		

		ReadWriteExcel.setExcelFile(SheetPath, "Supervisor");

		String ClientName = ReadWriteExcel.getCellDataString(3, "G");
		clickOn(loc_supnavigationtab, "supnavigationtab");
		Thread.sleep(2000);
		clickOn(loc_SupClientReqoption, "Client Requirement");
		Thread.sleep(2000);
		verifyPagetitle("Client Requirement", "Client’s Check Requirements");

		selectDropdownValue(loc_ClientDropdown, "Client Dropdown", ClientName);

		clickOn(loc_Searchbutton, "Search Button");

		verifyElementPresent(loc_AddCheckReq, "Add Req");

		clickOn(loc_AddCheckReq, "Add req");

		Thread.sleep(2000);

		clickOn(loc_CloseCheckReq, "Close req");

	}

	@Test(priority = 8)
	public void verifySupNewtask() throws InterruptedException, Exception {

		clickOn(loc_SupTaskOption, "SupTaskOption");
		Thread.sleep(2000);
		clickOn(loc_SupNewTask, "SupNewTask");
		Thread.sleep(2000);
		verifyPagetitle("New Tasks", "New Task");

	}

	@Test(priority = 9)
	public void verifySupOngoingtask() throws InterruptedException, Exception {

		clickOn(loc_SupTaskOption, "SupTaskOption");
		Thread.sleep(2000);
		clickOn(loc_Supongoingtask, "Supongoingtask");
		Thread.sleep(2000);
		verifyPagetitle("Ongoing Tasks", "Ongoing Task");

	}

	@Test(priority = 10)
	public void verifySupCompletedtask() throws InterruptedException, Exception {

		clickOn(loc_SupTaskOption, "SupTaskOption");
		Thread.sleep(2000);
		clickOn(loc_SupCompletedtask, "SupCompletedtask");
		Thread.sleep(2000);
		verifyPagetitle("Completed Task", "Completed Task");

	}

	@Test(priority = 11)
	public void verifySupTransferredtaskPage() throws InterruptedException, Exception {
		ReadWriteExcel.setExcelFile(SheetPath, "Supervisor");
		String ClientName = ReadWriteExcel.getCellDataString(21, "B");
		String AnalystName = ReadWriteExcel.getCellDataString(22, "B");
		String Status = ReadWriteExcel.getCellDataString(23, "B");

		clickOn(loc_SupTaskOption, "SupTask");
		Thread.sleep(2000);
		clickOn(loc_SupTransferredTask, "Transferred Task");
		Thread.sleep(2000);
		
		verifyPagetitle("Transferred Task", "Transferred Task");
		SupervisorFunctions sf = new SupervisorFunctions(driver);
		sf.Transferredtask(ClientName, AnalystName, Status);
	}

	@Test(priority = 12)

	public void verifyIITaskPage() throws InterruptedException, Exception {
		ReadWriteExcel.setExcelFile(SheetPath, "Supervisor");

		String ClientName = ReadWriteExcel.getCellDataString(3, "K");

		String AnalystName = ReadWriteExcel.getCellDataString(4, "K");

		Thread.sleep(2000);

		clickOn(loc_SupTaskOption, "SupTask");
		Thread.sleep(2000);
		clickOn(loc_SupIITask, "Sup II task");
		Thread.sleep(2000);
		verifyPagetitle("Incomplete Info Tasks", "Incomplete Information");

		SupervisorFunctions sf = new SupervisorFunctions(driver);
		sf.IITaskFilter(ClientName, AnalystName);
		verifyPagetitle("Incomplete Info Tasks", "Incomplete Information");

	}

	@Test(priority = 13)

	public void verifyContactDatabasePage() throws InterruptedException, Exception {
		Thread.sleep(2000);

		clickOn(loc_SupTaskOption, "SupTask");

		Thread.sleep(2000);

		clickOn(loc_SupContactDatabse, "Contact Databse");

		Thread.sleep(2000);

		verifyPagetitle("Contacts to approve", "Contacts to approve");

	}

	@Test(priority = 14)
	public void verifySupMessagethread() throws InterruptedException, Exception {

		Thread.sleep(2000);

		clickOn(loc_SupMessageThread, "Sup Message Thread");
		Thread.sleep(2000);

		verifyPagetitle("Message thread", "Message thread");

	}

	@Test(priority = 15)
	public void verifySupStatistics() throws InterruptedException, Exception

	{
		
		
		ReadWriteExcel.setExcelFile(SheetPath, "Supervisor");

		String ClientName = ReadWriteExcel.getCellDataString(3, "K");

		clickOn(loc_SupStatistics, "Sup Statistics");

		Thread.sleep(2000);

		verifyPagetitle("Statistics", "Statistics");
		
		clickOn(loc_SupStatSearch, " Search Client");
		
		String loc_ClientName = "//span[contains(text(),'"+ClientName+"')]";
		
		clickOn(loc_ClientName, "Client Name");

		selectDropdownValueByIndex(loc_SupStatDataEnteries, "DataEnteries", 1);
		
		selectDropdownValueByIndex(loc_SupstatCharttype, "DataEnteries", 1);
		
		selectDropdownValueByIndex(loc_Supstatxaxis, "DataEnteries", 1);
		
		clickOn(loc_SupstatGeneratebtn, "Generate button");

		Thread.sleep(2000);
		

		clickOn(loc_SupMISReport, "Sup MIS report");
		
         clickOn(loc_SupStatSearch, " Search Client");
		
 		Thread.sleep(2000);

		clickOn(loc_ClientName, " Client Name");

		clickOn(loc_supMISreportGenbtn, "MIS Report");

		

	}

}
