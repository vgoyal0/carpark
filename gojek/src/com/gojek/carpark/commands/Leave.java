package com.gojek.carpark.commands;

import com.gojek.carpark.ParkingLot;

/**
 * Implementation for "leave" command
 * 
 * @author VGoyal
 */
public class Leave implements Command {

	private ParkingLot theParkingLot;
	private int slotToRemove;

	public Leave(ParkingLot newParkingLot, int slotNum) {
		theParkingLot = newParkingLot;
		slotToRemove = slotNum;
	}

	@Override
	public void execute() {
		if (theParkingLot.removeCar(slotToRemove))
			System.out.println("Slot number " + slotToRemove + " is free");
		else
			System.out.println("No car at this slot!");
	}

}
