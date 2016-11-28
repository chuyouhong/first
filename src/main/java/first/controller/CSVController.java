package first.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import first.utils.CSVUtils;
/**
List<String> dataList=CSVUtils.importCsv(new File("D:/test/ljq.csv"));
if(dataList!=null && !dataList.isEmpty()){
    for(String data : dataList){
        System.out.println(data);
    }
}
*/

public class CSVController {

	public static void main(String[] args) {
		String date=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        List<String> dataList=new ArrayList<String>();
        dataList.add(",1,张三,,1,,,,男");
        dataList.add(",2,李四,,,2,,,男");
        dataList.add(",3,小红,,,,3,,女");
        dataList.add(",4,小红,,,,,4,男");
        boolean isSuccess=CSVUtils.exportCsv(new File("D:/test/备份医生数据"+date+".csv"), dataList);
        System.out.println(isSuccess);
		
//		List<String> dataList=Utils.importCsv(new File("D:/test/备份医生数据2016-10-28.csv"));
//		if(dataList!=null && !dataList.isEmpty()){
//		    for(String data : dataList){
//		    //	if(dataList.get(0).equals(data))continue;
//		    	String[] arr=data.split(",");
//		    	System.out.println(arr[2]);
//		    }
//		}
	}
}
