package abpw.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import abpw.utilities.XLUtils;

@Test
public class NCF_OLD_Moderation_TL extends BaseClass

{
	String AWID;
	String path=System.getProperty("user.dir")+"/src/test/java/abpw/testData/abpwDataSet.xlsx";
	@BeforeTest
	public void Read_Excel_From_Profiles_Sheet() throws IOException 
	{
		AWID=XLUtils.getCellData(path, "Profiles", 1, 1);
	}
	
	public void Moderation_TL() throws InterruptedException 
	{
		driver.get("http://10.132.100.50:8091/abp-matrimony-web-crm/");
		Thread.sleep(3000);	
		driver.findElement(By.id("country")).click();
		driver.findElement(By.xpath("//option[2]")).click();
		driver.findElement(By.name("emailid")).sendKeys("moderatortl-mn@yopmail.com");
		driver.findElement(By.name("password")).sendKeys("cic123");
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		Thread.sleep(6000);
		
		//driver.findElement(By.id("checkboxcheckboxAssignToId")).click();
		
		
		int i;
		
		for(i=1; i<3; i++) 
		{
			driver.findElement(By.id("filter_submit_btn")).click();
			explicitWait("(//input[@id='checkbox'])[1]");
			Thread.sleep(6000);
			driver.findElement(By.xpath("//*[@type='search']")).clear();
			driver.findElement(By.xpath("//*[@type='search']")).sendKeys(AWID);
			Thread.sleep(13000);
			
			int chkBox= driver.findElements(By.xpath("//thead//tr")).size();
			System.out.println("-----------"+chkBox);
			if (chkBox==2) 
			{
				try 
				{
					driver.findElement(By.xpath("(//input[@id='checkbox'])[1]")).click();		
					driver.findElement(By.id("moderatorSelectedId")).click();	
					driver.findElement(By.xpath("//option[@value='8018']")).click();
					driver.findElement(By.id("submit_btn")).click();	
					Thread.sleep(3000);
					driver.switchTo().alert().accept();
					logger.info("NCF: Assign to executive");
					i=3;
				} catch (Exception e) {
					System.out.println(e);
				}
			}
			else 
			{
				logger.info("NCF: Profile not found under moderation");
				i++;
			}
		}
	}
}
