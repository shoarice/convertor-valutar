package model.editor;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import model.Stire;

public class EditorModel extends Observable{
	private int id;
	
	private List<Stire> stiri;
	
	public EditorModel(){
		stiri = new ArrayList<Stire>();
	}
}
