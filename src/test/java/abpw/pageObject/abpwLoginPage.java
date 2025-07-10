package abpw.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class abpwLoginPage 
	{
		WebDriver ldriver;
		public abpwLoginPage(WebDriver rdriver)
			{
				ldriver=rdriver;
				PageFactory.initElements((WebDriver) rdriver, this);
			}
				
		@FindBy(xpath = "//*[@class='input_email']")
		@CacheLookup
		WebElement txtEmail;
		
		@FindBy(xpath = "//*[@class='input_password']")
		@CacheLookup
		WebElement txtPassword;
		
		@FindBy(xpath = "//*[@id='landPage_login_loginWithPassword_loginNow']")
		@CacheLookup
		WebElement btnLoginNow;
		
		
		public void setEmailID(String uemail)
			{
				txtEmail.clear();
				txtEmail.sendKeys(uemail);
			}
		public void setPassword(String upassword)
			{
				txtPassword.clear();
				txtPassword.sendKeys(upassword);
			}
		public void clickLoginNowButton()
			{
				btnLoginNow.click();
			}
}
