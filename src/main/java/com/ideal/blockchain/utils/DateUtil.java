package com.ideal.blockchain.utils;

import org.thymeleaf.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static final String DEFAULT_START_DATE = "2000-01-01";

    public static final String DATE_PATTERN = "yyyyMMdd";

    public static final String DATE_PATTERN_SPACE = "yyyy-MM-dd";

    public static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm";

    public static final String DATE_TIME_NORMAL = "yyyy-MM-dd HH:mm:ss";

    private static final ThreadLocal<SimpleDateFormat> simpleDateFormat = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat(DATE_PATTERN);
        }

    };

    private static final ThreadLocal<SimpleDateFormat> dateFormat = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat(DATE_PATTERN_SPACE);
        }

    };

    private static final ThreadLocal<SimpleDateFormat> dateTimeFormat = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat(DATE_TIME_PATTERN);
        }

    };

    public static String formatStanderDate(Date date) {
        if (date == null) return "";
        return simpleDateFormat.get().format(date);
    }

    public static String formatDate(Date date) {
        if (date == null) return "";
        return dateFormat.get().format(date);
    }

    public static String formatDateTime(Date date) {
        if (date == null) return "";
        return dateTimeFormat.get().format(date);
    }

    public static String formatDate(Date date, String pattern) {
        if (date == null) return "";
        return new SimpleDateFormat(pattern).format(date);
    }

    public static Date parseDate8(String date) {
        try {
            if (StringUtils.isEmpty(date)) return null;
            return simpleDateFormat.get().parse(date);
        } catch (ParseException e) {
            return new Date();
        }
    }

    public static Date parseDate_(String date) {
        try {
            if (StringUtils.isEmpty(date)) return null;
            return dateFormat.get().parse(date);
        } catch (ParseException e) {
            return new Date();
        }
    }

    public static void main(String[] args) {
    }
}
