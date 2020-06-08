package cn.com.liandisys.util.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期处理类
 * 
 * @author b_daiyq
 */
public class DateUtil {

    /** yyyy-MM-dd HH:mm:ss. */
    public static final String FORMAT_DATE_TIME_1 = "yyyy-MM-dd HH:mm:ss";

    /** yyyy/MM/dd HH:mm:ss. */
    public static final String FORMAT_DATE_TIME_2 = "yyyy/MM/dd HH:mm:ss";

    /** yyyyMMddHHmmss. */
    public static final String FORMAT_DATE_TIME_3 = "yyyyMMddHHmmss";

    /** yyyy-MM-dd HH:mm. */
    public static final String FORMAT_DATE_TIME_4 = "yyyy-MM-dd HH:mm";

    /** yyyy/MM/dd HH:mm. */
    public static final String FORMAT_DATE_TIME_5 = "yyyy/MM/dd HH:mm";

    /** yyyy-MM-dd HH:mm:ss.SSS. */
    public static final String FORMAT_DATE_TIME_7 = "yyyy-MM-dd HH:mm:ss.SSS";

    /** yyyymmdd-hhmmssSSS */
    public static final String FORMAT_DATE_TIME_8 = "yyyyMMdd-HHmmssSSS";

    /** yyyymmdd-hhmmssSSS */
    public static final String FORMAT_DATE_TIME_9 = "yyyyMM";

    /** yyyymmdd */
    public static final String FORMAT_DATE_TIME_10 = "yyyyMMdd";

    /** yyyy年MM月dd日_HH:mm */
    public static final String FORMAT_DATE_TIME_11 = "yyyy年MM月dd日_HH:mm";

    /** yyyy年MM月dd日HH时mm分ss秒 */
    public static final String FORMAT_DATE_TIME_12 = "yyyy年MM月dd日HH时mm分ss秒";

    /** yyyy年MM月dd日_HH：mm：ss */
    public static final String FORMAT_DATE_TIME_13 = "yyyy年MM月dd日_HH：mm：ss";

    /** YYYY-MM-DD */
    public static final String FORMAT_DATE_TIME_14 = "yyyy-MM-dd";
    
    /** YYYY年MM月DD日  */
    public static final String FORMAT_DATE_TIME_15 = "yyyy年MM月dd日";
    
    /** yyyy-MM-dd hh24:mi:ss */
    public static final String FORMAT_DATE_TIME_ORACLE = "yyyy-MM-dd hh24:mi:ss";
    
    /** yyyy-MM-dd hh24:mi:ss:FF1 */
    public static final String FORMAT_DATE_TIME_ORACLE_MILLI = "yyyy-MM-dd hh24:mi:ss.FF1";

    public static Timestamp getCurrentTimestamp() {

        Date date = new Date();
        Timestamp nousedate = new Timestamp(date.getTime());
        return nousedate;
    }
    
    /**
	 * 使用用户格式提取字符串日期 时间转换 String -> Date
	 * 
	 * @param strDate
	 *            日期字符串
	 * @param pattern
	 *            日期格式
	 * @return 用户格式提取字符串日期
	 */
	public static Date parse(String strDate, String pattern) {
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		try {
			return df.parse(strDate);
		} catch (ParseException e) {
			return null;
		}
	}
    
    /**
     * 将一个Timestamp格式化为字符
     * 
     * @param date
     * @param toFormat
     * @return
     */
    public static String toString(Timestamp ts, String toFormat) {

        if (ts == null) {
            return null;
        }

        SimpleDateFormat df = new SimpleDateFormat(toFormat);
        df.setLenient(false);
        return df.format(new Date(ts.getTime()));
    }

    /**
     * 将一个Date格式化为字符
     * 
     * @param date
     * @param toFormat
     * @return
     */
    public static String toString(Date date, String toFormat) {

        if (date == null) {
            return null;
        }

        SimpleDateFormat df = new SimpleDateFormat(toFormat);
        df.setLenient(false);
        return df.format(date);
    }

    /**
     * 指定日期格式的文字列转换为Timestamp
     * 
     * @param sDate 日期文字列
     * @param sFmt 指定的格式
     * @return 转换后的Timestamp
     */
    public static Timestamp toTimestamp(String sDate, String sFmt) {

        SimpleDateFormat sdfFrom = null;
        Timestamp ts = null;

        try {
            sdfFrom = new SimpleDateFormat(sFmt);

            Date date = sdfFrom.parse(sDate);
            ts = new Timestamp(date.getTime());
        } catch (ParseException e) {
            return null;
        } finally {
            sdfFrom = null;
        }

        return ts;
    }

    /**
     * 获取今天N天之前的时间戳
     * 
     * @return
     */
    public static Timestamp getNDaysBefore(int n) {

        Calendar calender = Calendar.getInstance();
        calender.setTime(new Date());
        calender.add(Calendar.DAY_OF_MONTH, -n);
        return new Timestamp(calender.getTimeInMillis());
    }

    /**
     * 获取给定时间戳的N天之前的时间戳
     * 
     * @param ts
     * @param n
     * @return
     */
    public static Timestamp getNDaysBefore(Timestamp ts, long n) {

        return new Timestamp(ts.getTime() - n * 24 * 60 * 60 * 1000);
    }

    /**
     * 获取给定时间戳的N天之后的时间戳
     * 
     * @param ts
     * @param n
     * @return
     */
    public static Timestamp getNDaysAfter(Timestamp ts, long n) {

        return new Timestamp(ts.getTime() + n * 24 * 60 * 60 * 1000);
    }

    /**
     * 获取给定时间戳的N小时之后的时间戳
     * 
     * @param ts 给定时间
     * @param hours 小时数
     * @return 给定时间戳的N小时之后的时间戳
     */
    public static Timestamp getNHourAfter(Timestamp ts, long hours) {

        return new Timestamp(ts.getTime() + hours * 60 * 60 * 1000);

    }

    /**
     * 获取给定时间戳的N小时之前的时间戳
     * 
     * @param ts 给定时间
     * @param hours 小时数
     * @return 给定时间戳的N小时之前的时间戳
     */
    public static Timestamp getNHourBefore(Timestamp ts, long hours) {

        return new Timestamp(ts.getTime() - hours * 60 * 60 * 1000);

    }

    /**
     * 获取给定时间戳的N分钟之后的时间戳
     * 
     * @param ts
     * @param minute
     * @return Timestamp
     */
    public static Timestamp getNMinuteAfter(Timestamp ts, long minute) {

        return new Timestamp(ts.getTime() + minute * 60 * 1000);

    }

    /**
     * 获取给定时间戳的N分钟之前的时间戳
     * 
     * @param ts 如果没有给定时间，采用当前时间往前推
     * @param minute
     * @return Timestamp
     */
    public static Timestamp getNMinuteBefore(Timestamp ts, long minute) {

        if(ts == null) {
            ts = new Timestamp((new Date()).getTime());
        }
        return new Timestamp(ts.getTime() - minute * 60 * 1000);

    }

    /**
     * 获取给定时间戳的N秒之后的时间戳
     * 
     * @param ts
     * @param second
     * @return Timestamp
     */
    public static Timestamp getNSecondAfter(Timestamp ts, long second) {

        return new Timestamp(ts.getTime() + second * 1000);

    }

    /**
     * 获取给定时间戳的N秒之前的时间戳
     * 
     * @param ts
     * @param second
     * @return Timestamp
     */
    public static Timestamp getNSecondBefore(Timestamp ts, long second) {

        return new Timestamp(ts.getTime() - second * 1000);

    }

    /**
     * 将世界时转换为北京时间
     * 
     * @param universalTime 世界时间
     * @return 北京时间
     */
    public static Timestamp convertUTimeoBjTime(Timestamp universalTime) {

        return getNHourAfter(universalTime, 8);
    }

    /**
     * 返回当日凌晨00:00:00的时间
     * 
     * @return Timestamp
     */
    public static Timestamp getCurrentZeroTime() {

        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.HOUR_OF_DAY, 0);
        ca.set(Calendar.MINUTE, 0);
        ca.set(Calendar.SECOND, 0);
        ca.set(Calendar.MILLISECOND, 0);

        return new Timestamp(ca.getTimeInMillis());
    }

    /**
     * 返回当日10:00:00的时间
     * 
     * @return Timestamp
     */
    public static Timestamp getCurrentTenTime() {

        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.HOUR_OF_DAY, 10);
        ca.set(Calendar.MINUTE, 0);
        ca.set(Calendar.SECOND, 0);
        ca.set(Calendar.MILLISECOND, 0);

        return new Timestamp(ca.getTimeInMillis());
    }

    /**
     * 返回当日15:00:00的时间
     * 
     * @return Timestamp
     */
    public static Timestamp getCurrentFiftnTime() {

        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.HOUR_OF_DAY, 15);
        ca.set(Calendar.MINUTE, 0);
        ca.set(Calendar.SECOND, 0);
        ca.set(Calendar.MILLISECOND, 0);

        return new Timestamp(ca.getTimeInMillis());
    }

    /**
     * 返回当日16:00:00的时间
     * 
     * @return Timestamp
     */
    public static Timestamp getCurrentSixtnTime() {

        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.HOUR_OF_DAY, 16);
        ca.set(Calendar.MINUTE, 0);
        ca.set(Calendar.SECOND, 0);
        ca.set(Calendar.MILLISECOND, 0);

        return new Timestamp(ca.getTimeInMillis());
    }

    /**
     * 返回给定日期前一天的零点时刻
     * 
     * @param ts
     * @return Timestamp
     */
    public static Timestamp getLastDayZeroTime(Timestamp ts) {

        Calendar ca = Calendar.getInstance();
        ca.setTimeInMillis(ts.getTime() - 24 * 60 * 60 * 1000); // 使用给定时间减去24小时进行设定
        ca.set(Calendar.HOUR_OF_DAY, 0);
        ca.set(Calendar.MINUTE, 0);
        ca.set(Calendar.SECOND, 0);
        ca.set(Calendar.MILLISECOND, 0);

        return new Timestamp(ca.getTimeInMillis());
    }
    
    
    /**
     * 返回相隔n天的0点
     * 
     * @param ts
     * @return Timestamp
     */
    public static Timestamp getNDayZeroTime(Timestamp ts, int n) {

        Calendar ca = Calendar.getInstance();
        ca.setTimeInMillis(ts.getTime() + 24 * 60 * 60 * 1000*n); // 使用给定时间减去24小时进行设定
        ca.set(Calendar.HOUR_OF_DAY, 0);
        ca.set(Calendar.MINUTE, 0);
        ca.set(Calendar.SECOND, 0);
        ca.set(Calendar.MILLISECOND, 0);

        return new Timestamp(ca.getTimeInMillis());
    }

    /**
     * 返回给定日期当天的零点时刻
     * 
     * @param ts
     * @return Timestamp
     */
    public static Timestamp getThisDayZeroTime(Timestamp ts) {

        Calendar ca = Calendar.getInstance();
        ca.setTimeInMillis(ts.getTime());
        ca.set(Calendar.HOUR_OF_DAY, 0);
        ca.set(Calendar.MINUTE, 0);
        ca.set(Calendar.SECOND, 0);
        ca.set(Calendar.MILLISECOND, 0);

        return new Timestamp(ca.getTimeInMillis());
    }

    /**
     * 返回给定日期后一天的23:59:59时刻
     * 
     * @param ts
     * @return Timestamp
     */
    public static Timestamp getNextDayEndTime(Timestamp ts) {

        Calendar ca = Calendar.getInstance();
        ca.setTimeInMillis(ts.getTime() + 24 * 60 * 60 * 1000); // 使用给定时间加上24小时进行设定
        ca.set(Calendar.HOUR_OF_DAY, 23);
        ca.set(Calendar.MINUTE, 59);
        ca.set(Calendar.SECOND, 59);
        ca.set(Calendar.MILLISECOND, 999);

        return new Timestamp(ca.getTimeInMillis());
    }

    /**
     * 返回两个时间戳之间的时间差
     * 
     * @param t1
     * @param t2
     * @return long
     */
    public static long getTimeInterval(Timestamp t1, Timestamp t2) {

        return Math.abs(t1.getTime() - t2.getTime());
    }

    /**
     * 根据与1970-01-01的相对天数值与分钟值返回时间戳
     * 
     * @param dayNum
     * @return
     */
    public static Timestamp getTimeStampByDayNumAndMinuteNum(int dayNum, int minuteNum) {

        // 根据与1970-01-01的相对天数与当天的绝对分钟数返回时间戳
        return new Timestamp((((long) dayNum) * 24 * 60 + (long) minuteNum) * 60 * 1000);
    }

    /**
     * 根据与1970-01-01的相对天数值与分钟值返回时间戳
     * 
     * @param dayNum
     * @param minuteNum
     * @return
     */
    public static Timestamp getTimeStampByDayNumAndMinuteNumWisjoy(int dayNum, int minuteNum) {

        // 根据与1970-01-01的相对天数与当天的绝对分钟数返回时间戳
        return new Timestamp((((long) dayNum) * 24 * 60 * 60 * 1000));
    }

    /**
     * 根据日期和分钟转换时间
     * 
     * @param date
     * @param min
     * @return
     */
    public static Timestamp exChangeTimeStamp(String date, long min) {

        String minute = "";
        long t1 = min - 5;
        long hour = 0;
        long mi = 0;
        if (t1 < 60) {
            if (t1 < 10) {
                minute = " 00:0" + t1 + ":00";
            } else {
                minute = " 00:" + t1 + ":00";
            }
        } else {
            hour = t1 / 60;
            mi = t1 % 60;
            if (hour < 10) {
                minute = " 0" + hour + ":";
            } else {
                minute = " " + hour + ":";
            }
            if (mi < 10) {
                minute = minute + "0" + mi + ":00";
            } else {
                minute = minute + mi + ":00";
            }
        }
        String time = date + minute;
        Timestamp ts = Timestamp.valueOf(time);

        return ts;
    }

    /**
     * 获取传入的时间参数与1970-01-01之间的相对天数值
     * 
     * @param ts
     * @return
     */
    public static int getDayNumByTimestamp(Timestamp ts) {

        ts = getThisDayZeroTime(ts);
        // 计算天数差值(ts----1970-01-01)
        return (int) (ts.getTime() / 1000 / 60 / 60 / 24) + 1;
    }

    /**
     * 获取当前时间，精确到小时，满足定时任务每两个小时抓取一次数据（作为当日零点时间处理）
     * 
     * @return
     */
    public static Timestamp getCurrentHourTime() {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String runDate = df.format(new Timestamp(System.currentTimeMillis()));
        int min = Integer.valueOf(runDate.substring(14, 16));
        if(min > 30){
            min = 3;
        } else {
            min = 0;
        }
        runDate = runDate.substring(0, 14) + min + "0:00";
        return Timestamp.valueOf(runDate);
    }

    /**
     * 为了防止同一批数据中有时间戳重叠的情况，对时间戳的毫秒位加上一个随机数（0.0-1.0）
     * 
     * @param milliSecond
     * @return
     */
    public static int getMilliSecond(int milliSecond) {

        return milliSecond * 1000000 + (int) (Math.random() * 1000000);
    }

    /**
     * 根据开始时间获取结束时间
     * 
     * @param beginTime
     * @param nDays 开始时间后nDays天为结束时间
     */
    public static Timestamp getEndTime(Timestamp beginTime, int nDays) {

        Timestamp endTime = null, tCurrentHour = null;
        // 本次程序抓取数据结束时间定义为开始时间后nDays天后
        endTime = getNDaysAfter(beginTime, nDays);
        // 获取系统当前时间
        tCurrentHour = getCurrentHourTime();
        if (endTime.after(tCurrentHour)) {
            // 如果结束时间大于当日零时时间，则选择当日零时时间作为结束时间
            endTime = tCurrentHour;
        }
        return endTime;
    }

    /**
     * 比较结束时间和现在时间，取较早的时间
     * 
     * @param endTime 结束时间
     * @return
     */
    public static Timestamp checkEndTime(Timestamp endTime) {

        Timestamp currentHour = DateUtil.getCurrentHourTime();
        if (endTime.after(currentHour)) {
            endTime = currentHour;
        }
        return endTime;
    }
    
    /**
     * 比较结束时间和现在时间，取较早的时间
     * 
     * @param endTime 结束时间
     * @return
     */
    public static Timestamp checkEndTimeWithSixteen(Timestamp endTime) {

        Timestamp currentHour = DateUtil.getCurrentSixtnTime();
        if (endTime.after(currentHour)) {
            endTime = currentHour;
        }
        return endTime;
    }

    /**
     * 判断时间是否相差24小时以内
     * 
     * @param compTime 比较时间
     * @param stdTime 基准时间
     * @return 是否相差24小时以内
     */
    public static boolean compTZTime(String compTime, String stdTime) {

        boolean result = false;

        long quot = 0;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1 = new Date();
        Date date2 = new Date();
        try {
            date1 = df.parse(compTime);
            date2 = df.parse(stdTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        quot = date1.getTime() - date2.getTime();
        quot = quot / 1000 / 60 / 60 / 24;

        if (quot > -1 && quot < 1) {
            result = true;
        }
        return result;
    }
    
    /**
     * 获取当月的开始时间
     * @return
     */
    public static Timestamp getStartTimeFromThisMonth(){
        
        Calendar calendar = Calendar.getInstance();
        //设置当月的起始时间
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), 1, 0, 0, 0);
        
        return new Timestamp(calendar.getTimeInMillis());
    }
    
    /**
     * 获取指定时间后一年
     * @param startTime
     * @param nYears
     * @return
     */
    public static Date getNYearsAfter(Date startTime, int nYears) {
        Calendar c = Calendar.getInstance();
        c.setTime(startTime);
        c.add(Calendar.YEAR, nYears);
        return c.getTime();
    }
    
    /**
     * 获取当前月份几个月前或后  n>0 往后n个月   n<0  往前n个月
     * @return  yyyy-MM
     */
    public static String getNMonthChange(int n, String formatType) {

        Calendar c = Calendar.getInstance();
        // 过去或将来 n个月
        c.setTime(new Date());
        c.add(Calendar.MONTH, n);      

        return toString(c.getTime(), formatType);
    }
    
    /**
	 * 根据年 月 获取对应的月份 天数
	 * @param year
	 * @param month
	 * @return
	 */
	public static int getDaysByYearMonth(int year, int month) {
		
		Calendar a = Calendar.getInstance();
		a.set(Calendar.YEAR, year);
		a.set(Calendar.MONTH, month - 1);
		a.set(Calendar.DATE, 1);
		a.roll(Calendar.DATE, -1);
		int maxDate = a.get(Calendar.DATE);
		return maxDate;
	}

}
