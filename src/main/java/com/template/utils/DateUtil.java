package com.template.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 日期工具类
 */
public final class DateUtil {

    private static final Map<String, ThreadLocal<SimpleDateFormat>> timestampFormatPool = new HashMap<String, ThreadLocal<SimpleDateFormat>>();

    private static final Map<String, ThreadLocal<SimpleDateFormat>> dateFormatPool = new HashMap<String, ThreadLocal<SimpleDateFormat>>();

    private static final Object timestampFormatLock = new Object();

    private static final Object dateFormatLock = new Object();

    private static String dateFormatPattern = "yyyy-MM-dd";

    private static String dateFormatPattern_CN = "yyyy年MM月dd日";

    private static String timestampPattern = "yyyy-MM-dd HH:mm:ss";

    private static String simplifyDatePattern = "yyyyMMdd";

    private static String simplifyTimestampPattern = "yyyyMMddHHmmss";

    private static String timestampPatternCps = "yyyyMMddHHmmss";

    private static SimpleDateFormat getDateFormatCN() {
        ThreadLocal<SimpleDateFormat> tl = dateFormatPool.get(dateFormatPattern_CN);
        if (null == tl) {
            synchronized (dateFormatLock) {
                tl = dateFormatPool.get(dateFormatPattern_CN);
                if (null == tl) {
                    tl = new ThreadLocal<SimpleDateFormat>() {
                        protected synchronized SimpleDateFormat initialValue() {
                            return new SimpleDateFormat(dateFormatPattern_CN);
                        }
                    };
                    dateFormatPool.put(dateFormatPattern_CN, tl);
                }
            }
        }
        return tl.get();
    }

    private static SimpleDateFormat getDateFormat() {
        ThreadLocal<SimpleDateFormat> tl = dateFormatPool.get(dateFormatPattern);
        if (null == tl) {
            synchronized (dateFormatLock) {
                tl = dateFormatPool.get(dateFormatPattern);
                if (null == tl) {
                    tl = new ThreadLocal<SimpleDateFormat>() {
                        protected synchronized SimpleDateFormat initialValue() {
                            return new SimpleDateFormat(dateFormatPattern);
                        }
                    };
                    dateFormatPool.put(dateFormatPattern, tl);
                }
            }
        }
        return tl.get();
    }

    public static SimpleDateFormat getTimestampFormat() {
        ThreadLocal<SimpleDateFormat> tl = timestampFormatPool.get(timestampPattern);
        if (null == tl) {
            synchronized (timestampFormatLock) {
                tl = timestampFormatPool.get(timestampPattern);
                if (null == tl) {
                    tl = new ThreadLocal<SimpleDateFormat>() {
                        protected synchronized SimpleDateFormat initialValue() {
                            return new SimpleDateFormat(timestampPattern);
                        }
                    };
                    timestampFormatPool.put(timestampPattern, tl);
                }
            }
        }
        return tl.get();
    }

    private static SimpleDateFormat getSimplifyTimestampFormat() {
        ThreadLocal<SimpleDateFormat> tl = timestampFormatPool.get(simplifyTimestampPattern);
        if (null == tl) {
            synchronized (timestampFormatLock) {
                tl = timestampFormatPool.get(simplifyTimestampPattern);
                if (null == tl) {
                    tl = new ThreadLocal<SimpleDateFormat>() {
                        protected synchronized SimpleDateFormat initialValue() {
                            return new SimpleDateFormat(simplifyTimestampPattern);
                        }
                    };
                    timestampFormatPool.put(simplifyTimestampPattern, tl);
                }
            }
        }
        return tl.get();
    }

    private static SimpleDateFormat getSimplifyDateFormat() {
        ThreadLocal<SimpleDateFormat> tl = timestampFormatPool.get(simplifyDatePattern);
        if (null == tl) {
            synchronized (timestampFormatLock) {
                tl = timestampFormatPool.get(simplifyDatePattern);
                if (null == tl) {
                    tl = new ThreadLocal<SimpleDateFormat>() {
                        protected synchronized SimpleDateFormat initialValue() {
                            return new SimpleDateFormat(simplifyDatePattern);
                        }
                    };
                    timestampFormatPool.put(simplifyDatePattern, tl);
                }
            }
        }
        return tl.get();
    }

    public static SimpleDateFormat getTimestampFormatCps() {
        ThreadLocal<SimpleDateFormat> tl = timestampFormatPool.get(timestampPatternCps);
        if (null == tl) {
            synchronized (timestampFormatLock) {
                tl = timestampFormatPool.get(timestampPatternCps);
                if (null == tl) {
                    tl = new ThreadLocal<SimpleDateFormat>() {
                        protected synchronized SimpleDateFormat initialValue() {
                            return new SimpleDateFormat(timestampPatternCps);
                        }
                    };
                    timestampFormatPool.put(timestampPatternCps, tl);
                }
            }
        }
        return tl.get();
    }

    /**
     * 格式化成时间戳格式
     * @param date	要格式化的日期对象
     * @return	"年年年年-月月-日日 时时:分分:秒秒"格式的日期字符串
     */
    public static String timestampFormat(Date date) {
        if(date == null){
            return "";
        }
        return getTimestampFormat().format(date);
    }

    /**
     * 格式化成时间戳格式
     * @param date	要格式化的日期对象
     * @return	"年年年年月月日日时时分分秒秒"格式的日期字符串
     */
    public static String simplifyTimestampFormat(Date date) {
        if(date == null){
            return "";
        }
        return getSimplifyTimestampFormat().format(date);
    }

    /**
     * 格式化成日期格式
     * @param date	要格式化的日期对象
     * @return	"年年年年月月日日"格式的日期字符串
     */
    public static String simplifyDateFormat(Date date) {
        if(date == null){
            return "";
        }
        return getSimplifyDateFormat().format(date);
    }

    /**
     * 格式化成时间戳格式
     * @param date	要格式化的日期对象
     * @return	"年年年年-月月-日日 时时:分分:秒秒"格式的日期字符串
     */
    public static String timestampFormatCps(Date date) {
        if(date == null){
            return "";
        }
        return getTimestampFormatCps().format(date);
    }

    /**
     * 格式化成Unix时间戳格式
     * @param date
     * @return
     */
    public static long unixTimestampFormat(Date date) {
        String unixDate = String.valueOf(date.getTime()).substring(0, 10);
        return Long.parseLong(unixDate);
    }

    /**
     * 格式化成时间戳格式
     * @param datetime	要格式化的日期
     * @return	"年年年年-月月-日日 时时:分分:秒秒"格式的日期字符串
     */
    public static String timestampFormat(long datetime){
        return getTimestampFormat().format(new Date(datetime));
    }

    /**
     * 将"年年年年-月月-日日 时时:分分:秒秒"格式的日期字符串转换成Long型日期
     * @param timestampStr	年年年年-月月-日日 时时:分分:秒秒"格式的日期字符串
     * @return	Long型日期
     */
    public static long formatTimestampToLong(String timestampStr){
        try {
            return getTimestampFormat().parse(timestampStr).getTime();
        } catch (ParseException e) {
            return 0L;
        }
    }

    /**
     * 将"年年年年-月月-日日 时时:分分:秒秒"格式的日期字符串转换成日期
     * @param timestampStr	年年年年-月月-日日 时时:分分:秒秒"格式的日期字符串
     * @return	日期
     */
    public static Date formatTimestampToDate(String timestampStr){
        try {
            return getTimestampFormat().parse(timestampStr);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 将"年年年年-月月-日日"格式的日期字符串转换成日期
     * @param dateStr	年年年年-月月-日日"格式的日期字符串
     * @return	日期
     */
    public static Date formatDateToDate(String dateStr) {
        try {
            return getDateFormat().parse(dateStr);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 格式化成日期格式
     * @param date	要格式化的日期
     * @return	"年年年年-月月-日日"格式的日期字符串
     */
    public static String dateFormat(Date date){
        if (date == null) {
            return "";
        }
        return getDateFormat().format(date);
    }

    /**
     * 格式化成日期格式
     * @param date	要格式化的日期
     * @return	"××××年××月××日"格式的日期字符串
     */
    public static String dateFormatCN(Date date){
        if (date == null) {
            return "";
        }
        return getDateFormatCN().format(date);
    }

    /**
     * 格式化成日期格式
     * @param datetime	要格式化的日期
     * @return	"年年年年-月月-日日"格式的日期字符串
     */
    public static String dateFormat(long datetime){
        return getDateFormat().format(new Date(datetime));
    }

    /**
     * 将"年年年年-月月-日日"格式的日期字符串转换成Long型日期
     * @param dateStr	"年年年年-月月-日日"格式的日期字符串
     * @return	Long型日期
     */
    public static long formatDateToLong(String dateStr) {
        try {
            return getDateFormat().parse(dateStr).getTime();
        } catch (ParseException e) {
            return 0L;
        }
    }

    /**
     * 得到本月的第一天
     * @return	以"年年年年-月月-日日"格式返回当前月第一天的日期
     */
    public static String getFirstDayOfCurrentMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        return getDateFormat().format(calendar.getTime());
    }

    /**
     * 得到本月的最后一天
     * @return	以"年年年年-月月-日日"格式返回当前月最后一天的日期
     */
    public static String getLastDayOfCurrentMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return getDateFormat().format(calendar.getTime());
    }

    /**
     * 获取当前日期前（后）的某一天
     * @param offset	偏移量，即当前日期之前（后）多少天，如果是之前，offset为负的整数
     * @return	以"年年年年-月月-日日"格式返回要获取的日期
     */
    public static String getDayAfterCurrentDate(int offset) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, offset);
        return calendar.getTime().toString();
    }

    /**
     * 返回以当前时间为基准的七日的结束销售时间
     * @return
     */
    public static Date getSevenDaysAfterOnSale() {
        Calendar calendarAdd = Calendar.getInstance();
        calendarAdd.setTime(new Date());

        calendarAdd.add(Calendar.DAY_OF_MONTH, 6);
        calendarAdd.set(Calendar.HOUR_OF_DAY, 23);
        calendarAdd.set(Calendar.MINUTE, 59);
        calendarAdd.set(Calendar.SECOND, 59);
        return calendarAdd.getTime();
    }

    /**
     * 根据指定的时间参数获取时间
     * @return
     */
    public static Date getTimeByIdentifiedValues(Integer year, Integer month, Integer day, Integer hour,
                                                 Integer minute, Integer second) {
        Calendar calendarAdd = Calendar.getInstance();
        calendarAdd.setTime(new Date());

        calendarAdd.add(Calendar.DAY_OF_MONTH, month);
        calendarAdd.set(Calendar.HOUR_OF_DAY, day);
        calendarAdd.set(Calendar.MINUTE, minute);
        calendarAdd.set(Calendar.SECOND, second);
        return calendarAdd.getTime();
    }

    /**
     * 获取默认日期时间
     * @return
     */
    public static Date getDefaultDateTime() {
        return new Date(formatTimestampToDate("1970-01-01 00:00:00").getTime());
    }
    //未完，待续
    //获取指定日期的前一天
    public static String getSpecifiedDayBefore(String specifiedDay){
//SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        Date date=null;
        try {
            date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.setTime(date);
        int day=c.get(Calendar.DATE);
        c.set(Calendar.DATE,day-1);

        String dayBefore=new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
        return dayBefore;
    }
    //获取指定日期的前，后 几天
    public static String getSpecifiedDayBefore(String specifiedDay,int num){
//SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        Date date=null;
        try {
            date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.setTime(date);
        int day=c.get(Calendar.DATE);
        c.set(Calendar.DATE,day+num);

        String dayBefore=new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
        return dayBefore;
    }
    /**
     * 获得指定日期的后一天
     * @param specifiedDay
     * @return
     */
    public static String getSpecifiedDayAfter(String specifiedDay){
        Calendar c = Calendar.getInstance();
        Date date=null;
        try {
            date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.setTime(date);
        int day=c.get(Calendar.DATE);
        c.set(Calendar.DATE,day+1);

        String dayAfter=new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
        return dayAfter;
    }

    public static String getDatetime(String timest){
        Long second=Long.parseLong(timest);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(second * 1000L);//转换为毫秒
        Date date = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String dateString = format.format(date);
        return dateString;
    }

    /**
     * create by:ZYP
     * description:
     * create time: 19:50 2018/8/29
     *
     * @return a
     * @Param: null
    */
    public static Date transForDate(Integer ms) {
        if (ms == null) {
            ms = 0;
        }
        long msl = (long) ms * 1000;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date temp = null;
        if (ms != null) {
            try {
                String str = sdf.format(msl);
                temp = sdf.parse(str);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return temp;
    }
    /**
     * 日期转时间戳
     * @param date
     * @return
     */
    public static Integer transForMilliSecond(String time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (date == null) return null;
        return (int) (date.getTime() / 1000);
    }


    private static byte[] lock = new byte[0];

    // 位数，默认是8位
    private final static long w = 100000000;

    public static String createID() {
        long r = 0;
        synchronized (lock) {
            r = (long) ((Math.random() + 1) * w);
        }

        return System.currentTimeMillis() + String.valueOf(r).substring(1);
    }

}
