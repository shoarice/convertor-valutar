package model.editor;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Observable;

import model.Stire;

public class EditorModel extends Observable{
	private int id;
	private long idStireCurent;
	
	private Map<Long,Stire> stiri;
	private Map<Long,Integer> cititori;
	
	public EditorModel(){
		stiri = new HashMap<Long,Stire>();
		cititori = Collections.synchronizedMap(new HashMap<Long,Integer>());
	}
	
	public void adaugaStire(Stire stire){
		synchronized (cititori) {
			stiri.put(idStireCurent, stire);
			cititori.put(idStireCurent, 0);
			idStireCurent++;
		}
		
		setChanged();
		notifyObservers();
	}
	
	public void stergeStiri(long[] stireIds){
		synchronized (cititori) {
			for (long stireId : stireIds) {
				stiri.remove(stireId);
				cititori.remove(stireId);
			}
		}
		
		setChanged();
		notifyObservers();
	}
	
	public StireWrapper[] getStiriWrappers(){
		StireWrapper[] tablou = new StireWrapper[stiri.size()];
		int i=0;
		long id=0;
		for (Entry<Long,Stire> entry : stiri.entrySet()) {
			id = entry.getKey();
			tablou[i] = new StireWrapper(id, entry.getValue(), cititori.get(id));
			i++;
		}
		
		return tablou;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
