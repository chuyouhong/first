package first.controller.test;

import java.io.UnsupportedEncodingException;

public class Test {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String s = reverse("abcghj");
		System.out.println(s);
	}

    public static String reverse(String originStr) {
        if(originStr == null || originStr.length() <= 1) 
            return originStr;
        String t=reverse(originStr.substring(1)) + originStr.charAt(0);
        return t;
    }
}
