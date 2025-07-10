package abpw.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class apwPlanPage {
	
	WebDriver ldriver;
	public apwPlanPage(WebDriver rdriver)
		{
			ldriver=rdriver;
			PageFactory.initElements(rdriver, this);
		}
	
	@FindBy(xpath = "(//*[@href='/plan'])[1]")
	@CacheLookup
	WebElement linkPlanMenu;
	
	@FindBy(xpath = "//button[@class='plan-buy-now']")
	@CacheLookup
	WebElement btnBuyNow;
	
	@FindBy(xpath = "(//a[@class='payonlnebtn'])[1]")
	@CacheLookup
	WebElement btnPayOnlne;
	
	
	@FindBy(xpath = "//*[contains(text(),'UPI / QR')]")
	@CacheLookup
	WebElement btnUPI;
	
	@FindBy(xpath = "//div[@id='new-vpa-field-upi']")
	@CacheLookup
	WebElement btnUPI_id;
	
	@FindBy(id = "vpa-upi")
	@CacheLookup
	WebElement txtUPI_id;
	
	@FindBy(id = "redesign-v15-cta")
	@CacheLookup
	WebElement btnPaynow;
	
	
	public void ClickOnPlanMenu() 
		{
			linkPlanMenu.click();
		}
	public void ClickOnBuyNowButton() 
		{
			btnBuyNow.click();
		}
	public void ClickOnPayOnlineButton() 
		{
			btnPayOnlne.click();
		}
	public void Pay_online() throws InterruptedException 
	{
		btnUPI.click();
		btnUPI_id.click();
		Thread.sleep(1000);
		txtUPI_id.clear();
		txtUPI_id.sendKeys("success@razorpay");
		Thread.sleep(1000);
		btnPaynow.click();
		
	}
	
	
}
