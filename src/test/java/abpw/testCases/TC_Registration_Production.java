package abpw.testCases;
import java.awt.AWTException;
import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import abpw.pageObject.abpwLandingPage;
import abpw.pageObject.abpwRegistrationPage;
import abpw.utilities.XLUtils;

public class TC_Registration_Production extends BaseClass{
	
	
	String path=System.getProperty("user.dir")+"/src/test/java/abpw/testData/abpwDataSet.xlsx";
	String image_path=System.getProperty("user.dir")+"\\src\\test\\java\\abpw\\testData\\male.jpg";
	String Mobile_Number, CitizenOf, Gender, MotherTongue, ProfileCreatedBy, BrideGroomName, Email_ID, Religion, 
	Caste, MaritalStatus, Location, Height;
		
	@BeforeTest
	public void Read_Excel_Data_From_Registration_Sheet() throws IOException 
	{
		Mobile_Number=XLUtils.getCellData(path, "Registration", 1, 1);
		CitizenOf=XLUtils.getCellData(path, "Registration", 2, 1);
		Gender=XLUtils.getCellData(path, "Registration", 3, 1);
		MotherTongue=XLUtils.getCellData(path, "Registration", 4, 1);
		ProfileCreatedBy=XLUtils.getCellData(path, "Registration", 5, 1);
		BrideGroomName=XLUtils.getCellData(path, "Registration", 6, 1);
		Email_ID=XLUtils.getCellData(path, "Registration", 7, 1);
		Religion=XLUtils.getCellData(path, "Registration", 8, 1);
		Caste=XLUtils.getCellData(path, "Registration", 9, 1);
		MaritalStatus=XLUtils.getCellData(path, "Registration", 10, 1);
		Location=XLUtils.getCellData(path, "Registration", 11, 1);
		Height=XLUtils.getCellData(path, "Registration", 12, 1);
	}
	
	@Test(priority=1)
	public void Registration_BasicDetails() throws AWTException, InterruptedException
	{
		try 
			{
			logger.info("====================> Start User Registration Script <===========================");
			
			browserZoomInOut();
			browserZoomInOut();	
//			------------ Start Registration First Screen -------------------------
			logger.info("------------ Landing on home screen ------------ ");
			abpwRegistrationPage AReg= new abpwRegistrationPage(driver);
			AReg.clickMobileNumberField();
			logger.info("Click on mobile number field");
			AReg.setMobileNumber(Mobile_Number);
			logger.info("Enter mobile number");
			
//			-------------------- Duplicate number checking --------------------
			Thread.sleep(5000);
//			boolean chkDuplicateMobNumber= driver.findElement(By.xpath("//*[text()='Provided mobile already registered']")).isDisplayed();
			boolean chkDuplicateMobNumber= driver.getPageSource().contains("Provided mobile already registered");
			
			System.out.println(chkDuplicateMobNumber);
			if(chkDuplicateMobNumber==true) 
				{
				abpwLandingPage LANDING = new abpwLandingPage(driver);
				LANDING.clickOnLoginLink();
//				LANDING.clickOnLoginWithPasswordRadioButton();
				
				driver.findElement(By.xpath("//*[@name='mobileNo']")).click();
				driver.findElement(By.xpath("//*[@name='mobileNo']")).sendKeys(Mobile_Number);
				driver.findElement(By.xpath("//*[@id='landPage_login_loginWithOTP_generateOTP']")).click();
				
				driver.findElement(By.xpath("//*[@name='otp']")).click();
				driver.findElement(By.xpath("//*[@name='otp']")).sendKeys(getOTP_from_CRM_QA(Mobile_Number));
				driver.findElement(By.xpath("//*[@id='landPage_login_validateOTP_btn']")).click();
				Thread.sleep(4000);
				deleteProfile();
				logger.info("Delete successfully");
				
				explicitWait("(//button[contains(text(),'Mobile Number')])[1]");
				
				abpwRegistrationPage Reg= new abpwRegistrationPage(driver);
//				driver.findElement(By.xpath("(//button[contains(text(),'Mobile Number')])[1]")).click();
				Reg.clickMobileNumberField();
				logger.info("Click on mobile number field");
				//driver.findElement(By.xpath("//*[@placeholder='Enter Mobile Number']")).sendKeys(Mobile_Number);
				Reg.setMobileNumber(Mobile_Number);
				logger.info("Enter mobile number");
				}
			else
				{
				System.out.println("No duplicate mobile number found");
				}
			
//			AReg.selectCitizenOf(CitizenOf);
//			logger.info("Select citizen of");
			Thread.sleep(3000);
			AReg.enterUserName(BrideGroomName);
			logger.info("Enter bride/groom name");
			Thread.sleep(3000);
			AReg.selectGender(Gender);
			logger.info("Select gender");
			Thread.sleep(3000);
			AReg.selectMotherTongue(MotherTongue);
			logger.info("Select mother tongue");
			AReg.selectDOB();
			logger.info("Enter date of birth");
			AReg.clickNextStepValidateOTP();
			logger.info("Click on validate OTP button");
			logger.info("Basic Details Is Completed");
//			------------ End Registration First Screen --------------------------- 
			
			

			} 
		catch (Exception e) 
			{
			 logger.info("Registration 1st screen (Basic Details) - Failed");
			 System.out.println(e);
			}
	}
	@Test(priority=2)
	public void Registration_OTP_Details() 
	{
		try {
			explicitWait("//*[@placeholder='Please enter OTP']");// Chk for OTP screen is appeared 
			abpwRegistrationPage AReg= new abpwRegistrationPage(driver);
			logger.info("------------ Landing on OTP screen ------------ ");
			String OTP1=getOTP_from_CRM_QA(Mobile_Number);
//			String[] otpPosition =otpNumberByNumber(OTP);		
//			AReg.setOTP1(otpPosition[0]);
//			AReg.setOTP2(otpPosition[1]);
//			AReg.setOTP3(otpPosition[2]);
//			AReg.setOTP4(otpPosition[3]);
//			AReg.setOTP5(otpPosition[4]);
//			AReg.setOTP6(otpPosition[5]);
			AReg.setOTP(OTP1);
			logger.info("Enter OTP");
			AReg.clickNextStepBasicDetails();
			logger.info("Click on validate OTP button");
			Thread.sleep(5000);
			} 
		catch (Exception e) 
			{
			logger.info("Registration OTP Validation - Failed");
			System.out.println(e);
			}
	}
	@Test(priority=3)
	public void Registration_BasicDetails_3rd_Screen() 
	{
		try 
			{
			abpwRegistrationPage AReg= new abpwRegistrationPage(driver);
			explicitWait("//*[contains(text(),'Profile Created By')]"); 	
			logger.info("------------ Landing on basic details screen ------------ ");
			AReg.selectProfileCreateBy(ProfileCreatedBy);
			logger.info("Select profile create by");			
			AReg.enterUserEmail(Email_ID);
			logger.info("Enter bride/groom email id");
			AReg.selectReligion(Religion);
			logger.info("Select religion");
			AReg.selectCaste(Caste);
			logger.info("Select caste");
			AReg.selectMaritalStatus(MaritalStatus);
			logger.info("Select marital status");
			AReg.setLocation(Location);
			logger.info("Select location");
			AReg.selectHeight(Height);
			logger.info("Select height");
			AReg.clickNextStepPhotoUpload();
			logger.info("Click on next step photo upload button");			
			}
	catch (Exception e) 
			{
			logger.info("3rd Screen Basic Details - Failed");
			System.out.println(e);
			}
	}
	@Test(priority=4)
	public void Registration_PhotoCropAndUpload() 
	{
		try 
			{
			explicitWait("//*[@id='new-register-flow-step-5-upload_photo-btn']");
			driver.findElement(By.xpath("//*[@id='new-register-flow-step-5-upload_photo-btn']")).click();
			logger.info("Click on Photo Upload button");
			Thread.sleep(10000);			
			robot_file_upload(image_path);
		    driver.findElement(By.xpath("//*[@id='new-register-flow-step-5-photo_upload-crop-savebtn']")).click();
		    logger.info("Select photo crop & save button");
		    Thread.sleep(3000);
		    scrollPage();
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("//*[@id='new-register-flow-step-5-photo_id_proof-btn-2']")).click();
		    logger.info("Click on next step photo id upload button");
		    explicitWait("//*[text()='Continue Anyway ']");
		    driver.findElement(By.xpath("//*[text()='Continue Anyway ']")).click();
			} 
		catch (Exception e) 
			{
			logger.info("4th Screen Profile Photo Upload - Failed");
			System.out.println(e);
			}
	}
	@Test(priority=5)
	public void Registration_PhotoId_Upload() throws InterruptedException, AWTException, IOException 
	{
		try 
			{
			explicitWait("//*[text()='Continue without verification']");
		    logger.info("------------ Landing on photo id screen ------------ ");
//		    driver.findElement(By.xpath("//*[text()='Upload Government ID']")).click();
		    Thread.sleep(2000);
//		    robot_file_upload(image_path);
//		    logger.info("Select photo id");
		    
		    driver.findElement(By.xpath("//*[text()='Continue without verification']")).click();
			} 
		catch (Exception e) 
			{
			logger.info("4th Screen Photo ID Upload - Failed");
			System.out.println(e);
			}
			
	}
	@Test(priority=6)
	public void getAWID_From_Home() 
	{
		try 
			{
			explicitWait("//*[@class='img-menu right-menu-icon-margin']");
			logger.info("------------ Landing on home screen ------------ ");
			driver.findElement(By.xpath("//*[@class='img-menu right-menu-icon-margin']")).click();
			String AWID=driver.findElement(By.xpath("//*[@class='circle-name']//span")).getText();			
			XLUtils.setCellData(path, "Profiles", 1, 1, AWID);
			logger.info("Create & Write In Excel Succesfully: "+AWID);
			//System.out.println("Create & Write In Excel Succesfully: "+AWID);
			logger.info("====================> End User Registration Script <===========================");
			deleteProfile();
			
			} 
		catch (Exception e) 
			{
			logger.info("Get AWID From Home Page - Failed");
			System.out.println(e);
			}
	}
	
	public void deleteProfile() throws InterruptedException, AWTException 
	{
		driver.navigate().to("https://testfiles.abpweddings.com/plan");
		driver.navigate().to("https://testfiles.abpweddings.com/deactivate-profile");
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//*[@type='radio' ]//following::span)[3]")).click();
		scrollPage();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//*[@class='row custom-toggle-row'])")).click();
		driver.findElement(By.xpath("//*[@id='new-register-flow-step-6-photoid_upload-yes-btn']")).click();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//*[@name='otp']")).click();
		String OTP_CRM= getOTP_from_CRM_QA(Mobile_Number);
		
		driver.findElement(By.xpath("//*[@name='otp']")).sendKeys(OTP_CRM);
		driver.findElement(By.xpath("//*[@class='btn btn-registration-primary-deactivate bd-confirm-submit-btn bd-submit-text-size']")).click();
		Thread.sleep(6000);
		
	}
	
	

}
