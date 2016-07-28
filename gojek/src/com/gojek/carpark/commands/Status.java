package com.gojek.carpark.commands;

import com.gojek.carpark.ParkingLot;

/**
 * Implementation of "Status" command
 * 
 * @author VGoyal
 */
public class Status implements Command {

	private ParkingLot theParkingLot;

	public Status(ParkingLot newParkingLot) {
		theParkingLot = newParkingLot;
	}

	@Override
	public void execute() {
		System.out.println("Slot No." + "\t\t" + "Registration No" + "\t\t" + "Color");
		System.out.println("=========================================");
		theParkingLot.status();
		System.out.println("=========================================");
	}

}
