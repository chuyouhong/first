package first.controller.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class Test01 {

	public static void main(String[] args) throws ParseException {
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime yesterday = today.minusDays(1);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(yesterday.format(dateTimeFormatter));
        LocalDateTime aa=LocalDateTime.parse(yesterday.format(dateTimeFormatter), dateTimeFormatter);
        System.out.println(aa.toString());
		
		String a="2012-02-06 12:30:00";
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		System.out.println(getLastDate(sdf.parse(a)));

	}
	
	public static String getLastDate(Date date){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String d="";
		Calendar cal=Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DATE, cal.get(Calendar.DATE)-1);
		
//		System.out.println(sdf.format(cal.getTime()));
//		cal.set(Calendar.MONTH, (cal.get(Calendar.MONTH)+1));
//		cal.set(Calendar.DATE, 1);
//		cal.set(Calendar.DATE, (cal.get(Calendar.DATE)-1));
		d=sdf.format(cal.getTime());
		return d;
	}

}
