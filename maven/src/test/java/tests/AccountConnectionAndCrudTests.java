package tests;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import tools.elementsInAccountConnection;
import tools.functions;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class AccountConnectionAndCrudTests extends elementsInAccountConnection{
	
	  @BeforeMethod
      public void beforeTest() throws InterruptedException {
		  WebDriverManager.edgedriver().setup();
		  driver=new EdgeDriver();
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
  public void LogInwithFacebook() throws InterruptedException {
	  js.executeScript("arguments[0].click();",ExistingAccountButton);
	  Thread.sleep(500);
	  connectToFacebookbutton=driver.findElement(By.className("facebook"));
	  js.executeScript("arguments[0].click();", connectToFacebookbutton);
       tabs=new ArrayList<String> (driver.getWindowHandles());
       driver.switchTo().window(tabs.get(1));
       emailField=driver.findElement(By.id("email"));
       passwordField=driver.findElement(By.id("pass"));
       signInButton=driver.findElement(By.name("login"));
       emailField.sendKeys("jsmhoni@gmail.com");
       passwordField.sendKeys("PM:uj4yVu-!nRGw");
       signInButton.click(); 
       driver.switchTo().window(tabs.get(0));
       Thread.sleep(11000);
       headerName=driver.findElement(By.id("header_name"));
       String name=headerName.getText();
     functions.checkingConnctionToFacebook(name);
     
  }

  
  @Test
  public static void CrudTest() throws InterruptedException {
	  js.executeScript("arguments[0].click();",ExistingAccountButton);
	  Thread.sleep(500);
	  connectToFacebookbutton=driver.findElement(By.className("facebook"));
	  js.executeScript("arguments[0].click();", connectToFacebookbutton);
       tabs=new ArrayList<String> (driver.getWindowHandles());
       driver.switchTo().window(tabs.get(1));
       emailField=driver.findElement(By.id("email"));
       passwordField=driver.findElement(By.id("pass"));
       signInButton=driver.findElement(By.name("login"));
       emailField.sendKeys("jsmhoni@gmail.com");
       passwordField.sendKeys("PM:uj4yVu-!nRGw");
       signInButton.click(); 
       driver.switchTo().window(tabs.get(0));
       Thread.sleep(10000);
       profile=driver.findElement(By.id("profile"));
       js.executeScript("arguments[0].click();", profile);
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
       functions.checkingValueCrudTest(Firstname, Lastname, Dateday, Datemonth, Dateyear, phoneNumber);
    
  }
  
  @Test
  public void CreatAcoountFailed() throws InterruptedException {
	  createNewAcoount.click();
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
	js.executeScript("arguments[0].click();", creatAcoount);
   
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
		functions.checkingErrorMesAccount(errMes);
		 driver.quit();

  }


}
