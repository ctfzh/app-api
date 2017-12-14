package com.funbox.project.utils;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    public static final String formatPattern = "yyyy-MM-dd";

    public static final String formatPatternDateTime = "yyyy-MM-dd HH:mm:ss";

    public static final String formatPattern_Short = "yyyyMMdd";

    public static void main(String[] args) {
        System.out.print(getCurrentDate());
    }

    /**
     * 获取当前日期
     *
     * @return
     */
    public static String getCurrentDate() {
        SimpleDateFormat format = new SimpleDateFormat(formatPattern);
        return format.format(new Date());
    }

    public static String getCurrentDateTime() {
        SimpleDateFormat format = new SimpleDateFormat(formatPatternDateTime);
        return format.format(new Date());
    }

    /**
     * 获取制定毫秒数之前的日期
     *
     * @param timeDiff
     * @return
     */
    public static String getDesignatedDate(long timeDiff) {
        SimpleDateFormat format = new SimpleDateFormat(formatPattern);
        long nowTime = System.currentTimeMillis();
        long designTime = nowTime - timeDiff;
        return format.format(designTime);
    }

    /**
     * 获取前几天的日期
     */
    public static String getPrefixDate(String count) {
        Calendar cal = Calendar.getInstance();
        int day = 0 - Integer.parseInt(count);
        cal.add(Calendar.DATE, day); // int amount 代表天数
        Date datNew = cal.getTime();
        SimpleDateFormat format = new SimpleDateFormat(formatPattern);
        return format.format(datNew);
    }

    /**
     * 获取几分钟后的时间
     *
     * @param curDate 当前时间
     * @param minutes 几分钟
     * @return 时间
     */
    public static Date getNextMinutes(Date curDate, int minutes) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(curDate);
        cal.add(Calendar.MINUTE, minutes);
        return cal.getTime();
    }

    /**
     * 日期转换成字符串
     *
     * @param date
     * @return
     */
    public static String dateToString(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat format = new SimpleDateFormat(formatPattern);
        return format.format(date);
    }

    /**
     * 日期转换成字符串
     *
     * @param date
     * @param pattern
     * @return
     */
    public static String dateToString(Date date, String pattern) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }

    /**
     * 字符串转换日期
     *
     * @param str
     * @return
     */
    public static Date stringToDate(String str) {
        SimpleDateFormat format = new SimpleDateFormat(formatPattern);
        if (!StringUtils.isEmpty(str)) {
            try {
                return format.parse(str);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 字符串转换日期
     *
     * @param dateStr
     * @param pattern
     * @return
     */
    public static Date stringToDate(String dateStr, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        if (!StringUtils.isEmpty(dateStr)) {
            try {
                return format.parse(dateStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 获取当前日期是一周的第几天
     *
     * @param date 传入日期
     * @return int
     */
    public static int getWeeks(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_WEEK);
    }

    /**
     * 比较两个日期大小（只比较日期，不比较时间）
     *
     * @param date1
     * @param date2
     * @return int 若date1大于date2 返回1 ； 若date1等于date2 返回0； 若date1小于date2 返回-1；
     */
    public static int compareDate(Date date1, Date date2) {
        String dateStr1 = dateToString(date1);
        String dateStr2 = dateToString(date2);
        return dateStr1.compareTo(dateStr2);
    }

    /**
     * 将formatPattern格式的时间字符串dateStr转换成formatPatternShort格式的时间字符串
     *
     * @param dateStr            时间字符串
     * @param formatPattern      原始时间格式
     * @param formatPatternShort 转换后的时间格式
     * @return
     */
    public static String formatDateStrPattern(String dateStr, String formatPattern, String formatPatternShort) {
        SimpleDateFormat dfs = new SimpleDateFormat(formatPattern);
        try {
            Date date = dfs.parse(dateStr);
            SimpleDateFormat shortPattern = new SimpleDateFormat(formatPatternShort);
            return shortPattern.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取某年某月的第一天
     *
     * @param year  年份
     * @param month 月份
     * @return Date
     */
    public static Date getFirstDayByYearAndMonth(Integer year, Integer month) {
        Calendar calendar = Calendar.getInstance();
        if (NullUtil.isNull(year) || NullUtil.isNull(month) || year.intValue() <= 0 || month.intValue() <= 0) {
            return calendar.getTime();
        }
        calendar.set(year, month - 1, 1);
        return calendar.getTime();
    }

    /**
     * 获取某年某月的最后一天
     *
     * @param year  年份
     * @param month 月份
     * @return Date
     */
    public static Date getLastDayByYearAndMonth(Integer year, Integer month) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(getFirstDayByYearAndMonth(year, month));
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return calendar.getTime();
    }

    /**
     * 获取某个日期的下周一
     *
     * @param curDate 某个日期
     * @return Date
     */
    public static Date getNextMonday(Date curDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(curDate);
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        calendar.add(Calendar.DATE, 7);
        return calendar.getTime();
    }

    /**
     * 获取某个日期的下个月的第一天
     *
     * @param curDate 某个日期
     * @return Date
     */
    public static Date getNextMonthFirstDay(Date curDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(curDate);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.MONTH, 1);
        return calendar.getTime();
    }
}
