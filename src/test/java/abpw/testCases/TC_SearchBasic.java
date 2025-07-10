package abpw.testCases;
import org.testng.annotations.Test;

import abpw.pageObject.abpwLandingPage;
import abpw.pageObject.abpwLoginPage;
import abpw.pageObject.abpwSearchingPage;

public class TC_SearchBasic extends BaseClass
	{
	String uName="AW43003587";
	String uPass="password";
	
	@Test(priority=1)
	public void login() 
		{
			abpwLandingPage LANDING = new abpwLandingPage(driver);
			LANDING.clickOnLoginLink();
			LANDING.clickOnLoginWithPasswordRadioButton();
				
			abpwLoginPage userLogin = new abpwLoginPage(driver);
			userLogin.setEmailID(uName);
			userLogin.setPassword(uPass);
			userLogin.clickLoginNowButton();
			System.out.println("Login Successfully");
		}
	
	@Test(priority=2)
	public void view_basic_search() throws InterruptedException 
		{
			explicitWait("(//*[contains(text(),'Edit Profile')])[2]");
			abpwSearchingPage AWSP=new abpwSearchingPage(driver);
			AWSP.clickOnSearchMenu();
			Thread.sleep(5000);
			AWSP.selectAgeFrom("23");
			AWSP.selectAgeTo("30");
			AWSP.selectReligion("Hindu");
			AWSP.selectMaritalStatus("Never");
			AWSP.selectMotherTongue("Bengali");
			AWSP.selectLocation("Kolkata");
			AWSP.clickOnSearchButton();	
		}
	}
