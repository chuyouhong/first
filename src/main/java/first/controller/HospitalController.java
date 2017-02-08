package first.controller;

import java.io.File;
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
			SaveImgUtils.download(arr[0],"D:/test/医生头像", arr[1]);
		}
	}
	
	public static void main(String[] args) {
		upLoad();
	}
	
	public static void upLoad() {
		String path = "D:/test/医生头像";
		String names = "";
		try {
			File f = new File(path);
			if (f.isDirectory()) {
				File[] fList = f.listFiles();
				for (int j = 0; j < fList.length; j++) {
					File file = fList[j];
					if (file.isFile()) {
						names += file.getName();
					}
					String weburl="http://media.thedoc.cn/upload/img/?type=\"医生头像\"&suffix=\".jpg\"&file="+file;
				}
				System.out.println(names);
			}
		} catch (Exception e) {
		}
	}
}
