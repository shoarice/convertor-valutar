package org.baltoaca.conv_valut.mvc;

import org.baltoaca.conv_valut.xml.XmlInformation;

public class ConvValutarModel extends Model {
	public static final double VAT = 0.24;

	private XmlInformation xmlInfo;
	private double sum;
	private double convRate;
	private double vat;
	private double result;
	private double resultAndVat;
	private String fromCurrencyLabel="";
	private String toCurrencyLabel="";

	public ConvValutarModel(XmlInformation xmlInfo) {
		this.xmlInfo = xmlInfo;
	}

	protected void changeAndNotify() {
		setChanged();
		notifyListeners();
	}

	protected void changeAndNotify(Object obj) {
		setChanged();
		notifyListeners(obj);
	}

	public XmlInformation getXmlInfo() {
		return xmlInfo;
	}

	public void setXmlInfo(XmlInformation xmlInfo) {
		this.xmlInfo = xmlInfo;
		changeAndNotify(xmlInfo);
	}

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
		changeAndNotify();
	}

	public double getConvRate() {
		return convRate;
	}

	public void setConvRate(double privateRate) {
		this.convRate = privateRate;
		changeAndNotify();
	}

	public double getVat() {
		return vat;
	}

	public void setVat(double vat) {
		this.vat = vat;
		changeAndNotify();
	}

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
		changeAndNotify();
	}

	public double getResultAndVat() {
		return resultAndVat;
	}

	public void setResultAndVat(double resultAndVat) {
		this.resultAndVat = resultAndVat;
		changeAndNotify();
	}

	public String getFromCurrencyLabel() {
		return fromCurrencyLabel;
	}

	public void setFromCurrencyLabel(String fromCurrencyLabel) {
		this.fromCurrencyLabel = fromCurrencyLabel;
		changeAndNotify();
	}

	public String getToCurrencyLabel() {
		return toCurrencyLabel;
	}

	public void setToCurrencyLabel(String toCurrencyLabel) {
		this.toCurrencyLabel = toCurrencyLabel;
		changeAndNotify();
	}

}
