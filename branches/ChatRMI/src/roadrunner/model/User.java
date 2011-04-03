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
	
	
	
	
}
