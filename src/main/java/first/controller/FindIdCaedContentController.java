package first.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

import org.json.JSONObject;

import com.baidu.aip.ocr.AipOcr;

public class FindIdCaedContentController {

    //设置APPID/AK/SK
    public static final String APP_ID = "10800850";
    public static final String API_KEY = "gdXpcZZNA7ZLZLPUYHGcguw7";
    public static final String SECRET_KEY = "1vyuxfZ4DGkjnk8NkO6hFYq1w2Nu64PU";

    public static void main(String[] args) {
    	
    	//-----------------识别图片中的文字-------------------
    	
        // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);
        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
        System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");

        // 调用接口
        String path = "aaa.jpg";
        JSONObject res = client.basicGeneral(path, new HashMap<String, String>());
        System.out.println(res.toString(2));
        
        //----------------识别身份证图片上的信息-----------------------
        
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("detect_direction", "true");
        options.put("detect_risk", "false");
        
        String idCardSide = "front"; //front：身份证正面；back：身份证背面
        
        // 参数为本地图片路径
        String image = "test.jpg";
        res = client.idcard(image, idCardSide, options);
      //  System.out.println(res.toString(2));

        // 参数为本地图片二进制数组
        byte[] file = getImageBinary(image);
        res = client.idcard(file, idCardSide, options);
     //   System.out.println(res.toString(2));
        
    }
    
    static byte[] getImageBinary(String url) { 
        File f = new File(url); 
        BufferedImage bi; 
        try { 
            bi = ImageIO.read(f); 
            ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
            ImageIO.write(bi, "jpg", baos);  //经测试转换的图片是格式这里就什么格式，否则会失真 
            return baos.toByteArray();
        } catch (IOException e) { 
            e.printStackTrace(); 
        } 
        return null; 
    }
}
