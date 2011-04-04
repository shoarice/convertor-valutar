package roadrunner.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class LocalUsers extends Model {
	
	private Set<User> users;
	
	public LocalUsers() {
		super();
		users = Collections.synchronizedSet(new HashSet<User>());
	}

	public Set<User> getUsers() {
		return users;
	}

	public void addUser(User user){
		users.add(user);
		notifyListeners();
	}
	
	public void addUser(String username){
		users.add(new User(username));
		notifyListeners();
	}
	
	public void removeUser(String username){
		users.remove(new User(username));
		notifyListeners();
	}
	
	public void setUsers(Set<User> users) {
		this.users = users;
		notifyListeners();
	}
}
