package first.controller.test;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class Test {
	public static void main(String[] args) throws UnsupportedEncodingException {
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
	}

    public static String reverse(String originStr) {
        if(originStr == null || originStr.length() <= 1) 
            return originStr;
        String t=reverse(originStr.substring(1)) + originStr.charAt(0);
        return t;
    }
}
