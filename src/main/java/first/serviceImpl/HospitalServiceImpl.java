package first.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import first.dao.HospitalDAO;
import first.model.HospitalInfo;
import first.service.HospitalService;
@Component
public class HospitalServiceImpl implements HospitalService{

	@Autowired
	HospitalDAO hospitalDAO;
	
	@Override
	public List<HospitalInfo> getHospitalList() {
		return hospitalDAO.getHospitalList();
	}

}
