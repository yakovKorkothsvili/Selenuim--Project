 package tests;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import tools.ElementsThatAllTestsHave;
import tools.AccountTestFunctions;
import tools.EditStyleOfPicsFunctions;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

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
	static public WebElement ExistingAccountButton;
	static public WebElement connectToFacebookbutton;
	static public ArrayList<String> tabs;
	static public WebElement emailField;
	static public WebElement passwordField;
	static public WebElement signInButton;
	static public WebElement headerName;
	static public String name;
	static public WebElement hasbonHisi;
	//Create account elements
	static public WebElement createNewAcoount;
	static public WebElement fieldName;
	static public WebElement fieldLastName;
	static public WebElement fieldEmail;
	static public WebElement PhoneField;
	static public WebElement PasswordField;
	static public WebElement PAsswordField;
	static public WebElement creatAcoount;
	static public WebElement errorMesFirstName;
	static public WebElement errorMesLastName;
	static public WebElement errorMesEmail;
	static public WebElement errorMesPhone;
	static public WebElement errorMesPassword;
	static public WebElement errorMesTaknon;
	static public ArrayList<String> errMes=new ArrayList<String>(5);
	//crud test elements
	static public WebElement profile;
	static public WebElement firstName;
	static public WebElement lastName;
	static public WebElement dateDay;
	static public WebElement dateMonth;
	static public WebElement dateYear;
	static public Select day;
	static public Select month;
	static public Select year;
	static public WebElement phoneField;
	static public WebElement saveButton;
	static public String Firstname;
	static public String Lastname;
	static public String Dateday;
	static public String Datemonth;
	static public String Dateyear;
	static public String phoneNumber;
	static public WebElement valueDay;
	static public WebElement valueMonth;
	static public WebElement valueYear;
	//elements from test connectToFacebookthroughChat
	static public WebElement chatButton;
	static public List <WebElement> chat1Button;
    static public List<WebElement> iframe;
	static public WebElement facebookIcon;
	static public List<WebElement> iframe1;
	static public List<WebElement>nameEmail;
	static public WebElement loginbutton;
	static public String email;
	//elements from test CheckingSearchResultsFromChat
	static public WebElement returnButton;
	static public WebElement searchField;
	static public Robot robot;
	static public List<WebElement> results;
	static public ArrayList<String> Results;
	static public String b;
	
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
