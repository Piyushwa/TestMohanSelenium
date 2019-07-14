package testscripts;

import static org.testng.Assert.assertTrue;

import java.util.Set;

import javax.annotation.PreDestroy;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import baseclass.DriverHelper;
import locators.CommonLocators;
import pages.AnalystFunctions;
import pages.CandidateFunctions;
import pages.CaseQAFunctions;
import pages.ClientFunctions;
import pages.SupervisorFunctions;
import utilities.DatabaseConnectivity;
import utilities.ExecutionLog;
import pages.*;

@Listeners(baseclass.ListenerClass.class)

public class SmokeTestCase extends DriverHelper implements CommonLocators{

	public static Boolean EpectedReportStatus = true;

	//public static String FirstNamevalue =LevelFirstNamevalue;
			
			//"Automation_Candidate_20-May-2019 04_18_19 PM Test PW";
			
			//
	
	 
	 CandidateFunctions canf = new CandidateFunctions(driver);
	 
	 
	  @Test(priority = 0)
	  
	  
	  public void RegisterCandidate() throws Exception {
	  
	
			 login lg = new login(driver);

	  // lg.loggedin("Testteam1","Testqa@1234");
	  
	  String Pagetitle = lg.loggedin("Testteam1","Testqa@1234");
	  
	  Assert.assertEquals(Pagetitle, "Home");
	  
		 ClientFunctions cf = new ClientFunctions(driver);

	  
	  String First_Name = cf.registercandidate();
	  
	  ExecutionLog.Log(First_Name);
	  
	  String VerifyCandidateQuery =
	  "select * from candidate_master where first_name = '" + First_Name + "'";
	  String Candidate_ID =
	  DatabaseConnectivity.selectStringQueryforcolumn(VerifyCandidateQuery,
	  "Candidate_ID"); ExecutionLog.Log(Candidate_ID);
	  
	  try
	  
	  {
	  
	  Assert.assertTrue(Candidate_ID !=
	  null,"Candidate is not created in Databases");
	  
	  } catch (Exception e) {
	  
	  e.printStackTrace(); }
	  
	  ExecutionLog.Log("Candidate ID in Databasefor Created User " + Candidate_ID);
	  
	  }
	  
	  @Test(priority = 1)
	  
	  public  void CandidateInformationFill() throws Exception {
	  
	 CandidateFunctions canf = new CandidateFunctions(driver);
	  
	  canf.candidateinformationfill();
	  
	  canf.AddressDetails();
	  
	  canf.PermanentAddressDetails();
	  
	  canf.familydetails();
	  
	  canf.contactdetails();
	  
	  canf.employmenthistory();
	  
	  canf.Educationqualification();
	  
	  canf.Profesionalqualification();
	  
	  canf.professionalrefrence();
	  
	  canf.identitydetails();
	  
	  canf.careergaps();
	  
	  canf.Declaration();
	  
	  canf.uploads();
	  
	  canf.overview();
	  
	  canf.submitcandidateprofile();
	  
	  String VerifyCandidateQuery =
	  "select * from candidate_master where first_name = '" + LevelFirstNamevalue + "'";
	  String Case_ID =
	  DatabaseConnectivity.selectStringQueryforcolumn(VerifyCandidateQuery,
	  "case_ID");
	  
	  ExecutionLog.Log(Case_ID);
	  
	  try {
	  
	  Assert.assertTrue(Case_ID != null, "CaseID is not created in Databases");
	  
	  } catch (Exception e) {
	  
	  e.printStackTrace(); }
	  
	  }
	  
	  
	  @Test(priority = 2, description = "Verify Client On Going Cases")
	  
	  
	  public void verifyClientOngoingCase() throws Exception {
	  
	  Thread.sleep(2000);
	  
	  driver.navigate().refresh();
	  
pages.login lg = new pages.login(driver);
	  lg.loggedin("Testteam1","Testqa@1234");
	  
	 ClientFunctions clientfun = new ClientFunctions(driver);
	  
	 clientfun.NavigatetoClientongoingcase();
	  
	  String winHandleBefore = driver.getWindowHandle();
	  
	  verifyPagetitle("ongoingcase", "Ongoing Cases");
	  
	  clickOn(loc_Ongoingfirstcasereview, "Ongoing Report");
	  
	  
	  
	  Set<String> handles = driver.getWindowHandles();
	  
	  for(String windowHandle : handles) {
	  if(!windowHandle.equals(winHandleBefore)) {
	  driver.switchTo().window(windowHandle);
	  
	  driver.close(); driver.switchTo().window(winHandleBefore); } }
	  
	  Thread.sleep(2000);
	  
	  clientfun.VerifyclientOngoingfilters("Name", LevelFirstNamevalue);
	  
	  verifyTextMatches(loc_completecaseresult, "Candidate Name filter Result",
			  LevelFirstNamevalue);
	  
	  
	  }
	  
	  @Test(priority = 3)
	  
	  
	  
	  public static void Supervisor() throws InterruptedException, Exception {
	  
	  SupervisorFunctions sf = new SupervisorFunctions(driver);
	  
	  sf.Supervisoraction();
	  
	  String Case_Name = sf.verifysupervisoraction();
	  
	  System.out.println(LevelFirstNamevalue);
	  
	  Assert.assertTrue(Case_Name.contains(LevelFirstNamevalue));
	  
	  }
	 
	  
	  @Test(priority = 4) public static void Analyst() throws InterruptedException,
	  Exception {
	  
	  AnalystFunctions af = new AnalystFunctions(driver);
	  
	af.Analystreview();
	  
	  af.Analystaction();
	  
	  }
	  
	  @Test(priority = 5) public static void TaskQA() throws InterruptedException,
	  Exception {
	  
	  TaskQAFunctions tq = new TaskQAFunctions(driver);
	  
	  tq.TaskQAaction();
	  
	  }
	  
	  @Test(priority = 6) public static void CaseQA() throws InterruptedException,
	  Exception {
	  
	  CaseQAFunctions cq = new CaseQAFunctions(driver);
	  
	  cq.CaseQAaction();
	  
	  }
	 
	@Test(priority = 7)

	public static void FinalQA() throws InterruptedException, Exception {

		FinalQA fq = new FinalQA(driver);

		Boolean FinalReprt = fq.FinalQAaction();

		System.out.println(FinalReprt);

		Assert.assertEquals(FinalReprt, EpectedReportStatus);

	}
	
	@Test(priority = 8)

	public static void VerifySupCompletedCase() throws InterruptedException, Exception {

		  SupervisorFunctions sf = new SupervisorFunctions(driver);

	String CaseCompletestatus = sf.SupcompletedCase();
	
Assert.assertEquals(CaseCompletestatus, "Report Ready");

	}

	@Test(priority = 9)

	public static void VerifySupArchivedCase() throws InterruptedException, Exception {


	}

	
	
}
