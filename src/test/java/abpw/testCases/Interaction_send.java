package abpw.testCases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Interaction_send extends BaseClass
	{
		String sourceUserId="AW43003587";
		String TargetUserID="AW95570117";
		@Test(priority=1)
		public void login() 
		{
			driver.findElement(By.xpath("//*[@id='landingPage_topbar_register']")).click();
			driver.findElement(By.xpath("//*[@id='landPage_login_IhavePasswd_radio']")).click();
			driver.findElement(By.xpath("//*[@class='input_email']")).sendKeys(sourceUserId);
			driver.findElement(By.xpath("//*[@class='input_password']")).clear();
			driver.findElement(By.xpath("//*[@class='input_password']")).sendKeys("password");
			driver.findElement(By.xpath("//*[@id='landPage_login_loginWithPassword_loginNow']")).click();
		
		}
		@Test(priority=2)
		public void searchProfile() throws AWTException, InterruptedException
		{
			WebDriverWait wait= new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'Edit Profile')])[2]" )));
			driver.findElement(By.xpath("((//ul[li])[1]//following::li)[2]")).click();
			driver.findElement(By.xpath("//input[@type='search']")).clear();
			driver.findElement(By.xpath("//input[@type='search']")).sendKeys(TargetUserID);
			
			driver.findElement(By.xpath("//*[@class='go-btn']")).click();	
			//------- wait and or condition apply
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Request contact')] | //*[contains(text(),'View Contact')]")));
			Thread.sleep(2000);
			zoomIn();
			zoomIn();
			zoomIn();
			zoomIn();
			zoomIn();
			//---------- Click on the search profile -----------------------
			driver.findElement(By.xpath("(//div[@class='row'])[6]")).click();
		}
		
		@Test(priority=3)
		public void viewProfile() throws InterruptedException
		{
			Thread.sleep(2000);
			ArrayList<String> tabs= new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			
			WebDriverWait wait= new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'Suggested for you')])[1]")));
			//---------- 
			Thread.sleep(2000);//photo request
			boolean photoRequestButton= driver.findElement(By.xpath("//*[@class='sendrequestbtn']")).isDisplayed();
			if (photoRequestButton==true)
			{
				System.out.println("check");
				driver.findElement(By.xpath("//*[@class='sendrequestbtn']")).click();
			}
			else 
			{
				System.out.println("Photo already unlocked");
			}
			Thread.sleep(2000);//send interest
			driver.findElement(By.xpath("//ul[@class='new-profile-details-modalicon-section ul-flex']//li[1]")).click();
			Thread.sleep(2000);//contact
			driver.findElement(By.xpath("//ul[@class='new-profile-details-modalicon-section ul-flex']//li[2]")).click();
			Thread.sleep(2000);// chat
			driver.findElement(By.xpath("//ul[@class='new-profile-details-modalicon-section ul-flex']//li[3]")).click();
			Thread.sleep(2000);// astrology
			driver.findElement(By.xpath("//*[@class='request-now ml-0 ']")).click();
			Thread.sleep(1500);
			driver.findElement(By.xpath("//*[@class='ok_btn ']")).click();
			driver.close();
			driver.switchTo().window(tabs.get(0));
		}
		@Test(priority=4)
		public void logout() throws InterruptedException 
		{
			driver.findElement(By.xpath("((//ul[li])[1]//li)[1]")).click();
			driver.findElement(By.xpath("(//*[@class='left-img'])[4]")).click();
			Thread.sleep(1500);
			driver.findElement(By.xpath("(((//ul[li])[8])//li)[6]//a")).click();
			Thread.sleep(3000);
		}
		@Test(priority=5)
		public void loginAgain() 
		{
			driver.findElement(By.xpath("//*[@id='landingPage_topbar_register']")).click();
			driver.findElement(By.xpath("//*[@id='landPage_login_IhavePasswd_radio']")).click();
			driver.findElement(By.xpath("//*[@class='input_email']")).sendKeys(TargetUserID);
			driver.findElement(By.xpath("//*[@class='input_password']")).clear();
			driver.findElement(By.xpath("//*[@class='input_password']")).sendKeys("password");
			driver.findElement(By.xpath("//*[@id='landPage_login_loginWithPassword_loginNow']")).click();
		
		}
		@Test(priority=6)
		public void checkInteraction() throws InterruptedException 
		{
			Thread.sleep(10000);
			driver.findElement(By.xpath("(((//ul[li])[7])//li)[1]//a")).click();
			//driver.findElement(By.id("uncontrolled-tab-example-tab-request-sent")).click();
			Thread.sleep(10000);
			int elementsCounts = driver.findElements(By.xpath("//div[@class='memberid matchcard']")).size();
			System.out.println("Total Profile count in pending section: "+elementsCounts);
			int i;
			for(i=1; i<elementsCounts; i++) 
			{
				String findAWID="(//div[@class='memberid matchcard'])["+i+"]";	
				String msgTextXpath="(//div[@class='statusmessage'])["+i+"]";
				String AWID = driver.findElement(By.xpath(findAWID)).getText();
				if (AWID.equals(sourceUserId))
				{
					String msgText= driver.findElement(By.xpath(msgTextXpath)).getText();
					System.out.println("Recived MSG: "+msgText);
				}
				
				System.out.println(AWID);
				
			}
			
			
		
		}
		
		 public void zoomIn() throws AWTException
		 {
			 Robot robot = new Robot();
//			 This code causes the zoom level to decrease:
			 robot.keyPress(KeyEvent.VK_CONTROL);
			 robot.keyPress(KeyEvent.VK_MINUS);
			 robot.keyRelease(KeyEvent.VK_CONTROL);
			 robot.keyRelease(KeyEvent.VK_MINUS);
		 }
	}
