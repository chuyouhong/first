package first.controller.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test16 {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.HOUR_OF_DAY, 3);
		Date endDate = dft.parse(dft.format(cal.getTime()));
		
		System.out.println(endDate);
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
	}

	public static int getTimeZone() {
		Calendar cal = Calendar.getInstance();
		int offset = cal.get(Calendar.ZONE_OFFSET);
		cal.add(Calendar.MILLISECOND, -offset);
		Long timeStampUTC = cal.getTimeInMillis();
		Long timeStamp = System.currentTimeMillis();
		Long timeZone = (timeStamp - timeStampUTC) / (1000 * 3600);
		return timeZone.intValue();
	}

}
