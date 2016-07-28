package com.gojek.carpark;

import com.gojek.carpark.parsers.FileInput;
import com.gojek.carpark.parsers.InteractiveConsole;

/**
 * Driver program for Parking lot game
 * 
 * @author VGoyal
 */
public class MyProgram {

	public static void main(String[] args) {
		
		Parser parser;

		// Commands in a File Input
		if (args.length > 0) {
			parser = new FileInput(args[0]);
		}

		// Commands on Interactive console
		else {
			parser = new InteractiveConsole();
		}

		parser.parse();
	}
}
