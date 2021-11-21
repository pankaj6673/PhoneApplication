package services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import models.Android;
import models.Iphone;
import models.Phone;

import java.util.Comparator;

public class PhoneService {
	
	private Scanner scanner = new Scanner(System.in);
	
	public ArrayList<Android> getAndroidList() {
		
		ArrayList<Android> output = new ArrayList<Android>();
		
		output.add(new Android("Samsung A3", 2016, 80.0, "Samsung"));
		output.add(new Android("Google Pixel 3", 2018, 739, "Google"));
		output.add(new Android("Samsung Galaxy S9", 2018, 780, "Galaxy"));
		output.add(new Android("Razer Phone 2", 2018, 779, "Razer"));
		output.add(new Android("Xiaomi Mi 8 Pro", 2018, 499, "Xiaomi"));
		
		return output;
	}
	
	public ArrayList<Iphone> getIphoneList() {
		
		ArrayList<Iphone> output = new ArrayList<Iphone>();
		
		output.add(new Iphone("Iphone 5", 2012, 105.0));
		output.add(new Iphone("Iphone 6s", 2015, 245.0));
		output.add(new Iphone("Iphone 7", 2016, 298.99));
		output.add(new Iphone("Iphone 8", 2017, 849.0));
		output.add(new Iphone("Iphone XS", 2018, 949.0));
		
		return output;
	}

	//Combines both List of Phones to display to the User.
	public ArrayList<Phone> combinePhoneLists(ArrayList<Android> androidList, ArrayList<Iphone> iphoneList) {
		ArrayList<Phone> output = new ArrayList<Phone>();
		
		output.addAll(androidList);
		output.addAll(iphoneList);
		
		return output;
	}
	
	//Prints out The passed Phone List. 
	//Calls Overridden toString() methods to get dynamic formatting.
	public void printPhoneList(ArrayList<Phone> phoneList) {
		int index = 1;
		for(Phone phone : phoneList) {
			String itemNumber = String.format("%1d)", index);
			System.out.println(itemNumber + phone);
			index++;
		}
	}

	public void searchByReleaseYear(ArrayList<Phone> phoneList, int year) {
		int index = 1;
		for(Phone phone : phoneList) {
			if(phone.getReleaseYear() == year) {
				String itemNumber = String.format("%1d)", index);
				System.out.println(itemNumber + phone);
				index++;
			}
		}
	}

	
	public void sortByReleaseYear(ArrayList<Phone> phoneList) {
		Collections.sort(phoneList, new Comparator<Phone>() {
			public int compare(Phone p1, Phone p2) {
				return Integer.valueOf(p1.getReleaseYear()).compareTo(p2.getReleaseYear());
			}
		});
		
		int index = 1;
		for(Phone phone : phoneList) {
			String itemNumber = String.format("%1d)", index);
			System.out.println(itemNumber + phone);
			index++;
		}
	}

	public void sortByCost(ArrayList<Phone> phoneList) {
		Collections.sort(phoneList, new Comparator<Phone>() {
			public int compare(Phone p1, Phone p2) {
				return Double.valueOf(p1.getCost()).compareTo(p2.getCost());
			}
		});
		
		int index = 1;
		for(Phone phone : phoneList) {
			String itemNumber = String.format("%1d)", index);
			System.out.println(itemNumber + phone);
			index++;
		}
		
	}
	
	
	public void addIPhone(ArrayList<Iphone> iPhoneList) {
		Iphone newIphone = new Iphone();
		
		System.out.print("Enter iphone name: ");
		newIphone.setName(scanner.next());
		System.out.print("Enter iphone release year: ");
		newIphone.setReleaseYear(scanner.nextInt());
		System.out.print("Enter phone cost: ");
		newIphone.setCost(scanner.nextDouble());
		
		iPhoneList.add(newIphone);
	}
	
	public void addAndroid(ArrayList<Android> androidList) {
		Android newAndroid = new Android();
		
		System.out.print("Enter phone name: ");
		newAndroid.setName(scanner.next());
		System.out.print("Enter phone release year: ");
		newAndroid.setReleaseYear(scanner.nextInt());
		System.out.print("Enter phone manufacturer: ");
		newAndroid.setManufacturer(scanner.next());
		System.out.print("Enter phone cost: ");
		newAndroid.setCost(scanner.nextDouble());
		
		androidList.add(newAndroid);
	}
	
	
	public void editIphone(ArrayList<Iphone> iPhoneList, int phoneNum) {
		int index = phoneNum - 1;
		System.out.print("Enter new name: ");
		iPhoneList.get(index).setName(scanner.next());
		System.out.print("Enter new release year: ");
		iPhoneList.get(index).setReleaseYear(scanner.nextInt());
		System.out.print("Enter new cost: ");
		iPhoneList.get(index).setCost(scanner.nextDouble());
	}
	
	public void editAndroid(ArrayList<Android> androidList, int phoneNum) {
		int index = phoneNum - 1;
		System.out.print("Enter new name: ");
		androidList.get(index).setName(scanner.next());
		System.out.print("Enter new release year: ");
		androidList.get(index).setReleaseYear(scanner.nextInt());
		System.out.print("Enter new manufacture: ");
		androidList.get(index).setManufacturer(scanner.next());
		System.out.print("Enter new cost: ");
		androidList.get(index).setCost(scanner.nextDouble());
	}
	
	
	public void deleteIphone(ArrayList<Iphone> iPhoneList, int phoneNum) {
		int index = phoneNum - 1;
		iPhoneList.remove(index);
	}
	
	public void deleteAndroid(ArrayList<Android> androidList, int phoneNum) {
		int index = phoneNum - 1;
		androidList.remove(index);
	}

}
