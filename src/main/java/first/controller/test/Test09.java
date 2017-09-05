package first.controller.test;

import java.io.UnsupportedEncodingException;
/**
 * 根据编码方式取字符串的字节数
 * @author Administrator
 *
 */
public class Test09 {
	public static void main(String[] args) {
		String a=new String("safsdfds辨识度ds");
		byte[] b;
		try {
			b = a.getBytes("GBK");
			int c = b.length;
			System.out.println(c);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} 

	}
}
