package com.gojek.carpark;

/**
 * Interface for parking lot implementations
 * 
 * @author VGoyal
 */
public interface ParkingLot {

	/**
	 * Add a car to the parking lot
	 * 
	 * @param car
	 */
	public void addCar(Car car);

	/**
	 * Remove the car parked at a specific slot number
	 * 
	 * @param slotToRemove
	 * @return
	 */
	public boolean removeCar(int slotToRemove);

	/**
	 * Display the current status of parking lot
	 */
	public void status();

	/**
	 * Get a empty slot in the parking lot
	 * 
	 * @return
	 */
	public int getEmptySlotNumber();

	/**
	 * Returns the car at a specificed slot
	 * 
	 * @param slotNumber
	 * @return
	 */
	public Car getCar(int slotNumber);

	/**
	 * Get the slot number for a car with a given registration number
	 * 
	 * @param registrationNumber
	 * @return
	 */
	public String getSlotNumberForRegistrationNumber(String registrationNumber);

	/**
	 * Get slot numbers of all car of a particular color in the parking lot
	 * 
	 * @param color
	 * @return
	 */
	public String getSlotNumbersForCarsWithColour(String color);

	/**
	 * Get registration numbers of all car of a particular color in the parking
	 * lot
	 * 
	 * @param color
	 * @return
	 */
	public String getRegistrationNumbersForCarsWithColour(String color);
}
