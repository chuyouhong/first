package first.controller.client;

import java.util.Enumeration;
import java.util.Properties;

/**
 * 通过代理访问internet资源
 */
public class Proxy {

	public static void main(String[] args) {
		String sUrl="http://192.168.10.212:8082/img/31744437-344f-4cf7-82cc-009641fd901e.jpg";
		//获取系统属性集合
		Properties prop=System.getProperties();
		prop.getProperty("http.proxyHost");
//		System.out.println(prop.getProperty("http.proxyHost")+""+prop.getProperty("http.proxyPort"));
		//设置代理服务器地址
		prop.put("http.proxyHost", "192.168.10.212");
		prop.put("http.proxyPort", "8082");
		
		
	}

}
