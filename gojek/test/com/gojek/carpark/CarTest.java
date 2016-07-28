package test.com.gojek.carpark;

import org.junit.Test;

import com.gojek.carpark.Car;
import com.gojek.carpark.MultiLevelCarParkingLot;
import com.gojek.carpark.ParkingLot;

import junit.framework.Assert;

public class CarTest {

	/**
	 * Tests if a car is able to park in the parking lot
	 */
	@Test
	public void testPark() {
		ParkingLot parkingLot = new MultiLevelCarParkingLot(2);
		Car systemUnderTest = new Car("registration_number", "color");
		systemUnderTest.park(parkingLot, 1);
		Car parkedCar = parkingLot.getCar(1);
		Assert.assertNotNull("Car should be present in the parking lot", parkedCar);
	}

	/**
	 * Tests if a car is able to leave the parking lot
	 */
	@Test
	public void testLeave() {
		ParkingLot parkingLot = new MultiLevelCarParkingLot(2);
		Car systemUnderTest = new Car("registration_number", "color");
		systemUnderTest.park(parkingLot, 1);
		systemUnderTest.leave(parkingLot);
		Car parkedCar = parkingLot.getCar(1);
		Assert.assertNull("Car should not be present in parking lot after leaving", parkedCar);
	}

	/**
	 * Test Getting/Setting of Registration number property is working fine
	 */
	@Test
	public void testGetSetRegistrationNumber() {
		Car systemUnderTest = new Car("registration_number", "color");
		String regNum = systemUnderTest.getRegistrationNumber();
		Assert.assertTrue(regNum.equals("registration_number"));
	}

	/**
	 * Test Getting/Setting of Color property is working fine
	 */
	@Test
	public void testGetSetColor() {
		Car systemUnderTest = new Car("registration_number", "color");
		String color = systemUnderTest.getColor();
		Assert.assertTrue(color.equals("color"));
	}

	/**
	 * Test Getting/Setting slot number property is working fine
	 */
	@Test
	public void testGetSetSlotNumber() {
		Car systemUnderTest = new Car("registration_number", "color");
		systemUnderTest.setSlotNumber(2);
		int slotNumber = systemUnderTest.getSlotNumber();
		Assert.assertTrue(slotNumber == 2);
	}

	/**
	 * Test if car's string representation contains necessary details
	 */
	@Test
	public void testToString() {
		Car systemUnderTest = new Car("registration_number", "color");
		String toString = systemUnderTest.toString();
		Assert.assertTrue("Car string representation contains registration number",
				toString.contains(systemUnderTest.getRegistrationNumber()));
		Assert.assertTrue("Car string representation contains car color", toString.contains(systemUnderTest.getColor()));
	}

}
