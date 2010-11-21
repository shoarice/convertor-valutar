package org.baltoaca.conv_valut.mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JList;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.baltoaca.conv_valut.computer.Currency;
import org.baltoaca.conv_valut.gui.MainFrame;

public class ConvValutarController extends Controller {

	final MainFrame myView;
	final ConvValutarModel myModel;

	public ConvValutarController(Model model, ModelListener view) {
		super(model, view);
		myView = (MainFrame) view;
		myModel = (ConvValutarModel) model;

		// *************** JFormattedTextField`s *******************

		// tfSum
		myView.getTfSum().addPropertyChangeListener("value",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						updateModel();

					}
				});

		// tfConvRate
		myView.getTfConvRate().addPropertyChangeListener("value",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						updateModel();

					}
				});

		// *************** JList`s *******************

		// lsFrom
		myView.getLsFrom().addListSelectionListener(
				new ListSelectionListener() {

					@Override
					public void valueChanged(final ListSelectionEvent e) {

						if (e.getValueIsAdjusting() == false) { // if value is
																// NOT adjusting

							String label = ((Currency) ((JList) e.getSource())
									.getSelectedValue()).getShortName();
							myModel.setFromCurrencyLabel(label);

							SwingUtilities.invokeLater(new Runnable() {

								@Override
								public void run() {
									myView.getLsFrom().ensureIndexIsVisible(
											((JList) e.getSource())
													.getSelectedIndex());

								}
							});
							updateModel();
						}
					}
				});

		// lsTo
		myView.getLsTo().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(final ListSelectionEvent e) {

				if (e.getValueIsAdjusting() == false) { // if value is NOT
														// adjusting
					String label = ((Currency) ((JList) e.getSource())
							.getSelectedValue()).getShortName();
					myModel.setToCurrencyLabel(label);
					SwingUtilities.invokeLater(new Runnable() {

						@Override
						public void run() {
							myView.getLsTo().ensureIndexIsVisible(
									((JList) e.getSource()).getSelectedIndex());

						}
					});
					updateModel();
				}
			}
		});

		// buttons
		myView.getBtSwitch().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				final int selectionIndexFrom = myView.getLsFrom()
						.getSelectedIndex();
				final int selectionIndexTo = myView.getLsTo()
						.getSelectedIndex();

				SwingUtilities.invokeLater(new Runnable() {

					@Override
					public void run() {
						;
						myView.getTfConvRate().setValue(new Double(0));

					}
				});

				System.out.println("Button pressed " + selectionIndexFrom
						+ selectionIndexTo);

				if (selectionIndexFrom != selectionIndexTo) {

					SwingUtilities.invokeLater(new Runnable() {

						@Override
						public void run() {
							if (selectionIndexFrom >= 0)
								myView.getLsFrom().setSelectedIndex(
										selectionIndexTo);
							if (selectionIndexTo >= 0)
								myView.getLsTo().setSelectedIndex(
										selectionIndexFrom);
						}
					});
				}
				updateModel();
			}
		});

		// Menus
		myView.getMnItemExit().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);

			}
		});

	} // end 2 param constructor

	// Private methods for computing and updating the numeric fields of the
	// model
	private void updateModel() {

		if ((((Number) myView.getTfSum().getValue()).doubleValue() == 0.0)
				|| (myView.getLsFrom().getSelectedIndex() == -1)
				|| (myView.getLsTo().getSelectedIndex() == -1)) {
			myModel.setResult(0);
			myModel.setVat(0);
			myModel.setResultAndVat(0);
		} else {
			double result = computeResult();
			myModel.setResult(result);
			myModel.setVat(computeVat(result));
			myModel.setResultAndVat(computeResultAndVat(result));
		}

	}

	private double computeResult() {
		double rate = 0;
		double result = 0;

		if (((Number) myView.getTfConvRate().getValue()).doubleValue() == 0) {
			rate = ((Currency) myView.getLsFrom().getSelectedValue()).getRate()
					/ ((Currency) myView.getLsTo().getSelectedValue())
							.getRate();
		} else { // use specified convRate
			rate = ((Number) myView.getTfConvRate().getValue()).doubleValue();
		}

		result = ((Number) myView.getTfSum().getValue()).doubleValue() * rate;
		return result;
	}

	private double computeVat(double value) {
		return (ConvValutarModel.VAT) * value;
	}

	private double computeResultAndVat(double value) {
		return (ConvValutarModel.VAT + 1) * value;
	}

}
