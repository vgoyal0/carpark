package com.gojek.carpark.commands;

import com.gojek.carpark.Car;
import com.gojek.carpark.Parser;

/**
 * Factory class for getting a command implementation based on user input
 * 
 * @author VGoyal
 */
public class CommandFactory {

	/**
	 * Command constants
	 * 
	 * @author VGoyal
	 */
	public interface COMMANDS {
		String CREATE_PARKING_LOT = "create_parking_lot";
		String PARK = "park";
		String LEAVE = "leave";
		String STATUS = "status";
		String REGISTRATION_NUMBERS_FOR_CARS_WITH_COLOUR = "registration_numbers_for_cars_with_colour";
		String SLOT_NUMBERS_FOR_CARS_WITH_COLOUR = "slot_numbers_for_cars_with_colour";
		String SLOT_NUMBER_FOR_REGISTRATION_NUMBER = "slot_number_for_registration_number";
	}

	/**
	 * Factory method to instantiate commands
	 * 
	 * @param commandType
	 * @param arguments
	 * @param parser
	 * @return
	 */
	public static Command getCommand(String commandType, String[] arguments, Parser parser) {

		switch (commandType) {

		case COMMANDS.CREATE_PARKING_LOT:
			if (arguments == null || arguments.length < 1 || arguments.length > 1 || !arguments[0].matches("\\d+")) 
				throw new IllegalArgumentException("Invalid arguments passed to the command");
			return new CreateParking(parser, Integer.parseInt(arguments[0]));

		case COMMANDS.PARK:
			if (arguments == null || arguments.length < 2 || arguments.length > 2)
				throw new IllegalArgumentException("Invalid arguments passed to the command");
			Car newCar = new Car(arguments[0], arguments[1]);
			return new Park(parser.getParkingLot(), newCar);

		case COMMANDS.LEAVE:
			if (arguments == null || arguments.length < 1 || arguments.length > 1 || !arguments[0].matches("\\d+"))
				throw new IllegalArgumentException("Invalid arguments passed to the command");
			return new Leave(parser.getParkingLot(), Integer.parseInt(arguments[0]));

		case COMMANDS.STATUS:
			return new Status(parser.getParkingLot());

		case COMMANDS.REGISTRATION_NUMBERS_FOR_CARS_WITH_COLOUR:
			if (arguments == null || arguments.length < 1 || arguments.length > 1)
				throw new IllegalArgumentException("Invalid arguments passed to the command");
			return new Search(parser.getParkingLot(), arguments[0],
					Search.CommandType.REGISTRATION_NUMBERS_FOR_CARS_WITH_COLOUR);

		case COMMANDS.SLOT_NUMBER_FOR_REGISTRATION_NUMBER:
			if (arguments == null || arguments.length < 1 || arguments.length > 1)
				throw new IllegalArgumentException("Invalid arguments passed to the command");
			return new Search(parser.getParkingLot(), arguments[0],
					Search.CommandType.SLOT_NUMBER_FOR_REGISTRATION_NUMBER);

		case COMMANDS.SLOT_NUMBERS_FOR_CARS_WITH_COLOUR:
			if (arguments == null || arguments.length < 1 || arguments.length > 1)
				throw new IllegalArgumentException("Invalid arguments passed to the command");
			return new Search(parser.getParkingLot(), arguments[0],
					Search.CommandType.SLOT_NUMBERS_FOR_CARS_WITH_COLOUR);

		default:
			return new Dummy("'" + commandType + "' operation is not supported yet! Try something else");

		}

	}
}
