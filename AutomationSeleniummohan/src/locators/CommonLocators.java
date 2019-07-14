package locators;

import pages.CandidateFunctions;
import utilities.ReadWriteExcel;

public interface CommonLocators {

	public static String SheetPath = System.getProperty("user.dir") + "\\TestData\\InputFile.xlsx";

	String Gender = "";
	String Boolean = "";

	String loc_username = "//*[@id='login-step1-userid']";
	String loc_Password = "//*[@id='AuthenticationFG.ACCESS_CODE']";
	String loc_Forgot_Password = "//a[contains(text(),'Forgot my password')]";
	String loc_loginbutton = "//button[contains(text(),'Login')]";
	String loc_PrivacyPolicylink ="//u[contains(text(),'Privacy Policy')]";
	String loc_Agreecheck = "//*[@id='lblagreeYES']";
	String loc_Submit = "//input[@value= 'Submit']";

	// Client Home

	String loc_clientHomeRefnocheck = "//td[contains(text(),'Ref No')]//input[@id='searchResult_searchParameters']";
	String loc_clientHomeNamecheck = "//td[contains(text(),'Name')]//input[@id='searchResult_searchParameters']";
	String loc_EmployeeIdcheck = "//td[contains(text(),'Employee ID')]//input[@id='searchResult_searchParameters']";
	String loc_EmployeeCostcenter = "//td[contains(text(),'Cost Centre')]//input[@id='searchResult_searchParameters']";
	String loc_Filtervalue = "//input[@id='searchResult_searchString']";
	String loc_Searchbutton = "//input[@id='searchCases']";
	String loc_SearchResult = "//table[@id='replaceSearchResult']//tr[3]/td[1]";

//MultipleRegisterCandidate

	String loc_MultipleRegisterCandidate = "//a[contains(text(),'Register Multiple Candidate')]";
	String loc_uploadButton = "//input[@name='submit'][@value='Upload']";
	String loc_ChooseFile = "//input[@id='fileDetails']";
	String loc_CreateProfiles = "//input[@id='DisableSubmit'][@value='CREATE PROFILES']";
	String loc_Successmesage = "//strong[contains(text(),'Your candidates have been registered successfully.')]";

//CandidateManagement

	String loc_CandidateManagement = "//a[contains(text(),'Candidate Management')]";
	String loc_ParentActionCheck = "//input[@id='parentchkId']";
	String loc_Exporttoexcel = "//input[@id='downloadExcel']";
	String loc_DeleteProfile = "//input[@id='delete']";
	String loc_SendRemider = "//input[@id='reminder']";
	String loc_Reactivate = "//input[@id='activate']";

//MyCase
	
	String loc_MyCases = "//a[contains(text(),'My Cases')]";

//ongoingCase

	String loc_OngoingCase = "//a[contains(text(),'Ongoing Cases')]";
	String loc_Ongoingfirstcasereview = "//tr[1]//td[8]//a[1]//img[1]";
	String loc_clientRefnoOnGoingcheck = "//input[@id = 'searchResult_searchParameters'][@value='refNo']";
	String loc_clientNameOnGoingcheck = "//input[@id = 'searchResult_searchParameters'][@value='name']";
	String loc_clientEmpIDOnGoingcheck = "//input[@id = 'searchResult_searchParameters'][@value='employeeID']";
	String loc_clientEmpCostOnGoingcheck = "//input[@id = 'searchResult_searchParameters'][@value='costCentre']";
	String loc_ClientCompletionDateCheck = "//input[@id = 'searchResult_searchParameters'][@value='completionDate']";
;String loc_ongoingeportWOrd = "/html[1]/body[1]/div[1]/table[1]/tbody[1]/tr[5]/td[2]/table[1]/tbody[1]/tr[1]/td[1]";
String loc_Printbuttononreport = "//div[@id='op_footer_container_new']//table//tbody//tr//td//input";

//"//td[contains(text(),'Candidate Name')]";
//ClientCompletedCase	

	String loc_ClientCompletedCase = "//a[contains(text(),'Completed Cases')]";
	String loc_completecaseresult  = "//a[contains(@href,'/Client/candidateProfile/')]";
    String loc_CompleteCaseFIlterfrom = "//input[@id='searchResult_searchFromDate']";
    String loc_CompleteCaseFIlterto = "//input[@id='searchResult_searchToDate']";


//ArchivedCases 
	String loc_ArchivedCases = "//a[contains(text(),'Archived Cases')]";

//Uploads
	String loc_Upload = "//a[contains(text(), 'Uploads')] ";
	String loc_NormalUpload = "//a[contains(text(),'Normal Uploads')]";
	String loc_Bulkupload = "//a[contains(text(),'Bulk Uploads')]";
	String loc_firstcandidatefile = "//input[@name='[0].candidateUpload[0].fileDetails']";
	String loc_firstcandidateupload = "//*[@id='myTable']/tbody/tr[1]/td[8]/input[5]";
	
	String loc_Normaluploadsuccessmesg = "//strong[contains(text(),'Document uploaded successfully. ')]";
	String loc_Caseupload = "//a[contains(text(),'Case Upload')]";
	String loc_CUchoosefilebutton = "//input[@name='attachedFiles[0].fileDetailsList']";
	String loc_CUuploadbutton = "//input[@value='Upload Attachment']";
	String loc_CUDownloadFile = "//tr[2]//td[5]//a[1]";
	
	String loc_BUChoosefile = "//input[@name='fileDetails']";
	String loc_BUUploadfile = "//input[@name='submit']";
	String loc_BUFirstupload = "//input[@id='bulkUploads_0__upload']";
String loc_BUUpoadFilesbutton = "//table[@class='tablesorter']//input[@name='submit']";
String loc_BUSuccessmessage = "//strong[contains(text(),'Documents uploaded successfully.')]";

//MISReport
	String loc_MISReport = "//a[contains(text(),'MIS Reports')]";
	String loc_MISReportBoard = "//a[@id='Overviewli']";
	String loc_MISDataEnteries = "//select[@id='dataEntriesSelectedValue']";
	String loc_MISchartype = "//select[@id='chartType']";
	String loc_MISAxis = "//select[@id='xAxisType']";
	String loc_GenerateStatisticsButton = "//input[@id='btnCharts']";
    String loc_GenerateMISReport = "//input[@id='btnGetReports']";
	String loc_SettingsOption = "//a[contains(text(),'Settings')]";
	String loc_Reportresulttext = "//div[@id='heading']";
//MessageThread
	String loc_MessaageThread = "//a[contains(text(),'Message Thread')]";
//ChangePassword
	String loc_ChangePasswordoption = "//a[contains(text(),'Change Password')]";
//Client->CreateCase->RegisterCanditate
	String loc_Createcase = "//a[contains(text(),'Create Case')]";
	String loc_Candiate_Registration = "//a[contains(text(),'Register Candidate')]";
	String loc_HiringCountry = "//*[@id='caseDetails_0__hiring_country']";
	String loc_ResearchJurisdiction = "//*[@id='caseDetails_0__research_juridiction']";
	String loc_Language = "//*[@id='culture']";
	String loc_FirstName = "//*[@id='firstName']";
	String loc_MiddleName = "//*[@id='middleName']";
	String loc_LastName = "//*[@id='lastName']";
	String loc_MobileNo = "//*[@id='MobileNo']";
	String loc_Email = "//*[@id='email']";
	String loc_DOBYear = "//*[@id='dobYR']";
	String loc_DOBMonth = "//*[@id='dobMN']";
	String loc_DOBDate = "//*[@id='dobDT']";
	String loc_EmployeeStartDate = "//input[@id='Employee_start_date']";
	String loc_EmployeeID = "//*[@id='employeeID']";
	String loc_CostCenter = "//*[@id='costCenter']";
	String loc_Remark = "//*[@id='Remark']";
	String loc_EmployeeClass = "//*[@id='employeeClass']";
	String loc_RecruiterName = "//*[@id='recruiter']";
	String loc_EmployeeDepartment = "//*[@id='employee_department']";
	String loc_Designation = "//*[@id='Corporatetitle']";
	String loc_HRBusinessPartner = "//*[@id='employee_HRBP']";
	String loc_Package = "//*[@id='package']";
	String loc_AddCheckDD = "//*[@id='check']";
	String loc_AddCheckbutton = "//*[@id='addCheck']";
	String loc_Submitbutton = "//*[@id='Submit']";
	String loc_NoticeCancel = "/html/body/div[3]/div[3]/div/button[2]";
	String loc_NoticeCancel2 = "//button[contains(text(),'CANCEL')]";
	String loc_NoticeYes = "//button[contains(text(),'YES')]";
	String loc_RegistarionSuccess2 = "//*[@id='tablebodyClient']/h2";
	String loc_RegistarionSuccess1 = "//*[@id='footer_container']/font/strong";

//CandidateManagement

	String loc_CandidateManagementOption = "//*[@id='masterUl']/li[2]/ul/li[3]/a";
	String loc_Submitnext = "//*[@id='next']";
	String loc_Agreetermcheck = "//*[@id='lblBuagreeYES']";
	String loc_Iagree = "//*[@id='lblagreeYES']";
	String loc_IDisagree = "//*[@id='lblagreeNo']";
	String loc_WelcomeUnderstood = "//a[contains(text(),'UNDERSTOOD')]";

	String loc_Surname = "//*[@id='lastName'] ";
	String loc_legalFirstName = "//*[@id='txtfirstName'] ";
	String loc_middleName = "//input[@id='middleName']";
	String loc_Maidenname = "//*[@id='FormerName'] ";
	String loc_dobchange = "//input[@id='Date_of_Name_Change']";
	String loc_DateofNameChangeYear = "//select[@class='ui-datepicker-year']";
	String loc_DateofNameChangeMonth = "//select[@class='ui-datepicker-month']";
	String loc_PlaceofBirth = "//*[@id='Place_Of_Birth'] ";
	String loc_nickname = "//*[@id='nickName'] ";
	String loc_Title = "//select[@id='title']";
	String loc_otherlanguaecountry = "//select[@id='otherLanguage']";
	String loc_otherlanguaeName = "//*[@id='nameOtherLanguage']";

	String loc_Oldpassword = "//*[@id='text-content']/form/div[2]/input";
//"//input[@name ='OldPassword']";
	String loc_NewPassword = "//*[@id='text-content']/form/div[3]/input";
	String loc_ConfirmPassword = "//*[@id='text-content']/form/div[4]/input";
	String loc_ChangePassword = "//button[contains(text(),'Change Password')]";
	String loc_Logon = "//a[contains(text(),'LogOn')]";

//Personal Details
	String loc_PersonalInfo = "//span[contains(text(),'Personal Particulars')]";
	String loc_LastNamePD = "//*[@id='lastName']";
	String loc_FirstNamePD = "//*[@id='txtfirstName']";
	String loc_FormerNamePD = "//*[@id='FormerName']";
	String loc_Place_of_birthPD = "//*[@id='Place_Of_Birth']";
	String loc_NicknamePD = "//*[@id='nickName']";
	String loc_MaleGender = "//span[contains(text(),'Male')]";
	String loc_FemaleGender = "";
	String loc_department = "//*[@id='department']";
	String loc_Position = "//*[@id='position']";
	String loc_NameOption = "//label[@for ='nameOtherLanguageCheckbox']";
	String loc_PermitNO = "//*[@id='lblhiringCountryPermitNO']/span";
	String loc_MovetoAddrssDetails = "//a[contains(text(),'TO ADDRESS DETAILS>')]";

//Address details
	String loc_Addressdetails = "//span[contains(text(),'Address Details')]";
	String loc_apartmentnumber = "//*[@id='unitNo']";
	String loc_unitlane1 = "//*[@id='streetLine1']";
	String loc_unitlane2 = "//*[@id='streetLine2']";
	String loc_city = "//*[@id='city']";
	String loc_state = "//*[@id='state']";
	String loc_postalcode = "//*[@id='areaCode']";
	String loc_country = "//*[@id='country']";
	String loc_fromYear = "//*[@id='livedFromYR']";
	String loc_fromMonth = "//*[@id='livedFromMN']";
	String loc_toYear = "//*[@id='livedToYR']";
	String loc_toMonth = "//*[@id='livedToMN']";
	String loc_addInfo = "//*[@id='additionalInfo']";
	String CorrespondingSameaddress = "//*[@id='form']/div[10]/div/div/label";
	String loc_resiTyppe = "//span[contains(text(),'Male')]";
	String loc_resiselfown = "//*[@id='rdoNatureLocationOwn']/span";
	String loc_MovetoPermanent = "//a[contains(text(),'TO PERMANENT ADDRESS DETAILS >')]";

//Permanent Address details

	String loc_PermanentAddressdetails = "//span[contains(text(),'Permanent Address Details')]";
	String loc_perAddress = "//div[@class='row-el']//div//p//label[@class='checkvirtual']";

	String loc_movetofamilydetails = "//a[contains(text(),'TO FAMILY DETAILS>')]";

//family details
	String loc_FamilyDetails = "//span[contains(text(),'Family Details')]";
	String loc_Ffamilytname = "//*[@id='fLastName']";
	String loc_Fmiddlename = "//*[@id='fMiddleName']";
	String loc_Ffirstname = "//*[@id='fName']";
	String loc_Mfamilyname = "//*[@id='mLastName']";
	String loc_Mmiddlename = "//*[@id='mMiddleName']";
	String loc_Mfirstname = "//*[@id='mName']";
	String loc_MovetocontactDetails = "//button[contains(text(),'TO CONTACT DETAILS> ')]";

//Contact details
	String loc_ContactDetails = "//span[contains(text(),'Contact Details')]";
	String loc_email = "//*[@id='mailID']";
	String loc_Officecountry = "//*[@id='ophCountryCode']";
	String loc_officearea = "//*[@id='ophAreaCode']";
	String loc_officenumber = "//*[@id='oph']";
	String loc_Mobilecountry = "//*[@id='mnCountryCode']";
	String loc_Mobilenumber = "//*[@id='mb']";
	String loc_HomeCountry = "//*[@id='hpCountryCode']";
	String loc_HomeAreaCode = "//*[@id='hpAreaCode']";
	String loc_HomeNumber = "//*[@id='hp']";
	String loc_commmethod = "//*[@id='preferredMean']";
	String loc_prefertime = "//*[@id='timeOfDay']";
	String loc_movetoemploymenthistory = "//a[contains(text(),'TO EMPLOYMENT HISTORY >')]";

//Employment details
	String loc_EmploymentHistory = "//span[contains(text(),'Employment History')]";
	/*
	 * String loc_currentempyes =
	 * "//input[@id='currentEmployer']//span[contains(text(),'Yes')]"; String
	 * loc_currentempNo =
	 * "//label[@id='lblcurrentEmployerNO']//span[contains(text(),'No')]";
	 * 
	 * String loc_cantcontact =
	 * "//input[@id='contactEmployerNow']//span[contains(text(),'No')]";
	 * 
	 * String loc_cancontact =
	 * "//label[@id='lblcontactEmployerNowYES']//span[contains(text(),'Yes')]";
	 */
	String loc_reason = "//*[@id='reasonIfCant']";
	String loc_conyear = "//*[@id='contactDateYR']";
	String loc_conmonth = "//*[@id='contactDateMN']";
	String loc_condate = "//*[@id='contactDateDT']";
	String loc_companyname = "//*[@id='employerName']";
	String loc_employeeidEC = "//input[@id='Employee_ID']";
	String loc_aptnumberEC = "//*[@id='unitNo']";
	String loc_streetlane1 = "//*[@id='streetLine1']";
	String loc_streetlane2 = "//*[@id='streetLine2']";
	String loc_empcity = "//*[@id='city']";
	String loc_empstate = "//*[@id='state']";
	String loc_zipEC = "//*[@id='areaCode']";
	String loc_empcountry = "//select[@id='countrycodeid']";
	String loc_Phonecountry = "//*[@id='employerPhCountryCode']";
	String loc_Phonearea = "//*[@id='employerPhAreaCode']";
	String loc_Phonenumber = "//*[@id='employerPhNo']";
	String loc_Faxcountry = "//*[@id='employerFxCountryCode']";
	String loc_Faxarea = "//*[@id='employerFxNoAreaCode']";
	String loc_faxphone = "//*[@id='employerFxNo']";
	String loc_empMobilecountry = "//*[@id='can_MobileCountryCode']";
	String loc_empmobilenumber = "//*[@id='candidateMobileNo']";

	String loc_empdept = "//*[@id='employmentDept']";
	String loc_empstyear = "//*[@id='employeeFromYR']";
	String loc_empstmonth = "//*[@id='employeeFromMN']";
	String loc_empstdate = "//*[@id='employeeFromDT']";
	String loc_empendyear = "//*[@id='employeeToYR']";
	String loc_empendmonth = "//*[@id='employeeToMN']";
	String loc_empenddate = "//*[@id='employeeToDT']";
	String loc_jobtitle = "//*[@id='positions']";
	String loc_corptitle = "//*[@id='CorporateTitle']";
	String loc_responsibilities = "//*[@id='responsibility']";
	String loc_reasonforliving = "//*[@id='leavingReason']";
	String loc_reasonforlivingother = "//*[@id='otherLeavingReason']";
	String loc_voluntaryresignation = "//*[@id='resignationRequest_ByCompany']";
	String loc_involuntaryreason = "//*[@id='voluntaryResignation']";
	String loc_lsupname = "//*[@id='supervisorName']";
	String loc_lsuptitle = "//*[@id='supervisor_designation']";
	String loc_lsupemail = "//*[@id='SupervisorEmail']";
	String loc_supphonecountry = "//*[@id='SupPhNoCountryCode']";
	String loc_supphonearea = "//*[@id='SupPhNoAreaCode']";
	String loc_supphonenumber = "//*[@id='SupPhNo']";
	String loc_hrname = "//*[@id='HR_representative_name']";
	String loc_hrjobtitle = "//*[@id='HR_job_title']";
	String loc_hrcontact = "//*[@id='HR_contact_details']";
	String loc_lfixedsalary = "//*[@id='baseSalaryType']";
	String loc_lfixedcurrency = "//*[@id='baseSalary_currency']";
	String loc_lfixedsalaryV = "//*[@id='baseSalary']";
	String loc_bonus = "//*[@id='lastBonusType']";
	String loc_bonusV = "//*[@id='lastBonus']";
	String loc_renumeration = "//*[@id='otherRemuneration']";
	String loc_addinfo = "//*[@id='additionalInfo']";
	String loc_agency = "//label[@id='lblemployedByAgencyNO']//span[contains(text(),'No')]";
	String loc_agencyname = "//*[@id='agencyName']";
	String loc_agencyphoneCountry = "//*[@id='agencyPhCountryCode']";
	String loc_agencyphonearea = "//*[@id='agencyPhAreaCode']";
	String loc_agencyphonenumber = "//*[@id='agencyPhNo']";
	String loc_agencyaprt = "//*[@id='agencyUnitNo']";
	String loc_agencyuniltlane1 = "//*[@id='agencyStreetLine1']";
	String loc_plaseselectfile = "//div[@class='file_wrapper']//input[@id='candidateUpload_0__fileDetailsList'] ";

	String loc_filetitle = "//input[@placeholder='* Title']";
          String loc_CountrycodeConfirm = "//span[@class='popup-confirm']";
	String loc_MovetoEducationalQualification = "//a[contains(text(),'TO EDUCATIONAL QUALIFICATION>')]";

//Education Qualification

	String loc_EducationHistory = "//span[contains(text(),'Educational Qualification')]";
	String loc_CollegeName = "//input[@id='instituteName']";
	String loc_ApartmentEQ = "//input[@id='unit']";
	String loc_CityNameEQ = "//input[@id='city']";
	String loc_CountryEQ = "//select[@id='countrycodeid']";

	String loc_InstitutephoneCountry = "//*[@id='insti_PhCountryCode']";
	String loc_Institutephonearea = "//*[@id='insti_PhAreaCode']";
	String loc_Institutephonenumber = "//*[@id='insti_PhNo']";

	String loc_ProgrammeName = "//input[@id='progName']";
	String loc_QualificationType = "//select[@id='Typeofqualification']";
	String loc_Progammeloc = "//div[@class='el-6']//span[contains(text(),'No')]";
	String loc_StartYearEQ = "//select[@id='startDateYR']";
	String loc_StartMonthEQ = "//select[@id='startDateMN']";
	String loc_EndYearEQ = "//select[@id='endDateYR']";
	String loc_EndMonthEQ = "//select[@id='endDateMN']";
	String loc_StudyStatus = "//span[contains(text(),'Graduated')]";

	String loc_gradyear = "//select[@id='graduationDateYR']";
	String loc_gradmonth = "//select[@id='graduationDateMN']";
	String loc_gradday = "//select[@id='graduationDateDT']";

	String loc_CertifciationnUmber = "//*[@id='certiNo']";
	String loc_AddinfoEQ = "//*[@id='additionalInfo']";
	String loc_MovetoProfessional = "//a[contains(text(),'TO PROFESSIONAL QUALIFICATION>')]";

//Professional Qualification

	String loc_ProfQualification = "//span[contains(text(),'Professional Qualification')]";
	String loc_QualificationPQ = "//input[@id='qualiName']";
	String loc_Institute = "//input[@id='institute']";
	String loc_StatusPQ = "//input[@id='status']";
	String loc_SatePQ = "//input[@id='state']";
	String loc_PhonecountryPQ = "//*[@id='phCountryCode']";
	String loc_PhoneareaPQ = "//*[@id='phareaCode']";
	String loc_PhonenumberPQ = "//*[@id='ph']";
	String loc_CountryCodePQ = "//input[@id='phCountryCode']";
	String loc_AreaCodePQ = "//input[@id='phCountryCode']";
	String loc_PhonePQ = "//input[@id='ph']";
	String loc_ApartmentPQ = "//input[@id='unit']";
	String loc_streetlane1PQ = "//*[@id='street1']";
	String loc_streetlane2PQ = "//*[@id='street2']";
	String loc_Membershipno = "//input[@id='Membership_No']";
	String loc_zipPQ = "//*[@id='zip']";
	String loc_PQStartyear = "//*[@id='dateFromYR']";
	String loc_PQStartmonth = "//*[@id='dateFromMN']";
	String loc_PQStartdate = "//*[@id='dateFromDT']";
	String loc_PQendyear = "//*[@id='dateToYR']";
	String loc_PQendmonth = "//*[@id='dateToMN']";
	String loc_PQenddate = "//*[@id='dateToDT']";
	String loc_AccreditationYear = "//select[@id='accreditationDateYR']";
	String loc_AccreditationMonth = "//select[@id='accreditationDateMN']";
	String loc_Accreditationday = "//select[@id='accreditationDateDT']";
	String PQAddInfo = "//*[@id='additionalInfo']";
	String loc_CountryPQ = "//select[@id='countrycodeid']";
	String loc_NofurtherPQ = "//div[@class='el-12']//div//label[@class='checkvirtual']";
	String loc_MovetoProfessionalReference = "//a[contains(text(),'TO PROFESSIONAL REFERENCE>')]";

//Professional Reference
	
	String loc_ProfessionalReference = "//span[contains(text(),'Professional Reference')]";
	String loc_Namepf = "//input[@id='fNmae']";
	String loc_Titlepf = "//input[@id='refreeTitle']";
	String loc_Countrypf = "//select[@id='country']";
	String loc_Phonepf = "//input[@id='phoneNo']";
	String loc_emailpf = "//input[@id='emailId']";
	String loc_Nofurtherdetailspf = "//div[@id='addanotherdiv']//label[@class='checkvirtual']";
	String loc_movetoidentitydetails = "//a[contains(text(),'TO IDENTITY DETAILS>')]";
	String loc_relationpf = "//*[@id='relationToYou']";
	String loc_relationknownpf = "//*[@id='knownDuration']";
	String loc_citypf = "//*[@id='city']";
	String loc_companypf = "//*[@id='companyName']";

//Identity details
	String loc_Indentitydetails = "//span[contains(text(),'Identity Details')]";
	String loc_primarynationalityid = "//*[@id='primaryNationality']";
	String loc_secondarynationalityid = "//*[@id='secondaryNationality']";
	String loc_countryofbirthid = "//*[@id='birthCountry']";
	String loc_primaryresidid = "//*[@id='primaryResidency']";
	String loc_secondaryresidid = "//*[@id='secondaryResidency']";
	String loc_issuecountryid = "//*[@id='issuingCountry']";
	String loc_typeid = "//*[@id='identityType']";
	String loc_numberid = "//*[@id='changeTextForIdentityNo']";
	String loc_anotherid = "//*[@id='addAnother']//span[contains(text(),' Yes')";
	String loc_issucountryid = "//*[@id='issuingCountry']";
	String loc_idtypeid = "//*[@id='identityType']";
	String loc_idnumberid = "//*[@id='changeTextForIdentityNo']";
	String loc_passnameid = "//*[@id='passportName']";
	String loc_issueyearid = "//*[@id='issueDateYR']";
	String loc_issuemonthid = "//*[@id='issueDateMN']";
	String loc_issuedateid = "//*[@id='issueDateDT']";
	String loc_expiryyearid = "//*[@id='expiryDateYR']";
	String loc_expirymonthid = "//*[@id='expiryDateMN']";
	String loc_expirydateid = "//*[@id='expiryDateDT']";
	String loc_anothersecid = "//*[@id='addAnother']//span[contains(text(),' Yes')";
	String loc_idissuecountryid = "//*[@id='issuingCountry']";
	String loc_idissuetypeid = "//*[@id='identityType']";
	String loc_othernumberid = "//*[@id='changeTextForIdentityNo']";
	String loc_docid = "//*[@id='documentName']";
	String loc_anotherthirdid = "//*[@id='addAnotherF']/span";
	String loc_Movetocareergaps = "//a[contains(text(),'TO CAREER GAPS>')]";

//*[@id="addAnotherF"]/span

//career gap details

	String loc_Careergap = "//span[contains(text(),'Career Gaps')]";
	String loc_startyear = "//*[@id='dateFromYR']";
	String loc_startmonth = "//*[@id='dateFromMN']";
	String loc_startdate = "//*[@id='dateFromDT']";
	String loc_endyear = "//*[@id='dateToYR']";
	String loc_endmonth = "//*[@id='dateToMN']";
	String loc_enddate = "//*[@id='dateToDT']";
	String loc_reasongap = "//textarea[@id='reason']";
	String loc_movetodeclaration = "//a[contains(text(),'TO DECLARATION>')]";
	String loc_Nofurtherdetails = "//*[@id='form']/div[1]/div/div/p[1]/label";

	String loc_addcareergap = "//a[contains(text(),'ADD CAREER GAP>')]";
//Declaration
	String loc_declaration = "//span[contains(text(),'Declaration')]";
	String loc_Noans = "//span[contains(text(),'No')]";

	String loc_Yesans = "//span[contains(text(),'Yes')]";

	String loc_Movetouploads = "//a[contains(text(),'TO UPLOAD >')]";

	String loc_Uppertext = "//*[@id='form']/div[1]/label/b";

//Uploads
	String loc_Uploads = "//span[contains(text(),'Uploads')]";
	String loc_ConsentUpload = "//*[@id='ClientBaseMandatoryUpload_ 0 __formDetailsList']";
	String loc_consentuplodbutton = "//*[@id='btnMandatoryUpload 0']";

	// *[@id="btnMandatoryUpload 0"]
	String loc_Movetooverview = "//a[contains(text(),'TO OVERVIEW BEFORE SUBMITTING YOUR PROFILE>')]";

//Overview
	String loc_Overview = "//span[contains(text(),'Overview')]";
	String Submitinfocheck = "//p[@class='elementPara']//label[@class='checkvirtual']";
	String loc_DoneOnveview = "//input[@id='createCase']";

	String loc_Candidatemessage = " //*[@id='the-end']/p[2]";

	String loc_Closewindow = "//*[@id='closeWindowCandi']";
	
	//Error
	
	String loc_Errorexit = "//a[contains(text(),'Exit')]";

}
