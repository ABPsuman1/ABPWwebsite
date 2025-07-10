package abpw.testCases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Profile_Completion extends BaseClass
{
	
@Test(priority=1)
public void login() 
	{
	driver.findElement(By.xpath("//*[@id='landingPage_topbar_register']")).click();
	driver.findElement(By.xpath("//*[@id='landPage_login_IhavePasswd_radio']")).click();
	driver.findElement(By.xpath("//*[@class='input_email']")).sendKeys("AW61792437");
	driver.findElement(By.xpath("//*[@class='input_password']")).clear();
	driver.findElement(By.xpath("//*[@class='input_password']")).sendKeys("password");
	driver.findElement(By.xpath("//*[@id='landPage_login_loginWithPassword_loginNow']")).click();
	}
@Test(priority=2)
public void planPurchase() throws InterruptedException, AWTException
	{
	WebDriverWait wait= new WebDriverWait(driver,30);
	Thread.sleep(5000);
	driver.findElement(By.xpath("(//*[contains(text(),'Edit Profile')])[2]")).click();
	//============== edit edit-about-me ========================================	
	Thread.sleep(5000);
	driver.findElement(By.xpath("//a[@class='edit-about-me']")).click();
	driver.findElement(By.name("quetionsAnswer1")).clear();
	driver.findElement(By.name("quetionsAnswer1")).sendKeys("From Automation Script - People usually tell me I am, People usually tell me I am");
	driver.findElement(By.name("quetionsAnswer3")).clear();
	driver.findElement(By.name("quetionsAnswer3")).sendKeys("From Automation Script - The most interesting situation in my life was,The most interesting situation in my life was");
	driver.findElement(By.xpath("(//*[@class='btn btn-primary saveto_profile'])[2]")).click();
	zoomIn();
	zoomIn();
	zoomIn();
	zoomIn();
	zoomIn();
	
	//scrollByXpath(editPersonalInformation);
	//============== editPersonalInformation ========================================
	
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='edit-personal-information']")));
	Thread.sleep(5000);
	
	driver.findElement(By.xpath("//a[@class='edit-personal-information']")).click();
	
	driver.findElement(By.xpath("(//*[contains(text(),'Kids')])[2]//following::div[1]")).click();
	//driver.findElement(By.xpath("//*[text()='None']")).click();
	driver.findElement(By.id("react-select-7-input")).sendKeys("None");
	driver.findElement(By.id("react-select-7-input")).sendKeys(Keys.ENTER);
	driver.findElement(By.xpath("(//*[contains(text(),'Manglik')])[2]//following::div[1]")).click();
	//driver.findElement(By.xpath("//*[text()='No']")).click();
	driver.findElement(By.id("react-select-9-input")).sendKeys("No");
	driver.findElement(By.id("react-select-9-input")).sendKeys(Keys.ENTER);
	driver.findElement(By.xpath("(//*[@class='btn btn-primary saveto_profile'])[3]")).click();
	
	//============== editProfessional background ========================================
	
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='edit-professional-background']")));
	
	Thread.sleep(5000);
	driver.findElement(By.xpath("//a[@class='edit-professional-background']")).click();
	driver.findElement(By.xpath("(//*[contains(text(),'Occupation')])[2]//following::div[1]")).click();
	//driver.findElement(By.xpath("//*[text()='Salaried - Private']")).click();
	driver.findElement(By.id("react-select-11-input")).sendKeys("Salaried - Private");
	driver.findElement(By.id("react-select-11-input")).sendKeys(Keys.ENTER);
	driver.findElement(By.xpath("(//*[contains(text(),'Designation')])[2]//following::div[1]")).click();
	//driver.findElement(By.xpath("//*[text()='Banking Professional']")).click();
	driver.findElement(By.id("react-select-12-input")).sendKeys("Banking Professional");
	driver.findElement(By.id("react-select-12-input")).sendKeys(Keys.ENTER);
	driver.findElement(By.name("companyName")).clear();
	driver.findElement(By.name("companyName")).sendKeys("ABP");
	driver.findElement(By.xpath("(//*[contains(text(),'Industry')])[2]//following::div[1]")).click();
	//driver.findElement(By.xpath("//*[text()='Animation']")).click();
	driver.findElement(By.id("react-select-13-input")).sendKeys("Animation");
	driver.findElement(By.id("react-select-13-input")).sendKeys(Keys.ENTER);
	driver.findElement(By.xpath("(//*[contains(text(),'Income')])[2]//following::div[1]")).click();
	//driver.findElement(By.xpath("//*[text()='INR 2 Lacs - 4 Lacs']")).click();
	driver.findElement(By.id("react-select-14-input")).sendKeys("INR 2 Lacs - 4 Lacs");
	driver.findElement(By.id("react-select-14-input")).sendKeys(Keys.ENTER);
	driver.findElement(By.xpath("(//*[@class='btn saveto_profile btn-primary'])[1]")).click();
	
	//============== edit Educational background ========================================
	
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='edit-educational-background']")));
	
	 Thread.sleep(5000);
	driver.findElement(By.xpath("//a[@class='edit-educational-background']")).click();
	driver.findElement(By.xpath("(//*[contains(text(),'Highest education')])[2]//following::div[1]")).click();
	//driver.findElement(By.xpath("//*[text()='B.A']")).click();
	driver.findElement(By.id("react-select-15-input")).sendKeys("B.A");
	driver.findElement(By.id("react-select-15-input")).sendKeys(Keys.ENTER);
	driver.findElement(By.xpath("(//*[contains(text(),'Specialisation')])[2]//following::div[1]")).click();
	//driver.findElement(By.xpath("//*[text()='Agriculture']")).click();
	driver.findElement(By.id("react-select-16-input")).sendKeys("Agriculture");
	driver.findElement(By.id("react-select-16-input")).sendKeys(Keys.ENTER);
	driver.findElement(By.name("highestEduInstituteVal")).clear();
	driver.findElement(By.name("highestEduInstituteVal")).sendKeys("Test Institute");
	driver.findElement(By.name("schoolName")).clear();
	driver.findElement(By.name("schoolName")).sendKeys("Test School");
	driver.findElement(By.xpath("(//*[@class='btn saveto_profile btn-primary '])[1]")).click();
	
	//============== edit-physical-description ========================================
	
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='edit-physical-description']")));
	Thread.sleep(12000);
	
	driver.findElement(By.xpath("//a[@class='edit-physical-description']")).click();
	driver.findElement(By.xpath("(//*[contains(text(),'Body type')])[1]//following::div[1]")).click();
	//driver.findElement(By.xpath("//*[text()='Slim']")).click();
	driver.findElement(By.id("react-select-17-input")).sendKeys("Slim");
	driver.findElement(By.id("react-select-17-input")).sendKeys(Keys.ENTER);
	driver.findElement(By.xpath("(//*[contains(text(),'Height')])[3]//following::div[1]")).click();
	//driver.findElement(By.xpath("//*[text()='5.03']")).click();
	driver.findElement(By.id("react-select-18-input")).sendKeys("5.03");
	driver.findElement(By.id("react-select-18-input")).sendKeys(Keys.ENTER);
	driver.findElement(By.xpath("(//*[contains(text(),'Complexion')])[2]//following::div[1]")).click();
	//driver.findElement(By.xpath("//*[text()='Very Fair']")).click();
	driver.findElement(By.id("react-select-19-input")).sendKeys("Very Fair");
	driver.findElement(By.id("react-select-19-input")).sendKeys(Keys.ENTER);
	driver.findElement(By.xpath("(//*[contains(text(),'Blood Group')])[2]//following::div[1]")).click();
	//driver.findElement(By.xpath("//*[text()='A+']")).click();
	driver.findElement(By.id("react-select-20-input")).sendKeys("Very Fair");
	driver.findElement(By.id("react-select-20-input")).sendKeys(Keys.ENTER);
	driver.findElement(By.xpath("(//*[contains(text(),'Disabilities')])[2]//following::div[1]")).click();
	//driver.findElement(By.xpath("//*[text()='Physical Challenged']")).click();
	driver.findElement(By.id("react-select-21-input")).sendKeys("Physical Challenged");
	driver.findElement(By.id("react-select-21-input")).sendKeys(Keys.ENTER);
	driver.findElement(By.xpath("(//*[contains(text(),'Known Ailments')])[2]//following::div[1]")).click();
	//driver.findElement(By.xpath("//*[text()='No Health Problems']")).click();
	driver.findElement(By.id("react-select-22-input")).sendKeys("No Health Problems");
	driver.findElement(By.id("react-select-22-input")).sendKeys(Keys.ENTER);
	driver.findElement(By.xpath("(//*[@class='btn saveto_profile btn-primary '])[2]")).click();
	
	//============== edit-astrology-details ========================================
	
	
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='edit-astrology-details']")));
	
	Thread.sleep(5000);
	driver.findElement(By.xpath("//a[@class='edit-astrology-details']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//*[contains(text(),'Place of birth')])[2]//following::div[1]")).click();
	Thread.sleep(2000);
	driver.findElement(By.id("react-select-23-input")).sendKeys("Kolka");
	Thread.sleep(2000);
	driver.findElement(By.id("react-select-23-input")).sendKeys(Keys.ENTER);
	driver.findElement(By.xpath("((//*[contains(text(),'Time of birth')])[2]//following::div[1]//following::div[1])[1]")).click();
	Thread.sleep(2000);
	driver.findElement(By.id("react-select-24-input")).sendKeys(Keys.ENTER);
	driver.findElement(By.xpath("(//*[contains(text(),'Nakshatra')])[2]//following::div[1]")).click();
	//driver.findElement(By.xpath("//*[text()='Anuradha']")).click();
	driver.findElement(By.id("react-select-28-input")).sendKeys("Anuradha");
	driver.findElement(By.id("react-select-28-input")).sendKeys(Keys.ENTER);
	driver.findElement(By.xpath("(//*[contains(text(),'Gothram')])[2]//following::div[1]")).click();
	//driver.findElement(By.xpath("//*[text()='Aatreya']")).click();
	driver.findElement(By.id("react-select-29-input")).sendKeys("Aatreya");
	driver.findElement(By.id("react-select-29-input")).sendKeys(Keys.ENTER);
	driver.findElement(By.xpath("(//*[contains(text(),'Zodiac')])[2]//following::div[1]")).click();
	//driver.findElement(By.xpath("//*[text()='Aries']")).click();
	driver.findElement(By.id("react-select-30-input")).sendKeys("Aries");
	driver.findElement(By.id("react-select-30-input")).sendKeys(Keys.ENTER);
	driver.findElement(By.xpath("(//*[contains(text(),'Rashi')])[2]//following::div[1]")).click();
	//driver.findElement(By.xpath("//*[text()='Mesh']")).click();
	driver.findElement(By.id("react-select-31-input")).sendKeys("Mesh");
	driver.findElement(By.id("react-select-31-input")).sendKeys(Keys.ENTER);
	driver.findElement(By.xpath("(//*[@class='btn saveto_profile btn-primary'])[2]")).click();
	Thread.sleep(12000);
	 ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
      //switch to new tab
      driver.switchTo().window(newTb.get(1));
	driver.close();
	driver.switchTo().window(newTb.get(0));
	
	//============== edit-lifestyle-preference ========================================
	
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='edit-lifestyle-preference']")));
	
	Thread.sleep(12000);
	
	driver.findElement(By.xpath("//a[@class='edit-lifestyle-preference']")).click();
	driver.findElement(By.xpath("(//*[contains(text(),'Smoking')])[2]//following::div[1]")).click();
	//driver.findElement(By.id("react-select-32-option-1")).click();
	driver.findElement(By.id("react-select-32-input")).sendKeys("Socially");
	driver.findElement(By.id("react-select-32-input")).sendKeys(Keys.ENTER);
	driver.findElement(By.xpath("(//*[contains(text(),'Drinking')])[2]//following::div[1]")).click();
	//driver.findElement(By.xpath("//*[text()='Not at all']")).click();
	driver.findElement(By.id("react-select-33-input")).sendKeys("Not at all");
	driver.findElement(By.id("react-select-33-input")).sendKeys(Keys.ENTER);
	driver.findElement(By.xpath("(//*[contains(text(),'Food Habits')])[2]//following::div[1]")).click();
	//driver.findElement(By.xpath("//*[text()='Vegetarian']")).click();
	driver.findElement(By.id("react-select-34-input")).sendKeys("Food Habits");
	driver.findElement(By.id("react-select-34-input")).sendKeys(Keys.ENTER);
	driver.findElement(By.xpath("(//*[contains(text(),'House Living in')])[2]//following::div[1]")).click();
	//driver.findElement(By.xpath("//*[text()='Self-Owned House']")).click();
	driver.findElement(By.id("react-select-35-input")).sendKeys("Self-Owned House");
	driver.findElement(By.id("react-select-35-input")).sendKeys(Keys.ENTER);
	driver.findElement(By.xpath("(//*[contains(text(),'Want kids')])[2]//following::div[1]")).click();
	//driver.findElement(By.xpath("//*[text()='Yes, want some day']")).click();
	driver.findElement(By.id("react-select-36-input")).sendKeys("Yes, want some day");
	driver.findElement(By.id("react-select-36-input")).sendKeys(Keys.ENTER);
	driver.findElement(By.xpath("((//*[contains(text(),'Vehicles Owned')])[1]//following::div[1]//following::div[2])[1]")).click();
	//driver.findElement(By.xpath("//*[text()='2 Wheeler']")).click();
	driver.findElement(By.id("react-select-37-input")).sendKeys("2 Wheeler");
	driver.findElement(By.id("react-select-37-input")).sendKeys(Keys.ENTER);
	driver.findElement(By.xpath("((//*[contains(text(),'Vehicles Owned')])[1]//following::div[1]//following::div[2])[5]")).click();
	//driver.findElement(By.xpath("//*[text()='2']")).click();
	driver.findElement(By.id("react-select-38-input")).sendKeys("2");
	driver.findElement(By.id("react-select-38-input")).sendKeys(Keys.ENTER);
	driver.findElement(By.xpath("(//*[contains(text(),'Pets')])[2]//following::div[1]")).click();
	//driver.findElement(By.xpath("//*[text()='Like']")).click();
	driver.findElement(By.id("react-select-39-input")).sendKeys("Like");
	driver.findElement(By.id("react-select-39-input")).sendKeys(Keys.ENTER);
	driver.findElement(By.xpath("(//*[@class='btn saveto_profile btn-primary '])[3]")).click();
	//============== edit-hobbies ========================================
	
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='edit-hobbies']")));
	
	Thread.sleep(12000);
	
	driver.findElement(By.xpath("//a[@class='edit-hobbies']")).click();
	driver.findElement(By.xpath("//input[@value='100002987']")).click();
	driver.findElement(By.xpath("//input[@value='100002988']")).click();
	driver.findElement(By.xpath("//input[@value='100002989']")).click();
	driver.findElement(By.xpath("(//*[@class='btn saveto_profile btn-primary'])[3]")).click();
	}
 public void zoomIn() throws AWTException
 {
	 Robot robot = new Robot();
//	 This code causes the zoom level to decrease:
	 robot.keyPress(KeyEvent.VK_CONTROL);
	 robot.keyPress(KeyEvent.VK_MINUS);
	 robot.keyRelease(KeyEvent.VK_CONTROL);
	 robot.keyRelease(KeyEvent.VK_MINUS);
 }
}



