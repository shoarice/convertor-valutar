package roadrunner.model;

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

	public static Network instance = null;
	
	private Network() {}
	
	public static Network instance(){
		if(instance == null)
			instance = new Network();
		
		return instance;
	}

	public void setComponentsInfo(Set<ComponentInfo> componentsInfo) {
		this.componentsInfo = componentsInfo;
		notifyListeners();
	}
	
	public void updateUsers(Component component, Set<User> users){
		
		for (ComponentInfo componentInfo : componentsInfo) {
			
			if(componentInfo.isComponent(component)){
				componentInfo.setUsers(users);
				return;
			}
		}
	}

	@Override
	public Iterator<ComponentInfo> iterator() {
		return componentsInfo.iterator();
	}
	
	
}
