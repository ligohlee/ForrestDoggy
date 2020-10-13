package forrest.service.jjj.facility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import forrest.domain.jjj.FacilityDTO;
import forrest.mapper.jjj.FacilityMapper;

@Service
@Component
public class FacilityDetailService {
	@Autowired
	FacilityMapper mapper;
	public void selectFacility(int facilityNum, Model model) {
		FacilityDTO facilityNum1 = new FacilityDTO();
		facilityNum1.setFacilityNum(facilityNum);
		FacilityDTO dto = mapper.selectFacility(facilityNum1);
		model.addAttribute("facility",dto);
	}

}
