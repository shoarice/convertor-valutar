package roadrunner.model;

import java.util.Observable;
import java.util.concurrent.Executors;

public abstract class Model extends Observable {
	
	public void notifyListeners(){
		setChanged();
		Executors.newSingleThreadExecutor().execute(new Runnable() {
			
			@Override
			public void run() {
				notifyObservers();
			}
		});
	}
	
	public void notifyListeners(final Object arg){
		setChanged();
		Executors.newSingleThreadExecutor().execute(new Runnable() {
			
			@Override
			public void run() {
				notifyObservers(arg);
			}
		});
	}
}
