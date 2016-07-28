package com.gojek.carpark;

/**
 * Parser interface is implemented by all parsers
 * 
 * @author VGoyal
 */
public interface Parser {

	/**
	 * parses the input and processes the commands received
	 */
	public void parse();

	/**
	 * Getting for parking lot
	 * 
	 * @return
	 */
	public ParkingLot getParkingLot();

	/**
	 * Setter for parking lot
	 * 
	 * @param parkingLot
	 */
	public void setParkingLot(ParkingLot parkingLot);
}
