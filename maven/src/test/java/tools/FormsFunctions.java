package tools;




public class FormsFunctions {

	static public void checkTheErrorMessagesSendEmailForm(String[]err) throws InterruptedException {
		System.out.println("");
		System.out.println("results for test send email form");
		String[]Messages=new String[7];
		Messages[0]="יש לבחור נושא";
		Messages[1]="חסר תוכן לנושא הפניה";
		Messages[2]="המינימום לשם פרטי הוא 2 אותית";
		Messages[3]="המינימום לשם משפחה הוא 2 אותית";
		Messages[4]="טלפון מכיל 7 ספרות";
		Messages[5]="חסרה קידומת";
		Messages[6]="כתובת האימייל שהוזנה אינה תקינה.";
		
		for (int i = 0; i < Messages.length; i++) {
			if (err[i].equals(Messages[i])) {
				System.out.println("error message "+Messages[i]+" is visible");
			}
			else {
				Thread.sleep(200);
				System.err.println("error message "+Messages[i]+" is NOT visible");
			}
		}
	}
	
	static public void checkingTheErrorMessagesContatMeForm(String [] ERRORMES) throws InterruptedException {
		System.out.println("");
		System.out.println("results for test contactMeForm");
		String[]messages=new String[ERRORMES.length];
		messages[0]="שם מכיל לפחות 2 אותיות";
		messages[1]="שם מכיל לפחות 2 אותיות";
		messages[2]="כתובת המייל אינה חוקית";
		for (int i = 0; i < messages.length; i++) {
			if (ERRORMES[i].equals(messages[i])) {
				System.out.println("error message "+messages[i]+" is visible");
			}
			else {
				Thread.sleep(300);
				System.err.println("error message "+messages[i]+" is NOT visible");
			}
		}
	}
	
	public static void checkingErrorMessagesFormLetTalkAboutIt(String[]ERROR) throws InterruptedException {
		System.out.println("");
		System.out.println("results for test LetTalkAboutItForm");
		String[]error=new String[ERROR.length];
		error[0]="המינימום לשם פרטי הוא 2 אותית";
		error[1]="המינימום לשם משפחה הוא 2 אותית";
		error[2]="חסר שם חברה";
		error[3]="חסר מספר עובדים";
		error[4]="טלפון מכיל 7 ספרות";
		error[5]="חסרה קידומת";
		error[6]="כתובת האימייל שהוזנה אינה תקינה.";
		for (int i = 0; i < error.length; i++) {
			if (ERROR[i].equals(error[i])) {
				System.out.println("error message "+error[i]+" is visible");
			}
			else {
				Thread.sleep(300);
				System.err.println("error message "+error[i]+" is NOT visible");
			}
		}
	}
	
	static public void checkingErrorMessagesFormFollowOrder(String errorOrderId, String errorPhoneField, String errorPhoneField1) throws InterruptedException{
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
				Thread.sleep(300);
				System.err.println("somthing went wrong in error message "+errMessage[i]);
			}
		}
	}


	
}
