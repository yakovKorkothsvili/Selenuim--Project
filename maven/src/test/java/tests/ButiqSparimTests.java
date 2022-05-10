package tests;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import tools.ButiqSparimFunctions;
import tools.ElementsThatAllTestsHave;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;

public class ButiqSparimTests extends ElementsThatAllTestsHave {
	//test LikeButtons
	static  WebElement menuAlbumTmonot;
	static  List<WebElement>likebuttons;
	static  WebElement howManyLikes;
	static  WebElement albumDesgin;
	//test rightAmuontOfBooksInEachCategory
	static  int []amountOfBooks;
	static  WebElement noshimButton;
	static  List <WebElement> categories;
	static  WebElement allBooks;
	static  ArrayList<String>nameOfCategory;
	
  @Parameters ("browser")
  @BeforeMethod
  public void beforeMethod(String browser) throws InterruptedException {
	  
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
	  
	  //closepopUps
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  cookiePopUp=driver.findElement(By.xpath("//*[@id='Layer_1']"));
	  cookiePopUp.click();
  }

  @AfterMethod
  public void afterMethod() {
	 // driver.quit();
  }
  
  @Test(priority = 1)
  public void checkingIfLikeButtonsAreWorking() throws InterruptedException {
	  ButiqSparimTests.navigateToBotiqSparim();
	  
	  ButiqSparimTests.scrollDownThePage8Times();
	  
	  ButiqSparimTests.clickingOnEveryLikeButtonOnBookDesignAndTakingTheAmountLikedBooks();
	  
	  ButiqSparimFunctions.checkingBotiqSparim(howManyLikes, likebuttons);
  }
  
  private static void navigateToBotiqSparim() throws InterruptedException {
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
  
  @Test(priority = 1)
  public static void rightAmuontOfBooksInEachCategory() throws InterruptedException {
	  ButiqSparimTests.navigateToBotiqSparim();
	  
	  ButiqSparimTests.findingButtonAndCategoriesElementsAndTakingTheTitleOfEachCategories();
	  
	  ButiqSparimTests.takingAmountOfBooksFromEachCategory();
	  
	  ButiqSparimFunctions.checkingThatTheAmountOfBooksInEachCategoryIsRight(amountOfBooks, nameOfCategory);
  }
  

  
  private static void findingButtonAndCategoriesElementsAndTakingTheTitleOfEachCategories() throws InterruptedException {
	  Thread.sleep(1500);
	  noshimButton=driver.findElement(By.xpath("//div[@id='theme-books']//span[@class='lupa-custom-select__triger-text underline ']"));
	  categories=driver.findElements(By.xpath("//div[@id='theme-books']//div[@class='custom-options']//span"));
	  
	  amountOfBooks=new int[categories.size()];
	  nameOfCategory=new ArrayList<String>(categories.size());
	  for (int i = 0; i < categories.size(); i++) {
		  String a=(String) js.executeScript("return arguments[0].innerHTML;",categories.get(i));
		  a=a.trim();
		nameOfCategory.add(a);
	}
  }
  
  private static void takingAmountOfBooksFromEachCategory() throws InterruptedException {
	  
	  for (int i = 0; i < categories.size(); i++) {
		  js.executeScript("arguments[0].click()", noshimButton);
		js.executeScript("arguments[0].click();", categories.get(i));
		
		  for (int j = 0; j < 3; j++) {	                                                   
			  js.executeScript("window.scrollBy(0,8000)", "");
			  Thread.sleep(1000); 
		  }
		  allBooks=driver.findElement(By.xpath("//p[@id='filter-results']//span[@class='total-filter-results']"));
		String books=allBooks.getText();
		books=books.trim();
		amountOfBooks[i]=Integer.parseInt(books);
	}
  }
  
  
}

