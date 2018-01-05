package com.kai;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;

/**
 * Created by FengKai on 2018/1/5.
 */
public class Main16 {
    /**
     * 时间日期 API
     * @param args
     */
    public static void main(String[] args) {
        //Clock
        /*
        Clock提供了对当前时间和日期的访问功能。Clock是对当前时区敏感的，并可用于
        替代System.currentTimeMillis()方法来获取当前的毫秒时间。当前时间线上的时刻
        可以用instant类来表示。instant也能够用于创建原先的java.util.Date对象。
         */
        Clock clock = Clock.systemDefaultZone();
        System.out.println(clock.getZone());//p Asia/Shanghai
        System.out.println(clock.millis());//等于System.currentTimeMillis()
        Instant instant = clock.instant();
        System.out.println(instant);//p 2018-01-05T02:53:31.715Z
        System.out.println(Date.from(instant));//instant 转为 Date 类型

        //Timezones
        System.out.println(ZoneId.getAvailableZoneIds());
        ZoneId zoneId1 = ZoneId.of("America/Toronto");
        ZoneId zoneId2 = ZoneId.of("Europe/Nicosia");
        System.out.println(zoneId1.getRules());
        System.out.println(zoneId2.getRules());

        //LocalTime
        LocalTime localTimeNow1 = LocalTime.now(zoneId1);
        LocalTime localTimeNow2 = LocalTime.now(zoneId2);

        System.out.println(localTimeNow1.isBefore(localTimeNow2));
        long hourBetween = ChronoUnit.HOURS.between(localTimeNow1,localTimeNow2);
        long minBetween = ChronoUnit.MINUTES.between(localTimeNow1,localTimeNow2);

        System.out.println(hourBetween);
        System.out.println(minBetween);

        //LocalTime是由多个工厂方法组成
        LocalTime localTime3 = LocalTime.of(12,59,59);
        System.out.println(localTime3);
        //DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).withLocale(Locale.CHINA);
        //LocalTime localTime4 = LocalTime.parse("13:37",dateTimeFormatter);
        //System.out.println(localTime4);

        //LocalDate
        //LocalDateTime

    }
}
