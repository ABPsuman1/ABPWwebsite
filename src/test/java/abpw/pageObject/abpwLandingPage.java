package abpw.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class abpwLandingPage 
	{
	WebDriver ldriver;
	public abpwLandingPage(WebDriver rdriver)
		{
			ldriver=rdriver;
			PageFactory.initElements((WebDriver) rdriver, this);
		}
	
		@FindBy(xpath = "//*[@id='landingPage_topbar_register']")
		@CacheLookup
		WebElement linkLogin;
		
		@FindBy(xpath = "//*[@id='landPage_login_IhavePasswd_radio']")
		@CacheLookup
		WebElement radioBtnLoginWithPassword;
		
		@FindBy(xpath = "//*[@id='landPage_login_forgotPasswd']")
		@CacheLookup
		WebElement linkForgotPassword;
		
		public void clickOnLoginLink()
		{
			linkLogin.click();
		}
	
		public void clickOnLoginWithPasswordRadioButton()
		{
			radioBtnLoginWithPassword.click();
		}
		public void clickOnForgotPasswordLink()
		{
			linkForgotPassword.click();
		}
	}
