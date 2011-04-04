package roadrunner.model;

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
		notifyListeners();
	}
	
	public void setComponents(Set<Component> components){
		for (Component component : components) {
			componentsInfo.add(new ComponentInfo(component));
		}
		
		notifyListeners();
	}
	
	public void updateUsers(Component component, Set<User> users){
		
		for (ComponentInfo componentInfo : componentsInfo) {
			
			if(componentInfo.isComponent(component)){
				componentInfo.setUsers(users);
				System.out.println("Users set: "+users);
				return;
			}
		}
		
	}

	@Override
	public Iterator<ComponentInfo> iterator() {
		return componentsInfo.iterator();
	}

	public Set<ComponentInfo> getComponentsInfo() {
		return componentsInfo;
	}
	
	
	
	
}
