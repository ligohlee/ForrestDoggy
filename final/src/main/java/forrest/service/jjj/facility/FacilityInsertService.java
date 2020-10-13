package forrest.service.jjj.facility;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import forrest.command.jjj.FacilityCommand;
import forrest.domain.jjj.FacilityDTO;
import forrest.mapper.jjj.FacilityMapper;

@Service
@Component
public class FacilityInsertService {
	
	@Autowired
	FacilityMapper facilityMapper;
	
	public void insertFacility(FacilityCommand command){
		
		FacilityDTO dto = new FacilityDTO();
		
		

		facilityMapper.insertFacility(dto);
		
		
		
	}

}
