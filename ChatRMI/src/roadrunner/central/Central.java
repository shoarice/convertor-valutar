package roadrunner.central;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Set;

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
	public void connect(Component component) throws RemoteException;
	public void disconnect(Component component) throws RemoteException;
	
	public Set<Component> getComponents() throws RemoteException;
	
}
