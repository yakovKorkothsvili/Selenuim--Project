package tools;


import java.util.ArrayList;
import java.util.Iterator;
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
	            	Thread.sleep(300);
	            	System.err.println("the link "+LinksNames.get(i)+" is not working");
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

	static public void designCheck(String harzlDesign, String mosahDesign) throws InterruptedException {
		System.out.println("");
		System.out.println("results for edit pics");
		if (harzlDesign.equals("divImgOptionMainBlack")) {
			System.out.println("the design for the harzl pic has been picked");
		}
		else {
			Thread.sleep(300);
			System.err.println("somthing went wrong with picking the design for harzl");
		}
		
		if (mosahDesign.equals("cursor: grab; width: 450px; height: 450px; display: none;")) {
			System.out.println("the design for mosah pic has been picked");
		}
		else {
			Thread.sleep(300);
			System.out.println("somthing went wrong in picking the design for mosah pic");
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

	static public void tableValues(List<WebElement> row,List<WebElement>row1, List<WebElement>row2) throws InterruptedException {
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
			Thread.sleep(300);
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
	  			Thread.sleep(300);
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
			  			Thread.sleep(300);
			  			System.err.println("the price on row 3 item number "+i+" is NOT correct");
			  		}
			  	}
	}
	static public void amuontOfPages(String[]pages) throws InterruptedException {
		System.out.println("");
		System.out.println("results for amuontOfPages");
		String[]amuont1={"28","32","36","40","44","48","52","56"};
		for (int i = 0; i < amuont1.length; i++) {
			if (pages[i].equals(amuont1[i])) {
				System.out.println("number "+amuont1[i]+" is visible");
			}
			else {
				Thread.sleep(300);
				System.out.println("number "+amuont1[i]+" is NOT visible");
			}
		}
	}
	



	

}


