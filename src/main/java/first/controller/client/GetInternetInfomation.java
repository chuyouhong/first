package first.controller.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.StringTokenizer;

/**
 * 解析Internet网页内容
 * 
 * @author Administrator
 *
 */
public class GetInternetInfomation {

	public Collection searchURL(String urlString) {
		URL url2 = null;
		java.net.URLConnection conn = null;
		String nextLine = null;
		StringTokenizer tokenizer = null;
		Collection urlCollection = new ArrayList();
		try {
			url2 = new URL(urlString);
			conn = url2.openConnection();
			conn.connect();

			BufferedReader Reader1 = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			while ((nextLine = Reader1.readLine()) != null) {
				tokenizer = new StringTokenizer(nextLine);
				while (tokenizer.hasMoreTokens()) {
					String urlToken = tokenizer.nextToken();
					if (hasMatch(urlToken)) {
						urlCollection.add(trimURL(urlToken));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return urlCollection;
	}

	private boolean hasMatch(String token) {
		return token.indexOf("http:") != -1;
	}

	private String trimURL(String url) {
		String tempStr = null;
		int beginIndex = url.indexOf("http");
		int endIndex = url.length();
		tempStr = url.substring(beginIndex, endIndex);
		endIndex = tempStr.indexOf(">");
		if (endIndex == -1) {
			endIndex = tempStr.length();
		}
		return tempStr.substring(0, endIndex);
	}

	public static void main(String[] args) {
		GetInternetInfomation info = new GetInternetInfomation();
		Collection urlCollection = info.searchURL("http://www.baidu.com");
		Iterator iter = urlCollection.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}

	}

}
