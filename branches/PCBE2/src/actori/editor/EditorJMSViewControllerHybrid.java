package actori.editor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import javax.jms.JMSException;
import javax.naming.NamingException;

import model.Stire;
import model.editor.EditorModel;
import model.editor.EvenimentStire;
import actori.AscultatorActiuniStiri;
import actori.PublicatorStiri;
import actori.ReceptorActiuniStiri;

public class EditorJMSViewControllerHybrid implements Observer{
	private int id;
	
	private PublicatorStiri pubicatorStiri;
	private ReceptorActiuniStiri receptorActiuniStiri;
	private EditorModel model;
	
	public EditorJMSViewControllerHybrid(int id, final EditorModel model){
		this.model = model;
		pubicatorStiri = new PublicatorStiri();
		receptorActiuniStiri = new ReceptorActiuniStiri(id);
		try {
			receptorActiuniStiri.inregistreazaActiuneStire(new AscultatorActiuniStiri() {
				
				@Override
				public void stireInchisa(long stireId) {
					model.decrementeazaCititor(stireId);
				}
				
				@Override
				public void stireDeschisa(long stireId) {
					model.incrementeazaCititor(stireId);
				}
			});
		} catch (JMSException e) {
			e.printStackTrace();
			receptorActiuniStiri.inchideConn();
		} catch (NamingException e) {
			e.printStackTrace();
			receptorActiuniStiri.inchideConn();
		}
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if(arg != null){
			final EvenimentStire e = (EvenimentStire) arg;
			EditorModel model = (EditorModel) o;
	
			final long idStiri[] = Arrays.copyOf(e.getIdStiri(), e.getIdStiri().length);
			final HashMap<Long,Stire> stiri = new HashMap<Long, Stire>();
			final HashMap<Long, String> domenii = new HashMap<Long, String>();
			for (long l : idStiri) {
				stiri.put(l,model.getStire(l).clone());
				domenii.put(l, model.getDomeniu(l).toString());
			}
			
			new Thread(){
	
				@Override
				public void run() {
					try {
						
						switch (e.getTipEveniment()) {
						case PUBLISH:{
							pubicatorStiri.publicareStire(stiri.get(idStiri[0]), domenii.get(idStiri[0]));
							break;
							
						}
						case EDIT:{
							pubicatorStiri.modificareStire(stiri.get(idStiri[0]), domenii.get(idStiri[0]));
							break;
						}
						case DELETE:{
							for (long l : idStiri) {
								pubicatorStiri.stergereStire(stiri.get(l), domenii.get(l));
							}
						}
						default:
							break;
						}
						
					} catch (JMSException e1) {
						e1.printStackTrace();
						pubicatorStiri.inchideConn();
					} catch (NamingException e1) {
						e1.printStackTrace();
						pubicatorStiri.inchideConn();
					}
				}
				
			}.start();
		}
		
	}
	
	public void inchideConn(){
		pubicatorStiri.inchideConn();
		receptorActiuniStiri.inchideConn();
	}
}
