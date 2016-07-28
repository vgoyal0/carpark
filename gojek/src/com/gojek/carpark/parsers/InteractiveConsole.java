package com.gojek.carpark.parsers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Implementation of an interactive console. User is asked to enter a command.
 * Command output is displayed before asking for next input. 'exit' command
 * terminates the program
 * 
 * @author VGoyal
 */
public class InteractiveConsole extends AbstractParser {
	
	/*
	 * (non-Javadoc) This method reads the input from console and processes the
	 * user commands
	 * 
	 * @see com.gojek.carpark.Parser#parse()
	 */
	public void parse() {

		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

			while (true) {

				String commandStr = null;
				System.out.println("Input:");
				if ((commandStr = br.readLine()) == null || commandStr.equalsIgnoreCase("exit")) {
					break;
				}
				System.out.println();

				System.out.println("Output:");
				processCommand(commandStr);
				System.out.println();

			}

		} catch (IOException e) {
			System.out.println("Problem reading from console.");
		}

	}
}
