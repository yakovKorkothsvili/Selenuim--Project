package tests;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import tools.ElementsTests;
import tools.UXFunctions;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;

public class UXTestsMainPage extends ElementsTests {
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
		static public ArrayList<String> FontAndColorLinks=new ArrayList<String>(4);
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
		  
			//String browser="chrome";
		  
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
		  
	  js=(JavascriptExecutor) driver;
	  driver.manage().window().maximize();
	  driver.get("https://www.lupa.co.il/");
	  Thread.sleep(1500);
	  cookie=driver.findElement(By.xpath("//*[@id='Layer_1']"));
	  cookie.click();
	  
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
	  UXTestsMainPage.findingElementsLinksAndTakingFontColorLink1();
	  
	  UXTestsMainPage.TakingFontColorLink2AddingStringsToArrayList();
	  
	  UXFunctions.checkingFontAndColorOf2Links(FontAndColorLinks);
  }

  private static void findingElementsLinksAndTakingFontColorLink1() {
	  links=driver.findElements(By.xpath("//div[@class='lupa_main_btn_container aos-init aos-animate']//a"));
	  fontFamliyAlbum=links.get(0).getCssValue("font-family");
	  colorAlbum=links.get(0).getCssValue("color");
  }
  
  private static void TakingFontColorLink2AddingStringsToArrayList() {
	  fontFamliyKirTmonot=links.get(1).getCssValue("font-family");
	  colorKirTmonot=links.get(1).getCssValue("color");
	  FontAndColorLinks.add(fontFamliyAlbum);
	  FontAndColorLinks.add(colorAlbum);
	  FontAndColorLinks.add(fontFamliyKirTmonot);
	  FontAndColorLinks.add(colorKirTmonot);
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