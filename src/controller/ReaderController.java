package controller;

import gui.ReaderGuiView;
import gui.StireGui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.JCheckBox;
import javax.swing.JList;

import model.Stire;
import model.reader.ReaderModel;
import model.reader.StireReaderEveniment;


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
				StringBuilder filter = new StringBuilder();
				if (!view.getTfAutor().getText().equals("")) {
					filter.append("autor = '")
						.append(view.getTfAutor().getText()).append("' AND ");
				}
			    
				if (!view.getTfSursa().getText().equals("")) {					
					filter.append("sursa = '")
						.append(view.getTfSursa().getText()).append("' AND ");
				}
				if (!view.getTfTitlu().getText().equals("")) {
					filter.append("titlu = '")
						.append(view.getTfTitlu().getText()).append("'");
				}
				
				model.setFilter(filter.toString());
				model.setDomains(stringList);
			}
		});
		
		view.getList().addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2){
					//open stire
					JList list = (JList) e.getSource();
					StireReaderEveniment ss = (StireReaderEveniment) list.getSelectedValue();
					final Stire s = ss.s;
					
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
		
		view.getChckbxPublished().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				AbstractButton abstractButton = (AbstractButton)actionEvent.getSource();
				boolean selected = abstractButton.getModel().isSelected();
				
				if(selected)
					model.addAllowed(0);
				else
					model.removeAllowed(0);
			}
		});
		view.getChckbxEdited().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				AbstractButton abstractButton = (AbstractButton)actionEvent.getSource();
				boolean selected = abstractButton.getModel().isSelected();
				
				if(selected)
					model.addAllowed(1);
				else
					model.removeAllowed(1);
			}
		});
		view.getChckbxDeleted().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				AbstractButton abstractButton = (AbstractButton)actionEvent.getSource();
				boolean selected = abstractButton.getModel().isSelected();
				
				if(selected)
					model.addAllowed(2);
				else
					model.removeAllowed(2);
			}
		});
	}
}

