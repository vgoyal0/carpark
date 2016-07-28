package com.gojek.carpark.commands;

/**
 * A dummy command implementation for unknown commands. User is prompted with a
 * friendly message
 * 
 * @author VGoyal
 */
public class Dummy implements Command {

	private String message;

	public Dummy(String message) {
		this.message = message;
	}

	@Override
	public void execute() {
		System.out.println(this.message);
	}

}
