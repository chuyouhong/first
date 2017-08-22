package first.controller.test;

import java.util.LinkedList;

public final class TestList {

	public static void main(String[] args) {
		LinkedList<String> list=new LinkedList<String>();
		list.add("asda1");
		list.add("asda3");
		list.add("fasdf1");
		list.add("asda2");
		System.out.println(list.size());
		
		System.out.println(list.get(3));
		list.add("aada1");
		System.out.println(list.get(3));
	}

}
