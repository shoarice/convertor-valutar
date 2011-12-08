package controller;

import gui.ReaderGuiView;
import gui.StireGui;

import java.awt.AWTEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JList;

import model.Stire;
import model.reader.ReaderModel;


public class ReaderController {
	private ReaderModel model;
	private ReaderGuiView view;
	
	public ReaderController (WindowAdapter adapter,final ReaderModel model, final ReaderGuiView view){
		
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
				}
				model.setDomains(stringList);
			}
		});
		
		view.getList().addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2){
					//open stire
					JList list = (JList) e.getSource();
					final Stire s = (Stire) list.getSelectedValue();
					
					model.deschideStire(s.getStireId(), s.getAutorId());
					StireGui sg = new StireGui(s);
					sg.getFrame().addWindowListener(new WindowAdapter() {

						@Override
						public void windowClosing(WindowEvent e) {
							model.inchideStire(s.getStireId(), s.getAutorId());
						}
						
					});
					sg.show();
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
}

