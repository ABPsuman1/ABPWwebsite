package abpw.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import abpw.pageObject.abpwLandingPage;
import abpw.pageObject.abpwLoginPage;
import abpw.utilities.XLUtils;

public class TC_Delete_Profile extends BaseClass

{
	
	String path=System.getProperty("user.dir")+"/src/test/java/abpw/testData/abpwDataSet.xlsx";
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
			logger.info("====================> Login <===========================");
			abpwLandingPage LANDING = new abpwLandingPage(driver);
			LANDING.clickOnLoginLink();
			LANDING.clickOnLoginWithPasswordRadioButton();
		
			abpwLoginPage userLogin = new abpwLoginPage(driver);
			userLogin.setEmailID(uName);
			userLogin.setPassword(uPass);
			userLogin.clickLoginNowButton();
			logger.info("Login successfully for Plan Purchase");
		}
	@Test(priority = 2)
	public void delete_profile() throws InterruptedException 
	{
		Thread.sleep(10000);
		driver.navigate().to("https://testfiles.abpweddings.com/deactivate-profile");
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//*[@type='radio' ]//following::span)[3]")).click();
		scrollPage();
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//*[@class='row custom-toggle-row'])")).click();
		driver.findElement(By.xpath("//*[@id='new-register-flow-step-6-photoid_upload-yes-btn']")).click();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//*[@name='otp']")).click();
		
		driver.findElement(By.xpath("//*[@name='otp']")).sendKeys("123123");
		driver.findElement(By.xpath("//*[@class='btn btn-registration-primary-deactivate bd-confirm-submit-btn bd-submit-text-size']")).click();
		
		
	}

}
