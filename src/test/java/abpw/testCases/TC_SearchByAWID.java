package abpw.testCases;

import org.testng.annotations.Test;

import abpw.pageObject.abpwLandingPage;
import abpw.pageObject.abpwLoginPage;
import abpw.pageObject.abpwSearchingPage;

public class TC_SearchByAWID extends BaseClass
	{
	String uName="AW43003587";
	String uPass="password";
	String TargetUserID="AW95570117";
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
	public void search_by_id() 
		{
			explicitWait("(//*[contains(text(),'Edit Profile')])[2]");
			abpwSearchingPage AWSP=new abpwSearchingPage(driver);
			AWSP.clickOnSearchMenu();
			AWSP.enterAWID(TargetUserID);
			AWSP.clickOnSearchIcon();
		}
	}
