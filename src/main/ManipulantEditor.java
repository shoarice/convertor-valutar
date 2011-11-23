package main;

import gui.EditorGuiView;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import model.editor.EditorModel;
import actori.editor.EditorJMSViewControllerHybrid;
import controller.EditorController;

//aka EditorHandler
public class ManipulantEditor {
	public ManipulantEditor(int id){
		EditorModel model = new EditorModel(id);
		
		EditorGuiView view = new EditorGuiView();
		model.addObserver(view);
		
		final EditorJMSViewControllerHybrid jmsView = new EditorJMSViewControllerHybrid(id, model);
		model.addObserver(jmsView);
		
		EditorController controller = EditorController.getInstance(new WindowAdapter() {

			@Override
			public void windowClosed(WindowEvent e) {
				jmsView.inchideConn();
			}
			
		}
		,model, view);
		
		view.show();
		
	}
}
