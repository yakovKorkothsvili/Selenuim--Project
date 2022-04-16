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
 @Parameters ("browser")
  @BeforeMethod
  public static void beforeTest(String browser) throws InterruptedException {
	// String browser="chrome";
	 
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
  driver.quit();
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
	  pickPics=driver.findElement(By.id("lupaSelectBtn"));
	  js.executeScript("arguments[0].click();", pickPics);
	  hipstory=driver.findElement(By.xpath("//div[@id='divIDGallery']//div[@class='btnSource']"));
	  js.executeScript("arguments[0].click();", hipstory);
	  Thread.sleep(1000);
	  showAll=driver.findElements(By.xpath("//div[@class='txtCategoryDesign']"));
	  js.executeScript("arguments[0].click();", showAll.get(0));
	  harzlPic=driver.findElement(By.id("img967"));
	  mosahPic=driver.findElement(By.id("img959"));
	  next=driver.findElement(By.xpath("//div[@id='page_gallery_category']//input"));
	  js.executeScript("arguments[0].click();",harzlPic);
	  Thread.sleep(500);
	  js.executeScript("arguments[0].click();",mosahPic);
	  Thread.sleep(500);
	  js.executeScript("arguments[0].click();",next);
	  editHarzlPic=driver.findElement(By.xpath("//div[@id='divEditDeleteSummaryimg967']//div[@class='divEditSummary']"));
	  js.executeScript("arguments[0].click();",editHarzlPic);
	  blackFrameHarzl=driver.findElement(By.id("imgBlackFrame"));
	  js.executeScript("arguments[0].click();",blackFrameHarzl);
	  saveHarzlPic=driver.findElement(By.xpath("//div[@id='allImagesSizeIdKappaPas']//input[@type='button']"));
	  typeOfDesign=driver.findElement(By.id("divImgOptionMain"));
	  harzlDesign=typeOfDesign.getAttribute("class");
	  js.executeScript("arguments[0].click();",saveHarzlPic);
	  editMosahPic=driver.findElement(By.xpath("//div[@id='divEditDeleteSummaryimg959']//div[@class='divEditSummary']"));
	  js.executeScript("arguments[0].click();",editMosahPic);
	  kapaDesign=driver.findElement(By.id("imgColor"));
	  saveMosahPic=driver.findElement(By.xpath("//div[@id='allImagesSizeIdKappaPas']//input[@type='button']"));
	  typeOfdesign=driver.findElement(By.id("divImgOptionMain"));
	  js.executeScript("arguments[0].click();",kapaDesign);
	  mosahDesign=typeOfdesign.getAttribute("style");
	  js.executeScript("arguments[0].click();",saveMosahPic);
	  EditStyleOfPicsFunctions.designCheck(harzlDesign, mosahDesign);
  }


  

  
}
