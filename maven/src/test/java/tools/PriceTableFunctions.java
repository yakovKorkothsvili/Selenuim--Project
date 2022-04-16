package tools;

import java.util.List;

import org.openqa.selenium.WebElement;

public class PriceTableFunctions {

	static public void CheckingThatTheAmuontOfPagesIsRight(String[]pages) throws InterruptedException {
		System.out.println("");
		System.out.println("results for 'CheckingTheAmountOfPagesBasedOnAmountOfClicks'");
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
	
	static public void checkingThe3rowsOfTheTableValues(List<WebElement> row,List<WebElement>row1, List<WebElement>row2) throws InterruptedException {
		System.out.println(" ");
		System.out.println("results for test 'checkingTheInfoOfTheTable'");
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
}
