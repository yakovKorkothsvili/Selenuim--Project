package tools;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

public class ButiqSparimFunctions {

	static public void checkingBotiqSparim(WebElement howManyLikes, List<WebElement> likeButtons)
			throws InterruptedException {
		System.out.println("");
		System.out.println("results like button butiq sparim");
		String Likes = howManyLikes.getText();
		int howmanyLikes = Integer.parseInt(Likes);
		if (howmanyLikes == likeButtons.size()) {
			System.out.println("all the like buttons are working and has been transferred to the 'like' category");
		} else {
			Thread.sleep(300);
			System.err.println("not all the like buttons r working");
		}
	}

	static public void checkingThatTheAmountOfBooksInEachCategoryIsRight(int[] amountOfBooks,
			ArrayList<String> nameOfCategory) throws InterruptedException {

		System.out.println(" ");
		System.out.println("results for rightAmuontOfBooksInEachCategory");
		int[] amountOfBooks1 = new int[amountOfBooks.length];
		amountOfBooks1[0] = 12;
		amountOfBooks1[1] = 2;
		amountOfBooks1[2] = 5;
		amountOfBooks1[3] = 4;
		amountOfBooks1[4] = 4;
		amountOfBooks1[5] = 0;
		amountOfBooks1[6] = 40;
		amountOfBooks1[7] = 24;
		amountOfBooks1[8] = 19;
		amountOfBooks1[9] = 18;
		amountOfBooks1[10] = 27;
		amountOfBooks1[11] = 9;
		amountOfBooks1[12] = 18;
		amountOfBooks1[13] = 9;
		amountOfBooks1[14] = 5;
		amountOfBooks1[15] = 17;
		amountOfBooks1[16] = 8;
		amountOfBooks1[17] = 0;
		for (int i = 0; i < amountOfBooks.length; i++) {
			if (amountOfBooks[i] == amountOfBooks1[i]) {
				System.out.println("category  " + nameOfCategory.get(i) + " showing the right amount of books");
			} else {
				Thread.sleep(300);
				System.err.println("category " + nameOfCategory.get(i) + " is not showing the right amount of books");
			}
		}
	}
}
