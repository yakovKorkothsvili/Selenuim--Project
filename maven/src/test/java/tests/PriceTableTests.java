package tests;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import tools.ElementsThatAllTestsHave;
import tools.PriceTableFunctions;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;

public class PriceTableTests extends ElementsThatAllTestsHave {
	//elements valuesInTable
	static public WebElement pricesButton;
	static public WebElement albumimButton;
	static public List <WebElement> rowPrices;
	static public List <WebElement> rowPrices2;
	static public List <WebElement> rowPrices3;
	//elements amountOfPages
	static public WebElement plus;
	static public WebElement pages;
	static public String[]amuont=new String[8];
	static public WebElement popupAdHazhatMihir;

@Parameters ("browser")
  @BeforeMethod
  public void beforeMethod(String browser) throws InterruptedException {
	  
	  //String browser= "chrome";
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
  public void afterMethod() {
	 driver.quit();
  }

  @Test
  public void CheckingTheAmountOfPagesBasedOnAmountOfClicks() throws InterruptedException {
	  PriceTableTests.navigateToPriceTable();
	  
	  PriceTableTests.closePopUphzahatMihir();
	  
	  PriceTableTests.clickingOnPlusAndTakingTheAmountOfPages();
	  
	  PriceTableFunctions.CheckingThatTheAmuontOfPagesIsRight(amuont);
  }
  
  private static void navigateToPriceTable() {
		 pricesButton=driver.findElement(By.xpath("//div[@class='menu-tabs']//button[@data-tab-title-id='806']"));
		  js.executeScript("arguments[0].click();", pricesButton);
		  albumimButton=driver.findElement(By.xpath("//nav[@class='tabs-content tabs-content--visible']//img[@alt='מחירי אלבומים ומשלוחים']"));
		  js.executeScript("arguments[0].click();", albumimButton);
  }
  
  private static void closePopUphzahatMihir() throws InterruptedException {
	  Thread.sleep(8500);
	  popupAdHazhatMihir=driver.findElement(By.xpath("//div//div[@role='button']"));
	  js.executeScript("arguments[0].click();", popupAdHazhatMihir);
  }
  
  private static void clickingOnPlusAndTakingTheAmountOfPages() throws InterruptedException {
	  plus=driver.findElement(By.id("plus_sign"));
	  pages=driver.findElement(By.id("pages-number-subtitle"));
	  for (int i = 0; i < 8; i++) {
		 plus.click();
		 Thread.sleep(600);
		 amuont[i]=pages.getText();
	}
  }
  
  @Test
  public void checkingTheInfoOfTheTable() throws InterruptedException {
	  PriceTableTests.navigateToPriceTable();
	  
	  PriceTableTests.closePopUphzahatMihir();
	  
	  PriceTableTests.findingThe3RowsOfTheTable();
	  
	  PriceTableFunctions.checkingThe3rowsOfTheTableValues(rowPrices2, rowPrices, rowPrices3);
	  
  }
  
  private static void findingThe3RowsOfTheTable() throws InterruptedException {
	  Thread.sleep(2500);
	  rowPrices=driver.findElements(By.xpath("//div[@class='table-responsive']//tr[2]//span[@class='price_list_table_format_price_number']"));
	  rowPrices2=driver.findElements(By.xpath("//div[@class='table-responsive']//tr[3]//span[@class='price_list_table_format_price_number']"));
	  rowPrices3=driver.findElements(By.xpath("//div[@class='table-responsive']//tr[4]//span[@class='price_list_table_format_price_number']"));
  }
  
}
