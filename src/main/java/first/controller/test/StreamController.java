package first.controller.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StreamController {

	public static void main(String[] args) {
		List<Double> list =new ArrayList<Double>();
		list.add(6.1);
		list.add(4.2);
		list.add(7.3);
		list.add(3.4);
		list.add(8.4);
		list.add(2.3);
		list.add(9.2);
		list.add(1.1);
		
	//	list.stream().sorted().forEach(System.out::println);
	//	list.stream().filter((a)->(a>5)).forEach(System.out::println);
	//	boolean f = list.stream().allMatch((a)->(a>0));
	//	System.out.println(f);
	//	long f = list.stream().filter((a)->(a>5)).count();
	//	System.out.println(f);
		Optional<Double> ss = 
				list
				.stream()
				.sorted()
				.reduce((a,b)->a+b);
		ss.ifPresent(System.out::println);
		
		Double dd = list.stream().map((a)->a.doubleValue()).reduce((b,c)->b+c).get();
		System.out.println(dd);
		double ff = list.stream().mapToDouble((a)->a.doubleValue()).sum();
		System.out.println(ff);
		

	}

}
