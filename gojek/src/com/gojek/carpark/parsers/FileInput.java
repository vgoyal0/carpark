package com.gojek.carpark.parsers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Implementation of file input parser File is read from the given location and
 * parsed Each command is executed and output is printed in console
 * 
 * @author VGoyal
 */
public class FileInput extends AbstractParser {

	private String fileName;

	public FileInput(String fileName) {
		this.fileName = fileName;
	}

	/*
	 * (non-Javadoc) This method read the file input and processes the commands
	 * found in the file
	 * 
	 * @see com.gojek.carpark.Parser#parse()
	 */
	public void parse() {

		try (FileReader reader = new FileReader(fileName)) {

			String commandStr = null;
			try (BufferedReader br = new BufferedReader(reader)) {

				while ((commandStr = br.readLine()) != null) {

					processCommand(commandStr);
					System.out.println();

				}

			} catch (IOException e) {
				System.out.println("Error procesing the command " + commandStr
						+ "Please verify the commands in the file and try again.");
			}
		} catch (IOException e) {
			System.out.println(
					"Error reading input file. Please make sure file exists at the path: " + fileName);
		}
	}
}
