package first.model;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;

import sun.misc.BASE64Encoder;

public class Test {
	
	public static void main(String[] args) throws ParseException, IOException {

		System.out.println(GetImageStr());
	}
    public static String GetImageStr() throws IOException {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
        byte[] data = null;
        String imgFilePath="C:\\Users\\Administrator\\Pictures\\a.png";
        // 读取图片字节数组
        try {
            InputStream in = new FileInputStream(imgFilePath);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();

        FileWriter fw = new FileWriter("D:/Test.txt");
        String s = encoder.encode(data);
        fw.write(s, 0, s.length());
        fw.flush();
        return s;// 返回Base64编码过的字节数组字符串
    }
}
