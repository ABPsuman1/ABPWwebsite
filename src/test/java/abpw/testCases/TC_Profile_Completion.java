package abpw.testCases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import abpw.pageObject.abpwLandingPage;
import abpw.pageObject.abpwLoginPage;
import abpw.pageObject.abpwProfileCompletionPage;
import abpw.utilities.XLUtils;

public class TC_Profile_Completion extends BaseClass
	{
	//String uName="AW61792437";
	String uName;
	String uPass="password";
	String path=System.getProperty("user.dir")+"/src/test/java/abpw/testData/abpwDataSet.xlsx";
	String PeopleUsuallyTellMe, TheMostInteresting, Kids, Manglik, Occupation, Designation, CompanyName, Industry, Income, HighestEducation, 
	Specialisation, HighestEduInstitute, SchoolName, Body_type, Height, Complexion, BloodGroup, Disabilities, KnownAilments, PlaceOfBirth,
	TimeOfBirth, Nakshatra, Gothram, Zodiac, Rashi, Smoking, Drinking, FoodHabits, HouseLivingIn, WantKids, VehiclesOwned, VehiclesOwned2,
	Pets, FamilyToMeIs, Gon, FamilyOrigin, HomeTown, FamilyType, FamilyStatus, FamilyIncome, FamilyValue, FatherStatus, FatherOccupation,
	MotherStatus, MotherOccupation;
	
	@BeforeTest
	public void Read_Excel_Data_From_Profiles_And_PC_Sheet() throws IOException 
	{

		//------------------- Login Data ----------------------------------------
		uName=XLUtils.getCellData(path, "Profiles", 1, 1);
		//------------------- PC Data -------------------------------------------
		PeopleUsuallyTellMe=XLUtils.getCellData(path, "PC", 1, 1);
		TheMostInteresting=XLUtils.getCellData(path, "PC", 2, 1);
		Kids=XLUtils.getCellData(path, "PC", 3, 1);
		Manglik=XLUtils.getCellData(path, "PC", 4, 1);
		Occupation=XLUtils.getCellData(path, "PC", 5, 1);
		Designation=XLUtils.getCellData(path, "PC", 6, 1);
		CompanyName=XLUtils.getCellData(path, "PC", 7, 1);
		Industry=XLUtils.getCellData(path, "PC", 8, 1);
		Income=XLUtils.getCellData(path, "PC", 9, 1);
		HighestEducation=XLUtils.getCellData(path, "PC", 10, 1);
		Specialisation=XLUtils.getCellData(path, "PC", 11, 1);
		HighestEduInstitute=XLUtils.getCellData(path, "PC", 12, 1);
		SchoolName=XLUtils.getCellData(path, "PC", 13, 1);
		Body_type=XLUtils.getCellData(path, "PC", 14, 1);
		Height=XLUtils.getCellData(path, "PC", 15, 1);
		Complexion=XLUtils.getCellData(path, "PC", 16, 1);
		BloodGroup=XLUtils.getCellData(path, "PC", 17, 1);
		Disabilities=XLUtils.getCellData(path, "PC", 18, 1);
		KnownAilments=XLUtils.getCellData(path, "PC", 19, 1);
		PlaceOfBirth=XLUtils.getCellData(path, "PC", 20, 1);
		TimeOfBirth=XLUtils.getCellData(path, "PC", 21, 1);
		Nakshatra=XLUtils.getCellData(path, "PC", 22, 1);
		Gothram=XLUtils.getCellData(path, "PC", 23, 1);
		Zodiac=XLUtils.getCellData(path, "PC", 24, 1);
		Rashi=XLUtils.getCellData(path, "PC", 25, 1);
		Smoking=XLUtils.getCellData(path, "PC", 26, 1);
		Drinking=XLUtils.getCellData(path, "PC", 27, 1);
		FoodHabits=XLUtils.getCellData(path, "PC", 28, 1);
		HouseLivingIn=XLUtils.getCellData(path, "PC", 29, 1);
		WantKids=XLUtils.getCellData(path, "PC", 30, 1);
		VehiclesOwned=XLUtils.getCellData(path, "PC", 31, 1);
		VehiclesOwned2=XLUtils.getCellData(path, "PC", 32, 1);
		Pets=XLUtils.getCellData(path, "PC", 33, 1);
		FamilyToMeIs=XLUtils.getCellData(path, "PC", 34, 1);
		Gon=XLUtils.getCellData(path, "PC", 35, 1);
		FamilyOrigin=XLUtils.getCellData(path, "PC", 36, 1);
		HomeTown=XLUtils.getCellData(path, "PC", 37, 1);
		FamilyType=XLUtils.getCellData(path, "PC", 38, 1);
		FamilyStatus=XLUtils.getCellData(path, "PC", 39, 1);
		FamilyIncome=XLUtils.getCellData(path, "PC", 40, 1);
		FamilyValue=XLUtils.getCellData(path, "PC", 41, 1);
		FatherStatus=XLUtils.getCellData(path, "PC", 42, 1);
		FatherOccupation=XLUtils.getCellData(path, "PC", 43, 1);
		MotherStatus=XLUtils.getCellData(path, "PC", 44, 1);
		MotherOccupation=XLUtils.getCellData(path, "PC", 45, 1);	
		
	}
	@Test(priority=1)
	public void login() 
		{
			logger.info("====================> Start Profile Completion Script <===========================");
			abpwLandingPage LANDING = new abpwLandingPage(driver);
			LANDING.clickOnLoginLink();
			LANDING.clickOnLoginWithPasswordRadioButton();
				
			abpwLoginPage userLogin = new abpwLoginPage(driver);
			userLogin.setEmailID(uName);
			userLogin.setPassword(uPass);
			userLogin.clickLoginNowButton();
			explicitWait("(//*[contains(text(),'Edit Profile')])[2]");
			logger.info("Login successfully for profile completion");
		}
	@Test(priority=2)
	public void profileCompletion() throws InterruptedException, AWTException
		{		
		explicitWait("(//*[contains(text(),'Edit Profile')])[2]");
		abpwProfileCompletionPage APCP= new abpwProfileCompletionPage(driver);
		browserZoomInOut();
		browserZoomInOut();
		browserZoomInOut();
		browserZoomInOut();
		browserZoomInOut();
		Thread.sleep(3000);
		APCP.clickOnEditProfileLink();	
		logger.info("Click on edit profile link");
		//============= Start About Section ==============================
		//---------- Start Edit About Me ---------------------------------	
		logger.info("------------ Start edit about me section ------------ ");
		Thread.sleep(2000);
		APCP.click_About_Me_Icon();
		logger.info("Click on edit about me icon");
		APCP.set_About_Me_Que1(PeopleUsuallyTellMe);
		logger.info("Enter About Me Que1");
		APCP.set_About_Me_Que3(TheMostInteresting);
		logger.info("Enter About Me Que2");
		APCP.save_About_Me();
		logger.info("Save about me section");
		//---------- End Edit About Me -----------------------------------
		
		//---------- Start Edit Personal Information ---------------------
		logger.info("------------ Start edit personal information section ------------ ");
		Thread.sleep(10000);
		APCP.click_Personal_Information_Icon();
		logger.info("Click on edit personal information icon");
		APCP.set_Kids(Kids);
		logger.info("Select Kids");
		APCP.set_Manglik(Manglik);
		logger.info("Select Manglik");
		APCP.save_Personal_Information();
		logger.info("Save personal information section");
		//---------- End Edit Personal Information -----------------------
		
		//---------- Start Edit Professional Background ------------------	
		logger.info("------------ Start edit professional background section ------------ ");
		Thread.sleep(10000);
		APCP.ClickOn_Professiona_background_Icon();
		logger.info("Click on edit professional background icon");
		APCP.setOccupation(Occupation);
		logger.info("Select Occupation");
		APCP.setDesignation(Designation);
		logger.info("Select Designation");
		APCP.setCompanyName(CompanyName);
		logger.info("Enter Company Name");
		APCP.setIndustry(Industry);
		logger.info("Select Industry");
		APCP.setIncome(Income);
		logger.info("Select Income");
		APCP.save_ProfessionalBackground();
		logger.info("Save professional background section");
		//---------- End Edit Professional Background ------------------
				
		//---------- Start Edit Educational background -------------------
		logger.info("------------ Start edit educational background section ------------ ");
		Thread.sleep(12000);		
		APCP.ClickOn_educationalbackground_Icon();
		logger.info("Click on edit educational background icon");
		APCP.setHighestEducation(HighestEducation);
		logger.info("Select Highest Education");
		APCP.setSpecialisation(Specialisation);
		logger.info("Select Specialisation");
		APCP.setHighestEduInstitute(HighestEduInstitute);
		logger.info("Enter Highest Edu Institute");
		APCP.setSchoolName(SchoolName);
		logger.info("Enter School Name");
		APCP.save_EducationalBackground();
		logger.info("Save educational background section");
		//---------- End Edit Educational background ---------------------
	
		//---------- Start Edit Physical Description ---------------------	
		Thread.sleep(12000);
		logger.info("------------ Start edit physical description section ------------ ");
		APCP.ClickOn_PhysicalDescription_Icon();
		logger.info("Click on edit physical description icon");
		APCP.setBody_type(Body_type);
		logger.info("Select Body Type");
		APCP.setHeight(Height);
		logger.info("Select Height");
		APCP.setComplexion(Complexion);
		logger.info("Select Complexion");
		APCP.setBloodGroup(BloodGroup);
		logger.info("Select Blood Group");
		APCP.setDisabilities(Disabilities);
		logger.info("Select Disabilities");
		APCP.setKnownAilments(KnownAilments);
		logger.info("Select Known Ailments");
		APCP.save_PhysicalDescription();
		logger.info("Save physical description section");
		//---------- End Edit Physical Description ------------------------
		
		//---------- Start Edit Astrology Details -------------------------
		logger.info("------------ Start edit astrology details section ------------ ");
		Thread.sleep(12000);
		APCP.ClickOn_AstrologyDetails_Icon();
		logger.info("Click on edit astrology details icon");
		APCP.setPlaceOfBirth(PlaceOfBirth);
		logger.info("Select Place Of Birth");
		APCP.setTimeOfBirth(TimeOfBirth);
		logger.info("Select Time Of Birth");
		APCP.setNakshatra(Nakshatra);
		logger.info("Select Nakshatra");
		APCP.setGothram(Gothram);
		logger.info("Select Gothram");
		APCP.setZodiac(Zodiac);
		logger.info("Select Zodiac");
		APCP.setRashi(Rashi);
		logger.info("Select Rashi");
		APCP.SaveAstrologyDetails();
		
		Thread.sleep(12000);
		 ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
	      //switch to new tab
	      driver.switchTo().window(newTb.get(1));
		driver.close();
		driver.switchTo().window(newTb.get(0));
		logger.info("Save Astrology section");
		//---------- End Edit Astrology Details --------------------------
		
		//---------- Start Edit Lifestyle Preference ---------------------
		logger.info("------------ Start edit lifestyle preference section ------------ ");
		Thread.sleep(12000);
		APCP.ClickOn_LifestylePreference_Icon();
		logger.info("Click on edit lifestyle preference icon");
		APCP.setSmoking(Smoking);
		logger.info("Select Smoking");
		APCP.setDrinking(Drinking);
		logger.info("Select Drinking");
		APCP.setFoodHabits(FoodHabits);
		logger.info("Select Food Habits");
		APCP.setHouseLivingIn(HouseLivingIn);
		logger.info("Select House Living In");
		APCP.setWantKids(WantKids);
		logger.info("Select Want Kids");
		APCP.setVehiclesOwned(VehiclesOwned);
		logger.info("Select Vehicles Owned");
		APCP.setVehiclesOwned2(VehiclesOwned2);
		logger.info("Select Vehicles Owned 2");
		APCP.setPets(Pets);
		logger.info("Select Pets");
		APCP.SaveLifestylePreference();
		logger.info("Save Lifestyle Section");
		//---------- End Edit Lifestyle Preference -----------------------
		
		//-------------- Start Edit Hobbies Section ----------------------	
		logger.info("------------ Start edit hobbies section ------------ ");
		Thread.sleep(12000);
		APCP.ClickOn_hobbies_Icon();
		logger.info("Click on edit hobbies icon");
		APCP.ClickOnchkArtHandicraft();
		logger.info("Select Art Handicraft");
		APCP.ClickOnchkAutoRacing();
		logger.info("Select AutoRacing");
		APCP.ClickOnchkBasketball();
		logger.info("Select Basketball");
		APCP.SaveHobbies();
		logger.info("Save Hobbies Section");
		//-------------- End Edit Hobbies Section ------------------------
		//============= End About Section ================================
		//============= Start Family Details Section =====================
		logger.info("------------ Start edit family details section ------------ ");
		Thread.sleep(12000);
		APCP.clickOnFamilySection();
		logger.info("Click on family tab");
		APCP.clickEditFamilySection();
		logger.info("Click on edit family icon");
		APCP.setFamilyToMeIs(FamilyToMeIs);
		logger.info("Enter Family To Me Is..");
		APCP.setGon(Gon);
		logger.info("Select Gon");
		APCP.setFamilyOrigin(FamilyOrigin);
		logger.info("Select Family Origin");
		APCP.setHomeTown(HomeTown);
		logger.info("Select Home Town");
		APCP.setFamilyType(FamilyType);
		logger.info("Select Family Type");
		APCP.setFamilyStatus(FamilyStatus);
		logger.info("Select Family Status");
		APCP.setFamilyIncome(FamilyIncome);
		logger.info("Select Family Income");
		APCP.setFamilyValue(FamilyValue);
		logger.info("Select Family Value");
		APCP.setFatherStatus(FatherStatus);
		logger.info("Select Father Status");
		APCP.setFatherOccupation(FatherOccupation);
		logger.info("Select Father Occupation");
		APCP.setMotherStatus(MotherStatus);
		logger.info("Select Mother Status");
		APCP.setMotherOccupation(MotherOccupation);
		logger.info("Select Mother Occupation");
		APCP.SaveFamilyDetails();
		Thread.sleep(10000);
		logger.info("Save Family Details Section");
		//============= End Family Details Section ======================
		logger.info("====================> End Profile Completion Script <===========================");
		}
	
	}
