package first.controller.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;

public final class TestList {

	public static void main(String[] args) {
		LinkedList<String> linklist=new LinkedList<String>();
		linklist.add("asda1");
		linklist.add("asda3");
		linklist.add("fasdf1");
		linklist.add("asda2");
		System.out.println(linklist.size());
		
		ArrayList<String> arrayList = new ArrayList<String>();
		
		arrayList.add("asda1");
		arrayList.add("ddddddd");
		//arrayList.remove(1);
		System.err.println(arrayList.size());
		arrayList.add("asda3");
		arrayList.add("asda43");
		arrayList.add("fasdf1");
		arrayList.add("asda2");
		System.out.println(arrayList.size());
		
		HashSet<String> hashSet = new HashSet<String>();
		int a =(int) ((arrayList.size() / 0.75F) + 1);// Math.max((int)(arrayList.size() / 0.75F) + 1, 16);
		System.out.println(a);
		hashSet.add("asda1");
		hashSet.remove("asda1");
		hashSet.add("asda3");
		hashSet.add("fasdf1");
		hashSet.add("asda2");
		System.out.println(hashSet.size());
		
		HashMap<String,String> hashMap = new HashMap<String,String>();
		hashMap.put("1", "afa1");
		hashMap.put("2", "afa2");
		hashMap.put("3", "afa3");
		hashMap.put("4", "afa4");
		System.out.println(hashMap.size());
		
		Hashtable<String,String> hashTable = new Hashtable<String,String>();
		hashTable.put("1", "afa1");
		hashTable.put("2", "afa2");
		hashTable.put("3", "afa3");
		hashTable.put("4", "afa4");
		System.out.println(hashTable.size());
	}

}
