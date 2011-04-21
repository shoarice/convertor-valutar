package roadrunner.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

import roadrunner.remote.Component;

/**
 * A model class that represents a component with its associated users list
 * @author VlaD
 *
 */
public class ComponentInfo extends Model {
	private final Component component;
	private Set<User> users;
	
	public ComponentInfo(Component component, Set<User> users) {
		this.component = component;
		this.users = Collections.synchronizedSet(users);
	}
	
	public boolean hasUser(String username){
		
		for (User user : users) {
			if(user.getUsername().contains(username))
				return true;
		}
		
		return false;
	}
	
	public boolean isComponent(Component component){
		return this.component.equals(component);
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
		notifyListeners(null);
	}

	public Component getComponent() {
		return component;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((component == null) ? 0 : component.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ComponentInfo other = (ComponentInfo) obj;
		if (component == null) {
			if (other.component != null)
				return false;
		} else if (!component.equals(other.component))
			return false;
		return true;
	}

	public String[] getUserNames() {
		ArrayList<String> result = new ArrayList<String>();
		for (User user : users) {
			result.add(user.toString());
		}
		
		return result.toArray(new String[1]);
	}

	@Override
	public String toString() {
		return "ComponentInfo [component=" + component + ", users=" + users
				+ "]";
	}
	
	
	
}
