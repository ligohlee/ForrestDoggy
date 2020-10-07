package forrest.service.sy.room;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import forrest.domain.sy.OptionsDTO;
import forrest.mapper.sy.OptionsMapper;

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
