package abpw.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import abpw.utilities.XLUtils;

public class NCF_OLD_Moderation_EX extends BaseClass

{
	String AWID;
	String path=System.getProperty("user.dir")+"/src/test/java/abpw/testData/abpwDataSet.xlsx";
	@BeforeTest
	public void Read_Excel_From_Profiles_Sheet() throws IOException 
	{
		AWID=XLUtils.getCellData(path, "Profiles", 1, 1);
	}
	
	@Test
	public void Moderation_EXE() throws InterruptedException 
	{
		driver.get("http://10.132.100.50:8091/abp-matrimony-web-crm/");
		Thread.sleep(3000);	
		driver.findElement(By.id("country")).click();		
		driver.findElement(By.xpath("//option[2]")).click();
		driver.findElement(By.name("emailid")).sendKeys("moderatorexeone-mn@yopmail.com");
		driver.findElement(By.name("password")).sendKeys("cic123");
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		explicitWait("//input[@type='search']");
		Thread.sleep(1000);	
		driver.findElement(By.xpath("//*[@type='search']")).sendKeys(AWID);
		Thread.sleep(3000);		
		driver.findElement(By.xpath("//*[@id='moderateExecTblBody']//td[1]//a")).click();
		Thread.sleep(10000);
		driver.findElement(By.id("contentAccept")).click();
		driver.findElement(By.xpath("//a[@class='PhotoModeration']")).click();	
		driver.findElement(By.xpath("(//div[@class='checkbox-panel']//input)[1]")).click();
		driver.findElement(By.xpath("//a[@class='DocumentsModeration']")).click();
		driver.findElement(By.xpath("//*[@id='uploadDocumentFormSubmit']//td[4]//input[1]")).click();
		driver.findElement(By.id("submitButton2")).click();		
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		logger.info("NCF: Now profile is live");
	}
}
