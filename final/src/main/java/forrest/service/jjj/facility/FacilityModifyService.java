package forrest.service.jjj.facility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import forrest.command.jjj.FacilityCommand;
import forrest.domain.jjj.FacilityDTO;
import forrest.mapper.jjj.FacilityMapper;

@Service
@Component
public class FacilityModifyService {
	@Autowired
	FacilityMapper facMapper;
	public void modifyFacility(int facNum, FacilityCommand facCommand) {
		FacilityDTO fac = new FacilityDTO();
		
		fac.setFacName(facCommand.getFacName());
		fac.setFacInfo(facCommand.getFacInfo());
		facMapper.updateFacility(fac);
		
	}

}
