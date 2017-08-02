package first.controller.client;
/**
 * 实现internet资源的单线程下载
 */
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
public class URLConnection {
	public static void main(String[] args) {
		try {
			URL url=new URL("http://192.168.10.212:8082/img/31744437-344f-4cf7-82cc-009641fd901e.jpg");
			java.net.URLConnection conn=url.openConnection();
			conn.connect();
			InputStream is = conn.getInputStream();
			System.out.println(is.read());
			int len=conn.getContentLength();
			System.out.println("图片大小："+(double)len/1024+"kb");
			System.out.println("图片名称："+url.getFile().substring(url.getFile().lastIndexOf('/')+1));
			FileOutputStream fos=new FileOutputStream("F:\\tupian.jpg");
			byte[] buf=new byte[1024];
			int size=-1;
			while((size=is.read(buf))!=-1){
				fos.write(buf, 0, size);
				fos.flush();
			}
			fos.close();
			is.close();
			conn.connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
