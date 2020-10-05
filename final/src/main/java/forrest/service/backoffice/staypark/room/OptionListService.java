package forrest.service.backoffice.staypark.room;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import forrest.domain.backoffice.staypark.OptionsDTO;
import forrest.mapper.backoffice.staypark.room.OptionsMapper;

@Service
@Component
public class OptionListService {
	
	@Autowired
	OptionsMapper optionsMapper;
	
	public void listOpt(Model model) {
		// TODO Auto-generated method stub
		
		List<OptionsDTO> list = optionsMapper.selectOpt();
		model.addAttribute("optList", list);
		
		
	}

}
