package roadrunner.remote;

import java.rmi.Remote;

/**
 * The interface that will be available for remote method invocation on a component
 * @author VlaD
 *
 */
public interface Component extends Remote{
	/**
	 * Method called by the central program when a new component connects to the swarm :P
	 */
	public void updateComponents();
}
