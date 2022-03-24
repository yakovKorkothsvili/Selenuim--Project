 package tests;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import tools.ElementsTests;
import tools.AccountTestFunctions;
import tools.functions;
import java.util.ArrayList;
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

public class AccountTests extends ElementsTests{
	//LogInwithFacebookToLupa elements
	static public WebElement ExistingAccountButton;
	static public WebElement connectToFacebookbutton;
	static public ArrayList<String> tabs;
	static public WebElement emailField;
	static public WebElement passwordField;
	static public WebElement signInButton;
	static public WebElement headerName;
	static public String name;
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
	
	
	//@Parameters ("browser")
	  @BeforeMethod
      public void beforeTest() throws InterruptedException {
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
		  driver.get("https://connect.lupa.co.il/v2/ui/index.aspx?channel=website&callback=https://account.lupa.co.il/track_orders.aspx");
		  js=(JavascriptExecutor) driver;
		  
		  act=new Actions(driver);
		  
		  ExistingAccountButton=driver.findElement(By.xpath("//div[@class='ctrl_screens']//a[contains(.,'קיי')]"));
		  createNewAcoount=driver.findElement(By.xpath("//div[@class='ctrl_screens']//a[contains(.,'דש')]"));
		  
	  }

	  @AfterMethod
	  public void afterTest() {
		  driver.quit();
	  }
	
  @Test
  public void LogInwithFacebookToLupa() throws InterruptedException {

       AccountTests.clickOnButtonExistingAccount();
       
       AccountTests.clickOnButtonConnectToFacebookAndSwitchToTab2();
       
       AccountTests.fillDetailsAndClickSignIn();
       
       AccountTests.switchToTab1AndTakingFirstNameOfTheAccount();
       
       AccountTestFunctions.checkingConnctionToFacebook(name);
     
  }
private static void clickOnButtonExistingAccount() throws InterruptedException {
	js.executeScript("arguments[0].click();",ExistingAccountButton);
	  Thread.sleep(500);
}
  
private static void clickOnButtonConnectToFacebookAndSwitchToTab2() {
	  connectToFacebookbutton=driver.findElement(By.className("facebook"));
	  js.executeScript("arguments[0].click();", connectToFacebookbutton);
       tabs=new ArrayList<String> (driver.getWindowHandles());
       driver.switchTo().window(tabs.get(1));
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
    driver.switchTo().window(tabs.get(0));
    Thread.sleep(11000);
    headerName=driver.findElement(By.id("header_name"));
    name=headerName.getText();
}


  @Test
  public static void CrudTestPersonalDetails() throws InterruptedException {
	  
	  AccountTests.clickOnButtonExistingAccount();
	  
	  AccountTests.clickOnButtonConnectToFacebookAndSwitchToTab2();
      
      AccountTests.fillDetailsAndClickSignIn();
       
      AccountTests. swicthToTab1AndClickOnProfile();
      
      AccountTests.changingPersonalDetailsAndClickSave();
      
      AccountTests.refreshAndTakingTheValuesOfDetails();

      AccountTestFunctions.checkingValueCrudTest(Firstname, Lastname, Dateday, Datemonth, Dateyear, phoneNumber);
    
  }
  
  private static void swicthToTab1AndClickOnProfile() throws InterruptedException {
      driver.switchTo().window(tabs.get(0));
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
	 
	  AccountTests.clickOnCreateNewAcoount();
	  
	  AccountTests.findElementsOnAndFillDetails();
	 
	  AccountTests.clickOnCreatAcoount();
	  
	  AccountTests.takingTheErrorMessages();
	  
      AccountTestFunctions.checkingErrorMesAccount(errMes);

  }

  private static void clickOnCreateNewAcoount() throws InterruptedException {
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
  
}
