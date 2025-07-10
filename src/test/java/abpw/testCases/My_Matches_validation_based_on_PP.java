package abpw.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class My_Matches_validation_based_on_PP extends BaseClass
	{
	String sourceUserId="AW43003587";
	String AGE="28";
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
	public void setPP() throws InterruptedException 
		{
		WebDriverWait wait= new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(((//ul[li])[7])//li)[1]//a" )));
		driver.findElement(By.xpath("(((//ul[li])[6])//li)[2]")).click();	
		//------- Wait for edit Age-------------
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='img-fluid'])[4]" )));
		driver.findElement(By.xpath("(//*[@class='img-fluid'])[4]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//*[contains(text(),'Age from')])//following::div[5]")).click();
		driver.findElement(By.xpath("(//*[contains(text(),'Age from')])//following::input[1]")).sendKeys(AGE);
		driver.findElement(By.xpath("(//*[contains(text(),'Age from')])//following::input[1]")).sendKeys(Keys.ENTER);
		
		driver.findElement(By.xpath("(//*[contains(text(),'Age to')])//following::div[5]")).click();
		driver.findElement(By.xpath("(//*[contains(text(),'Age to')])//following::input[1]")).sendKeys(AGE);
		driver.findElement(By.xpath("(//*[contains(text(),'Age to')])//following::input[1]")).sendKeys(Keys.ENTER);
		
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		}
	@Test(priority=3)
	public void verifyMyMatches() throws InterruptedException 
		{
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[@href='/my-matches'])[1]")).click();
		
		WebDriverWait wait= new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='name-text']")));
		int myMatchesCount =driver.findElements(By.xpath("//p[@class='name-text']")).size();
		System.out.println(myMatchesCount);
		
		for (int i=1; i<=myMatchesCount; i++)
			{
			String unameXpath="(//p[@class='name-text'])["+i+"]//span[1]";
			String uAgeXpath="(//p[@class='name-text'])["+i+"]//span[2]";
				System.out.println("-------------------------- ");
				System.out.println(driver.findElement(By.xpath(unameXpath)).getText());
				String MyMatcheAge= driver.findElement(By.xpath(uAgeXpath)).getText();
				String[] getAge = MyMatcheAge.split("(?<=.)");
				String NEWAGE =getAge[0]+""+getAge[1];
				System.out.println("Getting Age From My Matches: "+NEWAGE);
				
				if (AGE.equals(NEWAGE))
				{
					System.out.println("Age Matched from PP");
				}
				else
				{
					System.out.println("Age Not Matched from PP");
				}
			}
		}
	}
