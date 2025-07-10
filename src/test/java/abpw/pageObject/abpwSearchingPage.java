package abpw.pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class abpwSearchingPage 
	{
	WebDriver ldriver;
	public abpwSearchingPage(WebDriver rdriver)
		{
			ldriver=rdriver;
			PageFactory.initElements((WebDriver) rdriver, this);
		}
	
	@FindBy(xpath = "((//ul[li])[1]//following::li)[2]")
	@CacheLookup
	WebElement menuBtnSearch;
	
	public void clickOnSearchMenu() 
	{
	menuBtnSearch.click();
	}
	
//	======== Start Search By ID ==========================================
	@FindBy(xpath = "//input[@type='search']")
	@CacheLookup
	WebElement txtSearchById;
	
	@FindBy(xpath = "//*[@class='go-btn search_click']")
	@CacheLookup
	WebElement iconSearch;
	
	public void enterAWID(String AWID) 
	{
	txtSearchById.clear();
	txtSearchById.sendKeys(AWID);
	}
	
	public void clickOnSearchIcon() 
	{
	iconSearch.click();
	}
//	======== End Search By ID =============================================
//	======== Start Search Result ==========================================
	@FindBy(xpath = "(//div[@class='row'])[6]")
	@CacheLookup
	WebElement btnSearchResultCard;
	
	public void clickOnSearchResultCard() 
	{
	btnSearchResultCard.click();
	}
//	======== End Search Result ==========================================
	
//	======== Start Basic Search =========================================
	@FindBy(xpath = "//*[contains(text(),'Age from')]//following::div[5]")
	@CacheLookup
	WebElement ddAgeFrom;
	
	@FindBy(xpath = "//*[contains(text(),'Age from')]//following::input[1]")
	@CacheLookup
	WebElement txtAgeFrom;
	
	@FindBy(xpath = "//*[contains(text(),'Age to')]//following::div[5]")
	@CacheLookup
	WebElement ddAgeTo;
	
	@FindBy(xpath = "//*[contains(text(),'Age to')]//following::input[1]")
	@CacheLookup
	WebElement txtAgeTo;
	
	@FindBy(xpath = "//*[contains(text(),'Religion')]//following::div[5]")
	@CacheLookup
	WebElement ddReligion;
	
	@FindBy(xpath = "//*[contains(text(),'Religion')]//following::input[1]")
	@CacheLookup
	WebElement txtReligion;
	
	@FindBy(xpath = "//*[contains(text(),'Marital Status')]//following::div[5]")
	@CacheLookup
	WebElement ddMaritalStatus;
	
	@FindBy(xpath = "//*[contains(text(),'Marital Status')]//following::input[1]")
	@CacheLookup
	WebElement txtMaritalStatus;
	
	@FindBy(xpath = "//*[contains(text(),'Mother Tongue')]//following::div[5]")
	@CacheLookup
	WebElement ddMotherTongue;
	
	@FindBy(xpath = "//*[contains(text(),'Mother Tongue')]//following::input[1]")
	@CacheLookup
	WebElement txtMotherTongue;
	
	@FindBy(xpath = "//*[contains(text(),'Location')]//following::div[5]")
	@CacheLookup
	WebElement ddLocation;
	
	@FindBy(xpath = "//*[contains(text(),'Location')]//following::input[1]")
	@CacheLookup
	WebElement txtLocation;
	
	public void selectAgeFrom(String AgeFrom) throws InterruptedException 
	{
		ddAgeFrom.click();
		Thread.sleep(2000);
		txtAgeFrom.sendKeys(AgeFrom);
		txtAgeFrom.sendKeys(Keys.ENTER);
	}
	
	public void selectAgeTo(String AgeTo) throws InterruptedException 
	{
		ddAgeTo.click();
		Thread.sleep(2000);
		txtAgeTo.sendKeys(AgeTo);
		txtAgeTo.sendKeys(Keys.ENTER);
	}
	
	public void selectReligion(String Religion) throws InterruptedException 
	{
		ddReligion.click();
		Thread.sleep(2000);
		txtReligion.sendKeys(Religion);
		txtReligion.sendKeys(Keys.ENTER);
	}
	
	public void selectMaritalStatus(String MaritalStatus) throws InterruptedException 
	{
		ddMaritalStatus.click();
		Thread.sleep(2000);
		txtMaritalStatus.sendKeys(MaritalStatus);
		txtMaritalStatus.sendKeys(Keys.ENTER);
	}
	
	public void selectMotherTongue(String MotherTongue) throws InterruptedException 
	{
		ddMotherTongue.click();
		Thread.sleep(2000);
		txtMotherTongue.sendKeys(MotherTongue);
		txtMotherTongue.sendKeys(Keys.ENTER);
	}
	
	public void selectLocation(String Location) throws InterruptedException 
	{
		ddLocation.click();
		Thread.sleep(2000);
		txtLocation.sendKeys(Location);
		txtLocation.sendKeys(Keys.ENTER);
	}
	
//	======== End Basic Search ===========================================
// =============== Search button =======================================
	
	@FindBy(xpath = "//button[@role='button']")
	@CacheLookup
	WebElement btnSearch;
	
	public void clickOnSearchButton() 
	{
		btnSearch.click();
	}
// =============== End search button ===================================
	
	
	}
