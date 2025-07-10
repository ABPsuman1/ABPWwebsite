package abpw.testCases;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Plan_Purchase extends BaseClass
{
	@Test(priority=1)
	public void login() 
		{
		driver.findElement(By.xpath("//*[@id='landingPage_topbar_register']")).click();
		driver.findElement(By.xpath("//*[@id='landPage_login_IhavePasswd_radio']")).click();
		driver.findElement(By.xpath("//*[@class='input_email']")).sendKeys("AW61792437");
		driver.findElement(By.xpath("//*[@class='input_password']")).clear();
		driver.findElement(By.xpath("//*[@class='input_password']")).sendKeys("password");
		driver.findElement(By.xpath("//*[@id='landPage_login_loginWithPassword_loginNow']")).click();
		}
	@Test(priority=2)
	public void planPurchase() throws InterruptedException, AWTException
		{
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//*[@href='/plan'])[1]")).click();
		browserZoomInOut();
		
		driver.findElement(By.xpath("//button[@class='plan-buy-now']")).click();
		driver.findElement(By.xpath("(//a[@class='payonlnebtn'])[1]")).click();
		Thread.sleep(10000);
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println(size);
		driver.switchTo().frame(4);
		driver.findElement(By.xpath("(//div[@class='stack svelte-by96ls horizontal'])[2]")).click();
		driver.findElement(By.xpath("//div[@id='new-vpa-field-upi']")).click();
		driver.findElement(By.id("vpa-upi")).sendKeys("success@razorpay");
		Thread.sleep(2000);
		driver.findElement(By.id("redesign-v15-cta")).click();
		Thread.sleep(20000);
		driver.switchTo().defaultContent();
		//driver.switchTo().alert().accept();
			
		}
}
