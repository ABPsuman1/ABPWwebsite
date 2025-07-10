package abpw.testCases;

import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import abpw.pageObject.abpwHomePage;
import abpw.pageObject.abpwLandingPage;
import abpw.pageObject.abpwLoginPage;
import abpw.utilities.XLUtils;

public class TC_My_Matches extends BaseClass

{
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
	}
	
	@Test(priority=1)
	public void login() 
	{
		logger.info("====================> Start My Matches Script <===========================");
		abpwLandingPage LANDING = new abpwLandingPage(driver);
		LANDING.clickOnLoginLink();
		LANDING.clickOnLoginWithPasswordRadioButton();
				
		abpwLoginPage userLogin = new abpwLoginPage(driver);
		userLogin.setEmailID(uName);
		userLogin.setPassword(uPass);
		userLogin.clickLoginNowButton();
		explicitWait("(//*[@href='/my-matches'])[1]");
		logger.info("Login successfully for my matches");
	}
	
	@Test(priority=2)
	public void My_Matches() throws InterruptedException 
	{
		abpwHomePage AHP= new abpwHomePage(driver);
		Thread.sleep(5000);
		AHP.clickOnMyMatchesLink();
		logger.info("Click on my match link");
		
		explicitWait("//p[@class='name-text']");
		int myMatchesCount =driver.findElements(By.xpath("//p[@class='name-text']")).size();
		System.out.println(myMatchesCount);
		
		for (int i=1; i<=myMatchesCount; i++)
			{
				//String unameXpath="(//p[@class='name-text'])["+i+"]//span[1]";
				String uAgeXpath="(//p[@class='name-text'])["+i+"]//span[2]";
				String fullXpath="(//p[@class='name-text'])["+i+"]";
				//System.out.println("-------------------------- ");
				logger.info("-------------- User: "+i+" --------------");
				//System.out.println(driver.findElement(By.xpath(unameXpath)).getText());
				String my_matches_user_details=driver.findElement(By.xpath(fullXpath)).getText();
				logger.info("My Matches Uuser Details: "+my_matches_user_details);
				String MyMatcheAge= driver.findElement(By.xpath(uAgeXpath)).getText();
				String[] getAge = MyMatcheAge.split("(?<=.)");
				String NEWAGE =getAge[0]+""+getAge[1];				
				//System.out.println("Getting Age From My Matches: "+NEWAGE);
				
				if (AgeFrom.equals(NEWAGE))
				{
					logger.info("Age Matched from PP "+NEWAGE+" - PASS");
					//assert(true);
				}
				else
				{
					logger.info("Age Not Matched from PP "+NEWAGE+" - FAILED");
					//assert(false);
				}
				
			}
		logger.info("====================> End My Matches Script <===========================");
	}
}
