package controller;

import gui.EditorView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

import model.Stire;
import model.editor.EditorModel;
import model.editor.StireWrapper;

public class EditorController {

	private EditorModel model;
	private EditorView view;
	
	public static EditorController getInstance(EditorModel model, final EditorView view){
		EditorController c = new EditorController(model, view);
		
		//adauga functionalitate la view;
		
		//*********** BUTTON PUBLISH ***********
		view.getBtnPublish().addActionListener(new PublishActionListener(view, model));
		
		//*********** BUTTON DELETE ***********
		view.getBtnDelete().addActionListener(new DeleteActionListener(view,model));
		//*********** BUTTON EDIT ***********
		//*********** BUTTON CLOSE ***********
		view.getBtnClose().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				view.getFrmWritersCenter().dispose();
			}
		});
		
		return c;
	}
	
	private EditorController(EditorModel model, EditorView view){
		this.model = model;
		this.view = view;
	}
}

class PublishActionListener implements ActionListener {
	
	private EditorModel model;
	private EditorView view;

	public PublishActionListener(EditorView view, EditorModel model) {
		this.view = view;
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Stire stire = buildStire();
		model.adaugaStire(stire);
	}

	public Stire buildStire() {
		String autor = view.getTxtFldAuthor().getText();
		String sursa = view.getTxtFldSource().getText();
		String titlu = view.getTxtFldTitle().getText();
		String text = view.getTxtrEditDocument().getText();
		int id = model.getId();
		
		Stire stire = new Stire();
		stire.setAutor(autor);
		stire.setStire(text);
		stire.setSursa(sursa);
		stire.setTitlu(titlu);
		stire.setAutorId(id);
		
		Date time = Calendar.getInstance().getTime();
		stire.setDataCreat(time);
		stire.setDataModificat(time);
		return stire;
	}
}

class DeleteActionListener implements ActionListener{
	private EditorModel model;
	private EditorView view;

	public DeleteActionListener(EditorView view, EditorModel model) {
		this.view = view;
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object[] selected = view.getList().getSelectedValues();
		StireWrapper[] stireWrappers = new StireWrapper[selected.length];
		
		for (int i = 0;i<selected.length; i++) {
			stireWrappers[i] = (StireWrapper) selected[i];
		}
		
		long[] stiriIds = new long[stireWrappers.length];
		for (int i =0; i<stireWrappers.length;i++) {
			stiriIds[i] = stireWrappers[i].getId();
		}
		model.stergeStiri(stiriIds);
	}
}
