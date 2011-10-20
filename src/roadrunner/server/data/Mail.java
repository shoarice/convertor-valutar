package roadrunner.server.data;

public class Mail {
	private String from; //name of sender
	private String msg;
	
	public Mail(String sender, String message) {
		this.from = sender;
		this.msg = message;
	}
	
	public String toString() {
		String res = "Mail from: " + from + "\nMessage: " + msg;
		return res;
	}
}
