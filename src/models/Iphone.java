package models;

public class Iphone extends Phone {

	//Variables
	private String manufacturer = "Apple";
	
	//Constructors
	public Iphone() { super(); }
	
	public Iphone(String name, int releaseYear, double cost) {
		super(name, releaseYear, cost);
	}

	//Getters
	public String getManufacturer() {
		return manufacturer;
	}

	@Override
	public String toString() {
		return super.toString() + String.format("%10s", manufacturer);
	}
	
}
