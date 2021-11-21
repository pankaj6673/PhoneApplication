package services;

import java.util.ArrayList;
import java.util.Scanner;
import models.Android;
import models.Iphone;
import models.Phone;

public class AppService {
	
	private Scanner scanner = new Scanner(System.in);
	private PhoneService phoneService = new PhoneService();

	public void welcomeUser() {
		System.out.println("+--------------------------------+");
		System.out.println("|  Welcome to PhonoMania Store   |");
		System.out.println("+--------------------------------+");
	}
	
	public void printMenuOptions() {
		System.out.println("\n1.Display Phones");
		System.out.println("2.Search Phone");
		System.out.println("3.Add Phone");
		System.out.println("4.Edit Phone");
		System.out.println("5.Delete Phone");
		System.out.println("6.Sort Phones");
		System.out.println("7.Quit \n");
	}
	
	public void selectPhoneToPrint(ArrayList<Iphone> iPhoneList, ArrayList<Android> androidList) {
		System.out.println("1.Iphone");
		System.out.println("2.Android");
		System.out.println("3.Both \n");
		System.out.print(">Choose Option: ");
		
		int value = scanner.nextInt();
		System.out.println();
		ArrayList<Phone> phoneList = new ArrayList<Phone>();
		switch(value) {
			case 1: phoneList.addAll(iPhoneList);
					phoneService.printPhoneList(phoneList);
					break;
					
			case 2: phoneList.addAll(androidList);
					phoneService.printPhoneList(phoneList);
					break;
					
			case 3: phoneList.addAll(androidList);
					phoneList.addAll(iPhoneList);
					phoneService.printPhoneList(phoneList);
					break;
		}
	}

	public void addPhoneToList(ArrayList<Iphone> iPhoneList, ArrayList<Android> androidList) {
		System.out.println("1.Iphone");
		System.out.println("2.Android \n");
		System.out.print(">Choose Option: ");
		
		int value = scanner.nextInt();
		switch(value) {
			case 1: phoneService.addIPhone(iPhoneList);
					System.out.println("\nPhone Added!");
					break;
					
			case 2: phoneService.addAndroid(androidList);
					System.out.println("\nPhone Added!");
					break;
		}
	}
	
	public void editPhoneInList(ArrayList<Iphone> iPhoneList, ArrayList<Android> androidList) {
		System.out.println("1.Iphone");
		System.out.println("2.Android \n");
		System.out.print(">Choose Option: ");
		
		int value = scanner.nextInt();
		ArrayList<Phone> phoneList = new ArrayList<Phone>();
		switch(value) {
			case 1: phoneList.addAll(iPhoneList);
					phoneService.printPhoneList(phoneList);
					System.out.print("\n>Enter phone to Edit: ");
					int phoneNum = scanner.nextInt();
					phoneService.editIphone(iPhoneList, phoneNum);
					System.out.println("\nPhone Edited!");
					break;
					
			case 2: phoneList.addAll(androidList);
					phoneService.printPhoneList(phoneList);
					System.out.print("\n>Enter phone to Edit: ");
					int phoneNum1 = scanner.nextInt();
					phoneService.editAndroid(androidList, phoneNum1);
					System.out.println("\nPhone Edited!");
					break;
		}
	}
	
	public void deletePhoneInList(ArrayList<Iphone> iPhoneList, ArrayList<Android> androidList) {
		System.out.println("1.Iphone");
		System.out.println("2.Android \n");
		System.out.print(">Choose Option: ");
		
		int value = scanner.nextInt();
		ArrayList<Phone> phoneList = new ArrayList<Phone>();
		switch(value) {
			case 1: phoneList.addAll(iPhoneList);
					phoneService.printPhoneList(phoneList);
					System.out.print("\n>Enter phone to Delete: ");
					int phoneNum = scanner.nextInt();
					phoneService.deleteIphone(iPhoneList, phoneNum);
					System.out.println("\nPhone Deleted!");
					break;
					
			case 2: phoneList.addAll(androidList);
					phoneService.printPhoneList(phoneList);
					System.out.print("\n>Enter phone to Delete: ");
					int phoneNum1 = scanner.nextInt();
					phoneService.deleteAndroid(androidList, phoneNum1);
					System.out.println("\nPhone Deleted!");
					break;
		}
	}

	public void sortPhoneList(ArrayList<Iphone> iPhoneList, ArrayList<Android> androidList) {
		System.out.println("\n1.Sort by release year");
		System.out.println("2.Sort by cost \n");
		System.out.print(">Choose Option: ");
		
		int value = scanner.nextInt();
		System.out.println();
		ArrayList<Phone> phoneList = new ArrayList<Phone>();
		phoneList.addAll(iPhoneList);
		phoneList.addAll(androidList);
		
		switch(value) {
			case 1: System.out.println("--Sorting by Release Year--");
					phoneService.sortByReleaseYear(phoneList);
					break;
			case 2: System.out.println("--Sorting by Cost--");
					phoneService.sortByCost(phoneList);
					break;
		}
	}

	
	
	//Master Function - Switch Statement drives the application logic.
	public void selectMenuOption(ArrayList<Iphone> iPhoneList, ArrayList<Android> androidList) {
		printMenuOptions();
		System.out.print(">Choose Option: ");
		int input = scanner.nextInt();
		
		ArrayList<Phone> phoneList = new ArrayList<Phone>();
		phoneList.addAll(iPhoneList);
		phoneList.addAll(androidList);
		
		switch(input) {
			case 1: System.out.println();
					selectPhoneToPrint(iPhoneList, androidList);
					selectMenuOption(iPhoneList, androidList); 
					break;
					
			case 2: System.out.print(">Input year to search by: ");
					int year = scanner.nextInt();
					System.out.println();
					phoneService.searchByReleaseYear(phoneList, year);
					selectMenuOption(iPhoneList, androidList); 
					break;
			
			case 3: addPhoneToList(iPhoneList, androidList);
					selectMenuOption(iPhoneList, androidList); 
					break;
					
			case 4: editPhoneInList(iPhoneList, androidList);
					selectMenuOption(iPhoneList, androidList); 
					break;
					
			case 5: deletePhoneInList(iPhoneList, androidList);
					selectMenuOption(iPhoneList, androidList); 
					break;
					
			case 6: sortPhoneList(iPhoneList, androidList);
					selectMenuOption(iPhoneList, androidList); 
					
			case 7: System.out.println("--Exiting PhoneMania--");
					System.exit(0); //Quits the Application.
					
			default: System.out.println("Invalid Option");
					 selectMenuOption(iPhoneList, androidList); 
					 break;
		}
	}
	
}
