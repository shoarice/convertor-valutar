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
import roadrunner.gui.ClientFrame;
import roadrunner.model.ComponentInfo;
import roadrunner.model.LocalUsers;
import roadrunner.model.Model;
import roadrunner.model.Network;
import roadrunner.model.Status;
import roadrunner.model.User;

public class ComponentImplementation extends Model implements Component {
	
	private final LocalUsers localUsers;
	private final Central central;
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

	public static ComponentImplementation start(String[] args) {
		
		String host = getHostName(args);
		
		Central central = getCentral(host);
		
		ComponentImplementation component = createAndExportComponent(central);
		
		connectToCentral(central, component);
		
		return component;
		
		//TODO in cazul set-urilor set-urilor, acestea trebuie sincronizate cu Collections.syncr...Set() etc
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
			central.connect(component);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public String[] getLocalUsers() {
		User[] users= localUsers.getUsers().toArray(new User[1]);
		if(users.length == 1 && users[0] == null){
			return new String[0];
		}
		String[] userNames= new String[users.length];
		for (int i=0;i<users.length;i++)
		{
			userNames[i]=users[i].getUsername();
		}
		return userNames;
	}
	
	public void disconnect(){
		try {
			central.disconnect(this);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public void addLocalUser(String username, ClientFrame clientFrame){
		localUsers.addUser(username,clientFrame);
		
		notifyComponents();
		notifyListeners(getLocalUsers());
		
	}

	public void addLocalUser(User user, ClientFrame frame){
		localUsers.addUser(user, frame);
		
		notifyComponents();
		notifyListeners(getLocalUsers());

	}
	
	public void removeLocalUser(String username){
		localUsers.removeUser(username);
		
		notifyComponents();
		notifyListeners(getLocalUsers());
	}
	
	public void setStatusForUser(String username, Status status){
		localUsers.setStatusForUser(username,status);
		
		notifyComponents();
		notifyListeners(getLocalUsers());
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
