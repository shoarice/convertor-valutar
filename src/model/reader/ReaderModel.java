package model.reader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Observable;

import model.Stire;

public class ReaderModel extends Observable{
	private List<String> domains;
	private Map<IdPair, Stire> stiri;
	
	public ReaderModel(int id) {
		//don't know if we need id but this way there are no errors and I can commit
		domains = new ArrayList<String>();
		stiri = Collections.synchronizedMap(new HashMap<IdPair, Stire>());
	}
	
	
	public void setDomains(List<String> stringList) {
		 domains = stringList;
		 
		 setChanged();
		 notifyObservers(new StireReaderEveniment(new Stire(), 0));
	}
	
	public void addStire(Stire s){
		IdPair p = new IdPair();
		p.autorId = s.getAutorId();
		p.stireId = s.getStireId();
		
		stiri.put(p, s);
		
		setChanged();
		notifyObservers();
	}
	
	public List<Stire> getStiri(){
		List<Stire> list = new ArrayList<Stire>(stiri.size());
		for (Entry<IdPair, Stire> e : stiri.entrySet()) {
			list.add(e.getValue());
		}
		return list;
	}
	
	public Stire deschideStire(long stireId, int autorId){
		Stire s = stiri.get(new IdPair(stireId, autorId));
		
		setChanged();
		notifyObservers(new StireReaderEveniment(s, 1));
		
		return s;
	}
	
	public void inchideStire(long stireId, int autorId){
		Stire s = stiri.get(new IdPair(stireId, autorId));
		
		setChanged();
		notifyObservers(new StireReaderEveniment(s,-1));
	}
	
	public List<String> getDomains() {
		return domains;
	}
}
