package abpw.testCases;

import org.testng.annotations.Test;

import abpw.utilities.ReadConfig;
import abpw.utilities.XLUtils;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;


import io.github.bonigarcia.wdm.WebDriverManager;

public class NCF_Moderation_TL

{
	ReadConfig  readconfig =new ReadConfig();
	String CRMurl=readconfig.getCRMurl();
	String user_moderationTL=readconfig.getModerationTLuser();
	String user_moderationTL_password=readconfig.getModerationTLuserPassword();
	String moderationEXEname=readconfig.getModerationEXEname();
	WebDriver driver;
	String AWID;
	String Mobile_Number;
	//String CRMurl="crmqa.abpweddings.com/";
	String path=System.getProperty("user.dir")+"/src/test/java/abpw/testData/abpwDataSet.xlsx";
	@BeforeTest
	public void Read_Excel_From_Registration_Sheet() throws IOException, InterruptedException 
	{
		Mobile_Number=XLUtils.getCellData(path, "Registration", 1, 1);
		WebDriverManager.firefoxdriver().setup();
		 driver = new FirefoxDriver();
		 driver.manage().window().maximize();
		 driver.get(CRMurl);
			driver.findElement(By.xpath("//*[@id='inputEmail4']")).sendKeys(user_moderationTL);
			driver.findElement(By.xpath("//*[@id='Password']")).sendKeys(user_moderationTL_password);	
			driver.findElement(By.xpath("//*[@type='submit']")).click();
			
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("(//*[@aria-label='Search'])[1]")).click();
		 driver.findElement(By.xpath("(//*[@aria-label='Search'])[1]")).sendKeys(Mobile_Number);
		 driver.findElement(By.xpath("//*[@id='button-addon2']")).click();
		 Thread.sleep(6000);
		 AWID =driver.findElement(By.xpath("//td//a")).getText();
		 XLUtils.setCellData(path, "Profiles", 1, 1, AWID);
		 System.out.println(AWID);
	}
	
	@Test
	public void ModerationTL() throws InterruptedException
	{
//		System.out.println("CRM URL: "+CRMurl+" USER: "+user_moderationTL+" AND PASSWORD IS: "+user_moderationTL_password);
//		--------------------- Logout URL ------------------------------------------
//		String LogoutURL="https://abpwedcrmapis.abpweddings.com/prod/crmusers/logout/"+user_moderationTL;
//		driver.get(LogoutURL);
//		--------------------- Try to login crm with modreation TL -----------------	
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//span[@class='icon'])[2]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Allocation Dashboard')]")).click();
		rowcount();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='headerSearchInput']")).click();
		driver.findElement(By.xpath("//input[@id='headerSearchInput']")).sendKeys(AWID);
		executeassign();
		driver.findElement(By.xpath("(//*[@type='checkbox'])[2]")).click();
		driver.findElement(By.xpath("//select[@class='form-select']")).click();
		//String MOD_EXE_NAME="\"//option[contains(text(),'"+moderationEXEname+"')]\"";
		driver.findElement(By.xpath("//option[contains(text(),'"+moderationEXEname+"')]")).click();
//		driver.findElement(By.xpath("//option[contains(text(),'Moderator Exeone')]")).click();
		driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
		driver.close();
	}
	public void rowcount() throws InterruptedException
	{
		for (int i=0; i<5; i++)
		{
			Thread.sleep(3000);
			int rowcount=driver.findElements(By.xpath("//*[tbody]//tr")).size();
			if(rowcount> 5)
			{
				System.out.println("Total row count :"+rowcount);
				i=5;
			}
			else
			{
				i++;
			}
		}
	}
	public void executeassign() throws InterruptedException
	{
		for (int j=0; j<5; j++)
		{
			Thread.sleep(3000);
			int rowcount=driver.findElements(By.xpath("//*[@type='checkbox']")).size();
			if(rowcount==2)
			{
				System.out.println("Total row count :"+rowcount);
				j=5;
			}
			else
			{
				System.out.println("Loop count with row :"+rowcount);
				j++;
			}
		}
	}
	public void explicitWait(String Located)
	 {
		 WebDriverWait wait = new WebDriverWait(driver, 60);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Located)));
		 System.out.println("Wait is completed");
	 }
}


	

