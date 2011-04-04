package roadrunner.remote;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import roadrunner.central.Central;
import roadrunner.model.ComponentInfo;
import roadrunner.model.LocalUsers;
import roadrunner.model.Network;
import roadrunner.model.User;

public class ComponentImplementation implements Component {
	
	private LocalUsers localUsers;
	private Central central;
	private Component self;
	
	public ComponentImplementation(Central central) {
		super();
		localUsers = new LocalUsers();
		this.central = central;
	}

	public void setSelf(Component self) {
		this.self = self;
	}

	@Override
	public void updateComponents() throws RemoteException {
		ExecutorService thread = Executors.newSingleThreadExecutor();
		thread.execute(new Runnable() {
			
			@Override
			public void run() {
				
				try {
					
					Set<Component> components = central.getComponents();
					Network.instance().setComponents(components);
					
				} catch (RemoteException e) {
					e.printStackTrace();
				}	
				
			}//END RUN
		});
	}
	
	@Override
	public synchronized void updateUsers(final Component component) throws RemoteException {
		ExecutorService thread = Executors.newSingleThreadExecutor();
		thread.execute(new Runnable() {
			
			@Override
			public void run() {
				try {
					
					Set<User> users = component.getUsers();
					Network.instance().updateUsers(component, users);
					
				} catch (RemoteException e) {
					e.printStackTrace();
				}
				
			}//END RUN
		});
	}

	@Override
	public synchronized Set<User> getUsers() throws RemoteException {
		return localUsers.getUsers();
	}

	public static void main(String[] args) {
		
		String host = getHostName(args);
		
		Central central = getCentral(host);
		
		ComponentImplementation component = createAndExportComponent(central);
		
		connectToCentral(central, component);
		
//JUST SOME TESTING
/*		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		component.addLocalUser("cacaaaaaaaaaaaaa1");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		component.addLocalUser("cacaaaaaaaaaaaaa2");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		component.addLocalUser("cacaaaaaaaaaaaaa3");
		component.addLocalUser("cacaaaaaaaaaaaaa4");
		
		System.out.println("gata");*/
	}

	private static String getHostName(String[] args) {
		String host = (args.length < 1) ? null : args[0];
		return host;
	}

	private static Central getCentral(String host) {
		Central central = null;
		try {
			
			Registry reg = LocateRegistry.getRegistry(host);
			central = (Central) reg.lookup("central");
			
		} catch (AccessException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return central;
	}

	private static ComponentImplementation createAndExportComponent(Central central) {
		ComponentImplementation component = new ComponentImplementation(central);
		try {
			Component stub = (Component) UnicastRemoteObject.exportObject(component, 0);
			component.setSelf(stub);
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return component;
	}

	private static void connectToCentral(Central central,
			ComponentImplementation component) {
		try {
			central.connect((Component) component);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	//TODO returneaza doar un array de nume
	public LocalUsers getLocalUsers() {
		return localUsers;
	}
	
	public void addLocalUser(String username){
		localUsers.addUser(username);
		
		notifyComponents();
		
	}

	public void addLocalUser(User user){
		localUsers.addUser(user);
		
		notifyComponents();
	}
	
	
	private void notifyComponents() {
		ExecutorService thread = Executors.newSingleThreadExecutor();
		thread.execute(new Runnable() {
			
			@Override
			public void run() {
				synchronized (Network.instance().getComponentsInfo()) {
					Iterator<ComponentInfo> it = Network.instance().iterator();
					while(it.hasNext()){
						Component component = it.next().getComponent();
						
						try {
							component.updateUsers(self);
						} catch (RemoteException e) {
							it.remove();
							e.printStackTrace();
						}
					}
				}
			}
		});
	}
	
	
	
	

}
