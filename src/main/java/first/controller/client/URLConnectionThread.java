package first.controller.client;
/**
 * 实现internet资源的单线程下载
 */
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
public class URLConnectionThread {
	public static void main(String[] args) {
		try {
			URL url=new URL("file:///F:/ri.gif");
			URLConnection conn=url.openConnection();
			conn.connect();
			InputStream is = conn.getInputStream();
			int len=conn.getContentLength();
			System.out.println("图片大小："+(double)len/1024+"kb");
			System.out.println("图片名称："+url.getFile().substring(url.getFile().lastIndexOf('/')+1));
			FileOutputStream fos=new FileOutputStream("F:\\ri_bak.gif");
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
