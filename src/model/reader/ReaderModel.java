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
	private List<Integer> allowed;
	private Map<IdPair, StireReaderEveniment> stiri;
	private String filter;
	
	public ReaderModel(int id) {
		//don't know if we need id but this way there are no errors and I can commit
		domains = new ArrayList<String>();
		stiri = Collections.synchronizedMap(new HashMap<IdPair, StireReaderEveniment>());
		allowed = new ArrayList<Integer>();
		allowed.add(0);
		allowed.add(1);
		allowed.add(2);
	}
	public void addAllowed(int i){
		allowed.add(i);
	}
	
	public void removeAllowed(int i){
		allowed.remove(i);
	}
	
	public void clearAllowed(){
		allowed.clear();
	}
	
	public void setDomains(List<String> stringList) {
		 domains = stringList;
		 
		 setChanged();
		 notifyObservers(new StireReaderEveniment(new Stire(), 0));
	}
	
	public void addStire(Stire s, int i){
		if(allowed.contains(i)){
			IdPair p = new IdPair();
			p.autorId = s.getAutorId();
			p.stireId = s.getStireId();
			
			stiri.put(p, new StireReaderEveniment(s,i));
			
			setChanged();
			notifyObservers();
		}
	}
	
	public List<StireReaderEveniment> getStiri(){
		List<StireReaderEveniment> list = new ArrayList<StireReaderEveniment>(stiri.size());
		for (Entry<IdPair, StireReaderEveniment> e : stiri.entrySet()) {
			list.add(e.getValue());
		}
		return list;
	}
	
	public Stire deschideStire(long stireId, int autorId){
		Stire s = stiri.get(new IdPair(stireId, autorId)).s;
		
		setChanged();
		notifyObservers(new StireReaderEveniment(s, 1));
		
		return s;
	}
	
	public void inchideStire(long stireId, int autorId){
		Stire s = stiri.get(new IdPair(stireId, autorId)).s;
		stiri.remove(new IdPair(stireId, autorId));
		
		setChanged();
		notifyObservers(new StireReaderEveniment(s.clone(),-1));
		
	}
	
	public List<String> getDomains() {
		return domains;
	}
	public void setFilter(String filter) {
		this.filter = filter;
	}

	public String getFilter() {
		return filter;
	}
}
