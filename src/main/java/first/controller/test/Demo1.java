package first.controller.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import first.service.test.Formula;

public class Demo1 {

	public static void main(String[] args) {
		comparatorSort();
		Integer converted1 = converter1.convert("123");
		System.out.println(converted1);   // 123
	}

	public static void comparatorSort() {
		// 老版本的比较器
		List<Integer> names = Arrays.asList(3, 6, 1, 5);
		Collections.sort(names, new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				return a.compareTo(b);
			}
		});
		System.out.println(names);
		Collections.sort(names, (a, b) -> b.compareTo(a));
		System.out.println(names);
		Formula formula = new Formula() {
			@Override
			public double calculate(int a) {
				// TODO Auto-generated method stub
				return sqrt(a * 100);
			}
		};
		System.out.println(formula.calculate(16));
		System.out.println(formula.sqrt(16));
	}

	
	@FunctionalInterface
	interface Converter<F, T> {
		T convert(F from);
	}
	static Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
	Integer converted = converter.convert("123");
	
	static Converter<String, Integer> converter1 = Integer::valueOf;

}
