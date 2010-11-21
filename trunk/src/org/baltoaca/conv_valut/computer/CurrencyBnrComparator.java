package org.baltoaca.conv_valut.computer;

import java.util.Comparator;

public class CurrencyBnrComparator implements Comparator<Currency> {

	@Override
	public int compare(Currency c1, Currency c2) {
		//TODO externalise the order
		
		if(c1.equals(c2))
			return 0;
		
		if(c1.getShortName().equals("RON")){
			return -5; 
		}
		if(c2.getShortName().equals("RON")){
			return 5;
		}
		
		if(c1.getShortName().equals("EUR")){
			return -3; 
		}
		if(c2.getShortName().equals("EUR")){
			return 3;
		}
		
		if(c1.getShortName().equals("USD")){
			return -1; 
		}
		if(c2.getShortName().equals("USD")){
			return 1;
		}
		
		
		return 1;
	}

}
