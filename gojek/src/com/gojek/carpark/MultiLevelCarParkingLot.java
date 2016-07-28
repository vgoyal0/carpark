package com.gojek.carpark;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * An implementation for multi­storey parking lot that can hold up to 'n' cars
 * at any given point in time. Each slot is given a number starting at 1
 * increasing with increasing distance from the entry point in steps of one. The
 * customer is allocated a parking slot which is nearest to the entry
 * 
 * @author VGoyal
 */
public class MultiLevelCarParkingLot implements ParkingLot {
	private Car[] slots;
	private int nearestEmptyCar;
	private int totalCarsInParking;

	public MultiLevelCarParkingLot(int size) {

		slots = new Car[size];
		nearestEmptyCar = 1;
		totalCarsInParking = 0;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gojek.carpark.ParkingLot#getEmptySlotNumber()
	 */
	public int getEmptySlotNumber() {

		if (nearestEmptyCar <= slots.length)
			return nearestEmptyCar;
		return -1;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gojek.carpark.ParkingLot#addCar(com.gojek.carpark.Car)
	 */
	public void addCar(Car car) {

		int slotNumber = car.getSlotNumber() - 1;
		slots[slotNumber] = car;
		totalCarsInParking++;
		while (slotNumber < slots.length) {

			if (slots[slotNumber] == null) {
				break;
			}
			slotNumber++;

		}
		nearestEmptyCar = slotNumber + 1;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gojek.carpark.ParkingLot#removeCar(int)
	 */
	public boolean removeCar(int slotNumber) {

		boolean wasRemoved = false;
		if (slots[slotNumber - 1] != null) {

			slots[slotNumber - 1] = null;
			wasRemoved = true;
			totalCarsInParking--;

		}
		if (slotNumber < nearestEmptyCar) {
			nearestEmptyCar = slotNumber;
		}
		return wasRemoved;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gojek.carpark.ParkingLot#status()
	 */
	public void status() {

		if (totalCarsInParking != 0) {

			for (Car car : slots) {

				if (car != null) {
					System.out.println(car);
				}

			}

		} else {
			System.out.println("No data to display");
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.gojek.carpark.ParkingLot#getRegistrationNumbersForCarsWithColour(java
	 * .lang.String)
	 */
	public String getRegistrationNumbersForCarsWithColour(String color) {
		
		return Arrays.asList(slots).parallelStream()
				.filter(t -> t != null && t.getColor().equalsIgnoreCase(color))
				.map(Car::getRegistrationNumber)
				.collect(Collectors.joining(", "));
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.gojek.carpark.ParkingLot#getSlotNumbersForCarsWithColour(java.lang.
	 * String)
	 */
	public String getSlotNumbersForCarsWithColour(String color) {

		List<Integer> slotNumbers = Arrays.asList(slots).parallelStream()
				.filter(t -> t != null && t.getColor().equalsIgnoreCase(color)).map(Car::getSlotNumber)
				.collect(Collectors.toList());
		return slotNumbers.stream().map(String::valueOf).collect(Collectors.joining(", "));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.gojek.carpark.ParkingLot#getSlotNumberForRegistrationNumber(java.lang
	 * .String)
	 */
	public String getSlotNumberForRegistrationNumber(String registrationNumber) {

		List<Integer> slotNumbers = Arrays.asList(slots).parallelStream()
				.filter(t -> t != null && t.getRegistrationNumber().equalsIgnoreCase(registrationNumber)).limit(1)
				.map(Car::getSlotNumber).collect(Collectors.toList());
		if (slotNumbers != null && slotNumbers.size() > 0)
			return String.valueOf(slotNumbers.get(0));
		return "Not found";

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gojek.carpark.ParkingLot#getCar(int)
	 */
	public Car getCar(int slotNumber) {
		return slots[--slotNumber];
	}

}
