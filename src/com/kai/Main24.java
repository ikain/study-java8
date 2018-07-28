package com.kai;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by FengKai on 2018/7/25.
 */
public class Main24 {

    public static void main(String[] args) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date birthdayDate = df.parse("2018-09-10");
            System.out.println(birthdayDate.getTime());
            Calendar calendar = dateToCalendar(birthdayDate);
            System.out.println(calendar.getTimeInMillis());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static Calendar dateToCalendar(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }
}
