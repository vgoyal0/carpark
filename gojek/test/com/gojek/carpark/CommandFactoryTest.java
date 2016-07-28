package test.com.gojek.carpark;

import org.junit.Test;

import com.gojek.carpark.Parser;
import com.gojek.carpark.commands.AddCar;
import com.gojek.carpark.commands.Command;
import com.gojek.carpark.commands.CommandFactory;
import com.gojek.carpark.commands.CreateParking;
import com.gojek.carpark.commands.DummyCommand;
import com.gojek.carpark.commands.RemoveCar;
import com.gojek.carpark.commands.Search;
import com.gojek.carpark.commands.ShowStatus;
import com.gojek.carpark.parsers.InteractiveConsole;

import junit.framework.Assert;

public class CommandFactoryTest {

	Parser parser = new InteractiveConsole();

	/**
	 * Positive test to check if create parking command instance is returned for
	 * 'create_parking' command
	 */
	@Test
	public void positive_create_parking_lot_command_get_instance_test() {
		String commandType = CommandFactory.COMMANDS.CREATE_PARKING_LOT;
		String[] args = { "2" };
		Command createParkingLot = CommandFactory.getCommand(commandType, args, parser);
		Assert.assertTrue("An instance of 'CreateParking' command is returned",
				createParkingLot instanceof CreateParking);
	}

	/**
	 * An exception is thrown when a command is executed with wrong parameters
	 */
	@Test(expected = IllegalArgumentException.class)
	public void negative_create_parking_lot_command_get_instance_test() {
		String commandType = CommandFactory.COMMANDS.CREATE_PARKING_LOT;
		String[] args = null;
		Command createParkingLot = CommandFactory.getCommand(commandType, args, parser);
		Assert.assertNull("Null is returned as validation failed", createParkingLot);
	}

	/**
	 * Positive test to check if add car command instance is returned for 'park'
	 * command
	 */
	@Test
	public void positive_add_car_command_get_instance_test() {
		String commandType = CommandFactory.COMMANDS.PARK;
		String[] args = { "registration_number", "color" };
		Command addCommand = CommandFactory.getCommand(commandType, args, parser);
		Assert.assertTrue("An instance of 'AddCar' command is returned", addCommand instanceof AddCar);
	}

	/**
	 * An exception is thrown when a command is executed with wrong parameters
	 */
	@Test(expected = IllegalArgumentException.class)
	public void negative_add_car_command_get_instance_test() {
		String commandType = CommandFactory.COMMANDS.PARK;
		String[] args = { "registration_number" };
		Command addCommand = CommandFactory.getCommand(commandType, args, parser);
		Assert.assertNull("Null is returned as validation failed", addCommand);
	}

	/**
	 * Positive test to check if remove car command instance is returned for
	 * 'leave' command
	 */
	@Test
	public void positive_leave_command_get_instance_test() {
		String commandType = CommandFactory.COMMANDS.LEAVE;
		String[] args = { "2" };
		Command removeCarCommand = CommandFactory.getCommand(commandType, args, parser);
		Assert.assertTrue("An instance of 'RemoveCar' command is returned", removeCarCommand instanceof RemoveCar);
	}

	/**
	 * An exception is thrown when a command is executed with wrong parameters
	 */
	@Test(expected = IllegalArgumentException.class)
	public void negative_leave_command_get_instance_test() {
		String commandType = CommandFactory.COMMANDS.LEAVE;
		String[] args = null;
		Command removeCarCommand = CommandFactory.getCommand(commandType, args, parser);
		Assert.assertNull("Null is returned as validation failed", removeCarCommand);
	}

	/**
	 * Positive test to check if status command instance is returned for
	 * 'status' command
	 */
	@Test
	public void positive_status_command_get_instance_test() {
		String commandType = CommandFactory.COMMANDS.STATUS;
		String[] args = {};
		Command showStatusCommand = CommandFactory.getCommand(commandType, args, parser);
		Assert.assertTrue("An instance of 'ShowStatus' command is returned", showStatusCommand instanceof ShowStatus);
	}

	/**
	 * Positive test to check if search command instance is returned for below
	 * commands: 1. registration_numbers_for_cars_with_colour 2.
	 * slot_number_for_registration_number 3. slot_numbers_for_cars_with_colour
	 */
	@Test
	public void positive_search_command_get_instance_test() {
		String commandType = CommandFactory.COMMANDS.REGISTRATION_NUMBERS_FOR_CARS_WITH_COLOUR;
		String[] args = { "color" };
		Command searchCommand = CommandFactory.getCommand(commandType, args, parser);
		Assert.assertTrue("An instance of 'Search' command is returned", searchCommand instanceof Search);

		commandType = CommandFactory.COMMANDS.SLOT_NUMBER_FOR_REGISTRATION_NUMBER;
		String[] args1 = { "registration_number" };
		searchCommand = CommandFactory.getCommand(commandType, args1, parser);
		Assert.assertTrue("An instance of 'Search' command is returned", searchCommand instanceof Search);

		commandType = CommandFactory.COMMANDS.SLOT_NUMBERS_FOR_CARS_WITH_COLOUR;
		String[] args2 = { "color" };
		searchCommand = CommandFactory.getCommand(commandType, args2, parser);
		Assert.assertTrue("An instance of 'Search' command is returned", searchCommand instanceof Search);
	}

	/**
	 * Positive test to check if dummy command instance is returned for any
	 * other command which is not supported by application
	 */
	@Test
	public void positive_dummy_command_get_instance_test() {
		String commandType = "unsupported_command";
		String[] args = {};
		Command showStatusCommand = CommandFactory.getCommand(commandType, args, parser);
		Assert.assertTrue("An instance of 'DummyCommand' command is returned",
				showStatusCommand instanceof DummyCommand);
	}

}
