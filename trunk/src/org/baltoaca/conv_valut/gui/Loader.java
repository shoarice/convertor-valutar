package org.baltoaca.conv_valut.gui;

import java.awt.Component;

import javax.swing.ProgressMonitor;

/**
 * Extends <code>ProgressMonitor</code> for a personalized 
 * progress monitor for this application
 * @author VlaD
 *
 */
public class Loader extends ProgressMonitor {

	private int progress;
	
	public Loader(Component parentComponent, Object message, String note,
			int min, int max) {
		super(parentComponent, message, note, min, max);
		setMillisToDecideToPopup(0);
		setMillisToPopup(0);

	}

	/**
	 * Sets the next step in the <code>ProgresMonitor</code> with
	 * all the settings needed 
	 * @see ProgressMonitor
	 */
	
	public void next(){
		String message = String.format("Pasul %d din %d\n",progress,getMaximum());
		setNote(message);
		setProgress(progress++);
		if(isCanceled()){
			System.exit(0);
		}
		/*try {
			Thread.sleep(1000);  //Testing
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
	}
}
