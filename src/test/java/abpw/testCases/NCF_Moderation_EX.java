package abpw.testCases;

import org.testng.annotations.Test;

import abpw.utilities.ReadConfig;
import abpw.utilities.XLUtils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;


import io.github.bonigarcia.wdm.WebDriverManager;

public class NCF_Moderation_EX 
{
	ReadConfig  readconfig =new ReadConfig();
	String CRMurl=readconfig.getCRMurl();
	String user_moderationEX=readconfig.getModerationEXEuser();
	String user_moderationEX_password=readconfig.getModerationEXEpassword();
	WebDriver driver;
	String AWID;
	String path=System.getProperty("user.dir")+"/src/test/java/abpw/testData/abpwDataSet.xlsx";		
		@BeforeTest
		public void Read_Excel_From_Profiles_Sheet() throws IOException 
			{
				AWID=XLUtils.getCellData(path, "Profiles", 1, 1);
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.get(CRMurl);
				driver.findElement(By.xpath("//*[@id='inputEmail4']")).sendKeys(user_moderationEX);
				driver.findElement(By.xpath("//*[@id='Password']")).sendKeys(user_moderationEX_password);	
				driver.findElement(By.xpath("//*[@type='submit']")).click();
			}
		@Test
		public void acceptModeration() throws InterruptedException 
			{
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//span[@class='icon'])[2]")).click();
			driver.findElement(By.xpath("//span[contains(text(),'Moderation Execution Datasheet')]")).click();
			//Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@id='headerSearchInput']")).click();
			driver.findElement(By.xpath("//input[@id='headerSearchInput']")).sendKeys(AWID);
			Thread.sleep(6000);
			driver.findElement(By.xpath("(//td[a])[1]")).click();
			driver.findElement(By.xpath("//*[@id='gridCheck']")).click();
			driver.findElement(By.xpath("//span[contains(text(),'Photo Moderation')]")).click();
			driver.findElement(By.xpath("(//input[@value='checked'])[1]")).click();
			driver.findElement(By.xpath("//span[contains(text(),'Document  Moderation')]")).click();
			driver.findElement(By.xpath("(//input[@value='checked'])[2]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//button[contains(text(),'Submit')])[2]")).click();
			Thread.sleep(3000);
			driver.close();
			}

}
