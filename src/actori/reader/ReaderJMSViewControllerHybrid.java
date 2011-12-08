package actori.reader;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import model.Stire;
import model.TipEveniment;
import model.reader.ReaderModel;
import model.reader.StireReaderEveniment;
import actori.AscultatorStiri;
import actori.PublicatorActiuniStiri;
import actori.ReceptorStiri;

public class ReaderJMSViewControllerHybrid implements Observer{
	
	private ReceptorStiri receptorStiri;
	private PublicatorActiuniStiri publicatorActiuniStiri;
	private ReaderModel model;
	private AscultatorStiri asc;
	
	public ReaderJMSViewControllerHybrid(final ReaderModel model){
		this.model = model;
		receptorStiri = new ReceptorStiri();
		publicatorActiuniStiri = new PublicatorActiuniStiri();
		asc = new SuperAscultatorDeStiri(model);
		
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if(arg != null){
			StireReaderEveniment e = (StireReaderEveniment) arg;
			if(e.tip == 0){
				List<String> domains = model.getDomains();
				
				receptorStiri.nuMaiRecepta();
				for (String string : domains) {
					receptorStiri.inregistreazaAscultatorStiri(string, asc);
				}
			}else if(e.tip == 1){
				publicatorActiuniStiri.trimiteStireDeschisa(e.s.getStireId(), e.s.getAutorId());
			}else if(e.tip == -1){
				publicatorActiuniStiri.trimiteStireInchisa(e.s.getStireId(), e.s.getAutorId());
			}
		}
	}
}

class SuperAscultatorDeStiri implements AscultatorStiri{
	private ReaderModel m;

	public SuperAscultatorDeStiri(ReaderModel m){
		this.m = m;
	}

	@Override
	public void laStire(Stire stire, TipEveniment tipEveniment) {
		if(tipEveniment == TipEveniment.PUBLISH){
				m.addStire(stire);
		}
	}
	
}
