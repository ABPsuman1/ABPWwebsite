package abpw.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class abpwViewProfilePage 
{
	WebDriver ldriver;
	public abpwViewProfilePage(WebDriver rdriver)
		{
			ldriver=rdriver;
			PageFactory.initElements(rdriver, this);
		}
	
	@FindBy(xpath = "//*[@class='sendrequestbtn']")
	@CacheLookup
	WebElement btn_SendPhotoRequest;
	
	@FindBy(xpath = "//ul[@class='new-profile-details-modalicon-section ul-flex']//li[1]")
	@CacheLookup
	WebElement btn_InterestRequest;
	
	@FindBy(xpath = "//ul[@class='new-profile-details-modalicon-section ul-flex']//li[2]")
	@CacheLookup
	WebElement btn_ContactRequest;
	
	@FindBy(xpath = "//ul[@class='new-profile-details-modalicon-section ul-flex']//li[3]")
	@CacheLookup
	WebElement btn_ChatRequest;
	
	@FindBy(xpath = "//*[@class='request-now ml-0 ']")
	@CacheLookup
	WebElement btn_AstrologyRequest;
	
	@FindBy(xpath = "//*[@class='ok_btn ']")
	@CacheLookup
	WebElement btn_AstrologyPopup_Confirmation;
	
	public void clickOn_SendPhotoRequest() throws InterruptedException 
	{
		Thread.sleep(2000);
		btn_SendPhotoRequest.click();
		System.out.println("Done: Photo Request");
	}
	
	public void clickOn_InterestRequest() throws InterruptedException 
	{
		Thread.sleep(3000);
		btn_InterestRequest.click();
		System.out.println("Done: Interest Request");
	}
	
	public void clickOn_ContactRequest() throws InterruptedException 
	{
		Thread.sleep(3000);
		btn_ContactRequest.click();
		System.out.println("Done: Contact Request");
	}
	
	public void clickOn_ChatRequest() throws InterruptedException 
	{
		Thread.sleep(3000);
		btn_ChatRequest.click();
		System.out.println("Done: Chat Request");
	}
	
	public void clickOn_AstrologyRequest() throws InterruptedException 
	{
		Thread.sleep(3000);
		btn_AstrologyRequest.click();
		System.out.println("Done: Astrology Request");
	}
	
	public void clickOn_AstrologyPopup_Confirmation() throws InterruptedException 
	{
		Thread.sleep(3000);
		btn_AstrologyPopup_Confirmation.click();
	}
}
