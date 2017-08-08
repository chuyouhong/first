package first.controller.client;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownThread implements Runnable{
	
	String url="";
	File file;
	long startPosition;
	long endPosition;
	
	public DownThread(String url,File file,long startPosition,long endPosition){
		this.url=url;
		this.file=file;
		this.startPosition=startPosition;
		this.endPosition=endPosition;
	}
	
	@Override
	public void run() {
		try {
			URL downUrl=new URL(url);
			HttpURLConnection conn=(HttpURLConnection) downUrl.openConnection();
			conn.setRequestProperty("User-agent", "NetFox");
			String sProperty="bytes="+startPosition+"-";
			if(endPosition>0){
				sProperty+=endPosition;
			}
			conn.setRequestProperty("RANGE", sProperty);
			conn.connect();
			RandomAccessFile dst=new RandomAccessFile(file, "rw");
			dst.seek(startPosition);
			InputStream is = conn.getInputStream();
			BufferedInputStream bis=new BufferedInputStream(is);
			byte[] buf=new byte[1024];
			int size=-1;
			while((size=bis.read(buf))!=-1){
				dst.write(buf,0,size);
			}
			dst.close();
			bis.close();
			conn.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("一个线程结束");
	}
}
