package first.controller.test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class StreamThreadController {
	
	public static void main(String[] agrs){
		int max=1000000;
		List<String> list =new ArrayList<>(max);
		long aa=System.nanoTime();
		long aaa=System.currentTimeMillis();	
		for(int i=0;i<max;i++){
			UUID uuid=UUID.randomUUID();
			list.add(uuid.toString());
		}
		long bb = System.nanoTime();
		long bbb = System.currentTimeMillis();
		System.out.println(bb-aa);
		System.out.println(bbb-aaa);
		//串行stream 在单线程中执行
		long x = list.stream().sorted().count();
		long cc = System.nanoTime();
		System.out.println(cc-bb);
		long milli = TimeUnit.NANOSECONDS.toMillis(cc - bb);
		System.out.println(String.format("sequential sort took: %d ms", milli));
		
		//并行 stream 在多线程中执行
		long xx = list.parallelStream().sorted().count();
		long dd = System.nanoTime();
		long millis = TimeUnit.NANOSECONDS.toMillis(dd - cc);
		System.out.println(String.format("sequential sort took: %d ms", millis));
		
	}
}
