package com.gojek.carpark.commands;

/**
 * Interface each command needs to implement
 * 
 * @author VGoyal
 */
public interface Command {

	/**
	 * Execute method is responsible for finally executing the command on the
	 * parking lot
	 */
	public void execute();

}
