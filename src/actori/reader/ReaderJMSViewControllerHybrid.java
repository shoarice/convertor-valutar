package actori.reader;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import model.Stire;
import model.reader.ReaderModel;
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
			Stire s = (Stire) arg;
			if(s.getAutorId() == -1){
				List<String> domains = model.getDomains();
				
				receptorStiri.nuMaiRecepta();
				for (String string : domains) {
					receptorStiri.inregistreazaAscultatorStiri(string, asc);
				}
			}else{
				publicatorActiuniStiri.trimiteStireDeschisa(s.getStireId(), s.getAutorId());
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
	public void laStire(Stire stire, String tipEveniment) {
		if(tipEveniment.equals("publicare")){
				m.addStire(stire);
		}
		System.out.println(stire);
		System.out.println(tipEveniment);
	}
	
}
