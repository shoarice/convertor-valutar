package main;

import gui.ReaderGuiView;
import model.reader.ReaderModel;
import actori.reader.ReaderJMSViewControllerHybrid;
import controller.ReaderController;

public class ManipulantReader {
	
	public ManipulantReader(int id) {
		ReaderModel rm = new ReaderModel(id);
		ReaderGuiView view = new ReaderGuiView();
		
		ReaderJMSViewControllerHybrid h = new ReaderJMSViewControllerHybrid(rm);
		rm.addObserver(view);
		rm.addObserver(h);
		
		ReaderController c = new ReaderController(null, rm, view);
		
		view.show();
	}
}
