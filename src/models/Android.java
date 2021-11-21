package models;

public class Android extends Phone {

	//Variables
	private String manufacturer;
	
	//Constructors
	public Android() { super(); }
	
	public Android(String name, int releaseYear, double cost, String manufacturer) {
		super(name, releaseYear, cost);
		this.manufacturer = manufacturer;
	}

	//Getters
	public String getManufacturer() {
		return manufacturer;
	}

	//Setters
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	@Override
	public String toString() {
		return super.toString() + String.format("%10s", manufacturer);
	}
	
}
