package exceptions;

public class ConsoleNotFoundException extends Exception {

	private static final long serialVersionUID = 359668488704567345L;
	
	public ConsoleNotFoundException(){
		super("The JVM does not have a console associated");
	}

}
