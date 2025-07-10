package abpw.testCases;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import abpw.pageObject.abpwForgotPasswordPage;
import abpw.pageObject.abpwLandingPage;
import abpw.utilities.XLUtils;

public class TC_Forgot_Password extends BaseClass
	{
		String path=System.getProperty("user.dir")+"/src/test/java/abpw/testData/abpwDataSet.xlsx";
		String USERID; 
		String updatePassword="password";
		
		@BeforeTest
		public void Read_Excel_From_Profiles_Sheet() throws IOException 
		{
			USERID=XLUtils.getCellData(path, "Profiles", 1, 1);
		}
		@Test(priority=1)
		public void openForgot_Password_Page() 
		{
			try 
				{
				logger.info("====================> Start Forgot Password Script <===========================");
				abpwLandingPage LANDING = new abpwLandingPage(driver);
				LANDING.clickOnLoginLink();
				logger.info("=> Click on login link");
				LANDING.clickOnLoginWithPasswordRadioButton();
				logger.info("=> Click on login with password radio button");
				LANDING.clickOnForgotPasswordLink();
				logger.info("=> Click on forgot password link");
				} 
			catch (Exception e) 
				{
				logger.info("Opening forgot password page - Failed");
				 System.out.println(e);
				}
		}
		
		
		@Test(priority=2)
		public void Set_Password() throws InterruptedException, AWTException 
		{
			try 
				{
				abpwForgotPasswordPage AFPL= new abpwForgotPasswordPage(driver);
				
				AFPL.enterUserDetails(USERID);
				logger.info("=> Enter user AWID");
				AFPL.clickOnGenerateOTPbutton();
				logger.info("=> Click on generate OTP button");
				String OTP=getOTP(USERID);
				AFPL.setForgotPasswordOTP(OTP);
				logger.info("=> Enter user OTP");
				AFPL.clickOnVerifyOtpButton();
				logger.info("=> Click on verify otp button");
				explicitWait("//*[@placeholder='Enter New Password']");
				AFPL.setNewPassword(updatePassword);
				logger.info("=> Enter new password");
				AFPL.setConfPassword(updatePassword);
				logger.info("=> Enter confirm password");
				AFPL.clickOnChangePasswordButton();
				logger.info("====================> End Forgot Password Script <===========================");
				} 
			catch (Exception e) 
				{
				logger.info("Set new password - Failed");
				 System.out.println(e);
				}			
		}
	}
