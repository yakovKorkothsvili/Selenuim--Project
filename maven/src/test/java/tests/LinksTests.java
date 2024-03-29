package tests;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import tools.ElementsThatAllTestsHave;
import tools.LinksFunctions;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;

public class LinksTests extends ElementsThatAllTestsHave {

	// test MenuTestAlbumTmonot
	static public WebElement menuAlbumTmonot;
	static public List<WebElement> LinksAlbumTmonot;
	static public WebElement albumDesgin;
	static public String[] url;
	static public List<String> linksName = new ArrayList<String>();
	// elements Links
	static public List<WebElement> linkS;

	//@Parameters("browser")
	@BeforeMethod
	public void beforeMethod() throws InterruptedException {

		String browser="Edge";

		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browser.equals("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		}

		js = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		driver.get("https://www.lupa.co.il/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// closepopUps
		Thread.sleep(1500);
		cookiePopUp = driver.findElement(By.id("XMLID_54_"));
		cookiePopUp.click();
		driver.findElement(By.xpath("//div[@aria-label='close']")).click();

	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

	@Test
	public static void LinksTestsOnMenuAlbumTmonot() throws InterruptedException {
		LinksTests.findElementAlbumTmonotAndClickOnIt();

		LinksTests.TakingTheTitlesOfTheLinksAndClickOnAlbumTmonotMenu();

		LinksTests.ClickingOnEachLinkAndTakingTheURL();

		LinksFunctions.CheckingIfTheTestGotToTheRightURLs(url, linksName);

	}

	private static void findElementAlbumTmonotAndClickOnIt() throws InterruptedException {
		LinksAlbumTmonot = driver.findElements(By.xpath("//ul[@data-tab-content-id='801']//li"));
		menuAlbumTmonot = driver
				.findElement(By.xpath("//menu[@class='desktop-menu ']//button[@data-tab-title-id='801']"));
		Thread.sleep(1000);
		menuAlbumTmonot.click();
	}

	private static void TakingTheTitlesOfTheLinksAndClickOnAlbumTmonotMenu() throws InterruptedException {
		for (WebElement y : LinksAlbumTmonot) {
			Thread.sleep(550);
			linksName.add(y.getText());
		}
		menuAlbumTmonot.click();
	}

	private static void ClickingOnEachLinkAndTakingTheURL() throws InterruptedException {
		url = new String[LinksAlbumTmonot.size()];
		for (int i = 0; i < LinksAlbumTmonot.size(); i++) {
			// need to find those elements again cuz the test is moving between pages
			menuAlbumTmonot = driver
					.findElement(By.xpath("//menu[@class='desktop-menu ']//button[@data-tab-title-id='801']"));
			LinksAlbumTmonot = driver.findElements(By.xpath("//ul[@data-tab-content-id='801']//li"));
			js.executeScript("arguments[0].click();", menuAlbumTmonot);
			Thread.sleep(1500);
			LinksAlbumTmonot.get(i).click();
			url[i] = driver.getCurrentUrl();
			driver.navigate().back();

//		   driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
//		   popUpBackToSchool=driver.findElement(By.xpath("//div[@class='element-shape closeLightboxButton adoric_element']"));
//           js.executeScript("arguments[0].click();", popUpBackToSchool);

		}
	}

	@Test
	public static void LinksTetsMenuBottomOfThePage() throws InterruptedException {
		LinksTests.findingMenuLinksElements();

		LinksTests.clickOneEachLinkAndTakingTheURLBottomMenu();

		LinksFunctions.LinksBottomOfThePageCheckingTheUrls(url);

	}

	private static void findingMenuLinksElements() {
		linkS = driver.findElements(By.xpath("//div[@class='row']//ul[@id='menu-%d7%9e%d7%95%d7%a6%d7%a8%d7%99%d7%9d']//a[@href]"));
		url = new String[linkS.size()];
	}

	private static void clickOneEachLinkAndTakingTheURLBottomMenu() throws InterruptedException {
		for (int i = 0; i < linkS.size(); i++) {
			Thread.sleep(1500);
			linkS = driver.findElements(By.xpath("//div[@class='row']//ul[@id='menu-%d7%9e%d7%95%d7%a6%d7%a8%d7%99%d7%9d']//a[@href]"));
			js.executeScript("arguments[0].click();", linkS.get(i));
			Thread.sleep(500);
			url[i] = driver.getCurrentUrl();
			driver.navigate().back();
		}
	}

}
