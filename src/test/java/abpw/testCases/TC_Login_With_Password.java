package abpw.testCases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import abpw.pageObject.abpwLandingPage;
import abpw.pageObject.abpwLoginPage;
import abpw.utilities.XLUtils;

public class TC_Login_With_Password extends BaseClass{
	String path=System.getProperty("user.dir")+"/src/test/java/abpw/testData/abpwDataSet.xlsx";
	//String uName="AW61792437";
	String uName;
	String uPass="password";
	
	@BeforeTest
	public void Read_Excel_From_Profiles_Sheet() throws IOException 
	{
		uName=XLUtils.getCellData(path, "Profiles", 1, 1);
	}
	
	@Test
	public void login_with_password() 
	{
		abpwLandingPage LANDING = new abpwLandingPage(driver);
		LANDING.clickOnLoginLink();
		LANDING.clickOnLoginWithPasswordRadioButton();
		
		abpwLoginPage userLogin = new abpwLoginPage(driver);		
		userLogin.setEmailID(uName);
		userLogin.setPassword(uPass);
		userLogin.clickLoginNowButton();
	}

}
