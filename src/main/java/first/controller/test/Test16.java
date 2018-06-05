package first.controller.test;

import java.util.Calendar;

public class Test16 {

	public static void main(String[] args) {
		System.out.println(getTimeZone());
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
