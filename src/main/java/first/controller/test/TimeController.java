package first.controller.test;

import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class TimeController {

	public static void main(String[] args) {
		Date date=new Date();
		//是否为本月最后一天
		boolean istrue=isLastDayOfMonth(date);

		Clock clock = Clock.systemDefaultZone();
		long millis = clock.millis();
		long s = System.currentTimeMillis();
		Instant instant = clock.instant();
		Date legacyDate = Date.from(instant); // legacy java.util.Date
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(legacyDate));

		System.out.println(ZoneId.getAvailableZoneIds());
		// prints all available timezone ids

		ZoneId zone1 = ZoneId.of("Europe/Berlin");
		ZoneId zone2 = ZoneId.of("Brazil/East");
		System.out.println(zone1.getRules());
		System.out.println(zone2.getRules());

		// ZoneRules[currentStandardOffset=+01:00]
		// ZoneRules[currentStandardOffset=-03:00]

		LocalTime now1 = LocalTime.now(zone1);
		LocalTime now2 = LocalTime.now(zone2);

		System.out.println(now1.isBefore(now2)); // false

		long hoursBetween = ChronoUnit.HOURS.between(now1, now2);
		long minutesBetween = ChronoUnit.MINUTES.between(now1, now2);

		System.out.println(hoursBetween); // -3
		System.out.println(minutesBetween); // -239

		LocalTime late = LocalTime.of(23, 59, 59);
		System.out.println(late); // 23:59:59

		DateTimeFormatter germanFormatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)
				.withLocale(Locale.GERMAN);

		LocalTime leetTime = LocalTime.parse("13:37", germanFormatter);
		System.out.println(leetTime); // 13:37

		LocalDate today = LocalDate.now();
		LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
		LocalDate yesterday = tomorrow.minusDays(2);

		LocalDate independenceDay = LocalDate.of(2016, Month.DECEMBER, 1);
		DayOfWeek dayOfWeek = independenceDay.getDayOfWeek();

		DateTimeFormatter germanFormatter1 = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)
				.withLocale(Locale.GERMAN);

		LocalDate xmas = LocalDate.parse("24.12.2014", germanFormatter1);
		System.out.println(xmas); // 2014-12-24

		LocalDateTime sylvester = LocalDateTime.of(2014, Month.DECEMBER, 31, 23, 59, 59);

		DayOfWeek dayOfWeek1 = sylvester.getDayOfWeek();
		System.out.println(dayOfWeek1); // WEDNESDAY

		Month month = sylvester.getMonth();
		System.out.println(month); // DECEMBER

		long minuteOfDay = sylvester.getLong(ChronoField.MINUTE_OF_DAY);
		System.out.println(minuteOfDay); // 1439
		
		Instant instant1 = sylvester
		        .atZone(ZoneId.systemDefault())
		        .toInstant();

		Date legacyDate1 = Date.from(instant1);
		System.out.println(legacyDate1);     // Wed Dec 31 23:59:59 CET 2014
		
		
	}
	
	public static boolean isLastDayOfMonth(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DATE, (calendar.get(Calendar.DATE) + 1));
        if (calendar.get(Calendar.DAY_OF_MONTH) == 1) {
            return true;
        }
        return false;
    } 
}
