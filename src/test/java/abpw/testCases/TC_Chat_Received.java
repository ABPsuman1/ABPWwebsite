package abpw.testCases;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import abpw.pageObject.abpwLandingPage;
import abpw.pageObject.abpwLoginPage;


public class TC_Chat_Received extends BaseClass
	{	
	String uName="AW55515030";
	String uPass="password1";	
	@Test(priority=1)
	public void firstChatMsgReceived() throws InterruptedException 
		{
		logger.info("====================> Start Chat Received Script <===========================");
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
		explicitWait("(//*[@class='chat_listing_click']//div[1])[1]");
		logger.info("Click on chat section");
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//*[@class='chat_listing_click']//div[1])[1]")).click();
		logger.info("Click on profile card section");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//textarea[@id='exampleInputEmail1']")).click();
		driver.findElement(By.xpath("//textarea[@id='exampleInputEmail1']")).sendKeys("Ok, Received");
		driver.findElement(By.xpath("//button[@class='chat-send-btn-submit chat_button_click']")).click();
		
		logger.info("====================> End Chat Received Script <===========================");
		}
	
	public void chatReceived() {}
	}
