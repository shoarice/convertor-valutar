package org.baltoaca.conv_valut.mvc;

public abstract class Controller {

	private Model model;
	private ModelListener view;

	public Controller(Model model, ModelListener view) {
		this.model = model;
		this.view = view;
	}

	public Model getModel() {
		return model;
	}

	public ModelListener getView() {
		return view;
	}

}
