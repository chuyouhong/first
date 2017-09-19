package first.controller.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

import sun.misc.Queue;

public final class TestList {

	public static void main(String[] args) throws Exception {
		
		/**
		 * LinkedList 链表结构，增删快，改查慢
		 * ArrayList 数组结构，增删慢，改查快
		 */
		LinkedList<String> linklist = new LinkedList<String>() {
			{
				add("asda1");
				add("asda3");
			}
		};
		 linklist.add("asda13");
		 linklist.add("asda34");
		 linklist.add("fasdf12");
		 linklist.add("asda2t");
		System.out.println(linklist.size());

		ArrayList<String> arrayList = new ArrayList<String>();// size为10

		arrayList.add("asda1");
		arrayList.add("ddddddd");
		// arrayList.remove(1);
		System.err.println(arrayList.size());
		arrayList.add("asda3");
		arrayList.add("asda43");
		arrayList.add("fasdf1");
		arrayList.add("asda2");
		System.out.println(arrayList.size());

		/**
		 * hashSet中有一个hashMap对象，保存在hashSet中的元素，都保存到hashMap中的Key中，故hset保存的数据是无重复的
		 */
		HashSet<String> hashSet = new HashSet<String>();
		int a = (int) ((arrayList.size() / 0.75F) + 1);// Math.max((int)(arrayList.size()
														// / 0.75F) + 1, 16);
		System.out.println(a);
		hashSet.add("asda1");
		hashSet.remove("asda1");
		hashSet.add("asda3");
		hashSet.add("fasdf1");
		hashSet.add("asda2");
		System.out.println(hashSet.size());

		/**
		 * HashMap 非线性安全的，key,value允许为null,先进先出
		 * Hashtable 线性安全的，key,value均不可为null，先进后出
		 */
		HashMap<String, String> hashMap = new HashMap<String, String>();
		int ii;
		hashMap.put("1", "afa1");
		System.out.println("---hashcade-1---"+((ii = "1".hashCode()) ^ ii >>> 16));
		hashMap.put("2", "afa2");
		System.out.println("---hashcade-1---"+((ii = "2".hashCode()) ^ ii >>> 16));
		hashMap.put("f", null);
		System.out.println("---hashcade-1---"+((ii = "f".hashCode()) ^ ii >>> 16));
		hashMap.put("3", "afa22");
		System.out.println("---hashcade-1---"+((ii = "3".hashCode()) ^ ii >>> 16));
		hashMap.put("23", "afa22");
		System.out.println("---hashcade-1---"+((ii = "23".hashCode()) ^ ii >>> 16));
		System.out.println(hashMap.get("23"));
		hashMap.put("24", "afa22");
		hashMap.put("25", "afa22");
		hashMap.put("26", "afa22");
		hashMap.put("27", "afa22");
		hashMap.put("28", "afa22");
		hashMap.put("29", "afa22");
		hashMap.put("230", "afa22");
		hashMap.put("247", "afa22");
		hashMap.put("255", "afa22");
		hashMap.put("263", "afa22");
		hashMap.put("272", "afa22");
		hashMap.put("281", "afa22");
		hashMap.put("293", "afa22");
		// hashMap.remove("2");
		hashMap.put("3", "afa3");
		hashMap.put("4", "afa4");
		Map<String, String> map = Collections.synchronizedMap(hashMap);
		System.out.println(map.size());

		/**
		 * 创建时初始容量大小为11
		 */
		Hashtable<String, String> hashTable = new Hashtable<String, String>();
		hashTable.put("1", "afa11");
		hashTable.put("22", "afa22");
		hashTable.put("23", "afa22");
		hashTable.put("24", "afa22");
		hashTable.put("25", "afa22");
		hashTable.put("26", "afa22");
		hashTable.put("27", "afa22");
		hashTable.put("28", "afa22");
		hashTable.put("29", "afa22");
		hashTable.put("20", "afa22");
		hashTable.put("3", "afa33");
		hashTable.put("4", "afa44");
		System.out.println(hashTable.size());
		
		ConcurrentHashMap<String, String> chmap = new ConcurrentHashMap<String,String>(); 
		chmap.get("");
		
		// Stack 先进后出
		Stack<Integer> s = new Stack<Integer>();

		for (int i = 0; i <= 10; i++){
			System.out.println(i);
		s.push(i);//入栈
		}
		while (s.size() > 0){
			System.out.println(s.pop());//出栈
		} 
		
		// Queue 先进先出
		Queue<String> q = new Queue<String>();

		for (int i = 0; i <= 10; i++){
			System.out.println(i);
		q.enqueue("q"+i);//入栈
		}
		while (!q.isEmpty()){
			System.out.println("q"+q.dequeue());//出栈
		} 

	}
}
