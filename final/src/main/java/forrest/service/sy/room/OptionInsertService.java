package forrest.service.sy.room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import forrest.command.sy.room.OptionsCommand;
import forrest.domain.sy.room.OptionsDTO;
import forrest.mapper.sy.room.OptionsMapper;


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
