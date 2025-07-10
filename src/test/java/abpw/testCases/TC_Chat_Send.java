package abpw.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import abpw.pageObject.abpwLandingPage;
import abpw.pageObject.abpwLoginPage;
import abpw.utilities.XLUtils;

public class TC_Chat_Send extends BaseClass
	{
	String uName;
	String uPass="password";
	String path=System.getProperty("user.dir")+"/src/test/java/abpw/testData/abpwDataSet.xlsx";
	
	
	@BeforeTest
	public void Read_Excel_From_Profiles_And_PP_Sheet() throws IOException 
		{
		//------------------- Login Data ----------------------------------------
		uName=XLUtils.getCellData(path, "Profiles", 1, 1);
		}
	@Test(priority=1)
	public void firstChatMsgSend() throws InterruptedException 
		{
		logger.info("====================> Start Chat Send Script <===========================");
		abpwLandingPage LANDING = new abpwLandingPage(driver);
		LANDING.clickOnLoginLink();
		LANDING.clickOnLoginWithPasswordRadioButton();
		
		abpwLoginPage userLogin = new abpwLoginPage(driver);
		userLogin.setEmailID(uName);
		userLogin.setPassword(uPass);
		userLogin.clickLoginNowButton();
		explicitWait("(//*[@href='/my-matches'])[1]");
		logger.info("Login successful");
		
		driver.findElement(By.xpath("(//*[@href='/message'])[1]")).click();
		logger.info("Click on chat section");
		explicitWait("(//*[@class='chat_listing_click']//div[1])[1]");
		driver.findElement(By.xpath("(//*[@class='chat_listing_click']//div[1])[1]")).click();
		logger.info("Click on profile card section");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//textarea[@id='exampleInputEmail1']")).click();
		driver.findElement(By.xpath("//textarea[@id='exampleInputEmail1']")).sendKeys("Hi from source user");
		driver.findElement(By.xpath("//button[@class='chat-send-btn-submit chat_button_click']")).click();
		logger.info("MSG Send");
		logger.info("====================> End Chat Send Script <===========================");
		}
	
	}
