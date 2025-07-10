package abpw.testCases;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import abpw.pageObject.abpwLandingPage;
import abpw.pageObject.abpwLoginPage;
import abpw.utilities.XLUtils;

public class TC_Interaction_Received extends BaseClass
{
	String TargetUserID;
	String uName="AW55515030";
	String uPass="password1";
	
	String path=System.getProperty("user.dir")+"/src/test/java/abpw/testData/abpwDataSet.xlsx";
	@BeforeTest
	public void Read_Excel_From_Profiles_Sheet() throws IOException 
	{
		TargetUserID=XLUtils.getCellData(path, "Profiles", 1, 1);
	}
	
	@Test(priority=1)
	public void login() 
		{
		logger.info("====================> Start Interaction Received Script <===========================");
			abpwLandingPage LANDING = new abpwLandingPage(driver);
			LANDING.clickOnLoginLink();
			LANDING.clickOnLoginWithPasswordRadioButton();
				
			abpwLoginPage userLogin = new abpwLoginPage(driver);
			userLogin.setEmailID(uName);
			userLogin.setPassword(uPass);
			userLogin.clickLoginNowButton();
			logger.info("Login successfully for interaction received");
		}
	
	@Test(priority=2)
	public void checkInteraction() throws InterruptedException, AWTException 
	{
		Thread.sleep(10000);
		driver.findElement(By.xpath("(((//ul[li])[7])//li)[1]//a")).click();
		logger.info("Click on my requests link from home page");
		//driver.findElement(By.id("uncontrolled-tab-example-tab-request-sent")).click();		
		explicitWait("(//div[@class='statusmessage'])[1]");
		Thread.sleep(2000);
		int elementsCounts = driver.findElements(By.xpath("//div[@class='memberid matchcard']")).size();
		//System.out.println("Total Profile count in pending section: "+elementsCounts);
		int i;
		browserZoomInOut();
		browserZoomInOut();
		browserZoomInOut();
		browserZoomInOut();
		for(i=1; i<elementsCounts; i++) 
		{
			
			String findAWID="(//div[@class='memberid matchcard'])["+i+"]";	
			String msgTextXpath="(//div[@class='statusmessage'])["+i+"]";
			String acceptButtonXpath="(//div[@class='statusmessage'])["+i+"]//following::button[1]";
//			WebElement acceptButtonXpathScroll=driver.findElement(By.xpath("(//div[@class='statusmessage'])["+i+"]//following::button[1]"));
			String AWID = driver.findElement(By.xpath(findAWID)).getText();
			if (AWID.equals(TargetUserID))
			{
				String msgText= driver.findElement(By.xpath(msgTextXpath)).getText();
				logger.info(msgText+" FROM AWID: "+AWID);
				System.out.println("Recived MSG: "+msgText);
//				JavascriptExecutor js = (JavascriptExecutor) driver;
//				js.executeScript("arguments[0].scrollIntoView();", acceptButtonXpathScroll);
				
				Thread.sleep(3000);
				driver.findElement(By.xpath(acceptButtonXpath)).click();
				Thread.sleep(6000);
			}
			
			System.out.println(AWID);
			
		}
		logger.info("====================> End Interaction Received Script <===========================");
	}
}
