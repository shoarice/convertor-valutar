package roadrunner.model;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import roadrunner.remote.Component;

/**
 * A model class that contains a list of all the components with their associated users
 * @author VlaD
 *
 */
public class Network extends Model implements Iterable<ComponentInfo>{
	private Set<ComponentInfo> componentsInfo;

	private static Network instance = null;
	
	private Network() {
		componentsInfo = Collections.synchronizedSet(new HashSet<ComponentInfo>());
	}
	
	public synchronized static Network instance(){
		if(instance == null)
			instance = new Network();
		
		return instance;
	}

	public void setComponentsInfo(Set<ComponentInfo> componentsInfo) {
		this.componentsInfo = componentsInfo;
		notifyListeners(null);
	}
	
	public void setComponents(Set<Component> components){
		componentsInfo.clear();
		for (Component component : components) {
			try {
				componentsInfo.add(new ComponentInfo(component,component.getUsers()));
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		notifyListeners(null);
	}
	
	public void updateUsers(Component component, Set<User> users){
		
		for (ComponentInfo componentInfo : componentsInfo) {
			
			if(componentInfo.isComponent(component)){
				componentInfo.setUsers(users);
				notifyListeners(null);
				return;
			}
		}
	}
	
	public boolean isUserPresent(String username){
		for (ComponentInfo componentInfo : componentsInfo) {
			if(componentInfo.hasUser(username))
				return true;
		}
		return false;
	}

	@Override
	public Iterator<ComponentInfo> iterator() {
		return componentsInfo.iterator();
	}

	public Set<ComponentInfo> getComponentsInfo() {
		return componentsInfo;
	}
	
	public String[] getAllUsers(){
		ArrayList<String> result = new ArrayList<String>();
		synchronized (componentsInfo) {
			for (ComponentInfo componentInfo : componentsInfo) {
				for (String username : componentInfo.getUserNames()) {
					result.add(username);
				}
			}
		}
		return result.toArray(new String[1]);
	}

	@Override
	public String toString() {
		return componentsInfo.toString();
	}
	
	
	
	
}
