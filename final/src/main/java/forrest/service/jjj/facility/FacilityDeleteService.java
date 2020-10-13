package forrest.service.jjj.facility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import forrest.mapper.jjj.FacilityMapper;

@Service
@Component

public class FacilityDeleteService {
	@Autowired
	FacilityMapper mapper;
	public void deleteFacility(int facilityNum) {
		
		mapper.deleteFacility(facilityNum);
	}
	
}
