package tests;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.netty.util.Timeout;
import tools.ElementsThatAllTestsHave;
import tools.E2EFunctions;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class E2ETests extends ElementsThatAllTestsHave{
	//elements edit pics
	static public WebElement howDoUDoLupa;
	static public WebElement online;
	static public WebElement toUploadButton;
    static public WebElement NameOfBookTextBox;
	static public WebElement continueButton;
	static public WebElement checkBox;
	static public WebElement acceptButton;
	static public WebElement uploadPicsFromComputer;
	
	static public List <WebElement> showAll;
	static public  ArrayList<String> tabs1;
	
	static public WebElement mosahPic;
	
	static public WebElement editHarzlPic;
	static public WebElement editMosahPic;
	static public WebElement blackFrameHarzl;
	static public WebElement saveHarzlPic;
    static public WebElement typeOfDesign;
	static public String harzlDesign;
	static public WebElement kapaDesign;
	static public WebElement typeOfdesign;
    static public WebElement saveMosahPic;
    static public String mosahDesign;
 @Parameters ("browser")
  @BeforeMethod
  public static void beforeTest(String browser) throws InterruptedException {
	 //String browser="Edge";
	 
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			  driver=new ChromeDriver();
		}
		else if (browser.equals("Edge")) {
			WebDriverManager.edgedriver().setup();
			  driver=new EdgeDriver();
		}

	  

  driver.manage().window().maximize();
  driver.get("https://www.lupa.co.il/");
  js=(JavascriptExecutor) driver;
  //closepopUps
  Thread.sleep(1500);
  cookiePopUp=driver.findElement(By.id("XMLID_54_"));
  cookiePopUp.click();
  driver.findElement(By.xpath("//div[@class='element-shape closeLightboxButton adoric_element']")).click();	  
  }

  @AfterMethod
  public void afterTest()  {
  driver.quit();
  }



  @Test(priority = 6)
  static public void editPics() throws InterruptedException {
	  //navigate to design album on the website 
	  howDoUDoLupa=driver.findElement(By.xpath("//button[@data-tab-title-id='810']"));
	  howDoUDoLupa.click();
	  online=driver.findElement(By.xpath("//ul[@data-tab-content-id='810']//img[@alt='לופה באון ליין']"));
	  js.executeScript("arguments[0].click();", online);
	  Thread.sleep(1000);
	  toUploadButton=driver.findElement(By.xpath("//div[@class='page-header__content aos-init aos-animate']//div[@data-aos]//a"));
	  toUploadButton.click();
	  //switchTabsAndPickAlbumName
	  tabs1=new ArrayList<String>(driver.getWindowHandles());
	  driver.switchTo().window(tabs1.get(1));
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  NameOfBookTextBox=driver.findElement(By.id("mat-input-1"));
	  continueButton=driver.findElement(By.xpath("//button[@type='submit']//span[contains(.,'המשיכו')]"));
	  NameOfBookTextBox.sendKeys("nice name of a book");
	  continueButton.click();
	  //accept the Standardization
	  checkBox=driver.findElement(By.id("mat-checkbox-1-input"));
	  acceptButton=driver.findElement(By.xpath("//button//span[contains(.,'לאישור')]"));
	  js.executeScript("arguments[0].click();", checkBox);
	  acceptButton.click();
	  
	  uploadPicsFromComputer=driver.findElement(By.xpath("//mat-card//label//img"));
	  js.executeScript("arguments[0].click();",uploadPicsFromComputer);
	  
	  

  }


  

  
}
