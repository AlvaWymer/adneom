package com.adneom.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

/**
 * @ClassName: DateUtil
 * @Description: DateUtil
 * @Author: Yang Naihua
 * @Create: 2018-11-20 16:55
 **/
public final class DateUtil {
    public static final DateTimeFormatter EUROPE_DATE = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static final DateTimeFormatter BASIC_ISO_DATE_TIME = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
    public static final DateTimeFormatter BASIC_ISO_DATE = DateTimeFormatter.ofPattern("yyyyMMdd");
    public static final DateTimeFormatter BEIJING_DATE = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.CHINESE);
    public static final DateTimeFormatter BEIJING_DATETIME = DateTimeFormatter.ofPattern("yyyy-dd-MM HH:mm", Locale.CHINESE);
    public static final DateTimeFormatter PARIS_DATETIME = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm", Locale.FRANCE);
    public static final DateTimeFormatter PARIS_DATE = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.FRANCE);
    public static final DateTimeFormatter EUROPE_DATETIME = DateTimeFormatter.ofPattern("yyyy-dd-MM HH:mm:ss");
    public static final DateTimeFormatter BASIC_DATETIME_NO_TIMEZONE = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static Date asDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date asDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static LocalDate asLocalDate(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static LocalDateTime asLocalDateTime(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    public static LocalDateTime getParisTimeFromUtcTime(LocalDateTime localDateTime){
        Instant instant = localDateTime.atZone(ZoneId.of("UTC")).toInstant();
        return LocalDateTime.ofInstant(instant, ZoneId.of("Europe/Paris"));
    }

    public static LocalDateTime getUtcTimeFromParisTime(LocalDateTime localDateTime){
        Instant instant = localDateTime.atZone(ZoneId.of("Europe/Paris")).toInstant();
        return LocalDateTime.ofInstant(instant, ZoneId.of("UTC"));
    }

    public static LocalDateTime getUtcTime(LocalDateTime localDateTime, ZoneId fromZone){
        Instant instant = localDateTime.atZone(fromZone).toInstant();
        return LocalDateTime.ofInstant(instant, ZoneId.of("UTC"));
    }

    public static LocalDateTime translate(LocalDateTime localDateTime, ZoneId fromZone, ZoneId toZone){
        Instant instant = localDateTime.atZone(fromZone).toInstant();
        return LocalDateTime.ofInstant(instant, toZone);
    }

    public static LocalDateTime getBasicTimeNoTimeZone(String time){
        return LocalDateTime.parse(time, BASIC_DATETIME_NO_TIMEZONE);
    }
}
