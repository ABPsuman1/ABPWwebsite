package abpw.testCases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class NCF_Get_OTP extends BaseClass
{
	String AWID;
	@Test(priority=1)
	public void loginCRM_mgr() throws InterruptedException {
	driver.get("https://crmqa.abpweddings.com");
	driver.findElement(By.xpath("//*[@id='inputEmail4']")).sendKeys("test.testcrmmgr@yopmail.com");
	driver.findElement(By.xpath("//*[@id='Password']")).sendKeys("cic123");	
	driver.findElement(By.xpath("//*[@type='submit']")).click();
	
//	--- Get AWID ---------------
	Thread.sleep(3000);
	 driver.findElement(By.xpath("(//*[@aria-label='Search'])[1]")).click();
	 driver.findElement(By.xpath("(//*[@aria-label='Search'])[1]")).sendKeys("9932785146");
	 driver.findElement(By.xpath("//*[@id='button-addon2']")).click();
	 Thread.sleep(6000);
	 AWID =driver.findElement(By.xpath("//td//a")).getText();
	
	
	Thread.sleep(3000);
	driver.findElement(By.xpath("(//span[@class='icon'])[2]")).click();
	
	driver.findElement(By.xpath("//span[contains(text(),'Get Otp')]")).click();
	driver.findElement(By.xpath("//*[@id='exampleFormControlTextarea1']")).click();
	driver.findElement(By.xpath("//*[@id='exampleFormControlTextarea1']")).sendKeys(AWID);
	driver.findElement(By.xpath("(//button)[5]")).click();
	
//	get otp
	 String OTP_FROM_CRM = driver.findElement(By.xpath("//tbody//tr/td[2]")).getText();
	 System.out.println(OTP_FROM_CRM);
	}
	
	
}
