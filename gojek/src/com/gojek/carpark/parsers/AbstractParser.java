package com.gojek.carpark.parsers;

import java.util.Arrays;

import com.gojek.carpark.ParkingLot;
import com.gojek.carpark.Parser;
import com.gojek.carpark.commands.Command;
import com.gojek.carpark.commands.CommandFactory;

/**
 * Abstract Parser class is parent of all different parsers
 * 
 * @author VGoyal
 */
public abstract class AbstractParser implements Parser {

	private ParkingLot parkingLot;

	/**
	 * This method's responsibility is to take the command string and execute it
	 * 
	 * @param commandStr
	 */
	protected void processCommand(String commandStr) {

		if (commandStr != null && !commandStr.isEmpty()) {

			String[] commandArray = commandStr.split(" ");
			String commandType = commandArray[0];
			String[] arrguments = null;
			if (commandArray.length > 1) {
				arrguments = Arrays.copyOfRange(commandArray, 1, commandArray.length);
			}
			Command command = CommandFactory.getCommand(commandType, arrguments, this);
			command.execute();

		}

	}
    
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gojek.carpark.Parser#getParkingLot()
	 */
	public ParkingLot getParkingLot() {
		return this.parkingLot;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gojek.carpark.Parser#setParkingLot(com.gojek.carpark.ParkingLot)
	 */
	public void setParkingLot(ParkingLot parkingLot) {
		this.parkingLot = parkingLot;
	}
}
