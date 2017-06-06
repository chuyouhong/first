package first.controller.test;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;

import first.service.test.Formula;

public class ComparatorController {

	public static void main(String[] args) throws UnsupportedEncodingException {
		comparatorSort();
		Integer converted1 = converter1.convert("123");
		System.out.println(converted1); // 123

		String s = "http://www.firsthospital.cn/photo/000047丁晓颖.jpg";
		String str="";
		for(int i=0;i<s.length();i++){
			String ch=s.substring(i,i+1 );
			if(ch.matches("[\u4E00-\u9FA5]+")){
				System.out.println(ch);
				str+=URLEncoder.encode(ch, "utf-8");
			}else{
				str+=ch;
			}	
		}
		System.out.println(str);
	}
	public static void comparatorSort() {
		// 老版本的比较器
		List<Integer> names = Arrays.asList(3, 6, 1, 5);
		Collections.sort(names, new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				System.out.println(a.compareTo(b));
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
	
	public static int compareVersion(String ver1, String ver2){
		if (ver1 == null && ver2 == null){
			return 0;
		}
		if (ver1 == null){
			return -1;
		}
		if (ver2 == null){
			return 1;
		}
		return ver1.compareTo(ver2);
	}

	@FunctionalInterface
	interface Converter<F, T> {
		T convert(F from);
	}

	static Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
	Integer converted = converter.convert("123");

	static Converter<String, Integer> converter1 = Integer::valueOf;

}
