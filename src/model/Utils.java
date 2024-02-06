package model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

public class Utils {
	public String dateToStringParser(Date date) {
		DateFormat dateformatter = new SimpleDateFormat("dd MMM yyyy");
		return dateformatter.format(date);
	}
}
