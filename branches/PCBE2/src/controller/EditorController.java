package controller;

import gui.EditorView;
import model.editor.EditorModel;

public class EditorController {
	private EditorModel model;
	private EditorView view;
	
	public static EditorController getInstance(EditorModel model, EditorView view){
		EditorController c = new EditorController(model, view);
		
		//adauga functionalitate la view;
		
		return c;
	}
	
	private EditorController(EditorModel model, EditorView view){
		this.model = model;
		this.view = view;
	}
}
