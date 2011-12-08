package model;

import java.util.List;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.query.Predicate;


public class ContainerStiri {

	private static final String DB4O_FILENAME = "db";
	private ObjectContainer db;
	
	public ContainerStiri(){
		db = Db4oEmbedded.openFile(Db4oEmbedded
		        .newConfiguration(), DB4O_FILENAME);
	}
	
	public void putStire(Stire s){
		db.store(s);
	}
	
	public List<Stire> getStiriCuId(final int id){
		return db.query(new Predicate<Stire>() {

			private static final long serialVersionUID = 8563138650101583600L;

			@Override
			public boolean match(Stire arg0) {
				return arg0.getAutorId() == id;
			}
			
		});
	}
}
