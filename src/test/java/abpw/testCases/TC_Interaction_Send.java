package abpw.testCases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import abpw.pageObject.abpwLandingPage;
import abpw.pageObject.abpwLoginPage;
import abpw.pageObject.abpwSearchingPage;
import abpw.pageObject.abpwViewProfilePage;
import abpw.utilities.XLUtils;

public class TC_Interaction_Send extends BaseClass
{
	//String TargetUserID="AW95570117";
	//String TargetUserID="AW89049069";
	String TargetUserID="AW55515030";
	
	String uName;
	String uPass="password";
	
	String path=System.getProperty("user.dir")+"/src/test/java/abpw/testData/abpwDataSet.xlsx";
	@BeforeTest
	public void Read_Excel_From_Profiles_Sheet() throws IOException 
	{
		uName=XLUtils.getCellData(path, "Profiles", 1, 1);
	}
	
	@Test(priority=1)
	public void login() 
		{
			logger.info("====================> Start Interaction Send Script <===========================");
			abpwLandingPage LANDING = new abpwLandingPage(driver);
			LANDING.clickOnLoginLink();
			LANDING.clickOnLoginWithPasswordRadioButton();
				
			abpwLoginPage userLogin = new abpwLoginPage(driver);
			userLogin.setEmailID(uName);
			userLogin.setPassword(uPass);
			userLogin.clickLoginNowButton();
			logger.info("Login successfully for interaction send");
		}
	
	@Test(priority=2)
	public void view_profile() throws InterruptedException, AWTException 
		{
			explicitWait("(//*[contains(text(),'Edit Profile')])[2]");
			abpwSearchingPage AWSP=new abpwSearchingPage(driver);
			AWSP.clickOnSearchMenu();
			logger.info("Click on search menu");
			AWSP.enterAWID(TargetUserID);
			logger.info("Enter target user ID");
			AWSP.clickOnSearchIcon();
			logger.info("Click on search icon");
			explicitWait("//*[contains(text(),'Request contact')] | //*[contains(text(),'View Contact')]");
			logger.info("Search result is appearing");
			AWSP.clickOnSearchResultCard();
			logger.info("Click on search result card");
			Thread.sleep(3000);
			ArrayList<String> tabs= new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			explicitWait("(//*[contains(text(),'Suggested for you')])[1]");
			Thread.sleep(3000);
			logger.info("View Profile Done");			
		}
	@Test(priority=3)
	public void interaction_send() throws InterruptedException, AWTException 
		{
						
			abpwViewProfilePage AVPP= new abpwViewProfilePage(driver);
			
			for (int i=0; i<5 ; i++)
			{
				//button[contains(text(),'Close')]
			}
			
			
			AVPP.clickOn_SendPhotoRequest();
			Thread.sleep(6000);
			explicitWait("(//button[contains(text(),'Close')])[1]");
			driver.findElement(By.xpath("(//button[contains(text(),'Close')])[1]")).click();
			Thread.sleep(2000);
			logger.info("Send Photo Request: Done");
			
			AVPP.clickOn_InterestRequest();
			Thread.sleep(5000);
			driver.findElement(By.xpath("(//button[contains(text(),'Close')])[1]")).click();
			Thread.sleep(2000);
			logger.info("Send Interest Request: Done");
			
			AVPP.clickOn_ContactRequest();
			Thread.sleep(5000);
			driver.findElement(By.xpath("(//button[contains(text(),'Close')])[1]")).click();
			Thread.sleep(2000);
			logger.info("Send Contact Request: Done");
			
			AVPP.clickOn_ChatRequest();	
			Thread.sleep(5000);
			explicitWait("(//button[contains(text(),'Close')])[1]");
			driver.findElement(By.xpath("(//button[contains(text(),'Close')])[1]")).click();
			Thread.sleep(2000);
			logger.info("Send Chat Request: Done");
			
			browserZoomInOut();
			browserZoomInOut();
			browserZoomInOut();
			browserZoomInOut();
			browserZoomInOut();
			AVPP.clickOn_AstrologyRequest();
			Thread.sleep(2000);
			logger.info("Send Astrology Request: Done");
			AVPP.clickOn_AstrologyPopup_Confirmation();
			logger.info("Click on astrology popup");
			Thread.sleep(5000);
			driver.findElement(By.xpath("(//button[contains(text(),'Close')])[1]")).click();			
			Thread.sleep(3000);
			logger.info("====================> End Interaction Send Script <===========================");
		} 
	}
