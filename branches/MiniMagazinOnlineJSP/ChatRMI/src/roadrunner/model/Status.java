package roadrunner.model;

public enum Status {
	AVAILABLE ("Available"), AWAY ("Away"), BUSY ("Busy");
	
	private String description;
	
	Status(String description){
		this.description = description;
	}
	
	@Override
	public String toString(){
		return description;
	}
}
