package model.reader;

import model.Stire;

public class StireReaderEveniment {
	public StireReaderEveniment(Stire s2, int i) {
		this.s =s2;
		this.tip = i;
	}
	public Stire s;
	public int tip;
	
	@Override
	public String toString() {
		String str = "";
		switch(tip){
		case 0:
			str = " ** PUBLISHED **";
			break;
		case 1:
			str = " ** EDITED **";
			break;
		case 2:
			str = " ** DELETED **";
			break;
		}
		return s.toString()+str;
	}
	
	
}
