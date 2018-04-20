package com.skytiger.net.utils;

import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class TimeUtils {
	public static Date stringToDate(Object dateString, String dateFormat) {
		DateFormat df = new SimpleDateFormat(dateFormat);
		Date d = null;
		if (dateString != null && !"".equals(dateString)) {
			try {
				d = df.parse((String) dateString);
			} catch (ParseException e) {
			}
		}
		return d;
	}

	public static String dateToString(Date date, String dateFormat) {
		// DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		DateFormat df = new SimpleDateFormat(dateFormat);
		String d = null;
		if (date != null) {
			d = df.format(date);
		}
		return d;
	}

	public static String getTodayString() {
		GregorianCalendar today = new GregorianCalendar();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String todayString = df.format(today.getTime());

		return todayString;
	}

	public static String getTodayString(String format) {
		GregorianCalendar today = new GregorianCalendar();
		SimpleDateFormat df = new SimpleDateFormat(format);
		String todayString = df.format(today.getTime());

		return todayString;
	}

	public static String getTomorrowString() {
		GregorianCalendar tomorrow = new GregorianCalendar();
		tomorrow.add(Calendar.DAY_OF_MONTH, 1);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String tomorrowStringg = df.format(tomorrow.getTime());

		return tomorrowStringg;
	}

	public static String getYesterdayString() {
		GregorianCalendar yesterday = new GregorianCalendar();
		yesterday.add(Calendar.DAY_OF_MONTH, -1);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		df.setCalendar(yesterday);
		String yesterdayString = df.format(yesterday.getTime());

		return yesterdayString;
	}

	public static String getPrevMonthString(Date oneday) {
		Calendar calendar = java.util.Calendar.getInstance();
		calendar.setTime(oneday);
		calendar.set(Calendar.MONDAY, calendar.get(Calendar.MONDAY) - 1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		return sdf.format(calendar.getTime());
	}

	/**
	 * 指定时间 天 向前 或 向后 平移
	 * 
	 * @param date
	 * @param dayNum
	 * @return
	 */
	public static Date setDateDay(Date date, int dayNum) {
		GregorianCalendar now = new GregorianCalendar();
		now.setTime(date);
		now.add(GregorianCalendar.DATE, dayNum);
		return now.getTime();
	}

	/**
	 * 指定时间 分钟 向前 或 向后 平移
	 * 
	 * @param date
	 * @param dayNum
	 * @return
	 */
	public static Date setDateMinute(Date date, int minute) {
		GregorianCalendar now = new GregorianCalendar();
		now.setTime(date);
		now.add(GregorianCalendar.MINUTE, minute);
		return now.getTime();
	}

	/**
	 * 指定时间 月 向前 或 向后 平移
	 * 
	 * @param date
	 * @param dayNum
	 * @return
	 */
	public static Date setDateMonth(Date date, int MonthNum) {
		GregorianCalendar now = new GregorianCalendar();
		now.setTime(date);
		now.add(GregorianCalendar.MONTH, MonthNum);
		return now.getTime();
	}
	
	/**
	 * 指定时间 年 向前 或 向后 平移
	 * 
	 * @param date
	 * @param dayNum
	 * @return
	 */
	public static Date setDateYear(Date date, int num) {
		GregorianCalendar now = new GregorianCalendar();
		now.setTime(date);
		now.add(GregorianCalendar.YEAR, num);
		return now.getTime();
	}

	// 不管时分秒
	public static int nDaysBetweenTwoDate(Date firstDate, Date secondDate) {
		int nDay = (int) ((stringToDate(dateToString(secondDate, "yyyy-MM-dd"), "yyyy-MM-dd").getTime() - stringToDate(dateToString(firstDate, "yyyy-MM-dd"), "yyyy-MM-dd").getTime()) / (24 * 60 * 60 * 1000));
		return nDay;
	}

	/**
	 * 指定时间 秒 向前 或 向后 平移
	 * 
	 * @param date
	 * @param dayNum
	 * @return
	 */
	public static Date setDateSecond(Date date, int Second) {
		GregorianCalendar now = new GregorianCalendar();
		now.setTime(date);
		now.add(GregorianCalendar.SECOND, Second);
		return now.getTime();
	}

	/**
	 * 计算两个时间的工作日天数
	 * 
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static int isWeekend(String startDate, String endDate) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date now = df.parse(startDate);
		Date date = df.parse(endDate);
		int i;
		if (now.getDay() == 1 || now.getDay() == 2 || now.getDay() == 3 || now.getDay() == 4 || now.getDay() == 5) {
			i = 1;
		} else {
			i = 0;
		}

		int subdate = (int) ((date.getTime() - now.getTime()) / (24 * 60 * 60 * 1000));
		for (int j = 0; j < subdate; j++) {
			now = TimeUtils.setDateDay(now, 1);
			if (now.getDay() == 1 || now.getDay() == 2 || now.getDay() == 3 || now.getDay() == 4 || now.getDay() == 5) {
				i++;
			}// 判断是不是双休日
		}
		return i;

	}

	/**
	 * 获取该日期是周几
	 * 
	 * @param date
	 * @return
	 */
	public static int getWeekDay(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.DAY_OF_WEEK) - 1;
	}

	public static Date getTraningDate() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		int week = TimeUtils.getWeekDay(cal.getTime());
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		switch (week) {
			case 1:
			case 3:
			case 5:
				cal.add(Calendar.DAY_OF_MONTH, 1);
				break;
			case 2:
			case 4:
				if (hour >= 14) {
					cal.add(Calendar.DAY_OF_MONTH, 2);
				}
				break;
			case 6:
				if (hour >= 14) {
					cal.add(Calendar.DAY_OF_MONTH, 3);
				}
				break;
			case 0:
				cal.add(Calendar.DAY_OF_MONTH, 2);
			default:
				break;
		}
		cal.set(Calendar.HOUR_OF_DAY, 14);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		return cal.getTime();
	}

	/**
	 * 指定时间 小时 向前 或 向后 平移
	 * 
	 * @param date
	 * @param dayNum
	 * @return
	 */
	public static Date setDateHour(Date date, int hours) {
		GregorianCalendar now = new GregorianCalendar();
		now.setTime(date);
		now.add(GregorianCalendar.HOUR_OF_DAY, hours);
		return now.getTime();
	}

	/**
	 * 得到北京时间
	 * 
	 * @param date
	 * @param dayNum
	 * @return
	 * @throws Exception
	 */
	public static Date getBeijinTime() throws Exception {
		TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
		URL url = new URL("http://www.ntsc.ac.cn/");// 取得资源对象
		URLConnection uc = url.openConnection();// 生成连接对象
		uc.connect(); // 发出连接
		long ld = uc.getDate(); // 取得网站日期时间
		Date date = new Date(ld); // 转换为标准时间对象

		return date;
	}

	public static void main(String[] args) throws Exception {
		Date date = TimeUtils.stringToDate("2016-09-04 00:00:00", "yyyy-MM-dd");
		System.out.println(TimeUtils.nDaysBetweenTwoDate(date,new Date()));
	}
}
