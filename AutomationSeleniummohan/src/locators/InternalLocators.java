package locators;

public interface InternalLocators {

	// *****supervisor*****
	String loc_supnavigationtab = "//a[contains(text(),'Sup Navigation')]";
	String loc_supnewcases = "//a[contains(text(),'New Cases')]";
	String loc_supcaseaction = "//a[contains(text(),'New Cases')]";
	String loc_Assignalltoonealayst = "//select[@id='opIDForAllChecks']";
	String loc_AssignAllButton = "//input[@id='assignall']";
	String loc_SupervisorNotes = "//textarea[@id='case_comments']";
	String loc_AddINtialIISupervisor = "//textarea[@id='initial']";
	String loc_Update = "//input[@id='Update']";
	String loc_supOngoingcase = "//a[contains(text(),'Ongoing Cases')]";
	
	//Supervisor Menu Option
	
	String loc_SupArchivedCase = "//li[@class='SuparchiveCases']//a[contains(text(),'Archived Cases')]";
	String SupCandidateManagement = "//li[@class='SupprofileManagement']//a[contains(text(),'Candidate Management')]";
	String loc_SupCaseDownloadoption = "//a[contains(text(),'Case Download')]";
	String loc_SupCaseSearchoption = "//li[@class='SupcaseSearch']//a[contains(text(),'Case Search')]";
	String loc_SupRemarksoption = "//li[@class='SupClientSetting']//a[contains(text(),'Remarks')]";
	String loc_SupCustomEditoption = "//a[contains(text(),'Custom Edit')]";
	String loc_SupManageUsersoption = "//li[@class='Supmanageuser']//a[contains(text(),'Manage Users')]";
	String loc_SupClientReqoption = "//a[contains(text(),'Client’s Check Requirements')]";
    String loc_SupTaskOption = "//a[contains(text(),'Sup Task')]";
	String loc_SupNewTask = "//a[contains(text(),'New Task')]";
     String loc_Supongoingtask = "//a[contains(text(),'Ongoing Task')]";
     String loc_SupCompletedtask = "//a[contains(text(),'Completed Task')]";
     String loc_SupTransferredTask = "//a[contains(text(),'Transferred Task')]";
     String loc_SupIITask = "//a[contains(text(),'II Task')]";
     String loc_SupContactDatabse = "//a[contains(text(),'Contact Database')]";
     String loc_SupMessageThread = "//a[contains(text(),'Message Thread')]";
     String loc_SupStatistics = "//li[@class='SupStatistics']//a[contains(text(),'Sup Statistics')]";
     String loc_SupMISReport = "//*[@id='Overviewli'] ";
     String loc_SupHome = "//li[@class='SupIndex']//a[contains(text(),'Sup Home')]";
     String loc_Supbilling = "//a[contains(text(),'SupBilling')]";
     
     String loc_SupFilterType = "//select[@id='selectFilter']";
     String loc_SupClientNameFilter = "//select[@id='clientId']";
     String loc_DownloadInitialII = "//input[@id='btnDownload']";
     String loc_FilterSearchbutton = "//input[@id='btnsubmit']";

	// *****Analyst*****
	String loc_Yourtask = "//a[contains(text(),'Your Task')]";
	String loc_Assigndate = "//th[@class='heading_top header'][contains(text(),'Assign Date')]";
	String loc_Assigndate2 = "//*[@id='report']/thead/tr/th[8]";
	String loc_Statustab = "//a[contains(text(),'Status Update')]";
	String loc_InProgressTab = "//a[contains(text(),'In-progress')]";
	String loc_supcomletedcase = "//a[contains(text(),'Completed Cases')]";
	String loc_SupCompletedCaseStatus = "//*[@id='report']/tbody/tr[1]/td[3]";
	

	//Employment

	String loc_analystempactivity = "//*[@id='searchEntityActivity']";
	String loc_empcheckActionnotes = "//textarea[@id='checkNotes']";
	String loc_empresponsereceived = "//img[@title='Response Received']";
	String loc_analystempwritereport = "//a[contains(text(),'Write Report')]";
	String loc_executivesummary = "//*[@id='checkMaster_exe_summary']";
	String loc_empreportnotes = "//*[@id='checkMaster_check_notes']";

	String loc_companynameemp = "//*[@id='company_name_comment']";
	String loc_countryemp = "//*[@id='employer_country_comment']";
	String loc_jobtitleemp = "//*[@id='job_title_comment']";
	String loc_corptitleemp = "//*[@id='CorporateTitle_comment']";
	String loc_empperiodemp = "//*[@id='emp_period_comment']";
	String loc_supnameemp = "//*[@id='last_supervisor_comment']";
	String loc_suptitleemp = "//*[@id='last_sup_title_comment']";
	String loc_fixedsalaryemp = "//*[@id='last_salary_comment']";
	String loc_bonusemp = "//*[@id='last_bonus_comment']";
	String loc_renumemp = "//*[@id='other_rem_comment']";
	String loc_reasondeptureemp = "//*[@id='departure_reason_comment']";
	String loc_Infringement = "//*[@id='infringement_org_rule']";
	String loc_disciplinary = "//*[@id='disciplinary_action']";
	String loc_rehire = "//*[@id='rehire_eligibility']";
	String loc_remarks = "/html";
	String loc_addcomment = "//*[@id='checkPerformance_additional_comment']";
	String loc_commentby = "//*[@id='checkPerformance_commented_by']";
	String loc_checkperformdate = "//*[@id='checkPerformance_Date']";
	String loc_verifiedby = "//*[@id='checkMaster_verified_by']";
	String loc_contactdetails = "//*[@id='checkMaster_verified_by_contact']";
	String loc_verifieddate = "//*[@id='checkMaster_verified_date']";
	String loc_savebtn = "//input[@value='Save']";
	String loc_submitbtn = "//input[@value='Submit']";
    String loc_Remarkframe = "//div[@class='cleditorMain']//iframe";

	// Education

	String loc_analysteduactivity = "//*[@id='searchEntityActivity']";
	String loc_analysteduwritereport = "//a[contains(text(),'Write Report')]";
	String loc_eduexecutivesummary = "//*[@id='checkMaster_exe_summary']";
	String loc_eduNotessummary = "//*[@id='checkMaster_check_notes']";

	String loc_eduinsititute = "//*[@id='comment_insti_name']";
	String loc_educountry = "//*[@id='education_country_comment']";
	String loc_eduqualification = "//*[@id='comment_qualification']";
	String loc_eduattendancedate = "//*[@id='comment_attendence_date']";
	String loc_edugraddate = "//*[@id='comment_graduation_date']";
	String loc_eduprogtype = "//*[@id='program_type']";
	String loc_eduexternal = "//*[@id='comment_externalProgramType']";
	String loc_eduexternalcountry = "//*[@id='comment_externalStayCountry']";
	String loc_eduaccrestatus = "//*[@id='accrediation_status']";
	String loc_eduaccreorg = "//*[@id='accrediation_organization']";
	String loc_edusource = "//*[@id='source']";
	String loc_edustudymode = "//*[@id='ModOfStudy']";
	String loc_eduremarks = "/html";
	String loc_eduverifiedby = "//*[@id='checkMaster_verified_by']";
	String loc_educontactdetails = "//*[@id='checkMaster_verified_by_contact']";
	String loc_eduverifieddate = "//*[@id='checkMaster_verified_date']";

	//AddressVerification
	String addverNotes  = "//*[@id='checkMaster.check_notes']";
	String loc_addveraddcomment = "//*[@id= 'comment_address']";
	String loc_addNatureofaddcomment = "//*[@id= 'comment_Add_nature']";
	String loc_addverResPeriodComment = "//*[@id= 'comment_residancy_period']";
	String loc_addverRelationcomment = "//*[@id= 'Respondent_Relation']";
	
//ProfessionalReference

String loc_RefrenceRole = "//*[@id='main_duty_resp']";
	// Database

	String loc_analystdbwritereport = "//a[contains(text(),'Write Report')]";
	String loc_dbexesummary = "//*[@id='exe_summary']";
	String loc_dbnote = "//textarea[@id='check_notes']";
	String loc_dbdescription = "//*[@id='check_comments']";
	String loc_dbdate = "//*[@id='verified_date']";
	String loc_bodyframe = "//html";
	
	// Professional Qualification
	
	String loc_verifiedBy = "//textarea[@id='checkMaster_verified_by']";
	
	
	
	
	// QA
	String loc_QAindex = "//a [@href='/QA/Index/']";
	String loc_QAMyChecks = "//a[contains(text(),'My Checks')]";
	String loc_QAchecknotes = "//textarea[@id='checkMaster_check_notes']";
String loc_QASubmitcheck = "//td[contains(text(),'Supplementary awaited')]//input[@value='Submit']";
	// Case QA
	String loc_caseQAindex = "//a[contains(text(),'CaseQA Home')]";
	String loc_CaseQAMyChecks = "//li[@class='CaseQAmyCasesList']";
	String loc_CaseQASubmitcase = "//input[@id='submit']";

	// Final QA
//Employee Details
	String loc_FinalQAindex = "//a[contains(text(),'FinalQA Home')]";
	String loc_FinalMyCase = "//a[@href='/SeniorSup/myFinalCasesList']";
	String loc_FinalQAComments = "//textarea[@id='caseqacomments']";
	String loc_empDetailsCompNameNotes  = "//*[@id='empDetails_0__company_name_comment']";
	String loc_empDetailsCountryNotes  = "//*[@id='empDetails_0__employer_country_comment']";
	String loc_empDetailsJobTitleNotes  = "//*[@id='empDetails_0__job_title_comment']";
	String loc_empDetailsCorporateTitleNotes  = "//*[@id='empDetails_0__CorporateTitle_comment']";
	String loc_empDetailsEmpPeriodNotes  = "//*[@id='empDetails_0__emp_period_comment']";
	String loc_empDetailsLastSupNotes  = "//*[@id='empDetails_0__last_supervisor_comment']";
	String loc_empDetailsLastSupTitleNotes  = "//*[@id='empDetails_0__last_sup_title_comment']";
	String loc_empDetailsLastSalaryNotes  = "//*[@id='empDetails_0__last_salary_comment']";
	String loc_empDetailsBonusNotes  = "//*[@id='empDetails_0__last_bonus_comment']";
	String loc_empDetailsRemunerationNotes  = "//*[@id='empDetails_0__other_rem_comment']";
	String loc_empDetailsRODNotes  = "//*[@id='empDetails_0__departure_reason_comment']";
//Education Details
	String loc_eduDetailsInstNameNotes  = "//*[@id='eduDetails_0__comment_insti_name']";
	String loc_eduDetailsCountryNotes  = "//*[@id='eduDetails_0__education_country_comment']";
	String loc_eduDetailsQualNotes  = "//*[@id='eduDetails_0__comment_qualification']";
	String loc_eduDetailsDOANotes  = "//*[@id='eduDetails_0__comment_attendence_date']";
	String loc_eduDetailsGradDateNotes  = "//*[@id='eduDetails_0__comment_graduation_date']";
	String loc_eduDetailsProgTypeNotes  = "//*[@id='eduDetails_0__program_type']";
	String loc_eduDetailsLongDistNotes  = "//*[@id='eduDetails_0__comment_externalProgramType']";
	String loc_eduDetailsCountryofstayNotes  = "//*[@id='eduDetails_0__comment_externalStayCountry']";

	String loc_eduDetailsAccreditationNotes  = "//*[@id='eduDetails_0__accrediation_status']";
	String loc_eduDetailsAccrOrgotes  = "//*[@id='eduDetails_0__accrediation_organization']";
	String loc_eduDetailsSourceNotes  = "//*[@id='eduDetails_0__source']";	
	String loc_FinalQASaveAll = "//input[@id='saveAll']";
	String loc_FinalQASubmit = "//input[@id='submit1']";
	String loc_WordfinalReport = "//tbody/tr[2]/td[5]/a";
	
	//SenSuphome -- Menu Options
	
	String loc_SenSuphome = "//a[contains(text(),'Sen Sup Home')]";
	String loc_SenSupNavigation = "//a[contains(text(),'Sen Sup Navigation')]";
	String loc_SenSupNewCase = "//li[@class='SeniorSupNewcases']//a[contains(text(),'New Cases')]";
	String loc_SenSupOnGoingCase = " //li[@class='SeniorSupOngoingcases']//a[contains(text(),'Ongoing Cases')]" ; 
	String loc_SenSupCompleteCase = "//li[@class='SeniorSupsenSupCompletedCase']//a[contains(text(),'Completed Cases')]"; 
	String loc_SenSupArchieveCase = "//li[@class='SeniorSuparchiveCases']//a[contains(text(),'Archived Cases')]" ; 
	String loc_SenSupCandidateManagement = "//li[@class='SeniorSupprofileManagement']//a[contains(text(),'Candidate Management')] " ; 
	
	
	String loc_SenSupCaseSearch = " //li[@class='SeniorSupcaseSearch']//a[contains(text(),'Case Search')]" ; 
	
	
	String loc_SenSupSatistics = "//a[contains(text(),'Sen Sup Statistics')]";
	
	//New task
	String loc_NewTaskClientName= "//select[@id='ddlClientName']";
	String loc_Newtasksearchbutton = "//input[@id='btnsubmit']";
	String loc_NewtaskFiltertype ="//select[@id='selectFilter']";
	String loc_NewtaskFilterbutton = "//input[@id='Filter']";
	String loc_NewtaskAnalystname ="//select[@id='opIDForAllChecks']";
	String loc_NewTaskAssignbutton = "//input[@id='submitForm' and @value = 'Assign']";
	
	//IITask
	
	String loc_IIClientName= "//select[@id='ddlClientName']";
	String loc_IIAnalystName = "//select[@id='ddlAnalystName']";
	String loc_IISearch ="//input[@id='btnsubmit']";
	String loc_IIFirstClientName = "//tr[@id='40896']//td[contains(text(),'Testteam_client1')]";
		
	//Case Search
	
	String loc_CaseserachFiltervalue = "//select[@id='selectValue']";
	String loc_Caseserachfiltertext = "//input[@id='searchVal']";
	String loc_Caseserachfiltersubmit = "//input[@name='submit']";
	String loc_FilterResult  = "//a[contains(@href,'/Sup/candidateProfile?')]";
	
	//ManageUsers
	String loc_SenSupManageUsers = " //li[@class='SeniorSupmanageUser']//a[contains(text(),'Manage Users')]" ; 
	String loc_UserNamecheck = "//input[@value='Name' and @name='searchBy']";
	String loc_UserEmailcheck = "//input[@value='Email' and @name='searchBy']";
	String loc_ClientNamecheck = "//input[@value='ClientName' and @name='searchBy']";
	String loc_MUSearchBox = "//input[@id='searchString']";
	String loc_MUsearchbutton = "//input[@id='submitform']";
	
	
	//Client's Check requirement
	
String loc_ClientDropdown = "//select[@id='clientID']";
String loc_Searchbutton = "//input[@id='btnsubmit']";
String loc_AddCheckReq = "//a[@id='addnotes']";
String loc_CloseCheckReq = "//a[@id='closetr']";

//CustomEdit

String loc_CustEditName = "//input[@id='txtFName']";
String loc_CustEditMiddleName = "//input[@id='txtmiddlename']";
String loc_CustEditLastName = "//input[@id='txtLName']";
String loc_CustEditRefNo = "//input[@id='txtCaseRef']";
String loc_CueditFirstnamecheck = "//input[@value='SearchByFname' and @name='SearchBy']";
String loc_CueditMiddlenamecheck = "//input[@value='SearchByMname' and @name='SearchBy']";

String loc_CueditLastnamecheck = "//input[@value='SearchByLname' and @name='SearchBy']";

String loc_CueditRefnocheck = "//input[@value='SearchBycaseref' and @name='SearchBy']";

String loc_CuEditSearchbutton = "//input[@id='btn_search']";

//clientSettings

String loc_ClientSettings = "//li[@class='SupClientSetting']//a[contains(text(),'Client Setting')]";
String loc_ClientName ="//select[@id='client_id']";
String loc_CSpackagename = "//select[@id='pk_id']";
String loc_Finddetails = "//input[@value='Find details']";
String loc_firstcheckname = "//div[@class='half']//table[@class='myTable']//tr[2]//td[1]";
String loc_CScomment = "//textarea[@id='SupComments']";
String loc_CScommentSave = "//input[@onclick='AddSupRemark()']";


//Sup Statistics

String loc_SupStatSearch = "//span[@class='multiselect_span'][contains(text(),'Select Value')] ";
String loc_SupstatStartDate = "//input[@id='startDateStat']";
String loc_SupStatEnddate = "//input[@id='endDateStat']";
String loc_SupStatDataEnteries = "//select[@id='dataEntriesSelectedValue']";
String loc_SupstatCharttype = "//select[@id='chartType']";
String loc_Supstatxaxis = "//select[@id='xAxisType']";
String loc_SupstatGeneratebtn = "//input[@id='btnCharts']";
String loc_supMISreportGenbtn = "//input[@id='btnGetReports']";

//Transferred Task

String loc_SupTTClientname = "//select[@id='ddlClientName']";

String loc_SupTTAnalyst ="//select[@id='ddlAnalystName']";

String loc_SupTTStatus = "//select[@id='ddlStatus']";

String loc_SupTTSearchbutton = "//input[@id='btnsubmit']";

//ContactDatabase

String loc_EntitySearch = "//input[@id='searchString']";
String loc_GetEntitiesbutton = "//input[@id='getEntities']";
String loc_CreateContactbutton = "//input[@id='createEntityContact']";

//Error

String loc_Errorexit = "//a[contains(text(),'Exit')]";

	
}
