package roadrunner.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import roadrunner.remote.Component;

/**
 * A model class that represents a component with its associated users list
 * @author VlaD
 *
 */
public class ComponentInfo extends Model {
	private Component component;
	private Set<User> users;
	
	public ComponentInfo(Component component) {
		this.component = component;
		users = Collections.synchronizedSet(new HashSet<User>());
	}
	
	public boolean hasUser(String username){
		return users.contains(new User(username));
	}
	
	public boolean isComponent(Component component){
		return this.component.equals(component);
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
		notifyListeners();
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
	
}
