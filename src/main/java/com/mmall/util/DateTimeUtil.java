package com.mmall.util;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Date;

/**
 * @auther 李明浩
 * @date 9/27/2018 3:23 PM
 */
public class DateTimeUtil {
        //利用开源joda-time
        //string -date
        //date --str
        public static final String STANDARD_FORMAT = "yyyy-MM-dd HH:mm:ss";
        //提供两个方法，日期转字符串和字符串转日期
        public static Date strToDate(String dateTimeStr, String formatStr){
            DateTimeFormatter dateTimeFormat = DateTimeFormat.forPattern(formatStr);
            DateTime dateTime = dateTimeFormat.parseDateTime(dateTimeStr);
            return dateTime.toDate();
        }
        public static String dateToStr(Date date,String formatStr){
            if(date == null){
                return StringUtils.EMPTY;
            }
            DateTime dateTime = new DateTime(date);
            return dateTime.toString(formatStr);
        }

        public static Date strToDate(String dateTimeStr){
            DateTimeFormatter dateTimeFormat = DateTimeFormat.forPattern(STANDARD_FORMAT);
            DateTime dateTime = dateTimeFormat.parseDateTime(dateTimeStr);
            return dateTime.toDate();
        }
        public static String dateToStr(Date date){
            if(date == null){
                return StringUtils.EMPTY;
            }
            DateTime dateTime = new DateTime(date);
            return dateTime.toString(STANDARD_FORMAT);
        }
}
