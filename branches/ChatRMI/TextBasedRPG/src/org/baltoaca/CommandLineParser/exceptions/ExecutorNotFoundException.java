package org.baltoaca.CommandLineParser.exceptions;

public class ExecutorNotFoundException extends Exception {

	private static final long serialVersionUID = -4948274441158748429L;

	public ExecutorNotFoundException(){
		super("The CommandLineParser does not have an executor associated");
	}
}
