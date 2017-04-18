package com.bibinet.finance.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

	public static String datetimeFormatter(Date date) {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date);
	}

	public static String datetimeFormatter0(Date date) {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
	}

	public static String dateFormatter(Date date) {
		return new SimpleDateFormat("yyyy-MM-dd").format(date);
	}

	public static String timeFormatter(Date date) {
		return new SimpleDateFormat("HH:mm:ss").format(date);
	}

	public static String getCurrentDatetime() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());
	}

	public static String getCurrentDatetime0() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}

	public static String getCurrentDate() {
		return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	}

	public static String getCurrentTime() {
		return new SimpleDateFormat("HH:mm:ss").format(new Date());
	}

	/**
	 * 
	 * @param dateStr
	 *            yyyy-MM-dd
	 * @return Date
	 * @throws ParseException
	 */
	public static Date parseDate(String dateStr) throws ParseException {
		return new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
	}

	/**
	 * 
	 * @param dateStr
	 *            yyyy-MM
	 * @return Date
	 * @throws ParseException
	 */
	public static Date parseFirstDate(String dateStr) throws ParseException {
		return new SimpleDateFormat("yyyy-MM-dd").parse(dateStr + "-01");
	}

	/**
	 * ��ȡ����(�������ڼ�)
	 * 
	 * @return 1�������ա�2������һ��3�����ڶ���4����������5�������ġ�6�������塢7��������
	 */
	public static int getWeek(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.DAY_OF_WEEK);
	}

	/**
	 * ȡ��ĳ�����ж�����
	 */
	public static int getDaysOfMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	/**
	 * ȡ���ϸ����ж�����
	 */
	public static int getDaysOfLastMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, -1);
		return cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	/**
	 * ���켸��
	 */
	public static int getDayOfMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 
	 * �·ݱȽ�
	 * 
	 * @param date1
	 * @param date2
	 * @return if(date1 > date2) return 1; if(date1 < date2) return -1; if(date1
	 *         = date2) return 0;
	 */
	public static int compareMonth(Date date1, Date date2) {
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date1);
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(date2);

		if (cal1.get(Calendar.YEAR) > cal2.get(Calendar.YEAR)) {
			return 1;
		} else if (cal1.get(Calendar.YEAR) < cal2.get(Calendar.YEAR)) {
			return -1;
		} else {
			if (cal1.get(Calendar.MONTH) > cal2.get(Calendar.MONTH)) {
				return 1;
			} else if (cal1.get(Calendar.MONTH) < cal2.get(Calendar.MONTH)) {
				return -1;
			} else {
				return 0;
			}
		}
	}

	/**
	 * 
	 * �ܱȽ�
	 * 
	 * @param date1
	 * @param date2
	 * @return if(date1 > date2) return 1; if(date1 < date2) return -1; if(date1
	 *         = date2) return 0;
	 */
	public static int compareWeek(Date date1, Date date2) {
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date1);
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(date2);

		if (cal1.get(Calendar.YEAR) > cal2.get(Calendar.YEAR)) {
			return 1;
		} else if (cal1.get(Calendar.YEAR) < cal2.get(Calendar.YEAR)) {
			return -1;
		} else {
			if (cal1.get(Calendar.WEEK_OF_YEAR) > cal2.get(Calendar.WEEK_OF_YEAR)) {
				return 1;
			} else if (cal1.get(Calendar.WEEK_OF_YEAR) < cal2.get(Calendar.WEEK_OF_YEAR)) {
				return -1;
			} else {
				return 0;
			}
		}
	}

	/**
	 * �����ǵڼ���
	 */
	public static int getWeekOfYear(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.WEEK_OF_YEAR);
	}

	/**
	 * ����:+-
	 */
	public static Date dateOperation(Date date, int ndays) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_YEAR, ndays);
		return cal.getTime();
	}
}
