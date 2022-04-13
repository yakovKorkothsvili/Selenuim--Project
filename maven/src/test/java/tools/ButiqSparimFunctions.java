package tools;

import java.util.List;

import org.openqa.selenium.WebElement;

public class ButiqSparimFunctions {

	static public void checkingBotiqSparim(WebElement howManyLikes, List<WebElement>likeButtons) throws InterruptedException {
		System.out.println("");
		System.out.println("results like button butiq sparim");
		String Likes=howManyLikes.getText();
		int howmanyLikes=Integer.parseInt(Likes);
		if (howmanyLikes==likeButtons.size()) {
			System.out.println("all the like buttons are working and has been transferred to the 'like' category");
		}
		else {
			Thread.sleep(300);
			System.err.println("not all the like buttons r working");
		}
	}
}
