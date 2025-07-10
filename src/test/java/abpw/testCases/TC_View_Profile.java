package abpw.testCases;

import java.io.IOException;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import abpw.pageObject.abpwLandingPage;
import abpw.pageObject.abpwLoginPage;
import abpw.pageObject.abpwSearchingPage;
import abpw.utilities.XLUtils;

public class TC_View_Profile extends BaseClass
	{
	String uName="AW95570117";
	String uPass="password";
	String TargetUserID;
	String path=System.getProperty("user.dir")+"/src/test/java/abpw/testData/abpwDataSet.xlsx";
	String PeopleUsuallyTellMe, TheMostInteresting, Kids, Manglik, Occupation, Designation, CompanyName, Industry, Income, HighestEducation, 
	Specialisation, HighestEduInstitute, SchoolName, Body_type, Height, Complexion, BloodGroup, Disabilities, KnownAilments, PlaceOfBirth,
	TimeOfBirth, Nakshatra, Gothram, Zodiac, Rashi, Smoking, Drinking, FoodHabits, HouseLivingIn, WantKids, VehiclesOwned, VehiclesOwned2,
	Pets, FamilyToMeIs, Gon, FamilyOrigin, HomeTown, FamilyType, FamilyStatus, FamilyIncome, FamilyValue, FatherStatus, FatherOccupation,
	MotherStatus, MotherOccupation;
	@BeforeTest
	public void Read_Excel_From_Profiles_Sheet() throws IOException 
	{
		//------------------- Login Data ----------------------------------------
		TargetUserID=XLUtils.getCellData(path, "Profiles", 1, 1);
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
			logger.info("====================> Start View Profile Script <===========================");
			abpwLandingPage LANDING = new abpwLandingPage(driver);
			LANDING.clickOnLoginLink();
			LANDING.clickOnLoginWithPasswordRadioButton();
				
			abpwLoginPage userLogin = new abpwLoginPage(driver);
			userLogin.setEmailID(uName);
			userLogin.setPassword(uPass);
			userLogin.clickLoginNowButton();
			explicitWait("(//*[contains(text(),'Edit Profile')])[2]");
			logger.info("Login successfully for view profile");
		}
	
	@Test(priority=2)
	public void search_for_view_profile() throws InterruptedException 
		{
			explicitWait("(//*[contains(text(),'Edit Profile')])[2]");
			abpwSearchingPage AWSP=new abpwSearchingPage(driver);
			AWSP.clickOnSearchMenu();
			logger.info("Click on profile search menu");
			AWSP.enterAWID(TargetUserID);
			logger.info("Enter user AWID");
			AWSP.clickOnSearchIcon();
			logger.info("Click on search icon");
			explicitWait("//*[contains(text(),'Request contact')] | //*[contains(text(),'View Contact')]");
			logger.info("Search result is appearing");
			AWSP.clickOnSearchResultCard();
			logger.info("Click on profile card ");
			Thread.sleep(3000);
			ArrayList<String> tabs= new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			explicitWait("(//*[contains(text(),'Suggested for you')])[1]");
			Thread.sleep(3000);
			logger.info("Profile open successfully");
		}
	@Test(priority=3)
	public void verify_view_profile_occupation() throws InterruptedException 
		{
			String getOccupation=driver.findElement(By.xpath("//p[contains(text(),'Occupation')]//following::div[1]")).getText();
			if (getOccupation.equals(Occupation))
			{
				logger.info("Occupation verification: PASS");
				assert(true);
			}
			else
			{
				logger.info("Occupation verification: FAILED");
				assert(false);
			}
		}
	
	@Test(priority=4)
	public void verify_view_profile_Highesteducation() throws InterruptedException 
		{
			String getHighesteducation=driver.findElement(By.xpath("//p[contains(text(),'Highest education')]//following::div[1]")).getText();
			if (getHighesteducation.equals(HighestEducation))
			{
				logger.info("Highest education verification: PASS");
				assert(true);
			}
			else
			{
				logger.info("Highest education verification: FAILED");
				assert(false);
			}
		}
	
	@Test(priority=5)
	public void verify_view_profile_Disabilities() throws InterruptedException 
		{
			String getDisabilities=driver.findElement(By.xpath("//p[contains(text(),'Disabilities')]//following::div[1]")).getText();
			if (getDisabilities.equals(Disabilities))
			{
				logger.info("Disabilities verification: PASS");
				assert(true);
			}
			else
			{
				logger.info("Disabilities verification: FAILED");
				assert(false);
			}
			logger.info("====================> End View Profile Script <===========================");
		}
	}
