package roadrunner.central;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashSet;
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
		
		//notify components
		for (Component comp : components) {
			comp.updateComponents();
		}
	}

	@Override
	public synchronized void disconnect(Component component) {
		components.remove(component);
	}

	public static void main(String[] args) {
		CentralImplementation central = new CentralImplementation();
		Central centralStub = null;
		
		try {
			centralStub = (Central) UnicastRemoteObject.exportObject(central, 0);
			
			Registry reg = LocateRegistry.getRegistry();
			reg.rebind("central", centralStub);
			
		} catch (RemoteException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

}
