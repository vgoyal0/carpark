package com.gojek.carpark.commands;

import com.gojek.carpark.MultiLevelCarParkingLot;
import com.gojek.carpark.Parser;

/**
 * Implementation for "create_parking" command
 * 
 * @author VGoyal
 */
public class CreateParking implements Command {
	private int size;
	private Parser parser;

	public CreateParking(Parser parser, int size) {
		this.parser = parser;
		this.size = size;
	}

	@Override
	public void execute() {
		if (parser.getParkingLot() == null) {

			parser.setParkingLot(new MultiLevelCarParkingLot(size));
			System.out.println("Created a parking lot with " + size + " slots");
		} else {
			System.out.println("Parking lot is already created! You can't modify the parking lot once created");
		}
	}
}
