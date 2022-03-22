package tests;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import tools.FormsFunctions;
import tools.ElementsTests;
import tools.functions;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class FormsTests extends ElementsTests {	
	//elements errorMessagesOnFormSendEmail
	static public WebElement sendEmailButton;
	static public List<WebElement> mainPageMenu;
	static public WebElement subjectListButton;
	static public List <WebElement> dropList;
	static public WebElement PrivateName;
	static public WebElement LastName;
	static public WebElement PhoneNUMBER;
	static public WebElement email1;
	static public WebElement SendMailButton;
	static public List<WebElement>errorList;
	static public String[]errorMess=new String[7];
	//elements contactMeForm
	static public WebElement firstName;
	static public WebElement lastName;
	static public WebElement EMAIL;
	static public WebElement sendButton;
	static public List<WebElement>errmes;
	static public String[]errorElements;
	//elements LetTalkAboutItForm
	static public WebElement haskimButton;
	static public WebElement letsTalkAboutIt;
    static public WebElement POPup;
	static public WebElement privateName;
	static public WebElement lastNAME;
	static public WebElement First3Numbers;
    static public WebElement phoneNum;
    static public WebElement Email;
	static public WebElement sendKey;
	static public List<WebElement>numbers;
	static public String[] errorMessages;
	static public List<WebElement> errorMessagesElements;
	//followOrderFailed
	static public WebElement customerServiceButton;
	static public List<WebElement>followOrder;
	static public WebElement first3Numbers;
	static public List<WebElement>kidomet;
	static public WebElement phoneField;
	static public WebElement orderIdField;
	static public WebElement showDetes;
	static public WebElement errMesOrderId;
	static public WebElement errMesphone;
	static public WebElement errMes1phone;
	static public String errmessageOrderId;
	static public String errmessagePhone;
	static public String errmessagePhone1;

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
  public static void errorMessagesOnFormSendEmail() throws InterruptedException {
	  
	  FormsTests.navigateToCustomerServicePage();
	  
	  FormsTests.openTheSendEmailForm();
	 
	  FormsTests.picKaSubjectForTheEmail();
	 
      FormsTests.fillPersonalDetailsOnTheFormSendEmail();
      
      FormsTests.takeTheErrorMessagesFromTheFormSendEmail();
	  
	  FormsFunctions.checkTheErrorMessagesSendEmailForm(errorMess); 
	  
     }

    private static void navigateToCustomerServicePage() {
	    mainPageMenu=driver.findElements(By.xpath("//nav//li[@class='top-nav-item']"));
	    mainPageMenu.get(3).click();
   }

    private static void openTheSendEmailForm() {
	   sendEmailButton=driver.findElement(By.xpath("//div[@class='self-service-desktop']//a[@class='email-popup-trigger popup-trigger spu-clickable']"));
	   js.executeScript("arguments[0].click();", sendEmailButton);	
   }
    private static void picKaSubjectForTheEmail() {
	    subjectListButton=driver.findElement(By.id("modular-form-subject"));
	    js.executeScript("arguments[0].click();", subjectListButton);
	    dropList=driver.findElements(By.xpath("//div[@id='modular-form-subject']//div[@role='listbox']//span"));
	    js.executeScript("arguments[0].click();", dropList.get(3));
   }
    private static void fillPersonalDetailsOnTheFormSendEmail() {
	     PrivateName=driver.findElement(By.id("sales_form_form_private_name"));
	     LastName=driver.findElement(By.id("sales_form_form_familiy_name"));
	     PhoneNUMBER=driver.findElement(By.id("sales_form_form_phone"));
	     email1=driver.findElement(By.id("sales_form_form_email"));
	     sendEmailButton=driver.findElement(By.xpath("//form[@action='/customer-service/#wpcf7-f7386-o7']//input[@type='submit']"));
	     PrivateName.sendKeys("a");
	     LastName.sendKeys("b");
	     PhoneNUMBER.sendKeys("56784");
	     email1.sendKeys("stivyslashgmail.com");
	     js.executeScript("arguments[0].click();", sendEmailButton);
     }
    private static void takeTheErrorMessagesFromTheFormSendEmail() throws InterruptedException {
	  Thread.sleep(1500);
	  errorList=driver.findElements(By.xpath("//div[@id='wpcf7-f7386-o7']//span[@class='wpcf7-not-valid-tip']"));
	  for (int i = 0; i < errorList.size(); i++) {
		errorMess[i]=errorList.get(i).getText();
		errorMess[i]=errorMess[i].trim();
     }
   }
    
    @Test
    private static void errorMessagesContactMeForm() throws InterruptedException {
    	
    	FormsTests.navigateToBusinessPage();
    	
    	FormsTests.closePopUpHagadaAsAgift();
    	
    	FormsTests.fillPersonalDetailsOnFormContactMeForm();
    	
    	FormsTests.takeTheErrorMessagesFromContactMeForm();
    	
    	FormsFunctions.checkingTheErrorMessagesContatMeForm(errorElements);
    }
    
    private static void navigateToBusinessPage() throws InterruptedException {
      haskimButton=driver.findElement(By.xpath("//ul[@class='top-nav-items']//li[2]"));
   	  haskimButton.click();
   	  Thread.sleep(1000);
    }
    
    private static void closePopUpHagadaAsAgift() {
    	 POPup=driver.findElement(By.xpath("//div[@role='button' and @aria-label]"));
   	  js.executeScript("arguments[0].click();", POPup);
    }
    
    private static void fillPersonalDetailsOnFormContactMeForm() throws InterruptedException {
  	  firstName=driver.findElement(By.id("business-form-private-name"));
  	  lastName=driver.findElement(By.id("business-form-family-name"));
  	  EMAIL=driver.findElement(By.id("business-form-email"));
  	  sendButton=driver.findElement(By.xpath("//form[@class='business-form']//div[@class='lupa_btn form_btn register-email-btn']//a"));
  	  firstName.sendKeys("ì");
  	  lastName.sendKeys("ò");
  	  EMAIL.sendKeys("jsmhonigmail.com");
  	  js.executeScript("arguments[0].click();", sendButton);
  	  Thread.sleep(1500);
    }
    
    private static void takeTheErrorMessagesFromContactMeForm() throws InterruptedException {
  	  errmes=driver.findElements(By.xpath("//div[@class='lupa-error-message ']//span"));
  	  errorElements=new String[errmes.size()];
  	  for (int i = 0; i < errmes.size(); i++) {
  		errorElements[i]=errmes.get(i).getText();
  		errorElements[i]=errorElements[i].trim();
  	   }
    }
    
    
    @Test
    private static void errorMessagesLetTalkAboutItForm() throws InterruptedException {
    	FormsTests.navigateToBusinessPage();
    	
    	FormsTests.closePopUpHagadaAsAgift();
    	
    	FormsTests.openTheLetTalkAboutItForm();
    	
    	FormsTests.fillPersonalDetailsOnTheFormLetTalkAboutItForm();
    	
    	FormsTests.takeTheErrorMessagesFromLetTalkAboutItForm();
    	
    	FormsFunctions.checkingErrorMessagesFormLetTalkAboutIt(errorMessages);
    }
    
    private static void openTheLetTalkAboutItForm() {
    	letsTalkAboutIt=driver.findElement(By.xpath("//div[@class='page-header__content aos-init aos-animate']//a"));
   	 js.executeScript("arguments[0].click();", letsTalkAboutIt);
    }
    
    private static void fillPersonalDetailsOnTheFormLetTalkAboutItForm() throws InterruptedException {
   	 privateName=driver.findElement(By.id("business_form_private_name"));
   	 lastNAME=driver.findElement(By.id("business_form_familiy_name"));
   	 phoneNum=driver.findElement(By.id("business_form_phone"));
   	 First3Numbers=driver.findElement(By.xpath("//div[@id='modular_business_service_form']//div[@class='lupa-custom-select__trigger']//span"));
   	 Email=driver.findElement(By.id("business_form_email"));
   	 sendKey=driver.findElement(By.xpath("//div[@class='contact-submit-container']//input")); 
   	 privateName.sendKeys("y");
   	 lastNAME.sendKeys("A");
   	 phoneNum.sendKeys("123456");
   	 Email.sendKeys("yakovgmail.com");
   	 Thread.sleep(500);
   	 js.executeScript("arguments[0].click();", sendKey);
   	Thread.sleep(2000);
    }
    
    private static void takeTheErrorMessagesFromLetTalkAboutItForm() {
   	 errorMessagesElements=driver.findElements(By.xpath("//span[@class='wpcf7-not-valid-tip']"));
   	 errorMessages=new String[errorMessagesElements.size()];
   	 for (int i = 0; i < errorMessagesElements.size(); i++) {
   		errorMessages[i]=errorMessagesElements.get(i).getText();
   		errorMessages[i].trim();
   	  }
    }
    
    @Test
    private static void followOrderFormErrorMessages() throws InterruptedException {
    	FormsTests.navigateToCustomerServicePage();
    	
    	FormsTests.openFollowOrderForm();
    	
    	FormsTests.findElementsInTheFollowOrderForm();
    	
    	FormsTests.fillDetailsForFollowOrderFormAndTakeErrorMessageOrderID();
    	
    	FormsTests.fillDetailsForFollowOrderFormAndTakeErrorMessagePhone1();
    	
    	FormsTests.fillDetailsForFollowOrderFormAndTakeErrorMessagePhone2();
    	
    	FormsFunctions.checkingErrorMessagesFormFollowOrder(errmessageOrderId, errmessagePhone, errmessagePhone1);
    }
    
    private static void openFollowOrderForm() {
    	 followOrder=driver.findElements(By.xpath("//div[@class='lupa_btn lupa_btn_blue lupa_btn_wide aos-init aos-animate']//a"));
    	 js.executeScript("arguments[0].click();", followOrder.get(0));
    }
    
    private static void findElementsInTheFollowOrderForm() {
    	 first3Numbers=driver.findElement(By.xpath("//div[@class='form-row']//div[@class='lupa-custom-select__trigger']"));
    	 kidomet=driver.findElements(By.xpath("//div[@id='order_tracking_form']//div[@role='listbox']//span"));
    	 orderIdField=driver.findElement(By.id("order_tracking_service_form_order_id"));
    	 showDetes=driver.findElement(By.xpath("//div[@id='order_tracking_btn']//a[@role='button']"));
    	phoneField=driver.findElement(By.id("order_tracking_service_form_phone"));
    }
    
    private static void fillDetailsForFollowOrderFormAndTakeErrorMessageOrderID() throws InterruptedException {
    	 js.executeScript("arguments[0].click();", first3Numbers);
    	 js.executeScript("arguments[0].click();", kidomet.get(3));
    	 phoneField.sendKeys("1234567");
    	 orderIdField.sendKeys("5826954");
    	 js.executeScript("arguments[0].click();",showDetes);
    	 Thread.sleep(1500);
    	 errMesOrderId=driver.findElement(By.xpath("//div[@class='lupa-error-message ']//span"));
    	 errmessageOrderId=(String) js.executeScript("return arguments[0].innerHTML",errMesOrderId);
    	 errmessageOrderId=errmessageOrderId.trim(); 
    }
    
    private static void fillDetailsForFollowOrderFormAndTakeErrorMessagePhone1() throws InterruptedException {
     phoneField.clear();
   	 phoneField.sendKeys("51234567");
   	 js.executeScript("arguments[0].click();",showDetes);
   	 Thread.sleep(1500);
   	 errMesphone=driver.findElement(By.xpath("//div[@class='lupa-error-message ']//span"));
   	 errmessagePhone=(String) js.executeScript("return arguments[0].innerHTML", errMesphone);
   	 errmessagePhone=errmessagePhone.trim();
    }
    
     private static void fillDetailsForFollowOrderFormAndTakeErrorMessagePhone2() throws InterruptedException {
    	 phoneField.clear();
    	 phoneField.sendKeys("9335529");
    	 js.executeScript("arguments[0].click();",showDetes);
    	 Thread.sleep(2500);
    	 errMes1phone=driver.findElement(By.xpath("//div[@class='lupa-error-message ']//span"));
    	 errmessagePhone1=(String) js.executeScript("return arguments[0].innerHTML;",errMes1phone);
    	 errmessagePhone1=errmessagePhone1.trim(); 
     }
     
    
}