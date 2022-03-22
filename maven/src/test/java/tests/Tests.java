package tests;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import tools.ElementsTests;
import tools.functions;
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

public class Tests extends ElementsTests{

 //@Parameters ("browser")
  @BeforeMethod
  public static void beforeTest() throws InterruptedException {
	 String browser="chrome";
	  try {
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			  driver=new ChromeDriver();
		}
		else if (browser.equals("Edge")) {
			WebDriverManager.edgedriver().setup();
			  driver=new EdgeDriver();
		}
	} catch (Exception e) {
	}
	  

  driver.manage().window().maximize();
  driver.get("https://www.lupa.co.il/");
  js=(JavascriptExecutor) driver;
  
  //cookie pop up
  Thread.sleep(500);
  cookie=driver.findElement(By.xpath("//*[@id='Layer_1']"));
  cookie.click();

  //menus top page
  menuLinks=driver.findElements(By.xpath("//ul[@data-tab-content-id='801']//li"));
  menuAlbumTmonot=driver.findElement(By.xpath("//menu[@class='desktop-menu ']//button[@data-tab-title-id='801']"));
  albumDesgin=driver.findElement(By.xpath("//ul[@data-tab-content-id='801']//li[contains(.,'עי')]"));
  }

  @AfterMethod
  public void afterTest()  {
 driver.quit();
  }

  @Test(priority = 1)
  public void MenuTestAlbumTmonot() throws InterruptedException {
	  Thread.sleep(1000);
		menuAlbumTmonot.click();	
	  List<String> linksName = new ArrayList<String>();
	  
	  for (WebElement y:menuLinks) {
		  Thread.sleep(150);
		linksName.add(y.getText());
	}
	  menuAlbumTmonot.click();
	  
		String[] url=new String[menuLinks.size()];
		for (int i = 0; i < menuLinks.size(); i++) {
			menuAlbumTmonot=driver.findElement(By.xpath("//menu[@class='desktop-menu ']//button[@data-tab-title-id='801']"));
			menuLinks=driver.findElements(By.xpath("//ul[@data-tab-content-id='801']//li"));
			menuAlbumTmonot.click();
			Thread.sleep(500);
			menuLinks.get(i).click();
			url[i]=driver.getCurrentUrl();
			
		}
		functions.menuTest(url, linksName);
  }
  @Test(priority = 2)
  public void LikeButtons() throws InterruptedException {
	  
	  menuAlbumTmonot.click();
	  Thread.sleep(500);
	  albumDesgin.click();
	  for (int i = 0; i < 8; i++) {	                                                   
		  js.executeScript("window.scrollBy(0,8000)", "");
		  Thread.sleep(2500); 
	  }
		  likebuttons=driver.findElements(By.xpath("//section[@id='lupa_boutiq']//div[@class='heart' or @class='heart ']"));
		  for (int j = 0; j < likebuttons.size(); j++) {
			js.executeScript("arguments[0].click();", likebuttons.get(j));
		}
		  howManyLikes=driver.findElement(By.id("number_of_likes"));
	    functions.checkingBotiqSparim(howManyLikes, likebuttons);
	
  }
  
  @Test(priority = 4)
  static public void butiqSparimCatgorys() throws InterruptedException {
	  menuAlbumTmonot.click();
	  Thread.sleep(500);
	  albumDesgin.click();  
	  Thread.sleep(1500);
	  noshimButton=driver.findElement(By.xpath("//div[@id='theme-books']//span[@class='lupa-custom-select__triger-text underline ']"));
	  categories=driver.findElements(By.xpath("//div[@id='theme-books']//div[@class='custom-options']//span"));
	  
	  int []amountOfBooks=new int[categories.size()];
	  nameOfCategory=new ArrayList<String>(categories.size());
	  for (int i = 0; i < categories.size(); i++) {
		  String a=(String) js.executeScript("return arguments[0].innerHTML;",categories.get(i));
		  a=a.trim();
		nameOfCategory.add(a);
	}

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
   functions.botiqAmountOfBooksCategory(amountOfBooks, nameOfCategory);
  }
  
  @Test (priority = 5)
  static public void connectToFacebookThroughChat() throws InterruptedException{
	  chatButton=driver.findElement(By.id("services-widget-chat-icon"));
	  js.executeScript("arguments[0].click();", chatButton);
	  Thread.sleep(1000);
	  chat1Button=driver.findElements(By.xpath("//div[@id='collapse-services-content']//a"));
	  js.executeScript("arguments[0].click();", chat1Button.get(1));
	  Thread.sleep(1000);
	  iframe=driver.findElements(By.tagName("iframe"));

	  
		for (int i = 0; i < iframe.size(); i++) {
			try {
			driver.switchTo().frame(i);
			facebookIcon=driver.findElement(By.xpath("//button[@title='facebook']"));
			js.executeScript("arguments[0].click();", facebookIcon);
		
	} catch (Exception e) {
		driver.switchTo().parentFrame();
	}
}
		
	  driver.switchTo().parentFrame();
		tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		emailField=driver.findElement(By.id("email"));
		passwordField= driver.findElement(By.id("pass"));
		loginbutton=driver.findElement(By.name("login"));
		emailField.sendKeys("jsmhoni@gmail.com");
		passwordField.sendKeys("PM:uj4yVu-!nRGw");
		loginbutton.click();	
		Thread.sleep(500);
		try {
			driver.findElement(By.xpath("//span[@class='a8c37x1j ni8dbmo4 stjgntxs l9j0dhe7 ltmttdrg g0qnabr5 ojkyduve' and contains(.,'המשך')]")).click();
		} catch (Exception NoSuchElementException) {
		}	
		
		Thread.sleep(2500);
		driver.switchTo().window(tabs.get(0));
		iframe1=driver.findElements(By.tagName("iframe"));
		for (int i = 0; i <iframe1.size(); i++) {
			try {
				driver.switchTo().frame(i);
				nameEmail=driver.findElements(By.xpath("//div[@class='sc-eInJlc emAJPF']//div"));
				 name=nameEmail.get(1).getText();
				 email=nameEmail.get(2).getText();

			} catch (Exception NotSuchElement) {
				driver.switchTo().parentFrame();
			}
		}
		functions.connectionToFacebookChat(name, email);
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
	  functions.designCheck(harzlDesign, mosahDesign);
  }


  @Test(priority = 9)
  static public void searchResults() throws InterruptedException, AWTException {
	  chatButton=driver.findElement(By.id("services-widget-chat-icon"));
	  js.executeScript("arguments[0].click();", chatButton);
	  Thread.sleep(1000);
	  chat1Button=driver.findElements(By.xpath("//div[@id='collapse-services-content']//a"));
	  js.executeScript("arguments[0].click();", chat1Button.get(1)); 
	  Thread.sleep(1000);
	  iframe=driver.findElements(By.tagName("iframe"));
	 
		for (int i = 0; i < iframe.size(); i++) {
			try {
			driver.switchTo().frame(i);
			returnButton=driver.findElement(By.xpath("//div[@class='chat-1B4dk']//button[@data-testid='Icon--back']"));
			js.executeScript("arguments[0].click();", returnButton);
			Thread.sleep(500);
			searchField=driver.findElement(By.xpath("//div[@data-garden-id='forms.faux_input']//input"));
			searchField.sendKeys("לופה");
			Thread.sleep(500);
			robot=new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(500);
			results=driver.findElements(By.xpath("//ol[@lang='he']//li//a"));
			 Results=new ArrayList<String>(results.size());
			 
			for (int j = 0; j < results.size(); j++) {
				b=results.get(j).getText();
				b=b.trim();
				Results.add(b);
			}	
			functions.SearchResultsTest(Results);
	} catch (Exception NoSuchElementException) {
		driver.switchTo().parentFrame();
	 }
   }				
 }
  
  
  @Test(priority = 11)
  static public void valuesInTable() throws InterruptedException {
	  
	  //click on menu and sub menu
	 pricesButton=driver.findElement(By.xpath("//div[@class='menu-tabs']//button[@data-tab-title-id='806']"));
	  js.executeScript("arguments[0].click();", pricesButton);
	  albumimButton=driver.findElement(By.xpath("//nav[@class='tabs-content tabs-content--visible']//img[@alt='מחירי אלבומים ומשלוחים']"));
	  js.executeScript("arguments[0].click();", albumimButton);
	  
	  //taking values for the table (3 rows)
	  Thread.sleep(2500);
	  rowPrices=driver.findElements(By.xpath("//div[@class='table-responsive']//tr[2]//span[@class='price_list_table_format_price_number']"));
	  rowPrices2=driver.findElements(By.xpath("//div[@class='table-responsive']//tr[3]//span[@class='price_list_table_format_price_number']"));
	  rowPrices3=driver.findElements(By.xpath("//div[@class='table-responsive']//tr[4]//span[@class='price_list_table_format_price_number']"));
	  functions.tableValues(rowPrices, rowPrices2, rowPrices3);
  }
  
  @Test(priority = 12)
  static public void amountOfPages() throws InterruptedException {
	  
		 pricesButton=driver.findElement(By.xpath("//div[@class='menu-tabs']//button[@data-tab-title-id='806']"));
		  js.executeScript("arguments[0].click();", pricesButton);
		  albumimButton=driver.findElement(By.xpath("//nav[@class='tabs-content tabs-content--visible']//img[@alt='מחירי אלבומים ומשלוחים']"));
		  js.executeScript("arguments[0].click();", albumimButton);
		  Thread.sleep(6500);
		  
		  //click out of the pop up ad
		  popupAd=driver.findElement(By.xpath("//div//div[@role='button']"));
		  js.executeScript("arguments[0].click();", popupAd);
		  
		  //press on the plus button to add more pages and take the amount of the page after every click
		  plus=driver.findElement(By.id("plus_sign"));
		  pages=driver.findElement(By.id("pages-number-subtitle"));
		  for (int i = 0; i < 8; i++) {
			 plus.click();
			 Thread.sleep(600);
			 amuont[i]=pages.getText();
		}
		  functions.amuontOfPages(amuont);
  }
  
  @Test(priority = 13)
  static public void Links() throws InterruptedException {
	  
	//find the elements links (bottom of the page)
	  linkS=driver.findElements(By.xpath("//div[@class='row']//ul[@id='menu-%d7%9e%d7%95%d7%a6%d7%a8%d7%99%d7%9d']//a[@href]"));
	  url=new String[linkS.size()];
	  
	  //click on one of the menu links and take the URL
	  for (int i = 0; i < linkS.size(); i++) {
		  linkS=driver.findElements(By.xpath("//div[@class='row']//ul[@id='menu-%d7%9e%d7%95%d7%a6%d7%a8%d7%99%d7%9d']//a[@href]"));
		js.executeScript("arguments[0].click();", linkS.get(i));
	    Thread.sleep(500);
		url[i]=driver.getCurrentUrl();
		driver.navigate().back();
	}
	  functions.LinksBottomOfThePage(url);
  }
  
}
