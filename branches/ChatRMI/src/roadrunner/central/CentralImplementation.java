package roadrunner.central;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import roadrunner.remote.Component;

public class CentralImplementation implements Central {
	
	Set<Component> components;
	
	public CentralImplementation() {
		super();
		components = new HashSet<Component>();
	}

	@Override
	public synchronized void connect(Component component) {
		
		//if the component already exists it will not be added because this is a set
		components.add(component);
		notifyComponents();
	}

	@Override
	public synchronized void disconnect(Component component) {
		components.remove(component);
		notifyComponents();
	}

	private void notifyComponents() {
		//notify components
		Iterator<Component> it = components.iterator();
		while (it.hasNext()) {
			Component comp = it.next();
			
			try {
				comp.updateComponents();
			} catch (RemoteException e) {
				e.printStackTrace();
				
				/**
				 * If there is an exception when calling a remote method on a component
				 * we assume that the connection is lost and remove the component from the list
				 */
				it.remove();
				
			}
		}
	}

	@Override
	public synchronized Set<Component> getComponents() throws RemoteException {
		return components;
	}

	public static void main(String[] args) {
		CentralImplementation central = new CentralImplementation();
		Central centralStub = null;
		
		try {
			centralStub = (Central) UnicastRemoteObject.exportObject(central, 0);
			
			Registry reg = LocateRegistry.getRegistry();
			reg.rebind("central", centralStub);
			
			System.out.println("Central program ready");
		} catch (RemoteException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

}
