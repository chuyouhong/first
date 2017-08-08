package first.controller.client;
/**
 * 多线程下载
 */
import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;

public class MultiDownload {

	public static void main(String[] args) {
		MultiDownload down = new MultiDownload();
		try {
			long s=System.currentTimeMillis();
			down.downProcess("https://upyun.thedoc.cn/cdn/androidpkg/docpro_v2.3.1.apk", "F:\\docpro_v2.3.1.apk", 3);
			long e=System.currentTimeMillis();
			System.out.println(e-s);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void downProcess(String url, String dest, int threadNum) throws Exception {
		long fileSize = getFileLength(url);
		System.out.println("资源大小："+fileSize/1024);
		long byteCount = fileSize / threadNum + 1;
		File file=new File(dest);
		int i=0;
		while(i<threadNum){
			final long startPosition=byteCount*i;
			final long endPosition=byteCount*(i+1);
			if(i<threadNum){
				DownThread fileThread=new DownThread(url, file, startPosition, 0);
				new Thread(fileThread).start();
			}else{
				DownThread fileThread= new DownThread(url, file, startPosition, endPosition);
				new Thread(fileThread).start();
			}
			i++;
		}
	}

	public long getFileLength(String url) throws Exception {
		long size = -1;
		URL downloadUrl = new URL(url);
		HttpURLConnection conn = (HttpURLConnection) downloadUrl.openConnection();
		int stateCode = conn.getResponseCode();
		if (stateCode == 200) {
			size = conn.getContentLength();
			conn.disconnect();
		}
		return size;
	}
}
