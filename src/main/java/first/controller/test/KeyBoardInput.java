package first.controller.test;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
/**
 * 获取
 * @author Administrator
 *
 */
public class KeyBoardInput {

	public static void main(String[] args) {
		//System.in 接受键盘input的值
		//第一种
//		InputStream in = System.in;
//		InputStreamReader isr = new InputStreamReader(in);
//		BufferedReader br = new BufferedReader(isr);
//		try {
//			String readin = br.readLine();
//			if (!StringUtils.isEmpty(readin)) {
//				PrintStream a = System.out;
//				PrintStream e = System.err;
//				e.println("e"+readin);
//				a.println(readin);
//				System.out.println("Read KeyBoard in :" + readin);
//			}
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		//第二种
//		Scanner sc=new Scanner(System.in);
//		String s=sc.nextLine();
//		System.out.println(s);
//		String s1=sc.next();
//		System.out.println(s1);
//		int s2=sc.nextInt();
//		System.out.println(s2);
		System.out.println(Thread.currentThread().getContextClassLoader().getResource(""));
		System.out.println(Test.class.getClassLoader().getResource(""));
		System.out.println(ClassLoader.getSystemResource(""));
		System.out.println(Test.class.getResource(""));
		System.out.println(Test.class.getResource("/"));
		System.out.println(new File("").getAbsolutePath());
		System.out.println(System.getProperty("user.dir"));
		
		Runtime rt=Runtime.getRuntime();
		try {
			rt.exec("C:\\Program Files (x86)\\Tencent\\QQ\\Bin\\QQ.exe");
			rt.exec("notepad.exe");
			rt.exec("cmd /c\"F:\\tupian.jpg\"");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error exec AnyQ");
		}
		
	}

}
