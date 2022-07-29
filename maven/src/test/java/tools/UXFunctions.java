package tools;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;

public class UXFunctions {

	static public void checkingLogoLoctionAndWidthHeight(int xLogo, int ylogo, int widthLogo, int heightLogo)
			throws InterruptedException {
		Thread.sleep(500);
		System.out.println(" ");
		System.out.println("results for logo css test");
		int XLogo = 1419;
		int YLogo = 62;
		int widthlogo = 64;
		int heightlogo = 56;

		if (XLogo == xLogo && YLogo == ylogo) {
			System.out.println("location of the logo is in the right place");
		} else {
			Thread.sleep(300);
			System.err.println("location of the logo is in the wrong place");
		}
		if (widthlogo == widthLogo && heightlogo == heightLogo) {
			System.out.println("width and height of the logo is right");
		} else {
			Thread.sleep(300);
			System.err.println("width and height of the logo is wrong");
		}
	}

	static public void checkingFontAndColorOf2Links(ArrayList<String> cssValueAlbumTmonot, ArrayList<String> cssValueKirtmonot) throws InterruptedException {
		System.out.println("");
		System.out.println("results for Css value Links");

		String[] CssValueLinkAlbumTmonot = { "\"ploni medium\", sans-serif", "rgba(0, 0, 0, 1)"};
		String[] CssValueLinkKirTmonot = { "\"ploni medium\", sans-serif", "rgba(0, 0, 0, 1)"};
		for (int i = 0; i < cssValueAlbumTmonot.size(); i++) {
      assertEquals(CssValueLinkAlbumTmonot[i],cssValueAlbumTmonot.get(i));
      assertEquals(CssValueLinkKirTmonot[i], cssValueKirtmonot.get(i));
		}
		System.out.println("test passed");
	}

	static public void checkingCssValueOfTextAndBackroundDiscount(int[] location, String ColorText,
			String ColorBackround) throws InterruptedException {
		System.out.println(" ");
		System.out.println("the results for test cssValueDiscound");
		int[] locationOf = new int[] { 71, 77, 45, 66 };
		String[] name = { "Xtext", "Ytext" };
		String[] name1 = { "Xbackround", "Ybackround" };
		String textColor = "rgba(0, 0, 0, 1)";
		String backroundColor = "rgba(187, 220, 218, 1)";

		int a = 0;
		int b = 0;
		for (int i = 0; i < 2; i++) {
			if (location[i] == locationOf[i]) {
				System.out.println("location of " + name[a] + " is in place");
			} else {
				Thread.sleep(300);
				System.err.println("location of " + name[a] + " is wrong");
			}
			a++;
		}
		for (int i = 2; i < 4; i++) {
			if (location[i] == locationOf[i]) {
				System.out.println("location of " + name1[b] + " is in place");
			} else {
				Thread.sleep(300);
				System.err.println("location of " + name1[b] + " is wrong");
			}
			b++;
		}

		if (ColorText.equals(textColor)) {
			System.out.println("color of the text is right");
		} else {
			Thread.sleep(300);
			System.err.println("color of the text is wrong");
		}
		if (ColorBackround.equals(backroundColor)) {
			System.out.println("color of the backround is right");
		} else {
			Thread.sleep(300);
			System.err.println("color of the backround is right");
		}
	}
}
