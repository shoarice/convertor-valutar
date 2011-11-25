package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

import model.reader.ReaderModel;
import gui.EditorGuiView;
import gui.ReaderGuiView;
import java.util.ArrayList;

import javax.swing.JCheckBox;


public class ReaderController {
	private ReaderModel model;
	private ReaderGuiView view;
	
	public ReaderController (WindowAdapter adapter,final ReaderModel model, final ReaderGuiView view){
		
		ReaderController r = new ReaderController(model, view);
		view.getBtnSubmit().addActionListener(new ActionListener () {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<JCheckBox> chckBoxList;
				ArrayList<String> stringList= new ArrayList<String>();
				chckBoxList = view.getCheckBoxList();
				for (JCheckBox checkbox : chckBoxList) {
					if (checkbox.isSelected()) {
						stringList.add(checkbox.getText().toLowerCase());
					}
			    model.setDomains(stringList);
				}
			}
		});
		
		view.getBtnClose().addActionListener(new ActionListener () {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				view.getFrmReader().dispose();
			}
		});
	
	}
	
	private ReaderController(ReaderModel model, ReaderGuiView view){
		this.model = model;
		this.view = view;
	}
}

