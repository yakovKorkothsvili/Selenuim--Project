package tools;


import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.primitives.ImmutableIntArray;


public class functions {

	static public void menuTest(String[] url, List<String>LinksNames) throws InterruptedException {
		System.out.println(" ");
		System.out.println("results for Menu Test");
		String[] URLs= new String[LinksNames.size()];
		URLs[0]="https://www.lupa.co.il/products/digital-album/";
		URLs[1]="https://www.lupa.co.il/products/minilupa/";
		URLs[2]="https://www.lupa.co.il/products/layflat/";
		URLs[3]="https://www.lupa.co.il/themes/family-photo-book/";
		URLs[4]="https://www.lupa.co.il/themes/travel/";
		URLs[5]="https://www.lupa.co.il/themes/wedding/";
		URLs[6]="https://www.lupa.co.il/themes/bat-mizva/";
		URLs[7]="https://www.lupa.co.il/themes/bar-mizva/";
		URLs[8]="https://www.lupa.co.il/boutiq/";
		URLs[9]="https://www.lupa.co.il/platform/stickers/";
		URLs[10]="https://www.lupa.co.il/platform/designers/";
             for (int i = 0; i < LinksNames.size(); i++) {
	            if (URLs[i].equals(url[i])) {
	            	System.out.println("the link "+LinksNames.get(i)+" is working");
                	}
	            else {
	            	System.err.println("the link "+LinksNames.get(i)+" is not working");
				}
            }
	}
	
	static public void checkingErrorMesAccount(ArrayList<String>errMes) throws InterruptedException {
		System.out.println(" ");
		System.out.println("results for error message creating account");
		String []errorMes= new String[6];
		errorMes[0]="שם פרטי לא יכול להכיל ספרות";
		errorMes[1]="זה שם ממאדים. כאן יש מינימום של 2 אותיות לשם";
		errorMes[2]="hopa@lupa.co.il דוגמה לכתובת מייל נכונה";
		errorMes[3]="במספר טלפון תקין יש 10 ספרות";
		errorMes[4]="המינימום כאן, הוא שילוב של 6 אותיות באנגלית וספרות";
		errorMes[5]="נא לאשר את התקנון";
		for (int i = 0; i < errMes.size(); i++) {
			if (errMes.get(i).equals(errorMes[i])) {
				System.out.println("the error message "+errorMes[i]+" is visible");
			}
			else {
				Thread.sleep(300);
				System.err.println("the error message "+errorMes[i]+" is not visible");
				
			}
		}
	}
	static public void checkingConnctionToFacebook(String name) {
		System.out.println(" ");
		System.out.println("results for connction to facebook");
		if (name.contains("אהלן John")||name.contains("אהלן yakov")) {
			System.out.println("the account has been connected with facebook");
		}
		else {
			System.err.println("the account didnt connect");
		}
	}
	static public void checkingBotiqSparim(WebElement howManyLikes, List<WebElement>likeButtons) {
		System.out.println("");
		System.out.println("results like button butiq sparim");
		String Likes=howManyLikes.getText();
		int howmanyLikes=Integer.parseInt(Likes);
		if (howmanyLikes==likeButtons.size()) {
			System.out.println("all the like buttons r working and has been transferred to the 'like' category");
		}
		else {
			System.err.println("not all the like buttons r working");
		}
	}
	static public void errMesOrderAndPhoneFields(String errorOrderId, String errorPhoneField, String errorPhoneField1){
		System.out.println(" ");
		System.out.println("results for error message on tracking order");
		String errorMes[]=new String[3];
		errorMes[0]=errorOrderId;
		errorMes[1]=errorPhoneField;
		errorMes[2]=errorPhoneField1;
		String[] errMessage=new String[3];
		errMessage[0]="מספר ההזמנה אינו תקין";
		errMessage[1]="במספר תקין יש קידומת + 7 ספרות";
		errMessage[2]="המספר אינו קיים במערכת";
		
		for (int i = 0; i < errMessage.length; i++) {
			if (errorMes[i].equals(errMessage[i])) {
				System.out.println("the error message "+errorMes[i]+" is up");
				
			}
			else {
				System.err.println("somthing went wrong in error message "+errMessage[i]);
			}
		}
	}
	static public void botiqAmountOfBooksCategory(int[]amountOfBooks, ArrayList<String>nameOfCategory) throws InterruptedException {
		System.out.println(" ");
		System.out.println("results for butiq sparim");
		int[]amountOfBooks1=new int[amountOfBooks.length];
		amountOfBooks1[0]=14;
		amountOfBooks1[1]=8;
		amountOfBooks1[2]=41;
		amountOfBooks1[3]=16;
		amountOfBooks1[4]=24;
		amountOfBooks1[5]=18;
		amountOfBooks1[6]=24;
		amountOfBooks1[7]=12;
		amountOfBooks1[8]=11;
		amountOfBooks1[9]=2;
		amountOfBooks1[10]=5;
		amountOfBooks1[11]=9;
		amountOfBooks1[12]=17;
		amountOfBooks1[13]=9;
		amountOfBooks1[14]=5;
		amountOfBooks1[15]=18;
		amountOfBooks1[16]=4;
		amountOfBooks1[17]=4;
		amountOfBooks1[18]=4;
		for (int i = 0; i < amountOfBooks.length; i++) {
			if (amountOfBooks[i]==amountOfBooks1[i]) {
				System.out.println("category  "+nameOfCategory.get(i)+" showing the right amount of books");		
			}
			else {
				Thread.sleep(300);
				System.err.println("category "+nameOfCategory.get(i)+" is not showing the right amount of books");
			}
		}
	}
	static public void checkingValueCrudTest(String FirstName, String LastName, String BdDay, String BdMonth, String BdYear, String PhoneNumber) throws InterruptedException {
		System.out.println(" ");
		System.out.println("results for crud test");
		String[]det= {FirstName, LastName, BdDay, BdMonth, BdYear, PhoneNumber};
		String[]name= {"first name", "last name", "birth day", "birth month", "birth year", "phone number"};
		String [] change= new String[6];
		change[0]="yakov";
		change[1]="korkot";
		change[2]="3";
		change[3]="1";
		change[4]="1999";
		change[5]="054-1234567";
		for (int i = 0; i < change.length; i++) {
			det[i]=det[i].trim();
		}
		for (int i = 0; i < change.length; i++) {
			if (det[i].equals(change[i])) {
				System.out.println(name[i]+" has been changed successfully to "+det[i]);
			}
			else {
				Thread.sleep(300);
				System.err.println(name[i]+" has not been changed to "+change[i]);
			}
		}
		
	}
	static public void connectionToFacebookChat(String name, String email) throws InterruptedException {
		System.out.println("");
		System.out.println("results for connectToFacebookThroughChat");
		if (name.equals("John Smhoni")&& email.equals("jsmhoni@gmail.com")) {
			System.out.println("the acoount to facebook through chat is working");
		}		
		else {
			Thread.sleep(300);
			System.err.println("something went wrong");
		}
		
	}
	static public void designCheck(String harzlDesign, String mosahDesign) {
		System.out.println("");
		System.out.println("results for edit pics");
		if (harzlDesign.equals("divImgOptionMainBlack")) {
			System.out.println("the design for the harzl pic has been picked");
		}
		else {
			System.err.println("somthing went wrong with picking the design for harzl");
		}
		
		if (mosahDesign.equals("cursor: grab; width: 450px; height: 450px; display: none;")) {
			System.out.println("the design for mosah pic has been picked");
		}
		else {
			System.out.println("somthing went wrong in picking the design for mosah pic");
		}
	}
	static public void LogoCss(int xLogo, int ylogo, int widthLogo, int heightLogo) throws InterruptedException {
		Thread.sleep(500);
		System.out.println(" ");
		System.out.println("results for logo css test");
		int XLogo=1419;
		int YLogo=62;
		int widthlogo=64;
		int heightlogo=56;

		if (XLogo==xLogo && YLogo==ylogo) {
			System.out.println("location of the logo is in the right place");
		}
		else {
			System.err.println("location of the logo is in the wrong place");
		}
		if (widthlogo==widthLogo && heightlogo==heightLogo) {
			System.out.println("width and height of the logo is right");
		}
		else {
			System.err.println("width and height of the logo is wrong");
		}
	}
	
	static public void LinksCss(ArrayList<String>cssElements) throws InterruptedException {
		System.out.println("");
		System.out.println("results for Css value Links");
       String[]name= {"font","color","font","color"};
       String[]names= {"Link album tmonot","Link kir tmonot"};

		String []CssValue= {"\"ploni medium\", sans-serif","rgba(0, 0, 0, 1)","\"ploni medium\", sans-serif","rgba(0, 0, 0, 1)"};
		for (int i = 0; i < cssElements.size(); i++) {
			if (cssElements.get(i).equals(CssValue[i])) {
				if (i==0||i==1) {
					System.out.println(name[i]+" of "+names[0]+" is correct");
				} else {
					System.out.println(name[i]+" of "+names[1]+" is correct");
				}
			}	
			else {
				Thread.sleep(200);
				System.err.println("somthing went wrong");
			}
		}
	}
	
	static public void SearchResultsTest(ArrayList<String>REsults) throws InterruptedException {
		System.out.println("");
		System.out.println("results for test 'Search Results'");
		String[]LinksNames=new String[9];
		LinksNames[0]="קישור להתקנת תוכנת לופה";
		LinksNames[1]="אבטחת המידע בלופה";
		LinksNames[2]="הגדרת לופה כתכנית בטוחה בחומת האש";
		LinksNames[3]="הגדרת לופה כתוכנית בטוחה בחומת האש";
		LinksNames[4]="איך תולים לופה בריבוע";
		LinksNames[5]="התקנת תוכנת לופה - סרטון";
		LinksNames[6]="עיצוב ספר באפליקציה - סרטון";
		LinksNames[7]="הזמנת ספר בתוכנת המחשב";
		LinksNames[8]="התקנת התוכנה על מחשב במקום העבודה";
		for (int i = 0; i < REsults.size(); i++) {
			if (REsults.get(i).equals(LinksNames[i])) {
				System.out.println("result number "+LinksNames[i]+" is in place");
			}	
			else {
				Thread.sleep(100);
				System.err.println("result num "+LinksNames[i]+" is not in place");
			}
		}
	}
	static public void cssValueDiscount(int[]location, String ColorText, String ColorBackround) {
		System.out.println(" ");
		System.out.println("the results for test cssValueDiscound");
		int []locationOf=new int[]{71,77,45,66};
		String []name= {"text","backround"};
		String textColor="rgba(0, 0, 0, 1)";
		String backroundColor="rgba(0, 0, 0, 1)";
		for (int i = 0; i < 2; i++) {
			if (location[i]==locationOf[i]) {
					System.out.println("location of "+name[0]+" is in place");
			}else {
				System.err.println("location of "+name[0]+" is not in place");	
      		}	
		}
		for (int i = 2; i < 4; i++) {
			if (location[i]==locationOf[i]) {
				System.out.println("location of "+name[1]+" is in place");
		}else {
			System.err.println("location of "+name[1]+" is not in place");	
  		}	
	}
		
		if (ColorText.equals(textColor)) {
			System.out.println("color of the "+name[0]+" is right");
		}
		else {
			System.err.println("color of the "+name[0]+" is wrong");
		}
		if (ColorBackround.equals(backroundColor)) {
			System.out.println("color of the "+name[1]+" is right");
		}
		else {
			System.err.println("color of the "+name[1]+" is right");
		}
}
	static public void tableValues(List<WebElement> row,List<WebElement>row1, List<WebElement>row2) {
		System.out.println(" ");
		System.out.println("results for test valuesInTable");
		System.out.println(" ");
		int[]row0=new int[row.size()];
		int[]rowA=new int[] {153,226,174,164,248,164,121,79};
      for (int i = 0; i < row.size(); i++) {
	   String a=row.get(i).getText();
	   row0[i]=Integer.parseInt(a);
      } 
      for (int i = 0; i < row0.length; i++) {
		if (row0[i]==rowA[i]) {
			System.out.println("the price on row 1 item number "+i+" is correct");
		}
		else {
			System.err.println("the price on row 1 item number "+i+" is NOT correct");
		}
	}
      System.out.println(" ");
		int[]rowOne=new int[row1.size()];
		int[]rowB=new int[] {120,121,96,69};
	      for (int i = 0; i < row1.size(); i++) {
		   String a=row1.get(i).getText();
		   rowOne[i]=Integer.parseInt(a);
	      } 
	      for (int i = 0; i < rowB.length; i++) {
	  		if (rowOne[i]==rowB[i]) {
	  			System.out.println("the price on row 2 item number "+i+" is correct");
	  		}
	  		else {
	  			System.err.println("the price on row 2 item number "+i+" is NOT correct");
	  		}
	  	}
	      System.out.println(" ");
			int[]rowTwo=new int[row2.size()];
			int[]rowC=new int[] {216,303,226,202,333,225};
		      for (int i = 0; i < row2.size(); i++) {
			   String a=row2.get(i).getText();
			   rowTwo[i]=Integer.parseInt(a);
		      }
		      for (int i = 0; i < rowC.length; i++) {
			  		if (rowTwo[i]==rowC[i]) {
			  			System.out.println("the price on row 3 item number "+i+" is correct");
			  		}
			  		else {
			  			System.err.println("the price on row 3 item number "+i+" is NOT correct");
			  		}
			  	}
	}
	
	
	
	}


