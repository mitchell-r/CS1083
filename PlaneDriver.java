/**
	Represents a Plane Driver.
	@author Mitchell Rogers - 3606091
	Assignment #1
	Java 1083
	Leah Bidlake
*/

import java.text.*;

public class PlaneDriver{

	public static void main(String[] args){
		
		DecimalFormat form1 = new DecimalFormat("#.00");
		Plane plane1 = new Plane(3, 250);
		
		Passenger p1 = new Passenger("Fred", 54.50, 58.00);
		Passenger p2 = new Passenger("Charlie", 33.00, 10.30);
		Passenger p3 = new Passenger("Suzie", 56.50, 36.50);
		Passenger p4 = new Passenger("Mitchell", 63.52, 15.23);
		Passenger p5 = new Passenger("Bob", 123.124, 127.623);
		
		plane1.addPassenger(p5);
		plane1.addPassenger(p1);		
		plane1.addPassenger(p2);
		plane1.addPassenger(p3);
		plane1.addPassenger(p3);
		plane1.addPassenger(p4);
		
		plane1.removePassenger(p2);
		
		plane1.updateLuggage(p1, 115.00);
		plane1.updateLuggage(p1, 44.00);
		
		System.out.println("\nCurrent passengers:\n" + plane1);
		
		System.out.println("\nThere is: " + form1.format(plane1.getMaxWeight() - plane1.getCurrentWeight()) + "kg left before the plane is full");
	}
}