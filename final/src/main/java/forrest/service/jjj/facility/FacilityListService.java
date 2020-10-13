package forrest.service.jjj.facility;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import forrest.domain.jjj.FacilityDTO;
import forrest.mapper.jjj.FacilityMapper;


@Service
@Component
public class FacilityListService {
	@Autowired
	FacilityMapper facilityMapper;
	
	public void listFacility(Model model) {
		List<FacilityDTO> list = facilityMapper.selectFacilityAll();
		model.addAttribute("list" , list);
	}

}
