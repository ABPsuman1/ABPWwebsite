package abpw.testCases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import abpw.utilities.ReadConfig;


public class BaseClass {
	WebDriver driver;
	String Path=".//Drivers//geckodriver0.33.0WIN32.exe";
	ReadConfig  readconfig =new ReadConfig();
	String URL=readconfig.getURL();
	String DBurl=readconfig.getDBurl();
	String DBusername=readconfig.getDBusername();
	String DBpassword=readconfig.getDBpassword();
	public static Logger logger;
	
	public void browserSetUp() 
	{
		logger = Logger.getLogger("abpw");
		PropertyConfigurator.configure("Log4j.properties");
		
		System.setProperty("webdriver.gecko.driver","D:\\ABP Weddings\\drivers\\geckodriver-v0.32.2-win32\\geckodriver.exe");	
		driver= new FirefoxDriver();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@SuppressWarnings("deprecation")
	@BeforeClass
	public void browserSetUp_new() 
	{
		logger = Logger.getLogger("abpw");
		PropertyConfigurator.configure("Log4j.properties");
		
		System.setProperty("webdriver.gecko.driver",Path);	
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);	
		driver= new FirefoxDriver(capabilities);
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@AfterClass
	public void tearDown() 
	{
		//driver.quit();
		System.out.println("Browser Closed");
	}
	
	public String getOTP(String searchkey) throws InterruptedException, AWTException 
	{
		
		//--------- new tab open ------------------------
		Robot robot = new Robot();                          
		robot.keyPress(KeyEvent.VK_CONTROL); 
		robot.keyPress(KeyEvent.VK_T); 
		robot.keyRelease(KeyEvent.VK_CONTROL); 
		robot.keyRelease(KeyEvent.VK_T);
		//--------- end new tab open --------------------
		//--------- find all tabs with in array ---------
		 ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		 driver.switchTo().window(tabs2.get(1));
		 //		--------- end find all tabs with in array -----	    
		 //		--------- Start getting otp from DB ---------
		driver.get(DBurl);
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys(DBusername);
		driver.findElement(By.name("auth[password]")).clear();
		driver.findElement(By.name("auth[password]")).sendKeys(DBpassword);
		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();		 
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("(//*[contains(text(),'Search')])[1]")).click();
//			driver.findElement(By.name("where[0][col]")).click();
//			new Select(driver.findElement(By.name("where[0][col]"))).selectByVisibleText("contactNumber");
		driver.findElement(By.name("where[0][val]")).sendKeys(searchkey);
		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
		
		String otp = driver.findElement(By.xpath("//td[11]")).getText();
		driver.close();
		driver.switchTo().window(tabs2.get(0)); //---------> Switch to base tab
		System.out.println("OTP Is:"+otp);
		return otp;
	}
	
	public String getOTP_from_CRM_QA(String Mobile_Number) throws InterruptedException, AWTException 
	{
		//--------- new tab open ------------------------
				Robot robot = new Robot();                          
				robot.keyPress(KeyEvent.VK_CONTROL); 
				robot.keyPress(KeyEvent.VK_T); 
				robot.keyRelease(KeyEvent.VK_CONTROL); 
				robot.keyRelease(KeyEvent.VK_T);
		//--------- end new tab open --------------------
		//--------- find all tabs with in array ---------
				 ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
				 driver.switchTo().window(tabs2.get(1));
				 
				Thread.sleep(3000);
				driver.get("https://crmqa.abpweddings.com");
				driver.findElement(By.xpath("//*[@id='inputEmail4']")).sendKeys("test.testcrmmgr@yopmail.com");
				driver.findElement(By.xpath("//*[@id='Password']")).sendKeys("cic123");	
				driver.findElement(By.xpath("//*[@type='submit']")).click();				
//				--- Get AWID ---------------
				Thread.sleep(3000);
				driver.findElement(By.xpath("(//*[@aria-label='Search'])[1]")).click();
				driver.findElement(By.xpath("(//*[@aria-label='Search'])[1]")).sendKeys("9932785146");
				driver.findElement(By.xpath("//*[@id='button-addon2']")).click();
				Thread.sleep(6000);
				String AWID =driver.findElement(By.xpath("//td//a")).getText();					
				Thread.sleep(3000);
				driver.findElement(By.xpath("(//span[@class='icon'])[2]")).click();				
				driver.findElement(By.xpath("//span[contains(text(),'Get Otp')]")).click();
				driver.findElement(By.xpath("//*[@id='exampleFormControlTextarea1']")).click();
				driver.findElement(By.xpath("//*[@id='exampleFormControlTextarea1']")).sendKeys(AWID);
				driver.findElement(By.xpath("(//button)[5]")).click();
				
//				--- Get OTP ------------
				String OTP_FROM_CRM = driver.findElement(By.xpath("//tbody//tr/td[2]")).getText();
				driver.findElement(By.xpath("//*[text()='Logout']")).click();
				
				driver.close();
				driver.switchTo().window(tabs2.get(0)); //---------> Switch to base tab
				System.out.println("OTP Is:"+OTP_FROM_CRM);
				
				return OTP_FROM_CRM;
	}
	
	 public static String[] otpNumberByNumber(String getOTP) 
	 {
		 
		 String[] otpPositionGenerater = getOTP.split("(?<=.)");
		 
		 return otpPositionGenerater;
		 
	 }
	 
	 public void robot_file_upload(String FilePath) throws AWTException, InterruptedException
	 {
		// file path passed as parameter to StringSelection
	     // StringSelection s = new StringSelection("D:\\ABP Weddings\\male.jpg");
		 StringSelection s= new StringSelection(FilePath);
	      logger.info("Select photo path");
	      // Clipboard copy
	      Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s,null);
		// Robot object creation
	      Robot r = new Robot();
	      r.delay(250);
	      //pressing enter
	      r.keyPress(KeyEvent.VK_ENTER);
	      //releasing enter
	      r.keyRelease(KeyEvent.VK_ENTER);
	      //pressing ctrl+v
	      r.keyPress(KeyEvent.VK_CONTROL);
	      r.keyPress(KeyEvent.VK_V);
	      //releasing ctrl+v
	      r.keyRelease(KeyEvent.VK_CONTROL);
	      r.keyRelease(KeyEvent.VK_V);
	      //pressing enter
	      r.delay(2500);
	      r.keyPress(KeyEvent.VK_ENTER);
	      //releasing enter
	      r.keyRelease(KeyEvent.VK_ENTER);
	      Thread.sleep(3000);
	      logger.info("Select photo");
	     
	 }
	 public void browserZoomInOut() throws AWTException
	 {
		 Robot robot = new Robot();
//		 This code causes the zoom level to decrease:
		 robot.keyPress(KeyEvent.VK_CONTROL);
		 robot.keyPress(KeyEvent.VK_MINUS);
		 robot.keyRelease(KeyEvent.VK_CONTROL);
		 robot.keyRelease(KeyEvent.VK_MINUS);
//		 This code causes the zoom level to increase:
//		 robot.keyPress(KeyEvent.VK_CONTROL);
//		 robot.keyPress(KeyEvent.VK_EQUALS);
//		 robot.keyRelease(KeyEvent.VK_CONTROL);
//		 robot.keyRelease(KeyEvent.VK_EQUALS);
	 }
	 public void browserZoomOut() throws AWTException
	 {
		 Robot robot = new Robot();

//		 This code causes the zoom level to increase:
		 robot.keyPress(KeyEvent.VK_CONTROL);
		 robot.keyPress(KeyEvent.VK_EQUALS);
		 robot.keyRelease(KeyEvent.VK_CONTROL);
		 robot.keyRelease(KeyEvent.VK_EQUALS);
	 }
	 public void explicitWait(String Located)
	 {
		 WebDriverWait wait = new WebDriverWait(driver, 60);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Located)));
		 System.out.println("Wait is completed");
	 }
	 
	 public void setIframeForPlanBuy() throws InterruptedException 
	 {
		 Thread.sleep(10000);
		 int size = driver.findElements(By.tagName("iframe")).size();
		 System.out.println("Total Frame: "+size);
		 int updateFrameSize=size-1;
		 //driver.switchTo().frame(frame_no);
		 driver.switchTo().frame(updateFrameSize);
	 }
	 public void closeIframe() 
	 {
		 driver.switchTo().defaultContent(); 
	 }
	 public void scrollPage()
	    {
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,250)", "");
	    }
}
