package first.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import first.model.HospitalInfo;

public interface HospitalDAO {
	
	
	@Select("select a.provicne_name,a.city_name,a.district_name,a.town_name,a.`name`,b.url from base_hospital_info a "
			+ "LEFT JOIN base_pic_info b on a.pic_id=b.id where b.url is not null")
	List<HospitalInfo> getHospitalList();
}
