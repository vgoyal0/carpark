package com.gojek.carpark.commands;

import com.gojek.carpark.Car;
import com.gojek.carpark.ParkingLot;

/**
 * Implementation for "park" command
 * 
 * @author VGoyal
 */
public class Park implements Command {

	private ParkingLot theParkingLot;
	private Car carToAdd;

	public Park(ParkingLot newParkingLot, Car newCar) {
		theParkingLot = newParkingLot;
		carToAdd = newCar;
	}

	@Override
	public void execute() {
		int emptySlot = theParkingLot.getEmptySlotNumber();
		if (emptySlot == -1) {
			System.out.println("Sorry, parking lot is full");
			return;
		}
		carToAdd.park(theParkingLot, emptySlot);
		System.out.println("Allocated slot number: " + emptySlot);
	}

}
