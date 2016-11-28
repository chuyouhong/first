package first.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class SaveImgUtils {
	
	/**
	 * 下载文件到本地
	 *
	 * @param urlString
	 *            被下载的文件地址
	 * @param filename
	 *            本地文件名
	 * @throws Exception
	 *             各种异常
	 */
	public static void download(String urlString, String downloadDir,String filename) throws Exception {
		// 构造URL
		URL url = new URL(urlString);
		// 打开连接
		URLConnection con = url.openConnection();
		// 输入流
		InputStream is = con.getInputStream();
		// 1K的数据缓冲
		byte[] bs = new byte[1024];
		// 读取到的数据长度
		int len;
		// 输出的文件流
		
	    System.out.println("Start to save photo.");  
	    
	    File downloadFilePath = new File(downloadDir);  
	    if(downloadFilePath.exists() == false)              // 如果该目录不存在,则创建之  
	         downloadFilePath.mkdirs();  
	      
	    filename = downloadDir+"/"+filename+".jpg";      //生成新的照片名  
	    System.out.println(filename); 
		
		OutputStream os = new FileOutputStream(filename);
		// 开始读取
		while ((len = is.read(bs)) != -1) {
			os.write(bs, 0, len);
		}
		// 完毕，关闭所有链接
		os.close();
		is.close();
	}

}
