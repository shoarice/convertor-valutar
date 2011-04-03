package roadrunner.model;

public class User extends Model{
	private String username;
	private Status status;
	
	public User(String username) {
		this.username = username;
		status = Status.AVAILABLE;
	}

	public void setStatus(Status status) {
		this.status = status;
		notifyListeners();
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
