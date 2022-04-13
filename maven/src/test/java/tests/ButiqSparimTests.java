package tests;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import tools.ButiqSparimFunctions;
import tools.ElementsTests;

import org.testng.annotations.BeforeMethod;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;

public class ButiqSparimTests extends ElementsTests {
	//test LikeButtons
	static public WebElement menuAlbumTmonot;
	static public List<WebElement>likebuttons;
	static public WebElement howManyLikes;
	static public WebElement albumDesgin;
	
  @BeforeMethod
  public void beforeMethod() throws InterruptedException {
	  
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
	  
	  //closepopUps
	  Thread.sleep(1500);
	  cookiePopUp=driver.findElement(By.xpath("//*[@id='Layer_1']"));
	  cookiePopUp.click();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }
  
  @Test
  public void checkingIfLikeButtonsAreWorking() throws InterruptedException {
	  ButiqSparimTests.clickOnMenuAlbumTmonotAndLinkAlbumDesign();
	  
	  ButiqSparimTests.scrollDownThePage8Times();
	  
	  ButiqSparimTests.clickingOnEveryLikeButtonOnBookDesignAndTakingTheAmountLikedBooks();
	  
	  ButiqSparimFunctions.checkingBotiqSparim(howManyLikes, likebuttons);
  }
  
  private static void clickOnMenuAlbumTmonotAndLinkAlbumDesign() throws InterruptedException {
	  menuAlbumTmonot=driver.findElement(By.xpath("//menu[@class='desktop-menu ']//button[@data-tab-title-id='801']"));
	  menuAlbumTmonot.click();
	  albumDesgin=driver.findElement(By.xpath("//ul[@data-tab-content-id='801']//li[contains(.,'עי')]"));
	  Thread.sleep(500);
	  albumDesgin.click();
  }
  
  private static void scrollDownThePage8Times() throws InterruptedException {
	  for (int i = 0; i < 8; i++) {	                                                   
		  js.executeScript("window.scrollBy(0,8000)", "");
		  Thread.sleep(2500); 
	  }
  }
  
  private static void clickingOnEveryLikeButtonOnBookDesignAndTakingTheAmountLikedBooks() {
	  likebuttons=driver.findElements(By.xpath("//section[@id='lupa_boutiq']//div[@class='heart' or @class='heart ']"));
	  for (int j = 0; j < likebuttons.size(); j++) {
		js.executeScript("arguments[0].click();", likebuttons.get(j));
	}
	  
	  howManyLikes=driver.findElement(By.id("number_of_likes"));
  }

}
