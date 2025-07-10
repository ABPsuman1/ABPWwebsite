package abpw.pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class abpwRegistrationPage 
	{
		WebDriver ldriver;
		public abpwRegistrationPage(WebDriver rdriver)
		{
			ldriver=rdriver;
			PageFactory.initElements((WebDriver) rdriver, this);
		}
		
//		-------- Start Registration First Screen -------------------------------
	
		@FindBy(xpath="(//button[contains(text(),'Mobile Number')])[1]")
		@CacheLookup
		WebElement btnMobileNumberField;
		
		@FindBy(xpath="//*[@placeholder='Enter Mobile Number']")
		@CacheLookup
		WebElement txtMobileNumber;
		
		@FindBy(xpath="//*[contains(text(),'Citizen of')]")
		@CacheLookup
		WebElement btnCitizenOf;
		
		@FindBy(xpath="//*[contains(text(),'Citizen of')]//following::input[1]")
		@CacheLookup
		WebElement selectCitizenOf;
		
		@FindBy(xpath="//*[contains(text(),'Gender')]")
		@CacheLookup
		WebElement btnGender;
		
		@FindBy(xpath="//*[contains(text(),'Gender')]//following::input[1]")
		@CacheLookup
		WebElement selectGender;
		
		@FindBy(xpath="//*[contains(text(),'Mother Tongue')]")
		@CacheLookup
		WebElement btnMotherTongue;
		
		@FindBy(xpath="//*[contains(text(),'Mother Tongue')]//following::input[1]")
		@CacheLookup
		WebElement selectMotherTongue;
		
		@FindBy(xpath="(//div[@class='col-md-12'])[5]")
		@CacheLookup
		WebElement selectDobfield;
		
		@FindBy(xpath="//*[@placeholder='dd/mm/yyyy']")
		@CacheLookup
		WebElement selectDobCalendar;
		
		@FindBy(xpath="//*[@aria-label='Previous Month']")
		@CacheLookup
		WebElement selectPreCalendarMonth;
		
		@FindBy(xpath="//*[text()='11']")
		@CacheLookup
		WebElement selectDOB11;
		
		@FindBy(xpath="//*[text()='NEXT STEP']")
		@CacheLookup
		WebElement btnNextStepValidateOTP;
		
		public void clickMobileNumberField()
		{
			btnMobileNumberField.click();
		}
		public void setMobileNumber(String MobileNumber)
		{
			txtMobileNumber.sendKeys(MobileNumber);
		}
		public void selectCitizenOf(String CitizenOf)
		{
			btnCitizenOf.click();
			selectCitizenOf.sendKeys(CitizenOf);
			selectCitizenOf.sendKeys(Keys.ENTER);
		}
		public void selectGender(String Gender)
		{
			btnGender.click();
			selectGender.sendKeys(Gender);
			selectGender.sendKeys(Keys.ENTER);
			
			//selectGender_Male.click();
		}
		public void selectMotherTongue(String MotherTongue)
		{
			btnMotherTongue.click();
			selectMotherTongue.sendKeys(MotherTongue);
			selectMotherTongue.sendKeys(Keys.ENTER);
		}
		
		public void selectDOB()
		{
			selectDobfield.click();
			selectDobCalendar.click();
			selectPreCalendarMonth.click();
			selectDOB11.click();
		}
		
		public void clickNextStepValidateOTP() throws InterruptedException
		{
			Thread.sleep(3000);
			btnNextStepValidateOTP.click();
		}
//		-------- End Registration First Screen ---------------------------------
//		-------- Start OTP Screen ----------------------------------------------
		@FindBy(xpath="//input[@name='otpfield-1']")
		@CacheLookup
		WebElement txtOtpfield1;
		
		@FindBy(xpath="//input[@name='otpfield-2']")
		@CacheLookup
		WebElement txtOtpfield2;
		
		@FindBy(xpath="//input[@name='otpfield-3']")
		@CacheLookup
		WebElement txtOtpfield3;
		
		@FindBy(xpath="//input[@name='otpfield-4']")
		@CacheLookup
		WebElement txtOtpfield4;
		
		@FindBy(xpath="//input[@name='otpfield-5']")
		@CacheLookup
		WebElement txtOtpfield5;
		
		@FindBy(xpath="//input[@name='otpfield-6']")
		@CacheLookup
		WebElement txtOtpfield6;
		
		@FindBy(xpath="//*[@placeholder='Please enter OTP']")
		@CacheLookup
		WebElement txtOTP;
		
		@FindBy(xpath="//*[text()='NEXT STEP - BASIC DETAILS']")
		@CacheLookup
		WebElement btnNextStepBasicDetails;
		
		public void setOTP1(String OTP1)
		{
			txtOtpfield1.click();
			txtOtpfield1.sendKeys(OTP1);
		}
		public void setOTP2(String OTP2)
		{
			txtOtpfield2.click();
			txtOtpfield2.sendKeys(OTP2);
		}
		public void setOTP3(String OTP3)
		{
			txtOtpfield3.click();
			txtOtpfield3.sendKeys(OTP3);
		}
		public void setOTP4(String OTP4)
		{
			txtOtpfield4.click();
			txtOtpfield4.sendKeys(OTP4);
		}
		public void setOTP5(String OTP5)
		{
			txtOtpfield5.click();
			txtOtpfield5.sendKeys(OTP5);
		}
		public void setOTP6(String OTP6)
		{
			txtOtpfield6.click();
			txtOtpfield6.sendKeys(OTP6);
		}
		public void setOTP(String OTP) 
		{
			txtOTP.clear();
			txtOTP.sendKeys(OTP);
		}
		public void clickNextStepBasicDetails() throws InterruptedException
		{
			Thread.sleep(3000);
			btnNextStepBasicDetails.click();
		}
//		-------- End OTP Screen ------------------------------------------------
//		-------- Start Basic Details 3rd Screen --------------------------------
		@FindBy(xpath="//*[contains(text(),'Profile Created By')]")
		@CacheLookup
		WebElement btnProfileCreateBy;
		
		@FindBy(xpath="//*[contains(text(),'Profile Created By')]//following::input[1]")
		@CacheLookup
		WebElement selectProfileCreateBy;
		
		@FindBy(xpath="(//button[@class='pseudotextbox light-pseudo-box'])[1]")
		@CacheLookup
		WebElement txtUserNameField;
				
		@FindBy(xpath="(//input)[3]")
		@CacheLookup
		WebElement txtUserName;
		
		@FindBy(xpath="//button[@class='pseudotextbox light-pseudo-box email-form ']")
		@CacheLookup
		WebElement txtUserEmailField;
				 
		@FindBy(xpath="(//input[@type='text'])[2]")
		@CacheLookup
		WebElement txtUserEmail;
		
		@FindBy(xpath="//*[contains(text(),'Religion')]")
		@CacheLookup
		WebElement btnReligion;
		
		@FindBy(xpath="//*[contains(text(),'Religion')]//following::input[1]")
		@CacheLookup
		WebElement selectReligion;
		
		@FindBy(xpath="//*[contains(text(),'Caste')]")
		@CacheLookup
		WebElement btnCaste;
		
		@FindBy(xpath="//*[contains(text(),'Caste')]//following::input[1]")
		@CacheLookup
		WebElement selectCaste;
		
		@FindBy(xpath="//*[contains(text(),'Marital Status')]")
		@CacheLookup
		WebElement btnMaritalStatus;
		
		@FindBy(xpath="//*[contains(text(),'Marital Status')]//following::input[1]")
		@CacheLookup
		WebElement selectMaritalStatus;
		
		@FindBy(xpath="//*[contains(text(),'Location')]")
		@CacheLookup
		WebElement btnLocation;
		
		@FindBy(xpath="//*[contains(text(),'Location')]//following::input[1]")
		@CacheLookup
		WebElement txtLocation;
		
//		@FindBy(xpath="//*[text()='Kolkata,West Bengal,India']")
//		@CacheLookup
//		WebElement selectLocationKolkata;
				
		@FindBy(xpath="(//*[contains(text(),'Height')])[2]")
		@CacheLookup
		WebElement btnHeight;
		
		@FindBy(xpath="(//*[contains(text(),'Height')])[2]//following::input[1]")
		@CacheLookup
		WebElement selectHeight;
		
		@FindBy(xpath="//*[text()='NEXT STEP']")
		@CacheLookup
		WebElement btnNextStepPhotoUpload;
		
		public void selectProfileCreateBy(String CreateBy)
		{
			btnProfileCreateBy.click();
			selectProfileCreateBy.sendKeys(CreateBy);
			selectProfileCreateBy.sendKeys(Keys.ENTER);
		}
		
		public void enterUserName(String Uname)
		{
			txtUserNameField.click();
			txtUserName.sendKeys(Uname);
		}
		public void enterUserEmail(String email)
		{
			txtUserEmailField.click();
			txtUserEmail.sendKeys(email);
		}
		public void selectReligion(String Religion)
		{
			btnReligion.click();
			selectReligion.sendKeys(Religion);
			selectReligion.sendKeys(Keys.ENTER);
		}
		public void selectCaste(String Caste)
		{
			btnCaste.click();
			selectCaste.sendKeys(Caste);
			selectCaste.sendKeys(Keys.ENTER);
		}
		public void selectMaritalStatus(String MaritalStatus)
		{
			btnMaritalStatus.click();
			selectMaritalStatus.sendKeys(MaritalStatus);
			selectMaritalStatus.sendKeys(Keys.ENTER);
		}
		public void setLocation(String Location) throws InterruptedException 
		{
			btnLocation.click();
			Thread.sleep(3000);
			txtLocation.sendKeys(Location);
			txtLocation.sendKeys(Keys.ENTER);			
		}
		
		public void selectHeight(String Height) 
		{
			btnHeight.click();
			selectHeight.sendKeys(Height);
			selectHeight.sendKeys(Keys.ENTER);
		}
		public void clickNextStepPhotoUpload() throws InterruptedException
		{
			Thread.sleep(3000);
			btnNextStepPhotoUpload.click();
		}
//		-------- End Basic Details 3rd Screen ----------------------------------

	}
