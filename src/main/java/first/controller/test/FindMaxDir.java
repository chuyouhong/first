package first.controller.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FindMaxDir {
	public static void main(String[] args) {
		File maxFile = null;
		long maxFileLen = 0;
		File file = new File("D:/workspace");
		if (file.exists()) {
			File[] arrFile = file.listFiles();
			for (File fl : arrFile) {
				String name = fl.getName();
				long size = getTotalSize(fl);
				System.out.println(name + ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + size);
				if (size >= maxFileLen) {
					maxFile = fl;
					maxFileLen = size;
				}
			}
//			System.out.println("MaxFileName" + maxFile.getName() + ";MaxFileLength:" + maxFileLen);
		}
	}

	public static long getTotalSize(File file) {
		long size = 0;
		if (file.exists()) {
			if (file.isDirectory()) {
//				System.out.println("DIRECTORY_NAME:"+file.getName());
				File[] child = file.listFiles();
				if (null != child && child.length > 0) {
					for (File ch : child) {
						size += getTotalSize(ch);
					}
				}
			} else {
			//	System.out.println("FILE_NAME:"+file.getName());
				size = file.length();
			}
		}
		return size;
	}

}
