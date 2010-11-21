package org.baltoaca.conv_valut.computer;

public class Currency {

	private String iso4271Name;
	private String fullName;
	private double rate;
	private boolean hasMultiplier;
	private double multiplier;

	/**
	 * Creates an instance without a multiplier
	 * 
	 * @param name
	 *            The name of the currency
	 * @param rate
	 *            The rate of the currency
	 */
	public Currency(String name, String fullName, Double rate) {
		this.rate = rate;
		this.iso4271Name = name;
		hasMultiplier = false;
		multiplier = 1;
		this.fullName = fullName;
	}

	/**
	 * Creates an instance with a multiplier set
	 * 
	 * @param name
	 *            The name of the currency
	 * @param rate
	 *            The rate of the currency
	 * @param multiplier
	 *            The multiplier of the currency. If this is set to 1, the
	 *            hasMultiplier method will return false. If this is set to 0,
	 *            the field inside the object will be set to 1. If this is
	 *            negative, the field inside the object will be set to positive
	 */
	public Currency(String name,String fullName, double rate, double multiplier) {
		this(name, fullName, rate);
		if (multiplier < 0) {
			this.multiplier = -1 * multiplier;
			hasMultiplier = true;
		} else {
			if (multiplier == 0) {
				this.multiplier = 1;
				hasMultiplier = false;
			} else {
				this.multiplier = multiplier;
				hasMultiplier = true;
			}
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Currency) {
			if (rate == ((Currency) obj).rate
					&& iso4271Name.equals(((Currency) obj).iso4271Name)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		String str = "";
		if (hasMultiplier)
			str += (int) multiplier;
		str += iso4271Name;
		if(fullName!=null)
			str+=" - "+fullName;
		return str;
	}

	public boolean hasMultiplier() {
		return hasMultiplier;
	}

	public String getShortName() {
		return iso4271Name;
	}
	public String getFullName(){
		return fullName;
	}

	public double getRate() {
		return rate;
	}

	public double getMultiplier() {
		return multiplier;
	}

}
