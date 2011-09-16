package roadrunner.view;

import java.util.Observable;
import java.util.Observer;

import roadrunner.model.Model;

public abstract class View implements Observer{
	
	private Model model;
	
	public View(Model model){
		this.model = model;
		model.addObserver(this);
	}
	
	public void unsubscribe(){
		model.deleteObserver(this);
	}
	
	public void subscribe(){
		model.addObserver(this);
	}
	
	@Override
	public abstract void update(Observable arg0, Object arg1);

}
