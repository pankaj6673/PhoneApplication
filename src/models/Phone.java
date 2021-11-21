package models;

public class Phone {
	
	//Variables
	private String name;
	private int releaseYear;
	private double cost;
	
	//Constructors
	public Phone() {}
	
	public Phone(String name, int releaseYear, double cost) {
		this.name = name;
		this.releaseYear = releaseYear;
		this.cost = cost;
	}
	
	//Getters
	public String getName() {
		return name;
	}
	
	public int getReleaseYear() {
		return releaseYear;
	}
	
	public double getCost() {
		return cost;
	}
	
	//Setters
	public void setName(String name) {
		this.name = name;
	}
	
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	//Overridden Functions
	@Override
	public String toString() {
		String displayCost = "£" + String.format("%.2f", cost);
		return String.format("%20s %8d %10s", name, releaseYear, displayCost);
	}
	
}
