package org.baltoaca.conv_valut.xml;

import java.text.DateFormat;
import java.util.Calendar;

import org.baltoaca.conv_valut.thread.Main;

public class XmlDateFormatter {
	DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG,Main.locale);
	
	public String formatDateFromCalendar(Calendar calendar){
		return dateFormat.format(calendar.getTime());
	}

}
