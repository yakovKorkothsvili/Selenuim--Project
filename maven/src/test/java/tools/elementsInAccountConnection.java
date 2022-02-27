package tools;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class elementsInAccountConnection {
	static public WebDriver driver=null;
    static  public Actions act; 
	static public  JavascriptExecutor js=null;
	//connect with faceboook elements
	static public WebElement ExistingAccountButton;
	static public WebElement connectToFacebookbutton;
	static public ArrayList<String> tabs;
	static public WebElement emailField;
	static public WebElement passwordField;
	static public WebElement signInButton;
	static public WebElement headerName;
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
	
	
}
