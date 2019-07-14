package testscripts;

import java.io.File;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utilities.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import baseclass.DriverHelper;
import locators.CommonLocators;
import pages.ClientFunctions;
import pages.login;
import utilities.DatabaseConnectivity;
import utilities.ExecutionLog;

@Listeners(baseclass.ListenerClass.class)

public class SmokeTestCaseClientPages extends DriverHelper implements CommonLocators {

	//public static String FirstNamevalue = LevelFirstNamevalue;
			
			

	@Test(priority = 0, description = "Verify Client Home")

	public void verifyclientthome() throws InterruptedException, Exception {

		navigatetourl(URL);
		login lg = new login(driver);
		lg.loggedin("Testteam1", "Testqa@1234");
		ClientFunctions clientfun = new ClientFunctions(driver);
		verifyElementPresent(loc_Searchbutton, "HomeButton");
		clientfun.Verifyclienthomefilters("Name","Automation_Candidate_14-May-2019 11_23_37 AM Test PW");
		String Text = getText(loc_SearchResult);
		ExecutionLog.Log("Result is " + Text);
		verifyElementPresent(loc_SearchResult, "Results are avilable");

	}

	@Test(priority = 1, description = "Verify RegisterMultiple Candidate ")

	public void verifyRegisterMultipleCandidate() throws Exception {

		ClientFunctions clientfun = new ClientFunctions(driver);

		clientfun.NavigatetoRegisterMultipleCandidate();
		clientfun.uploadRegisterMutlipleCandidate();

		verifyTextMatches(loc_Successmesage, "Success Message", "Your candidates have been registered successfully.");

	}

	@Test(priority = 2, description = "Verify Candidate Management")

	public void verifyCandidateManagement() throws Exception {

		ClientFunctions clientfun = new ClientFunctions(driver);

		clientfun.NavigatetoCandidateManagement();

		verifyPagetitle("CandidateManagement", "Candidate Management");

		clickOn(loc_ParentActionCheck, "Parent Action Check");

		verifyElementEnable(loc_Exporttoexcel, "Export To excel");

		verifyElementEnable(loc_Exporttoexcel, "Export To excel");

		verifyElementEnable(loc_DeleteProfile, "DeleteProfile");

		verifyElementEnable(loc_SendRemider, "SendRemider");

		verifyElementEnable(loc_Reactivate, "Reactivate");

		clickOn(loc_Exporttoexcel, "Export To Excel");

	}

	@Test(priority = 3, description = "Verify Client On Going Cases")

	public void verifyClientOngoingCase() throws Exception {

		ClientFunctions clientfun = new ClientFunctions(driver);

		clientfun.NavigatetoClientongoingcase();

		String winHandleBefore = driver.getWindowHandle();

		verifyPagetitle("ongoingcase", "Ongoing Cases");

		clickOn(loc_Ongoingfirstcasereview, "Ongoing Report");

		Set<String> handles = driver.getWindowHandles();

		for (String windowHandle : handles) {
			if (!windowHandle.equals(winHandleBefore)) {
				driver.switchTo().window(windowHandle);

				driver.close();
				driver.switchTo().window(winHandleBefore);
			}
		}

		Thread.sleep(2000);

	
	}

	@Test(priority = 4, description = "Verify Client Completed Cases")

	public void verifyClientCompletedCases() throws Exception {

		ClientFunctions clientfun = new ClientFunctions(driver);

		clientfun.NavigatetoClientCompletedCase();

		verifyPagetitle("CompletedCases", "Completed Cases");

		clientfun.VerifyclientOngoingfilters("Name",LevelFirstNamevalue);

		String CaseIDquery = "select case_id, * from candidate_master where first_name  = '" +LevelFirstNamevalue+"'";

		String CaseID = DatabaseConnectivity.selectStringQueryforcolumn(CaseIDquery, "case_id");

		String loc_ReportDownload = "//a[@href='/Client/generateReportWithComments?caseId=" + CaseID + "']";

		clickOn(loc_ReportDownload, "ReportDownload");

		Thread.sleep(4000);

		File latestfile = getLatestFilefromDir("C:\\Downloads");
		String latestfilename = latestfile.getName();
		String FIlepath = DriverHelper.downloadPath + "\\"+latestfilename;

		Assert.assertTrue(ReadandParseDocxFile.readdocfile(FIlepath, "Case Information"));
	}

	@Test(priority = 5, description = "Verify Client Archived Cases")

	public void verifyClientArchivedCases() throws Exception {

		ClientFunctions clientfun = new ClientFunctions(driver);

		clientfun.NavigatetoArchivedCase();

		verifyPagetitle("ArchivedCases", "Archived Cases");

		clientfun.VerifyclientOngoingfilters("Name", "Automation_Candidate_14-May-2019 09_46_39 AM Test PW ");

	}

	@Test(priority = 6, description = "Verify Client Normal Upload")

	public void verifyClientNormalUploads() throws Exception

	{

		ClientFunctions clientfun = new ClientFunctions(driver);

		clientfun.NavigatetoNormaluploads();

		verifyPagetitle("NormalUploads", "Normal Uploads");

		clientfun.ActiononNormlupload();

		verifyTextMatches(loc_Normaluploadsuccessmesg, "Success Meesage", "Document uploaded successfully.");

	}

	@Test(priority = 7, description = "Verify Client Bulk Upload")

	public void verifyClientBulkUploads() throws Exception {

		ClientFunctions clientfun = new ClientFunctions(driver);

		clientfun.Navigatetobulkupload();

		verifyPagetitle("BulkUploads", "Bulk Uploads");

		clientfun.ActiononBulkupload();

		verifyTextMatches(loc_BUSuccessmessage, "Success Meesage", "Documents uploaded successfully.");

	}

	@Test(priority = 8, description = "Verify Client Case Upload")

	public void verifyClientCaseUpload() throws Exception {
		ClientFunctions clientfun = new ClientFunctions(driver);

		clientfun.Navigatetocaseupload();
		
		verifyPagetitle("CaseUpload", "Case Upload");

		clientfun.ActiononCaseupload();

		File downloadfile = getLatestFilefromDir(downloadPath);

		String FileName = downloadfile.getName();

		Assert.assertTrue(isFileDownloaded(downloadPath, FileName));

	}

	@Test(priority = 9, description = "Verify MIS Report")

	public void VerifyMISReport() throws Exception {

		ClientFunctions clientfun = new ClientFunctions(driver);
		clickOn(loc_MISReport, "MISReport");
		verifyPagetitle("MISReport", "Statistics");

		Boolean Flag = clientfun.GenerateStatisticsMISReport();
		Boolean expected = true;
		Assert.assertEquals(Flag, expected);

		clientfun.GenerateMISReport();

	}

	@Test(priority = 10, description = "Verify Message Thread")
	public void VerifyMessagethread() throws Exception {

		ClientFunctions clientfun = new ClientFunctions(driver);
		clientfun.NavigatetoMessagethread();

		verifyPagetitle("Message Thread", "Message Thread");

	}

	@Test(priority = 11, description = "Verify Settings")
	public void VerifySettings() throws Exception {

		ClientFunctions clientfun = new ClientFunctions(driver);
		clientfun.NavigatetoClientSettings();

		verifyPagetitle("Settings", "Settings");

	}

	@Test(priority = 12, description = "Verify Change Password")
	
	public void VerifyChangePassword() throws Exception {

ClientFunctions clientfun = new ClientFunctions(driver);
clientfun.NavigatetoChangePassword();
verifyPagetitle("Change Password", "Change Password");

	}

}
