package roadrunner.remote;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import roadrunner.central.Central;

/**
 * For testing purposes
 * @author VlaD
 *
 */
public class NaiveAndStupidComponentImpl implements Component {

	private Central central;
	private Component selfStub;
	
	public NaiveAndStupidComponentImpl() {
		super();
	}

	@Override
	public void updateComponents() throws RemoteException {
		System.out.println("Am primiiiiiiiiiit apeeel");			
		
		ExecutorService thread = Executors.newSingleThreadExecutor();
		thread.execute(new Runnable() {

			@Override
			public void run() {
				Set<Component> set = null;
				try {
					set = central.getComponents();
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				set.remove(selfStub);
				System.out.println(set);
			}
		});

		System.out.println("Gata");
	}
	
	public void setCentral(Central central) {
		this.central = central;
	}

	public void setSelfStub(Component selfStub) {
		this.selfStub = selfStub;
	}

	public static void main(String[] args) {
		NaiveAndStupidComponentImpl component = new NaiveAndStupidComponentImpl();
		
		
		String host = (args.length < 1) ? null : args[0];
		Central central = null;
		try {
			Component stub = (Component) UnicastRemoteObject.exportObject(component, 0);
			
			Registry reg = LocateRegistry.getRegistry(host);
			central = (Central) reg.lookup("central");
			
			component.setCentral(central);
			component.setSelfStub(stub);
			
			central.connect((Component) component);
			
		} catch (RemoteException e) {
			e.printStackTrace();
			System.exit(1);
		} catch (NotBoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

}
