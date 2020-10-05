package forrest.service.backoffice.staypark.room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import forrest.command.backoffice.staypark.OptionsCommand;
import forrest.domain.backoffice.staypark.OptionsDTO;
import forrest.mapper.backoffice.staypark.room.OptionsMapper;

@Service
@Component
public class OptionInsertService {
	
	@Autowired
	OptionsMapper optionsMapper;

	public int insertOpt(OptionsCommand command) {
		// TODO Auto-generated method stub
		
		OptionsDTO dto = new OptionsDTO();
		
		dto.setOptName(command.getOptName());
		dto.setOptPrice(command.getOptPrice());
		
		int i = optionsMapper.insertOpt(dto);
		return i;
		
	}

}
