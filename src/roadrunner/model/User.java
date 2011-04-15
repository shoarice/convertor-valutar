package roadrunner.model;

import java.io.Serializable;

public class User extends Model implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -500718627599027557L;
	private final String username;
	private Status status;
	
	public User(String username) {
		this.username = username;
		status = Status.AVAILABLE;
	}

	public void setStatus(Status status) {
		this.status = status;
		notifyListeners();
	}

	public Status getStatus() {
		return status;
	}

	public String getUsername() {
		return username;
	}

	@Override
	public String toString() {
		if(status == Status.AVAILABLE)
			return username;
		else
			return username + " - " + status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
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
		User other = (User) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	
	
	
	
	
}
