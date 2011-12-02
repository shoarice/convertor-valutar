package model.reader;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class ReaderModel extends Observable{
	private List<String> domains;
	
	public void setDomains(List<String> stringList) {
		 domains = stringList;
		 setChanged();
		 notifyObservers();
	}
	
	public ReaderModel(int id) {
		//don't know if we need id but this way there are no errors and I can commit
	}
	
	

}
