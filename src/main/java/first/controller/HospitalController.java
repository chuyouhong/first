package first.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import first.model.HospitalInfo;
import first.service.HospitalService;
import first.utils.CSVUtils;
import first.utils.SaveImgUtils;

@Controller
public class HospitalController {
	
	@Autowired
	HospitalService HospitalService;
	
	@RequestMapping(value = "/saveImg/", method = RequestMethod.GET)
	public void get() throws Exception {

		List<HospitalInfo> list=HospitalService.getHospitalList();
		
		for(HospitalInfo hos:list){
			String downloadDir ="F:/医院图片/"+hos.getProvicne_name()+"/"+hos.getCity_name()+"/"+hos.getDistrict_name()+"/"+hos.getTown_name();
			
			SaveImgUtils.download("http://jtys.org/resource/images"+hos.getUrl(), downloadDir,hos.getName()+".jpg");
		}
	}
	
	
	@RequestMapping(value = "/saveImg1/", method = RequestMethod.GET)
	public void get1() throws Exception {

		List<String> dataList=CSVUtils.importCsv(new File("D:/test/医+医生url.csv"));
		
		for(String s:dataList){
			String[] arr=s.split(",");
			SaveImgUtils.download(getB(arr[0]),"D:/test/专科医生头像", arr[1]+".jpg");
		}
	}
	
	public String getB(String s) throws UnsupportedEncodingException{
		String str="";
		for(int i=0;i<s.length();i++){
			String ch=s.substring(i,i+1 );
			if(ch.matches("[\u4E00-\u9FA5]+")){
				System.out.println(ch);
				str+=URLEncoder.encode(ch, "utf-8");
			}else{
				str+=ch;
			}	
		}
		return str;
	}
}
