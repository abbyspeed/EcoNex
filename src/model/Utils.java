package model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Utils {
	public String dateToStringParser(Date date) {
		DateFormat dateformatter = new SimpleDateFormat("dd MMM yyyy");
		return dateformatter.format(date);
	}
	
	public void parseMonth(Date startDate, Date endDate) {
		DateTimeFormatter parser = DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.ENGLISH);
		String stringStart = dateToStringParser(startDate);
		String stringEnd = dateToStringParser(startDate);
		
        Month startMonth = Month.from(parser.parse(stringStart));
        Month endMonth = Month.from(parser.parse(stringEnd));
        
        int startMonthNumber = startMonth.getValue();
        int endMonthNumber = endMonth.getValue();
        
        System.out.println(startMonthNumber);
        System.out.println(endMonthNumber + "END");
	}
	
	public void getMonths() {
		
	}
	
//	public static List<Integer> getListMonths(Date startDate, Date endDate, Locale locale) {
//	    Calendar calendar = Calendar.getInstance(locale);
//	    calendar.setTime(startDate);
//
//	    DateTimeFormatter parser = DateTimeFormatter.ofPattern("MMM", Locale.ENGLISH);
//        Month startMonth = Month.from(parser.parse((CharSequence) startDate));
//        Month endMonth = Month.from(parser.parse((CharSequence) startDate));
//        
//        int monthNumber = month.getValue();
//	    
//	    List<String> months = new ArrayList<>();
//
//	    while (calendar.getTime().getTime() <= endDate.getTime()) {
//	        months.add(df.format(calendar.getTime()));
//	        calendar.add(Calendar.MONTH, 1);
//	    }
//
//	    return months;
//	}
}
