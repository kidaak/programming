package org.myapp.text;

import java.text.DateFormat;
import java.util.Locale;

import org.zkoss.text.DateFormatInfo;

public class MyDateTimeFormat implements DateFormatInfo {

	@Override
	public String getDateFormat(int style, Locale locale) {
		String format = null;
		switch (style) {
		case DateFormat.SHORT:
			format = "dd-MM-yy";
			break;
		case DateFormat.MEDIUM:
			format = "dd-MM-yyyy";
			break;
		case DateFormat.LONG:
			format = "dd-MM-yyyy hh:mm";
			break;
		case DateFormat.FULL:
			format = "dd-MM-yyyy hh:mm:ss";
			break;
		}
		return format;
	}

	@Override
	public String getTimeFormat(int style, Locale locale) {
		String format = null;
		System.out.println(locale.getLanguage());
		switch (locale.getLanguage()) {
		case "us":
			format = "hh:mm";
			break;
		case "vi":
			format = "hh:mm:ss";
			break;
		default:
			break;
		}
		return format;
	}

	@Override
	public String getDateTimeFormat(int dateStyle, int timeStyle, Locale locale) {
		// TODO Auto-generated method stub
		return null;
	}

}
