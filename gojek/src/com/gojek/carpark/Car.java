package com.gojek.carpark;

/**
 * Implementation of a car
 * 
 * @author VGoyal
 */
public class Car {
	private int slotNumber;
	private String registrationNumber;
	private String color;

	public Car(String registrationNumber, String color) {
		this.registrationNumber = registrationNumber;
		this.color = color;
	}

	/**
	 * Park the car at a given slot number in the parking lot
	 * 
	 * @param parkingLot
	 * @param slotNumber
	 */
	public void park(ParkingLot parkingLot, int slotNumber) {
		this.slotNumber = slotNumber;
		parkingLot.addCar(this);
	}

	/**
	 * Leave the parking lot
	 * 
	 * @param parkingLot
	 */
	public void leave(ParkingLot parkingLot) {
		parkingLot.removeCar(slotNumber);
	}

	/**
	 * Getter for registration number of car
	 * 
	 * @return
	 */
	public String getRegistrationNumber() {
		return registrationNumber;
	}

	/**
	 * Setter for registration number of car
	 * 
	 * @param registrationNumber
	 */
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	/**
	 * Getter for color of car
	 * 
	 * @return
	 */
	public String getColor() {
		return color;
	}

	/**
	 * Setter for color of car
	 * 
	 * @param color
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * Getter for slot number of car in parking lot
	 * 
	 * @return
	 */
	public int getSlotNumber() {
		return slotNumber;
	}

	/**
	 * Setter for slot number of car in parking lot
	 * 
	 * @param slotNumber
	 */
	public void setSlotNumber(int slotNumber) {
		this.slotNumber = slotNumber;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return slotNumber + "\t\t\t\t" + registrationNumber + "\t\t" + color;
	}
}
