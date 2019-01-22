/**
	Represents a Plane object that holds passengers in a Passenger array.
	@author Mitchell Rogers - 3606091
	Assignment #1
	Java 1083
	Leah Bidlake
*/

import java.text.*;

public class Plane{
	DecimalFormat form1 = new DecimalFormat("#.00");
	
	private int maxPeople;
	private double maxWeight;
	private Passenger[] Plane = new Passenger[1];
	private int companion = 0;
	private double currentWeight = 0;
	
	public Plane(int maxPeople, double maxWeight){
		this.maxPeople = maxPeople;
		this.maxWeight = maxWeight;
		Passenger[] temp = new Passenger[maxPeople];
		Plane = temp;
	}
	
	public boolean addPassenger(Passenger dataIn){
		boolean result = false;
		boolean found = false;
		
		if(findPassenger(dataIn) >= 0){
			System.out.println(dataIn.getName() + " is already on the plane. (you cannot add the same person twice)");
			found = true;
		}
		
		else if(companion == Plane.length){
			System.out.println(dataIn.getName() + " is not allowed on the plane. (the plane is at full capacity)");
		}
		
		else if(currentWeight+dataIn.getTotalWeight() >= maxWeight){
			System.out.println(dataIn.getName() + " is not allowed on the plane. (you cannot go over the max weight)");
		}
		
		if(companion < maxPeople && currentWeight+dataIn.getTotalWeight() <= maxWeight && !found){
			this.Plane[companion] = dataIn;
			currentWeight += dataIn.getTotalWeight();
			companion++;
			result = true;
			System.out.println(dataIn.getName() + " has boarded the plane. (passenger added)");
		}
		return result;
	}
	
	public boolean removePassenger(Passenger dataIn){
		int foundAt = -1;
		boolean found = false;
		boolean result = false;
		
		if(findPassenger(dataIn) >= 0){
			foundAt = findPassenger(dataIn);
			currentWeight -= dataIn.getTotalWeight();
			Plane[foundAt] = Plane[companion-1];
			System.out.println(dataIn.getName() + " has got off the plane. (passenger removed)");
			companion--;
			result = true;
		}
		
		return result;
	}
	
	public int findPassenger(Passenger dataIn){
		int foundAt = -1;
		boolean found = false;
		
		for(int i = 0; i < companion && !found; i++){
			if(Plane[i].getID() == dataIn.getID()){
				found = true;
				foundAt = i;
			}
		}
		return foundAt;
	}
	
	public boolean updateLuggage(Passenger dataIn, double newWeight){
		boolean result = false;
		if(currentWeight + newWeight - dataIn.getLuggage() <= maxWeight){
			currentWeight = currentWeight - dataIn.getLuggage() + newWeight;
			dataIn.setLuggage(newWeight);
			result = true;
			System.out.println(dataIn.getName() + "'s luggage has been updated to: " + form1.format(newWeight) + "kg");
		}
		if(!result){
			System.out.println(dataIn.getName() + " can not increase their luggage by this amount due to the weight limit of the plane.\n" + dataIn.getName() + " can only increase their luggage by: " + form1.format(maxWeight-currentWeight) + "kg");
		}
		return result;
	}
	
	public String toString(){
		String temp = "";
		for(int i = 0; i < companion; i++){
			temp += Plane[i].getID() + "\t" + Plane[i].getName() + "\t" + form1.format(Plane[i].getTotalWeight()) + "kg\n";
		}
		temp += "\nTotal weight:\t" + form1.format(currentWeight) + "kg";
		return temp;
	}
	
	public double getMaxWeight(){
		return maxWeight;
	}
	
	public double getCurrentWeight(){
		return currentWeight;
	}
}