package first.controller.test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Date;

public class Test14 {

	public static void main(String[] args) {
		String str="Hello, welcome to LifeWow!\nThis is an automatic response sent when you registering an email address on LifeWow to verify that the email is valid.\nYour verification code:%s, valid for 30 mins. Please do not provide it to anyone.";
		String s=String.format(str, "111111");
		System.out.println(s);
		
		String a="abcdefg";
		StringBuffer sb1=new StringBuffer();
		sb1.append(a);
		System.out.println(sb1.reverse());
		

		long en = 1526572800000l; //1526619600000

		long sta = 1526456670000l;

		long avg = en - sta;
		System.out.println(avg);
		long day = avg/(1000*60*60*24);
		long hour = avg%(1000*60*60*24)/(1000*60*60);
		long min = avg%(1000*60*60)/(1000*60);
		long sec = avg%(1000*60)/(1000);
		System.out.println(day+"天"+hour+"时"+min+"分"+sec+"秒");

		StringBuilder sb = new StringBuilder();
		PrintStream printStream = null;
		try {
			printStream = new PrintStream(new FileOutputStream("report.html"));// 路径默认在项目根目录下
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>测试报告的样式</title>");
		sb.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");
		// 样式内容
		sb.append("<style type=\"text/css\">");
		sb.append(".tablename table th {background:#8FBC8F}");
		sb.append(".tablename table tr{ background:#FAEBD7;text-align:center}");
		sb.append("</style></head>");
		// 样式结尾
		// 主体部分一个div
		sb.append("<div class=\"tablename\">");
		// 一个table
		sb.append(
				"<table width=\"500\"  height=\"100\" border=\"1\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;\">");
		sb.append("<th>用例集/测试方法</th><th>总计</th><th>通过</th><th>失败</th><th>通过率</th><th>详细</th><tr>");

		sb.append("<td>test集合</td><td>10</td><td>8</td><td>2</td><td>80%</td> <td>点我查看详情</td></tr>");

		sb.append("<th>测试方法</th><th>测试项</th><th>测试模块</th><th>测试描述</th><th>验证点</th>");
		sb.append("<tr><td>" + 12333 + "</td><td>变量2</td><td>变量3</td><td>变量4</td><td>变量5</td>");
		sb.append("</tr></table>");
		// table与html结尾
		sb.append("</div></body></html>");

		printStream.println(sb.toString());
	}

}
