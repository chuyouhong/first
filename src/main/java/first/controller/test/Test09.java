package first.controller.test;

import java.io.UnsupportedEncodingException;
/**
 * 根据编码方式取字符串的字节数
 * @author Administrator
 *
 */
public class Test09 {
	public static void main(String[] args) {
		String str="abc";
		
		System.out.println(str.getBytes());
		System.out.println(str.getBytes());
		String a=new String("sfsdfds162辨识度ds");
		byte[] b;
		try {
			b = a.getBytes("utf-8");
			int c = b.length;
			System.out.println(c);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} 
        Integer aa = new Integer(3);
        Integer bb = 3;                  
        int cc = 3;
        System.out.println(aa.equals(bb));//T     
        System.out.println(aa.equals(cc));//F 
        System.out.println(bb.equals(cc));//F 
//        Integer f1 = 100, f2 = 100, f3 = 150, f4 = 150;
//
//        System.out.println(f1 == f2);
//        System.out.println(f3 == f4);
        
        String s1 = new StringBuilder("go").append("od").toString();
        	System.out.println(s1.intern() == s1);
        String s2 = new StringBuilder("ja").append("va").toString();
        	System.out.println(s2.intern() == s2);
        	System.out.println(s2.equals("java"));

	}
}
