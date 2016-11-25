package first.controller.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Demo1 {
	
	public static void main(String[] args){
		//老版本的比较器
		List<Integer> names = Arrays.asList(3, 6, 1, 5);
		Collections.sort(names, new Comparator<Integer>() {
		    @Override
		    public int compare(Integer a, Integer b) {
		        return a.compareTo(b);
		    }
		});
		System.out.println(names);
	}
}
