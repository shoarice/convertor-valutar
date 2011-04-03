package roadrunner.central;

import java.rmi.Remote;

import roadrunner.remote.Component;

/**
 * Remote interface to the central program
 * @author VlaD
 *
 */
public interface Central extends Remote{
	
	/**
	 * Called by a component when it wants to register with the central program
	 * @param component
	 */
	public void connect(Component component);
	public void disconnect(Component component);
	
}
