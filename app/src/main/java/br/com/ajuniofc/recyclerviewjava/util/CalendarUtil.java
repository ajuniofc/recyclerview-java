package br.com.ajuniofc.recyclerviewjava.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by JHUNIIN on 15/04/2018.
 */

public class CalendarUtil {
    public static Calendar parseToCalendar(String stringDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();
        try {
            Date date = dateFormat.parse(stringDate);
            calendar.setTime(date);
            return calendar;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
