 package tests;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import tools.ElementsThatAllTestsHave;
import tools.AccountTestFunctions;
import tools.E2EFunctions;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class AccountTests extends ElementsThatAllTestsHave{
	//LogInwithFacebookToLupa elements
	static  WebElement ExistingAccountButton;
	static  WebElement connectToFacebookbutton;
	static  ArrayList<String> tabs;
	static  WebElement emailField;
	static  WebElement passwordField;
	static  WebElement signInButton;
	static  WebElement headerName;
	static  String name;
	static  WebElement hasbonHisi;
	//Create account elements
	static  WebElement createNewAcoount;
	static  WebElement fieldName;
	static  WebElement fieldLastName;
	static  WebElement fieldEmail;
	static  WebElement PhoneField;
	static  WebElement PasswordField;
	static  WebElement PAsswordField;
	static  WebElement creatAcoount;
	static  WebElement errorMesFirstName;
	static  WebElement errorMesLastName;
	static  WebElement errorMesEmail;
	static  WebElement errorMesPhone;
	static  WebElement errorMesPassword;
	static  WebElement errorMesTaknon;
	static  ArrayList<String> errMes=new ArrayList<String>(5);
	//crud test elements
	static  WebElement profile;
	static  WebElement firstName;
	static  WebElement lastName;
	static  WebElement dateDay;
	static  WebElement dateMonth;
	static  WebElement dateYear;
	static  Select day;
	static  Select month;
	static  Select year;
	static  WebElement phoneField;
	static  WebElement saveButton;
	static  String Firstname;
	static  String Lastname;
	static  String Dateday;
	static  String Datemonth;
	static  String Dateyear;
	static  String phoneNumber;
	static  WebElement valueDay;
	static  WebElement valueMonth;
	static  WebElement valueYear;
	//elements from test connectToFacebookthroughChat
	static  WebElement chatButton;
	static  List <WebElement> chat1Button;
    static  List<WebElement> iframe;
	static  WebElement facebookIcon;
	static  List<WebElement> iframe1;
	static  List<WebElement>nameEmail;
	static  WebElement loginbutton;
	static  String email;
	//elements from test CheckingSearchResultsFromChat
	static  WebElement returnButton;
	static  WebElement searchField;
	static  Robot robot;
	static  List<WebElement> results;
	static  ArrayList<String> Results;
	static  String b;
	
	@Parameters ("browser")
	  @BeforeMethod
      public void beforeTest(String browser) throws InterruptedException {
		  
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
		  Thread.sleep(1500);
		  cookiePopUp=driver.findElement(By.xpath("//*[@id='Layer_1']"));
		  cookiePopUp.click();

		  
		  
	  }

	  @AfterMethod
	  public void afterTest() {
		 driver.quit();
	  }
	
  @Test
  public void LogInwithFacebookToLupa() throws InterruptedException {
	  
	  AccountTests.navigateToHasbonHisi();

       AccountTests.clickOnButtonExistingAccount();
       
       AccountTests.clickOnButtonConnectToFacebookAndSwitchToTab2();
       
       AccountTests.fillDetailsAndClickSignIn();
       
       AccountTests.switchToTab1AndTakingFirstNameOfTheAccount();
       
       AccountTestFunctions.checkingConnctionToFacebook(name);
     
  }
  
  private static void navigateToHasbonHisi() {
	hasbonHisi=driver.findElement(By.xpath("//menu[@class='desktop-menu ']//a//span[contains(.,'חשבון אישי')]"));
	hasbonHisi.click();
  }
private static void clickOnButtonExistingAccount() throws InterruptedException {
	 tabs=new ArrayList<String> (driver.getWindowHandles());
     driver.switchTo().window(tabs.get(1));
	Thread.sleep(1500);
	  ExistingAccountButton=driver.findElement(By.xpath("//div[@class='ctrl_screens']//a[contains(.,'קיי')]")); 
	js.executeScript("arguments[0].click();",ExistingAccountButton);
	  Thread.sleep(500);
}
  
private static void clickOnButtonConnectToFacebookAndSwitchToTab2() {
	  connectToFacebookbutton=driver.findElement(By.className("facebook"));
	  js.executeScript("arguments[0].click();", connectToFacebookbutton);
       tabs=new ArrayList<String> (driver.getWindowHandles());
       driver.switchTo().window(tabs.get(2));
}
 
private static void fillDetailsAndClickSignIn() {
    emailField=driver.findElement(By.id("email"));
    passwordField=driver.findElement(By.id("pass"));
    signInButton=driver.findElement(By.name("login"));
    emailField.sendKeys("jsmhoni@gmail.com");
    passwordField.sendKeys("PM:uj4yVu-!nRGw");
    signInButton.click(); 
}

private static void switchToTab1AndTakingFirstNameOfTheAccount() throws InterruptedException {
    driver.switchTo().window(tabs.get(1));
    Thread.sleep(11000);
    headerName=driver.findElement(By.id("header_name"));
    name=headerName.getText();
}


  @Test
  public static void CrudTestPersonalDetails() throws InterruptedException {
	  
	  AccountTests.navigateToHasbonHisi();
	  
	  AccountTests.clickOnButtonExistingAccount();
	  
	  AccountTests.clickOnButtonConnectToFacebookAndSwitchToTab2();
      
      AccountTests.fillDetailsAndClickSignIn();
       
      AccountTests. swicthToTab1AndClickOnProfile();
      
      AccountTests.changingPersonalDetailsAndClickSave();
      
      AccountTests.refreshAndTakingTheValuesOfDetails();

      AccountTestFunctions.checkingValueCrudTest(Firstname, Lastname, Dateday, Datemonth, Dateyear, phoneNumber);
    
  }
  
  private static void swicthToTab1AndClickOnProfile() throws InterruptedException {
      driver.switchTo().window(tabs.get(1));
      Thread.sleep(10000);
      profile=driver.findElement(By.id("profile"));
      js.executeScript("arguments[0].click();", profile);
  }
  
  private static void changingPersonalDetailsAndClickSave() {
      firstName=driver.findElement(By.id("cph_txb_f_name"));
      lastName=driver.findElement(By.id("cph_txb_l_name"));
      dateDay=driver.findElement(By.id("cph_ddDays"));
      dateMonth=driver.findElement(By.id("cph_ddMonth"));
      dateYear=driver.findElement(By.id("cph_ddYears"));
      phoneField=driver.findElement(By.id("cph_txb_phone"));
      saveButton=driver.findElement(By.id("cph_btn_update_profile"));
      firstName.clear();
      lastName.clear();
      firstName.sendKeys("yakov");
      lastName.sendKeys("korkot");
      day=new Select(dateDay);
      month=new Select(dateMonth);
      year=new Select(dateYear);
      day.selectByValue("3");;
      month.selectByValue("1");
      year.selectByValue("1999");
      phoneField.clear();
      phoneField.sendKeys("054-1234567");
      saveButton.click();
  }
  
  private static void refreshAndTakingTheValuesOfDetails() {
      driver.navigate().refresh();
      firstName=driver.findElement(By.id("cph_txb_f_name"));
      lastName=driver.findElement(By.id("cph_txb_l_name"));
      phoneField=driver.findElement(By.id("cph_txb_phone"));
      valueDay=driver.findElement(By.xpath("//select[@id='cph_ddDays']//option[@selected='selected']"));
      valueMonth=driver.findElement(By.xpath("//select[@id='cph_ddMonth']//option[@selected='selected']"));
      valueYear=driver.findElement(By.xpath("//select[@id='cph_ddYears']//option[@selected='selected']"));
      Firstname=firstName.getAttribute("value");
      Lastname=lastName.getAttribute("value");
      Dateday=valueDay.getAttribute("value");
      Datemonth=valueMonth.getAttribute("value");
      Dateyear=valueYear.getAttribute("value");
      phoneNumber=phoneField.getAttribute("value");
  }

  @Test
  public void CreatAcoountErrorMessages() throws InterruptedException {
	  
	  AccountTests.navigateToHasbonHisi();
	 
	  AccountTests.clickOnCreateNewAcoount();
	  
	  AccountTests.findElementsOnAndFillDetails();
	 
	  AccountTests.clickOnCreatAcoount();
	  
	  AccountTests.takingTheErrorMessages();
	  
      AccountTestFunctions.checkingErrorMesAccount(errMes);

  }

  private static void clickOnCreateNewAcoount() throws InterruptedException {
	  tabs=new ArrayList<String> (driver.getWindowHandles());
	     driver.switchTo().window(tabs.get(1));
	  Thread.sleep(1000);
	  createNewAcoount=driver.findElement(By.xpath("//div[@class='ctrl_screens']//a[contains(.,'דש')]"));
	  Thread.sleep(1000);
	  js.executeScript("arguments[0].click();", createNewAcoount);
	  
  }

  private static void findElementsOnAndFillDetails() {
	  fieldName=driver.findElement(By.id("ctrl_signup_nameInput"));
	  fieldLastName=driver.findElement(By.id("ctrl_signup_lastnameInput"));
	  fieldEmail=driver.findElement(By.id("ctrl_signup_emailInput"));
	  PhoneField=driver.findElement(By.id("ctrl_signup_mobileInput"));
	  PasswordField=driver.findElement(By.id("ctrl_signup_passwordInput"));
	  PAsswordField=driver.findElement(By.id("ctrl_signup_passwordInput2"));
	  creatAcoount=driver.findElement(By.name("embedded_signup_btn"));
	fieldName.sendKeys("12345678");
	fieldLastName.sendKeys("ט");
	fieldEmail.sendKeys("yakov580gmail.com");
	PhoneField.sendKeys("05648928");
	PasswordField.sendKeys("dt8uo");
	PAsswordField.sendKeys("dt8uo");
  }
  private static void clickOnCreatAcoount() {
	  js.executeScript("arguments[0].click();", creatAcoount);
  }
  
  private static void takingTheErrorMessages() {
  	errorMesFirstName=driver.findElement(By.id("msg_ctrl_signup_nameInput"));
  	String ErrorMesFirstName=errorMesFirstName.getText();
  	errMes.add(ErrorMesFirstName);

		errorMesLastName=driver.findElement(By.id("msg_ctrl_signup_lastnameInput"));
		String ErrorMesLastName=errorMesLastName.getText();
		errMes.add(ErrorMesLastName);

		errorMesEmail=driver.findElement(By.id("msg_ctrl_signup_emailInput"));
		String ErrorMesEmail=errorMesEmail.getText();
		errMes.add(ErrorMesEmail);

		errorMesPhone=driver.findElement(By.id("msg_ctrl_signup_mobileInput"));
		String ErrorMesPhone=errorMesPhone.getText();
		errMes.add(ErrorMesPhone);
		
		errorMesPassword=driver.findElement(By.id("msg_ctrl_signup_passwordInput"));
		String ErrorMesPassword=errorMesPassword.getText();
		errMes.add(ErrorMesPassword);
		
		errorMesTaknon=driver.findElement(By.id("msg_ctrl_signup_legalme2"));
		String ErrorMesTaknon=errorMesTaknon.getText();
		errMes.add(ErrorMesTaknon);
  }
  
  @Test
  public static void  connectToFacebookThroughChat() throws InterruptedException {
	  AccountTests.clickOnWaitingForYouInTheChatAndFromHereWeStartToChatButtons();
	  
	  AccountTests.clickTheFacebookIconItsInIfarme();
	  
	  AccountTests.switchToTheMainFrameAndswitchToTabNub2();
	  
	  AccountTests.fillDetailsToThenConnectTofacebook();
	  
	  AccountTests.switchBackToMainTabToTakeNameAndEmailItsInAIfame();
	  
	  AccountTestFunctions.checkingIfTheNameEmailIsRight(name, email);
  }
  
  private static void clickOnWaitingForYouInTheChatAndFromHereWeStartToChatButtons() throws InterruptedException {
	  chatButton=driver.findElement(By.id("services-widget-chat-icon"));
	  js.executeScript("arguments[0].click();", chatButton);
	  Thread.sleep(1000);
	  chat1Button=driver.findElements(By.xpath("//div[@id='collapse-services-content']//a"));
	  js.executeScript("arguments[0].click();", chat1Button.get(1));
	  Thread.sleep(1000);
  }
  
  private static void  clickTheFacebookIconItsInIfarme(){
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
  }
  private static void switchToTheMainFrameAndswitchToTabNub2() {
	  driver.switchTo().parentFrame();
		tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
  }
  
  private static void  fillDetailsToThenConnectTofacebook() throws InterruptedException {
		emailField=driver.findElement(By.id("email"));
		passwordField= driver.findElement(By.id("pass"));
		loginbutton=driver.findElement(By.name("login"));
		emailField.sendKeys("jsmhoni@gmail.com");
		passwordField.sendKeys("PM:uj4yVu-!nRGw");
		loginbutton.click();	
		Thread.sleep(500);
		
		//popUp 'continue as nameOfTheAccount' after i click login sometimes show up sometimes not
		try {
			driver.findElement(By.xpath("//span[@class='a8c37x1j ni8dbmo4 stjgntxs l9j0dhe7 ltmttdrg g0qnabr5 ojkyduve' and contains(.,'המשך')]")).click();
		} catch (Exception NoSuchElementException) {
		}	
  }
  
  private static void switchBackToMainTabToTakeNameAndEmailItsInAIfame() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.switchTo().window(tabs.get(0));
		iframe1=driver.findElements(By.tagName("iframe"));
		for (int i = 0; i <iframe1.size(); i++) {
			try {
				driver.switchTo().frame(i);
				nameEmail=driver.findElements(By.xpath("//div[@class='styles__UserProfileDetailsContainer-sc-1jj4i2k-0 kSRUDj']//div"));
				 name=nameEmail.get(0).getText();
				 email=nameEmail.get(1).getText();
				
			} catch (Exception NotSuchElement) {
				driver.switchTo().parentFrame();
			}
		}
  }
  
  @Test
  public static void CheckingSearchResultsFromChat() throws InterruptedException {
	  
	  AccountTests.clickOnWaitingForYouInTheChatAndFromHereWeStartToChatButtons();
	  
	  AccountTests.typeingLupaInSearchBarAndTakingTheResults();
	  
	  AccountTestFunctions.CheckingTheSearchResults(Results);
	  
  }
  
  private static void typeingLupaInSearchBarAndTakingTheResults() {
	  iframe=driver.findElements(By.tagName("iframe"));
		for (int i = 0; i < iframe.size(); i++) {
			try {
			driver.switchTo().frame(i);
			returnButton=driver.findElement(By.xpath("//div[@data-embed='chat']//button[@data-testid='Icon--back']"));
			js.executeScript("arguments[0].click();", returnButton);
			Thread.sleep(500);
			searchField=driver.findElement(By.xpath("//div[@data-garden-id='forms.faux_input']//input"));
			searchField.sendKeys("לופה");
			Thread.sleep(500);
			robot=new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(1500);
			results=driver.findElements(By.xpath("//ol[@lang='he']//li//a"));
			 Results=new ArrayList<String>(results.size());
			 
			for (int j = 0; j < results.size(); j++) {
				b=results.get(j).getText();
				b=b.trim();
				Results.add(b);
			}
	} catch (Exception NoSuchElementException) {
		driver.switchTo().parentFrame();
	  }
    }
  }
  
  
}
