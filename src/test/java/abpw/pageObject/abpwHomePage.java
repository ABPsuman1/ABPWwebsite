package abpw.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class abpwHomePage 
{
	WebDriver ldriver;
	public abpwHomePage(WebDriver rdriver)
		{
			ldriver=rdriver;
			PageFactory.initElements((WebDriver) rdriver, this);
		}
	@FindBy(xpath = "(//*[@href='/my-home'])[1]")
	@CacheLookup
	WebElement LinkHome;
	
	@FindBy(xpath = "(//*[@href='/my-matches'])[1]")
	@CacheLookup
	WebElement LinkMyMatches;
	
	@FindBy(xpath = "(//*[@href='/basic-search'])[1]")
	@CacheLookup
	WebElement LinkSearch;
	
	@FindBy(xpath = "(//*[@href='/message'])[1]")
	@CacheLookup
	WebElement LinkChat;
	
	@FindBy(xpath = "(//*[@href='/plan'])[1]")
	@CacheLookup
	WebElement LinkSubscription;
	
	@FindBy(xpath = "//*[@class='img-menu right-menu-icon-margin']")
	@CacheLookup
	WebElement btnMenu;
	
	@FindBy(xpath = "(//*[@href='/edit-profile?page=preference'])[1]")
	@CacheLookup
	WebElement btnMenuLink_PartnerPreference;
	
	public void clickOnHomeLink() 
	{
		LinkHome.click();
	}
	public void clickOnMyMatchesLink() 
	{
		LinkMyMatches.click();
	}
	public void clickOnMySearchLink() 
	{
		LinkSearch.click();
	}
	public void clickOnChatLink() 
	{
		LinkChat.click();
	}
	public void clickOnSubscriptionLink() 
	{
		LinkSubscription.click();
	}
	public void clickOnMenu() 
	{
		btnMenu.click();
	}
	public void clickOnMenu_PartnerPreference() 
	{
		btnMenuLink_PartnerPreference.click();
	}
	
}
