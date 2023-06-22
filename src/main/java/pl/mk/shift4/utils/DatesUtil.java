package pl.mk.shift4.utils;

import java.text.DateFormatSymbols;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DatesUtil {

    public static String getDayOfWeekName(int dayOfWeek) {
        DateFormatSymbols dfs = new DateFormatSymbols(Locale.ENGLISH);
        String[] months = dfs.getShortWeekdays();
        return months[dayOfWeek + 1].toUpperCase();
    }

    public static String getMonthName(int month) {
        DateFormatSymbols dfs = new DateFormatSymbols(Locale.ENGLISH);
        String[] months = dfs.getShortMonths();
        return months[month - 1].toUpperCase();
    }
}
