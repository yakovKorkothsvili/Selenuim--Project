package tests;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import tools.ElementsThatAllTestsHave;
import tools.UXFunctions;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;

public class UXTestsMainPage extends ElementsThatAllTestsHave {
	   //elements UXLogo
		static public WebElement logo;
		static public int xLogo;
		static public int yLogo;
		static public int widthLogo;
		static public int heightLogo;
		//elements UX Links
		static public List<WebElement> links;
		static public String  fontFamliyAlbum;
		static public String colorAlbum;
		static public String fontFamliyKirTmonot;
		static public String colorKirTmonot;
		static public ArrayList<String> FontAndColorAlbumTmonot=new ArrayList<String>(2);
		static public ArrayList<String> FontAndColorKirTmonot=new ArrayList<String>(2);
		//elements ccsValueDiscount
		static public WebElement discountText;
		static public WebElement discountBackround;
		static public int XdisText;
		static public int YdisText;
		static public String ColordisText;
		static public int XdisBackround;
		static public int YdisBackround;
		static public String ColordisBackround;
		static public int[]location;
		
	  @Parameters ("browser")
	  @BeforeMethod
	  public void beforeMethod(String browser) throws InterruptedException {
		  
			//String browser="Edge";
		  
			if (browser.equals("chrome")) {
				WebDriverManager.chromedriver().setup();
				  driver=new ChromeDriver();
			}
			else if (browser.equals("Edge")) {
				WebDriverManager.edgedriver().setup();
				  driver=new EdgeDriver();
			}

		  
	  js=(JavascriptExecutor) driver;
	  driver.manage().window().maximize();
	  driver.get("https://www.lupa.co.il/");
	  //closepopUps
	  Thread.sleep(1500);
	  cookiePopUp=driver.findElement(By.id("XMLID_54_"));
	  cookiePopUp.click();
	  driver.findElement(By.xpath("//div[@class='element-shape closeLightboxButton adoric_element']")).click();	
	  
	  }
	  
	  
	  @AfterMethod
	  public void afterMethod() {
		  driver.quit();
	  }
	  
	  
  @Test
  public void UXTestLupaLogo() throws InterruptedException {
	  UXTestsMainPage.findElementLogoAndTakingItsLocation();
	  
	  UXTestsMainPage.TakingLogosWidthHeight();
	 
	  UXFunctions.checkingLogoLoctionAndWidthHeight(xLogo, yLogo, widthLogo, heightLogo);
	  
  }
  
  private static void findElementLogoAndTakingItsLocation() {
	  logo=driver.findElement(By.xpath("//div[@class='tabs-logo-discount-wrapper']//a//img"));
	  point=logo.getLocation();
	  xLogo= point.getX();
	  yLogo=point.getY();
  }
  
  private static void TakingLogosWidthHeight() {
	  widthLogo=logo.getSize().getWidth();
	  heightLogo=logo.getSize().getHeight();
  }
  
  @Test
  public void  UXTestOn2LinksFontAndColor() throws InterruptedException {
	  findingElementsLinksAndTakingFontColorLink1();
	  
	  TakingFontColorLink2AddingStringsToArrayList();
	  
	  UXFunctions.checkingFontAndColorOf2Links(FontAndColorAlbumTmonot, FontAndColorKirTmonot);
  }

  private static void findingElementsLinksAndTakingFontColorLink1() {
	  links=driver.findElements(By.xpath("//div[@class='lupa_main_btn_container aos-init aos-animate']//a"));
	  fontFamliyAlbum=links.get(0).getCssValue("font-family");
	  colorAlbum=links.get(0).getCssValue("color");
  }
  
  private static void TakingFontColorLink2AddingStringsToArrayList() {
	  fontFamliyKirTmonot=links.get(1).getCssValue("font-family");
	  colorKirTmonot=links.get(1).getCssValue("color");
	  FontAndColorAlbumTmonot.add(fontFamliyAlbum);
	  FontAndColorAlbumTmonot.add(colorAlbum);
	  FontAndColorKirTmonot.add(fontFamliyKirTmonot);
	  FontAndColorKirTmonot.add(colorKirTmonot);
  }
  
  @Test 
  public void UXTestOnDiscountAd() throws InterruptedException {
	  UXTestsMainPage.FindingTextAndBackroundInDiscountAd();
	  
	  UXTestsMainPage.TakingLocationAndColorOfTextDiscount();
	  
	  UXTestsMainPage.TakingLocationAndColorOfBackroundDiscount();
	  
	  UXFunctions.checkingCssValueOfTextAndBackroundDiscount(location, ColordisText, ColordisBackround);
	  
  }
  private static void FindingTextAndBackroundInDiscountAd() {
	  discountText=driver.findElement(By.xpath("//div[@class='tabs-logo-discount-wrapper']//a[@class='promotions-popup-link promotions-popup-trigger popup-trigger spu-clickable']//p"));
	  discountBackround=driver.findElement(By.xpath("//div[@class='tabs-logo-discount-wrapper']//a[@class='promotions-popup-link promotions-popup-trigger popup-trigger spu-clickable']"));
	  location= new int[4];
  }
  
  private static void TakingLocationAndColorOfTextDiscount() {
	  point=discountText.getLocation();
	  location[0]=point.getX();
	  location[1]=point.getY();
	  ColordisText=discountText.getCssValue("color");
	 
  }
  private static void TakingLocationAndColorOfBackroundDiscount() {
	  point=discountBackround.getLocation();
	  location[2]=point.getX();
	  location[3]=point.getY();
	  ColordisBackround=discountBackround.getCssValue("background-color");
	
  }
  
}
