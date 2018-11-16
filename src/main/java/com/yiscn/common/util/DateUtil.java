package com.yiscn.common.util;

import org.joda.time.Interval;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * Created by DengLibin on 2017/5/27.
 */
public class DateUtil {
    /**
     * 以指定格式获取当前时间的字符串
     * @param pattern
     * @return
     */
    public static String getNowDate( String pattern){
        // 线程安全的格式化类，不用每次都new个SimpleDateFormat
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        LocalDateTime localDateTime = LocalDateTime.now();
        return dateTimeFormatter.format(localDateTime);
    }
    public static String getNowDateString(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        return dateTimeFormatter.format(localDateTime);
    }
    /**
     * 字符串转日期
     * @param dateTime
     * @param pattern
     * @return
     */
    public static LocalDateTime parseDateTime(String dateTime,String pattern){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDateTime.parse(dateTime,dateTimeFormatter);
    }


    /**
     * 获取年份
     * @return
     */
    public static int getYear(){
        /*Year year = Year.now();
        return Integer.parseInt(year.toString());*/
        return LocalDate.now().getYear();
    }

    /**
     * 获取月份
     * @return
     */
    public static int getMonth(){
       /* Calendar calendar=Calendar.getInstance();
        int month=calendar.get(Calendar.MONTH)+1; //获得当前时间的月份，月份从0开始所以结果要加1
        return month;*/
        Month month = LocalDate.now().getMonth();
        return  month.getValue();

    }

    /**
     * 获取第几号
     * @return
     */
    public static int getDay(){
       /* Calendar calendar=Calendar.getInstance();
        //获得当前时间的月份，月份从0开始所以结果要加1
        int day=calendar.get(Calendar.DAY_OF_MONTH);
        return day;*/
        return  LocalDate.now().getDayOfMonth();
    }

    public static Date getDate(String dateStr,String pattern){
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
    /**
     * 星期
     * @param localDate
     * @return
     */
    public static String getWeekOfDate(LocalDate localDate) {
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        int w = dayOfWeek.getValue();
        if (w < 0 || w >=7)
            w = 0;
        return weekDays[w];
    }
    public static int getDayOfWeek(LocalDate localDate){
        return localDate.getDayOfWeek().getValue();
    }

    /**
     * 判断是否是闰年
     * @param year
     * @return
     */
    public static boolean isLeapYear(int year){
        Year y = Year.of(year);
        return y.isLeap();
    }

    /**
     * 根据年份数，该年的月份数,该月的天数 返回日期
     * @param year
     * @param month
     * @param days
     * @return
     */
    public static LocalDate getDate(int year,int month,int days){
        Year y = Year.of(year);
        YearMonth yearMonth = y.atMonth(month);
        LocalDate localDate = yearMonth.atDay(days);
        return localDate;

    }

    /**
     * 如果某年是平年，但天数如果写的是29会自动转成28
     * @param year
     * @param month
     * @param days
     * @return
     */
    public static LocalDate getDateAutoParse(int year,int month,int days){
        MonthDay monthDay = MonthDay.of(month,days);
        return monthDay.atYear(year);
    }
    public static String getDateString(int year,int month,int day){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        MonthDay monthDay = MonthDay.of(month,day);
       LocalDate date =  monthDay.atYear(year);
       return dateTimeFormatter.format(date);
    }
    public static String getDateTimeString(LocalDate localDate){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return dateTimeFormatter.format(localDate);
    }

    /**
     * 当前日期的下几个日期
     * @param localDate
     * @return
     */
    public static  String getNextDate(LocalDate localDate,int i,String pattern){
        LocalDate  nextDate = localDate.plusDays(i);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        return dateTimeFormatter.format(nextDate);

    }

    /**
     * 当前日期的下几个日期
     * @param localDate
     * @param i
     * @return
     */
    public static  LocalDate getNextDate(LocalDate localDate,int i){
        LocalDate  nextDate = localDate.plusDays(i);
        return nextDate;

    }

    /**
     * 今天的日期
     * @param pattern
     * @return
     */
    public String getDateToDay(String pattern){
        LocalDate today = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        return dateTimeFormatter.format(today);
    }

    /**
     * 计算两个日期之间天数
     * @param date1
     * @param date2
     * @return
     */
    public static long caculateDays(LocalDate date1,LocalDate date2){

        return ChronoUnit.DAYS.between(date1,date2);
    }

    /**
     * 计算两个日期之间的分钟数
     * @param time1
     * @param time2
     * @return
     */
    public static long caculateMinutes(LocalDateTime time1,LocalDateTime time2){
        return ChronoUnit.MINUTES.between(time1,time2);
    }

    /**
     * 计算两个日期之间的秒钟数
     * @param time1
     * @param time2
     * @return
     */
    public static long caculateSeconds(LocalDateTime time1,LocalDateTime time2){
        return ChronoUnit.SECONDS.between(time1,time2);
    }

    /**
     * Date和LocalDateTime互转
     * @param date
     * @return
     */
    public static LocalDateTime getFromDate(Date date){
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        return  LocalDateTime.ofInstant(instant,zoneId);
    }
    public static String formatDate(LocalDateTime time){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        return dateTimeFormatter.format(localDateTime);
    }
    public static Date getDateNow(){
        ZoneId zoneId = ZoneId.of("GMT+08");
        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime zdt = localDateTime.atZone(zoneId);

        Date date = Date.from(zdt.toInstant());
        return date;
    }

    /**
     * 设置指定日期时间
     * @param year
     * @param month
     * @param day
     * @param hour
     * @param min
     * @param second
     * @return
     */
    public static LocalDateTime getLocalDateTime(int year,int month,int day,int hour,int min,int second){
        LocalDateTime of = LocalDateTime.of(year, month, day, hour, min, second);
        return  of;
    }

    //yyyy-MM-dd
    public static LocalDate getLocalDate(String date) {
        return LocalDate.parse(date);
    }

    public static int getHour() {
        return LocalDateTime.now().getHour();
    }

    //通过毫秒数返回日期时间
    public static String getDateTimeStringByMil(long millisecond ) {
        Date date = new Date(millisecond);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }
    //通过毫秒数返回日期
    public static String getDateStringByMil(long millisecond ) {
        Date date = new Date(millisecond);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }

    public static long getMillisecond(){
        return new Date().getTime();
    }

    //获取毫秒数
    public static long getMillisecondByDateTimeString(String dateTime, String pattern) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return  format.parse(dateTime).getTime();
    }

    /**
     * 计算时差
     * @param startTime 开始时间戳
     * @param endTime 结束时间戳
     * @return
     */
    public static IntervalBo getInterval(long startTime, long endTime){
        Interval interval =
                new Interval(startTime, endTime);
        org.joda.time.Period period = interval.toPeriod();
        IntervalBo intervalBo = new IntervalBo();
        intervalBo.setPeriodYear(period.getYears());
        intervalBo.setPeriodMonth(period.getMonths());
        intervalBo.setPeriodDay(period.getDays());
        intervalBo.setPeriodHour(period.getHours());
        intervalBo.setPeriodMinute(period.getMinutes());
        intervalBo.setPeriodSecond(period.getSeconds());
        return  intervalBo;

    }


    public static class IntervalBo{
        private  int periodYear;
        private  int periodMonth;
        private  int periodDay;
        private  int periodHour;
        private  int periodMinute;
        private  int periodSecond;

        public int getPeriodYear() {
            return periodYear;
        }

        public void setPeriodYear(int periodYear) {
            this.periodYear = periodYear;
        }

        public int getPeriodMonth() {
            return periodMonth;
        }

        public void setPeriodMonth(int periodMonth) {
            this.periodMonth = periodMonth;
        }

        public int getPeriodDay() {
            return periodDay;
        }

        public void setPeriodDay(int periodDay) {
            this.periodDay = periodDay;
        }

        public int getPeriodHour() {
            return periodHour;
        }

        public void setPeriodHour(int periodHour) {
            this.periodHour = periodHour;
        }

        public int getPeriodMinute() {
            return periodMinute;
        }

        public void setPeriodMinute(int periodMinute) {
            this.periodMinute = periodMinute;
        }

        public int getPeriodSecond() {
            return periodSecond;
        }

        public void setPeriodSecond(int periodSecond) {
            this.periodSecond = periodSecond;
        }
    }
}
