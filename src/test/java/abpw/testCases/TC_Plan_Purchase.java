package abpw.testCases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import abpw.pageObject.abpwLandingPage;
import abpw.pageObject.abpwLoginPage;
import abpw.pageObject.apwPlanPage;
import abpw.utilities.XLUtils;

public class TC_Plan_Purchase extends BaseClass
	{
		String path=System.getProperty("user.dir")+"/src/test/java/abpw/testData/abpwDataSet.xlsx";
		//String uName="AW61792437";
		String uName;
		String uPass="password";
		
		@BeforeTest
		public void Read_Excel_From_Profiles_Sheet() throws IOException 
		{
			uName=XLUtils.getCellData(path, "Profiles", 1, 1);
		}
		
		@Test(priority=1)
		public void login() 
			{
				logger.info("====================> Start Plan Purchase Script <===========================");
				abpwLandingPage LANDING = new abpwLandingPage(driver);
				LANDING.clickOnLoginLink();
				LANDING.clickOnLoginWithPasswordRadioButton();
			
				abpwLoginPage userLogin = new abpwLoginPage(driver);
				userLogin.setEmailID(uName);
				userLogin.setPassword(uPass);
				userLogin.clickLoginNowButton();
				logger.info("Login successfully for Plan Purchase");
			}
		@Test(priority=2)
		public void planPurchase() throws InterruptedException, AWTException
			{
			explicitWait("//*[@class='active header_my-home ']");
			
			apwPlanPage PlanPage= new apwPlanPage(driver);
			PlanPage.ClickOnPlanMenu();
			logger.info("Click on plan menu");
			browserZoomInOut();
			PlanPage.ClickOnBuyNowButton();
			logger.info("Click on buy now button");
			
			
//			PlanPage.ClickOnPayOnlineButton();
//			logger.info("Click on pay online button");
			setIframeForPlanBuy();
			//Thread.sleep(4000);
			explicitWait("//*[contains(text(),'HDFC Bank Netbanking')]");
			driver.findElement(By.xpath("//*[contains(text(),'HDFC Bank Netbanking')]")).click();
			Thread.sleep(4000);
			closeIframe();
//			setIframeForPlanBuy();
			//driver.switchTo().frame(1);
			int window=driver.getWindowHandles().size();
			System.out.println(window);
			ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(newTb.get(1));
			explicitWait("//*[contains(text(),'Success')]");
			driver.findElement(By.xpath("//*[contains(text(),'Success')]")).click();
			driver.switchTo().window(newTb.get(0));
//			PlanPage.Pay_online();
//			logger.info("Click on pay now button");
//			closeIframe();
			Thread.sleep(12000);
			//driver.switchTo().alert().accept();
			driver.navigate().to("https://testfiles.abpweddings.com/plan?page=myplan");
//			Thread.sleep(3000);
//			if(driver.findElement(By.xpath("(//a[@class='invoice-link'])[1]")).isDisplayed()) 
//			{
//				logger.info("Plan Purchase: PASS");
//				logger.info("====================> End Plan Purchase Script <===========================");
//				assert(true);				
//			}
//			else
//			{
//				logger.info("Plan Purchase: FAILED");
//				logger.info("====================> End Plan Purchase Script <===========================");
//				assert(false);
//			}
			}
	}
