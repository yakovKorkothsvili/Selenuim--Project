package tools;

import java.util.ArrayList;

public class AccountTestFunctions {
	static public void checkingConnctionToFacebook(String name) throws InterruptedException {
		System.out.println(" ");
		System.out.println("results for connction to facebook");
		if (name.contains("���� John")||name.contains("���� yakov")) {
			System.out.println("the account has been connected with facebook");
		}
		else {
			Thread.sleep(300);
			System.err.println("the account didnt connect");
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
	
	static public void checkingErrorMesAccount(ArrayList<String>errMes) throws InterruptedException {
		System.out.println(" ");
		System.out.println("results for error message creating account");
		String []errorMes= new String[errMes.size()];
		errorMes[0]="�� ���� �� ���� ����� �����";
		errorMes[1]="�� �� ������. ��� �� ������� �� 2 ������ ���";
		errorMes[2]="hopa@lupa.co.il ����� ������ ���� �����";
		errorMes[3]="����� ����� ���� �� 10 �����";
		errorMes[4]="�������� ���, ��� ����� �� 6 ������ ������� ������";
		errorMes[5]="�� ���� �� ������";
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
	
	static public void checkingIfTheNameEmailIsRight(String name, String email) throws InterruptedException {
		System.out.println("");
		System.out.println("results for connectToFacebookThroughChat");
		if (name.equals("John Smhoni")&& email.equals("jsmhoni@gmail.com")) {
			System.out.println("the connection to facebook through chat is working");
		}		
		else {
			Thread.sleep(300);
			System.err.println("something went wrong");
		}
		
	}
	
	static public void CheckingTheSearchResults(ArrayList<String>REsults) throws InterruptedException {
		System.out.println("");
		System.out.println("results for test 'Search Results'");
		String[]LinksNames=new String[9];
		LinksNames[1]="����� ������ ����� ����";
		LinksNames[0]="����� ����� �����";
		LinksNames[2]="����� ���� ������ ����� ����� ���";
		LinksNames[3]="����� ���� ������� ����� ����� ���";
		LinksNames[4]="��� ����� ���� ������";
		LinksNames[5]="����� ��� ��������� - �����";
		LinksNames[6]="����� ����� ���� - �����";
		LinksNames[7]="����� ��� ������ �����";
		LinksNames[8]="����� ������ �� ���� ����� ������";
		for (int i = 0; i < REsults.size(); i++) {
			if (REsults.get(i).equals(LinksNames[i])) {
				System.out.println("result "+LinksNames[i]+" is in place");
			}	
			else {
				Thread.sleep(100);
				System.err.println("result "+LinksNames[i]+" is not in place");
			}
		}
	}
}
