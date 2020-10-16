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
	FacilityMapper facilityMapper;
	
	public void detailFacility(int facNum, Model model) {
		FacilityDTO fac = new FacilityDTO();
		fac.setFacNum(facNum);
		FacilityDTO dto = facilityMapper.selectFacility(fac);
		System.out.println(dto.getFacNum());
		model.addAttribute("facility",dto);
	
		
	}


}
