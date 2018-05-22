package com.kai;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class DateType {

    public static void main(String[] args) {
        /**
         * 日期格式正确 
         */
        String date1 = "2014-01-03";
        /**
         * 日期范围不正确---平年二月没有29号 
         */
        String date2 = "2014-02-29";
        /**
         * 日期月份范围不正确---月份没有13月 
         */
        String date3 = "2014-13-03";
        /**
         * 日期范围不正确---六月没有31号 
         */
        String date4 = "2014-06-31";
        /**
         * 日期范围不正确 ----1月超过31天 
         */
        String date5 = "2014-01-32";
        /**
         * 这个测试年份 
         */
        String date6 = "0014-01-03";

        DateSelect date = new DateSelect();

        /**
         * 打印正确日期格式 
         */
        System.out.println(date.isDate(date1));
        /**
         * 打印date1 
         */
        System.out.println(date.isDate(date2));
        /**
         * 打印date3 
         */
        System.out.println(date.isDate(date3));
        /**
         * 打印date4 
         */
        System.out.println(date.isDate(date4));
        /**
         * 打印date5 
         */
        System.out.println(date.isDate(date5));
        /**
         * 打印date6 
         */
        System.out.println(date.isDate(date6));

        System.out.println(date.isDate("333121212"));

        System.out.println(date.isDateFormat("2017-02-333"));
    }

}

class DateSelect {
    boolean isDate(String date) {
        /**
         * 判断日期格式和范围
         */
        String rexp = "[1-9]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])";

        Pattern pat = Pattern.compile(rexp);

        Matcher mat = pat.matcher(date);

        boolean dateType = mat.matches();

        return dateType;
    }

    boolean isDateFormat(String date){
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try{
            formatter.setLenient(false);
            formatter.parse(date);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}