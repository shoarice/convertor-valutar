package roadrunner.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import roadrunner.gui.ClientFrame;

public class LocalUsers extends Model {
	
	private final Map<User, ClientFrame> users;
	
	public LocalUsers() {
		super();
		users = Collections.synchronizedMap(new HashMap<User, ClientFrame>());
	}

	public Set<User> getUsers() {
		Set<User> set = new HashSet<User>();
		for (User user : users.keySet()) {
			set.add(user);
		}
		return set;
	}

	public void addUser(User user, ClientFrame clientFrame){
		users.put(user,clientFrame);
		notifyListeners();
	}
	
	public void addUser(String username, ClientFrame frame){
		users.put(new User(username), frame);
		notifyListeners();
	}
	
	public void removeUser(String username){
		users.remove(new User(username));
		notifyListeners();
	}

	
}
