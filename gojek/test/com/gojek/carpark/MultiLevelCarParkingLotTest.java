package test.com.gojek.carpark;

import org.junit.Assert;
import org.junit.Test;

import com.gojek.carpark.Car;
import com.gojek.carpark.MultiLevelCarParkingLot;
import com.gojek.carpark.ParkingLot;

public class MultiLevelCarParkingLotTest {

	Car testCar = new Car("registration_number", "color");

	@Test
	public void testGetEmptySlotNumber() {
		ParkingLot systemUnderTest = new MultiLevelCarParkingLot(1);
		int emptySlot = systemUnderTest.getEmptySlotNumber();
		Assert.assertTrue("There is an empty slot in parking lot", emptySlot != -1);
		testCar.setSlotNumber(emptySlot);
		systemUnderTest.addCar(testCar);
		emptySlot = systemUnderTest.getEmptySlotNumber();
		Assert.assertTrue("Parking lot is full, it should not have an empty slot", emptySlot == -1);
	}

	@Test
	public void testAddCar() {
		ParkingLot systemUnderTest = new MultiLevelCarParkingLot(1);
		int emptySlot = systemUnderTest.getEmptySlotNumber();
		testCar.setSlotNumber(emptySlot);
		systemUnderTest.addCar(testCar);
		Car parkedCar = systemUnderTest.getCar(emptySlot);
		Assert.assertNotNull("Car should have been parked in the parking lot", parkedCar);
	}

	@Test
	public void testRemoveCar() {
		ParkingLot systemUnderTest = new MultiLevelCarParkingLot(1);
		int emptySlot = systemUnderTest.getEmptySlotNumber();
		testCar.setSlotNumber(emptySlot);
		systemUnderTest.addCar(testCar);
		systemUnderTest.removeCar(emptySlot);
		Car parkedCar = systemUnderTest.getCar(emptySlot);
		Assert.assertNull("Car should have been removed from the parking lot", parkedCar);
	}

	@Test
	public void testStatus() {
		ParkingLot systemUnderTest = new MultiLevelCarParkingLot(1);
		int emptySlot = systemUnderTest.getEmptySlotNumber();
		testCar.setSlotNumber(emptySlot);
		systemUnderTest.addCar(testCar);
		systemUnderTest.status();
		Assert.assertTrue("Status call executes without any error", true);
	}

	@Test
	public void testGetRegistrationNumbersForCarsWithColour() {
		ParkingLot systemUnderTest = new MultiLevelCarParkingLot(1);
		int emptySlot = systemUnderTest.getEmptySlotNumber();
		testCar.setSlotNumber(emptySlot);
		systemUnderTest.addCar(testCar);
		String registrationNumbersForCarsWithColour = systemUnderTest.getRegistrationNumbersForCarsWithColour("color");
		Assert.assertTrue("Right regisrtation numbers are returned for a perticular color",
				registrationNumbersForCarsWithColour.contains("registration_number"));
	}

	@Test
	public void testGetSlotNumbersForCarsWithColour() {
		ParkingLot systemUnderTest = new MultiLevelCarParkingLot(1);
		int emptySlot = systemUnderTest.getEmptySlotNumber();
		testCar.setSlotNumber(emptySlot);
		systemUnderTest.addCar(testCar);
		String slotNumber = systemUnderTest.getSlotNumbersForCarsWithColour("color");
		Assert.assertTrue("Right slot numbers are returned for a perticular color",
				slotNumber.contains(String.valueOf(emptySlot)));
	}

	@Test
	public void testGetSlotNumberForRegistrationNumber() {
		ParkingLot systemUnderTest = new MultiLevelCarParkingLot(1);
		int emptySlot = systemUnderTest.getEmptySlotNumber();
		testCar.setSlotNumber(emptySlot);
		systemUnderTest.addCar(testCar);
		String slotNumber = systemUnderTest.getSlotNumberForRegistrationNumber("registration_number");
		Assert.assertTrue("Right slot number is returned for a perticular registration number",
				slotNumber.contains(String.valueOf(emptySlot)));
	}

	@Test
	public void testGetCar() {
		ParkingLot systemUnderTest = new MultiLevelCarParkingLot(1);
		int emptySlot = systemUnderTest.getEmptySlotNumber();
		testCar.setSlotNumber(emptySlot);
		systemUnderTest.addCar(testCar);
		Car parkedCar = systemUnderTest.getCar(emptySlot);
		Assert.assertNotNull("Able to locate a parked car in the parking lot", parkedCar);
		systemUnderTest.removeCar(emptySlot);
		parkedCar = systemUnderTest.getCar(emptySlot);
		Assert.assertNull("Should not return a car that has left the parking lot", parkedCar);
	}

}
