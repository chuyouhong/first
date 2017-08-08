package first.controller.client;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Internet资源下载的断点续传
 */
public class DownLoad {
	private long start = 0;
	private long end = 0;

	public DownLoad(long start, long end) {
		this.start = start;
		this.end = end;
	}

	public DownLoad(long start) {
		this.start = start;
	}

	public void down() {
		try {
			URL url = new URL("http://192.168.10.212:8082/img/31744437-344f-4cf7-82cc-009641fd901e.jpg");
			URLConnection conn = url.openConnection();
			// 设置请求的RANGE和User-agent参数
			conn.setRequestProperty("User-agent", "NetFox");
			String sProperty = "byte=" + start + "-";
			// 如果知道结束位置>0，设置结束位置，否则默认到文件结尾
			if (end > 0) {
				sProperty = "byte=" + start + "-" + end;
			}
			conn.setRequestProperty("RANGE", sProperty);
			System.out.println(conn.getContentLength());
			conn.connect();
			InputStream is = conn.getInputStream();
			// 讲文件下载到F盘
			String file = url.getFile();
			String name = file.substring(file.lastIndexOf('/') + 1);
			System.out.println(name);
			// 以追加的方式写文件
			FileOutputStream fos = new FileOutputStream("F:\\" + name, true);
			byte[] buf = new byte[1024];
			int size = -1;
			while ((size = is.read(buf)) != -1) {
				fos.write(buf, 0, size);
			}
			fos.close();
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		DownLoad dl = new DownLoad(1000, 2000);
		dl.down();

		DownLoad d2 = new DownLoad(2000,3000);
		d2.down();
	}
}
