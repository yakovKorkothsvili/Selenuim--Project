package tools;

import java.awt.Robot;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.Point;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;



public class ElementsTests {
	
	//all tests have those elements
	static public WebDriver driver=null;
    static  public Actions act; 
	static public  JavascriptExecutor js=null;
	static public WebElement cookiePopUp;
	static public Point point;
	static public WebElement gifsForPassoverPopUp;
	//test LikeButtons
	static public WebElement menuAlbumTmonot;
	static public List<WebElement>likebuttons;
	static public WebElement howManyLikes;
	static public WebElement albumDesgin;
	//butiqSparimCatgorys elements
	static public WebElement noshimButton;
	static public List <WebElement> categories;
	static public WebElement allBooks;
	static public ArrayList<String>nameOfCategory;
	//elements from test connectToFacebookthroughChat
	static public WebElement chatButton;
	static public List <WebElement> chat1Button;
    static public List<WebElement> iframe;
	static public WebElement facebookIcon;
	static public List<WebElement> iframe1;
	static public List<WebElement>nameEmail;
	static public WebElement passwordField;
	static public WebElement emailField;
	static public WebElement loginbutton;
	static public String name;
	static public String email;
	static public ArrayList<String> tabs;
	//elements edit pics
	static public WebElement howDoUDoLupa;
	static public WebElement online;
	static public WebElement toUploadButton;
     static public WebElement pickPics;
	static public WebElement hipstory;
	static public List <WebElement> showAll;
	static public  ArrayList<String> tabs1;
	static public WebElement harzlPic;
	static public WebElement mosahPic;
	static public WebElement next;
	static public WebElement editHarzlPic;
	static public WebElement editMosahPic;
	static public WebElement blackFrameHarzl;
	static public WebElement saveHarzlPic;
    static public WebElement typeOfDesign;
	static public String harzlDesign;
	static public WebElement kapaDesign;
	static public WebElement typeOfdesign;
    static public WebElement saveMosahPic;
    static public String mosahDesign;
	//elements search results
	static public WebElement returnButton;
	static public WebElement searchField;
	static public Robot robot;
	static public List<WebElement> results;
	static public ArrayList<String> Results;
	static public String b;
	//elements valuesInTable
	static public WebElement pricesButton;
	static public WebElement albumimButton;
	static public List <WebElement> rowPrices;
	static public List <WebElement> rowPrices2;
	static public List <WebElement> rowPrices3;
	//elements amountOfPages
	static public WebElement plus;
	static public WebElement pages;
	static public String[]amuont=new String[8];
	static public WebElement popupAd;



}
