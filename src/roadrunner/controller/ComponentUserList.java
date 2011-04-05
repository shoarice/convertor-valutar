package roadrunner.controller;

import java.util.Observable;

import javax.swing.JList;
import javax.swing.SwingUtilities;

import roadrunner.model.Model;

public class ComponentUserList extends Controller {

	private JList list;
	public ComponentUserList(Model model, JList list) {
		super(model);
		this.list=list;
	}

	@Override
	public void update(Observable arg0, final Object arg1) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				list.setListData((Object[])arg1);
			}
		});
	}
	
	

}
