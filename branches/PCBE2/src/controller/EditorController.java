package controller;

import gui.EditorView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

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
		view.getBtnEdit().addActionListener(new EditActionListener(view,model));
		
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
		if(stire != null){
			TreePath selection = view.getTree().getSelectionPath();
			if(selection == null){
				view.showErrorMsg("Make sure you select a domain");
				return;
			}
			TreeNode node = (TreeNode) selection.getLastPathComponent();
			if(!node.isLeaf()){
				view.showErrorMsg("Make sure you selected a domain with no further subdomains");
				return;
			}
			long stireId;
			if((stireId = model.getIdStireIncarcata()) >= 0){
				model.adaugaStire(stire, selection.getPath(),stireId);
			}
			else
				model.adaugaStire(stire,selection.getPath());
			
			view.getTxtFldAuthor().setText("");
			view.getTxtFldSource().setText("");
			view.getTxtFldTitle().setText("");
			view.getTxtrEditDocument().setText("Your text here...");
			view.getTree().setSelectionRow(0);
		}
		
		
		
		
	}

	public Stire buildStire() {
		String autor = view.getTxtFldAuthor().getText();
		String sursa = view.getTxtFldSource().getText();
		String titlu = view.getTxtFldTitle().getText();
		String text = view.getTxtrEditDocument().getText();
		int id = model.getIdAutor();

		if(autor.equals("")
				|| titlu.equals("null")){
			view.showErrorMsg("Make sure all the fields are filled");
			return null;
		}
				
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
		if(selected.length == 0)
			return;
		
		StireWrapper[] stireWrappers = new StireWrapper[selected.length];
		
		for (int i = 0;i<selected.length; i++) {
			stireWrappers[i] = (StireWrapper) selected[i];
		}
		
		long[] stiriIds = new long[stireWrappers.length];
		boolean stireIncarcata = false;
		for (int i =0; i<stireWrappers.length;i++) {
			stiriIds[i] = stireWrappers[i].getId();
			if(stiriIds[i] == model.getIdStireIncarcata())
				stireIncarcata = true;
		}
		model.stergeStiri(stiriIds);
		if(stireIncarcata){
			view.getTxtFldAuthor().setText("");
			view.getTxtFldSource().setText("");
			view.getTxtFldTitle().setText("");
			view.getTxtrEditDocument().setText("Your text here...");
			view.getTree().setSelectionRow(0);
		}
	}
}

class EditActionListener implements ActionListener {
	
	private EditorModel model;
	private EditorView view;

	public EditActionListener(EditorView view, EditorModel model) {
		this.view = view;
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object[] selected = view.getList().getSelectedValues();
		if(selected.length == 0)
			return;
		if(selected.length > 1){
			view.showErrorMsg("Only select one item for editing");
			return;
		}
		
		final StireWrapper wrapper = (StireWrapper) selected[0];
		final Stire stire = wrapper.getStire();

		view.getTxtFldAuthor().setText((stire.getAutor()));
		view.getTxtFldSource().setText(stire.getSursa());
		view.getTxtFldTitle().setText(stire.getTitlu());
		view.getTxtrEditDocument().setText(stire.getStire());
		view.getTree().setSelectionPath(new TreePath(wrapper.getDomenii()));
		model.setIdStireIncarcata(wrapper.getId());
	}
}
