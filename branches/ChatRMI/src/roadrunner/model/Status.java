package roadrunner.model;

public enum Status {
	AVAILABLE ("Available"), AWAY ("Away");
	
	private String description;
	
	Status(String description){
		this.description = description;
	}
	
	@Override
	public String toString(){
		return description;
	}
}
