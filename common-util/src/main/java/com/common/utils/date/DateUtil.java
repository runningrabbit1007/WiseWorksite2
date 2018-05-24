package com.common.utils.date;

import android.annotation.SuppressLint;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


@SuppressLint("SimpleDateFormat")
public class DateUtil {

	private static SimpleDateFormat dataFormart;

	public static SimpleDateFormat getSimpleDateFormat(String DATE_PATTERN) {
		dataFormart = new SimpleDateFormat(DATE_PATTERN);
		return dataFormart;
	}

	public static String getCurrentTime(String DATE_PATTERN) {
		dataFormart = new SimpleDateFormat(DATE_PATTERN);
		return dataFormart.format(new Date());
	}

	public static String getCurrentTime(String DATE_PATTERN, long lastTime) {
		if (lastTime == -1L){
			return dataFormart.format(new Date());
		}
		dataFormart = new SimpleDateFormat(DATE_PATTERN);
		return dataFormart.format(lastTime);
	}

	/**
	 * Will (on day month year) -- > (year - month - day) date format
	 */
	public static String dateTransform(String dateData) {
		String year = dateData.substring(0, dateData.indexOf("年"));
		String month = dateData.substring(dateData.indexOf("年") + 1,
				dateData.indexOf("月"));
		String day = dateData.substring(dateData.indexOf("月") + 1,
				dateData.indexOf("日"));
		return year + "-" + month + "-" + day;
	}

	public static String getAssignTime(String DATE_PATTERN, long time) {
		dataFormart = new SimpleDateFormat(DATE_PATTERN);
		return dataFormart.format(time);
	}

	/**
	 * Formatting a long time value (the current time)
	 * 
	 * @return
	 */
	@SuppressLint("SimpleDateFormat")
	public static String getCurrentTimeText(final long systemCurrentTime) {
		if (systemCurrentTime == 0) {
			return "";
		}
		return getCurrentTime("yyyy-MM-dd HH:mm:ss");
	}

	public static long TimeStrToLong(String timeStr, String timeStrFormat) {
		// 处理小时
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(timeStrFormat);
		Date date = null;
		try {
			date = simpleDateFormat.parse(timeStr);
		} catch (ParseException e) {
			e.printStackTrace();
			return 0;
		}
		return date.getTime();
	}

	/**
	 * 得到当前日期
	 * @return
	 */
	public static ItemDate getCurrentDay() {
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		int day = calendar.get(Calendar.DATE);
		return new ItemDate(year, month, day);
	}
	
	/**
	 * 自定义的一个日期类
	 */
	public static class ItemDate {
		private int year;
		private int month;
		private int day;

		public ItemDate() {
		}

		public ItemDate(int year, int month, int day) {
			this.year = year;
			this.month = month;
			this.day = day;
		}

		public int getYear() {
			return year;
		}

		public void setYear(int year) {
			this.year = year;
		}

		public int getMonth() {
			return month;
		}

		public void setMonth(int month) {
			this.month = month;
		}

		public int getDay() {
			return day;
		}

		public void setDay(int day) {
			this.day = day;
		}

		public String toString() {
			return this.year + "年" + this.month + "月" + this.day + "日";
		}

		public boolean equals(ItemDate itemDate) {
			return this.year == itemDate.getYear()
					&& this.month == itemDate.getMonth()
					&& this.day == itemDate.getDay();
		}
	}
	
	/**
	 * 根据当前年月获取天数
	 */
	public static int getDaysByMonth(int year,int month){
		int[] monDays = new int[] {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		if ( ( (year) % 4 == 0 && (year) % 100 != 0) ||(year) % 400 == 0) 
		        monDays[2]++;
		return monDays[month];
	}




	public static String getDateTimeStamp(Date pDate){

		Date lDate = new Date(1991,03,16,8,6,53);

		try {

			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String currentDateTime = dateFormat.format(lDate);

			return currentDateTime;
		} catch (Exception e) {
			e.printStackTrace();

			return null;
		}
	}

	public static String getDateStrToday(Date pDate){
		try {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(pDate);
			String days = (calendar.get(Calendar.MONTH) + 1) + "月" + calendar.get(Calendar.DAY_OF_MONTH) + "日";
			return days;
		} catch (Exception pE) {
			pE.printStackTrace();
		}
		return "";
	}
	public static String getDateStrToday(long timeStamp){
		try {
			Date pDate = new Date(timeStamp);
			return getDateStrToday(pDate);
		} catch (Exception pE) {
			pE.printStackTrace();
		}
		return "";
	}





	public static String getDateStrToMin(long pTimeStamp){
		try {
			Date lDate = new Date(pTimeStamp);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(lDate);
			return calendar.get(Calendar.YEAR) + "年" + (calendar.get(Calendar.MONTH) + 1) + "月" + calendar.get(Calendar.DAY_OF_MONTH) + "日 " + calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE);
		} catch (Exception pE) {
			pE.printStackTrace();
		}
		return "";
	}


	public static String getDateStrToYMDH(long pTimeStamp){
		try {
			Date lDate = new Date(pTimeStamp);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(lDate);
			return calendar.get(Calendar.YEAR) + "年" + (calendar.get(Calendar.MONTH) + 1) + "月" + calendar.get(Calendar.DAY_OF_MONTH) + "日";
		} catch (Exception pE) {
			pE.printStackTrace();
		}
		return "";
	}

	/**
	 * 样式：2016.5.4
	 *
	 * @param pTimeStamp
	 * @return
	 */
	public static String getDateStrToYMD2(long pTimeStamp) {
		try {
			Date lDate = new Date(pTimeStamp);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(lDate);
			return calendar.get(Calendar.YEAR) + "." + (calendar.get(Calendar.MONTH) + 1) + "." + calendar.get(Calendar.DAY_OF_MONTH);
		} catch (Exception pE) {
			pE.printStackTrace();
		}
		return "";
	}
}
