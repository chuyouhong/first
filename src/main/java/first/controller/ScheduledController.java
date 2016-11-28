package first.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class ScheduledController {
	
//	@Scheduled(fixedDelay = 1000 * 2) 可执行的定时器
//	@Scheduled(cron = "0 0 2 * * ?")   没有执行
//	@Scheduled(fixedDelay = 1000 * 3)
	public void times() throws ParseException{
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

		if(new Date().after(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2016-11-25 11:03:00"))){
			System.out.println("time is up");
		}
	}

}
