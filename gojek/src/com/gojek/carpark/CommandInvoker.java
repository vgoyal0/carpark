package com.gojek.carpark;

import com.gojek.carpark.commands.Command;

/**
 * Command invoker simply invoked the command provided to it
 * 
 * @author VGoyal
 */
public class CommandInvoker {
	private Command theCommand;

	public CommandInvoker(Command newCommand) {
		theCommand = newCommand;
	}

	/**
	 * Execute the command provided
	 */
	public void call() {

		theCommand.execute();

	}

}
