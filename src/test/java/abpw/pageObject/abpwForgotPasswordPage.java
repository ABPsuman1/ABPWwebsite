package abpw.pageObject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class abpwForgotPasswordPage 
	{
		WebDriver ldriver;
		public abpwForgotPasswordPage(WebDriver rdriver)
			{
				ldriver=rdriver;
				PageFactory.initElements((WebDriver) rdriver, this);
			}
		@FindBy(xpath = "//*[@placeholder='Enter Email/Profile ID/Phone']")
		@CacheLookup
		WebElement txtForgotPasswordID;
		
		@FindBy(id = "landPage_login_forgotpwd_start_gentOTP")
		@CacheLookup
		WebElement btnGenerateOTP;
		
		@FindBy(xpath = "//*[@placeholder='Enter OTP here']")
		@CacheLookup
		WebElement txtForgotPasswordOTP;
		
		@FindBy(id = "landPage_login_forgotpwd_otp_verfyOTP")
		@CacheLookup
		WebElement btnVerifyOTP;
		
		@FindBy(xpath = "//*[@placeholder='Enter New Password']")
		@CacheLookup
		WebElement txtNewPassword;
		
		@FindBy(xpath = "//*[@placeholder='Confirm New Password']")
		@CacheLookup
		WebElement txtConfPassword;
		
		@FindBy(id = "landPage_login_forgotpwd_reset_changepwd")
		@CacheLookup
		WebElement btnChangePassword;
		
		public void enterUserDetails(String UserID) 
		{
			txtForgotPasswordID.clear();
			txtForgotPasswordID.sendKeys(UserID);
		}
		
		public void clickOnGenerateOTPbutton() 
		{
			btnGenerateOTP.click();
		}
		
		public void setForgotPasswordOTP(String OTP) 
		{
			txtForgotPasswordOTP.clear();
			txtForgotPasswordOTP.sendKeys(OTP);
		}
		public void clickOnVerifyOtpButton() 
		{
			btnVerifyOTP.click();
		}
		public void setNewPassword(String NEWPASSWORD) 
		{
			txtNewPassword.clear();
			txtNewPassword.sendKeys(NEWPASSWORD);
		}
		public void setConfPassword(String CONFPASSWORD) 
		{
			txtConfPassword.clear();
			txtConfPassword.sendKeys(CONFPASSWORD);
		}
		public void clickOnChangePasswordButton() 
		{
			btnChangePassword.click();
		}
		
}
