package tools;

import java.util.List;

public class LinksFunctions {
	static public void CheckingIfTheTestGotToTheRightURLs(String[] url, List<String>LinksNames) throws InterruptedException {
		
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
	
	static public void LinksBottomOfThePageCheckingTheUrls(String[]Url) throws InterruptedException {
		String[]URLS=new String[Url.length];
		System.out.println("");
		System.out.println("results for test Links Tests Menu Bottom Of The Page");
		URLS[0]="https://www.lupa.co.il/products/digital-album/";
		URLS[1]="https://www.lupa.co.il/lupa-squared/tiles/";
		URLS[2]="https://www.lupa.co.il/themes/hagadda/";
		URLS[3]="https://www.lupa.co.il/products/calendars/";
		URLS[4]="https://www.lupa.co.il/platform/app-calendar-skins/";
		URLS[5]="https://www.lupa.co.il/products/photo-books/";
		URLS[6]="https://www.lupa.co.il/products/layflat/";
		URLS[7]="https://www.lupa.co.il/products/woodprint/";
		URLS[8]="https://www.lupa.co.il/products/photo-prints/";
		URLS[9]="https://www.lupa.co.il/products/canvas/";
		URLS[10]="https://www.lupa.co.il/platform/gift-package/";
		URLS[11]="https://www.lupa.co.il/platform/stickers/";
		URLS[12]="https://www.lupa.co.il/platform/familyday/";
		URLS[13]="https://www.lupa.co.il/platform/passovergifts/";
		for (int i = 0; i < Url.length; i++) {
			if (Url[i].equals(URLS[i])) {
				System.out.println("menu ' מוצרים ' Link number "+i+" is working");
			}
			else {
				Thread.sleep(300);
				System.err.println("menu ' מוצרים ' Link number "+i+"is Not working");
			}
		}
	}
}
