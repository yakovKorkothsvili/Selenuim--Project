package tools;




public class FormsFunctions {

	static public void checkTheErrorMessagesSendEmailForm(String[]err) throws InterruptedException {
		System.out.println("");
		System.out.println("results for test send email form");
		String[]Messages=new String[7];
		Messages[0]="�� ����� ����";
		Messages[1]="��� ���� ����� �����";
		Messages[2]="�������� ��� ���� ��� 2 �����";
		Messages[3]="�������� ��� ����� ��� 2 �����";
		Messages[4]="����� ���� 7 �����";
		Messages[5]="���� ������";
		Messages[6]="����� ������� ������ ���� �����.";
		
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
		messages[0]="�� ���� ����� 2 ������";
		messages[1]="�� ���� ����� 2 ������";
		messages[2]="����� ����� ���� �����";
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
		error[0]="�������� ��� ���� ��� 2 �����";
		error[1]="�������� ��� ����� ��� 2 �����";
		error[2]="��� �� ����";
		error[3]="��� ���� ������";
		error[4]="����� ���� 7 �����";
		error[5]="���� ������";
		error[6]="����� ������� ������ ���� �����.";
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
		errMessage[0]="���� ������ ���� ����";
		errMessage[1]="����� ���� �� ������ + 7 �����";
		errMessage[2]="����� ���� ���� ������";
		
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
