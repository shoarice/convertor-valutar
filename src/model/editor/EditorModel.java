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
	private Map<Long, Object[]> domenii;
	
	public EditorModel(){
		stiri = new HashMap<Long,Stire>();
		cititori = Collections.synchronizedMap(new HashMap<Long,Integer>());
		domenii = new HashMap<Long, Object[]>();
	}
	
	public void adaugaStire(Stire stire, Object[] domenii){
		synchronized (cititori) {
			stiri.put(idStireCurent, stire);
			cititori.put(idStireCurent, 0);
			this.domenii.put(idStireCurent, domenii);
			idStireCurent++;
		}
		
		setChanged();
		notifyObservers();
	}
	
	
	
	public void adaugaStire(Stire stire, Object[] domenii, long stireId) {
		synchronized (cititori) {
			stiri.put(stireId, stire);
			cititori.put(stireId, 0);
			this.domenii.put(stireId, domenii);
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
				domenii.remove(stireId);
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
			tablou[i] = new StireWrapper(id, entry.getValue(), cititori.get(id),domenii.get(id));
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
