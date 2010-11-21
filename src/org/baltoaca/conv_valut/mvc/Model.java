package org.baltoaca.conv_valut.mvc;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public abstract class Model {

	private Set<ModelListener> modelListeners = new HashSet<ModelListener>();
	private boolean changed = false;

	// Add/remove listeners
	public void addModelListener(ModelListener mL) {
		modelListeners.add(mL);
	}

	public void addModelListeners(Collection<ModelListener> mL) {
		modelListeners.addAll(mL);
	}

	public void removeModelListener(ModelListener mL) {
		modelListeners.remove(mL);
	}

	public void removeModelListeners(Collection<ModelListener> mL) {
		modelListeners.removeAll(mL);
	}

	public void removeAllModelListeners() {
		modelListeners.clear();
	}

	public int countModelListeners() {
		return modelListeners.size();
	}

	// get/set changed state
	protected void setChanged() {
		changed = true;
	}

	protected void clearChanged() {
		changed = false;
	}

	public boolean isChanged() {
		return changed;
	}

	// notify methods
	public void notifyListeners() {
		if (isChanged()) {
			for (ModelListener mL : modelListeners) {
				mL.update(this, null);
			}
			clearChanged();
		}
	}

	public void notifyListeners(Object obj) {
		if (isChanged()) {
			for (ModelListener mL : modelListeners) {
				mL.update(this, obj);
			}
			clearChanged();
		}
	}

}
