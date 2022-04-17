package tests;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import tools.ElementsThatAllTestsHave;
import tools.EditStyleOfPicsFunctions;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class EditStyleOfPicsTests extends ElementsThatAllTestsHave{
	//elements edit pics
	static public WebElement howDoUDoLupa;
	static public WebElement online;
	static public WebElement toUploadButton;
     static public WebElement pickPics;
	static public WebElement hipstory;
	static public List <WebElement> showAll;
	static public  ArrayList<String> tabs1;
	static public WebElement harzlPic;
	static public WebElement mosahPic;
	static public WebElement next;
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
 //@Parameters ("browser")
  @BeforeMethod
  public static void beforeTest() throws InterruptedException {
	 String browser="chrome";
	 
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
  
  ///cookie pop up
  Thread.sleep(1500);
  cookiePopUp=driver.findElement(By.xpath("//*[@id='Layer_1']"));
  cookiePopUp.click();
  }

  @AfterMethod
  public void afterTest()  {
 // driver.quit();
  }



  @Test(priority = 6)
  static public void editPics() throws InterruptedException {
	  howDoUDoLupa=driver.findElement(By.xpath("//button[@data-tab-title-id='810']"));
	  howDoUDoLupa.click();
	  online=driver.findElement(By.xpath("//ul[@data-tab-content-id='810']//img[@alt='לופה באון ליין']"));
	  js.executeScript("arguments[0].click();", online);
	  Thread.sleep(1000);
	  toUploadButton=driver.findElement(By.xpath("//div[@class='page-header__content aos-init aos-animate']//div[@data-aos]//a"));
	  toUploadButton.click();
	  tabs1=new ArrayList<String>(driver.getWindowHandles());
	  driver.switchTo().window(tabs1.get(1));

  }


  

  
}
