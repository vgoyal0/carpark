package com.gojek.carpark.commands;

import com.gojek.carpark.ParkingLot;

/**
 * Implementation for various search commands
 * 
 * @author VGoyal
 */
public class Search implements Command {

	enum CommandType {
		SLOT_NUMBERS_FOR_CARS_WITH_COLOUR, SLOT_NUMBER_FOR_REGISTRATION_NUMBER, REGISTRATION_NUMBERS_FOR_CARS_WITH_COLOUR;
	}

	private ParkingLot theParkingLot;
	private String searchParam;
	private CommandType commandType;

	public Search(ParkingLot newParkingLot, String searchParam, CommandType commandType) {
		this.theParkingLot = newParkingLot;
		this.searchParam = searchParam;
		this.commandType = commandType;
	}

	@Override
	public void execute() {
		switch(commandType){
		case SLOT_NUMBERS_FOR_CARS_WITH_COLOUR:
			System.out.println(theParkingLot.getSlotNumbersForCarsWithColour(searchParam));
			break;
		case SLOT_NUMBER_FOR_REGISTRATION_NUMBER:
			System.out.println(theParkingLot.getSlotNumberForRegistrationNumber(searchParam));
			break;
		case REGISTRATION_NUMBERS_FOR_CARS_WITH_COLOUR:
			System.out.println(theParkingLot.getRegistrationNumbersForCarsWithColour(searchParam));
			break;
		}
	}

}
