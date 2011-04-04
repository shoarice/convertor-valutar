package roadrunner.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Set;

import roadrunner.model.User;

/**
 * The interface that will be available for remote method invocation on a component
 * @author VlaD
 *
 */
public interface Component extends Remote{
	/**
	 * Method called by the central program when a new component connects to the swarm :P
	 */
	public void updateComponents() throws RemoteException;
	
	/**
	 * Method called by the other components when the user list changes
	 * @param component
	 * @throws RemoteException
	 */
	public void updateUsers(Component component) throws RemoteException;
	
	/**
	 * Method called by other components when this component calls updateUsers() on the other component
	 * @return
	 * @throws RemoteException
	 */
	public Set<User> getUsers() throws RemoteException;
}
