package model.editor;

import model.TipEveniment;

public class EvenimentStire {
	private TipEveniment tipEveniment;
	private long[] idStire;

	public EvenimentStire(long[] id, TipEveniment tip){
		this.tipEveniment = tip;
		this.idStire = id;
	}

	public TipEveniment getTipEveniment() {
		return tipEveniment;
	}

	public long[] getIdStiri() {
		return idStire;
	}
	
}
