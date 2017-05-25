package first.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import first.utils.CSVUtils;

/**
 * 
 * @author <a href="mailto:just_szl@hotmail.com"> Geray</a>
 * @version 1.0,2012-6-12
 */
public class HttpPostArgumentTest2 {

	// file1与file2在同一个文件夹下 filepath是该文件夹指定的路径
	public Map<String,String> SubmitPost(String url, String filename1, String filepath) {

		HttpClient httpclient = new DefaultHttpClient();
		String bb=null;
		try {

			HttpPost httppost = new HttpPost(url);

			FileBody bin = new FileBody(new File(filepath + File.separator + filename1));

			StringBody comment = new StringBody(filename1);

			MultipartEntity reqEntity = new MultipartEntity();

			reqEntity.addPart("file", bin);// file1为请求后台的File upload;属性
		//	reqEntity.addPart("type", comment);// filename1为请求后台的普通参数;属性
			httppost.setEntity(reqEntity);

			HttpResponse response = httpclient.execute(httppost);

			int statusCode = response.getStatusLine().getStatusCode();
			
			if (statusCode == HttpStatus.SC_OK) {

				System.out.println("服务器正常响应.....");

				HttpEntity resEntity = response.getEntity();

			//	System.out.println(EntityUtils.toString(resEntity));// httpclient自带的工具类读取返回数据

			//	System.out.println(resEntity.getContent());

				String a = EntityUtils.toString(resEntity);
//				String aa = a.split("\"")[7];
//				System.out.println(aa);
				EntityUtils.consume(resEntity);
				JSONObject json=null;
				json = new JSONObject(a); 
				bb=json.optJSONObject("data").getString("url");
				bb=bb.replaceAll("media", "upyun");
				System.out.println(bb);
			}

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				httpclient.getConnectionManager().shutdown();
			} catch (Exception ignore) {

			}
		}
		Map<String,String> map=new HashMap<>();
		map.put("id", filename1.replaceAll(".jpg", ""));
		map.put("url", bb);
		return map;
	}

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		List<String> dataList=new ArrayList<String>();
		// TODO Auto-generated method stub
		String path = "D:/test/专科医生头像";
		String date=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		HttpPostArgumentTest2 httpPostArgumentTest2 = new HttpPostArgumentTest2();
		File f = new File(path);
		if (f.isDirectory()) {
			File[] fList = f.listFiles();
			for (int j = 0; j < fList.length; j++) {
				File file = fList[j];
				if (file.isFile()) {//http://media.thedoc.cn/upload/img/
					Map<String, String> map = httpPostArgumentTest2.SubmitPost("http://media.thedoc.cn/upload/img/?type=医生头像&suffix=jpg&file=", file.getName(), path);
					//String s="update geo_hospital set photo='"+map.get("url")+"' where id="+map.get("id")+";";
					String s=map.get("url")+","+map.get("id");
					dataList.add(s);
				}
			}
		}
		CSVUtils.exportCsv(new File("D:/test/专科医生头像"+date+".csv"), dataList);
	}

}
