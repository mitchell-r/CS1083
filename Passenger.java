/**
	Represents a Passenger Object.
	@author Mitchell Rogers - 3606091
	Assignment #1
	Java 1083
	Leah Bidlake
*/
public class Passenger{

	private static int id = 1000;
	private String name;
	private double weight;
	private double luggage;
	private int passID;
	
	public Passenger(String name, double weight, double luggage){
		this.name = name;
		this.weight = weight;
		this.luggage = luggage;
		passID = id;
		id++;
	}
	
	public String getName(){
		return name;
	}
	
	public double getWeight(){
		return weight;
	}
	
	public double getLuggage(){
		return luggage;
	}
	
	public double getTotalWeight(){
		return luggage + weight;
	}
	
	public int getID(){
		return passID;
	}
	
	public void setLuggage(double dataIn){
		luggage = dataIn;
	}
	
}