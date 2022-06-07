package tools;

public class E2EFunctions {

	static public void designCheck(String harzlDesign, String mosahDesign) throws InterruptedException {
		System.out.println("");
		System.out.println("results for edit pics");
		if (harzlDesign.equals("divImgOptionMainBlack")) {
			System.out.println("the design for the harzl pic has been picked");
		} else {
			Thread.sleep(300);
			System.err.println("somthing went wrong with picking the design for harzl");
		}

		if (mosahDesign.equals("cursor: grab; width: 450px; height: 450px; display: none;")) {
			System.out.println("the design for mosah pic has been picked");
		} else {
			Thread.sleep(300);
			System.out.println("somthing went wrong in picking the design for mosah pic");
		}
	}

}
