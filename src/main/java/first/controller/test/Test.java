package first.controller.test;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

public class Test {
	private static DecimalFormat decimalFormat = new DecimalFormat("0.00");
	
	public static void main(String[] args) throws Exception {
		
		Class<?> clz = Class.forName("first.model.Item");
		Constructor<?> con = clz.getConstructor();
		Object obj = con.newInstance();
		Method method = clz.getMethod("setGender", String.class);
		Object aaa = method.invoke(obj, "男");
		System.out.println(aaa);
		Method method1 = clz.getMethod("getGender",null);
		Object bbb = method1.invoke(obj, null);
		System.out.println(bbb);
		
		
		ArrayList<Integer> lis=new ArrayList();
		Object[] ar=new Object[10];
		ar[0]=1;
		ar[1]="2";
		ar[3]=4.0;
		System.out.println(ar);
		ConcurrentHashMap<String, String> cmap =new ConcurrentHashMap();
		cmap.put("", "value");
		cmap.get("");
		cmap.size();
		TreeMap tm=new TreeMap();
		tm.put("", "value");
		HashMap hm=new HashMap();
		hm.put("", "value");
		HashSet hs=new HashSet();
		hs.add("");
		List<Integer> al=new ArrayList();
		al.add(11);
		Integer[] iarr=new Integer[10];
		iarr[0]=8;
		//al =Arrays.asList(iarr);
		al.toArray(iarr);
		System.out.println(iarr.toString());
		System.out.println(decimalFormat.format(477.636));
		System.out.println(decimalFormat.format(45677.632));
		System.out.println(decimalFormat.format(545677.632));
		String aa="001";
		System.out.println(Integer.valueOf(aa));
		Map<String,String> map=new HashMap<String,String>();
		map.put("aaa", null);
		map.put(null, "1");
		map.put(null, null);
		String a = map.get(null);
		String b = map.get("aaa");
		String s = reverse("abcghj");
		boolean c=map.containsKey("a");
		boolean d=map.containsKey("aaa");
		boolean e=map.containsKey(null);
		System.out.println(s);
		
		//java 二叉树
		Integer[] arr={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21};
		BinTree tree = new BinTree();
		tree.CreateTree(arr);
		tree.preOrder(tree.getRoot());
	}

    public static String reverse(String originStr) {
        if(originStr == null || originStr.length() <= 1) 
            return originStr;
        String t=reverse(originStr.substring(1)) + originStr.charAt(0);
        return t;
    }
}
