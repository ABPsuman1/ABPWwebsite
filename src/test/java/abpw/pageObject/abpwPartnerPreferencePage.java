package abpw.pageObject;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class abpwPartnerPreferencePage 
	{
	WebDriver ldriver;
	public abpwPartnerPreferencePage(WebDriver rdriver)
		{
			ldriver=rdriver;
			PageFactory.initElements((WebDriver) rdriver, this);
		}
	
	//-------------- Personal Information -----------------------------------
	
	@FindBy(xpath = "(//*[@class='personal-ifo-right'])[1]")
	@CacheLookup
	WebElement btnPlusPersonalInformation;
	
	@FindBy(xpath = "(//*[@class='img-fluid'])[3]")
	@CacheLookup
	WebElement iconAge;
	
	@FindBy(xpath = "(//*[contains(text(),'Age from')])//following::div[5]")
	@CacheLookup
	WebElement ddFromAge;
	
	@FindBy(xpath = "(//*[contains(text(),'Age from')])//following::input[1]")
	@CacheLookup
	WebElement txtFromAge;	
	
	@FindBy(xpath = "(//*[contains(text(),'Age to')])//following::div[5]")
	@CacheLookup
	WebElement ddToAge;
	
	@FindBy(xpath = "(//*[contains(text(),'Age to')])//following::input[1]")
	@CacheLookup
	WebElement txtToAge;
	
	@FindBy(xpath = "//button[text()='Submit']")
	@CacheLookup
	WebElement btnSaveAge;
	
	@FindBy(xpath = "(//*[@class='img-fluid'])[4]")
	@CacheLookup
	WebElement iconReligion;
	
	@FindBy(xpath = "(//*[contains(text(),'Religion')])[4]//following::div[3]")
	@CacheLookup
	WebElement ddReligion;
	
	@FindBy(xpath = "(//*[contains(text(),'Religion')])[4]//following::input[1]")
	@CacheLookup
	WebElement txtReligion;	
	
	@FindBy(xpath = "//button[text()='Submit']")
	@CacheLookup
	WebElement btnSaveReligion;
	
	@FindBy(xpath = "(//*[@class='img-fluid'])[5]")
	@CacheLookup
	WebElement iconMaritalStatus;
	
	@FindBy(xpath = "(//*[contains(text(),'Marital Status')])[4]//following::div[3]")
	@CacheLookup
	WebElement ddMaritalStatus;
	
	@FindBy(xpath = "(//*[contains(text(),'Marital Status')])[4]//following::input[1]")
	@CacheLookup
	WebElement txtMaritalStatus;	
	
	@FindBy(xpath = "//button[text()='Submit']")
	@CacheLookup
	WebElement btnSaveMaritalStatus;
	
	
	public void clickOnAgeIcon()
	{
		iconAge.click();
	}
	public void clickOnPersonalInformationPlusbutton()
	{
		btnPlusPersonalInformation.click();
	}
	public void setFromAge(String FromAge) throws InterruptedException
	{
		ddFromAge.click();
		Thread.sleep(2000);
		txtFromAge.sendKeys(FromAge);
		txtFromAge.sendKeys(Keys.ENTER);
	}
	
	public void setToAge(String ToAge) throws InterruptedException
	{
		ddToAge.click();
		Thread.sleep(2000);
		txtToAge.sendKeys(ToAge);
		txtToAge.sendKeys(Keys.ENTER);
	}
	
	public void saveAge() 
	{
		btnSaveAge.click();
	}
	public void clickOnReligionIcon() 
	{
		iconReligion.click();
	}
	public void setReligion(String Religion) throws InterruptedException 
	{
		Thread.sleep(2000);
		ddReligion.click();
		Thread.sleep(1000);
		txtReligion.sendKeys(Keys.BACK_SPACE);
		txtReligion.sendKeys(Religion);
		txtReligion.sendKeys(Keys.ENTER);
	}
	public void clickOnSaveReligion() 
	{
		btnSaveReligion.click();
	}
	public void clickOnMaritalStatusIcon() 
	{
		iconMaritalStatus.click();
	}
	public void setMaritalStatus(String MaritalStatus) throws InterruptedException 
	{
		Thread.sleep(2000);
		ddMaritalStatus.click();
		Thread.sleep(1000);
		txtMaritalStatus.sendKeys(Keys.BACK_SPACE);
		txtMaritalStatus.sendKeys(MaritalStatus);
		txtMaritalStatus.sendKeys(Keys.ENTER);
	}
	public void clickOnSaveMaritalStatus() 
	{
		btnSaveMaritalStatus.click();
	}
	
	//-------------- Personal Information -----------------------------------
	
		@FindBy(xpath = "(//*[@class='personal-ifo-right'])[2]")
		@CacheLookup
		WebElement btnPlusProfessionalEducationalInformation;
		
//		@FindBy(xpath = "")
//		@CacheLookup
//		WebElement iconAge;
//		
//		@FindBy(xpath = "")
//		@CacheLookup
//		WebElement ddFromAge;
//		
//		@FindBy(xpath = "")
//		@CacheLookup
//		WebElement ddToAge;
//		
//		@FindBy(xpath = "")
//		@CacheLookup
//		WebElement iconReligion;
	
	
	}
