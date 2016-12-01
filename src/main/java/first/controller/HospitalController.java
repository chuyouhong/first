package first.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import first.model.HospitalInfo;
import first.service.HospitalService;
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
			
			SaveImgUtils.download("http://jtys.org/resource/images"+hos.getUrl(), downloadDir,hos.getName());
		}
	}
}
