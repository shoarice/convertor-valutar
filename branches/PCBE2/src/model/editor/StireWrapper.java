package model.editor;

import model.Stire;

public class StireWrapper {
	private long id;
	private Stire stire;
	private int numarCititori;
	
	public StireWrapper(long id, Stire stire, int numarCititori) {
		this.id = id;
		this.stire = stire;
		this.numarCititori = numarCititori;
	}

	public long getId() {
		return id;
	}

	public Stire getStire() {
		return stire;
	}

	public int getNumarCititori() {
		return numarCititori;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(stire.getTitlu())
		.append(" - ")
		.append(numarCititori);
		
		return sb.toString();
	}
	
}
