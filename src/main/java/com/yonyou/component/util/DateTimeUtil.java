package com.yonyou.component.util;

import java.security.InvalidParameterException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

/**
 * DateTime Util.
 * 
 * @version 1.0.0
 * @author kuzhuxuan
 */
public class DateTimeUtil {

	public static int YEAR = 0;
	public static int MONTH = 1;
	public static int WEEK = 2;
	public static int DAY = 3;
	public static int HOUR = 4;
	public static int MINUTE = 5;
	public static int SECOND = 6;

	/**
	 * Return current datetime string.
	 * 
	 * @return current datetime, pattern: "yyyy-MM-dd HH:mm:ss".
	 */
	public static String getDateTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dt = sdf.format(new Date());
		return dt;
	}	

	/**
	 * �����������
	 * @author snowing
	 * @time2017.6.21
	 * @return
	 */
	public static int getDifferentdays(Date fromDate,Date toDate) {
		if(fromDate==null||toDate==null){
			return 0;
		}
		long from = fromDate.getTime();  
		long to = toDate.getTime();  
		int days = (int) ((to - from)/(1000 * 60 * 60 * 24));
		return days;  
	}
	
	
	/**
	 * ��ȡ��ǰʱ���ʽΪyyyy-MM-dd ���ַ���
	 * @return
	 */
	public static String getCurrentStringDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dt = sdf.format(new Date());
		return dt;
	}
	/**
	 * ��ȡ��ǰʱ���ʽΪyyyy-MM-dd ����
	 * @return
	 */
	public static Date getCurrentDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dt = sdf.format(new Date());
		Date d=null;
		try {
			d=sdf.parse(dt);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d;
	}
	
	//����2017-05-09 15:09:48.807
	public static Timestamp getDateTimestamp() {
		 java.sql.Timestamp   dateTime   =   new   java.sql.Timestamp(new Date().getTime());//sql����  
		return dateTime;
	}
	 //����2017-05-09
	 public static Date getDate() {
		java.sql.Date   date   =   new   java.sql.Date(new Date().getTime());//sql����  
		return date;
	}
	
	
	public static Timestamp getTimestamp() {
		Timestamp dt = new Timestamp(System.currentTimeMillis());
		return dt;
	}
	
	/**
	 * �Զ������ڸ�ʽ�����ص�ǰʱ��
	 * 
	 * @param pattern
	 *            format pattern
	 * @return current datetime
	 */
	public static String getDateTime(String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String dt = sdf.format(new Date());
		return dt;
	}
	/**
	 * ����תstring
	 * 
	 * @param date
	 *            java.util.Date
	 * @return short format datetime
	 */
	public static String shortFmt3(Date date) {
		if(date==null){
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
		}
	/**
	 *��ȡ��ǰ����
	 * 
	 */
	public static String getNowDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(new Date());
		}

	/**
	 * ����תstring
	 * 
	 * @param date
	 *            java.util.Date
	 * @return short format datetime
	 */
	public static String shortFmt(Date date) {
		if(date==null){
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return sdf.format(date);
	}
	/**
	 * ����תstring
	 * 
	 * @param date
	 *            java.util.Date
	 * @return short format datetime
	 */
	public static String shortFmt2(Date date) {
		if(date==null){
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}

	/**
	 * �Զ������ڸ�ʽ��������ת��string
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static String parse(Date date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}

	/**
	 * String ���͵�����ת��������
	 * 
	 * @param param
	 *            datetime string, pattern: "yyyy-MM-dd HH:mm:ss".
	 * @return java.util.Date
	 */
	public static Date parse(String param) {
		Date date = null;
		DateFormat sdf = DateFormat.getDateInstance();
		if (param.trim().indexOf("") != -1) {
			sdf = DateFormat.getDateTimeInstance();
		}
		else{
			return null;
		}
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date = sdf.parse(param);
		} catch (ParseException ex) {
			ex.printStackTrace();
		}
		return date;
	}
	/**
	 * 2010/10/10 ת���� 2010-10-10
	 * 
	 * @param param
	 * @return java.util.Date
	 */
	public static String parseDateString(String param) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			param=sdf.format(sdf.parse(param));
		} catch (ParseException e) {
			SimpleDateFormat sdf2= new SimpleDateFormat("yyyy/MM/dd");
			try {
				param=sdf.format(sdf2.parse(param));
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		}
		return param;
	}

	/**
	 * ͨ�����ڻ�ȡ��ǰ������
	 * 
	 * @param date
	 * @return
	 */
	public static int getWeek(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int week = calendar.get(Calendar.DAY_OF_WEEK);
		return week;
	}

	/**
	 * �жϵ�ǰ�����Ƿ�Ϊ����
	 * 
	 * @param date
	 * @return
	 */
	public static boolean isWeekend(Date date) {
		int week = getWeek(date);
		if (week == Calendar.SATURDAY || week == Calendar.SUNDAY) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * ��ȡ��������֮�����������
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws InvalidParameterException
	 */
	public static Date[] getDate(Date startDate, Date endDate)
			throws InvalidParameterException {
		Date[] dateList = null;
		if (startDate.compareTo(endDate) > 0) {
			throw new InvalidParameterException("��ʼ���ڲ����ڽ�������֮��");
		}
		long startTime = startDate.getTime();
		long endTime = endDate.getTime();
		int interval = (int) ((endTime - startTime) / (24 * 60 * 60 * 1000));// 获取相差天数
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(startDate);
		Date currentDate = null;
		dateList = new Date[interval];
		for (int i = 0; i < interval; i++) {
			currentDate = calendar.getTime();
			dateList[i] = currentDate;
			calendar.add(Calendar.DATE, 1);

		}
		return dateList;
	}

	/**
	 * �жϽ��������Ƿ���ڿ�ʼ����
	 * 
	 * @param enddate
	 * @param newStartDate
	 * @return boolean 
	 */
	public static boolean checkDateInterval(Date enddate, Date newStartDate) {
		return enddate.after(newStartDate);
	}

	/**
	 * ��ȡ��������֮����������
	 * 
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public static int getDayBetween(Date beginDate, Date endDate) {
		long minSecond = (endDate.getTime() - beginDate.getTime())/ (1000 * 60 * 60 * 24);
		return (int) minSecond;
	}

	/**
	 * �����е������ռӼ������µ�����
	 * 
	 * @param date
	 * @param value
	 * @param type
	 * @return Date 
	 */
	public static Date getDate(Date date, int value, int type) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int tempValue = 0;
		Date newDate = null;
		switch (type) {
		case 0:
			tempValue = calendar.get(Calendar.YEAR);
			calendar.set(Calendar.YEAR, tempValue + value);
			newDate = new Date(calendar.getTimeInMillis());
			return newDate;
		case 1:
			tempValue = calendar.get(Calendar.MONTH);
			calendar.set(Calendar.MONTH, tempValue + value);
			newDate = new Date(calendar.getTimeInMillis());
			return newDate;
		case 2:
			tempValue = calendar.get(Calendar.WEEK_OF_YEAR);
			calendar.set(Calendar.WEEK_OF_YEAR, tempValue + value);
			newDate = new Date(calendar.getTimeInMillis());
			return newDate;
		case 3:
			tempValue = calendar.get(Calendar.DAY_OF_YEAR);
			calendar.set(Calendar.DAY_OF_YEAR, tempValue + value);
			newDate = new Date(calendar.getTimeInMillis());
			return newDate;
		case 4:
			tempValue = calendar.get(Calendar.HOUR_OF_DAY);
			calendar.set(Calendar.HOUR_OF_DAY, tempValue + value);
			newDate = new Date(calendar.getTimeInMillis());
			return newDate;
		case 5:
			tempValue = calendar.get(Calendar.MINUTE);
			calendar.set(Calendar.MINUTE, tempValue + value);
			newDate = new Date(calendar.getTimeInMillis());
			return newDate;
		case 6:
			tempValue = calendar.get(Calendar.SECOND);
			calendar.set(Calendar.SECOND, tempValue + value);
			newDate = new Date(calendar.getTimeInMillis());
			return newDate;
		}
		return date;
	}

	 /**
	  * �ַ���ʱ���ʽ����������
	  * @param oldTime
	  * @param newTime
	  * @return
	  * @throws ParseException
	  */
	  public static int computeDays(String smallTime,String bigTime) throws ParseException{  
	        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
	        Calendar calendar = Calendar.getInstance();    
	        calendar.setTime(sdf.parse(smallTime));    
	        long time1 = calendar.getTimeInMillis();                 
	        calendar.setTime(sdf.parse(bigTime));    
	        long time2 = calendar.getTimeInMillis();         
	        long between_days=(time2-time1)/(1000*3600*24);  
	       return Integer.parseInt(String.valueOf(between_days));     
	    } 
	  /**
	  * �ַ���ת��������
	  * @param str
	  * @return date
	  */
	  public static Date StrToDate(String str) {
		  Date date = null;
	    if(StringUtils.isEmpty(str)){
	    	return date;
	    }
	     SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	     try {
	      date = format.parse(str);
	     } catch (ParseException e) {
	      e.printStackTrace();
	     }
	     return date;
	  }
	  /**
		  * �ַ���ת��������
		  * @param str
		  * @return date
		  */
		  public static Date StrToDateTime(String str) {
			  Date date = null;
		    if(StringUtils.isEmpty(str)){
		    	return date;
		    }
		     SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		     try {
		      date = format.parse(str);
		     } catch (ParseException e) {
		      e.printStackTrace();
		     }
		     return date;
		  }
	public static void main(String[] args) {
		// System.out.println(parse("2005/12/12"));
		
		System.out.println(DateTimeUtil.parse("yyyy-MM-dd HH:mm").toGMTString());

//		Date date1 = DateTimeUtil.parse("2017-05-15");
//		Date date2 = DateTimeUtil.parse("2006-01-02");
//		System.out.println(DateTimeUtil.checkDateInterval(date1, date2));
//		System.out.println(DateTimeUtil.getCurrentStringDate());
//		System.out.println(DateTimeUtil.getCurrentDate());
//		System.out.println(DateTimeUtil.getDayBetween(date1,DateTimeUtil.getCurrentDate()));
		// Date newDate= getDate(date2,200,DateTimeUtil.DAY);
		// System.out.println(shortFmt(newDate)+" 新时�?);
		// System.out.println(CheckDateInterval(date1,date2));
		// System.out.println( DateTimeUtil.getDate(new
		// Date(),-30,DateTimeUtil.DAY));
		// int distance = (int)((date2.getTime() -
		// date1.getTime())/1000/60/60/24);
		// //天转化成毫��
		// long time=100*24*60*60*1000;
		// long oldTime=date2.getTime();
		// long newTime=oldTime+time;
		// Date newDate= new Date(newTime);
		// System.out.println(shortFmt(date2)+" 旧时�?);
		// System.out.println(shortFmt(newDate)+" 新时�?);

		// Calendar calendar = new GregorianCalendar();
		// calendar.setTime(date2);
		// int day = calendar.get(Calendar.DAY_OF_YEAR);
		// calendar.set(Calendar.DAY_OF_YEAR, day - 10000);
		// long time=calendar.getTimeInMillis();
		// Date newDate= new Date(time);
		// System.out.println(shortFmt(newDate)+" 新时�?);

		// date2.getTime();
		// System.out.println(distance);
		// Calendar calendar = Calendar.getInstance();
		// calendar.setTime(new Date());
		// System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
		// Date startDate = calendar.getTime();
		// System.out.println(DateTimeUtil.isWeekend(startDate));
		// calendar.add(Calendar.DATE, 1);
		// Date endDate = calendar.getTime();
		// Date[] days = DateTimeUtil.getDate(startDate, endDate);
		// for (int i = 0; i < days.length; i++) {
		// System.out.println(DateTimeUtil.parse(days[i],
		// "yyyy-MM-dd HH:mm:ss"));
		// }
	}
	/**
	 * ���յ�ǰ���ڲ�ѯ���ܵ�һ��
	 */
	public  static String getWeekStartDate(){
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY); 
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		Date date = cal.getTime();
		SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dt = sdf.format(date);
		return dt;
		}
	/**
	 * ���յ�ǰ���ڲ�ѯ���µ�һ��
	 */
	public static  String getMonthStartDate(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 Calendar c = Calendar.getInstance();    
		      c.add(Calendar.MONTH, 0);
		      c.set(Calendar.HOUR_OF_DAY, 0);
		      c.set(Calendar.MINUTE, 0);
		      c.set(Calendar.SECOND, 0);
		      c.set(Calendar.DAY_OF_MONTH,1);//����Ϊ1��,��ǰ���ڼ�Ϊ���µ�һ�� 
		      String first = sdf.format(c.getTime());
		return first;

		}
	
}
