package model.editor;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Observable;

import model.Stire;

public class EditorModel extends Observable{
	private int idAutor;
	private long idStireCurent;
	private long idStireIncarcata;
	
	private Map<Long,Stire> stiri;
	private Map<Long,Integer> cititori;
	private Map<Long, Object[]> domenii;
	
	public EditorModel(){
		stiri = new HashMap<Long,Stire>();
		cititori = Collections.synchronizedMap(new HashMap<Long,Integer>());
		domenii = new HashMap<Long, Object[]>();
		idStireIncarcata = -1;
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
			resetIdStireIncarcata();
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
				if(stireId == idStireIncarcata)
					resetIdStireIncarcata();
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
	public int getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(int id) {
		this.idAutor = id;
	}

	public long getIdStireIncarcata() {
		return idStireIncarcata;
	}

	public void setIdStireIncarcata(long idStireIncarcata) {
		this.idStireIncarcata = idStireIncarcata;
	}
	
	public void resetIdStireIncarcata(){
		setIdStireIncarcata(-1);
	}
}
