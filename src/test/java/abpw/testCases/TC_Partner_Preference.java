package abpw.testCases;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import abpw.pageObject.abpwHomePage;
import abpw.pageObject.abpwLandingPage;
import abpw.pageObject.abpwLoginPage;
import abpw.pageObject.abpwPartnerPreferencePage;
import abpw.utilities.XLUtils;

public class TC_Partner_Preference extends BaseClass
	{
		//String uName="AW61792437";
		String uName;
		String uPass="password";
		String path=System.getProperty("user.dir")+"/src/test/java/abpw/testData/abpwDataSet.xlsx";
		String AgeFrom, AgeTo, Religion, MaritalStatus, MotherTongue, Location;
		@BeforeTest
		public void Read_Excel_From_Profiles_And_PP_Sheet() throws IOException 
		{
			//------------------- Login Data ----------------------------------------
			uName=XLUtils.getCellData(path, "Profiles", 1, 1);
			//------------------- PP Data -------------------------------------------
			AgeFrom=XLUtils.getCellData(path, "PP", 1, 1);
			AgeTo= XLUtils.getCellData(path, "PP", 2, 1);
			Religion= XLUtils.getCellData(path, "PP", 3, 1);
			MaritalStatus= XLUtils.getCellData(path, "PP", 4, 1);
			MotherTongue= XLUtils.getCellData(path, "PP", 5, 1);
			Location= XLUtils.getCellData(path, "PP", 6, 1);
		}
		
		@Test(priority=1)
		public void login() 
			{
				logger.info("====================> Start Partner Preference Script <===========================");
				abpwLandingPage LANDING = new abpwLandingPage(driver);
				LANDING.clickOnLoginLink();
				LANDING.clickOnLoginWithPasswordRadioButton();
					
				abpwLoginPage userLogin = new abpwLoginPage(driver);
				userLogin.setEmailID(uName);
				userLogin.setPassword(uPass);
				userLogin.clickLoginNowButton();
				explicitWait("(//*[@href='/my-matches'])[1]");
				logger.info("Login successfully for partner preference");
			}
		
		@Test (priority=2)
		public void Partner_Preference() throws InterruptedException, AWTException 
		{
			try 
			{
				abpwHomePage AHP= new abpwHomePage(driver);
				Thread.sleep(5000);
				AHP.clickOnMyMatchesLink();
				logger.info("Click on my-matches header link");
				Thread.sleep(2000);
				AHP.clickOnMenu();
				logger.info("Click on menu link");
				AHP.clickOnMenu_PartnerPreference();
				logger.info("Click on partner preference sub-menu link");
				//----------------- Personal Information --------------------------------------
				abpwPartnerPreferencePage APPP= new abpwPartnerPreferencePage(driver);			
				APPP.clickOnAgeIcon();
				logger.info("Click on edit age icon");
				Thread.sleep(2000);
				APPP.setFromAge(AgeFrom);
				logger.info("Select from age");
				APPP.setToAge(AgeTo);
				logger.info("Select to age");
				APPP.saveAge();
				logger.info("Click save age button");			
				Thread.sleep(6000);
				//explicitWait("(//*[@class='img-fluid'])[4]");
				APPP.clickOnReligionIcon();
				logger.info("Click religion icon");
				Thread.sleep(2000);
				APPP.setReligion(Religion);
				logger.info("Select religion");
				Thread.sleep(2000);
				APPP.clickOnSaveReligion();
				logger.info("Click on save religion button");
				
				browserZoomInOut();
				browserZoomInOut();
				browserZoomInOut();
				browserZoomInOut();
				browserZoomInOut();
				
				Thread.sleep(2000);
				APPP.clickOnMaritalStatusIcon();
				logger.info("Click marital status icon");
				Thread.sleep(2000);
				//APPP.setMaritalStatus("Never Married");
				APPP.setMaritalStatus(MaritalStatus);
				logger.info("Select marital status");
				Thread.sleep(2000);
				APPP.clickOnSaveMaritalStatus();
				logger.info("Click on save marital status button");
				
			} 
			catch (Exception e) 
			{
				System.out.println(e);
			}
			
			logger.info("====================> End Partner Preference Script <===========================");
		} 
	}
